package study.me.please.data.io.session

import androidx.room.PrimaryKey
import study.me.please.data.io.ImportedSource
import java.util.UUID

/** history item for statistics or browsing history */
data class SessionHistoryItem(

    /** source of this item */
    val importedSource: ImportedSource? = null,

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
