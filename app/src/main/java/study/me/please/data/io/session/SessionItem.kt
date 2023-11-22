package study.me.please.data.io.session

import study.me.please.data.io.QuestionIO
import java.util.UUID

/** Item of a session with all relevant information to one questioning screen */
data class SessionItem(
    /** whether current item is historic - aka simulation of a [SessionScreenMode.LOCKED] */
    val isHistory: Boolean = false,

    /** information about historic question and answers */
    val historyItem: SessionHistoryItem? = null,

    /** current question to be answsered */
    val data: QuestionIO? = null,

    /** list of correct answers. Either from history or current question */
    val correctAnswers: List<String?>,

    /** whether this item's source is repetition */
    val isRepeated: Boolean = false
) {
    /** unique identifier */
    val uid: String
        get() = data?.uid ?: historyItem?.uid ?: UUID.randomUUID().toString()
}