package study.me.please.data.io

/** Response data structure of breeds list */
data class BreedsListResponse(

    /** Content - list of breeds */
    val message: Map<String, List< String>> = mapOf(),

    /** Response status type */
    val status: String
)