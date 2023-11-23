package study.me.please.base.navigation

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

sealed class NavigationDestination(

    /** unique identifier for the scope of the whole navigation tree */
    val identification: String,

    /** list of all arguments that can be passed into this destination */
    val arguments: List<String> = listOf()
) {
    /** web url prefix for this app */
    protected val uriPrefix = ""

    /** Pathway to the specific screen */
    val route: String
        get() {
            var route = identification
            arguments.forEach {
                route += "?$it={$it}"
            }
            return route
        }

    /** List of all possible deep-links for this destination */
    open val deepLink: List<NavDeepLink>
        get() = mutableListOf<NavDeepLink>().apply {
            var route = uriPrefix.plus(identification)
            arguments.forEach {
                route += "/{$it}"
                add(navDeepLink {
                    uriPattern = route
                })
            }
        }

    /** List of all possible arguments for this destination */
    open val navArguments: List<NamedNavArgument>
        get() = mutableListOf<NamedNavArgument>().apply {
            arguments.forEach { argument ->
                add(navArgument(argument) {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = null
                })
            }
        }

    /** Assembles a route with given arguments */
    fun createRoute(vararg argumentValues: Pair<String, Any?>): String {
        var route = route
        argumentValues.forEach {
            route = route.replace(
                "{${it.first}}",
                URLEncoder.encode(
                    when(it.second) {
                        is SnapshotStateList<*> -> {
                            (it.second as? SnapshotStateList<*>)?.toList()?.joinToString(",") ?: it.first
                        }
                        is List<*> -> {
                            (it.second as? List<*>)?.joinToString(",") ?: it.first
                        }
                        is Array<*> -> {
                            (it.second as? Array<*>)?.toList()?.joinToString(",") ?: it.first
                        }
                        else -> it.second?.toString() ?: it.first
                    },
                    StandardCharsets.UTF_8
                )
            )
        }
        return route
    }

    /** home page screen */
    object Home: NavigationDestination(identification = "home")

    /** screen for seeing and modifying app and user settings */
    object Settings: NavigationDestination(identification = "settings")

    /** list of all collections screen */
    object CollectionLobby: NavigationDestination(identification = "collection_lobby")

    /** list of all sessions screen */
    object SessionLobby: NavigationDestination(identification = "session_lobby")

    /** screen with concrete session detail */
    object SessionDetail: NavigationDestination(
        identification = "session_detail",
        arguments = listOf(
            NavigationComponent.COLLECTION_UID_LIST,
            NavigationComponent.QUESTION_UID_LIST,
            NavigationComponent.SESSION_UID,
            NavigationComponent.TOOLBAR_TITLE
        )
    )

    /** screen with concrete collection detail */
    object CollectionDetail: NavigationDestination(
        identification = "collection_detail",
        arguments = listOf(
            NavigationComponent.COLLECTION_UID,
            NavigationComponent.TOOLBAR_TITLE
        )
    )

    /** screen for session - questioning play-through */
    object SessionPlay: NavigationDestination(
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
}