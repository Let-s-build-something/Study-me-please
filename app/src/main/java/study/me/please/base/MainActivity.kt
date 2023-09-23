package study.me.please.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.compose.theme.StudyMeAppTheme
import dagger.hilt.android.AndroidEntryPoint
import study.me.please.base.navigation.CustomizableAppBar
import study.me.please.base.navigation.DefaultAppBarActions
import study.me.please.base.navigation.NavigationComponent
import study.me.please.base.navigation.NavigationDestination
import study.me.please.hilt.SharedPreferencesModule
import study.me.please.ui.collection.CollectionLobbyScreen
import study.me.please.ui.collection.detail.CollectionDetailScreen
import study.me.please.ui.collection.settings.SettingsScreen
import study.me.please.ui.collection.settings.SettingsViewModel
import study.me.please.ui.home.HomeScreen
import study.me.please.ui.session.SessionScreen
import study.me.please.ui.session.lobby.SessionLobbyScreen

@AndroidEntryPoint
class MainActivity: ComponentActivity(), BackboneChannel {

    private var navController: NavHostController? = null

    private var actions: MutableState<Pair<NavigationDestination, (@Composable RowScope.() -> Unit)>?>
        = mutableStateOf(null)

    private val settingsViewModel: SettingsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isSystemInDarkTheme = isSystemInDarkTheme()
            /** Whether this app is in dark theme */
            val isDarkTheme = remember { mutableStateOf(
                settingsViewModel.sharedPreferences.getBoolean(
                    SharedPreferencesModule.SP_IS_DARK_THEME,
                    isSystemInDarkTheme
                )
            ) }
            val localFocusManager = LocalFocusManager.current

