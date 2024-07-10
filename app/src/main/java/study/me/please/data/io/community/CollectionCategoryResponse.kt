package study.me.please.data.io.community

/** Category for categorizing collections */
data class CollectionCategoryResponse(

    /** List of all available categories */
    val categories: List<CollectionCategoryIO> = listOf()
)