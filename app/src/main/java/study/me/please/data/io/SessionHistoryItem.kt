package study.me.please.data.io

import androidx.room.PrimaryKey
import java.util.UUID

/** history item for statistics or browsing history */
data class SessionHistoryItem(

    /** question information */
    val questionIO: QuestionIO,

    /** index of this question */
    val index: Int,

    /** list of selected asnwers' identifiers */
    val answers: List<SessionAnswerValidation>,

    /** What time it took for the user to answer this question */
    val timeElapsed: Long,

    /** identifier */
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString()
)
