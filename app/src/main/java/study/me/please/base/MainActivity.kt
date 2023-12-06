package study.me.please.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.compose.theme.StudyMeAppTheme
import com.squadris.squadris.ext.isTablet
import dagger.hilt.android.AndroidEntryPoint
import study.me.please.base.navigation.NavigationComponent
import study.me.please.base.navigation.NavigationComponent.getArgument
import study.me.please.base.navigation.NavigationDestination
import study.me.please.hilt.SharedPreferencesModule
import study.me.please.ui.collection.CollectionLobbyScreen
import study.me.please.ui.collection.detail.CollectionDetailScreen
import study.me.please.ui.collection.detail.questions.detail.QuestionDetailScreen
import study.me.please.ui.collection.detail.subjects.SubjectsHostScreen
import study.me.please.ui.home.HomeScreen
import study.me.please.ui.session.play.SessionScreen
import study.me.please.ui.session.detail.SessionDetailScreen
import study.me.please.ui.session.lobby.SessionLobbyScreen
import study.me.please.ui.settings.SettingsScreen
import study.me.please.ui.settings.SettingsViewModel

@AndroidEntryPoint
class MainActivity: ComponentActivity(), BackboneChannel {

    private val settingsViewModel: SettingsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            // Whether this app is in dark theme
            val isDarkTheme = remember { mutableStateOf(
                settingsViewModel.sharedPreferences.getBoolean(
                    SharedPreferencesModule.SP_IS_DARK_THEME,
                    true
                )
            ) }

            StudyMeAppTheme(isDarkTheme = isDarkTheme.value) {
                val navController = rememberNavController()
                val isTablet = isTablet(activity = this)

                CompositionLocalProvider(
                    LocalNavController provides navController,
                    LocalIsTablet provides isTablet
                ) {
                    NavHost(
                        modifier = Modifier.background(color = LocalTheme.colors.backgroundLight),
                        navController = navController,
                        startDestination = NavigationDestination.Home.route
                    ) {
                        composable(NavigationDestination.Home.route) {
                            HomeScreen()
                        }
                        composable(NavigationDestination.CollectionLobby.route) { backStackEntry ->
                            CollectionLobbyScreen()
                            backStackEntry.arguments?.remove(
                                NavigationComponent.CREATE_NEW_ITEM
                            )
                        }
                        composable(NavigationDestination.Settings.route) {
                            SettingsScreen(
                                isDarkTheme = isDarkTheme.value,
                                viewModel = settingsViewModel
                            ) { newValue ->
                                isDarkTheme.value = newValue
                            }
                        }
                        composable(NavigationDestination.SessionLobby.route) { backStackEntry ->
                            SessionLobbyScreen(
                                createNewItem = backStackEntry.getArgument(NavigationComponent.CREATE_NEW_ITEM).toBoolean()
                            )
                        }
                        composable(
                            NavigationDestination.SessionDetail.route,
                            arguments = NavigationDestination.SessionDetail.navArguments
                        ) { backStackEntry ->
                            SessionDetailScreen(
                                title = backStackEntry.getArgument(NavigationComponent.TOOLBAR_TITLE),
                                collectionUidList = backStackEntry.getArgument(NavigationComponent.COLLECTION_UID_LIST)?.split(","),
                                questionUidList = backStackEntry.getArgument(NavigationComponent.QUESTION_UID_LIST)?.split(","),
                                sessionUid = backStackEntry.getArgument(NavigationComponent.SESSION_UID)
                            )
                        }
                        composable(
                            NavigationDestination.CollectionDetail.route,
                            arguments = NavigationDestination.CollectionDetail.navArguments
                        ) { backStackEntry ->
                            CollectionDetailScreen(
                                title = backStackEntry.getArgument(NavigationComponent.TOOLBAR_TITLE),
                                collectionUid = backStackEntry.getArgument(NavigationComponent.COLLECTION_UID)
                            )
                        }
                        composable(
                            NavigationDestination.SessionPlay.route,
                            arguments = NavigationDestination.SessionPlay.navArguments
                        ) { backStackEntry ->
                            SessionScreen(
                                title = backStackEntry.getArgument(NavigationComponent.TOOLBAR_TITLE),
                                isTestingMode = backStackEntry.getArgument(NavigationComponent.IS_TESTING_MODE).toBoolean(),
                                sessionUid = backStackEntry.getArgument(NavigationComponent.SESSION_UID),
                                questionUid = backStackEntry.getArgument(NavigationComponent.QUESTION_UID),
                                questionUids = backStackEntry.getArgument(NavigationComponent.QUESTION_UID_LIST)?.split(","),
                                collectionUid = backStackEntry.getArgument(NavigationComponent.COLLECTION_UID)
                            )
                            backStackEntry.arguments?.remove(NavigationComponent.QUESTION_UID_LIST)
                            backStackEntry.arguments?.remove(NavigationComponent.COLLECTION_UID)
                        }
                        composable(
                            NavigationDestination.QuestionDetail.route,
                            arguments = NavigationDestination.QuestionDetail.navArguments
                        ) { backStackEntry ->
                            backStackEntry.getArgument(NavigationComponent.QUESTION_UID)?.let { uid ->
                                QuestionDetailScreen(
                                    questionUid = uid,
                                    toolbarTitle = backStackEntry.getArgument(NavigationComponent.TOOLBAR_TITLE)
                                )
                            }
                        }
                        composable(
                            NavigationDestination.Subjects.route,
                            arguments = NavigationDestination.Subjects.navArguments
                        ) { backStackEntry ->
                            backStackEntry.getArgument(NavigationComponent.COLLECTION_UID)?.let { collectionUid ->
                                SubjectsHostScreen(
                                    collectionUid = collectionUid,
                                    toolbarTitle = backStackEntry.getArgument(
                                        NavigationComponent.TOOLBAR_TITLE
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}