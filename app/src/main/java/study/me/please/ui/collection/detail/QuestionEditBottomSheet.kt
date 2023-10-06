package study.me.please.ui.collection.detail

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Snackbar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material.icons.outlined.ContentPaste
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Deselect
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.SelectAll
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImagePainter
import com.squadris.squadris.compose.theme.Colors
import com.squadris.squadris.compose.theme.LocalTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.base.GeneralClipBoard
import study.me.please.data.io.LargePathAsset
import study.me.please.data.io.QuestionAnswerIO
import study.me.please.data.io.QuestionIO
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.BrandHeaderButton
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.EditFieldInput
import study.me.please.ui.components.EditableImageAsset
import study.me.please.ui.components.ImageAction
import study.me.please.ui.components.InteractiveCardMode
import study.me.please.ui.components.QuestionAnswerCard
import study.me.please.ui.components.SimpleBottomSheet
import study.me.please.ui.components.TextHeader
import study.me.please.ui.components.rememberInteractiveCardState

const val INPUT_DELAYED_RESPONSE_MILLIS = 500L

/**  */
data class QuestionSheetState(
    val promptImageUrl: MutableState<LargePathAsset?> = mutableStateOf(null),
    val explanationImageUrl: MutableState<LargePathAsset?> = mutableStateOf(null),
    val prompt: MutableState<String> = mutableStateOf(""),
    val explanation: MutableState<String> = mutableStateOf("")
)

