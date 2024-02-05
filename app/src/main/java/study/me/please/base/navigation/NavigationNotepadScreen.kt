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
            NavigationComponent.IS_EMBEDDED,
            NavigationComponent.PARAGRAPH_UID,
            NavigationComponent.PARAGRAPH_SOURCE
        )
    ) {
        /** Creates a route for navigation */
        fun makeRoute(
            isEmbedded: Boolean,
            paragraphUid: String?,
            importedSource: String?
        ): String {
            return super.createRoute(
                NavigationComponent.IS_EMBEDDED to isEmbedded.toString(),
                NavigationComponent.PARAGRAPH_UID to paragraphUid,
                NavigationComponent.PARAGRAPH_SOURCE to importedSource
            )
        }
    }

    /** screen for subject detail with user's main notes for certain collection */
    object Unit: NavigationNotepadScreen(
        identification = "unit",
        arguments = listOf(
            NavigationComponent.IS_EMBEDDED,
            NavigationComponent.UNIT_UID
        )
    ) {
        /** Creates a route for navigation */
        fun makeRoute(
            isEmbedded: Boolean,
            unitUid: String
        ): String {
            return super.createRoute(
                NavigationComponent.IS_EMBEDDED to isEmbedded.toString(),
                NavigationComponent.UNIT_UID to unitUid,
            )
        }
    }
}