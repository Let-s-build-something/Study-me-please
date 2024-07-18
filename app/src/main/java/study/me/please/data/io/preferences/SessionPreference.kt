package study.me.please.data.io.preferences

/** Prompt preference for specific behaviour */
data class SessionPreference (

    /**
     * whether feature is on
     */
    var value: Boolean = false,

    /** unique identifier of this preference */
    val uid: String
)