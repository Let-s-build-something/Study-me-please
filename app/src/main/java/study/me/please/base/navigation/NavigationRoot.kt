package study.me.please.base.navigation

import kotlin.reflect.KClass

sealed class NavigationRoot<T>(
    override val identification: String,
    override val argumentKClass: KClass<T>? = null
): NavigationNode<T>(identification, argumentKClass) where T: Any {

    /** home page screen */
    object Home: NavigationScreen(identification = "home")

    /** screen for seeing and modifying app and user settings */
    object Settings: NavigationScreen(identification = "settings")

    /** list of all collections screen */
    object CollectionLobby: NavigationScreen(identification = "collection_lobby")

    /** User profile dashboard with action */
    object UserAccountDashboard: NavigationScreen(identification = "account")

    /** list of all sessions screen */
    object SessionLobby: NavigationScreen(identification = "session_lobby")

    /** screen with concrete session detail */
    object SessionDetail: NavigationRoot<SessionDetail.SessionDetailArgument>(
        identification = "sessions/detail",
        argumentKClass = SessionDetailArgument::class
    ) {
        /** Argument for session detail screen */
        data class SessionDetailArgument(

            /** unique identifier for the collection */
            val collectionUidList: List<String> = listOf(),

            /** unique identifier for the session */
            val questionUidList: List<String> = listOf(),

            /** unique identifier for the session */
            val sessionUid: String = "",

            /** title for the toolbar */
            val toolbarTitle: String
        )
    }

    /** screen with concrete collection detail */
    object CollectionQuestions: NavigationRoot<CollectionQuestions.CollectionQuestionsArgument>(
        identification = "collection/question",
        argumentKClass = CollectionQuestionsArgument::class
    ) {

        /** Argument for collection detail screen */
        data class CollectionQuestionsArgument(

            /** unique identifier for the collection */
            val collectionUid: String = "",

            /** title for the toolbar */
            val toolbarTitle: String = ""
        )
    }

    /** screen with collection detail general info */
    object CollectionAbout: NavigationRoot<CollectionQuestions.CollectionQuestionsArgument>(
        identification = "collection/about",
        argumentKClass = CollectionQuestions.CollectionQuestionsArgument::class
    )

    /** screen for community section */
    object Community: NavigationScreen(identification = "community")

    /** screen for signing up */
    object SignUp: NavigationScreen(identification = "sign-up")

    /** screen for session - questioning play-through */
    object SessionPlay: NavigationRoot<SessionPlay.SessionPlayArgument>(
        identification = "session/play",
        argumentKClass = SessionPlayArgument::class
    ) {

        /** Argument for session play screen */
        data class SessionPlayArgument(
            /** title for the toolbar */
            val toolbarTitle: String,

            /** unique identifier for the collection */
            val collectionUid: String = "",

            /** unique identifier for the session */
            val sessionUid: String = "",

            /** unique identifier for the question */
            val questionUid: String = "",

            /** list of unique identifiers for the questions */
            val questionUids: List<String> = listOf(),

            /** flag for testing mode */
            val isTestingMode: Boolean = false
        )
    }

    /** screen for editable question detail */
    object QuestionDetail: NavigationRoot<QuestionDetail.QuestionDetailArgument>(
        identification = "questions/detail",
        argumentKClass = QuestionDetailArgument::class
    ) {

        /** Argument for question detail screen */
        data class QuestionDetailArgument(
            /** title for the toolbar */
            val toolbarTitle: String,

            /** unique identifier for the question */
            val questionUid: String
        )
    }

    /** screen for units with user's main notes for certain collection */
    object CollectionDetail: NavigationRoot<CollectionDetail.CollectionDetailArgument>(
        identification = "collections/units",
        argumentKClass = CollectionDetailArgument::class
    ) {
        /** Argument for collection detail screen */
        data class CollectionDetailArgument(
            /** title for the toolbar */
            val toolbarTitle: String = "",

            /** unique identifier for the collection */
            val collectionUid: String = ""
        )
    }

    /** screen for units with user's main notes for certain collection */
    object PublicCollection: NavigationRoot<PublicCollection.PublicCollectionArgument>(
        identification = "community/collections",
        argumentKClass = PublicCollectionArgument::class
    ) {
        /** Argument for collection detail screen */
        data class PublicCollectionArgument(
            /** title for the toolbar */
            val collectionName: String,

            /** unique identifier for the collection */
            val collectionUid: String
        )
    }
}