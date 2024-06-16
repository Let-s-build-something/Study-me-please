package study.me.please.ui.collection

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import com.squadris.squadris.compose.base.BaseViewModel
import com.squadris.squadris.utils.RefreshableViewModel
import javax.inject.Inject

@HiltViewModel
class CollectionViewModel @Inject constructor(
    private val repository: CollectionRepository,
    val dataManager: CollectionDataManager
): BaseViewModel(), RefreshableViewModel {

    override val isRefreshing = MutableStateFlow(false)

    override var lastRefreshTimeMillis: Long = 0L

    override suspend fun onDataRequest(isSpecial: Boolean, isPullRefresh: Boolean) {
        repository.getCollections()?.let { collections ->
            dataManager.collections.value = collections
        }
    }

    /** Requests for a removal of collections */
    fun requestCollectionDeletion(uidList: Set<String>) {
        viewModelScope.launch {
            repository.deleteCollections(uidList.toList())
        }
    }
}