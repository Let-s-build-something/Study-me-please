package study.me.please.ui.session.lobby

import androidx.lifecycle.viewModelScope
import com.squadris.squadris.compose.base.BaseViewModel
import com.squadris.squadris.utils.RefreshableViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import study.me.please.data.io.session.SessionIO
import javax.inject.Inject

@HiltViewModel
class SessionLobbyViewModel @Inject constructor(
    private val repository: SessionLobbyRepository,
    private val dataManager: SessionLobbyDataManager
): BaseViewModel(), RefreshableViewModel {

    override val isRefreshing: MutableStateFlow<Boolean> = MutableStateFlow(false)
    override var lastRefreshTimeMillis: Long = 0L

    /** Received sessions from database */
    val sessions: StateFlow<List<SessionIO>?> = dataManager.sessions.asStateFlow()

    override suspend fun onDataRequest(isSpecial: Boolean, isPullRefresh: Boolean) {
        repository.getAllSessions()?.let {
            dataManager.sessions.value = it
        }
    }

    /** saves a sessions */
    private fun saveSession(session: SessionIO) {
        viewModelScope.launch {
            repository.saveSession(session)
        }
    }

    /** Requests for a download of all sessions */
    fun requestAllSessions() {
        viewModelScope.launch {
            repository.getAllSessions()?.let {
                dataManager.sessions.value = it
            }
        }
    }

    /** Requests for a download of all sessions */
    fun addNewSession() {
        viewModelScope.launch {
            val newSession = SessionIO()
            dataManager.sessions.update {
                it?.toMutableList()?.apply {
                    add(0, newSession)
                }
            }
            saveSession(newSession)
        }
    }

    /** requests a session list deletion */
    fun requestSessionsDeletion(uids: Set<String>) {
        viewModelScope.launch {
            repository.deleteSessions(uids)
            dataManager.sessions.update { list ->
                list?.toMutableList()?.apply {
                    removeAll { uids.contains(it.uid) }
                }
            }
        }
    }
}