package study.me.please.ui.session.lobby

import kotlinx.coroutines.flow.MutableStateFlow
import study.me.please.data.io.session.SessionIO
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.ui.components.preference_chooser.PreferencePackDataManager
import javax.inject.Inject

/** Data storage */
class SessionLobbyDataManager @Inject constructor(): PreferencePackDataManager {

    /** Received sessions from database */
    val sessions: MutableStateFlow<List<SessionIO>?> = MutableStateFlow(null)

    /** all existing preferences to choose from if in testing mode */
    override val preferencePacks: MutableStateFlow<List<SessionPreferencePack>?> = MutableStateFlow(null)
}