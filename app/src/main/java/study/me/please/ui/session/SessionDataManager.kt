package study.me.please.ui.session

import kotlinx.coroutines.flow.MutableStateFlow
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.SessionIO
import javax.inject.Inject

/** Data storage */
class SessionDataManager @Inject constructor() {

    /** Received collection from database */
    val collection: MutableStateFlow<CollectionIO?> = MutableStateFlow(null)

    /** Received question from database */
    val question: MutableStateFlow<QuestionIO?> = MutableStateFlow(null)

    /** Received session from database */
    val session: MutableStateFlow<SessionIO?> = MutableStateFlow(null)
}