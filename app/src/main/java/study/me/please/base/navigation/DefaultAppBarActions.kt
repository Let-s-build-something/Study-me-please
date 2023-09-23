package study.me.please.base.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AutoFixHigh
import androidx.compose.material.icons.outlined.Inventory2
import androidx.compose.material.icons.outlined.PersonAddAlt
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import study.me.please.R

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
        NavigationDestination.HOME.route,
        NavigationDestination.SETTINGS.route -> {
            if(route != NavigationDestination.SETTINGS.route) {
                ActionBarIcon(
                    text = stringResource(id = R.string.screen_settings_title),
                    imageVector = Icons.Outlined.Settings,
                    onClick = {
                        actionNavigation(NavigationDestination.SETTINGS.route)
                    }
                )
            }
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
        NavigationDestination.SESSION_LOBBY.route -> {
            ActionBarIcon(
                text = stringResource(id = R.string.screen_collection_title),
                imageVector = Icons.Outlined.Inventory2,
                onClick = {
                    actionNavigation.invoke(NavigationDestination.COLLECTION_LOBBY.route)
                }
            )
        }
        NavigationDestination.HOME.route,
        NavigationDestination.SETTINGS.route,
        NavigationDestination.COLLECTION_DETAIL.route,
        NavigationDestination.SESSION.route -> {}
        else -> {
            ActionBarIcon(
                text = stringResource(id = R.string.screen_sessions_title),
                imageVector = Icons.Outlined.PlayArrow,
                onClick = {
                    actionNavigation.invoke(NavigationDestination.SESSION_LOBBY.route)
                }
            )
        }
    }
}

@Preview
@Composable
fun CollectionDetailAppBarActions(
    onClick: () -> Unit = {}
) {
    ActionBarIcon(
        text = stringResource(id = R.string.button_play),
        imageVector = Icons.Outlined.PlayArrow,
        onClick = onClick
    )
}

@Composable
fun SessionAppBarActions(
    isTest: Boolean,
    onChangePreferences: () -> Unit = {}
) {
    if(isTest) {
        ActionBarIcon(
            text = stringResource(id = R.string.button_preferences),
            imageVector = Icons.Outlined.AutoFixHigh,
            onClick = onChangePreferences
        )
    }
}

@Composable
fun SessionLobbyBarActions(
    onChangePreferences: () -> Unit = {}
) {
    ActionBarIcon(
        text = stringResource(id = R.string.button_preferences),
        imageVector = Icons.Outlined.AutoFixHigh,
        onClick = onChangePreferences
    )
}