package study.me.please.base

import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.NavController
import com.squadris.squadris.compose.theme.LocalTheme
import study.me.please.base.navigation.CustomizableAppBar

/** current navigation tree and controller */
val LocalNavController = staticCompositionLocalOf<NavController?> { null }

/** current snackbar host for showing snackbars */
val LocalSnackbarHost = staticCompositionLocalOf<SnackbarHostState?> { null }

/** whether device is a tablet or not */
val LocalIsTablet = staticCompositionLocalOf<Boolean> { false }

/**
 * Most basic all-in-one implementation of a screen with action bar, without bottom bar
 * @param navigationIcon what type of navigation icon screen should have
 * @param title capital title of the screen
 * @param subtitle lower case subtitle of the screen
 * @param actionIcons right side actions to be displayed
 * @param content screen content under the action bar
 */
@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    navigationIcon: Pair<ImageVector, String>? = null,
    title: String? = null,
    subtitle: String? = null,
    onBackPressed: () -> Boolean = { true },
    actionIcons: @Composable RowScope.() -> Unit = {},
    appBarVisible: Boolean = true,
    containerColor: Color = Color.Transparent,
    contentColor: Color = Color.Transparent,
    floatingActionButtonPosition: FabPosition = FabPosition.End,
    floatingActionButton: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit,
) {
    val navController = LocalNavController.current
    val focusManager = LocalFocusManager.current
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current
    val snackbarHostState = SnackbarHostState()

    BackHandler(navController?.previousBackStackEntry != null) {
        if(onBackPressed()) navController?.popBackStack()
    }

    CompositionLocalProvider(
        LocalSnackbarHost provides snackbarHostState
    ) {
        Scaffold(
            modifier = modifier
                .pointerInput(Unit) {
                    detectTapGestures(onTap = {
                        focusManager.clearFocus()
                    })
                },
            snackbarHost = {
                SnackbarHost(snackbarHostState)
            },
            containerColor = containerColor,
            contentColor = contentColor,
            floatingActionButton = floatingActionButton,
            floatingActionButtonPosition = floatingActionButtonPosition,
            topBar = {
                AnimatedVisibility(visible = appBarVisible) {
                    CustomizableAppBar(
                        modifier = Modifier.background(LocalTheme.colors.brandMain),
                        title = title,
                        navigationIcon = navigationIcon,
                        subtitle = subtitle,
                        actions = actionIcons,
                        onNavigationIconClick = {
                            onBackPressedDispatcher?.onBackPressedDispatcher?.onBackPressed()
                        }
                    )
                }
            },
            content = content
        )
    }
}