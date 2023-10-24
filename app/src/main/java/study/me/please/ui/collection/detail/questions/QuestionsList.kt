package study.me.please.ui.collection.detail.questions

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imeNestedScroll
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
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
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.squadris.squadris.compose.components.ChipState
import com.squadris.squadris.compose.components.CustomChipGroup
import com.squadris.squadris.compose.components.CustomChipType
import com.squadris.squadris.compose.components.DEFAULT_ANIMATION_LENGTH_SHORT
import com.squadris.squadris.compose.components.rememberCustomChipGroupState
import com.squadris.squadris.compose.theme.LocalTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.data.io.QuestionIO
import study.me.please.ui.collection.detail.CollectionDetailViewModel
import study.me.please.ui.collection.detail.INPUT_DELAYED_RESPONSE_MILLIS
import study.me.please.ui.collection.detail.OptionsLayout
import study.me.please.ui.collection.detail.QuestionEditBottomSheetContent
import study.me.please.ui.components.AddToSessionCollectionSheet
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.BrandHeaderButton
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.ImageAction
import study.me.please.ui.components.InteractiveCardMode
import study.me.please.ui.components.QuestionCard
import study.me.please.ui.components.rememberInteractiveCardState

private const val CHIP_HAS_IMAGE_ID = "HAS_IMAGE_CHIP"
private const val CHIP_IS_INVALID_ID = "IS_INVALID_CHIP"

