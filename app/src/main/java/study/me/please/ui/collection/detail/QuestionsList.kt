package study.me.please.ui.collection.detail

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Deselect
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.SelectAll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.squadris.squadris.compose.theme.Colors
import com.squadris.squadris.compose.theme.LocalTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import study.me.please.R
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.QuestionIO
import study.me.please.ui.components.AddToSessionCollectionSheet
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.BrandHeaderButton
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.ImageAction
import study.me.please.ui.components.InteractiveCardMode
import study.me.please.ui.components.ListOptionsBottomSheet
import study.me.please.ui.components.ProgressIndicator
import study.me.please.ui.components.QuestionCard
import study.me.please.ui.components.rememberInteractiveCardState
import study.me.please.ui.components.tab_switch.DEFAULT_ANIMATION_LENGTH_LONG
import study.me.please.ui.components.tab_switch.DEFAULT_ANIMATION_LENGTH_SHORT
import java.util.UUID

/** Interactive list of questions */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun QuestionsList(
    viewModel: CollectionDetailViewModel,
    collectionDetail: CollectionIO,
    requestCollectionSave: () -> Unit,
    requestQuestionSave: (question: QuestionIO) -> Unit,
    onNavigateToQuestionTest: (questionIO: QuestionIO) -> Unit,
    navigateToSession: (questionUids: List<String>) -> Unit
) {
    val sessions = viewModel.sessions.collectAsState()
    val collectionQuestions = viewModel.collectionQuestions.collectAsState()

    val questionInEdit: MutableState<QuestionIO> = remember(collectionQuestions.value) {
        mutableStateOf(QuestionIO(uid = ""))
    }
    val selectedQuestionUids = remember(collectionQuestions.value) { mutableStateListOf<String>() }
    val questions = remember(collectionQuestions.value) { mutableStateListOf(
        *collectionQuestions.value.toTypedArray()
    ) }

    val coroutineScope = rememberCoroutineScope()
    val localFocusManager = LocalFocusManager.current

    val questionSheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(skipHiddenState = false)
    )
    val interactiveStates = questions.map { rememberInteractiveCardState() }
    val showAddToSheet = remember(collectionQuestions.value) { mutableStateOf(false) }
    val showDeleteDialog = remember(collectionQuestions.value) { mutableStateOf(false) }


    val stopChecking = {
        interactiveStates.forEach {
            it.isChecked.value = false
            it.mode.value = InteractiveCardMode.DATA_DISPLAY
        }
        selectedQuestionUids.clear()
    }
    questions.forEachIndexed { index, fact ->
        interactiveStates.getOrNull(index)?.let { state ->
            LaunchedEffect(state.isChecked.value) {
                if(state.isChecked.value) {
                    selectedQuestionUids.add(fact.uid)
                }else selectedQuestionUids.remove(fact.uid)
            }
        }
    }
    LaunchedEffect(questionInEdit.value) {
        if(questionInEdit.value.uid.isNotEmpty()) {
            localFocusManager.clearFocus()
            questionSheetState.bottomSheetState.expand()
        }else questionSheetState.bottomSheetState.hide()
    }
    LaunchedEffect(key1 = selectedQuestionUids.size) {
        coroutineScope.launch {
            if(selectedQuestionUids.size > 0) {
                interactiveStates.forEach {
                    it.mode.value = InteractiveCardMode.CHECKING
                }
                localFocusManager.clearFocus()
            }else stopChecking()
        }
    }
    LaunchedEffect(key1 = questions.size) {
        coroutineScope.launch(Dispatchers.Default) {
            collectionDetail.questionUidList.apply {
                addAll(questions.map { it.uid })
            }
            requestCollectionSave()
        }
    }

    if(selectedQuestionUids.size > 0) {
        BackHandler {
            stopChecking()
        }
    }
    if(questionInEdit.value.uid.isNotEmpty()) {
        BackHandler {
            questionInEdit.value = QuestionIO(uid = "")
        }
    }

    if(showAddToSheet.value) {
        AddToSessionCollectionSheet(
            tabs = mutableListOf(
                stringResource(id = R.string.screen_sessions_title)
            ),
            sessions = sessions.value,
            isShimmering = sessions.value == null,
            selectedCollections = selectedQuestionUids,
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

    if(showDeleteDialog.value) {
        BasicAlertDialog(
            dialogTitle = stringResource(id = R.string.question_delete_dialog_title),
            dialogText = stringResource(
                id = R.string.question_delete_dialog_description,
                selectedQuestionUids.size
            ),
            icon = Icons.Outlined.Delete,
            confirmButtonState = ButtonState(
                text = stringResource(id = R.string.button_confirm)
            ) {
                coroutineScope.launch(Dispatchers.Default) {
                    questions.removeAll { selectedQuestionUids.contains(it.uid) }
                    viewModel.requestQuestionsDeletion(uidList = selectedQuestionUids.toSet())
                    stopChecking()
                    showDeleteDialog.value = false
                }
            },
            dismissButtonState = ButtonState(
                text = stringResource(id = R.string.button_dismiss)
            ) { showDeleteDialog.value = false }
        )
    }

    QuestionEditBottomSheetContent(
        questionIO = questionInEdit.value,
        onDismissRequest = {
            questionInEdit.value = QuestionIO(uid = "")
        },
        requestDataSave = {
            requestQuestionSave(questionInEdit.value)
        },
        onDeleteRequest = { uids ->
            viewModel.requestAnswersDeletion(
                uidList = uids.toSet(),
                question = questionInEdit.value
            )
        },
        onQuestionTestPlay = onNavigateToQuestionTest,
        state = questionSheetState,
        clipBoard = viewModel.clipBoard,
        addExistingAnswer = {
            withContext(Dispatchers.Default) {
                questions.filter { it.uid != questionInEdit.value.uid }
                    .flatMap { question -> question.answers.map { answer ->
                        answer.copy().also {
                            it.explanationMessage = if(answer.isCorrect) {
                                "${question.prompt}\n\n${it.explanationMessage}"
                            }else answer.explanationMessage
                            it.isCorrect = false
                        }
                    } }
                    .filter { newAnswer ->
                        questionInEdit.value.answers.any { oldAnswer ->
                            oldAnswer.text == newAnswer.text
                        }.not()
                    }
                    .randomOrNull()
                    ?.copy(uid = UUID.randomUUID().toString())
            }
        },
        content = {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                val (progressScrollbar, content) = createRefs()

                val questionsScrollState = rememberLazyListState()
                /*ProgressIndicator(
                    modifier = Modifier
                        .constrainAs(progressScrollbar) {
                            end.linkTo(parent.end, 2.dp)
                            linkTo(content.top, content.bottom)
                        },
                    scrollState = questionsScrollState
                )*/

                LazyColumn(
                    modifier = Modifier
                        .constrainAs(content) {
                            linkTo(parent.start, parent.end)
                            linkTo(parent.top, parent.bottom, bias = 0f)
                            width = Dimension.fillToConstraints
                        },
                    state = questionsScrollState,
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    stickyHeader {
                        BrandHeaderButton(
                            modifier = Modifier
                                .zIndex(100f)
                                .fillMaxWidth(0.85f),
                            text = stringResource(id = R.string.collection_detail_add_question)
                        ) {
                            stopChecking()
                            questions.add(
                                index = 0,
                                QuestionIO().also { newQuestion ->
                                    questionInEdit.value = newQuestion
                                }
                            )
                        }
                    }
                    stickyHeader {
                        OptionsLayout(
                            onCopyRequest = {
                                coroutineScope.launch(Dispatchers.Default) {
                                    viewModel.clipBoard.questions.copyItems(
                                        questions.filter { selectedQuestionUids.contains(it.uid) }
                                    )
                                    stopChecking()
                                }
                            },
                            onPasteRequest = {
                                questions.addAll(0, viewModel.clipBoard.questions.paste())
                                stopChecking()
                            },
                            onDeleteRequest = {
                                showDeleteDialog.value = true
                            },
                            onSelectAll = {
                                interactiveStates.forEach {
                                    it.isChecked.value = true
                                }
                            },
                            onDeselectAll = {
                                selectedQuestionUids.clear()
                            },
                            isEditMode = selectedQuestionUids.size > 0,
                            hasPasteOption = viewModel.clipBoard.questions.isEmpty.value.not(),
                            animateTopDown = false
                        ) {
                            AnimatedVisibility(visible = selectedQuestionUids.size > 0) {
                                ImageAction(
                                    leadingImageVector = Icons.Outlined.Add,
                                    text = stringResource(id = R.string.button_add_to)
                                ) {
                                    viewModel.requestSessions()
                                    showAddToSheet.value = true
                                }
                            }
                            AnimatedVisibility(visible = selectedQuestionUids.size > 0) {
                                ImageAction(
                                    leadingImageVector = Icons.Outlined.PlayArrow,
                                    text = stringResource(id = R.string.button_start_session)
                                ) {
                                    navigateToSession(selectedQuestionUids.toList())
                                    stopChecking()
                                }
                            }
                        }
                    }
                    itemsIndexed(questions) { index, question ->
                        QuestionCard(
                            modifier = Modifier
                                .zIndex(1f)
                                .padding(bottom = if (index == questions.lastIndex) 48.dp else 0.dp),
                            data = question,
                            requestDataSave = {
                                requestQuestionSave(question)
                            },
                            onNavigateToSession = onNavigateToQuestionTest,
                            state = interactiveStates.getOrNull(index) ?: rememberInteractiveCardState(),
                            onClick = {
                                questionInEdit.value = question
                            }
                        )
                        Spacer(modifier = Modifier.height(LocalTheme.shapes.betweenItemsSpace))
                    }
                }
            }
        }
    )
}