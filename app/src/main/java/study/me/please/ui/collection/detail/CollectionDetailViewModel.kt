package study.me.please.ui.collection.detail

import androidx.lifecycle.viewModelScope
import com.squadris.squadris.compose.base.BaseViewModel
import com.squadris.squadris.utils.DateUtils
import com.squadris.squadris.utils.RefreshableViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import study.me.please.base.GeneralClipBoard
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.shared.SharedDataManager
import study.me.please.ui.collection.detail.questions.QuestionsFilter
import study.me.please.ui.collection.detail.questions.SortByType
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
    private fun requestCollectionSave(
        collection: CollectionIO,
        updateMap: Map<String, Any?>
    ) {
        viewModelScope.launch(Dispatchers.Default) {
            if(collection.isNotEmpty) {
                repository.saveCollection(
                    collection = collection.apply {
                        dateModified = DateUtils.now.timeInMillis
                    },
                    updateMap = updateMap
                )
            }
        }
    }

    /** Requests for a collection data save */
    fun updateCollectionAbout(collection: CollectionIO) {
        requestCollectionSave(
            collection = collection,
            updateMap = mapOf(
                "dateModified" to DateUtils.now.timeInMillis,
                "description" to collection.description,
                "name" to collection.name
            )
        )
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

    /** Adds a new question */
    fun addNewQuestion(): QuestionIO {
        val newQuestion = QuestionIO()
        dataManager.collectionQuestions.update {
            it.toMutableList().apply {
                add(0, newQuestion)
            }
        }
        viewModelScope.launch {
            dataManager.collectionDetail.value?.apply {
                questionUidList.add(newQuestion.uid)
            }?.let {
                requestCollectionSave(
                    it,
                    updateMap = mapOf("questions.${newQuestion.uid}" to newQuestion)
                )
            }
        }
        return newQuestion
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
            }?.let { collection ->
                requestCollectionSave(
                    collection,
                    updateMap = mapOf("questions" to clipBoard.map { it.uid to it }.plus(collection.questions))
                )
            }
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