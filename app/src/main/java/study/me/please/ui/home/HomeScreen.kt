package study.me.please.ui.home

import android.app.Activity
import android.content.res.Configuration
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
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForwardIos
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import com.squadris.squadris.compose.components.getDefaultPullRefreshSize
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.utils.OnLifecycleEvent
import okhttp3.internal.notify
import study.me.please.R
import study.me.please.base.DraggableRefreshIndicator
import study.me.please.base.ProgressBarRefreshIndicator
import study.me.please.base.navigation.NavigationUtils
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.SessionIO
import study.me.please.ui.components.CollectionCard
import study.me.please.ui.components.ImageAction
import study.me.please.ui.components.InteractiveCardState
import study.me.please.ui.components.OutlinedButton
import study.me.please.ui.components.SessionCard
import study.me.please.ui.components.rememberInteractiveCardState
import java.util.UUID

/** Main screen, visible first when user opens the app */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    activity: Activity,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val collections = viewModel.dataManager.collections.collectAsState()
    val sessions = viewModel.dataManager.sessions.collectAsState()
    val isRefreshing = viewModel.isRefreshing.collectAsState()
    val pullRefreshSize = getDefaultPullRefreshSize(activity = activity)
    val pullRefreshState = rememberPullRefreshState(
        refreshing = isRefreshing.value,
        onRefresh = {
            viewModel.requestCollections(true)
        },
        refreshThreshold = pullRefreshSize,
        refreshingOffset = pullRefreshSize
    )
    val indicatorOffset = remember { mutableStateOf(0.dp) }
    val configuration = LocalConfiguration.current
    val interactiveCollectionStates = collections.value?.map {
        rememberInteractiveCardState()
    }
    val interactiveSessionStates = sessions.value?.map {
        rememberInteractiveCardState()
    }

    OnLifecycleEvent { event ->
        if(event == Lifecycle.Event.ON_RESUME) {
            viewModel.requestCollections()
        }
    }

    DraggableRefreshIndicator(
        pullRefreshSize = pullRefreshSize,
        state = pullRefreshState,
        isRefreshing = isRefreshing.value
    ) { indicatorOffsetDp ->
        indicatorOffset.value = indicatorOffsetDp
    }
    ConstraintLayout(
        modifier = Modifier
            .pullRefresh(pullRefreshState, enabled = isRefreshing.value.not())
            .fillMaxSize()
            .graphicsLayer {
                translationY = indicatorOffset.value.toPx()
            }
    ) {
        val mainContent = createRef()
        ProgressBarRefreshIndicator(isRefreshing = isRefreshing.value, state = pullRefreshState)
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .constrainAs(mainContent) {
                    linkTo(
                        parent.top,
                        parent.bottom
                    )
                    linkTo(parent.start, parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                },
            verticalArrangement = Arrangement.spacedBy(
                LocalTheme.shapes.betweenItemsSpace
            )
        ) {
            CollectionsRow(
                interactiveStates = interactiveCollectionStates,
                configuration = configuration,
                collections = collections.value,
                onNavigationToDetail = { collection ->
                    NavigationUtils.navigateToCollectionDetail(
                        navController = navController,
                        collectionUid = collection.uid,
                        toolbarTitle = collection.name.ifEmpty { activity.getString(R.string.screen_collection_detail_new) }
                    )
                },
                onNavigationToLobby = { createNewItem ->
                    if(createNewItem) {
                        NavigationUtils.navigateToCollectionDetail(
                            navController = navController,
                            toolbarTitle = activity.getString(R.string.screen_collection_detail_new)
                        )
                    }else {
                        NavigationUtils.navigateToCollectionLobby(navController = navController)
                    }
                },
                onNavigationToSession = { collection ->
                    NavigationUtils.navigateToSession(
                        navController = navController,
                        collectionUid = collection.uid,
                        toolbarTitle = collection.name
                    )
                }
            )
            SessionsRow(
                interactiveStates = interactiveSessionStates,
                sessions = sessions.value,
                configuration = configuration,
                onNavigationToLobby = {
                    NavigationUtils.navigateToSessionLobby(navController = navController)
                },
                onNavigationToSession = { session ->
                    NavigationUtils.navigateToSession(
                        navController = navController,
                        sessionUid = session.uid,
                        toolbarTitle = session.name
                    )
                },
                onNavigationToDetail = { session ->
                    NavigationUtils.navigateToSessionDetail(
                        navController = navController,
                        sessionUid = session.uid,
                        toolbarTitle = session.name
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
@Preview
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