package study.me.please.ui.session.detail

import kotlinx.coroutines.flow.MutableStateFlow
import study.me.please.data.io.SessionIO
import study.me.please.data.io.preferences.SessionPreferencePack
import javax.inject.Inject

/** Data storage */
class SessionDetailDataManager @Inject constructor() {

    /** Downloaded session from database */
    val session: MutableStateFlow<SessionIO?> = MutableStateFlow(null)

    /** all existing preferences to choose from if in testing mode */
    val preferencePacks: MutableStateFlow<MutableList<SessionPreferencePack>?> = MutableStateFlow(null)
}