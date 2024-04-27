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
import kotlinx.coroutines.withContext
import study.me.please.base.BaseViewModel
import study.me.please.base.GeneralClipBoard
import study.me.please.data.io.BaseResponse
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.UnitsFilter
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.data.io.subjects.UnitIO
import study.me.please.ui.collection.RefreshableViewModel
import javax.inject.Inject

/** Communication bridge between UI and DB */
@HiltViewModel
class CollectionUnitsViewModel @Inject constructor(
    private val repository: UnitsRepository,
    val clipBoard: GeneralClipBoard,
    private val questionGenerator: QuestionGenerator
): BaseViewModel(), RefreshableViewModel {

    companion object {
        /** in case we failed updating collection with the new questions */
        const val FAILED_INSERT = "failed_insert"
    }

    override val isRefreshing = MutableStateFlow(false)

    override var lastRefreshTimeMillis: Long = 0L

    override suspend fun onDataRequest(isSpecial: Boolean, isPullRefresh: Boolean) {
        requestUnits()
    }

    /** List of all subjects related to a collection */
    private val _units = MutableStateFlow<List<UnitIO>?>(null)

    /** response from generating questions */
    private val _questionsGeneratingResponse = MutableSharedFlow<BaseResponse<List<QuestionIO>>>()

    /** current collection */
    private val _collection = MutableStateFlow<CollectionIO?>(null)

    /** current collection */
    val collection = _collection.asStateFlow()

    /** Scroll to specific element with this uid */
    val scrollToElement = MutableStateFlow<ScrollToElement?>(null)

    data class ScrollToElement(
        val unitUid: String,
        val elementUidList: List<String>
    )

    /** Filter for current subjects */
    val filter = MutableStateFlow(UnitsFilter())

    /** currently selected unit */
    var currentUnit: UnitIO? = null

    /** response from generating questions */
    val questionsGeneratingResponse = _questionsGeneratingResponse.asSharedFlow()

    /** list of all paragraph names */
    val paragraphNames = hashMapOf<String, Int>()

    /** List of all subjects related to a collection */
    val subjects = _units.combine(filter) { subjects, filter ->
        // TODO filtering the content
        // TODO searching in the content will be similar to web searching - iterate through all of content
        //  - purpose of search can be both read only and also to change information.
        //  We have to search through collapsed content and give ability to scroll to the search result
        //  - perhaps expand all of content for easier preparing of filter data?
        subjects
    }

    /** Makes a request for a unit deletion from the DB */
    fun deleteUnits(unitUidList: List<String>) {
        viewModelScope.launch {
            _units.update { previousSubjects ->
                previousSubjects?.toMutableList()?.apply {
                    removeIf { unitUidList.contains(it.uid) }
                }
            }
            repository.deleteUnits(unitUidList)
            repository.deleteFirebaseUnits(
                collectionUid = collectionUid,
                unitUidList = unitUidList
            )
        }
    }

    /** Adds new unit but doesn't create a DB record for it */
    fun addNewUnit(collectionUid: String, prefix: String) {
        viewModelScope.launch {
            _units.update { previousUnits ->
                previousUnits?.toMutableList()?.apply {
                    add(UnitIO(collectionUid = collectionUid, name = "$prefix ${this.size.plus(1)}"))
                }
            }
        }
    }

    /** Updates specific subject */
    fun updateUnit(unit: UnitIO) {
        viewModelScope.launch {
            _units.value?.apply {
                find { it.uid == unit.uid }?.updateTO(unit)
            }
            repository.updateUnit(unit)
            repository.updateFirebaseUnit(unit, collectionUid)
        }
    }

    /** Generates questions and saves them right after that */
    fun generateQuestions(
        checkedUnitUidList: List<String>,
        activity: Activity,
        collectionUid: String
    ) {
        viewModelScope.launch(Dispatchers.Default) {
            _collection.value = repository.getCollection(collectionUid)
            collection.value?.let { safeCollection ->

                val response = questionGenerator.generateQuestions(
                    activity = activity,
                    units = _units.value?.filter { checkedUnitUidList.contains(it.uid) }.orEmpty(),
                    allUnits = _units.value.orEmpty(),
                    excludedList = repository.getAllQuestions(collectionUid = collectionUid)
                        ?.mapNotNull { it.importedSource?.sourceUid }
                        .orEmpty()
                )
                if(response.data?.isNotEmpty() == true) {
                    repository.insertQuestions(response.data)
                    repository.updateCollectionQuestions(
                        collectionUid = safeCollection.uid,
                        uidList = safeCollection.questionUidList.plus(response.data.map { it.uid }).toSet()
                    )
                }
                _questionsGeneratingResponse.emit(response.copy(
                    errorCode = response.errorCode
                ))
            }
        }
    }

    /** invalidates paragraph names */
    fun invalidateParagraphNames() {
        viewModelScope.launch {
            paragraphNames.clear()
            repository.getAllParagraphs()?.forEach { paragraph ->
                val score = paragraphNames[paragraph.name]
                paragraphNames[paragraph.name] = (score?.plus(1) ?: 1)
            }
        }
    }


    var collectionUid: String = ""
    var defaultUnitPrefix: String = ""

    /** Makes a request to return subjects */
    private suspend fun requestUnits() {
        if(collectionUid.isBlank() || defaultUnitPrefix.isBlank()) return

        val allParagraphs = repository.getAllParagraphs()
        allParagraphs?.forEach { paragraph ->
            val score = paragraphNames[paragraph.name]
            paragraphNames[paragraph.name] = (score?.plus(1) ?: 1)
        }

        _collection.value = repository.getCollection(collectionUid) ?: CollectionIO(uid = collectionUid).also {
            repository.insertCollection(it)
        }

        val res = repository.getUnitsByCollection(collectionUid)
        _units.value = if(res.isNullOrEmpty()) {
            listOf(UnitIO(collectionUid = collectionUid, name = defaultUnitPrefix.plus(" 1")))
        }else res.onEach { unit ->
            if(unit.factUidList.isNotEmpty()) {
                unit.facts.clear()
                unit.facts.addAll(
                    repository.getFactsBy(unit.factUidList).orEmpty().sortedBy {
                        unit.factUidList.indexOf(it.uid)
                    }
                )
            }
            if(unit.paragraphUidList.isNotEmpty()) {
                unit.paragraphs.clear()
                unit.paragraphs.addAll(
                    repository.getParagraphsBy(unit.paragraphUidList).orEmpty().sortedBy {
                        unit.paragraphUidList.indexOf(it.uid)
                    }.onEach { paragraph ->
                        if(paragraph.factUidList.isNotEmpty()) {
                            paragraph.facts.clear()
                            paragraph.facts.addAll(
                                repository.getFactsBy(paragraph.factUidList).orEmpty().sortedBy {
                                    paragraph.factUidList.indexOf(it.uid)
                                }
                            )
                        }
                        if(paragraph.paragraphUidList.isNotEmpty()) {
                            paragraph.paragraphs.clear()
                            paragraph.paragraphs.addAll(
                                repository.getParagraphsBy(paragraph.paragraphUidList)?.sortedBy {
                                    paragraph.factUidList.indexOf(it.uid)
                                }.orEmpty()
                            )
                        }

                        iterateFurtherAction(paragraph) { iterationParagraph ->
                            if(iterationParagraph.factUidList.isNotEmpty()) {
                                iterationParagraph.facts.clear()
                                iterationParagraph.facts.addAll(
                                    repository.getFactsBy(iterationParagraph.factUidList).orEmpty().sortedBy {
                                        iterationParagraph.factUidList.indexOf(it.uid)
                                    }
                                )
                            }
                            if(iterationParagraph.paragraphUidList.isNotEmpty()) {
                                iterationParagraph.paragraphs.clear()
                                iterationParagraph.paragraphs.addAll(
                                    repository.getParagraphsBy(iterationParagraph.paragraphUidList)?.sortedBy {
                                        iterationParagraph.factUidList.indexOf(it.uid)
                                    }.orEmpty()
                                )
                            }
                        }
                    }
                )
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
                iterateFurtherAction(
                    paragraph = iterationParagraph,
                    action = action,
                )
            }
            paragraph.paragraphs = paragraphsCopy.toMutableList()
        }
    }
}