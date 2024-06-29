package study.me.please.ui.session.play

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.gestures.stopScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DoorBack
import androidx.compose.material.icons.outlined.SkipNext
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.squadris.squadris.compose.base.LocalNavController
import com.squadris.squadris.compose.components.SimpleModalBottomSheet
import com.squadris.squadris.compose.components.navigation.NavIconType
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.utils.OnLifecycleEvent
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.base.BrandBaseScreen
import study.me.please.base.navigation.SessionAppBarActions
import study.me.please.data.io.BaseResponse
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.data.state.session.SessionScreenMode
import study.me.please.ui.collection.EmptyLayout
import study.me.please.ui.collection.detail.REQUEST_DATA_SAVE_DELAY
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.ComponentHeaderButton
import study.me.please.ui.components.preference_chooser.PreferenceChooser
import study.me.please.ui.components.preference_chooser.PreferenceChooserController
import study.me.please.ui.components.session.StatisticsTable

/** how many items behind the front can be skipped forward */
private const val INDEXES_FOR_SKIP_TO_FRONT = 5

/**
 * Screen for displaying and answering questions within pre-defined session
 * @param isTestingMode the session will not be saved.
 *                      Session also has extra functionality for discovery purposes
 * @param sessionUid session identifier
 * @param preferencePackUid identifier for chosen session preferences
 * @param collectionUid collection identifier
 * @param questionUid question identifier
 * @param questionUids question identifiers
 */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun SessionScreen(
    title: String? = null,
    isTestingMode: Boolean = false,
    sessionUid: String? = null,
    preferencePackUid: String? = null,
    collectionUid: String? = null,
    questionUid: String? = null,
    questionUids: List<String>? = null,
    viewModel: SessionViewModel = hiltViewModel()
) {
    val navController = LocalNavController.current
    val context = LocalContext.current

    val questionModule = viewModel.questionModule.collectAsState()
    val questions = viewModel.questions.collectAsState()
    val preferencePacks = viewModel.preferencePacks.collectAsState()
    val preferencePack = viewModel.preferencePack.collectAsState()
    val generatingResponse = viewModel.questionsGeneratingResponse.collectAsState()

    val coroutineScope = rememberCoroutineScope()
    val savingScope = rememberCoroutineScope()
    var showStatistics by remember { mutableStateOf(false) }
    var showPreferenceModal by remember { mutableStateOf(false) }
    var showExitDialog by remember { mutableStateOf(false) }

    if(showExitDialog) {
        BasicAlertDialog(
            title = stringResource(id = R.string.session_leave_dialog_title),
            content = stringResource(R.string.session_leave_dialog_content),
            icon = Icons.Outlined.DoorBack,
            confirmButtonState = ButtonState(
                text = stringResource(id = R.string.button_confirm)
            ) {
                navController?.popBackStack()
            },
            dismissButtonState = ButtonState(
                text = stringResource(id = R.string.button_cancel)
            ),
            onDismissRequest = { showExitDialog = false }
        )
    }

    LaunchedEffect(Unit) {
        viewModel.requestStateData(
            context = context,
            isTestingMode = isTestingMode,
            sessionUid = sessionUid,
            collectionUid = collectionUid,
            questionUid = questionUid,
            questionUids = questionUids,
            preferencePackUid = preferencePackUid
        )
    }

    BrandBaseScreen(
        modifier = Modifier.fillMaxSize(),
        actionIcons = {
            SessionAppBarActions(
                isTest = isTestingMode,
                onChangePreferences = { showPreferenceModal = true },
                onStatisticsOpen = { showStatistics = showStatistics.not() }
            )
        },
        title = title,
        navIconType = NavIconType.CLOSE,
        onBackPressed = {
            if(isTestingMode.not()) showExitDialog = true
            isTestingMode
        }
    ) {
        Crossfade(
            targetState = questions.value.isNullOrEmpty().not() && preferencePack.value != null,
            label = "crossFadeContent"
        ) { isReady ->
            if(isReady) {
                preferencePack.value?.let { preference ->
                    questionModule.value?.let { module ->
                        val sessionState = rememberSessionScreenState(
                            module = module,
                            isTest = isTestingMode,
                            sessionPreferencePack = mutableStateOf(preference),
                            requestSave = { moduleToSave ->
                                savingScope.coroutineContext.cancelChildren()
                                savingScope.launch {
                                    delay(REQUEST_DATA_SAVE_DELAY)
                                    viewModel.requestSessionSave(moduleToSave.copy())
                                }
                            }
                        )
                        val preferenceSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

                        val liveIndex = sessionState.liveIndex.collectAsState()
                        val totalItemsCount = sessionState.module.totalItemsCount.collectAsState()

                        OnLifecycleEvent {
                            when(it) {
                                Lifecycle.Event.ON_RESUME -> sessionState.module.stopwatch.start()
                                Lifecycle.Event.ON_PAUSE -> sessionState.module.stopwatch.stop()
                                else -> {}
                            }
                        }

                        LaunchedEffect(showPreferenceModal) {
                            if(showPreferenceModal) {
                                preferenceSheetState.expand()
                            }else preferenceSheetState.hide()
                        }
                        LaunchedEffect(questions.value) {
                            if(questions.value.isNullOrEmpty().not()) {
                                sessionState.initialize(questions = questions.value.orEmpty())
                            }
                        }

                        Crossfade(
                            targetState = liveIndex.value != -1 && sessionState.module.questionsStack.isNotEmpty(),
                            label = "crossFadeContent"
                        ) { isDone ->
                            if(isDone) {
                                val pagerState = rememberPagerState(
                                    pageCount = {
                                        totalItemsCount.value
                                    },
                                    initialPage = sessionState.module.currentIndex
                                )

                                LaunchedEffect(pagerState) {
                                    snapshotFlow { pagerState.currentPage }.collectLatest { newIndex ->
                                        showStatistics = false
                                        sessionState.module.currentIndex = newIndex
                                        sessionState.liveIndex.value = newIndex

                                        savingScope.coroutineContext.cancelChildren()
                                        savingScope.launch {
                                            delay(REQUEST_DATA_SAVE_DELAY)
                                            viewModel.requestSessionSave(sessionState.module.copy())
                                        }
                                    }
                                }

                                LaunchedEffect(liveIndex.value) {
                                    val canBeSkipped = sessionState.module.getStepAt(liveIndex.value)?.mode?.value == SessionScreenMode.LOCKED
                                            || sessionState.module.getStepAt(liveIndex.value)?.isHistory == true

                                    if(canBeSkipped.not() && pagerState.currentPage >= sessionState.module.history.size) {
                                        sessionState.module.stopwatch.start()
                                    }
                                }

                                // blocking of scrolling to future questions
                                LaunchedEffect(pagerState) {
                                    snapshotFlow { pagerState.currentPageOffsetFraction }.collect { offset ->
                                        val canBeSkipped = sessionState.module.getStepAt(liveIndex.value)?.mode?.value == SessionScreenMode.LOCKED
                                                || sessionState.module.getStepAt(liveIndex.value)?.isHistory == true

                                        if(canBeSkipped.not() && offset > 0f && pagerState.currentPage >= sessionState.module.history.size) {
                                            pagerState.stopScroll(MutatePriority.PreventUserInput)
                                            // return to previous state
                                            pagerState.scrollToPage(sessionState.module.history.size)
                                        }
                                    }
                                }

                                if(showPreferenceModal) {
                                    SimpleModalBottomSheet(
                                        onDismissRequest = { showPreferenceModal = false },
                                        sheetState = preferenceSheetState,
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
                                                    sessionState.sessionPreferencePack.value = preference
                                                    viewModel.requestSessionSave(preferencePack = preference)
                                                }
                                            },
                                            defaultPreferencePack = sessionState.sessionPreferencePack.value,
                                            preferencePacks = preferencePacks.value
                                        )
                                    }
                                }


                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    AnimatedVisibility(visible = showStatistics) {
                                        StatisticsTable(
                                            modifier = Modifier
                                                .padding(16.dp)
                                                .fillMaxWidth(),
                                            questionModule = sessionState.module
                                        )
                                        Spacer(modifier = Modifier.height(LocalTheme.current.shapes.betweenItemsSpace))
                                    }
                                    AnimatedVisibility(
                                        modifier = Modifier.padding(vertical = 4.dp),
                                        visible = liveIndex.value < sessionState.module.history.size.minus(
                                            INDEXES_FOR_SKIP_TO_FRONT
                                        )
                                    ) {
                                        ComponentHeaderButton(
                                            startIconVector = Icons.Outlined.SkipNext,
                                            text = stringResource(id = R.string.button_skip_to_front),
                                            onClick = {
                                                coroutineScope.launch {
                                                    pagerState.animateScrollToPage(sessionState.module.history.size)
                                                }
                                            }
                                        )
                                    }
                                    HorizontalPager(
                                        state = pagerState,
                                        beyondBoundsPageCount = 1
                                    ) { index ->
                                        sessionState.module.getStepAt(index)?.let { item ->
                                            PromptLayout(
                                                sessionItem = item,
                                                sessionPreferencePack = sessionState.sessionPreferencePack.value,
                                                state = sessionState,
                                                stepForward = {
                                                    coroutineScope.launch {
                                                        pagerState.animateScrollToPage(pagerState.currentPage.plus(1))
                                                    }
                                                },
                                                index = index
                                            )
                                        }
                                    }
                                }
                            }else {
                                ExceptionLayout(
                                    response = generatingResponse.value
                                )
                            }
                        }
                    }
                }
            }else {
                ExceptionLayout(
                    response = generatingResponse.value
                )
            }
        }
    }
}

@Composable
private fun ExceptionLayout(
    response: BaseResponse<*>?
) {
    when {
        response?.responseCode == 204 -> {
            EmptyLayout(
                emptyText = stringResource(R.string.subject_generating_error_no_data)
            )
        }
        response?.responseCode != 200 && response?.responseCode != null -> {
            EmptyLayout(
                emptyText = stringResource(R.string.subject_generating_error_generic)
            )
        }
        // loading
        else -> {
            EmptyLayout(
                rawAnimation = R.raw.loading_generic,
                emptyText = stringResource(R.string.unit_session_loading)
            )
        }
    }
}