/** Interactive list of questions */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class,
    ExperimentalLayoutApi::class
)
@Composable
fun QuestionsList(
    viewModel: CollectionDetailViewModel,
    requestQuestionSave: (question: QuestionIO) -> Unit,
    onNavigateToQuestionTest: (questionIO: QuestionIO) -> Unit,
    navigateToSession: (questionUids: List<String>) -> Unit
) {
    val sessions = viewModel.sessions.collectAsState()
    val questions = viewModel.collectionQuestions.collectAsState(initial = listOf())
    val chipsFilter = viewModel.questionsFilter.collectAsState()

    val coroutineScope = rememberCoroutineScope()
    val inputScope = rememberCoroutineScope()
    val localFocusManager = LocalFocusManager.current
    val context = LocalContext.current

    val questionSheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            skipHiddenState = false, initialValue = SheetValue.Hidden
        )
    )
    val interactiveStates = questions.value.map { rememberInteractiveCardState() }
    val showAddToSheet = remember(questions.value) { mutableStateOf(false) }
    val showDeleteDialog = remember(questions.value) { mutableStateOf(false) }
    val chipGroupState = rememberCustomChipGroupState(
        onCheckedChipsChanged = { chipUids ->
            viewModel.questionsFilter.update { previousFilter ->
                QuestionsFilter(
                    text = previousFilter.text,
                    hasImage = chipUids.contains(CHIP_HAS_IMAGE_ID),
                    isInvalid = chipUids.contains(CHIP_IS_INVALID_ID)
                )
            }
        }
    )

    val controller = object: QuestionsListController {
        val questionInEdit: MutableState<QuestionIO> = remember(questions.value) {
            mutableStateOf(QuestionIO(uid = ""))
        }
        val selectedQuestionUids = remember(questions.value) { mutableStateListOf<String>() }

        init {
            LaunchedEffect(selectedQuestionUids.size) {
                coroutineScope.launch {
                    if(selectedQuestionUids.size > 0) {
                        interactiveStates.forEach {
                            it.mode.value = InteractiveCardMode.CHECKING
                        }
                        localFocusManager.clearFocus()
                    }else stopChecking()
                }
            }
        }
        override fun addQuestion() {
            questionInEdit.value = viewModel.addNewQuestion()
            stopChecking()
        }
        override fun stopChecking() {
            interactiveStates.forEach {
                it.isChecked.value = false
                it.mode.value = InteractiveCardMode.DATA_DISPLAY
            }
            selectedQuestionUids.clear()
        }
        override fun deleteQuestions() {
            viewModel.requestQuestionsDeletion(
                uidList = selectedQuestionUids.toSet()
            )
            stopChecking()
        }
        override fun deleteAnswers(uidList: List<String>) {
            viewModel.requestAnswersDeletion(
                uidList = uidList.toSet(),
                question = questionInEdit.value
            )
        }
        override fun openQuestion(question: QuestionIO) {
            questionInEdit.value = question
            coroutineScope.launch {
                localFocusManager.clearFocus()
                questionSheetState.bottomSheetState.expand()
            }
            localFocusManager.clearFocus()
        }
        override fun closeQuestion() {
            questionInEdit.value = QuestionIO(uid = "")
            if(questionSheetState.bottomSheetState.isVisible) {
                coroutineScope.launch {
                    questionSheetState.bottomSheetState.hide()
                }
            }
            localFocusManager.clearFocus()
        }
        override fun copyItems() {
            coroutineScope.launch(Dispatchers.Default) {
                viewModel.clipBoard.questions.copyItems(
                    questions.value.filter { selectedQuestionUids.contains(it.uid) }
                )
                stopChecking()
            }
        }
    }

    questions.value.forEachIndexed { index, question ->
        interactiveStates.getOrNull(index)?.let { state ->
            LaunchedEffect(state.isChecked.value) {
                if(state.isChecked.value) {
                    controller.selectedQuestionUids.add(question.uid)
                }else controller.selectedQuestionUids.remove(question.uid)
            }
        }
    }

    if(controller.selectedQuestionUids.size > 0) {
        BackHandler {
            controller.stopChecking()
        }
    }
    if(controller.questionInEdit.value.uid.isNotEmpty()) {
        BackHandler {
            controller.closeQuestion()
        }
    }

    if(showAddToSheet.value) {
        AddToSessionCollectionSheet(
            tabs = mutableListOf(
                stringResource(id = R.string.screen_sessions_title)
            ),
            sessions = sessions.value,
            isShimmering = sessions.value == null,
            selectedCollections = controller.selectedQuestionUids,
            onConfirmation = { sessionList, _ ->
                if(sessionList.isNullOrEmpty().not()) {
                    viewModel.requestSessionsSave(sessionList.orEmpty())
                }
                controller.stopChecking()
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
                controller.selectedQuestionUids.size
            ),
            icon = Icons.Outlined.Delete,
            confirmButtonState = ButtonState(
                text = stringResource(id = R.string.button_confirm)
            ) {
                coroutineScope.launch(Dispatchers.Default) {
                    controller.deleteQuestions()
                    showDeleteDialog.value = false
                }
            },
            dismissButtonState = ButtonState(
                text = stringResource(id = R.string.button_dismiss)
            ) { showDeleteDialog.value = false }
        )
    }

    val localDensity = LocalDensity.current
    var stickyHeaderHeight by remember { mutableStateOf(0.dp) }

    QuestionEditBottomSheetContent(
        questionIO = controller.questionInEdit.value,
        onDismissRequest = {
            Log.d("questions_list", "question in edit, onDismissRequest")
            controller.closeQuestion()
        },
        requestDataSave = {
            requestQuestionSave(controller.questionInEdit.value)
        },
        onDeleteRequest = { uids ->
            controller.deleteAnswers(uids)
        },
        onQuestionTestPlay = onNavigateToQuestionTest,
        sheetState = questionSheetState,
        clipBoard = viewModel.clipBoard,
        content = {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 12.dp)
            ) {
                val (progressScrollbar, content, btnAddItem) = createRefs()

                val questionsScrollState = rememberLazyListState()
                /*ProgressIndicator(
                    modifier = Modifier
                        .constrainAs(progressScrollbar) {
                            end.linkTo(parent.end, 2.dp)
                            linkTo(content.top, content.bottom)
                        },
                    scrollState = questionsScrollState
                )*/

                BrandHeaderButton(
                    modifier = Modifier
                        .zIndex(100f)
                        .onGloballyPositioned { coordinates ->
                            stickyHeaderHeight =
                                with(localDensity) { coordinates.size.height.toDp() }
                        }
                        .fillMaxWidth(0.85f)
                        .constrainAs(btnAddItem) {
                            linkTo(parent.start, parent.end)
                            top.linkTo(parent.top)
                        },
                    text = stringResource(id = R.string.collection_detail_add_question)
                ) {
                    controller.stopChecking()
                    controller.addQuestion()
                }
                LazyColumn(
                    modifier = Modifier
                        .constrainAs(content) {
                            linkTo(parent.start, parent.end)
                            linkTo(parent.top, parent.bottom, bias = 0f)
                            width = Dimension.fillToConstraints
                        }
                        // glitchy .imeNestedScroll()
                        .imePadding(),
                    state = questionsScrollState,
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if(questions.value.isNotEmpty() || chipsFilter.value.isEmpty().not()) {
                        item {
                            val isSearchActivated = remember(chipsFilter.value) { mutableStateOf(chipsFilter.value.text.isNotEmpty()) }
                            val chips = mutableListOf(
                                ChipState(
                                    type = CustomChipType.SEARCH,
                                    chipText = remember { mutableStateOf(chipsFilter.value.text) },
                                    onSearchOutput = { output ->
                                        inputScope.coroutineContext.cancelChildren()
                                        inputScope.launch {
                                            delay(INPUT_DELAYED_RESPONSE_MILLIS)
                                            viewModel.questionsFilter.update { previousFilter ->
                                                QuestionsFilter(
                                                    text = output,
                                                    hasImage = previousFilter.hasImage,
                                                    isInvalid = previousFilter.isInvalid
                                                )
                                            }
                                        }
                                    },
                                    onChipPressed = {
                                        isSearchActivated.value = isSearchActivated.value.not()
                                    },
                                    isChecked = isSearchActivated
                                ),
                                ChipState(
                                    type = CustomChipType.REGULAR,
                                    chipText = remember {
                                        mutableStateOf(context.getString(R.string.questions_list_chip_has_image))
                                    },
                                    isChecked = remember(chipsFilter.value.hasImage) {
                                        mutableStateOf(chipsFilter.value.hasImage)
                                    },
                                    uid = CHIP_HAS_IMAGE_ID,
                                ),
                                ChipState(
                                    type = CustomChipType.REGULAR,
                                    chipText = remember {
                                        mutableStateOf(context.getString(R.string.questions_list_chip_is_invalid))
                                    },
                                    isChecked = remember(chipsFilter.value.isInvalid) {
                                        mutableStateOf(chipsFilter.value.isInvalid)
                                    },
                                    uid = CHIP_IS_INVALID_ID
                                ),
                                ChipState(
                                    type = CustomChipType.SORT,
                                    onChipPressed = {
                                        //TODO popup of some sorts
                                    }
                                )
                            )
                            Column {
                                Spacer(modifier = Modifier.height(stickyHeaderHeight))
                                CustomChipGroup(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .zIndex(10f)
                                        .animateItemPlacement(),
                                    state = chipGroupState,
                                    chips = remember {
                                        mutableStateListOf(*chips.toTypedArray())
                                    }
                                )
                            }
                        }
                    }
                    item {
                        OptionsLayout(
                            onCopyRequest = {
                                controller.copyItems()
                            },
                            onPasteRequest = {
                                viewModel.pasteQuestionsClipBoard()
                                controller.stopChecking()
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
                                controller.selectedQuestionUids.clear()
                            },
                            isEditMode = controller.selectedQuestionUids.size > 0,
                            hasPasteOption = viewModel.clipBoard.questions.isEmpty.value.not(),
                            animateTopDown = false
                        ) {
                            AnimatedVisibility(visible = controller.selectedQuestionUids.size > 0) {
                                ImageAction(
                                    leadingImageVector = Icons.Outlined.Add,
                                    text = stringResource(id = R.string.button_add_to)
                                ) {
                                    viewModel.requestSessions()
                                    showAddToSheet.value = true
                                }
                            }
                            AnimatedVisibility(visible = controller.selectedQuestionUids.size > 0) {
                                ImageAction(
                                    leadingImageVector = Icons.Outlined.PlayArrow,
                                    text = stringResource(id = R.string.button_start_session)
                                ) {
                                    navigateToSession(controller.selectedQuestionUids.toList())
                                    controller.stopChecking()
                                }
                            }
                        }
                    }
                    itemsIndexed(
                        questions.value,
                        key = { _, question -> question.uid }
                    ) { index, question ->
                        QuestionCard(
                            modifier = Modifier
                                .zIndex(1f)
                                .animateItemPlacement(
                                    tween(
                                        durationMillis = DEFAULT_ANIMATION_LENGTH_SHORT,
                                        easing = LinearOutSlowInEasing
                                    )
                                ),
                            data = question,
                            requestDataSave = {
                                requestQuestionSave(question)
                            },
                            onNavigateToSession = onNavigateToQuestionTest,
                            state = interactiveStates.getOrNull(index) ?: rememberInteractiveCardState(),
                            onClick = {
                                controller.openQuestion(question)
                            }
                        )
                        Spacer(modifier = Modifier.height(LocalTheme.shapes.betweenItemsSpace))
                    }
                    item {
                        Spacer(modifier = Modifier.height(48.dp))
                    }
                }
            }
        }
    )
}