package study.me.please.base.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Assessment
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
    currentRoute: String? = NavigationDestination.Home.route,
    actionNavigation: (screen: String) -> Unit = {}
) {
    // first action
    when(currentRoute) {
        // lobby destinations
        NavigationDestination.Home.route,
        NavigationDestination.Settings.route -> {
            if(currentRoute != NavigationDestination.Settings.route) {
                ActionBarIcon(
                    text = stringResource(id = R.string.screen_settings_title),
                    imageVector = Icons.Outlined.Settings,
                    onClick = {
                        actionNavigation(NavigationDestination.Settings.route)
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
    when(currentRoute) {
        NavigationDestination.SessionLobby.route -> {
            ActionBarIcon(
                text = stringResource(id = R.string.screen_collection_title),
                imageVector = Icons.Outlined.Inventory2,
                onClick = {
                    actionNavigation.invoke(NavigationDestination.CollectionLobby.route)
                }
            )
        }
        NavigationDestination.CollectionLobby.route -> {
            ActionBarIcon(
                text = stringResource(id = R.string.screen_sessions_title),
                imageVector = Icons.Outlined.PlayArrow,
                onClick = {
                    actionNavigation.invoke(NavigationDestination.SessionLobby.route)
                }
            )
        }
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

@Composable
fun SessionDetailBarActions(
    onChangePreferences: () -> Unit = {},
    onPlay: () -> Unit = {},
) {
    ActionBarIcon(
        text = stringResource(id = R.string.button_preferences),
        imageVector = Icons.Outlined.AutoFixHigh,
        onClick = onChangePreferences
    )
    ActionBarIcon(
        text = stringResource(id = R.string.button_play),
        imageVector = Icons.Outlined.PlayArrow,
        onClick = onPlay
    )
}

@Composable
fun SessionAppBarActions(
    isTest: Boolean,
    onChangePreferences: () -> Unit = {},
    onStatisticsOpen: () -> Unit = {},
) {
    if(isTest) {
        ActionBarIcon(
            text = stringResource(id = R.string.button_preferences),
            imageVector = Icons.Outlined.AutoFixHigh,
            onClick = onChangePreferences
        )
    }
    ActionBarIcon(
        text = stringResource(id = R.string.button_statistics),
        imageVector = Icons.Outlined.Assessment,
        onClick = onStatisticsOpen
    )
}