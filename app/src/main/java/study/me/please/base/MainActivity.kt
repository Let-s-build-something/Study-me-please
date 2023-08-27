package study.me.please.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
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
import com.squadris.squadris.compose.theme.AppTheme
import com.squadris.squadris.compose.theme.StudyMeAppTheme
import dagger.hilt.android.AndroidEntryPoint
import study.me.please.base.navigation.CustomizableAppBar
import study.me.please.base.navigation.DefaultAppBarActions
import study.me.please.base.navigation.NavigationComponent
import study.me.please.base.navigation.NavigationDestination
import study.me.please.ui.collection.CollectionScreen
import study.me.please.ui.collection.detail.CreateCollectionScreen
import study.me.please.ui.home.HomeScreen
import study.me.please.ui.home.HomeViewModel

@AndroidEntryPoint
class MainActivity: ComponentActivity(), BackboneChannel {

    private var navController: NavHostController? = null

    private var actions: MutableState<Pair<String, (@Composable RowScope.() -> Unit)>?> = mutableStateOf(null)

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isDarkTheme = homeViewModel.dataManager.isDarkTheme.collectAsState()
            val localFocusManager = LocalFocusManager.current

            StudyMeAppTheme(
                isDarkTheme = isDarkTheme.value
            ) {
                if(navController == null) navController = rememberNavController()
                if(actions.value == null) actions = remember { mutableStateOf(null) }
                val currentDestination = navController?.currentBackStackEntryFlow?.collectAsState(
                    initial = null
                )
                val appBarTitle = remember { mutableStateOf<String?>(null) }
                if(actions.value != null
                    && actions.value?.first != currentDestination?.value?.destination?.route
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
                            modifier = Modifier.background(AppTheme.colors.brandMain),
                            title = currentDestination?.value?.destination?.route?.let { route ->
                                NavigationComponent.getScreenTitle(route)
                            } ?: appBarTitle.value,
                            navigationIcon = currentDestination?.value?.destination?.route?.let { route ->
                                NavigationComponent.getScreenNavigationIcon(route)
                            },
                            actions = actions.value?.second ?: {
                                DefaultAppBarActions(false) { screen ->
                                    navController?.navigate(screen)
                                }
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
                    containerColor = AppTheme.colors.backgroundLight
                ) { contentPadding ->
                    navController?.let { navController ->
                        NavHost(
                            modifier = Modifier
                                .padding(contentPadding),
                            navController = navController,
                            startDestination = NavigationComponent.START_DESTINATION.route
                        ) {
                            composable(NavigationDestination.HOME.route) {
                                HomeScreen(this@MainActivity)
                            }
                            composable(NavigationDestination.COLLECTION.route) {
                                CollectionScreen(
                                    activity = this@MainActivity,
                                    navController = navController
                                )
                            }
                            composable(
                                NavigationDestination.COLLECTION_DETAIL.route,
                                arguments = listOf(
                                    navArgument(
                                        NavigationComponent.COLLECTION_DETAIL_UID
                                    ) {
                                        nullable = true
                                        defaultValue = null
                                    },
                                    navArgument(
                                        NavigationComponent.COLLECTION_DETAIL_NAME
                                    ) {}
                                )
                            ) { backStackEntry ->
                                appBarTitle.value = backStackEntry.arguments?.getString(
                                    NavigationComponent.COLLECTION_DETAIL_NAME
                                )
                                CreateCollectionScreen(
                                    collectionUid = backStackEntry.arguments?.getString(
                                        NavigationComponent.COLLECTION_DETAIL_UID
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onBackPressedExec() {

    }
}