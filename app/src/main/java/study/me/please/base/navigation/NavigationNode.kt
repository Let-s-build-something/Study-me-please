package study.me.please.base.navigation

import android.util.Log
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.io.Serializable
import java.math.BigDecimal
import java.net.URLDecoder
import java.net.URLEncoder
import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlin.reflect.full.isSubclassOf
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor

/** Default empty navigation argument */
open class NavigationArgument

/** Shortcut for a default navigation destination with no argument */
typealias NavigationScreen = NavigationNode<NavigationArgument>

/** Most basic form of navigation */
abstract class NavigationNode<T>(

    /** unique identifier for the scope of the whole navigation tree */
    open val identification: String,

    open val argumentKClass: KClass<T>? = null
) where T: Any {
    /** web url prefix for this app */
    protected val uriPrefix = ""

    private val constructorParameters
        get() = argumentKClass?.primaryConstructor?.parameters

    /** Pathway to the specific screen */
    val route: String
        get() {
            var route = identification

            constructorParameters?.forEach { parameter ->
                route += "?${parameter.name}={${parameter.name}}"
            }
            return route
        }

    /** List of all possible deep-links for this destination */
    open val deepLinks: List<NavDeepLink>
        get() = mutableListOf<NavDeepLink>().apply {
            var route = uriPrefix.plus(identification)

            constructorParameters?.forEach { parameter ->
                route += "?${parameter.name}={${parameter.name}}"
            }
            add(navDeepLink {
                uriPattern = route
            })
        }

    /** List of all possible arguments for this destination */
    open val navArguments: List<NamedNavArgument>
        get() = mutableListOf<NamedNavArgument>().apply {
            constructorParameters?.forEach { parameter ->
                parameter.name?.let { name ->
                    add(
                        navArgument(name) {
                            type = NavType.StringType
                            nullable = true
                            defaultValue = null
                        }
                    )
                }
            }
        }

    /** Assembles a route with given argument data class */
    open fun createRoute(data: T): String {
        var route = route
        constructorParameters?.forEach { parameter ->
            val property = argumentKClass?.memberProperties?.find { it.name == parameter.name }
            route = route.replace(
                "{${parameter.name}}",
                parseArgumentToString(property?.get(data))
            )
        }
        return route
    }

    /** Assembles a data argument class from the route arguments */
    fun createArgumentInstance(navBackStackEntry: NavBackStackEntry): T? {
        return if(navBackStackEntry.arguments?.isEmpty == false) {
            val arguments = mutableListOf<Any?>()
            val constructor = argumentKClass?.primaryConstructor
            Log.d("kostka_test", "createArgumentInstance, constructorParameters: $constructorParameters")

            val isOptionalConstructor = constructor?.parameters?.all { it.isOptional } ?: false
            val constructorInstance = if(isOptionalConstructor) {
                constructor?.callBy(emptyMap())
            }else null

            constructor?.parameters?.forEach { parameter ->
                val defaultValue = if(isOptionalConstructor) {
                    parameter.name?.let {
                        constructorInstance?.javaClass?.getDeclaredField(it)?.apply {
                            isAccessible = true
                        }?.get(constructorInstance)
                    }
                }else null

                parameter.name?.let { name ->
                    arguments.add(
                        parseStringToArgument(
                            value = navBackStackEntry.getArgument(name),
                            type = parameter.type,
                            defaultValue = defaultValue
                        )
                    )
                }
            }
            argumentKClass?.primaryConstructor?.call(*arguments.toTypedArray())
        }else null
    }

    /** Parses given argument to string */
    private fun parseArgumentToString(value: Any?): String {
        return URLEncoder.encode(
            when(value) {
                is Enum<*> -> value.name
                is List<*> -> value.joinToString(separator = ",")
                is Set<*> -> value.joinToString(separator = ",")
                else -> value?.toString() ?: ""
            },
            "UTF8"
        )
    }

    /** Parses string to given argument type with a default as a fallback */
    private fun parseStringToArgument(
        value: String?,
        type: KType,
        defaultValue: Any?
    ): Any? {
        return when(val classifier = type.classifier) {
            Boolean::class -> value?.toBooleanStrictOrNull() ?: defaultValue ?: false
            Int::class -> value?.toIntOrNull() ?: defaultValue ?: 0
            Float::class -> value?.toFloatOrNull() ?: defaultValue ?: 0f
            Double::class -> value?.toDoubleOrNull() ?: defaultValue ?: 0.0
            Long::class -> value?.toLongOrNull() ?: defaultValue ?: 0L
            BigDecimal::class -> value?.toBigDecimalOrNull() ?: defaultValue ?: BigDecimal.ZERO
            List::class, Set::class -> {
                val listType = type.arguments.firstOrNull()?.type
                (if(listType != null) {
                    value?.split(",")?.map {
                        parseStringToArgument(
                            value = it,
                            type = listType,
                            defaultValue = null
                        )
                    }?.toList()
                }else null) ?: defaultValue ?: emptyList<Any>()
            }
            String::class -> value ?: defaultValue ?: ""
            else -> {
                val kClass = classifier as? KClass<*>
                if(kClass?.isSubclassOf(Enum::class) == true) {
                    (kClass.java.enumConstants?.firstOrNull {
                        it.toString() == value
                    } as? Enum<*>) ?: defaultValue ?: kClass.java.enumConstants?.firstOrNull()
                }else value ?: defaultValue
            }
        }
    }

    companion object {

        /** Return decoded argument from navigation arguments bundle */
        fun NavBackStackEntry.getArgument(name: String): String? {
            val argument = arguments?.getString(name)

            return if(argument.isNullOrEmpty()) null
            else {
                URLDecoder.decode(
                    argument.replace("%(?![0-9a-fA-F]{2})".toRegex(), "%25")
                        .replace("//\\+".toRegex(), "%2B"),
                    "UTF8"
                )
            }
        }

        /** Simplified version of [composable] method for navigation tree */
        fun <T: Any> NavGraphBuilder.composableNode(
            navigationNode: NavigationNode<T>,
            enterTransition: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)? = null,
            exitTransition: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)? = null,
            popEnterTransition: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)? = enterTransition,
            popExitTransition: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)? = exitTransition,
            content: @Composable AnimatedContentScope.(NavBackStackEntry, T?) -> Unit
        ) {
            composable(
                route = navigationNode.route,
                arguments = navigationNode.navArguments,
                deepLinks = navigationNode.deepLinks,
                enterTransition = enterTransition,
                exitTransition = exitTransition,
                popEnterTransition = popEnterTransition,
                popExitTransition = popExitTransition
            ) { navBackStackEntry ->
                this.content(
                    navBackStackEntry,
                    navigationNode.createArgumentInstance(navBackStackEntry)
                )
            }
        }

        /** Navigates to the destination with given argument */
        fun <A> NavController.navigate(
            navigationNode: NavigationNode<A>,
            data: A
        ) where A: Any {
            navigate(navigationNode.createRoute(data))
        }

        /**
         * Navigates to the destination with given argument and expect a result
         */
        fun <A, R> NavController.navigateForResult(
            navigationNode: NavigationNode<A>,
            data: A,
            coroutineScope: CoroutineScope,
            onResult: (R?) -> Unit
        ) where A: Any, R: Serializable? {
            coroutineScope.launch {
                this@navigateForResult.currentBackStackEntry?.savedStateHandle?.getStateFlow<R?>(
                    navigationNode.route,
                    initialValue = null
                )?.collectLatest { result ->
                    onResult(result)
                }
            }
            navigate(navigationNode.createRoute(data))
        }

        /**
         * Sets a result for the destination and closes it if needed
         */
        fun <R>NavController.setResult(
            result: Any,
            close: Boolean = false
        ) {
            currentDestination?.route?.let { route ->
                previousBackStackEntry?.savedStateHandle?.set(route, result)
                if(close) popBackStack(route, inclusive = true)
            }
        }
    }
}