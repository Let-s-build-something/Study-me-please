package study.me.please.ui.collection.detail.questions.detail

import androidx.lifecycle.viewModelScope
import com.squadris.squadris.compose.base.BaseViewModel
import com.squadris.squadris.utils.RefreshableViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import study.me.please.base.GeneralClipBoard
import study.me.please.data.io.QuestionAnswerIO
import study.me.please.data.io.QuestionIO
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

    /** collection identifier */
    var collectionUid: String = ""

    override suspend fun onDataRequest(isSpecial: Boolean, isPullRefresh: Boolean) {
        (repository.getQuestionByUid(questionUid) ?: QuestionIO(uid = questionUid)).let { questionDetail ->
            dataManager.questionDetail.value = questionDetail
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
            dataManager.questionDetail.value = question
            requestQuestionSave(question)
            repository.updateFirebaseQuestion(
                collectionUid = collectionUid,
                question = question
            )
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
                )?.also {
                    updateQuestion(it)
                }
            }
        }
    }

    /** creates a new answer */
    fun addNewAnswer(answer: QuestionAnswerIO) {
        viewModelScope.launch {
            dataManager.questionDetail.update { previousQuestion ->
                previousQuestion?.copy(
                    answers = previousQuestion.answers.apply {
                        add(0, answer)
                    }
                )
            }
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
                )?.also {
                    updateQuestion(it)
                }
            }
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