/** Bottom sheet layout for editing a question */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun QuestionEditBottomSheetContent(
    modifier: Modifier = Modifier,
    questionIO: QuestionIO,
    requestDataSave: () -> Unit,
    clipBoard: GeneralClipBoard,
    onQuestionTestPlay: (question: QuestionIO) -> Unit,
    onDeleteRequest: (selectedAnswerUids: List<String>) -> Unit = {},
    state: BottomSheetScaffoldState = rememberBottomSheetScaffoldState(),
    content: @Composable (paddingValues: PaddingValues) -> Unit = {},
    addExistingAnswer: suspend () -> QuestionAnswerIO?,
    onDismissRequest: () -> Unit = {}
) {
    val questionSheetState = remember { QuestionSheetState() }
    val inputScope = rememberCoroutineScope()
    val showDeleteDialog = remember { mutableStateOf(false) }
    val answers = remember {
        if(questionIO.uid.isNotEmpty()) {
            mutableStateListOf<QuestionAnswerIO?>(*questionIO.answers.toTypedArray())
        } else mutableStateListOf<QuestionAnswerIO?>(null)
    }
    val selectedAnswerUids = remember { mutableStateListOf<String>() }
    val interactiveStates = answers.map {
        rememberInteractiveCardState()
    }
    val stopChecking = {
        interactiveStates.forEach {
            it.isChecked.value = false
            it.mode.value = InteractiveCardMode.DATA_DISPLAY
        }
        selectedAnswerUids.clear()
    }
    if(selectedAnswerUids.size > 0) {
        BackHandler {
            stopChecking()
        }
    }

    if(showDeleteDialog.value) {
        BasicAlertDialog(
            dialogTitle = stringResource(id = R.string.answer_delete_dialog_title),
            dialogText = stringResource(
                id = R.string.answer_delete_dialog_description,
                selectedAnswerUids.size
            ),
            icon = Icons.Outlined.Delete,
            confirmButtonState = ButtonState(
                text = stringResource(id = R.string.button_confirm)
            ) {
                answers.removeAll { selectedAnswerUids.contains(it?.uid) }
                onDeleteRequest(selectedAnswerUids)
                stopChecking()
                showDeleteDialog.value = false
            },
            dismissButtonState = ButtonState(
                text = stringResource(id = R.string.button_dismiss)
            ) { showDeleteDialog.value = false }
        )
    }

    SimpleBottomSheet(
        sheetContent = {
            val itemModifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .wrapContentHeight()
                .fillMaxWidth()

            val coroutineScope = rememberCoroutineScope()
            val localDensity = LocalDensity.current
            var stickyHeaderHeight by remember { mutableStateOf(0.dp) }
            val showNoAnswerSnackbar = remember { mutableStateOf(false) }

            ConstraintLayout(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(
                        start = 8.dp,
                        end = 8.dp,
                        top = 8.dp
                    )
                    .animateContentSize()
                    .systemBarsPadding()
            ) {
                val (stickyHeader, headerContent, questionsContent) = createRefs()

                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .constrainAs(headerContent) {
                            top.linkTo(parent.top)
                            linkTo(parent.start, parent.end)
                            width = Dimension.fillToConstraints
                        }
                ) {
                    ImageAction(
                        leadingImageVector = Icons.Outlined.PlayArrow,
                        text = stringResource(id = R.string.button_test_play),
                        onClick = {
                            onQuestionTestPlay(questionIO)
                        }
                    )
                    // prompt
                    TextHeader(text = stringResource(id = R.string.question_edit_field_prompt_header))
                    EditFieldInput(
                        modifier = itemModifier,
                        value = questionSheetState.prompt.value,
                        hint = stringArrayResource(id = R.array.field_prompt_hint).random(),
                        minLines = 2,
                        maxLines = 2
                    ) { output ->
                        questionSheetState.prompt.value = output
                        questionIO.apply {
                            prompt = output
                        }
                        inputScope.coroutineContext.cancelChildren()
                        inputScope.launch {
                            delay(INPUT_DELAYED_RESPONSE_MILLIS)
                            requestDataSave()
                        }
                    }
                    if(questionSheetState.promptImageUrl.value != null) {
                        TextHeader(text = stringResource(id = R.string.question_edit_field_prompt_image))
                        EditableImageAsset(
                            modifier = itemModifier
                                .animateContentSize(),
                            asset = questionSheetState.promptImageUrl.value,
                            isInEditMode = true,
                            onUrlChange = { output ->
                                inputScope.coroutineContext.cancelChildren()
                                inputScope.launch {
                                    delay(INPUT_DELAYED_RESPONSE_MILLIS)
                                    questionSheetState.promptImageUrl.value = LargePathAsset(
                                        urlPath = output
                                    )
                                }
                            },
                            onLoadState = { loadState ->
                                if(loadState is AsyncImagePainter.State.Success) {
                                    questionIO.imagePromptUrl = questionSheetState.promptImageUrl.value
                                    requestDataSave()
                                }
                            }
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState())
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(
                            LocalTheme.shapes.betweenItemsSpace
                        )
                    ) {
                        if(questionSheetState.promptImageUrl.value == null) {
                            ImageAction(
                                modifier = Modifier,
                                leadingImageVector = Icons.Outlined.Image,
                                text = stringResource(id = R.string.button_add_prompt_image)
                            ) {
                                questionSheetState.promptImageUrl.value = LargePathAsset()
                            }
                        }
                    }

                    // explanation
                    TextHeader(text = stringResource(id = R.string.question_field_explanation_header))
                    EditFieldInput(
                        modifier = itemModifier,
                        value = questionSheetState.explanation.value,
                        hint = stringResource(id = R.string.question_edit_field_hint_explanation),
                        minLines = 5,
                        maxLines = 5
                    ) { output ->
                        questionSheetState.explanation.value = output
                        questionIO.apply {
                            textExplanation = output
                        }
                        inputScope.coroutineContext.cancelChildren()
                        inputScope.launch {
                            delay(INPUT_DELAYED_RESPONSE_MILLIS)
                            requestDataSave()
                        }
                    }
                    if(questionSheetState.explanationImageUrl.value != null) {
                        TextHeader(text = stringResource(id = R.string.question_edit_field_explanation_image))
                        EditableImageAsset(
                            modifier = itemModifier
                                .animateContentSize(),
                            asset = questionSheetState.explanationImageUrl.value,
                            isInEditMode = true,
                            onUrlChange = { output ->
                                inputScope.coroutineContext.cancelChildren()
                                inputScope.launch {
                                    delay(INPUT_DELAYED_RESPONSE_MILLIS)
                                    questionSheetState.explanationImageUrl.value = LargePathAsset(
                                        urlPath = output
                                    )
                                }
                            },
                            onLoadState = { loadState ->
                                if(loadState is AsyncImagePainter.State.Success) {
                                    questionIO.imageExplanationUrl = questionSheetState.explanationImageUrl.value
                                    requestDataSave()
                                }
                            }
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState())
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(
                            LocalTheme.shapes.betweenItemsSpace
                        )
                    ) {
                        if(questionSheetState.explanationImageUrl.value == null) {
                            ImageAction(
                                modifier = Modifier,
                                leadingImageVector = Icons.Outlined.Image,
                                text = stringResource(id = R.string.button_add_explanation_image)
                            ) {
                                questionSheetState.explanationImageUrl.value = LargePathAsset()
                            }
                        }
                    }
                }
                Column(
                  modifier = Modifier
                      .constrainAs(questionsContent) {
                          linkTo(parent.start, parent.end)
                          top.linkTo(headerContent.bottom)
                          width = Dimension.fillToConstraints
                      }
                ) {
                    Spacer(
                        modifier = Modifier
                            .height(stickyHeaderHeight + 16.dp)
                            .systemBarsPadding()
                    )
                    answers.forEachIndexed { index, answer ->
                        (interactiveStates.getOrNull(index) ?: rememberInteractiveCardState()).let { state ->
                            LaunchedEffect(key1 = state.isChecked.value) {
                                if(state.isChecked.value) {
                                    selectedAnswerUids.add(answer?.uid ?: "")
                                }else selectedAnswerUids.remove(answer?.uid)
                            }
                            LaunchedEffect(state.mode.value == InteractiveCardMode.EDIT) {
                                if(state.mode.value == InteractiveCardMode.EDIT) {
                                    interactiveStates.forEachIndexed { stateIndex, state ->
                                        if(index != stateIndex) {
                                            state.mode.value = InteractiveCardMode.DATA_DISPLAY
                                        }
                                    }
                                }
                            }
                            QuestionAnswerCard(
                                modifier = Modifier
                                    .padding(vertical = 4.dp),
                                requestDataSave = {
                                    answers.let { new ->
                                        questionIO.answers = new.filterNotNull().toMutableList()
                                    }
                                    requestDataSave()
                                },
                                state = state,
                                data = answer
                            )
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .onGloballyPositioned { coordinates ->
                            stickyHeaderHeight =
                                with(localDensity) { coordinates.size.height.toDp() }
                        }
                        .constrainAs(stickyHeader) {
                            top.linkTo(headerContent.bottom, 8.dp)
                            linkTo(parent.start, parent.end)
                        }
                ) {
                    // options row
                    OptionsLayout(
                        onCopyRequest = {
                            coroutineScope.launch(Dispatchers.Default) {
                                clipBoard.answers.copyItems(
                                    answers.filter { selectedAnswerUids.contains(it?.uid) }.filterNotNull()
                                )
                                stopChecking()
                            }
                        },
                        onPasteRequest = {
                            answers.addAll(clipBoard.answers.paste())
                            requestDataSave()
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
                            selectedAnswerUids.clear()
                        },
                        isEditMode = selectedAnswerUids.size > 0,
                        hasPasteOption = clipBoard.answers.isEmpty.value.not(),
                        animateTopDown = false
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(horizontal = LocalTheme.shapes.betweenItemsSpace),
                        horizontalArrangement = Arrangement.spacedBy(
                            LocalTheme.shapes.betweenItemsSpace
                        )
                    ) {
                        BrandHeaderButton(
                            modifier = Modifier.weight(1f),
                            text = stringResource(id = R.string.collection_detail_new_response)
                        ) {
                            if(answers.firstOrNull()?.isEmpty != true) {
                                stopChecking()
                                answers.add(0, QuestionAnswerIO())
                            }else {
                                interactiveStates.firstOrNull()?.mode?.value = InteractiveCardMode.EDIT
                            }
                        }
                        BrandHeaderButton(
                            modifier = Modifier.weight(1f),
                            text = stringResource(id = R.string.collection_detail_old_response)
                        ) {
                            stopChecking()
                            coroutineScope.launch {
                                addExistingAnswer().let { newAnswer ->
                                    if(newAnswer != null) {
                                        answers.add(newAnswer)
                                    }else showNoAnswerSnackbar.value = true
                                }
                            }
                        }
                    }
                }
            }
            AnimatedVisibility(visible = showNoAnswerSnackbar.value) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                        .wrapContentHeight(),
                    text = stringResource(id = R.string.collection_detail_no_old_response),
                    fontSize = 16.sp,
                    color = Color.White,
                    textAlign = TextAlign.End
                )
            }
            LaunchedEffect(showNoAnswerSnackbar.value) {
                if(showNoAnswerSnackbar.value) {
                    delay(3000)
                    showNoAnswerSnackbar.value = false
                }
            }
        },
        modifier = modifier,
        onDismissRequest = {
            stopChecking()
            onDismissRequest()
        },
        state = state,
        content = content,
    )

    LaunchedEffect(questionIO) {
        questionSheetState.promptImageUrl.value = questionIO.imagePromptUrl
        questionSheetState.explanationImageUrl.value = questionIO.imageExplanationUrl
        questionSheetState.prompt.value = questionIO.prompt
        questionSheetState.explanation.value = questionIO.textExplanation
        answers.clear()
        answers.addAll(questionIO.answers.toTypedArray())
    }
    // clean-up if needed
    LaunchedEffect(questionSheetState.promptImageUrl.value) {
        if(questionSheetState.promptImageUrl.value?.isEmpty == true) {
            questionIO.imagePromptUrl = null
            requestDataSave()
        }
    }
    LaunchedEffect(questionSheetState.explanationImageUrl.value) {
        if(questionSheetState.explanationImageUrl.value?.isEmpty == true) {
            questionIO.imageExplanationUrl = null
            requestDataSave()
        }
    }
    LaunchedEffect(answers.size) {
        // save only adding, deleting has its own logic
        if(questionIO.answers.size < answers.size) {
            answers.let { new ->
                questionIO.answers = new.filterNotNull().toMutableList()
            }
            requestDataSave()
            interactiveStates.firstOrNull()?.mode?.value = InteractiveCardMode.EDIT
        }else {
            answers.let { new ->
                questionIO.answers = new.filterNotNull().toMutableList()
            }
        }
    }
    LaunchedEffect(selectedAnswerUids.size) {
        if(selectedAnswerUids.size > 0) {
            interactiveStates.forEach {
                it.mode.value = InteractiveCardMode.CHECKING
            }
        }else {
            stopChecking()
            selectedAnswerUids.clear()
        }
    }
}

