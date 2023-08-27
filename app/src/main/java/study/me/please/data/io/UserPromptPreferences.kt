package study.me.please.data.io

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import study.me.please.data.room.AppRoomDatabase
import java.io.Serializable
import java.util.EnumMap

//TODO presaved preference list that could be named (test preferences, practise preferences, etc.)
//TODO then sessions have their own preferences and collections have their own recommended preferences
/** Prompt preferences for difficulty */
@Entity(tableName = AppRoomDatabase.ROOM_USER_PROMPT_PREFERENCES_TABLE)
data class UserPromptPreferences (

    /** user uid associated with preferences */
    @PrimaryKey
    val userUid: String = "",

    /**
     * Whether the question counts as answered when user answers
     * In multi-choice [QuestionPromptType.TEXT_QUESTION] we wait for user to make a mistake or to answer everything correctly
     * ideal for practicing
     */
    @SerializedName("finish_on_user_response")
    val finishOnUserResponse: UserPromptPreference = UserPromptPreference(
        false,
        mapOf(null to "Whether question counts as answered the moment user responds." +
            " In case of multi-choice text prompt, system waits for user to make either a mistake or answer correctly."),
        QuestionMode.PRACTICING
    ),
): Serializable {

    /** Odhadnuty typ na zaklade vybranych moznosti */
    val estimatedMode: QuestionMode?
        get() {
            val countMap: EnumMap<QuestionMode, Int> = EnumMap(QuestionMode::class.java)
            finishOnUserResponse.recommendedMode?.let { recommendedMode ->
                countMap[recommendedMode] = (countMap[recommendedMode] ?: 0) + 1
            }
            return countMap.toList().sortedByDescending { it.second }?.firstOrNull()?.first
        }
}