            StudyMeAppTheme(isDarkTheme = isDarkTheme.value) {
                if(navController == null) navController = rememberNavController()
                if(actions.value == null) actions = remember { mutableStateOf(null) }
                val currentDestination = navController?.currentBackStackEntryFlow?.collectAsState(
                    initial = null
                )
                val appBarTitle = remember { mutableStateOf<String?>(null) }
                if(actions.value != null
                    && actions.value?.first?.route != currentDestination?.value?.destination?.route
                ) {
                    actions.value = null
                }

                Scaffold(
                    modifier = Modifier
                        .pointerInput(Unit) {
                            detectTapGestures(onTap = {
                                localFocusManager.clearFocus()
                            })
                        },
                    topBar = {
                        CustomizableAppBar(
                            modifier = Modifier.background(LocalTheme.colors.brandMain),
                            title = currentDestination?.value?.destination?.route?.let { route ->
                                NavigationComponent.getScreenTitle(route)
                            } ?: appBarTitle.value,
                            navigationIcon = currentDestination?.value?.destination?.route?.let { route ->
                                NavigationComponent.getScreenNavigationIcon(route)
                            },
                            actions = {
                                DefaultAppBarActions(
                                    isUserSignedIn = false,
                                    route = currentDestination?.value?.destination?.route
                                ) { screen ->
                                    navController?.navigate(screen)
                                }
                                actions.value?.second?.invoke(this)
                            },
                            onNavigationIconClick = {
                                currentDestination?.value?.destination?.route?.let { route ->
                                    NavigationComponent.popBackStackToRoute(route)?.let { popTo ->
                                        navController?.popBackStack(
                                            route = popTo,
                                            inclusive = false
                                        )
                                    }.takeIf { navController?.popBackStack() ?: false }
                                }
                            }
                        )
                    },
                    containerColor = LocalTheme.colors.backgroundLight
                ) { contentPadding ->
                    navController?.let { navController ->
                        NavHost(
                            modifier = Modifier
                                .padding(contentPadding),
                            navController = navController,
                            startDestination = NavigationComponent.START_DESTINATION.route
                        ) {
                            composable(NavigationDestination.HOME.route) {
                                HomeScreen(
                                    navController = navController,
                                    activity = this@MainActivity
                                )
                            }
                            composable(NavigationDestination.COLLECTION_LOBBY.route) { backStackEntry ->
                                CollectionLobbyScreen(
                                    activity = this@MainActivity,
                                    navController = navController
                                )
                                backStackEntry.arguments?.remove(
                                    NavigationComponent.CREATE_NEW_ITEM
                                )
                            }
                            composable(NavigationDestination.SETTINGS.route) {
                                SettingsScreen(
                                    isDarkTheme = isDarkTheme.value,
                                    viewModel = settingsViewModel
                                ) { newValue ->
                                    isDarkTheme.value = newValue
                                }
                            }
                            composable(
                                NavigationDestination.SESSION_LOBBY.route,
                                arguments = listOf(
                                    navArgument(
                                        NavigationComponent.CREATE_NEW_ITEM
                                    ) {},
                                    navArgument(
                                        NavigationComponent.COLLECTION_UID
                                    ) { nullable = true; defaultValue = null },
                                    navArgument(
                                        NavigationComponent.SESSION_UID
                                    ) { nullable = true; defaultValue = null }
                                )
                            ) { backStackEntry ->
                                SessionLobbyScreen(
                                    navController = navController,
                                    changeActionBar = { newActions ->
                                        actions.value = NavigationDestination.SESSION_LOBBY to newActions
                                    },
                                    collectionUid = backStackEntry.arguments?.getString(
                                        NavigationComponent.COLLECTION_UID
                                    ),
                                    sessionUid = backStackEntry.arguments?.getString(
                                        NavigationComponent.SESSION_UID
                                    ),
                                    createNewItem = backStackEntry.arguments?.getString(
                                        NavigationComponent.CREATE_NEW_ITEM
                                    ).toBoolean()
                                )
                            }
                            composable(
                                NavigationDestination.COLLECTION_DETAIL.route,
                                arguments = listOf(
                                    navArgument(
                                        NavigationComponent.COLLECTION_UID
                                    ) {
                                        nullable = true
                                        defaultValue = null
                                    },
                                    navArgument(
                                        NavigationComponent.TOOLBAR_TITLE
                                    ) {}
                                )
                            ) { backStackEntry ->
                                appBarTitle.value = backStackEntry.arguments?.getString(
                                    NavigationComponent.TOOLBAR_TITLE
                                )
                                CollectionDetailScreen(
                                    navController = navController,
                                    collectionUid = backStackEntry.arguments?.getString(
                                        NavigationComponent.COLLECTION_UID
                                    ),
                                    changeActionBar = { newActions ->
                                        actions.value = NavigationDestination.COLLECTION_DETAIL to newActions
                                    }
                                )
                            }
                            composable(
                                NavigationDestination.SESSION.route,
                                arguments = listOf(
                                    navArgument(
                                        NavigationComponent.COLLECTION_UID
                                    ) { nullable = true; defaultValue = null },
                                    navArgument(
                                        NavigationComponent.SESSION_UID
                                    ) { nullable = true; defaultValue = null },
                                    navArgument(
                                        NavigationComponent.QUESTION_UID
                                    ) { nullable = true; defaultValue = null },
                                    navArgument(
                                        NavigationComponent.QUESTION_UIDS
                                    ) { nullable = true; defaultValue = null },
                                    navArgument(
                                        NavigationComponent.TOOLBAR_TITLE
                                    ) {},
                                    navArgument(
                                        NavigationComponent.IS_TESTING_MODE
                                    ) {}
                                )
                            ) { backStackEntry ->
                                appBarTitle.value = backStackEntry.arguments?.getString(
                                    NavigationComponent.TOOLBAR_TITLE
                                )
                                SessionScreen(
                                    isTestingMode = backStackEntry.arguments?.getString(
                                        NavigationComponent.IS_TESTING_MODE
                                    ).toBoolean(),
                                    sessionUid = backStackEntry.arguments?.getString(
                                        NavigationComponent.SESSION_UID
                                    ),
                                    questionUid = backStackEntry.arguments?.getString(
                                        NavigationComponent.QUESTION_UID
                                    ),
                                    questionUids = backStackEntry.arguments?.getString(
                                        NavigationComponent.QUESTION_UIDS
                                    )?.split(","),
                                    collectionUid = backStackEntry.arguments?.getString(
                                        NavigationComponent.COLLECTION_UID
                                    ),
                                    changeActionBar = { newActions ->
                                        actions.value = NavigationDestination.SESSION to newActions
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}