@Composable
fun OptionsLayout(
    modifier: Modifier = Modifier,
    onDeleteRequest: () -> Unit = {},
    onCopyRequest: () -> Unit = {},
    onPasteRequest: () -> Unit = {},
    selectAllVisible: Boolean = true,
    onSelectAll: () -> Unit = {},
    deselectAllVisible: Boolean = true,
    onDeselectAll: () -> Unit = {},
    isEditMode: Boolean = false,
    hasPasteOption: Boolean = false,
    animateTopDown: Boolean = true
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .horizontalScroll(rememberScrollState())
            .zIndex(-1f),
        horizontalArrangement = Arrangement.spacedBy(
            LocalTheme.shapes.betweenItemsSpace
        )
    ) {
        Spacer(modifier = Modifier.width(LocalTheme.shapes.betweenItemsSpace))
        AnimatedVisibility(
            modifier = Modifier.zIndex(-1f),
            visible = isEditMode,
            enter = slideInVertically(
                initialOffsetY = { it.times(if(animateTopDown) -2 else 2) },
                animationSpec = tween(400)
            ),
            exit = slideOutVertically(
                targetOffsetY = { it.times(if(animateTopDown) -2 else 2) },
                animationSpec = tween(400)
            )
        ) {
            Row(
                modifier = modifier
                    .wrapContentWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.spacedBy(
                    LocalTheme.shapes.betweenItemsSpace
                )
            ) {
                ImageAction(
                    leadingImageVector = Icons.Outlined.Delete,
                    text = stringResource(id = R.string.button_delete),
                    containerColor = Colors.RED_ERROR,
                    onClick = onDeleteRequest
                )
                if(selectAllVisible) {
                    ImageAction(
                        leadingImageVector = Icons.Outlined.SelectAll,
                        text = stringResource(id = R.string.button_select_all),
                        onClick = onSelectAll
                    )
                }
                if(deselectAllVisible) {
                    ImageAction(
                        leadingImageVector = Icons.Outlined.Deselect,
                        text = stringResource(id = R.string.button_deselect),
                        onClick = onDeselectAll
                    )
                }
                ImageAction(
                    leadingImageVector = Icons.Outlined.ContentCopy,
                    text = stringResource(id = R.string.button_copy),
                    onClick = onCopyRequest
                )
            }
        }
        AnimatedVisibility(
            modifier = Modifier.zIndex(-1f),
            visible = hasPasteOption,
            enter = slideInVertically(
                initialOffsetY = { it.times(if(animateTopDown) -2 else 2) },
                animationSpec = tween(400)
            ),
            exit = slideOutVertically(
                targetOffsetY = { it.times(if(animateTopDown) -2 else 2) },
                animationSpec = tween(400)
            )
        ) {
            ImageAction(
                leadingImageVector = Icons.Outlined.ContentPaste,
                text = stringResource(id = R.string.button_paste),
                onClick = onPasteRequest
            )
        }
        Spacer(modifier = Modifier.width(LocalTheme.shapes.betweenItemsSpace))
    }
}

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
private fun Preview() {
    QuestionEditBottomSheetContent(
        questionIO = QuestionIO(),
        requestDataSave = {},
        onQuestionTestPlay = {

        },
        clipBoard = GeneralClipBoard(),
        addExistingAnswer = { null }
    )
}