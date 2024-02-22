package study.me.please.ui.units

import android.app.Activity
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import study.me.please.base.BaseViewModel
import study.me.please.base.GeneralClipBoard
import study.me.please.data.io.BaseResponse
import study.me.please.data.io.FactIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.subjects.CategoryIO
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.data.io.subjects.UnitIO
import study.me.please.ui.components.FactCardCategoryUseCase
import javax.inject.Inject

/** Communication bridge between UI and DB */
@HiltViewModel
class UnitsViewModel @Inject constructor(
    private val repository: SubjectsRepository,
    val clipBoard: GeneralClipBoard,
    private val questionGenerator: QuestionGenerator
): BaseViewModel(), FactCardCategoryUseCase {

    companion object {
        /** in case we failed updating collection with the new questions */
        const val FAILED_INSERT = "failed_insert"
    }

    /** List of all subjects related to a collection */
    private val _subjectsList = MutableStateFlow<List<UnitIO>?>(null)

    /** List of all categories */
    private val _categories = MutableStateFlow<List<CategoryIO>?>(null)

    /** response from generating questions */
    private val _questionsGeneratingResponse = MutableSharedFlow<BaseResponse<List<QuestionIO>>>()

    /** Filter for current subjects */
    val filter = MutableStateFlow(SubjectsFilter())

    /** response from generating questions */
    val questionsGeneratingResponse = _questionsGeneratingResponse.asSharedFlow()

    /** List of all subjects related to a collection */
    val subjects = _subjectsList.combine(filter) { subjects, filter ->
        // TODO searching in subjects
        subjects
    }

    /** List of all categories */
    override val categories = _categories.asStateFlow()

    /** uid of an element that is requested to be removed from its paragraph */
    val elementUidToRemove = MutableStateFlow<String?>(null)

    var dragAndDroppedFact: FactIO? = null
    var dragAndDroppedParagraph: ParagraphIO? = null

    /** Generates questions and saves them right after that */
    fun generateQuestions(
        checkedSubjectUids: List<String>,
        activity: Activity,
        collectionUid: String
    ) {
        viewModelScope.launch(Dispatchers.Default) {
            val collection = repository.getCollection(collectionUid)
            val response = questionGenerator.generateQuestions(
                activity = activity,
                subjects = _subjectsList.value?.filter { checkedSubjectUids.contains(it.uid) }.orEmpty(),
                allSubject = _subjectsList.value.orEmpty(),
                excludedList = repository.getAllQuestions(collectionUid = collectionUid)
                    ?.map { it.uid }
                    .orEmpty()
            )
            if(response.data?.isNotEmpty() == true && collection != null) {
                repository.insertQuestions(response.data)
                repository.updateCollectionQuestions(
                    collectionUid = collection.uid,
                    uidList = collection.questionUidList.plus(response.data.map { it.uid })
                )
            }
            _questionsGeneratingResponse.emit(response.copy(
                errorCode = if(collection == null) FAILED_INSERT else response.errorCode
            ))
        }
    }

    /**
     * Iterates through the given source paragraph [sourceUid] and checks,
     * whether [targetUid] is a child of it
     */
    fun isNestedOfParagraph(
        sourceParagraph: ParagraphIO?,
        targetUid: String
    ): Boolean {
        if(sourceParagraph == null) return false

        sourceParagraph.paragraphs.forEach { paragraph ->
            if(paragraph.uid == targetUid) return true
            if(isNestedOfParagraph(
                sourceParagraph = paragraph,
                targetUid = targetUid
            )) return true
        }
        return false
    }

    /** Makes a request to return subjects */
    fun requestSubjectsList(collectionUid: String) {
        viewModelScope.launch {
            _categories.value = repository.getAllCategories()
            val res = repository.getSubjectsByCollection(collectionUid)
            _subjectsList.value = if(res.isNullOrEmpty()) {
                listOf(UnitIO(collectionUid = collectionUid))
            }else res
        }
    }

    override fun requestAllCategories() {
        viewModelScope.launch {
            _categories.value = repository.getAllCategories()
        }
    }

    /** Copies a fact by its uid */
    fun copyFactByUid(paragraphs: List<ParagraphIO>, uid: String) {
        viewModelScope.launch {
            paragraphs.forEach { paragraph ->
                paragraph.facts.forEach { fact ->
                    if(fact.uid == uid) {
                        clipBoard.facts.copyItems(listOf(fact))
                        return@launch
                    }
                }
                copyFactByUid(paragraph.paragraphs, uid = uid)
            }
        }
    }

    /** Copies a paragraph by its uid */
    fun copyParagraphByUid(paragraphs: List<ParagraphIO>, uid: String) {
        viewModelScope.launch {
            paragraphs.forEach { paragraph ->
                if(paragraph.uid == uid) {
                    clipBoard.paragraphs.copyItems(listOf(paragraph))
                    return@launch
                }
                copyFactByUid(paragraph.paragraphs, uid = uid)
            }
        }
    }

    /** Makes a request for a subject deletion from the DB */
    fun deleteSubject(subjectUid: String) {
        viewModelScope.launch {
            _subjectsList.update { previousSubjects ->
                previousSubjects?.toMutableList()?.apply {
                    removeIf { it.uid == subjectUid }
                }
            }
            repository.deleteSubject(subjectUid)
        }
    }

    /** Adds new subject and creates, but doesn't create a DB record for it */
    fun addNewSubject(collectionUid: String, prefix: String) {
        viewModelScope.launch {
            _subjectsList.update { previousSubjects ->
                previousSubjects?.toMutableList()?.apply {
                    add(UnitIO(collectionUid = collectionUid, name = "$prefix ${this.size.plus(1)}"))
                }
            }
        }
    }

    /** Updates specific subject */
    fun updateUnit(subject: UnitIO) {
        viewModelScope.launch {
            _subjectsList.value?.apply {
                find { it.uid == subject.uid }?.updateTO(subject)
            }
            repository.updateSubject(subject)
        }
    }

    /** iterates into all possible depths */
    private fun iterateFurther(paragraph: ParagraphIO, newParagraph: ParagraphIO) {
        paragraph.paragraphs.forEach { iterationParagraph ->
            if(iterationParagraph.uid == newParagraph.uid) {
                iterationParagraph.updateTO(newParagraph)
            }
            iterateFurther(paragraph = iterationParagraph, newParagraph = newParagraph)
        }
    }

    /** Updates specific subject */
    fun updateParagraph(subject: UnitIO, newParagraph: ParagraphIO) {
        viewModelScope.launch {
            subject.paragraphs.forEach { paragraph ->
                iterateFurther(paragraph, newParagraph)
            }

            _subjectsList.value?.apply {
                find { it.uid == subject.uid }?.updateTO(subject)
            }
            repository.updateSubject(subject)
            repository.updateParagraph(newParagraph)
        }
    }

    override fun requestAddNewCategory(category: CategoryIO) {
        viewModelScope.launch {
            _categories.update { previousCategories ->
                previousCategories?.toMutableList()?.apply {
                    add(category)
                }
            }
            repository.insertCategory(category)
        }
    }
}