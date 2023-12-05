package study.me.please.data.io

/** Response with data and its additional metadata */
data class BaseResponse<D> (

    /** Data key to this response */
    val data: D? = null,

    /** Whether this data is loading */
    val isLoading: Boolean = data != null,

    /** Error response message to the user */
    val errorMessage: String? = null
)