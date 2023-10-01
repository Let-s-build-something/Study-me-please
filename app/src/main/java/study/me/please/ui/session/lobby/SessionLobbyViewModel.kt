package study.me.please.ui.session.lobby

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import study.me.please.base.BaseViewModel
import study.me.please.data.io.SessionIO
import study.me.please.data.io.preferences.SessionPreferencePack
import javax.inject.Inject

@HiltViewModel
class SessionLobbyViewModel @Inject constructor(
    private val repository: SessionLobbyRepository,
    val dataManager: SessionLobbyDataManager
): BaseViewModel() {

    init {
        requestAllPreferences()
    }

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

    /** requests for all preferences */
    private fun requestAllPreferences() {
        viewModelScope.launch {
            repository.getAllPreferences()?.let { preferencePacks ->
                dataManager.preferencePacks.value = preferencePacks.toMutableList()
            }
        }
    }

    /** requests a save of preference pack */
    fun requestPreferencePackSave(preferencePack: SessionPreferencePack?) {
        if(preferencePack == null) return
        viewModelScope.launch {
            repository.savePreferencePack(preferencePack)
        }
    }

    /** requests a save of preference pack */
    fun requestPreferencePackDelete(uid: String?) {
        if(uid == null) return
        viewModelScope.launch {
            repository.deletePreferencePack(uid)
        }
    }

    /** requests a session list deletion */
    fun requestSessionsDeletion(uids: Set<String>) {
        viewModelScope.launch {
            repository.deleteSessions(uids)
        }
    }
}