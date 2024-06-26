package study.me.please.ui.collection.detail

import androidx.lifecycle.viewModelScope
import com.squadris.squadris.utils.DateUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.squadris.squadris.compose.base.BaseViewModel
import study.me.please.base.GeneralClipBoard
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.FactIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.shared.SharedDataManager
import com.squadris.squadris.utils.RefreshableViewModel
import study.me.please.ui.collection.detail.questions.QuestionsFilter
import study.me.please.ui.collection.detail.questions.SortByType
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class CollectionDetailViewModel @Inject constructor(
    private val repository: CollectionDetailRepository,
    private val dataManager: CollectionDetailDataManager,
    private val sharedDataManager: SharedDataManager,
    val clipBoard: GeneralClipBoard
): BaseViewModel(), RefreshableViewModel {

    override val isRefreshing: MutableStateFlow<Boolean> = MutableStateFlow(false)
    override var lastRefreshTimeMillis: Long = 0L

    /** Detail of received collection from database */
    var collectionDetail = dataManager.collectionDetail.asStateFlow()

    /** filter for questions */
    val questionsFilter: MutableStateFlow<QuestionsFilter> = MutableStateFlow(QuestionsFilter())

    /** local temporary save of downloaded questions */
    var collectionQuestions = dataManager.collectionQuestions.combine(questionsFilter) { collections, filter ->
        withContext(Dispatchers.Default) {
            collections.filter { question ->
                (filter.text.isEmpty() || (question.prompt.lowercase().contains(filter.text.lowercase())
                            || question.textExplanation.lowercase().contains(filter.text.lowercase()))
                            || question.promptList.any { it.lowercase().contains(filter.text.lowercase()) })
                        && (filter.isInvalid.not() || (question.answers.any { it.isCorrect }.not() || question.isSeriousDataPoint().not()))
                        && (filter.hasImage.not() || (question.imagePromptUrl?.isEmpty == false
                            || question.imageExplanationUrl?.isEmpty == false
                            || question.answers.any { answer -> answer.imageExplanation?.isEmpty == false }))
            }.sortedWith(
                if(filter.sortBy == SortByType.DATE_CREATED_ASC) {
                    compareBy { it.dateCreated }
                }else compareByDescending { it.dateCreated }
            )
        }
    }

    /** currently displayed collection identifier */
    var collectionUid: String = ""

    override suspend fun onDataRequest(isSpecial: Boolean, isPullRefresh: Boolean) {
        repository.getCollectionByUid(collectionUid)?.let { collectionDetail ->
            dataManager.collectionDetail.value = collectionDetail
            requestCachedQuestions(questionUidList = collectionDetail.questionUidList.toList())
        }
    }

    /** Requests for a collection data save */
    fun requestCollectionSave(collection: CollectionIO) {
        viewModelScope.launch(Dispatchers.Default) {
            if(collection.isNotEmpty) {
                repository.saveCollection(
                    collection = collection.apply {
                        dateModified = DateUtils.now.timeInMillis
                        if(collection.dateCreated == null) dateCreated = DateUtils.now.timeInMillis
                    },
                    userUid = sharedDataManager.currentUser.value?.uid
                )
            }
        }
    }

    private fun requestCachedQuestions(questionUidList: List<String>) {
        viewModelScope.launch {
            dataManager.collectionQuestions.value = repository.getQuestionsByUid(
                questionUidList
            ).orEmpty().also { newList ->
                if(newList.isNotEmpty()
                    && newList.size != dataManager.collectionDetail.value?.questionUidList?.size
                ) {
                    dataManager.collectionDetail.value?.questionUidList = newList.map { it.uid }.toMutableList()
                }
            }
        }
    }

    /** Requests for a question data save */
    private fun requestQuestionSave(question: QuestionIO) {
        viewModelScope.launch(Dispatchers.Default) {
            repository.saveQuestion(question)
        }
    }

    /** Requests for a removal of questions */
    fun requestQuestionsDeletion(uidList: Set<String>) {
        viewModelScope.launch {
            repository.deleteQuestions(uidList.toList())
            dataManager.collectionQuestions.update { questions ->
                questions.toMutableList().apply {
                    removeAll { uidList.contains(it.uid) }
                }
            }
        }
    }

    /** Requests for a fact data save */
    private fun requestFactSave(fact: FactIO) {
        viewModelScope.launch {
            repository.saveFact(fact)
        }
    }

    /** Adds a new question */
    fun addNewQuestion(): QuestionIO {
        val newQuestion = QuestionIO(uid = "TESTING QUESTION CREATION".plus(UUID.randomUUID().toString()))
        dataManager.collectionQuestions.update {
            it.toMutableList().apply {
                add(0, newQuestion)
            }
        }
        viewModelScope.launch {
            dataManager.collectionDetail.value?.apply {
                questionUidList.add(newQuestion.uid)
            }?.let { requestCollectionSave(it) }
        }
        return newQuestion
    }

    /** Pastes current clipboard */
    fun pasteFactsClipBoard() {
        viewModelScope.launch {
            val clipBoard = clipBoard.facts.paste()
            clipBoard.forEach {
                requestFactSave(it)
            }
            dataManager.collectionDetail.value?.apply {
                factUidList.addAll(clipBoard.map { it.uid })
            }?.let { requestCollectionSave(it) }
            dataManager.collectionFacts.update {
                it.toMutableList().apply { addAll(0, clipBoard) }
            }
        }
    }

    /** Pastes current clipboard */
    fun pasteQuestionsClipBoard() {
        viewModelScope.launch {
            val clipBoard = clipBoard.questions.paste()
            clipBoard.forEach {
                requestQuestionSave(it)
            }
            dataManager.collectionDetail.value?.apply {
                questionUidList.addAll(clipBoard.map { it.uid })
            }?.let { requestCollectionSave(it) }
            dataManager.collectionQuestions.update {
                it.toMutableList().apply { addAll(0, clipBoard) }
            }
        }
    }

    /** Update current TO with new one */
    fun updateCollection(collection: CollectionIO) {
        dataManager.collectionDetail.update { previousCollection ->
            previousCollection?.copy(
                description = collection.description,
                name = collection.name
            )
        }
    }
}