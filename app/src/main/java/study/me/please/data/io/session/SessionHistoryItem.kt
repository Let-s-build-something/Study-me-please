package study.me.please.data.io.session

import androidx.room.PrimaryKey
import study.me.please.data.io.QuestionIO
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
    val timeToAnswer: Long,

    /** start of this question */
    val timeOfStart: Long? = null,

    /** What time it took for the user to continue in questioning */
    var timeToContinue: Long? = null,

    /** Whether this question was only for repetition */
    val wasRepeated: Boolean = false,

    /** identifier */
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString()
)
