package study.me.please.data.io

/** list of banners */
data class ImageUrl(

    /** low resolution image for fast loading */
    val lowResUrl: String = "",

    /** medium resolution for mobile devices */
    val medResUrl: String = "",

    /** medium resolution for tablet-resolution devices */
    val highResUrl: String = ""
)
