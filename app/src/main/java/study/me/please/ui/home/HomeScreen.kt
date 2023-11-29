package study.me.please.ui.home

import android.app.Activity
import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForwardIos
import androidx.compose.material.icons.outlined.DoorBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.utils.OnLifecycleEvent
import study.me.please.R
import study.me.please.base.LocalNavController
import study.me.please.base.navigation.NavIconType
import study.me.please.base.navigation.NavigationComponent
import study.me.please.base.navigation.NavigationDestination
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.session.SessionIO
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.CollectionCard
import study.me.please.ui.components.ImageAction
import study.me.please.ui.components.InteractiveCardState
import study.me.please.ui.components.OutlinedButton
import study.me.please.ui.components.pull_refresh.PullRefreshScreen
import study.me.please.ui.components.rememberInteractiveCardState
import study.me.please.ui.components.session.SessionCard
import java.util.UUID

/** Main screen, visible first when user opens the app */
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val collections = viewModel.dataManager.collections.collectAsState()
    val sessions = viewModel.dataManager.sessions.collectAsState()

    val configuration = LocalConfiguration.current
    val context = LocalContext.current
    val navController = LocalNavController.current

    var showLeaveDialog by remember { mutableStateOf(false) }

    val interactiveCollectionStates = collections.value?.map {
        rememberInteractiveCardState()
    }
    val interactiveSessionStates = sessions.value?.map {
        rememberInteractiveCardState()
    }

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
                text = stringResource(id = R.string.button_cancel)
            ) {
                showLeaveDialog = false
            },
            dismissButtonState = ButtonState(
                text = stringResource(id = R.string.button_confirm)
            ) {
                showLeaveDialog = false
                (context as? Activity)?.finish()
            }
        )
    }

    PullRefreshScreen(
        viewModel = viewModel,
        navIconType = NavIconType.HOME,
        title = stringResource(id = R.string.home_screen_title)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(
                LocalTheme.shapes.betweenItemsSpace
            )
        ) {
            CollectionsRow(
                interactiveStates = interactiveCollectionStates,
                configuration = configuration,
                collections = collections.value,
                onNavigationToDetail = { collection ->
                    navController?.navigate(
                        NavigationDestination.CollectionDetail.createRoute(
                            NavigationComponent.COLLECTION_UID to collection.uid,
                            NavigationComponent.TOOLBAR_TITLE to collection.name.ifEmpty {
                                context.getString(R.string.screen_collection_detail_new)
                            }
                        )
                    )
                },
                onNavigationToLobby = { createNewItem ->
                    if(createNewItem) {
                        navController?.navigate(
                            NavigationDestination.CollectionDetail.createRoute(
                                NavigationComponent.TOOLBAR_TITLE to context.getString(
                                    R.string.screen_collection_detail_new
                                )
                            )
                        )
                    }else {
                        navController?.navigate(NavigationDestination.CollectionLobby.createRoute())
                    }
                },
                onNavigationToSession = { collection ->
                    navController?.navigate(
                        NavigationDestination.SessionPlay.createRoute(
                            NavigationComponent.TOOLBAR_TITLE to collection.name,
                            NavigationComponent.COLLECTION_UID to collection.uid
                        )
                    )
                }
            )
            SessionsRow(
                interactiveStates = interactiveSessionStates,
                sessions = sessions.value,
                configuration = configuration,
                onNavigationToLobby = {
                    navController?.navigate(NavigationDestination.SessionLobby.createRoute())
                },
                onNavigationToSession = { session ->
                    navController?.navigate(
                        NavigationDestination.SessionPlay.createRoute(
                            NavigationComponent.TOOLBAR_TITLE to session.name,
                            NavigationComponent.SESSION_UID to session.uid
                        )
                    )
                },
                onNavigationToDetail = { session ->
                    navController?.navigate(
                        NavigationDestination.SessionDetail.createRoute(
                            NavigationComponent.SESSION_UID to session.uid,
                            NavigationComponent.TOOLBAR_TITLE to session.name
                        )
                    )
                }
            )
        }
    }
}


