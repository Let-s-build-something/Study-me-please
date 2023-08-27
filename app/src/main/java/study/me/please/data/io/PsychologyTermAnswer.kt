package study.me.please.data.io

import java.util.UUID

data class PsychologyTermAnswer (

    /** Answer text to be displayed */
    val text: String = "",

    /** Whether this answer is the correct one */
    var isCorrect: Boolean = false,

    /** What is the reasoniung behind this answer being wrong/correct */
    val explanationMessage: String = "",

    /** unique identifier */
    val uid: String = UUID.randomUUID().toString(),

    /** explanation image */
    val imageExplanationUrl: String = ""
)