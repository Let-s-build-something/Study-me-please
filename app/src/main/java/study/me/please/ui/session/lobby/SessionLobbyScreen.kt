package study.me.please.ui.session.lobby

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Deselect
import androidx.compose.material.icons.outlined.SelectAll
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
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
import androidx.navigation.NavController
import com.squadris.squadris.compose.theme.Colors
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.ext.brandShimmerEffect
import com.squadris.squadris.utils.OnLifecycleEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.base.navigation.NavigationUtils
import study.me.please.base.navigation.SessionLobbyBarActions
import study.me.please.data.io.SessionIO
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.ComponentHeaderButton
import study.me.please.ui.components.ImageAction
import study.me.please.ui.components.InteractiveCardMode
import study.me.please.ui.components.ListOptionsBottomSheet
import study.me.please.ui.components.PreferenceChooser
import study.me.please.ui.components.SessionCard
import study.me.please.ui.components.SimpleModalBottomSheet
import study.me.please.ui.components.rememberInteractiveCardState

/** communication bridge for controlling session lobby screen */
interface SessionLobbyListener {
    fun onCreateNewItem()
    fun onCheckingStarted(sessionUid: String)
}

/**
 * Session lobby screen for management of sessions
 */
@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SessionLobbyScreen(
    navController: NavController,
    createNewItem: Boolean = false,
    viewModel: SessionLobbyViewModel = hiltViewModel(),
    changeActionBar: (actions: @Composable RowScope.() -> Unit) -> Unit
) {
    val optionsSheetState = rememberBottomSheetScaffoldState()
    val preferencesSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val showPreferenceModal = remember { mutableStateOf(false) }
    val selectedSessionUids = remember { mutableStateListOf<String>() }
    val showDeleteDialog = remember { mutableStateOf(false) }
    val localFocusManager = LocalFocusManager.current
    val coroutineScope = rememberCoroutineScope()

    val newItem = remember(createNewItem) { mutableStateOf(createNewItem) }
    val preferencePacks = viewModel.dataManager.preferencePacks.collectAsState()
    val sessionsFlow = viewModel.dataManager.sessions.collectAsState()
    val sessions = remember {
        derivedStateOf { mutableStateListOf(*sessionsFlow.value.orEmpty().toTypedArray()) }
    }
    val interactiveStates = sessions.value.map {
        rememberInteractiveCardState()
    }
    val stopChecking = {
        interactiveStates.forEach {
            it.isChecked.value = false
            it.mode.value = InteractiveCardMode.DATA_DISPLAY
        }
        coroutineScope.launch {
            optionsSheetState.bottomSheetState.collapse()
        }
        selectedSessionUids.clear()
    }
    val listener = remember(viewModel) {
        object: SessionLobbyListener {
            override fun onCreateNewItem() {
                val newSession = SessionIO()
                sessions.value.add(0, newSession)
                stopChecking()
            }
            override fun onCheckingStarted(sessionUid: String) {
                interactiveStates.forEach {
                    it.mode.value = InteractiveCardMode.CHECKING
                }
            }
        }
    }
    changeActionBar {
        SessionLobbyBarActions(
            onChangePreferences = {
                if(preferencePacks.value.isNullOrEmpty().not()) {
                    showPreferenceModal.value = true
                }
            }
        )
    }

    LaunchedEffect(key1 = selectedSessionUids.size) {
        coroutineScope.launch {
            if(selectedSessionUids.size > 0) {
                interactiveStates.forEach {
                    it.mode.value = InteractiveCardMode.CHECKING
                }
                optionsSheetState.bottomSheetState.expand()
                localFocusManager.clearFocus()
            }else stopChecking()
        }
    }
    LaunchedEffect(showPreferenceModal.value) {
        if(showPreferenceModal.value) {
            preferencesSheetState.expand()
        }else preferencesSheetState.hide()
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

    if(showPreferenceModal.value) {
        SimpleModalBottomSheet(
            onDismissRequest = {
                showPreferenceModal.value = false
            },
            sheetState = preferencesSheetState,
        ) {
            PreferenceChooser(
                modifier = Modifier
                    .padding(8.dp)
                    .padding(bottom = 32.dp),
                onDeleteRequest = { preferencePack ->
                    viewModel.requestPreferencePackDelete(preferencePack?.uid)
                },
                requestPreferenceSave = { preferencePack ->
                    viewModel.requestPreferencePackSave(preferencePack)
                },
                defaultPreferencePack = preferencePacks.value?.firstOrNull(),
                mustHaveSelection = false,
                preferencePacks = preferencePacks.value
            )
        }
    }

    if(showDeleteDialog.value) {
        BasicAlertDialog(
            dialogTitle = stringResource(id = R.string.collection_delete_dialog_title),
            dialogText = stringResource(
                id = R.string.collection_delete_dialog_description,
                selectedSessionUids.size
            ),
            icon = Icons.Outlined.Delete,
            confirmButtonState = ButtonState(
                text = stringResource(id = R.string.button_confirm)
            ) {
                coroutineScope.launch(Dispatchers.Default) {
                    sessions.value.removeAll { selectedSessionUids.contains(it.uid) }
                    viewModel.dataManager.sessions.update { list ->
                        list?.toMutableList()?.apply {
                            removeAll { selectedSessionUids.contains(it.uid) }
                        }
                    }
                    viewModel.requestSessionsDeletion(uids = selectedSessionUids.toSet())
                    stopChecking()
                    showDeleteDialog.value = false
                }
            },
            dismissButtonState = ButtonState(
                text = stringResource(id = R.string.button_dismiss)
            ) { showDeleteDialog.value = false }
        )
    }

    val localDensity = LocalDensity.current
    var optionsSheet by remember { mutableStateOf(0.dp) }
    if(sessionsFlow.value != null) {
        ListOptionsBottomSheet(
            modifier = Modifier
                .pointerInput(Unit) {
                    detectTapGestures(onTap = {
                        localFocusManager.clearFocus()
                        stopChecking()
                    })
                }
                .fillMaxSize(),
            onDismissRequest = {
                stopChecking()
            },
            sheetContentModifier = Modifier.onGloballyPositioned { coordinates ->
                optionsSheet = with(localDensity) { coordinates.size.height.toDp() }
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
                    selectedSessionUids.clear()
                }
                /*TODO mix sessisons
                ImageAction(
                    leadingImageVector = Icons.Outlined.PlayArrow,
                    text = stringResource(id = R.string.button_start_session)
                ) {}*/
            },
            state = optionsSheetState
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    state = rememberLazyListState(),
                    verticalArrangement = Arrangement.spacedBy(
                        LocalTheme.shapes.betweenItemsSpace
                    )
                ) {
                    item {
                        Spacer(modifier = Modifier.height(56.dp))
                    }
                    itemsIndexed(
                        sessions.value,
                        key = { _, item -> item.uid }
                    ) { index, session ->
                        interactiveStates.getOrNull(index)?.let { state ->
                            LaunchedEffect(state.isChecked.value) {
                                if(state.isChecked.value) {
                                    selectedSessionUids.add(session.uid)
                                }else selectedSessionUids.remove(session.uid)
                            }
                            SessionCard(
                                modifier = Modifier.fillMaxWidth(),
                                session = session,
                                onEditOptionPressed = {
                                    NavigationUtils.navigateToSessionDetail(
                                        navController = navController,
                                        sessionUid = session.uid,
                                        toolbarTitle = session.name
                                    )
                                },
                                onLongClick = {
                                    listener.onCheckingStarted(session.uid)
                                },
                                state = state
                            )
                        }
                    }
                }
                ComponentHeaderButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    text = stringResource(id = R.string.home_screen_sessions_empty_action)
                ) {
                    listener.onCreateNewItem()
                }
            }
        }
    }else {
        EditableListShimmerLayout()
    }
}

@Composable
fun EditableListShimmerLayout() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .height(55.dp)
                .padding(top = 8.dp, start = 4.dp, end = 4.dp)
                .fillMaxWidth()
                .brandShimmerEffect(LocalTheme.shapes.componentShape)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .height(65.dp)
                .padding(start = 4.dp, end = 4.dp)
                .fillMaxWidth()
                .brandShimmerEffect(LocalTheme.shapes.componentShape)
        )
    }
}