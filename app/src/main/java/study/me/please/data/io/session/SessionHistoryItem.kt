package study.me.please.data.io.session

import androidx.room.PrimaryKey
import study.me.please.data.io.QuestionIO
import java.util.UUID

/** history item for statistics or browsing history */
data class SessionHistoryItem(

    /** question information */
    @Deprecated("This should not be carried with it, only an UID and saved within question table." +
            " TODO consider how questions will be saved if they will no longer be the primary source for Examinations (Units will)" +
            " POSSIBLE SOLUTION: having ImportedSource together with generatingGoal is the same as having the question!")
    val questionIO: QuestionIO? = null,

    /** index of this question */
    val index: Int = -1,

    /** list of selected asnwers' identifiers */
    val answers: List<SessionAnswerValidation> = listOf(),

    /** What time it took for the user to answer this question */
    var timeToAnswer: Long = 0L,

    /** start of this question */
    val timeOfStart: Long? = null,

    /** What time it took for the user to continue in questioning */
    var timeToContinue: Long? = null,

    /** Whether this question was only for repetition */
    val isRepetition: Boolean = false,

    /** Whether this question was used to repeat */
    var wasRepeated: Boolean = false,

    /** identifier */
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString()
)
