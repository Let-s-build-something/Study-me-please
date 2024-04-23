package study.me.please.ui.home

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import study.me.please.base.BaseViewModel
import study.me.please.ui.collection.RefreshableViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository,
    val dataManager: HomeDataManager
): BaseViewModel(), RefreshableViewModel {

    companion object {
        /** How many items in each category will be downloaded */
        private const val ITEMS_LIMIT = 5
    }

    override val isRefreshing: MutableStateFlow<Boolean> = MutableStateFlow(false)
    override var lastRefreshTimeMillis: Long = 0L

    override suspend fun onDataRequest(isSpecial: Boolean, isPullRefresh: Boolean) {
        repository.getLatestCollections(ITEMS_LIMIT)?.let { collections ->
            dataManager.collections.value = collections
        }
        repository.getLatestSessions(ITEMS_LIMIT)?.let { sessions ->
            dataManager.sessions.value = sessions
        }
    }
}