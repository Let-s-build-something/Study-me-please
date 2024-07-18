package study.me.please.ui.session.lobby

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.DeleteSweep
import androidx.compose.material.icons.outlined.Deselect
import androidx.compose.material.icons.outlined.SelectAll
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.squadris.squadris.compose.base.LocalNavController
import com.squadris.squadris.compose.components.chips.DEFAULT_ANIMATION_LENGTH_SHORT
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.compose.theme.SharedColors
import com.squadris.squadris.ext.brandShimmerEffect
import com.squadris.squadris.ext.scalingClickable
import com.squadris.squadris.utils.OnLifecycleEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.base.navigation.NavigationRoot
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.ComponentHeaderButton
import study.me.please.ui.components.ImageAction
import study.me.please.ui.components.ListOptionsBottomSheet
import study.me.please.ui.components.pull_refresh.PullRefreshScreen
import study.me.please.ui.components.session.SessionCard

/** communication bridge for controlling session lobby screen */
interface SessionLobbyListener {
    fun onCreateNewItem()
}

/**
 * Session lobby screen for management of sessions
 */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun SessionLobbyScreen(
    createNewItem: Boolean = false,
    viewModel: SessionLobbyViewModel = hiltViewModel()
) {
    val localDensity = LocalDensity.current
    val coroutineScope = rememberCoroutineScope()
    val localFocusManager = LocalFocusManager.current
    val navController = LocalNavController.current

    val sessions = viewModel.sessions.collectAsState()
    val sessionsFlow = viewModel.sessions.collectAsState()

    val optionsSheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(skipHiddenState = false)
    )
    val checkedUidList = remember { mutableStateListOf<String>() }
    val selectedUid = remember { mutableStateOf<String?>(null) }
    val showDeleteDialog = remember { mutableStateOf(false) }
    val newItem = remember(createNewItem) { mutableStateOf(createNewItem) }
    var optionsSheetHeight by remember { mutableStateOf(0.dp) }

    val stopChecking = {
        coroutineScope.launch {
            optionsSheetState.bottomSheetState.hide()
        }
        checkedUidList.clear()
    }
    val listener = remember(viewModel) {
        object: SessionLobbyListener {
            override fun onCreateNewItem() {
                viewModel.addNewSession()
                stopChecking()
            }
        }
    }

    LaunchedEffect(key1 = checkedUidList.size) {
        coroutineScope.launch {
            if(checkedUidList.size > 0) {
                optionsSheetState.bottomSheetState.expand()
                localFocusManager.clearFocus()
            }else stopChecking()
        }
    }
    OnLifecycleEvent { event ->
        if(event == Lifecycle.Event.ON_RESUME) {
            viewModel.requestAllSessions()
        }
    }
    LaunchedEffect(Unit) {
        viewModel.requestAllSessions()
    }
    LaunchedEffect(newItem) {
        if(newItem.value) {
            listener.onCreateNewItem()
            newItem.value = false
        }
    }

    if(showDeleteDialog.value) {
        BasicAlertDialog(
            title = stringResource(id = R.string.collection_delete_dialog_title),
            content = stringResource(
                id = R.string.collection_delete_dialog_description,
                checkedUidList.size
            ),
            icon = Icons.Outlined.Delete,
            confirmButtonState = ButtonState(
                text = stringResource(id = R.string.button_confirm)
            ) {
                coroutineScope.launch(Dispatchers.Default) {
                    viewModel.requestSessionsDeletion(uids = checkedUidList.toSet())
                    stopChecking()
                }
            },
            dismissButtonState = ButtonState(
                text = stringResource(id = R.string.button_dismiss)
            ),
            onDismissRequest = { showDeleteDialog.value = false }
        )
    }

    PullRefreshScreen(
        viewModel = viewModel,
        title = stringResource(id = R.string.screen_session_lobby_title)
    ) {
        if(sessionsFlow.value != null) {
            ListOptionsBottomSheet(
                modifier = Modifier
                    .pointerInput(Unit) {
                        detectTapGestures(onTap = {
                            stopChecking()
                        })
                    }
                    .fillMaxSize(),
                onDismissRequest = {
                    stopChecking()
                },
                sheetContentModifier = Modifier.onGloballyPositioned { coordinates ->
                    optionsSheetHeight = with(localDensity) { coordinates.size.height.toDp() }
                },
                actions = {
                    ImageAction(
                        leadingImageVector = Icons.Outlined.DeleteSweep,
                        text = stringResource(id = R.string.button_delete),
                        containerColor = SharedColors.RED_ERROR
                    ) {
                        showDeleteDialog.value = true
                    }
                    ImageAction(
                        leadingImageVector = Icons.Outlined.SelectAll,
                        text = stringResource(id = R.string.button_select_all)
                    ) {
                        checkedUidList.addAll(sessions.value?.map { it.uid }.orEmpty())
                    }
                    ImageAction(
                        leadingImageVector = Icons.Outlined.Deselect,
                        text = stringResource(id = R.string.button_deselect)
                    ) {
                        checkedUidList.clear()
                    }
                },
                state = optionsSheetState
            ) { modalPaddingValues ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        state = rememberLazyListState(),
                        verticalArrangement = Arrangement.spacedBy(
                            LocalTheme.current.shapes.betweenItemsSpace
                        )
                    ) {
                        stickyHeader {
                            ComponentHeaderButton(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = LocalTheme.current.shapes.betweenItemsSpace),
                                text = stringResource(id = R.string.home_screen_sessions_empty_action)
                            ) {
                                listener.onCreateNewItem()
                            }
                        }
                        items(
                            sessions.value.orEmpty(),
                            key = { item -> item.uid }
                        ) { session ->
                            SessionCard(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .animateItemPlacement(
                                        tween(
                                            durationMillis = DEFAULT_ANIMATION_LENGTH_SHORT,
                                            easing = LinearOutSlowInEasing
                                        )
                                    )
                                    .scalingClickable(
                                        onTap = {
                                            if (checkedUidList.size > 0) {
                                                if (checkedUidList.contains(session.uid)) {
                                                    checkedUidList.remove(session.uid)
                                                } else checkedUidList.add(session.uid)
                                            } else {
                                                selectedUid.value = session.uid
                                            }
                                        },
                                        onLongPress = {
                                            if(checkedUidList.size == 0) {
                                                checkedUidList.add(session.uid)
                                            }
                                        }
                                    ),
                                session = session,
                                onEditOptionPressed = {
                                    navController?.navigate(
                                        NavigationRoot.SessionDetail.createRoute(
                                            NavigationRoot.SessionDetail.SessionDetailArgument(
                                                sessionUid = session.uid,
                                                toolbarTitle = session.name
                                            )
                                        )
                                    )
                                },
                                onCheckedChange = {
                                    if(it && checkedUidList.contains(session.uid).not()) {
                                        checkedUidList.add(session.uid)
                                    }else {
                                        checkedUidList.remove(session.uid)
                                    }
                                    selectedUid.value = null
                                },
                                isSelected = selectedUid.value == session.uid,
                                isChecked = if(checkedUidList.size > 0) {
                                    checkedUidList.contains(session.uid)
                                } else null
                            )
                        }
                    }
                }
            }
        }else {
            EditableListShimmerLayout()
        }
    }
}

@Composable
fun EditableListShimmerLayout(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(LocalTheme.current.shapes.betweenItemsSpace))
        repeat(3) {
            Box(
                modifier = Modifier
                    .height(70.dp)
                    .padding(start = 4.dp, end = 4.dp)
                    .fillMaxWidth()
                    .brandShimmerEffect(LocalTheme.current.shapes.componentShape)
            )
            Spacer(modifier = Modifier.height(LocalTheme.current.shapes.betweenItemsSpace))
        }
        Box(
            modifier = Modifier
                .height(55.dp)
                .padding(start = 4.dp, end = 4.dp)
                .fillMaxWidth()
                .brandShimmerEffect(LocalTheme.current.shapes.componentShape)
        )
    }
}