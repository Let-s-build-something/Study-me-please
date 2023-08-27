package study.me.please.base.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PersonAddAlt
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.theme.AppTheme
import study.me.please.R

/**
 * Custom app bar with options of customization
 * @param title title of the screen/app
 * @param navigationIcon current icon for navigation back/closing or none in case of null
 * @param actions other actions on the right side of the action bar
 * @param onNavigationIconClick event upon clicking on navigation back
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomizableAppBar(
    modifier: Modifier = Modifier,
    title: String? = "Home",
    navigationIcon: Pair<ImageVector, String>? = Icons.Outlined.Home to "",
    actions: @Composable RowScope.() -> Unit = {},
    onNavigationIconClick: () -> Unit = {}
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = title ?: "",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = AppTheme.colors.tetrial
            )
        },
        navigationIcon = {
            navigationIcon?.let { navigationIcon ->
                Icon(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(48.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .clickable(
                            indication = rememberRipple(
                                bounded = true,
                                color = AppTheme.colors.contrastActionLight
                            ),
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onNavigationIconClick()
                        }
                        .padding(8.dp),
                    imageVector = navigationIcon.first,
                    contentDescription = navigationIcon.second,
                    tint = AppTheme.colors.tetrial
                )
            }
        },
        actions = {
            actions(this)
        },
        colors = TopAppBarColors(
            containerColor = AppTheme.colors.brandMain,
            scrolledContainerColor = AppTheme.colors.brandMain,
            navigationIconContentColor = AppTheme.colors.tetrial,
            titleContentColor = AppTheme.colors.tetrial,
            actionIconContentColor = AppTheme.colors.tetrial
        )
    )
}

/**
 * The default layout of action in top action bar
 * @param isUserSignedIn whether user is currently signed in or not
 */
@Composable
fun DefaultAppBarActions(
    isUserSignedIn: Boolean = false,
    route: String? = NavigationDestination.HOME.route,
    actionNavigation: (screen: String) -> Unit = {}
) {
    // first action
    when(route) {
        // lobby destinations
        NavigationDestination.HOME.route -> {
            if(isUserSignedIn) {
                ActionBarIcon(
                    text = stringResource(id = R.string.screen_account_title),
                    imageVector = Icons.Outlined.PersonOutline,
                    onClick = {
                        //TODO
                    }
                )
            }else {
                ActionBarIcon(
                    text = stringResource(id = R.string.screen_register_title),
                    imageVector = Icons.Outlined.PersonAddAlt,
                    onClick = {
                        //TODO
                    }
                )
            }
        }
    }
    // second action
    when(route) {
        NavigationDestination.SESSION_LOBBY.route,
        NavigationDestination.SESSION.route -> {}
        else -> {
            ActionBarIcon(
                text = stringResource(id = R.string.screen_sessions_title),
                imageVector = Icons.Outlined.PlayArrow,
                onClick = {
                    actionNavigation.invoke(NavigationDestination.COLLECTION.route)
                }
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    CustomizableAppBar(
        actions = {
            DefaultAppBarActions()
        }
    )
}