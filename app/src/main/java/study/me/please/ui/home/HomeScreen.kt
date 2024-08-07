package study.me.please.ui.home

import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DoorBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.squadris.squadris.compose.base.LocalActivity
import com.squadris.squadris.compose.base.LocalIsTablet
import com.squadris.squadris.compose.base.LocalNavController
import com.squadris.squadris.compose.components.navigation.NavIconType
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.ext.scalingClickable
import com.squadris.squadris.utils.OnLifecycleEvent
import com.squadris.squadris.utils.RefreshableViewModel.Companion.requestData
import study.me.please.R
import study.me.please.base.navigation.NavigationRoot
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.session.SessionIO
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.CollectionCard
import study.me.please.ui.components.ContentTile
import study.me.please.ui.components.HorizontalBlock
import study.me.please.ui.components.pull_refresh.PullRefreshScreen
import study.me.please.ui.components.session.SessionCard
import study.me.please.ui.components.session.launcher.SessionLauncher
import java.util.UUID

const val IMAGE_URL_DISCOVER = "https://www.cubeit.cz/assets/img/analysis.jpg"

/** Main screen, visible first when user opens the app */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val collections = viewModel.dataManager.collections.collectAsState()
    val sessions = viewModel.dataManager.sessions.collectAsState()

    val configuration = LocalConfiguration.current
    val context = LocalContext.current
    val activity = LocalActivity.current
    val navController = LocalNavController.current

    var showLeaveDialog by remember { mutableStateOf(false) }
    val showSessionLauncher = remember { mutableStateOf<String?>(null) }

    BackHandler {
        showLeaveDialog = true
    }

    OnLifecycleEvent { event ->
        if(event == Lifecycle.Event.ON_RESUME) {
            viewModel.requestData(isSpecial = true)
        }
    }

    if(showLeaveDialog) {
        BasicAlertDialog(
            title = stringResource(id = R.string.leave_app_dialog_title),
            content = stringResource(R.string.leave_app_dialog_content),
            icon = Icons.Outlined.DoorBack,
            confirmButtonState = ButtonState(
                text = stringResource(id = R.string.button_confirm)
            ) {
                activity?.finish()
            },
            dismissButtonState = ButtonState(
                text = stringResource(id = R.string.button_cancel)
            ),
            onDismissRequest = {
                showLeaveDialog = false
            }
        )
    }

    PullRefreshScreen(
        viewModel = viewModel,
        navIconType = NavIconType.HOME,
        title = stringResource(id = R.string.home_screen_title)
    ) {
        showSessionLauncher.value?.let {
            SessionLauncher(
                collectionUidList = listOf(it),
                containsAll = false,
                onDismissRequest = {
                    showSessionLauncher.value = null
                }
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(
                LocalTheme.current.shapes.betweenItemsSpace
            )
        ) {
            ContentTile(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 8.dp, end = 8.dp),
                imageUrl = IMAGE_URL_DISCOVER,
                title = stringResource(R.string.home_screen_community),
                description = stringResource(R.string.home_screen_community_description),
                onClick = {
                    navController?.navigate(NavigationRoot.Community.route)
                }
            )
            CollectionsRow(
                configuration = configuration,
                collections = collections.value,
                onNavigationToDetail = { collection ->
                    navController?.navigate(
                        NavigationRoot.CollectionDetail.createRoute(
                            NavigationRoot.CollectionDetail.CollectionDetailArgument(
                                collectionUid = collection.uid,
                                toolbarTitle = collection.name.ifEmpty {
                                    context.getString(R.string.screen_collection_detail_new)
                                }
                            )
                        )
                    )
                },
                onNavigationToLobby = { createNewItem ->
                    if(createNewItem) {
                        navController?.navigate(
                            NavigationRoot.CollectionDetail.createRoute(
                                NavigationRoot.CollectionDetail.CollectionDetailArgument(
                                    toolbarTitle = context.getString(R.string.screen_collection_detail_new)
                                )
                            )
                        )
                    }else {
                        navController?.navigate(NavigationRoot.CollectionLobby.route)
                    }
                },
                onNavigationToSession = { collection ->
                    showSessionLauncher.value = collection.uid
                }
            )
            SessionsRow(
                sessions = sessions.value,
                configuration = configuration,
                onNavigationToLobby = {
                    navController?.navigate(NavigationRoot.SessionLobby.route)
                },
                onNavigationToSession = { session ->
                    navController?.navigate(
                        NavigationRoot.SessionPlay.createRoute(
                            NavigationRoot.SessionPlay.SessionPlayArgument(
                                toolbarTitle = session.name,
                                sessionUid = session.uid
                            )
                        )
                    )
                },
                onNavigationToDetail = { session ->
                    navController?.navigate(
                        NavigationRoot.SessionDetail.createRoute(
                            NavigationRoot.SessionDetail.SessionDetailArgument(
                                toolbarTitle = session.name,
                                sessionUid = session.uid
                            )
                        )
                    )
                }
            )
        }
    }
}


