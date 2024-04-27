package study.me.please.data.io.preferences

import com.google.gson.annotations.SerializedName
import study.me.please.data.io.QuestionMode

/** Prompt preference for specific behaviour */
data class SessionPreference (

    /**
     * whether feature is on
     */
    var value: Boolean = false,

    /**
     * What mode this feature is recommended/intended for.
     * If null, it is not specific to any
     */
    @SerializedName("recommended_mode")
    val recommendedMode: QuestionMode
)