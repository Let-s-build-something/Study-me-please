package study.me.please.ui.session.detail

import kotlinx.coroutines.flow.MutableStateFlow
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.data.io.session.SessionIO
import study.me.please.data.state.session.QuestionModule
import study.me.please.ui.components.preference_chooser.PreferencePackDataManager
import javax.inject.Inject

/** Data storage */
class SessionDetailDataManager @Inject constructor(): PreferencePackDataManager {

    /** Downloaded session from database */
    val session: MutableStateFlow<SessionIO?> = MutableStateFlow(null)

    /** Questions inside current session */
    val questions: MutableStateFlow<List<QuestionIO>?> = MutableStateFlow(null)

    /** Collections inside current session */
    val collections: MutableStateFlow<List<CollectionIO>?> = MutableStateFlow(null)

    /** information about current session module - containing all major session state information */
    val questionModule: MutableStateFlow<QuestionModule?> = MutableStateFlow(null)

    /** all existing preferences to choose from if in testing mode */
    override val preferencePacks: MutableStateFlow<List<SessionPreferencePack>?> = MutableStateFlow(null)
}