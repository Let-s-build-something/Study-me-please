package study.me.please.base.navigation

/** Navigation destinations within notepad */
sealed class NavigationNotepadScreen(
    override val identification: String,
    override val arguments: List<String> = listOf()
): NavigationDestination(identification, arguments) {

    /** screen for subject detail with user's main notes for certain collection */
    object Paragraph: NavigationNotepadScreen(
        identification = "paragraph",
        arguments = listOf(
            NavigationComponent.PARAGRAPH_UID,
            NavigationComponent.FACT_UID
        )
    ) {
        /** Creates a route for navigation */
        fun makeRoute(
            paragraphUid: String?,
            factUid: String? = null
        ): String {
            return super.createRoute(
                NavigationComponent.PARAGRAPH_UID to paragraphUid,
                NavigationComponent.FACT_UID to factUid
            )
        }
    }

    /** screen for subject detail with user's main notes for certain collection */
    object Unit: NavigationNotepadScreen(
        identification = "unit",
        arguments = listOf(
            NavigationComponent.UNIT_UID
        )
    ) {
        /** Creates a route for navigation */
        fun makeRoute(
            isEmbedded: Boolean,
            unitUid: String
        ): String {
            return super.createRoute(
                NavigationComponent.UNIT_UID to unitUid,
            )
        }
    }
}