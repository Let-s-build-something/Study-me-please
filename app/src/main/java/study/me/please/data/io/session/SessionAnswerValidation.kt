package study.me.please.data.io.session

import androidx.room.PrimaryKey
import java.util.UUID

/** Information about validation of an answer */
data class SessionAnswerValidation(
    /** Identifier */
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString(),

    /** Whether answer is correct */
    val isCorrect: Boolean = false
)