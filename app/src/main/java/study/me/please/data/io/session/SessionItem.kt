package study.me.please.data.io.session

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.room.Ignore
import study.me.please.data.io.QuestionAnswerIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.state.session.SessionScreenMode
import java.util.UUID

/** Item of a session with all relevant information to one questioning screen */
data class SessionItem(
    /** whether current item is historic - aka simulation of a [SessionScreenMode.LOCKED] */
    val isHistory: Boolean = false,

    /** information about historic question and answers */
    val historyItem: SessionHistoryItem? = null,

    /** current question to be answsered */
    val data: QuestionIO? = null,

    /** whether this item's source is repetition */
    var isRepetition: Boolean = false
) {
    /** unique identifier */
    @get:Ignore
    val uid: String
        get() = data?.uid ?: historyItem?.uid ?: UUID.randomUUID().toString()

    /** current screen mode */
    @Ignore
    val mode: MutableState<SessionScreenMode> = mutableStateOf(SessionScreenMode.REGULAR)

    /** List of all current validations */
    @Ignore
    val validations = mutableStateListOf<SessionAnswerValidation>()

    /** List of all currently selected answers */
    @Ignore
    val selectedAnswers = mutableStateListOf<QuestionAnswerIO>()
}