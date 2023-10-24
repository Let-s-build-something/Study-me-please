package study.me.please.ui.session

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForwardIos
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.squadris.squadris.compose.theme.Colors
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.utils.OnLifecycleEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.base.navigation.SessionAppBarActions
import study.me.please.data.io.LargePathAsset
import study.me.please.data.io.QuestionAnswerIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.ui.components.EditableImageAsset
import study.me.please.ui.components.ImageAction
import study.me.please.ui.components.OutlinedButton
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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SessionScreen(
    isTestingMode: Boolean = false,
    sessionUid: String? = null,
    preferencePackUid: String? = null,
    collectionUid: String? = null,
    questionUid: String? = null,
    questionUids: List<String>? = null,
    changeActionBar: (actions: @Composable RowScope.() -> Unit) -> Unit,
    viewModel: SessionViewModel = hiltViewModel()
) {
    val session = viewModel.session.collectAsState()
    val questions = viewModel.questions.collectAsState()
    val preferencePacks = viewModel.preferencePacks.collectAsState()
    val preferencePack = viewModel.preferencePack.collectAsState()

    val coroutineScope = rememberCoroutineScope()
    val showStatistics = remember { mutableStateOf(false) }
    val showPreferenceModal = remember { mutableStateOf(false) }

    OnLifecycleEvent { event ->
        if(event == Lifecycle.Event.ON_RESUME) {
            changeActionBar {
                SessionAppBarActions(
                    isTest = isTestingMode,
                    onChangePreferences = {
                        showPreferenceModal.value = true
                    },
                    onStatisticsOpen = {
                        showStatistics.value = showStatistics.value.not()
                    }
                )
            }
        }
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
                    viewModel.requestQuestionModuleSave(module)
                }
            )
            val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

            /*LaunchedEffect(preferencePack.value) {
                preferencePack.value?.let { newPreference ->
                    sessionState.sessionPreferencePack.value = newPreference
                }
            }*/
            LaunchedEffect(showPreferenceModal.value) {
                if(showPreferenceModal.value) {
                    sheetState.expand()
                }else sheetState.hide()
            }
            val sessionItem = sessionState.currentItem.collectAsState()
            LaunchedEffect(questions.value) {
                sessionState.module.questions = questions.value.orEmpty()
                sessionState.initialize()
            }
            LaunchedEffect(sessionState.currentItem.value) {
                showStatistics.value = false
            }

            if(showPreferenceModal.value) {
                SimpleModalBottomSheet(
                    onDismissRequest = {
                        showPreferenceModal.value = false
                    },
                    sheetState = sheetState,
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
            BackHandler {
                coroutineScope.launch {
                    sessionState.stepBackward()
                }
            }

            Column {
                AnimatedVisibility(visible = showStatistics.value) {
                    StatisticsTable(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        questionModule = sessionState.module
                    )
                }
                Spacer(modifier = Modifier.height(LocalTheme.shapes.betweenItemsSpace))
                PromptLayout(
                    sessionItem = sessionItem.value,
                    state = sessionState,
                    coroutineScope = coroutineScope
                )
            }
        }
    }
}

