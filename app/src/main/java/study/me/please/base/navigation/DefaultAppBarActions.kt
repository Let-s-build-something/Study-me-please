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
import study.me.please.R

/**
 * The default layout of action in top action bar
 * @param isUserSignedIn whether user is currently signed in or not
 */
@Composable
fun DefaultAppBarActions(
    isUserSignedIn: Boolean = false,
    currentRoute: String? = NavigationScreen.Home.route,
    actionNavigation: (screen: String) -> Unit = {}
) {
    // first action
    when(currentRoute) {
        // lobby destinations
        NavigationScreen.Home.route,
        NavigationScreen.Settings.route -> {
            if(currentRoute != NavigationScreen.Settings.route) {
                ActionBarIcon(
                    text = stringResource(id = R.string.screen_settings_title),
                    imageVector = Icons.Outlined.Settings,
                    onClick = {
                        actionNavigation(NavigationScreen.Settings.route)
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
        NavigationScreen.SessionLobby.route -> {
            ActionBarIcon(
                text = stringResource(id = R.string.screen_collection_title),
                imageVector = Icons.Outlined.Inventory2,
                onClick = {
                    actionNavigation.invoke(NavigationScreen.CollectionLobby.route)
                }
            )
        }
        NavigationScreen.CollectionLobby.route -> {
            ActionBarIcon(
                text = stringResource(id = R.string.screen_sessions_title),
                imageVector = Icons.Outlined.PlayArrow,
                onClick = {
                    actionNavigation.invoke(NavigationScreen.SessionLobby.route)
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