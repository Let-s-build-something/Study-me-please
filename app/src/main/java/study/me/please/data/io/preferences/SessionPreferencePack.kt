package study.me.please.data.io.preferences

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.squadris.squadris.utils.DateUtils
import study.me.please.data.io.QuestionMode
import study.me.please.data.room.AppRoomDatabase
import java.io.Serializable
import java.math.BigDecimal
import java.math.MathContext
import java.util.Date
import java.util.UUID

/** Prompt preferences for difficulty */
@Entity(tableName = AppRoomDatabase.ROOM_SESSION_PREFERENCE_PACK_TABLE)
data class SessionPreferencePack (

    /** identification */
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString(),

    /** Preference name for user identification */
    var name: String = "",

    /**
     * Whether we change mode of session to LOCKED just after a correct answer or right away
     */
    @SerializedName("wait_for_correct_answer")
    val waitForCorrectAnswer: SessionPreference = SessionPreference(
        false,
        mapOf(null to ""),
        QuestionMode.LEARNING
    ),

    @SerializedName("manual_validation")
    val manualValidation: SessionPreference = SessionPreference(
        false,
        mapOf(null to ""),
        QuestionMode.TEST
    ),

    @SerializedName("repeat_on_mistake")
    val repeatOnMistake: SessionPreference = SessionPreference(
        false,
        mapOf(null to ""),
        QuestionMode.PRACTICING
    ),

    /** last time this data object was modified */
    @SerializedName("date_modified")
    @ColumnInfo(name = "date_modified")
    var dateModified: Date? = DateUtils.now.time

): Serializable {

    /** anullates all preferences */
    fun clearPreferences() {
        waitForCorrectAnswer.value = false
        manualValidation.value = false
        repeatOnMistake.value = false
    }

    /** sum of all difficulty mode scored */
    val sumScore: Double
        get() {
            var result = 0.0
            mutableListOf<Pair<Int, Int>>().apply {
                if(waitForCorrectAnswer.value) {
                    add(waitForCorrectAnswer.recommendedMode.ordinal to 1)
                }
                if(repeatOnMistake.value) {
                    add(repeatOnMistake.recommendedMode.ordinal to 1)
                }
                if(manualValidation.value) {
                    add(manualValidation.recommendedMode.ordinal to 1)
                }
                val divider = sumOf { it.second.toDouble() }
                if(divider != 0.0) {
                    result = sumOf { it.first.toDouble() }.div(divider)
                }
            }
            return result
        }

    /** Odhadnuty typ na zaklade vybranych moznosti */
    val estimatedMode: QuestionMode
        get() = QuestionMode.values().getOrNull(
            BigDecimal(sumScore).round(MathContext(0)).toInt()
        ) ?: QuestionMode.PRACTICING
}