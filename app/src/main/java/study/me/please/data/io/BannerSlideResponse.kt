package study.me.please.data.io

/** single banner slide */
data class BannerSlideResponse(

    /** url action after click */
    val actionHref: String = "",

    /** url sources for images */
    val imgUrl: ImageUrl? = ImageUrl(),

    /** duration in milliseconds of how long this slide should be visible for */
    val durationVisibleMillis: Long = 4000L
)
