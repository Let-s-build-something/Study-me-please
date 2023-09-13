package study.me.please.data.io

import androidx.room.Entity
import study.me.please.data.room.AppRoomDatabase
import java.io.Serializable
import java.util.UUID

enum class AnswerPrefix {
    ALPHABET,
    NUMERIC,
    NONE,
    CUSTOM
}

data class AnswerPreferences(
    val prefixType: AnswerPrefix = AnswerPrefix.NONE,
    val customPrefix: String? = null
): Serializable

/**
 * Data storage for a questioning session
 */
@Entity(tableName = AppRoomDatabase.ROOM_SESSION_TABLE)
data class SessionIO(
    val uid: String = UUID.randomUUID().toString(),
    val preference: UserPromptPreference = UserPromptPreference(),
    val answerPreferences: AnswerPreferences = AnswerPreferences()
): Serializable