@Composable
private fun CollectionsRow(
    interactiveStates: List<InteractiveCardState>?,
    collections: List<CollectionIO>?,
    configuration: Configuration,
    onNavigationToLobby: (createNewItem: Boolean) -> Unit,
    onNavigationToSession: (collection: CollectionIO) -> Unit,
    onNavigationToDetail: (collection: CollectionIO) -> Unit
) {
    OutlinedButton(
        modifier = Modifier
            .padding(top = 16.dp, start = 4.dp),
        text = stringResource(id = R.string.screen_collection_title),
        activeColor = LocalTheme.colors.secondary,
        onClick = {
            onNavigationToLobby(false)
        }
    )
    if(collections?.isEmpty() == true) {
        EmptyElement(
            emptyText = stringResource(id = R.string.collection_empty_error),
            actionText = stringResource(id = R.string.home_screen_collections_empty_action)
        ) {
            onNavigationToLobby(true)
        }
    }else {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                Spacer(modifier = Modifier.width(6.dp))
            }
            itemsIndexed(
                collections ?: arrayOfNulls<CollectionIO?>(5).toList(),
                key = { _, collection -> collection?.uid ?: UUID.randomUUID().toString() }
            ) { index, collection ->
                (interactiveStates?.getOrNull(index))?.let { state ->
                    CollectionCard(
                        modifier = Modifier
                            .requiredWidth(configuration.screenWidthDp.div(2).dp),
                        data = collection,
                        onNavigateToDetail = {
                            collection?.let(onNavigationToDetail)
                        },
                        onNavigateToSession = {
                            collection?.let(onNavigationToSession)
                        },
                        state = state
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.width(6.dp))
            }
        }
    }
}

@Composable
private fun SessionsRow(
    interactiveStates: List<InteractiveCardState>?,
    sessions: List<SessionIO>?,
    configuration: Configuration,
    onNavigationToLobby: () -> Unit,
    onNavigationToSession: (session: SessionIO) -> Unit,
    onNavigationToDetail: (session: SessionIO) -> Unit
) {
    OutlinedButton(
        modifier = Modifier
            .padding(top = 16.dp, start = 4.dp),
        text = stringResource(id = R.string.screen_session_lobby_title),
        activeColor = LocalTheme.colors.secondary,
        onClick = {
            onNavigationToLobby()
        }
    )
    if(sessions?.isEmpty() == true) {
        EmptyElement(
            emptyText = stringResource(id = R.string.session_lobby_screen_empty_text),
            actionText = stringResource(id = R.string.home_screen_sessions_empty_action)
        ) {
            onNavigationToLobby()
        }
    }else {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(
                LocalTheme.shapes.betweenItemsSpace
            )
        ) {
            item {
                Spacer(modifier = Modifier.width(6.dp))
            }
            itemsIndexed(
                sessions ?: arrayOfNulls<SessionIO?>(5).toList(),
                key = { _, session -> session?.uid ?: UUID.randomUUID().toString() }
            ) { index, session ->
                (interactiveStates?.getOrNull(index))?.let { state ->
                    SessionCard(
                        modifier = Modifier
                            .requiredWidth(configuration.screenWidthDp.div(2).dp),
                        session = session,
                        state = state,
                        onEditOptionPressed = {
                            session?.let(onNavigationToDetail)
                        },
                        onPlayOptionPressed = {
                            session?.let(onNavigationToSession)
                        }
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.width(6.dp))
            }
        }
    }
}

/** Element to place shown whenever row content is empty */
@Composable
private fun EmptyElement(
    emptyText: String = "",
    actionText: String = "",
    onActionClicked: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = emptyText,
            color = LocalTheme.colors.primary,
            fontSize = 16.sp
        )
        ImageAction(
            text = actionText,
            trailingImageVector = Icons.AutoMirrored.Outlined.ArrowForwardIos,
            onClick = onActionClicked
        )
    }
}