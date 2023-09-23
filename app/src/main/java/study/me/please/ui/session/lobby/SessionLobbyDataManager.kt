package study.me.please.ui.session.lobby

import kotlinx.coroutines.flow.MutableStateFlow
import study.me.please.data.io.SessionIO
import javax.inject.Inject

/** Data storage */
class SessionLobbyDataManager @Inject constructor() {

    /** Received sessions from database */
    val sessions: MutableStateFlow<List<SessionIO>?> = MutableStateFlow(null)
}