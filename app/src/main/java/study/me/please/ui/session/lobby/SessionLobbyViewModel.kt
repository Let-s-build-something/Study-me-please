package study.me.please.ui.session.lobby

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import study.me.please.base.BaseViewModel
import study.me.please.data.io.SessionIO
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.ui.components.preference_chooser.PreferencePackDataManager
import study.me.please.ui.components.preference_chooser.PreferencePackRepository
import study.me.please.ui.components.preference_chooser.PreferencePackViewModel
import javax.inject.Inject

@HiltViewModel
class SessionLobbyViewModel @Inject constructor(
    private val repository: SessionLobbyRepository,
    private val dataManager: SessionLobbyDataManager
): BaseViewModel(), PreferencePackViewModel {

    override val coroutineScope: CoroutineScope = viewModelScope

    override val preferencePackDataManager: PreferencePackDataManager = dataManager

    override val preferencePackRepository: PreferencePackRepository = repository

    /** all existing preferences to choose from if in testing mode */
    override val preferencePacks: StateFlow<List<SessionPreferencePack>?> = dataManager.preferencePacks.asStateFlow()

    /** Received sessions from database */
    val sessions: StateFlow<List<SessionIO>?> = dataManager.sessions.asStateFlow()

    /** saves a sessions */
    fun saveSession(session: SessionIO) {
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