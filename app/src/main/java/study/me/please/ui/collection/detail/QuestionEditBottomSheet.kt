package study.me.please.ui.collection.detail

import android.annotation.SuppressLint
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material.icons.outlined.ContentPaste
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import com.squadris.squadris.compose.theme.AppTheme
import com.squadris.squadris.compose.theme.Colors
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import study.me.please.R
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
import study.me.please.ui.components.rememberInteractiveCardState

const val INPUT_DELAYED_RESPONSE_MILLIS = 500L

/**  */
data class QuestionSheetState(
    val promptImageUrl: MutableState<LargePathAsset?> = mutableStateOf(null),
    val explanationImageUrl: MutableState<LargePathAsset?> = mutableStateOf(null)
)

/** Bottom sheet layout for editing a question */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun QuestionEditBottomSheetContent(
    modifier: Modifier = Modifier,
    questionIO: QuestionIO,
    requestDataSave: () -> Unit,
    onQuestionTestPlay: (question: QuestionIO) -> Unit,
    onDeleteRequest: (selectedAnswerUids: List<String>) -> Unit = {},
    onCopyRequest: (selectedAnswerUids: List<String>) -> Unit = {},
    state: BottomSheetScaffoldState = rememberBottomSheetScaffoldState(),
    content: @Composable (paddingValues: PaddingValues) -> Unit = {},
    onDismissRequest: () -> Unit = {}
) {
    val questionSheetState = remember {
        QuestionSheetState(
            promptImageUrl = mutableStateOf(
                questionIO.imagePromptUrl
            ),
            explanationImageUrl = mutableStateOf(
                questionIO.imageExplanationUrl
            )
        )
    }
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

            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(
                        start = 8.dp,
                        end = 8.dp,
                        top = 8.dp,
                        bottom = 32.dp
                    )
            ) {
                // options row
                if(selectedAnswerUids.size > 0) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState())
                            .padding(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OptionsLayout(
                            onCopyRequest = {
                                onCopyRequest(selectedAnswerUids)
                            },
                            onPasteRequest = {

                            },
                            onDeleteRequest = {
                                showDeleteDialog.value = true
                            },
                            onTestPlay = {
                                onQuestionTestPlay(questionIO)
                            },
                            isEditMode = selectedAnswerUids.size > 0,
                            hasPasteOption = false //TODO
                        )
                    }
                }

                // prompt
                TextHeader(text = stringResource(id = R.string.question_edit_field_prompt_header))
                EditFieldInput(
                    modifier = itemModifier,
                    value = questionIO.prompt,
                    hint = stringArrayResource(id = R.array.field_prompt_hint).random(),
                    minLines = 2,
                    maxLines = 2
                ) { output ->
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
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    if(questionSheetState.promptImageUrl.value == null) {
                        ImageAction(
                            modifier = Modifier,
                            imageVector = Icons.Outlined.Image,
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
                    value = questionIO.textExplanation,
                    hint = stringResource(id = R.string.question_edit_field_hint_explanation),
                    minLines = 3,
                    maxLines = 3
                ) { output ->
                    questionIO.apply {
                        textExplanation = output
                    }
                    inputScope.coroutineContext.cancelChildren()
                    inputScope.launch {
                        delay(INPUT_DELAYED_RESPONSE_MILLIS)
                        requestDataSave()
                    }
                }
                if(questionSheetState.promptImageUrl.value != null) {
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
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    if(questionSheetState.explanationImageUrl.value == null) {
                        ImageAction(
                            modifier = Modifier,
                            imageVector = Icons.Outlined.Image,
                            text = stringResource(id = R.string.button_add_explanation_image)
                        ) {
                            questionSheetState.explanationImageUrl.value = LargePathAsset()
                        }
                    }
                }

                answers.forEachIndexed { index, answer ->
                    (interactiveStates.getOrNull(index) ?: rememberInteractiveCardState()).let { state ->
                        LaunchedEffect(key1 = state.isChecked.value) {
                            if(state.isChecked.value) {
                                selectedAnswerUids.add(answer?.uid ?: "")
                            }else selectedAnswerUids.remove(answer?.uid)
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
                BrandHeaderButton(
                    modifier = Modifier.padding(bottom = 16.dp),
                    text = stringResource(id = R.string.collection_detail_new_response)
                ) {
                    answers.add(
                        QuestionAnswerIO()
                    )
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
    LaunchedEffect(questionIO) {
        questionSheetState.promptImageUrl.value = questionIO.imagePromptUrl
        questionSheetState.explanationImageUrl.value = questionIO.imageExplanationUrl
        answers.clear()
        answers.addAll(questionIO.answers.toTypedArray())
    }
}

@Composable
private fun TextHeader(text: String) {
    Text(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(top = 8.dp, start = 8.dp, bottom = 2.dp),
        text = text,
        fontSize = 16.sp,
        color = AppTheme.colors.secondary,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun OptionsLayout(
    onDeleteRequest: () -> Unit = {},
    onCopyRequest: () -> Unit = {},
    onPasteRequest: () -> Unit = {},
    onTestPlay: () -> Unit = {},
    isEditMode: Boolean = false,
    hasPasteOption: Boolean = false
) {
    if(isEditMode) {
        ImageAction(
            imageVector = Icons.Outlined.Delete,
            text = stringResource(id = R.string.collection_list_delete_item),
            containerColor = Colors.RED_ERROR,
            onClick = onDeleteRequest
        )
        ImageAction(
            imageVector = Icons.Outlined.ContentCopy,
            text = stringResource(id = R.string.button_copy),
            onClick = onCopyRequest
        )
    }
    if(hasPasteOption) {
        ImageAction(
            imageVector = Icons.Outlined.ContentPaste,
            text = stringResource(id = R.string.button_paste),
            onClick = onPasteRequest
        )
    }
    ImageAction(
        imageVector = Icons.Outlined.PlayArrow,
        text = stringResource(id = R.string.button_test_play),
        onClick = onTestPlay
    )
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

        }
    )
}