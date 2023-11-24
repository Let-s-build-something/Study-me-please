package study.me.please.ui.collection

import androidx.lifecycle.viewModelScope
import com.squadris.squadris.utils.DateUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import study.me.please.base.BaseViewModel
import study.me.please.data.io.session.SessionIO
import javax.inject.Inject

/** ViewModel containing behavior for refreshing data */
interface RefreshableViewModel {

    companion object {
        /** minimum amount of millis required for refresh to take place */
        const val MINIMUM_REFRESH_DELAY = 2000L
    }

    /** whether current data is refreshing or not */
    val isRefreshing: MutableStateFlow<Boolean>

    /** time in millisecond of the last refresh */
    var lastRefreshTimeMillis: Long

    /** sets the value or refreshing */
    suspend fun CoroutineScope.setRefreshing(refreshing: Boolean) {
        if(refreshing) {
            lastRefreshTimeMillis = DateUtils.now.timeInMillis
            isRefreshing.value = true
        }else {
            delay(kotlin.math.max(
                DateUtils.now.timeInMillis.minus(lastRefreshTimeMillis),
                MINIMUM_REFRESH_DELAY
            ))
            isRefreshing.value = false
        }
    }

    /** requests for completely new data batch */
    fun requestData(isSpecial: Boolean, isPullRefresh: Boolean = false)
}

@HiltViewModel
class CollectionViewModel @Inject constructor(
    private val repository: CollectionRepository,
    val dataManager: CollectionDataManager
): BaseViewModel(), RefreshableViewModel {

    override val isRefreshing = MutableStateFlow(false)

    override var lastRefreshTimeMillis: Long = 0L

    override fun requestData(isSpecial: Boolean, isPullRefresh: Boolean) {
        viewModelScope.launch {
            if(isPullRefresh) setRefreshing(true)
            repository.getCollections()?.let { collections ->
                dataManager.collections.value = collections
            }
            if(isPullRefresh) setRefreshing(false)
        }
    }

    /** Requests all collections */
    fun requestSessions() {
        viewModelScope.launch {
            repository.getSessions()?.let { sessions ->
                dataManager.sessions.value = sessions
            }
        }
    }

    /** Requests for a removal of collections */
    fun requestCollectionDeletion(uidList: Set<String>) {
        viewModelScope.launch {
            repository.deleteCollections(uidList.toList())
        }
    }

    /** Requests a save for sessions */
    fun requestSessionsSave(sessions: List<SessionIO>) {
        viewModelScope.launch {
            repository.saveSessions(sessions)
        }
    }
}