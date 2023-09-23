package study.me.please.ui.session.lobby

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import study.me.please.base.BaseViewModel
import study.me.please.data.io.SessionIO
import javax.inject.Inject

@HiltViewModel
class SessionLobbyViewModel @Inject constructor(
    private val repository: SessionLobbyRepository,
    val dataManager: SessionLobbyDataManager
): BaseViewModel() {

    /** Requests for a download of all sessions */
    fun requestAllSessions() {
        viewModelScope.launch {
            repository.getAllSessions()?.let {
                dataManager.sessions.value = it
            }
        }
    }

    /** saves a sessions */
    fun saveSession(session: SessionIO) {
        viewModelScope.launch {
            repository.saveSession(session)
        }
    }
}