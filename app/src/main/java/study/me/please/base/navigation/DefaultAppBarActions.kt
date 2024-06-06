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
import androidx.navigation.compose.currentBackStackEntryAsState
import com.squadris.squadris.compose.base.LocalNavController
import com.squadris.squadris.compose.components.navigation.ActionBarIcon
import study.me.please.R

/**
 * The default layout of action in top action bar
 * @param isUserSignedIn whether user is currently signed in or not
 */
@Composable
fun DefaultAppBarActions(
    isUserSignedIn: Boolean = false,
    userPhotoUrl: String? = null
) {
    val navController = LocalNavController.current
    val currentEntry = navController?.currentBackStackEntryAsState()

    // first action
    when(currentEntry?.value?.destination?.route) {
        // lobby destinations
        NavigationRoot.Home.route,
        NavigationRoot.Settings.route -> {
            if(currentEntry.value?.destination?.route != NavigationRoot.Settings.route) {
                ActionBarIcon(
                    text = stringResource(id = R.string.screen_settings_title),
                    imageVector = Icons.Outlined.Settings,
                    onClick = {
                        navController.navigate(NavigationRoot.Settings.route)
                    }
                )
            }
            if(isUserSignedIn) {
                ActionBarIcon(
                    text = stringResource(id = R.string.screen_account_title),
                    imageUrl = userPhotoUrl,
                    imageVector = Icons.Outlined.PersonOutline,
                    onClick = {
                        navController.navigate(NavigationRoot.UserAccountDashboard.route)
                    }
                )
            }else {
                ActionBarIcon(
                    text = stringResource(id = R.string.screen_register_title),
                    imageVector = Icons.Outlined.PersonAddAlt,
                    onClick = {
                        navController.navigate(NavigationRoot.SignUp.route)
                    }
                )
            }
        }
    }
    // second action
    when(currentEntry?.value?.destination?.route) {
        NavigationRoot.SessionLobby.route -> {
            ActionBarIcon(
                text = stringResource(id = R.string.screen_collection_title),
                imageVector = Icons.Outlined.Inventory2,
                onClick = {
                    navController.navigate(NavigationRoot.CollectionLobby.route)
                }
            )
        }
        NavigationRoot.CollectionLobby.route -> {
            ActionBarIcon(
                text = stringResource(id = R.string.screen_sessions_title),
                imageVector = Icons.Outlined.PlayArrow,
                onClick = {
                    navController.navigate(NavigationRoot.SessionLobby.route)
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