@Composable
private fun PromptLayout(
    modifier: Modifier = Modifier,
    coroutineScope: CoroutineScope,
    sessionItem: SessionQuestion,
    state: SessionScreenState
) {
    val question = remember(sessionItem) {
        sessionItem.question ?: sessionItem.historyItem?.questionIO
    }
    val answers = remember(question, sessionItem) {
        derivedStateOf {
            question?.answers?.shuffled()
        }
    }
    val selectedAnswers = remember(sessionItem) { mutableStateListOf<QuestionAnswerIO>() }

    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 24.dp, end = 24.dp)
    ) {
        val (columnContent, btnContinue, btnContinueRepeat) = createRefs()

        val isLocked = state.mode.value == SessionScreenMode.LOCKED || sessionItem.isHistory
        LazyColumn(
            modifier = Modifier
                .constrainAs(columnContent) {
                    linkTo(parent.start, parent.end)
                    linkTo(parent.top, parent.bottom)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
        ) {
            item {
                Text(
                    text = question?.prompt ?: "",
                    fontSize = 22.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(
                            top = 18.dp,
                            end = 12.dp,
                            bottom = 12.dp
                        ),
                    color = LocalTheme.colors.primary,
                    fontWeight = FontWeight.Medium,
                    maxLines = 100,
                    softWrap = true,
                    lineHeight = 24.sp
                )
                EditableImageAsset(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    asset = question?.imagePromptUrl
                )
                if(isLocked) {
                    if(question?.textExplanation.isNullOrEmpty().not()) {
                        Text(
                            text = question?.textExplanation ?: "",
                            color = LocalTheme.colors.secondary,
                            fontSize = 14.sp
                        )
                    }
                    if(question?.imageExplanationUrl?.isEmpty == false) {
                        EditableImageAsset(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            asset = question.imageExplanationUrl
                        )
                    }
                }
            }
            items(
                (if(sessionItem.isHistory) question?.answers else answers.value).orEmpty(),
                key = { it.uid }
            ) { answer ->
                val validation = (sessionItem.historyItem?.answers ?: state.validations).find { it.uid == answer.uid }
                val showResult = validation != null

                OutlinedButton(
                    modifier = if(showResult) {
                        Modifier
                            .background(
                                color = if(validation?.isCorrect == true) {
                                    Colors.GREEN_CORRECT
                                }else Colors.RED_ERROR,
                                shape = LocalTheme.shapes.componentShape
                            )
                    }else Modifier,
                    thenModifier = Modifier
                        .padding(horizontal = 12.dp, vertical = 6.dp),
                    text = answer.text,
                    trailingIcon = if(showResult) {
                        if(validation?.isCorrect == true) {
                            Icons.Outlined.Check
                        }else Icons.Outlined.Close
                    }else if(selectedAnswers.contains(answer)) Icons.Outlined.Check else null,
                    // we don't want to validate again, it's pointless
                    enabled = (state.mode.value == SessionScreenMode.REGULAR || validation != null)
                            && sessionItem.isHistory.not(),
                    onClick = {
                        if(state.sessionPreferencePack.value.manualValidation.value) {
                            if(selectedAnswers.contains(answer)) {
                                selectedAnswers.remove(answer)
                            }else selectedAnswers.add(answer)
                        }else {
                            coroutineScope.launch {
                                state.validateAnswer(answer)
                            }
                        }
                    },
                    activeColor = if(showResult) Color.White else LocalTheme.colors.primary,
                    inactiveColor = if(showResult) Color.White else LocalTheme.colors.secondary
                )
                if(isLocked) {
                    if(answer.explanationMessage.isNotEmpty()) {
                        Text(
                            modifier = Modifier
                                .padding(top = 6.dp, start = 4.dp),
                            text = answer.explanationMessage,
                            color = LocalTheme.colors.secondary,
                            fontSize = 14.sp
                        )
                    }
                    if(answer.imageExplanation?.isEmpty == false) {
                        EditableImageAsset(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp, bottom = 20.dp),
                            asset = answer.imageExplanation
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                Spacer(modifier = Modifier.height(48.dp))
            }
        }

        if(state.validations.any { it.isCorrect.not() }.not()
            && isLocked
            && state.sessionPreferencePack.value.repeatOnMistake.value
        ) {
            ImageAction(
                modifier = Modifier
                    .shadow(
                        elevation = LocalTheme.styles.componentElevation,
                        shape = LocalTheme.shapes.componentShape,
                        clip = true
                    )
                    .constrainAs(btnContinueRepeat) {
                        end.linkTo(parent.end, 8.dp)
                        bottom.linkTo(btnContinue.top, 4.dp)
                    },
                text = stringResource(id = R.string.button_repeat)
            ) {
                coroutineScope.launch {
                    state.stepForward(forceRepeat = true)
                }
            }
        }
        if(isLocked || (state.sessionPreferencePack.value.manualValidation.value
                && selectedAnswers.isNotEmpty())
        ) {
            ImageAction(
                modifier = Modifier
                    .shadow(
                        elevation = LocalTheme.styles.componentElevation,
                        shape = LocalTheme.shapes.componentShape,
                        clip = true
                    )
                    .constrainAs(btnContinue) {
                        end.linkTo(parent.end, 8.dp)
                        bottom.linkTo(parent.bottom, 32.dp)
                    },
                text = stringResource(
                    id = if(state.sessionPreferencePack.value.manualValidation.value
                        && state.mode.value != SessionScreenMode.LOCKED
                    ) {
                        R.string.button_validate
                    } else R.string.button_continue
                ),
                trailingImageVector = Icons.AutoMirrored.Outlined.ArrowForwardIos,
            ) {
                coroutineScope.launch {
                    if(state.sessionPreferencePack.value.manualValidation.value
                        && state.mode.value != SessionScreenMode.LOCKED
                    ) {
                        selectedAnswers.forEach { answer ->
                            state.validateAnswer(answer)
                        }
                    }else {
                        selectedAnswers.clear()
                        state.stepForward()
                    }
                }
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
private fun PromptPreview() {
    Box(modifier = Modifier.background(LocalTheme.colors.backgroundLight)) {
        PromptLayout(
            sessionItem = SessionQuestion(
                isHistory = false,
                question = QuestionIO(
                    prompt = "Some random prompt",
                    textExplanation = "Text explanation",
                    imageExplanationUrl = LargePathAsset(
                        urlPath = "https://www.imgonline.com.ua/examples/bee-on-daisy-mini.jpg"
                    ),
                    answers = mutableListOf(
                        QuestionAnswerIO(text = "Answer 1", isCorrect = false),
                        QuestionAnswerIO(text = "Answer 2", isCorrect = true),
                        QuestionAnswerIO(text = "Answer 3", isCorrect = false),
                        QuestionAnswerIO(text = "Answer 4", isCorrect = false),
                        QuestionAnswerIO(text = "Answer 5", isCorrect = true)
                    )
                ),
                correctAnswers = listOf()
            ),
            state = SessionScreenState(
                QuestionModule(),
                sessionPreferencePack = mutableStateOf(SessionPreferencePack()),
                requestSave = {}
            ).apply {
                mode.value = SessionScreenMode.LOCKED
            },
            coroutineScope = rememberCoroutineScope()
        )
    }
}