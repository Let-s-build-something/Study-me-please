package study.me.please.ui.units

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import study.me.please.base.BaseViewModel
import study.me.please.base.GeneralClipBoard
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.UnitsFilter
import study.me.please.data.io.subjects.UnitIO
import study.me.please.ui.collection.RefreshableViewModel
import study.me.please.ui.units.utils.UnitsUseCase
import javax.inject.Inject


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

    /** list of all paragraph names */
    val paragraphNames = MutableStateFlow(hashMapOf<String, Int>())

    /** List of all subjects related to a collection */
    val units = _units.combine(filter) { units, filter ->
        // TODO filtering the content
        // TODO searching in the content will be similar to web searching - iterate through all of content
        //  - purpose of search can be both read only and also to change information.
        //  We have to search through collapsed content and give ability to scroll to the search result
        //  - perhaps expand all of content for easier preparing of filter data?
        units
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


    var collectionUid: String = ""
    var defaultUnitPrefix: String = ""

    /** Makes a request to return subjects */
    private suspend fun requestUnits() {
        if(collectionUid.isBlank() || defaultUnitPrefix.isBlank()) return

        _collection.value = repository.getCollection(collectionUid) ?: CollectionIO(uid = collectionUid).also {
            repository.insertCollection(it)
        }
        _units.value = useCase.getUnitsByCollection(collectionUid).ifEmpty {
            listOf(UnitIO(collectionUid = collectionUid, name = defaultUnitPrefix.plus(" 1")))
        }
    }
}