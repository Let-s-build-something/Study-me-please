package study.me.please.data.io

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import study.me.please.data.room.AppRoomDatabase

/** Prompt preference for specific behaviour */
data class UserPromptPreference (

    /**
     * whether feature is on
     */
    var value: Boolean = false,

    /**
     * Explanation of what the feature does and how does it affect the flow depending on the question type.
     * If null, the message is generic to all types
     */
    @SerializedName("text_description")
    val textDescription: Map<QuestionPromptType?, String> = mapOf(),

    /**
     * What mode this feature is recommended/intended for.
     * If null, it is not specific to any
     */
    @SerializedName("recommended_mode")
    val recommendedMode: QuestionMode? = null,
)