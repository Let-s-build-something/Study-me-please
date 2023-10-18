package study.me.please.ui.collection

import android.app.Activity
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Deselect
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.SelectAll
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.squadris.squadris.compose.components.getDefaultPullRefreshSize
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.compose.theme.Colors
import com.squadris.squadris.utils.OnLifecycleEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.base.DraggableRefreshIndicator
import study.me.please.base.ProgressBarRefreshIndicator
import study.me.please.base.navigation.NavigationUtils
import study.me.please.ui.components.AddToSessionCollectionSheet
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.CollectionCard
import study.me.please.ui.components.ComponentHeaderButton
import study.me.please.ui.components.ImageAction
import study.me.please.ui.components.InteractiveCardMode
import study.me.please.ui.components.ListOptionsBottomSheet
import study.me.please.ui.components.rememberInteractiveCardState
import study.me.please.ui.session.lobby.EditableListShimmerLayout

/** Screen with user's collections */
@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class,
    ExperimentalFoundationApi::class
)
@Composable
fun CollectionLobbyScreen(
    navController: NavController,
    activity: Activity,
    viewModel: CollectionViewModel = hiltViewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    val collectionsFlow = viewModel.dataManager.collections.collectAsState()
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
    val bottomSheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(skipHiddenState = false)
    )
    val showDeleteDialog = remember { mutableStateOf(false) }
    val showAddToSheet = remember { mutableStateOf(false) }

    OnLifecycleEvent { event ->
        if(event == Lifecycle.Event.ON_RESUME) {
            viewModel.requestCollections()
        }
    }

    val collections = remember(collectionsFlow.value) {
        mutableStateListOf(
            *collectionsFlow.value?.toTypedArray().orEmpty()
        )
    }
    val selectedCollectionUids = remember(collectionsFlow.value) { mutableStateListOf<String>() }
    val interactiveStates = collections.map {
        rememberInteractiveCardState()
    }
    val stopChecking = {
        interactiveStates.forEach {
            it.isChecked.value = false
            it.mode.value = InteractiveCardMode.DATA_DISPLAY
        }
        selectedCollectionUids.clear()
        coroutineScope.launch {
            bottomSheetState.bottomSheetState.hide()
        }
    }
    LaunchedEffect(selectedCollectionUids.size) {
        coroutineScope.launch {
            if(selectedCollectionUids.size > 0) {
                interactiveStates.forEach {
                    it.mode.value = InteractiveCardMode.CHECKING
                }
                bottomSheetState.bottomSheetState.expand()
            } else stopChecking()
        }
    }
    if(selectedCollectionUids.size > 0) {
        BackHandler {
            stopChecking()
        }
    }

    if(showDeleteDialog.value) {
        BasicAlertDialog(
            dialogTitle = stringResource(id = R.string.collection_delete_dialog_title),
            dialogText = stringResource(
                id = R.string.collection_delete_dialog_description,
                selectedCollectionUids.size
            ),
            icon = Icons.Outlined.Delete,
            confirmButtonState = ButtonState(
                text = stringResource(id = R.string.button_confirm)
            ) {
                coroutineScope.launch(Dispatchers.Default) {
                    collections.removeAll { selectedCollectionUids.contains(it.uid) }
                    viewModel.dataManager.collections.update { list ->
                        list?.toMutableList()?.apply {
                            removeAll { selectedCollectionUids.contains(it.uid) }
                        }
                    }
                    viewModel.requestCollectionDeletion(uidList = selectedCollectionUids.toSet())
                    stopChecking()
                    showDeleteDialog.value = false
                }
            },
            dismissButtonState = ButtonState(
                text = stringResource(id = R.string.button_dismiss)
            ) { showDeleteDialog.value = false }
        )
    }
    if(showAddToSheet.value) {
        AddToSessionCollectionSheet(
            tabs = mutableListOf(
                stringResource(id = R.string.screen_sessions_title)
            ),
            sessions = sessions.value,
            isShimmering = sessions.value == null,
            selectedCollections = selectedCollectionUids,
            onConfirmation = { sessionList, _ ->
                if(sessionList.isNullOrEmpty().not()) {
                    viewModel.requestSessionsSave(sessionList.orEmpty())
                }
                stopChecking()
                showAddToSheet.value = false
            },
            onDismissRequest = {
                showAddToSheet.value = false
            }
        )
    }
    DraggableRefreshIndicator(
        pullRefreshSize = pullRefreshSize,
        state = pullRefreshState,
        isRefreshing = isRefreshing.value
    ) { indicatorOffsetDp ->
        indicatorOffset.value = indicatorOffsetDp
    }
    if(collectionsFlow.value == null) {
        EditableListShimmerLayout()
    }else {
        ListOptionsBottomSheet(
            modifier = Modifier
                .fillMaxSize(),
            onDismissRequest = {
                stopChecking()
            },
            actions = {
                ImageAction(
                    leadingImageVector = Icons.Outlined.Delete,
                    text = stringResource(id = R.string.button_delete),
                    containerColor = Colors.RED_ERROR
                ) {
                    showDeleteDialog.value = true
                }
                ImageAction(
                    leadingImageVector = Icons.Outlined.SelectAll,
                    text = stringResource(id = R.string.button_select_all)
                ) {
                    interactiveStates.forEach {
                        it.isChecked.value = true
                    }
                }
                ImageAction(
                    leadingImageVector = Icons.Outlined.Deselect,
                    text = stringResource(id = R.string.button_deselect)
                ) {
                    selectedCollectionUids.clear()
                }
                ImageAction(
                    leadingImageVector = Icons.Outlined.Add,
                    text = stringResource(id = R.string.button_add_to)
                ) {
                    viewModel.requestSessions()
                    showAddToSheet.value = true
                }
                val toolbarText = stringResource(id = R.string.session_detail_default_toolbar)
                ImageAction(
                    leadingImageVector = Icons.Outlined.PlayArrow,
                    text = stringResource(id = R.string.button_start_session)
                ) {
                    NavigationUtils.navigateToSessionDetail(
                        navController = navController,
                        collectionUidList = selectedCollectionUids.toList(),
                        toolbarTitle = toolbarText
                    )
                    stopChecking()
                }
            },
            state = bottomSheetState
        ) { paddingValues ->
            ConstraintLayout(
                modifier = Modifier
                    .pullRefresh(pullRefreshState)
                    .fillMaxSize()
                    .graphicsLayer {
                        translationY = indicatorOffset.value.toPx()
                    }
            ) {
                val collectionList = createRef()

                ProgressBarRefreshIndicator(isRefreshing = isRefreshing.value, state = pullRefreshState)
                val toolbarText = stringResource(id = R.string.session_detail_default_toolbar)
                LazyColumn(
                    modifier = Modifier
                        .padding(paddingValues)
                        .pointerInput(Unit) {
                            detectTapGestures(onTap = {
                                stopChecking()
                            })
                        }
                        .windowInsetsPadding(WindowInsets.systemBars)
                        .windowInsetsPadding(WindowInsets.ime)
                        .constrainAs(collectionList) {
                            linkTo(
                                parent.top,
                                parent.bottom
                            )
                            linkTo(
                                parent.start,
                                parent.end
                            )
                            width = Dimension.fillToConstraints
                            height = Dimension.fillToConstraints
                        },
                    verticalArrangement = Arrangement.spacedBy(LocalTheme.shapes.betweenItemsSpace)
                ) {
                    if(collections.isNotEmpty()) {
                        item {
                            Spacer(modifier = Modifier.height(
                                LocalTheme.shapes.betweenItemsSpace
                            ))
                        }
                        itemsIndexed(
                            items = collections,
                            key = { _, item ->
                                item.uid
                            }
                        ) { index, collection ->
                            (interactiveStates.getOrNull(index) ?: rememberInteractiveCardState()).let { state ->
                                LaunchedEffect(key1 = state.isChecked.value) {
                                    if (state.isChecked.value) {
                                        selectedCollectionUids.add(collection.uid)
                                    } else selectedCollectionUids.remove(collection.uid)
                                }
                                CollectionCard(
                                    data = collection,
                                    onNavigateToDetail = {
                                        NavigationUtils.navigateToCollectionDetail(
                                            navController = navController,
                                            collectionUid = collection.uid,
                                            toolbarTitle = collection.name.ifEmpty { activity.getString(R.string.screen_collection_detail_new) }
                                        )
                                    },
                                    onNavigateToSession = {
                                        NavigationUtils.navigateToSessionDetail(
                                            navController = navController,
                                            collectionUidList = listOf(collection.uid),
                                            toolbarTitle = toolbarText
                                        )
                                    },
                                    state = state
                                )
                            }
                        }
                    }else if(collections.isEmpty() && collectionsFlow.value != null) {
                        item {
                            EmptyScreen()
                        }
                    }else {
                        item {
                            // loading state
                        }
                    }
                    stickyHeader {
                        ComponentHeaderButton(
                            modifier = Modifier.padding(vertical = 8.dp),
                            text = stringResource(id = R.string.add_new_collection)
                        ) {
                            NavigationUtils.navigateToCollectionDetail(
                                navController = navController,
                                toolbarTitle = activity.getString(R.string.screen_collection_detail_new)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun EmptyScreen() {
    val localConfiguration = LocalConfiguration.current
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.animation_empty)
    )
    // empty state
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 12.dp,
                bottom = 4.dp
            ),
        text = stringResource(id = R.string.collection_empty_error),
        fontSize = 18.sp,
        color = LocalTheme.colors.secondary,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
    LottieAnimation(
        modifier = Modifier
            .padding(
                top = 4.dp,
                start = 4.dp,
                end = 4.dp,
                bottom = 8.dp
            )
            .height(localConfiguration.screenHeightDp.dp.div(2)),
        composition = composition,
        restartOnPlay = true,
        isPlaying = true,
        contentScale = ContentScale.Inside,
        iterations = Int.MAX_VALUE
    )
}