package study.me.please.base.navigation

import androidx.navigation.NavController
import study.me.please.base.navigation.NavigationComponent.TOOLBAR_TITLE
import study.me.please.base.navigation.NavigationComponent.COLLECTION_UID
import study.me.please.base.navigation.NavigationComponent.IS_TESTING_MODE
import study.me.please.base.navigation.NavigationComponent.QUESTION_UID
import study.me.please.base.navigation.NavigationComponent.SESSION_UID
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
                .putNavigationArgument(COLLECTION_UID, collectionUid ?: "")
        )
    }

    /**
     * Navigates to session to create a new one or return to already existing
     * @param sessionUid identifier for retrieving existing session. Meaning it's backed in a database
     * @param questionUid identifier for question that will be tested
     * @param collectionUid identifier for collection that will be tested
     * @param isTesting whether user wants to only test functionality, texts, visibility of elements etc.
     *                  it has more options for testing and focuses on functionality discovery
     */
    fun navigateToSession(
        navController: NavController,
        toolbarTitle: String,
        sessionUid: String? = null,
        questionUid: String? = null,
        collectionUid: String? = null,
        isTesting: Boolean = false
    ) {
        navController.navigate(
            NavigationDestination.SESSION.route
                .putNavigationArgument(TOOLBAR_TITLE, toolbarTitle)
                .putNavigationArgument(COLLECTION_UID, collectionUid ?: "")
                .putNavigationArgument(SESSION_UID, sessionUid ?: "")
                .putNavigationArgument(QUESTION_UID, questionUid ?: "")
                .putNavigationArgument(IS_TESTING_MODE, isTesting.toString())
        )
    }
}