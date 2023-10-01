package study.me.please.base.navigation

import androidx.navigation.NavController
import study.me.please.base.navigation.NavigationComponent.TOOLBAR_TITLE
import study.me.please.base.navigation.NavigationComponent.COLLECTION_UID
import study.me.please.base.navigation.NavigationComponent.COLLECTION_UID_LIST
import study.me.please.base.navigation.NavigationComponent.CREATE_NEW_ITEM
import study.me.please.base.navigation.NavigationComponent.IS_TESTING_MODE
import study.me.please.base.navigation.NavigationComponent.QUESTION_UID
import study.me.please.base.navigation.NavigationComponent.QUESTION_UIDS
import study.me.please.base.navigation.NavigationComponent.QUESTION_UID_LIST
import study.me.please.base.navigation.NavigationComponent.SESSION_UID
import study.me.please.base.navigation.NavigationComponent.addNavigationArgument
import study.me.please.base.navigation.NavigationComponent.putNavigationArgument

/**
 * Tools for navigating to different screens
 */
object NavigationUtils {

    /**
     * Navigates to a specific collection
     * @param toolbarTitle title for toolbar
     * @param collectionUid identifier for retrieving data for displayed collection
     */
    fun navigateToCollectionDetail(
        navController: NavController,
        toolbarTitle: String,
        collectionUid: String? = null
    ) {
        navController.navigate(
            NavigationDestination.COLLECTION_DETAIL.route
                .putNavigationArgument(TOOLBAR_TITLE, toolbarTitle)
                .putNavigationArgument(COLLECTION_UID, collectionUid)
        )
    }

    /**
     * Navigates to a specific collection
     * @param toolbarTitle title for toolbar
     * @param sessionUid identifier for retrieving data for displayed session
     * @param collectionUidList list of collection identifiers that should assemble a new collection
     * @param collectionUidList list of question identifiers that should assemble a new collection
     */
    fun navigateToSessionDetail(
        navController: NavController,
        toolbarTitle: String,
        sessionUid: String? = null,
        collectionUidList: List<String>? = null,
        questionUidList: List<String>? = null
    ) {
        navController.navigate(
            NavigationDestination.SESSION_DETAIL.route
                .putNavigationArgument(COLLECTION_UID_LIST, collectionUidList?.joinToString(","))
                .putNavigationArgument(QUESTION_UID_LIST, questionUidList?.joinToString(","))
                .putNavigationArgument(SESSION_UID, sessionUid)
                .putNavigationArgument(TOOLBAR_TITLE, toolbarTitle)
        )
    }

    /**
     * Navigates to session to create a new one or return to already existing
     * @param sessionUid identifier for retrieving existing session. Meaning it's backed in a database
     * @param questionUid identifier for question that will be tested
     * @param questionUid identifiers for questions that will be tested
     * @param collectionUid identifier for collection that will be tested
     * @param isTesting whether user wants to only test functionality, texts, visibility of elements etc.
     *                  it has more options for testing and focuses on functionality discovery
     */
    fun navigateToSession(
        navController: NavController,
        toolbarTitle: String,
        sessionUid: String? = null,
        questionUid: String? = null,
        questionUids: List<String>? = null,
        collectionUid: String? = null,
        isTesting: Boolean = false
    ) {
        navController.navigate(
            NavigationDestination.SESSION.route
                .putNavigationArgument(TOOLBAR_TITLE, toolbarTitle)
                .putNavigationArgument(COLLECTION_UID, collectionUid)
                .putNavigationArgument(SESSION_UID, sessionUid)
                .putNavigationArgument(QUESTION_UID, questionUid)
                .putNavigationArgument(QUESTION_UIDS, questionUids?.joinToString(","))
                .putNavigationArgument(IS_TESTING_MODE, isTesting.toString())
        )
    }

    /**
     * Navigates to collection lobby screen
     */
    fun navigateToCollectionLobby(
        navController: NavController,
    ) {
        navController.navigate(
            NavigationDestination.COLLECTION_LOBBY.route
        )
    }

    /**
     * Navigates to session lobby screen
     */
    fun navigateToSessionLobby(navController: NavController) {
        navController.navigate(NavigationDestination.SESSION_LOBBY.route)
    }
}