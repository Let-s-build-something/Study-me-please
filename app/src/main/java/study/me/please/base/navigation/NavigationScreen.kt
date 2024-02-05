package study.me.please.base.navigation

sealed class NavigationScreen(
    override val identification: String,
    override val arguments: List<String> = listOf()
): NavigationNotepadScreen(identification, arguments) {

    /** home page screen */
    object Home: NavigationScreen(identification = "home")

    /** screen for seeing and modifying app and user settings */
    object Settings: NavigationScreen(identification = "settings")

    /** list of all collections screen */
    object CollectionLobby: NavigationScreen(identification = "collection_lobby")

    /** list of all sessions screen */
    object SessionLobby: NavigationScreen(identification = "session_lobby")

    /** screen with concrete session detail */
    object SessionDetail: NavigationScreen(
        identification = "session_detail",
        arguments = listOf(
            NavigationComponent.COLLECTION_UID_LIST,
            NavigationComponent.QUESTION_UID_LIST,
            NavigationComponent.SESSION_UID,
            NavigationComponent.TOOLBAR_TITLE
        )
    )

    /** screen with concrete collection detail */
    object CollectionDetail: NavigationScreen(
        identification = "collection_detail",
        arguments = listOf(
            NavigationComponent.COLLECTION_UID,
            NavigationComponent.TOOLBAR_TITLE
        )
    )

    /** screen for session - questioning play-through */
    object SessionPlay: NavigationScreen(
        identification = "session_play",
        arguments = listOf(
            NavigationComponent.TOOLBAR_TITLE,
            NavigationComponent.COLLECTION_UID,
            NavigationComponent.SESSION_UID,
            NavigationComponent.QUESTION_UID,
            NavigationComponent.QUESTION_UID_LIST,
            NavigationComponent.IS_TESTING_MODE
        )
    )

    /** screen for editable question detail */
    object QuestionDetail: NavigationScreen(
        identification = "question_detail",
        arguments = listOf(
            NavigationComponent.TOOLBAR_TITLE,
            NavigationComponent.QUESTION_UID
        )
    )

    /** screen for units with user's main notes for certain collection */
    object Units: NavigationScreen(
        identification = "units",
        arguments = listOf(
            NavigationComponent.TOOLBAR_TITLE,
            NavigationComponent.COLLECTION_UID
        )
    )
}