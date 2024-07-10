package study.me.please.ui.units

import androidx.lifecycle.viewModelScope
import com.squadris.squadris.compose.base.BaseViewModel
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
import study.me.please.data.io.UnitsFilter
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.data.io.subjects.UnitIO
import study.me.please.ui.units.utils.UnitsUseCase
import java.util.UUID
import javax.inject.Inject
import kotlin.math.abs


/** Communication bridge between UI and DB */
@HiltViewModel
class CollectionUnitsViewModel @Inject constructor(
    private val repository: UnitsRepository,
    private val useCase: UnitsUseCase,
    val clipBoard: GeneralClipBoard
): BaseViewModel(), RefreshableViewModel {

    override val isRefreshing = MutableStateFlow(false)

    override var lastRefreshTimeMillis: Long = 0L

    override suspend fun onDataRequest(isSpecial: Boolean, isPullRefresh: Boolean) {
        requestUnits()
    }

    /** List of all subjects related to a collection */
    private val _units = MutableStateFlow<List<UnitIO>?>(null)

    /** current collection */
    private val _collection = MutableStateFlow<CollectionIO?>(null)

    /** Scroll to specific element with this uid */
    val scrollToElement = MutableStateFlow<FocusedUnitElement?>(null)

    /** list of all paragraph names */
    val paragraphNames = MutableStateFlow(hashMapOf<String, Int>())

    /** Filter for current subjects */
    val filter = MutableStateFlow(UnitsFilter())

    /** identifier of collection that should be requested */
    var collectionUid: String? = null

    /** default prefix of new unit */
    var defaultUnitPrefix: String = ""

    /** List of all subjects related to a collection */
    val units = _units.asStateFlow()

    /** current collection */
    val collection = _collection.asStateFlow()

    /** current collection */
    val searchResults = _units.combine(filter) { units, filter ->
        withContext(Dispatchers.Default) {
            val results = mutableListOf<FocusedUnitElement>()
            val prompt = filter.textFilter.lowercase()

            if (prompt.isNotBlank()) {
                units?.sortedBy {
                    // serazeno podle vzdalenosti od aktualne vybraneho indexu
                    abs(units.indexOf(it) - (collection.value?.lastSelectedUnitIndex ?: 0)) + 1
                }?.forEach { unit ->
                    if (unit.name.contains(prompt)
                        || unit.bulletPoints.any { it.lowercase().contains(prompt) }
                    ) {
                        results.add(FocusedUnitElement(unitUid = unit.uid, emptyList()))
                    }

                    iterateFurtherAction(
                        paragraphs = unit.paragraphs,
                        action = { elementPath, iteratedParagraph ->
                            if (iteratedParagraph.name.lowercase().contains(prompt)
                                || iteratedParagraph.bulletPoints.any { it.lowercase().contains(prompt) }
                            ) {
                                results.add(FocusedUnitElement(unitUid = unit.uid, elementPath))
                            }
                            iteratedParagraph.facts.forEach { fact ->
                                if (fact.shortKeyInformation.lowercase().contains(prompt)
                                    || fact.longInformation.lowercase().contains(prompt)
                                    || fact.textList.any { it.lowercase().contains(prompt) }
                                ) {
                                    results.add(
                                        FocusedUnitElement(
                                            unitUid = unit.uid,
                                            elementPath.plus(fact.uid)
                                        )
                                    )
                                }
                                fact.facts.forEach { nestedFact ->
                                    if (nestedFact.shortKeyInformation.lowercase().contains(prompt)
                                        || nestedFact.longInformation.lowercase().contains(prompt)
                                        || nestedFact.textList.any { it.lowercase().contains(prompt) }
                                    ) {
                                        results.add(
                                            FocusedUnitElement(
                                                unitUid = unit.uid,
                                                elementPath.plus(nestedFact.uid)
                                            )
                                        )
                                    }
                                }
                            }
                        }
                    )
                }
                results
            }else null
        }
    }

    /** iterates into all possible depths */
    private suspend fun iterateFurtherAction(
        paragraphs: List<ParagraphIO>,
        elementPath: List<String> = emptyList(),
        action: suspend (List<String>, ParagraphIO) -> Unit
    ) {
        withContext(Dispatchers.Default) {
            paragraphs.forEach { iterationParagraph ->
                action(elementPath.plus(iterationParagraph.uid), iterationParagraph)

                iterateFurtherAction(
                    paragraphs = iterationParagraph.paragraphs,
                    action = action,
                    elementPath = elementPath.plus(iterationParagraph.uid)
                )
            }
        }
    }

    /** Makes a request for a unit deletion from the DB */
    fun deleteUnits(unitUidList: List<String>) {
        viewModelScope.launch {
            _units.update { previousUnits ->
                previousUnits?.toMutableList()?.apply {
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

    /** Makes a request for a collection save */
    fun updateCollection() {
        collection.value?.let {
            viewModelScope.launch {
                repository.updateCollection(it)
            }
        }
    }

    /** Adds new unit but doesn't create a DB record for it */
    fun addNewUnit(collectionUid: String?, prefix: String) {
        if(collectionUid == null) return
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

    /** invalidates paragraph names */
    fun invalidateParagraphNames() {
        viewModelScope.launch {
            paragraphNames.value.clear()
            val newMap = hashMapOf<String, Int>()
            repository.getAllParagraphs()?.forEach { paragraph ->
                val score = newMap[paragraph.name]
                newMap[paragraph.name] = (score?.plus(1) ?: 1)
            }
            paragraphNames.value = newMap
        }
    }

    /** Makes a request to return subjects */
    private suspend fun requestUnits() {
        if(collectionUid.isNullOrBlank()) {
            val newCollectionUid = UUID.randomUUID().toString()
            _collection.value = CollectionIO(uid = newCollectionUid).also {
                repository.insertCollection(it)
            }
            _units.value = listOf(UnitIO(
                collectionUid = newCollectionUid,
                name = defaultUnitPrefix.plus(" 1")
            ))
        }else {
            collectionUid?.let { uid ->
                if(uid.isBlank() || defaultUnitPrefix.isBlank()) return

                _collection.value = repository.getCollection(uid)
                _units.value = useCase.getUnitsByCollection(uid).ifEmpty {
                    listOf(UnitIO(collectionUid = uid, name = defaultUnitPrefix.plus(" 1")))
                }
            }
        }
    }
}

/** Helper class which focuses on a certain point within a unit */
data class FocusedUnitElement(

    /** identifier of an unit */
    val unitUid: String,

    /**
     * path leading into the element, it is ascending - meaning top down until the desired element
     */
    val elementPath: List<String>
)