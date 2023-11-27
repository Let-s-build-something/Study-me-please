package study.me.please.data.io.session

import java.io.Serializable

/** Question item in the session mode to be remembered */
data class QuestionItem(

    /** unique identifier */
    val uid: String = "",

    /** whether this item is just for repetition */
    val isRepetition: Boolean = false
): Serializable