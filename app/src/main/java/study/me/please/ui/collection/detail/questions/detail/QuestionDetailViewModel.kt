package study.me.please.ui.collection.detail.questions.detail

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import study.me.please.base.BaseViewModel
import study.me.please.base.GeneralClipBoard
import study.me.please.data.io.QuestionAnswerIO
import study.me.please.data.io.QuestionIO
import study.me.please.ui.collection.RefreshableViewModel
import study.me.please.ui.components.collapsing_layout.CollapsingLayoutState
import javax.inject.Inject

@HiltViewModel
class QuestionDetailViewModel @Inject constructor(
    private val repository: QuestionDetailRepository,
    private val dataManager: QuestionDetailDataManager,
    val clipBoard: GeneralClipBoard
): BaseViewModel(), RefreshableViewModel {

    override val isRefreshing: MutableStateFlow<Boolean> = MutableStateFlow(false)
    override var lastRefreshTimeMillis: Long = 0L

    /** Detail of received collection from database */
    var questionDetail = dataManager.questionDetail.asStateFlow()

    /** currently displayed question identifier */
    var questionUid: String = ""

    /** state for scrollable collapsing layout above everything else */
    val collapsingLayoutState = CollapsingLayoutState()

    override fun requestData(isSpecial: Boolean, isPullRefresh: Boolean) {
        viewModelScope.launch {
            if(isPullRefresh) setRefreshing(true)
            (repository.getQuestionByUid(questionUid) ?: QuestionIO(uid = questionUid)).let { questionDetail ->
                dataManager.questionDetail.value = questionDetail
            }
            if(isPullRefresh) setRefreshing(false)
        }
    }

    /** Requests for a question data save */
    private suspend fun requestQuestionSave(question: QuestionIO? = null) {
        (question ?: dataManager.questionDetail.value)?.let {
            repository.saveQuestion(it)
        }
    }

    /** Requests for a question data save */
    fun updateQuestion(question: QuestionIO) {
        viewModelScope.launch {
            dataManager.questionDetail.update {
                question
            }
            requestQuestionSave(question)
        }
    }

    /** Requests for a removal of answers */
    fun requestAnswersDeletion(uidList: Set<String>) {
        viewModelScope.launch {
            dataManager.questionDetail.update { previousQuestion ->
                previousQuestion?.copy(
                    answers = previousQuestion.answers.apply {
                        removeAll { uidList.contains(it.uid) }
                    }
                )
            }

            requestQuestionSave()
        }
    }

    /** Updates answer with new information */
    fun updateAnswer(answer: QuestionAnswerIO) {
        viewModelScope.launch {
            dataManager.questionDetail.update { previousQuestion ->
                previousQuestion?.copy(
                    answers = previousQuestion.answers.apply {
                        find { it.uid == answer.uid }?.updateTO(answer)
                    }
                )
            }
            requestQuestionSave()
        }
    }

    /** Pastes previously copied answers */
    fun pasteAnswers() {
        viewModelScope.launch {
            dataManager.questionDetail.update { previousQuestion ->
                previousQuestion?.copy(
                    answers = previousQuestion.answers.apply {
                        addAll(0, clipBoard.answers.paste())
                    }
                )
            }
            requestQuestionSave()
        }
    }
}