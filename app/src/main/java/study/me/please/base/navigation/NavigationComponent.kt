package study.me.please.base.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import study.me.please.R
import study.me.please.base.navigation.NavigationComponent.addNavigationArgument
import study.me.please.base.navigation.NavigationComponent.putNavigationArgument

enum class NavigationDestination(val route: String) {
    HOME("screen_home"),
    SETTINGS("screen_settings"),
    COLLECTION_LOBBY("screen_collection_lobby"),
    SESSION_LOBBY("screen_session_lobby"),
    SESSION_DETAIL(
        "screen_session_detail"
            .addNavigationArgument(NavigationComponent.COLLECTION_UID_LIST)
            .addNavigationArgument(NavigationComponent.QUESTION_UID_LIST)
            .addNavigationArgument(NavigationComponent.SESSION_UID)
            .addNavigationArgument(NavigationComponent.TOOLBAR_TITLE)
    ),
    SESSION(
        "screen_session"
            .addNavigationArgument(NavigationComponent.TOOLBAR_TITLE)
            .addNavigationArgument(NavigationComponent.COLLECTION_UID)
            .addNavigationArgument(NavigationComponent.SESSION_UID)
            .addNavigationArgument(NavigationComponent.QUESTION_UID)
            .addNavigationArgument(NavigationComponent.QUESTION_UIDS)
            .addNavigationArgument(NavigationComponent.IS_TESTING_MODE)
    ),
    /** Screen for creating collection or editing existing collection */
    COLLECTION_DETAIL(
        "screen_create_collection"
            .addNavigationArgument(NavigationComponent.COLLECTION_UID)
            .addNavigationArgument(NavigationComponent.TOOLBAR_TITLE)
    )
}

/** Helper object for Jetpack Compose navigation component  */
object NavigationComponent {
    val START_DESTINATION = NavigationDestination.HOME

    /** collection identifier */
    const val COLLECTION_UID = "collectionUid"

    /** question identifier list split by a comma */
    const val QUESTION_UID_LIST = "questionUidList"

    /** collection identifier list split by a comma */
    const val COLLECTION_UID_LIST = "collectionUidList"

    /** argument identifier for a question */
    const val QUESTION_UID = "questionUid"

    /** argument identifiers for multiple questions */
    const val QUESTION_UIDS = "questionUids"

    /** argument identifier for a session */
    const val SESSION_UID = "sessionUid"

    /** argument identifier for a testing mode flag */
    const val IS_TESTING_MODE = "isTestingMode"

    /** toolbar title */
    const val TOOLBAR_TITLE = "toolbarTitle"

    /** whether new item should be create the moment screen opens */
    const val CREATE_NEW_ITEM = "createNewItem"

    /** adds argument by composable navigation syntax */
    fun String.addNavigationArgument(argumentName: String): String {
        return this.plus("?$argumentName={$argumentName}")
    }

    /** Puts an argument to a navigation address */
    fun String.putNavigationArgument(argumentName: String, argumentValue: String?): String {
        return if(argumentValue == null) this else this.replace("{$argumentName}", argumentValue)
    }

    @Composable
    fun getScreenTitle(route: String): String? {
        return when(route) {
            NavigationDestination.HOME.route -> stringResource(id = R.string.home_screen_title)
            NavigationDestination.COLLECTION_LOBBY.route -> stringResource(
                id = R.string.screen_collection_title
            )
            NavigationDestination.SESSION_LOBBY.route -> stringResource(
                id = R.string.screen_session_lobby_title
            )
            NavigationDestination.SETTINGS.route -> stringResource(
                id = R.string.screen_settings_title
            )
            else -> null
        }
    }

    /**
     * Returns navigation icon [Pair.first] based on the given route [route],
     * paired with its contentDescription [Pair.second]
     *
     * If returned value is null, there should be no icon
     */
    @Composable
    fun getScreenNavigationIcon(route: String): Pair<ImageVector, String> {
        return when(route) {
            NavigationDestination.HOME.route -> Icons.Outlined.Home to stringResource(
                id = R.string.home_screen_title
            )
            NavigationDestination.COLLECTION_DETAIL.route,
            NavigationDestination.SESSION.route -> Icons.Outlined.Close to stringResource(
                id = R.string.navigate_close
            )
            else -> Icons.Outlined.ArrowBackIosNew to stringResource(
                id = R.string.navigate_back
            )
        }
    }

    /** in special cases we want something such as home button at thee front of appbar */
    fun popBackStackToRoute(route: String): String? {
        return when(route) {
            else -> null
        }
    }
}