@Composable
private fun CollectionsRow(
    collections: List<CollectionIO>?,
    configuration: Configuration,
    onNavigationToLobby: (createNewItem: Boolean) -> Unit,
    onNavigationToSession: (collection: CollectionIO) -> Unit,
    onNavigationToDetail: (collection: CollectionIO) -> Unit
) {
    val selectedUid = remember { mutableStateOf<String?>(null) }

    HorizontalBlock(
        modifier = Modifier.animateContentSize(),
        isEmpty = collections?.isEmpty() == true,
        emptyTitle = stringResource(R.string.collection_empty_error),
        emptyText = stringResource(R.string.home_screen_collections_empty_action),
        onActionClicked = onNavigationToLobby,
        heading = stringResource(R.string.screen_collection_title)
    ) {
        items(
            collections ?: arrayOfNulls<CollectionIO?>(5).toList(),
            key = { collection -> collection?.uid ?: UUID.randomUUID().toString() }
        ) { collection ->
            CollectionCard(
                modifier = Modifier
                    .scalingClickable(
                        onTap = {
                            selectedUid.value = collection?.uid
                        }
                    )
                    .width(
                        configuration.screenWidthDp.div(if(LocalIsTablet.current) 4 else 2).dp
                    ),
                data = collection,
                onNavigateToDetail = {
                    collection?.let(onNavigationToDetail)
                },
                onNavigateToSession = {
                    collection?.let(onNavigationToSession)
                },
                onCheckedChange = {
                    selectedUid.value = null
                },
                isSelected = selectedUid.value == collection?.uid,
            )
        }
    }
}

@Composable
private fun SessionsRow(
    sessions: List<SessionIO>?,
    configuration: Configuration,
    onNavigationToLobby: () -> Unit,
    onNavigationToSession: (session: SessionIO) -> Unit,
    onNavigationToDetail: (session: SessionIO) -> Unit
) {
    val selectedUid = remember { mutableStateOf<String?>(null) }

    HorizontalBlock(
        isEmpty = sessions?.isEmpty() == true,
        emptyTitle = stringResource(id = R.string.session_lobby_screen_empty_text),
        emptyText = stringResource(id = R.string.home_screen_sessions_empty_action),
        onActionClicked = {
            onNavigationToLobby()
        },
        heading = stringResource(id = R.string.screen_session_lobby_title)
    ) {
        items(
            sessions ?: arrayOfNulls<SessionIO?>(5).toList(),
            key = { session -> session?.uid ?: UUID.randomUUID().toString() }
        ) { session ->
            SessionCard(
                modifier = Modifier
                    .scalingClickable(
                        onTap = {
                            selectedUid.value = session?.uid
                        }
                    )
                    .requiredWidth(configuration.screenWidthDp.div(2).dp),
                session = session,
                isSelected = selectedUid.value == session?.uid,
                onEditOptionPressed = {
                    session?.let(onNavigationToDetail)
                },
                onCheckedChange = {
                    selectedUid.value = null
                },
                onPlayOptionPressed = {
                    session?.let(onNavigationToSession)
                }
            )
        }
    }
}