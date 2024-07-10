package study.me.please.ui.community

import androidx.lifecycle.viewModelScope
import com.squadris.squadris.compose.base.BaseViewModel
import com.squadris.squadris.utils.RefreshableViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.community.CollectionCategoryResponse
import javax.inject.Inject

/** Interaction between UI layer and the API, DB and logic behind a screen */
@HiltViewModel
class CommunityViewModel @Inject constructor(
    private val repository: CommunityRepository,
    val dataManager: CommunityDataManager
): BaseViewModel(), RefreshableViewModel {

    override val isRefreshing: MutableStateFlow<Boolean> = MutableStateFlow(false)
    override var lastRefreshTimeMillis: Long = 0L

    override suspend fun onDataRequest(isSpecial: Boolean, isPullRefresh: Boolean) {
        repository.getCategories().addOnSuccessListener {
            dataManager.categories.value = it.toObject(CollectionCategoryResponse::class.java)?.categories
        }
    }

    /** Filter for all community content */
    val filter = dataManager.filter.asStateFlow()

    /** currently filtered collections */
    val collections = dataManager.collections.asStateFlow()

    /** all available categories */
    val categories = dataManager.categories.asStateFlow()

    /** requests all collections from the server */
    private fun requestCollections() {
        viewModelScope.launch {
            dataManager.collections.value = null
            repository.getCollections(
                filter = dataManager.filter.value
            ).addOnSuccessListener { res ->
                // TODO paging needed
                dataManager.collections.value = res.documents.mapNotNull { it.toObject(CollectionIO::class.java) }
            }
        }
    }

    /** queries all currently visible collections for a category */
    fun filterCollection(categoryUid: String) {
        viewModelScope.launch {
            dataManager.filter.update {
                it.copy(categoryUid = categoryUid)
            }

            requestCollections()
        }
    }

    /** clears the current filter */
    fun clearFilter() {
        viewModelScope.launch {
            dataManager.filter.value = CommunityDashboardFilter()
        }
    }
}