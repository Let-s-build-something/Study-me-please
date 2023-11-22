package study.me.please.data.io.session

import androidx.room.PrimaryKey

/** Information about validation of an answer */
data class SessionAnswerValidation(
    /** Identifier */
    @PrimaryKey
    val uid: String,
    
    /** Whether answer is correct */
    val isCorrect: Boolean
)