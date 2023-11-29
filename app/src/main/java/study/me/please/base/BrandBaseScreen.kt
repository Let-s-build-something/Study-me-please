package study.me.please.base

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.FabPosition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import study.me.please.base.navigation.DefaultAppBarActions
import study.me.please.base.navigation.NavIconType
import study.me.please.base.navigation.NavigationDestination

/**
 * Most simple screen for implementing bussiness level logic
 */
@Composable
fun BrandBaseScreen(
    modifier: Modifier = Modifier,
    navIconType: NavIconType = NavIconType.BACK,
    title: String? = null,
    subtitle: String? = null,
    onBackPressed: () -> Boolean = { true },
    actionIcons: (@Composable RowScope.() -> Unit)? = null,
    appBarVisible: Boolean = true,
    containerColor: Color = Color.Transparent,
    contentColor: Color = Color.Transparent,
    floatingActionButtonPosition: FabPosition = FabPosition.End,
    floatingActionButton: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit,
) {
    val navController = LocalNavController.current
    val currentEntry = navController?.currentBackStackEntryAsState()

    BaseScreen(
        modifier = modifier,
        title = title,
        subtitle = subtitle,
        onBackPressed = onBackPressed,
        actionIcons = actionIcons ?: {
            DefaultAppBarActions(
                currentRoute = currentEntry?.value?.destination?.route,
                actionNavigation = { route ->
                    navController?.navigate(route)
                }
            )
        },
        appBarVisible = appBarVisible,
        containerColor = containerColor,
        contentColor = contentColor,
        onNavigationIconClick = if(navIconType == NavIconType.HOME) {
            {
                navController?.popBackStack(NavigationDestination.Home.route, inclusive = false)
            }
        } else null,
        floatingActionButtonPosition = floatingActionButtonPosition,
        floatingActionButton = floatingActionButton,
        navigationIcon = navIconType.imageVector,
        content = content
    )
}