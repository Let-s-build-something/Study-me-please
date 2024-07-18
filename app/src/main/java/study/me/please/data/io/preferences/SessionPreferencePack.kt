package study.me.please.data.io.preferences

import androidx.annotation.StringRes
import androidx.room.Ignore
import com.google.firebase.firestore.Exclude
import study.me.please.R
import study.me.please.data.io.QuestionMode
import java.io.Serializable
import java.util.UUID

/** Preference type for a session */
enum class PreferenceOption(@StringRes val stringRes: Int) {
    /** Whether we change mode of session to LOCKED just after a correct answer or right away */
    WaitForCorrectAnswer(R.string.preference_wait_for_correct_answer_desc),

    /** whether items should be validated manually by the user themselves */
    ManualValidation(R.string.preference_validate_manually_desc),

    /** whether user should learn from the mistakes gradually */
    RepeatOnMistake(R.string.preference_repeat_on_mistake_desc);
}

/** Prompt preferences for difficulty */
data class SessionPreferencePack (

    /** identification */
    val uid: String = UUID.randomUUID().toString(),

    /** unique identifiers of objects to be included in the session */
    val selectedUidList: List<String> = emptyList(),

    /** Map of all the preferences pair by type and value */
    val preferences: HashMap<PreferenceOption, Boolean> = hashMapOf(
        PreferenceOption.WaitForCorrectAnswer to false,
        PreferenceOption.ManualValidation to false,
        PreferenceOption.RepeatOnMistake to true
    )

): Serializable {

    /** updates the object within */
    @Ignore
    @Exclude
    fun update(newMode: QuestionMode) = this.copy(preferences = newMode.optionsMap)

    /** Odhadnuty typ na zaklade vybranych moznosti */
    @get:Exclude
    @get:Ignore
    val estimatedMode: QuestionMode
        get() {
            val selected = preferences.filter { it.value }
            var highestMode = QuestionMode.PRACTICING to 0

            QuestionMode.entries.forEach {
                val count = it.preferenceOptions.count { selected.contains(it) }
                if(count > highestMode.second) {
                    highestMode = it to count
                }
            }
            return highestMode.first
        }

    override fun toString(): String {
        return "{" +
                "selectedUidList: $selectedUidList," +
                "preferences: ${preferences.map { it.key to it.value }}," +
                "}"
    }
}