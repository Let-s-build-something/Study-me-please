package study.me.please.ui.session.play

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.squadris.squadris.compose.theme.LocalTheme
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import study.me.please.base.BrandBaseScreen
import study.me.please.base.LocalNavController
import study.me.please.base.navigation.NavIconType
import study.me.please.base.navigation.SessionAppBarActions
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.ui.components.SimpleModalBottomSheet
import study.me.please.ui.components.preference_chooser.PreferenceChooser
import study.me.please.ui.components.preference_chooser.PreferenceChooserController
import study.me.please.ui.components.session.StatisticsTable

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
    val session = viewModel.session.collectAsState()
    val questions = viewModel.questions.collectAsState()
    val preferencePacks = viewModel.preferencePacks.collectAsState()
    val preferencePack = viewModel.preferencePack.collectAsState()

    val navController = LocalNavController.current

    val coroutineScope = rememberCoroutineScope()
    var showStatistics by remember { mutableStateOf(false) }
    var showPreferenceModal by remember { mutableStateOf(false) }
    var showExitDialog by remember { mutableStateOf(false) }

    if(showExitDialog) {
        //TODO exit dialog
        navController?.popBackStack()
        showExitDialog = false
    }

    LaunchedEffect(Unit) {
        viewModel.requestStateData(
            isTestingMode = isTestingMode,
            sessionUid = sessionUid,
            collectionUid = collectionUid,
            questionUid = questionUid,
            questionUids = questionUids,
            preferencePackUid = preferencePackUid
        )
    }

    if(questions.value.isNullOrEmpty().not() && preferencePack.value != null) {
        preferencePack.value?.let { preference ->
            val sessionState = rememberSessionScreenState(
                session.value?.questionModule ?: QuestionModule(),
                isTest = isTestingMode,
                sessionPreferencePack = mutableStateOf(preference),
                requestSave = { module ->
                    viewModel.requestQuestionModuleSave(module.copy())
                }
            )
            val preferenceSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

            val liveIndex = sessionState.liveIndex.collectAsState()
            val totalItemsCount = sessionState.module.totalItemsCount.collectAsState()

            LaunchedEffect(showPreferenceModal) {
                if(showPreferenceModal) {
                    preferenceSheetState.expand()
                }else preferenceSheetState.hide()
            }
            LaunchedEffect(questions.value) {
                sessionState.initialize(questions = questions.value.orEmpty())
            }

            if(sessionState.module.questionsStack.isNotEmpty()) {
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
                        showExitDialog = true
                        false
                    }
                ) { paddingValues ->
                    Column(
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        AnimatedVisibility(visible = showStatistics) {
                            StatisticsTable(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth(),
                                questionModule = sessionState.module
                            )
                            Spacer(modifier = Modifier.height(LocalTheme.shapes.betweenItemsSpace))
                            //TODO pagerState.currentPage + 1/totalItemCount info banner
                            //TODO currentIndex isn't getting saved for some reason
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
                }
            }
        }
    }else {
        //TODO ShmmerLayout
    }
}