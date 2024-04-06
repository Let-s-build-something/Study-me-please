package study.me.please.ui.units

import android.app.Activity
import android.util.Log
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
import kotlinx.coroutines.withContext
import study.me.please.base.BaseViewModel
import study.me.please.base.GeneralClipBoard
import study.me.please.data.io.BaseResponse
import study.me.please.data.io.FactIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.subjects.CategoryIO
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.data.io.subjects.UnitIO
import study.me.please.ui.components.FactCardCategoryUseCase
import java.util.UUID
import javax.inject.Inject

/** Communication bridge between UI and DB */
@HiltViewModel
class UnitsViewModel @Inject constructor(
    private val repository: UnitsRepository,
    val clipBoard: GeneralClipBoard,
    private val questionGenerator: QuestionGenerator
): BaseViewModel(), FactCardCategoryUseCase {

    companion object {
        /** in case we failed updating collection with the new questions */
        const val FAILED_INSERT = "failed_insert"
    }

    /** List of all subjects related to a collection */
    private val _unitsList = MutableStateFlow<List<UnitIO>?>(null)

    /** List of all categories */
    private val _categories = MutableStateFlow<List<CategoryIO>?>(null)

    /** response from generating questions */
    private val _questionsGeneratingResponse = MutableSharedFlow<BaseResponse<List<QuestionIO>>>()

    /** Filter for current subjects */
    val filter = MutableStateFlow(UnitsFilter())

    /** currently selected unit */
    var currentUnit: UnitIO? = null

    /** response from generating questions */
    val questionsGeneratingResponse = _questionsGeneratingResponse.asSharedFlow()

    /** List of all subjects related to a collection */
    val subjects = _unitsList.combine(filter) { subjects, filter ->
        // TODO filtering the content
        // TODO searching in the content will be similar to web searching - iterate through all of content
        //  - purpose of search can be both read only and also to change information.
        //  We have to search through collapsed content and give ability to scroll to the search result
        //  - perhaps expand all of content for easier preparing of filter data?
        subjects
    }

    /** List of all categories */
    override val categories = _categories.asStateFlow()

    /** uid of an element that is requested to be removed from its paragraph */
    val elementUidToRemove = MutableStateFlow<String?>(null)

    /** Element that is being currently dragged */
    data class ElementToDrag(
        /** data that is being dragged - the same as localState inside the drag event */
        val data: Any?,

        /** uid of the parent of the [data] element */
        val parentUid: String,

        /** index of the element in the parent */
        val index: Int
    ) {
        /** returns [data] as [FactIO] */
        val fact: FactIO? = data as? FactIO

        /** returns [data] as [ParagraphIO] */
        val paragraph: ParagraphIO? = data as? ParagraphIO

        /** uid of the element */
        val uid: String
            get() = fact?.uid ?: paragraph?.uid ?: ""

        val asNew: ElementToDrag
            get() = ElementToDrag(
                data = fact?.copy(uid = UUID.randomUUID().toString()) ?: paragraph?.deepCopy(),
                parentUid = parentUid,
                index = index
            )
    }

    /** currently dragged element */
    var localStateElement: ElementToDrag? = null

    /** patch with modified paragraph */
    val paragraphPatch = MutableStateFlow<ParagraphIO?>(null)

    /** called when drag event is ended */
    suspend fun onDragEnded(elementToDrag: ElementToDrag): ElementToDrag {
        Log.d("kostka_test", "onDragEnded, element: ${elementToDrag.uid}")
        val newElement = elementToDrag.asNew
        Log.d("kostka_test", "onDragEnded, newElement: ${newElement.uid}")
        currentUnit?.let { unit ->
            requestObjectRemoval(
                unit = unit,
                elementUid = elementToDrag.uid
            )
            requestObjectAdd(
                unit = unit,
                element = newElement
            )
        }
        localStateElement = null
        return newElement
    }

    /** iterates through whole subject in order to remove any element by its uid */
    suspend fun requestObjectRemoval(
        unit: UnitIO,
        elementUid: String
    ) {
        withContext(Dispatchers.Default) {
            Log.d("kostka_test", "requestObjectRemoval, uid: $elementUid")
            // unit layer removal
            if(unit.removeParagraph(elementUid)) {
                repository.deleteParagraph(elementUid)
                updateUnit(unit)
                Log.d("kostka_test", "requestObjectRemoval, object $elementUid removed")
                elementUidToRemove.value = null
                return@withContext
            }
            if(unit.removeFact(elementUid)) {
                repository.deleteFact(elementUid)
                updateUnit(unit)
                Log.d("kostka_test", "requestObjectRemoval, object $elementUid removed")
                elementUidToRemove.value = null
                return@withContext
            }

            unit.paragraphs.forEach { paragraph ->
                // first paragraphs layer
                if(paragraph.removeParagraph(elementUid)) {
                    repository.deleteParagraph(elementUid)
                    repository.updateParagraph(paragraph)
                    paragraphPatch.value = paragraph
                    Log.d("kostka_test", "requestObjectRemoval, object $elementUid removed")
                    elementUidToRemove.value = null
                    return@withContext
                }
                if(paragraph.removeFact(elementUid)) {
                    repository.deleteFact(elementUid)
                    repository.updateParagraph(paragraph)
                    Log.d("kostka_test", "requestObjectRemoval, object $elementUid removed")
                    elementUidToRemove.value = null
                    return@withContext
                }

                iterateFurtherAction(
                    paragraph,
                    action = { nestedParagraph ->
                        // nested paragraphs layer
                        if(nestedParagraph.removeParagraph(elementUid)) {
                            repository.deleteParagraph(elementUid)
                            repository.updateParagraph(nestedParagraph)
                            paragraphPatch.value = nestedParagraph
                            Log.d("kostka_test", "requestObjectRemoval, object $elementUid removed")
                            elementUidToRemove.value = null
                            return@iterateFurtherAction
                        }
                        if(nestedParagraph.removeFact(elementUid)) {
                            repository.deleteFact(elementUid)
                            repository.updateParagraph(nestedParagraph)
                            Log.d("kostka_test", "requestObjectRemoval, object $elementUid removed")
                            elementUidToRemove.value = null
                            return@iterateFurtherAction
                        }
                    }
                )
            }
        }
    }

    /** iterates through whole subject in order to add any element by parent uid */
    private suspend fun requestObjectAdd(
        unit: UnitIO,
        element: ElementToDrag
    ) {
        withContext(Dispatchers.Default) {
            Log.d("kostka_test", "requestObjectAdd, uid: ${element.uid}")
            // unit layer add
            if(element.paragraph != null && element.parentUid == unit.uid) {
                unit.addParagraph(index = element.index, paragraph = element.paragraph)
                repository.updateParagraph(element.paragraph)
                repository.updateUnit(unit)
                Log.d("kostka_test", "requestObjectAdd, object ${element.uid} added (paragraphUidList: ${unit.paragraphUidList}")
                return@withContext
            }
            if(element.fact != null && element.parentUid == unit.uid) {
                unit.addFact(index = element.index, fact = element.fact)
                repository.updateFact(element.fact)
                repository.updateUnit(unit)
                Log.d("kostka_test", "requestObjectAdd, object ${element.uid} added (factUidList: ${unit.factUidList}")
                return@withContext
            }

            unit.paragraphs.forEach { paragraph ->
                // first paragraphs layer
                if(element.paragraph != null && paragraph.uid == element.parentUid) {
                    paragraph.addParagraph(index = element.index, paragraph = element.paragraph)
                    repository.updateParagraph(element.paragraph)
                    repository.updateParagraph(paragraph)
                    paragraphPatch.value = paragraph
                    Log.d("kostka_test", "requestObjectAdd, object ${element.uid} added (paragraphUidList: ${paragraph.paragraphUidList}")
                    return@withContext
                }
                if(element.fact != null && paragraph.uid == element.parentUid) {
                    paragraph.addFact(index = element.index, fact = element.fact)
                    repository.updateFact(element.fact)
                    repository.updateParagraph(paragraph)
                    paragraphPatch.value = paragraph
                    Log.d("kostka_test", "requestObjectAdd, object ${element.uid} added (factUidList: ${paragraph.factUidList}")
                    return@withContext
                }

                iterateFurtherAction(
                    paragraph,
                    action = { nestedParagraph ->
                        // nested paragraphs layer
                        if(element.paragraph != null && nestedParagraph.uid == element.parentUid) {
                            nestedParagraph.addParagraph(index = element.index, paragraph = element.paragraph)
                            repository.updateParagraph(element.paragraph)
                            repository.updateParagraph(nestedParagraph)
                            paragraphPatch.value = nestedParagraph
                            Log.d("kostka_test", "requestObjectAdd, object ${element.uid} added (paragraphUidList: ${nestedParagraph.paragraphUidList}")
                            return@iterateFurtherAction
                        }
                        if(element.fact != null && nestedParagraph.uid == element.parentUid) {
                            nestedParagraph.addFact(index = element.index, fact = element.fact)
                            repository.updateFact(element.fact)
                            repository.updateParagraph(nestedParagraph)
                            paragraphPatch.value = nestedParagraph
                            Log.d("kostka_test", "requestObjectAdd, object ${element.uid} added (factUidList: ${nestedParagraph.factUidList}")
                            return@iterateFurtherAction
                        }
                    }
                )
            }
        }
    }

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
                subjects = _unitsList.value?.filter { checkedSubjectUids.contains(it.uid) }.orEmpty(),
                allSubject = _unitsList.value.orEmpty(),
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

    /** Makes a request to return subjects */
    fun requestSubjectsList(collectionUid: String) {
        viewModelScope.launch(Dispatchers.Default) {
            _categories.value = repository.getAllCategories()
            val res = repository.getSubjectsByCollection(collectionUid)
            _unitsList.value = if(res.isNullOrEmpty()) {
                listOf(UnitIO(collectionUid = collectionUid))
            }else res.onEach { unit ->
                if(unit.paragraphUidList.isNotEmpty()) {
                    unit.paragraphs.clear()
                    unit.paragraphs.addAll(
                        repository.getParagraphsBy(unit.paragraphUidList)
                            .orEmpty()
                            .onEach { paragraph ->
                                paragraph.fillInParagraph()
                            }
                    )
                }
                if(unit.factUidList.isNotEmpty()) {
                    unit.facts.clear()
                    unit.facts.addAll(
                        repository.getFactsBy(unit.factUidList).orEmpty()
                    )
                }
            }
        }
    }

    /** Fills in all neccessary data to this paragraph */
    private suspend fun ParagraphIO.fillInParagraph() {
        if(paragraphUidList.isNotEmpty()) {
            paragraphs = repository.getParagraphsBy(paragraphUidList).orEmpty().onEach {
                it.fillInParagraph()
            }.toMutableList()
        }
        if(factUidList.isNotEmpty()) {
            facts = repository.getFactsBy(factUidList).orEmpty().toMutableList()
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

    /** iterates into all possible depths */
    private suspend fun iterateFurtherAction(
        paragraph: ParagraphIO,
        action: suspend (ParagraphIO) -> Unit
    ) {
        withContext(Dispatchers.Default) {
            val paragraphsCopy = paragraph.paragraphs.toList()
            paragraphsCopy.forEach { iterationParagraph ->
                action(iterationParagraph)
                iterateFurtherAction(paragraph = iterationParagraph, action = action)
            }
            paragraph.paragraphs = paragraphsCopy.toMutableList()
        }
    }

    /** Makes a request for a unit deletion from the DB */
    fun deleteUnit(unitUid: String) {
        viewModelScope.launch {
            _unitsList.update { previousSubjects ->
                previousSubjects?.toMutableList()?.apply {
                    removeIf { it.uid == unitUid }
                }
            }
            repository.deleteSubject(unitUid)
        }
    }

    /** Adds new unit but doesn't create a DB record for it */
    fun addNewUnit(collectionUid: String, prefix: String) {
        viewModelScope.launch {
            _unitsList.update { previousUnits ->
                previousUnits?.toMutableList()?.apply {
                    add(UnitIO(collectionUid = collectionUid, name = "$prefix ${this.size.plus(1)}"))
                }
            }
        }
    }

    /** Updates specific subject */
    fun updateUnit(subject: UnitIO) {
        viewModelScope.launch {
            _unitsList.value?.apply {
                find { it.uid == subject.uid }?.updateTO(subject)
            }
            repository.updateUnit(subject)
        }
    }

    /** Updates specific fact */
    fun updateFact(unit: UnitIO, fact: FactIO) {
        viewModelScope.launch(Dispatchers.Default) {
            _unitsList.value?.apply {
                unit.facts.find { fact.uid == it.uid }?.apply {
                    updateTO(fact)
                    return@launch
                }
                unit.paragraphs.forEach { paragraph ->
                    iterateFurtherAction(paragraph, action = { iterationParagraph ->
                        iterationParagraph.facts.find { fact.uid == it.uid }?.apply {
                            updateTO(fact)
                            return@iterateFurtherAction
                        }
                    })
                }
            }
            repository.updateFact(fact)
        }
    }

    /** Updates specific subject */
    fun updateParagraph(unit: UnitIO, newParagraph: ParagraphIO) {
        viewModelScope.launch {
            unit.paragraphs.forEach { paragraph ->
                if(paragraph.uid == newParagraph.uid) {
                    paragraph.updateTO(newParagraph)
                    return@forEach
                }

                iterateFurtherAction(paragraph, action = { iterationParagraph ->
                    if(iterationParagraph.uid == newParagraph.uid) {
                        iterationParagraph.updateTO(newParagraph)
                        return@iterateFurtherAction
                    }
                })
            }

            _unitsList.value?.apply {
                find { it.uid == unit.uid }?.updateTO(unit)
            }

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