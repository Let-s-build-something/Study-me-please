package study.me.please.base

import android.annotation.SuppressLint
import android.database.CursorWindow
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.compose.theme.StudyMeAppTheme
import com.squadris.squadris.ext.isTablet
import dagger.hilt.android.AndroidEntryPoint
import study.me.please.base.navigation.NavigationNode.Companion.composableNode
import study.me.please.base.navigation.NavigationRoot
import study.me.please.data.shared.SharedViewModel
import study.me.please.data.state.session.SessionScreen
import study.me.please.hilt.SharedPreferencesModule
import study.me.please.ui.account.AccountDashboardScreen
import study.me.please.ui.collection.CollectionLobbyScreen
import study.me.please.ui.collection.detail.CollectionAboutScreen
import study.me.please.ui.collection.detail.CollectionQuestionsScreen
import study.me.please.ui.collection.detail.questions.detail.QuestionDetailScreen
import study.me.please.ui.home.HomeScreen
import study.me.please.ui.session.detail.SessionDetailScreen
import study.me.please.ui.session.lobby.SessionLobbyScreen
import study.me.please.ui.settings.SettingsScreen
import study.me.please.ui.sign_up.SignUpScreen
import study.me.please.ui.units.CollectionDetailScreen
import java.lang.reflect.Field


@AndroidEntryPoint
class MainActivity: ComponentActivity(), BackboneChannel {

    private val sharedViewModel: SharedViewModel by viewModels()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "DiscouragedPrivateApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            val field: Field = CursorWindow::class.java.getDeclaredField("sCursorWindowSize")
            field.isAccessible = true
            field.set(null, 100 * 1024 * 1024) //the 100MB is the new size
        } catch (e: Exception) {
            e.printStackTrace()
        }
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            // Whether this app is in dark theme
            val isDarkTheme = remember { mutableStateOf(
                sharedViewModel.sharedPreferences.getBoolean(
                    SharedPreferencesModule.SP_IS_DARK_THEME,
                    true
                )
            ) }
            val snackbarHostState = remember { SnackbarHostState() }

            Scaffold(
                snackbarHost = {
                    BaseSnackbarHost(hostState = snackbarHostState)
                }
            ) { _ ->
                StudyMeAppTheme(isDarkTheme = isDarkTheme.value) {
                    val navController = rememberNavController()
                    val isTablet = isTablet(activity = this)

                    CompositionLocalProvider(
                        LocalNavController provides navController,
                        LocalIsTablet provides isTablet,
                        LocalActivity provides this,
                        LocalSnackbarHost provides snackbarHostState,
                        //LocalOverscrollConfiguration provides null,
                    ) {
                        NavHost(
                            modifier = Modifier.background(color = LocalTheme.colors.backgroundLight),
                            navController = navController,
                            startDestination = NavigationRoot.Home.route
                        ) {
                            composableNode(NavigationRoot.Home) { _, _ ->
                                HomeScreen()
                            }
                            composableNode(NavigationRoot.CollectionLobby) { _, _ ->
                                CollectionLobbyScreen()
                            }
                            composableNode(NavigationRoot.UserAccountDashboard) { _, _ ->
                                AccountDashboardScreen()
                            }
                            composableNode(NavigationRoot.Settings) { _, _ ->
                                SettingsScreen(isDarkTheme = isDarkTheme)
                            }
                            composableNode(NavigationRoot.SessionLobby) {  _, _ ->
                                SessionLobbyScreen()
                            }
                            composableNode(NavigationRoot.SessionDetail) { _, argument ->
                                SessionDetailScreen(
                                    title = argument?.toolbarTitle ?: "",
                                    collectionUidList = argument?.collectionUidList,
                                    questionUidList = argument?.questionUidList,
                                    sessionUid = argument?.sessionUid ?: ""
                                )
                            }
                            composableNode(NavigationRoot.CollectionQuestions) { _, argument ->
                                CollectionQuestionsScreen(
                                    title = argument?.toolbarTitle,
                                    collectionUid = argument?.collectionUid ?: ""
                                )
                            }
                            composableNode(NavigationRoot.CollectionAbout) { _, argument ->
                                CollectionAboutScreen(
                                    title = argument?.toolbarTitle,
                                    collectionUid = argument?.collectionUid ?: ""
                                )
                            }
                            composableNode(NavigationRoot.CollectionDetail) { _, argument ->
                                CollectionDetailScreen(
                                    collectionUid = argument?.collectionUid ?: "",
                                    toolbarTitle = argument?.toolbarTitle ?: ""
                                )
                            }
                            composableNode(NavigationRoot.SessionPlay) { _, argument ->
                                SessionScreen(
                                    title = argument?.toolbarTitle ?: "",
                                    isTestingMode = argument?.isTestingMode ?: false,
                                    sessionUid = argument?.sessionUid ?: "",
                                    questionUid = argument?.questionUid ?: "",
                                    questionUids = argument?.questionUids,
                                    collectionUid = argument?.collectionUid ?: ""
                                )
                            }
                            composableNode(NavigationRoot.SignUp) { _, _ ->
                                SignUpScreen()
                            }
                            composableNode(NavigationRoot.QuestionDetail) { _, argument ->
                                QuestionDetailScreen(
                                    questionUid = argument?.questionUid ?: "",
                                    toolbarTitle = argument?.toolbarTitle
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}