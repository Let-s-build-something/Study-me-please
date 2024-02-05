package study.me.please.base.navigation

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

abstract class NavigationDestination(

    /** unique identifier for the scope of the whole navigation tree */
    open val identification: String,

    /** list of all arguments that can be passed into this destination */
    open val arguments: List<String> = listOf()
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
    open val deepLinks: List<NavDeepLink>
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
    open fun createRoute(vararg argumentValues: Pair<String, Any?>): String {
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
                    StandardCharsets.UTF_8.toString()
                )
            )
        }
        return route
    }
}