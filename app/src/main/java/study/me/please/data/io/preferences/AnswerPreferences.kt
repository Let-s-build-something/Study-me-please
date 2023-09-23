package study.me.please.data.io.preferences

import java.io.Serializable

data class AnswerPreferences(
    val prefixType: AnswerPrefix = AnswerPrefix.NONE,
    val customPrefix: String? = null
): Serializable