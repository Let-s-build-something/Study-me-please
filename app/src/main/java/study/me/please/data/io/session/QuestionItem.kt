package study.me.please.data.io.session

import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.UUID

/** Question item in the session mode to be remembered */
data class QuestionItem(

    /** unique identifier */
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString(),

    /** whether this item is just for repetition */
    val isRepetition: Boolean = false
): Serializable