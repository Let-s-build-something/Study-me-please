package study.me.please.ui.session.lobby

import kotlinx.coroutines.flow.MutableStateFlow
import study.me.please.data.io.SessionIO
import study.me.please.data.io.preferences.SessionPreferencePack
import javax.inject.Inject

/** Data storage */
class SessionLobbyDataManager @Inject constructor() {

    /** Received sessions from database */
    val sessions: MutableStateFlow<List<SessionIO>?> = MutableStateFlow(null)

    /** all existing preferences to choose from if in testing mode */
    val preferencePacks: MutableStateFlow<MutableList<SessionPreferencePack>?> = MutableStateFlow(null)
}