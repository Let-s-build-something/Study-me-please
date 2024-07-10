package study.me.please.ui.collection

import androidx.lifecycle.viewModelScope
import com.squadris.squadris.compose.base.BaseViewModel
import com.squadris.squadris.utils.RefreshableViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CollectionViewModel @Inject constructor(
    private val repository: CollectionRepository,
    private val dataManager: CollectionDataManager
): BaseViewModel(), RefreshableViewModel {

    override val isRefreshing = MutableStateFlow(false)

    override var lastRefreshTimeMillis: Long = 0L

    override suspend fun onDataRequest(isSpecial: Boolean, isPullRefresh: Boolean) {
        repository.getCollections()?.let { collections ->
            dataManager.collections.value = collections
        }
    }

    /** list of all collections saved locally */
    val collections = dataManager.collections.asStateFlow()

    /** Requests for a removal of collections */
    fun requestCollectionDeletion(uidList: Set<String>) {
        viewModelScope.launch {
            dataManager.collections.update {
                it?.filter { collection -> collection.uid !in uidList }
            }
            repository.deleteCollections(uidList.toList())
        }
    }
}