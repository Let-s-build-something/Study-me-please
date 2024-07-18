package study.me.please.ui.session.play

import kotlinx.coroutines.flow.MutableStateFlow
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.data.io.session.SessionIO
import study.me.please.data.state.session.QuestionModule
import javax.inject.Inject

/** Data storage */
class SessionDataManager @Inject constructor() {

    /** Received collection from database */
    val collections: MutableStateFlow<List<CollectionIO>?> = MutableStateFlow(null)

    /** Received session from database */
    val session: MutableStateFlow<SessionIO?> = MutableStateFlow(null)

    /** information about current session module - containing all major session state information */
    val questionModule: MutableStateFlow<QuestionModule?> = MutableStateFlow(null)

    /** Received session preferences from database */
    val preferencePack: MutableStateFlow<SessionPreferencePack?> = MutableStateFlow(null)

    /** full list of questions for the session screen */
    val questions: MutableStateFlow<List<QuestionIO>?> = MutableStateFlow(null)
}