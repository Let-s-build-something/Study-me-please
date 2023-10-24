package study.me.please.ui.session

import kotlinx.coroutines.flow.MutableStateFlow
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.SessionIO
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.ui.components.preference_chooser.PreferencePackDataManager
import javax.inject.Inject

/** Data storage */
class SessionDataManager @Inject constructor(): PreferencePackDataManager {

    /** Received collection from database */
    val collection: MutableStateFlow<CollectionIO?> = MutableStateFlow(null)

    /** Received session from database */
    val session: MutableStateFlow<SessionIO?> = MutableStateFlow(null)

    /** Received session preferences from database */
    val preferencePack: MutableStateFlow<SessionPreferencePack?> = MutableStateFlow(null)

    /** full list of questions for the session screen */
    val questions: MutableStateFlow<List<QuestionIO>?> = MutableStateFlow(null)

    /** all existing preferences to choose from if in testing mode */
    override val preferencePacks: MutableStateFlow<List<SessionPreferencePack>?> = MutableStateFlow(null)
}