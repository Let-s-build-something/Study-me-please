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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Deselect
import androidx.compose.material.icons.outlined.SelectAll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
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
import com.squadris.squadris.compose.components.DEFAULT_ANIMATION_LENGTH_SHORT
import com.squadris.squadris.compose.theme.Colors
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.ext.brandShimmerEffect
import com.squadris.squadris.utils.OnLifecycleEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.base.LocalNavController
import study.me.please.base.navigation.NavigationComponent
import study.me.please.base.navigation.NavigationDestination
import study.me.please.base.navigation.SessionLobbyBarActions
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.ComponentHeaderButton
import study.me.please.ui.components.ImageAction
import study.me.please.ui.components.InteractiveCardMode
import study.me.please.ui.components.ListOptionsBottomSheet
import study.me.please.ui.components.preference_chooser.PreferenceChooser
import study.me.please.ui.components.session.SessionCard
import study.me.please.ui.components.SimpleModalBottomSheet
import study.me.please.ui.components.preference_chooser.PreferenceChooserController
import study.me.please.ui.components.pull_refresh.PullRefreshScreen
import study.me.please.ui.components.rememberInteractiveCardState

/** communication bridge for controlling session lobby screen */
interface SessionLobbyListener {
    fun onCreateNewItem()
    fun onCheckingStarted()
}
//TODO SessionLobbyListener needs to be redone into a controller and big refactor needed,
//TODO with OptionsLayout and some animations
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
    val preferencePacks = viewModel.preferencePacks.collectAsState()
    val sessionsFlow = viewModel.sessions.collectAsState()

    val optionsSheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(skipHiddenState = false)
    )
    val preferencesSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val showPreferenceModal = remember { mutableStateOf(false) }
    val selectedSessionUids = remember { mutableStateListOf<String>() }
    val showDeleteDialog = remember { mutableStateOf(false) }
    val newItem = remember(createNewItem) { mutableStateOf(createNewItem) }
    val interactiveStates = sessions.value?.map {
        rememberInteractiveCardState()
    }
    var optionsSheetHeight by remember { mutableStateOf(0.dp) }

    val stopChecking = {
        interactiveStates?.forEach {
            it.isChecked.value = false
            it.mode.value = InteractiveCardMode.DATA_DISPLAY
        }
        coroutineScope.launch {
            optionsSheetState.bottomSheetState.hide()
        }
        selectedSessionUids.clear()
    }
    val listener = remember(viewModel) {
        object: SessionLobbyListener {
            override fun onCreateNewItem() {
                viewModel.addNewSession()
                stopChecking()
            }
            override fun onCheckingStarted() {
                interactiveStates?.forEach {
                    it.mode.value = InteractiveCardMode.CHECKING
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.requestPreferencePacks()
    }
    LaunchedEffect(key1 = selectedSessionUids.size) {
        coroutineScope.launch {
            if(selectedSessionUids.size > 0) {
                interactiveStates?.forEach {
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
                controller = object: PreferenceChooserController {
                    override fun addPreferencePack(name: String): SessionPreferencePack {
                        return viewModel.addNewPreferencePack(name = name)
                    }
                    override fun savePreference(preference: SessionPreferencePack) {
                        viewModel.requestPreferencePackSave(preference)
                    }
                    override fun deletePreference(preferenceUid: String) {
                        viewModel.requestPreferencePackDelete(preferenceUid)
                    }
                    override fun choosePreference(preference: SessionPreferencePack) {
                    }
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

    PullRefreshScreen(
        viewModel = viewModel,
        actionIcons = {
            SessionLobbyBarActions(
                onChangePreferences = {
                    if(preferencePacks.value.isNullOrEmpty().not()) {
                        showPreferenceModal.value = true
                    }
                }
            )
        },
        title = stringResource(id = R.string.screen_session_lobby_title)
    ) { paddingValues ->
        if(sessionsFlow.value != null) {
            ListOptionsBottomSheet(
                modifier = Modifier
                    .pointerInput(Unit) {
                        detectTapGestures(onTap = {
                            stopChecking()
                        })
                    }
                    .padding(paddingValues)
                    .fillMaxSize(),
                onDismissRequest = {
                    stopChecking()
                },
                sheetContentModifier = Modifier.onGloballyPositioned { coordinates ->
                    optionsSheetHeight = with(localDensity) { coordinates.size.height.toDp() }
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
                        interactiveStates?.forEach {
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
            ) { modalPaddingValues ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(modalPaddingValues)
                ) {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        state = rememberLazyListState(),
                        verticalArrangement = Arrangement.spacedBy(
                            LocalTheme.shapes.betweenItemsSpace
                        )
                    ) {
                        stickyHeader {
                            ComponentHeaderButton(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = LocalTheme.shapes.betweenItemsSpace),
                                text = stringResource(id = R.string.home_screen_sessions_empty_action)
                            ) {
                                listener.onCreateNewItem()
                            }
                        }
                        itemsIndexed(
                            sessions.value.orEmpty(),
                            key = { _, item -> item.uid }
                        ) { index, session ->
                            interactiveStates?.getOrNull(index)?.let { state ->
                                LaunchedEffect(state.isChecked.value) {
                                    if(state.isChecked.value) {
                                        selectedSessionUids.add(session.uid)
                                    }else selectedSessionUids.remove(session.uid)
                                }
                                SessionCard(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .animateItemPlacement(
                                            tween(
                                                durationMillis = DEFAULT_ANIMATION_LENGTH_SHORT,
                                                easing = LinearOutSlowInEasing
                                            )
                                        ),
                                    session = session,
                                    onEditOptionPressed = {
                                        navController?.navigate(
                                            NavigationDestination.SessionDetail.createRoute(
                                                NavigationComponent.SESSION_UID to session.uid,
                                                NavigationComponent.TOOLBAR_TITLE to session.name
                                            )
                                        )
                                    },
                                    state = state
                                )
                            }
                        }
                    }
                }
            }
        }else {
            EditableListShimmerLayout(
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}

@Composable
fun EditableListShimmerLayout(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(LocalTheme.shapes.betweenItemsSpace))
        repeat(3) {
            Box(
                modifier = Modifier
                    .height(70.dp)
                    .padding(start = 4.dp, end = 4.dp)
                    .fillMaxWidth()
                    .brandShimmerEffect(LocalTheme.shapes.componentShape)
            )
            Spacer(modifier = Modifier.height(LocalTheme.shapes.betweenItemsSpace))
        }
        Box(
            modifier = Modifier
                .height(55.dp)
                .padding(start = 4.dp, end = 4.dp)
                .fillMaxWidth()
                .brandShimmerEffect(LocalTheme.shapes.componentShape)
        )
    }
}