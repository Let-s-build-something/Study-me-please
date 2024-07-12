package study.me.please.ui.collection.detail.questions.detail

import androidx.activity.compose.BackHandler
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material.icons.outlined.PlayArrow
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
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImagePainter
import com.squadris.squadris.compose.base.LocalNavController
import com.squadris.squadris.compose.components.navigation.ActionBarIcon
import com.squadris.squadris.compose.components.navigation.NavIconType
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.ext.scalingClickable
import com.squadris.squadris.utils.RefreshableViewModel.Companion.requestData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.base.navigation.NavigationRoot
import study.me.please.data.io.FactType
import study.me.please.data.io.LargePathAsset
import study.me.please.data.io.QuestionAnswerIO
import study.me.please.ui.collection.detail.REQUEST_DATA_SAVE_DELAY
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.BrandHeaderButton
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.EditFieldInput
import study.me.please.ui.components.EditableImageAsset
import study.me.please.ui.components.ImageAction
import study.me.please.ui.components.ListItemEditField
import study.me.please.ui.components.OptionsLayout
import study.me.please.ui.components.QuestionAnswerCard
import study.me.please.ui.components.TextHeader
import study.me.please.ui.components.pull_refresh.PullRefreshScreen

/** delay for a generic reaction to an input value change */
const val INPUT_DELAYED_RESPONSE_MILLIS = 500L

/** Editable detail of a question */
@Composable
fun QuestionDetailScreen(
    questionUid: String,
    collectionUid: String,
    toolbarTitle: String?,
    viewModel: QuestionDetailViewModel = hiltViewModel()
) {
    val focusManager = LocalFocusManager.current

    val question = viewModel.questionDetail.collectAsState()

    val navController = LocalNavController.current
    val savingScope = rememberCoroutineScope()
    val coroutineScope = rememberCoroutineScope()
    val promptSingleFR = remember(questionUid) { FocusRequester() }
    val promptMultiFR = remember(questionUid) { FocusRequester() }

    val livePrompt = remember(questionUid) {
        mutableStateOf(question.value?.promptList?.firstOrNull())
    }
    val imagePromptUrl = remember(question.value?.imagePromptUrl) {
        mutableStateOf(question.value?.imagePromptUrl)
    }
    val imageExplanationUrl = remember(question.value?.imageExplanationUrl) {
        mutableStateOf(question.value?.imageExplanationUrl)
    }
    var showDeleteDialog by remember { mutableStateOf(false) }
    val listItems = remember(question.value?.promptList) {
        mutableStateListOf(
            *question.value?.promptList?.ifEmpty {
                listOf(question.value?.prompt ?: "")
            }?.toTypedArray().orEmpty()
        )
    }
    val checkedAnswerUidList = remember {
        mutableStateListOf<String>()
    }
    val isReadOnly = remember {
        derivedStateOf { collectionUid.isBlank() }
    }
    val selectedAnswerUid = remember {
        mutableStateOf<String?>(null)
    }

    val bridge = remember(questionUid) {
        object: QuestionDetailBridge {
            override fun addNewAnswer() {
                val newAnswer = QuestionAnswerIO()
                viewModel.addNewAnswer(newAnswer)
                checkedAnswerUidList.clear()
                selectedAnswerUid.value = newAnswer.uid
            }

            override fun updateAnswer(answer: QuestionAnswerIO) {
                savingScope.coroutineContext.cancelChildren()
                savingScope.launch {
                    delay(REQUEST_DATA_SAVE_DELAY)
                    question.value?.let {
                        viewModel.updateAnswer(answer)
                    }
                }
            }

            override fun pasteRequest() {
                viewModel.pasteAnswers()
                checkedAnswerUidList.clear()
            }

            override fun deleteAnswers(uids: List<String>) {
                viewModel.requestAnswersDeletion(uids.toSet())
                checkedAnswerUidList.clear()
            }

            override fun updateQuestion() {
                savingScope.coroutineContext.cancelChildren()
                savingScope.launch {
                    delay(REQUEST_DATA_SAVE_DELAY)
                    question.value?.let {
                        viewModel.updateQuestion(it)
                    }
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.questionUid = questionUid
        viewModel.collectionUid = collectionUid
        viewModel.requestData(isSpecial = true)
    }

    LaunchedEffect(listItems.size) {
        if((question.value?.promptList?.size ?: 0) != listItems.size) {
            question.value?.copy(promptList = listItems.toMutableList())?.let {
                viewModel.updateQuestion(it)
            }
        }
    }

    if(showDeleteDialog) {
        BasicAlertDialog(
            title = stringResource(id = R.string.answer_delete_dialog_title),
            content = stringResource(
                id = R.string.answer_delete_dialog_description,
                checkedAnswerUidList.size
            ),
            icon = Icons.Outlined.Delete,
            confirmButtonState = ButtonState(
                text = stringResource(id = R.string.button_confirm)
            ) {
                bridge.deleteAnswers(checkedAnswerUidList)
                checkedAnswerUidList.clear()
            },
            dismissButtonState = ButtonState(
                text = stringResource(id = R.string.button_dismiss)
            ),
            onDismissRequest = { showDeleteDialog = false }
        )
    }

    PullRefreshScreen(
        viewModel = viewModel,
        title = livePrompt.value ?: toolbarTitle,
        subtitle = stringResource(R.string.question),
        navIconType = NavIconType.CLOSE,
        actionIcons = {
            ActionBarIcon(
                text = stringResource(id = R.string.button_test_play),
                imageVector = Icons.Outlined.PlayArrow,
                onClick = {
                    navController?.navigate(
                        NavigationRoot.SessionPlay.createRoute(
                            NavigationRoot.SessionPlay.SessionPlayArgument(
                                toolbarTitle = question.value?.prompt ?: "",
                                questionUid = questionUid,
                                isTestingMode = true
                            )
                        )
                    )
                }
            )
        }
    ) {
        BackHandler(checkedAnswerUidList.size > 0) {
            checkedAnswerUidList.clear()
        }

        val itemModifier = Modifier
            .padding(vertical = 8.dp)
            .wrapContentHeight()
            .fillMaxWidth()

        Column(
            modifier = Modifier
                .imePadding()
                .padding(horizontal = 8.dp)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(14.dp))

            // prompt
            TextHeader(text = stringResource(id = R.string.question_edit_field_prompt_header))

            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                val isIrremovable = listItems.size <= 1

                listItems.forEachIndexed { index, listItem ->
                    Crossfade(
                        modifier = Modifier.animateContentSize(),
                        targetState = listItems.size == 1,
                        label = "SingleEditToMultipleCrossfade"
                    ) { isSingleItem ->
                        if(isSingleItem) {
                            EditFieldInput(
                                modifier = Modifier
                                    .focusRequester(promptSingleFR)
                                    .fillMaxWidth(),
                                value = listItem,
                                enabled = isReadOnly.value.not(),
                                hint = stringArrayResource(id = R.array.field_prompt_hint).random(),
                                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                                keyboardActions = KeyboardActions(
                                    onNext = {
                                        listItems.add("")
                                        coroutineScope.launch {
                                            delay(50)
                                            focusManager.moveFocus(FocusDirection.Down)
                                        }
                                    }
                                ),
                                onEntered = { text ->
                                    listItems.add(index + 1, text.toString())
                                    coroutineScope.launch {
                                        delay(50)
                                        focusManager.moveFocus(FocusDirection.Down)
                                    }
                                },
                                minLines = 1,
                                maxLines = 5,
                                identifier = questionUid
                            ) { output ->
                                listItems[0] = output
                                livePrompt.value = output
                                question.value?.promptList = listOf(output)
                                bridge.updateQuestion()
                            }
                        }else {
                            ListItemEditField(
                                modifier = Modifier
                                    .then(
                                        if (index == listItems.lastIndex) {
                                            Modifier.focusRequester(promptMultiFR)
                                        } else Modifier
                                    ),
                                prefix = FactType.BULLET_POINT_PREFIX,
                                identifier = index.toString(),
                                onBackspaceKey = {
                                    if(isIrremovable.not()) {
                                        if(index > 0 && it.isNotBlank()) {
                                            listItems[index - 1] += it
                                        }
                                        if(listItems.size > 1 && index != 0) {
                                            focusManager.moveFocus(FocusDirection.Up)
                                        }
                                        if(it.isEmpty() || index > 0) {
                                            listItems.removeAt(index)
                                        }
                                    }
                                },
                                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                                keyboardActions = KeyboardActions(
                                    onNext = {
                                        listItems.add(index + 1, "")
                                        coroutineScope.launch {
                                            delay(50)
                                            focusManager.moveFocus(FocusDirection.Down)
                                        }
                                    }
                                ),
                                onEntered = { text ->
                                    listItems.add(index + 1, text.toString())
                                    coroutineScope.launch {
                                        delay(50)
                                        focusManager.moveFocus(FocusDirection.Down)
                                    }
                                },
                                hint = stringArrayResource(id = R.array.field_prompt_hint).random(),
                                value = AnnotatedString(listItem),
                                onValueChange = { output ->
                                    if(index == 0) {
                                        livePrompt.value = output
                                    }
                                    if(listItems.size > index) {
                                        listItems[index] = output
                                        question.value?.promptList = listItems.toList()
                                        bridge.updateQuestion()
                                    }
                                }
                            )
                        }
                    }
                }
            }

            if(question.value?.imagePromptUrl != null) {
                TextHeader(text = stringResource(id = R.string.question_edit_field_prompt_image))
                EditableImageAsset(
                    modifier = itemModifier
                        .animateContentSize(),
                    asset = imagePromptUrl.value,
                    isInEditMode = true,
                    onUrlChange = { output ->
                        imagePromptUrl.value = LargePathAsset(urlPath = output)
                    },
                    onLoadState = { loadState ->
                        if(loadState is AsyncImagePainter.State.Success) {
                            question.value?.imagePromptUrl = imagePromptUrl.value
                            bridge.updateQuestion()
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
                    LocalTheme.current.shapes.betweenItemsSpace
                )
            ) {
                if(imagePromptUrl.value == null) {
                    ImageAction(
                        modifier = Modifier,
                        leadingImageVector = Icons.Outlined.Image,
                        text = stringResource(id = R.string.button_add_prompt_image)
                    ) {
                        imagePromptUrl.value = LargePathAsset()
                    }
                }
            }

            // explanation
            TextHeader(text = stringResource(id = R.string.question_field_explanation_header))
            EditFieldInput(
                modifier = itemModifier,
                enabled = isReadOnly.value.not(),
                value = question.value?.textExplanation ?: "",
                hint = stringResource(id = R.string.question_edit_field_hint_explanation),
                minLines = 5,
                maxLines = 5
            ) { output ->
                question.value?.textExplanation = output
                bridge.updateQuestion()
            }
            if(imageExplanationUrl.value != null) {
                TextHeader(text = stringResource(id = R.string.question_edit_field_explanation_image))
                EditableImageAsset(
                    modifier = itemModifier
                        .animateContentSize(),
                    asset = imageExplanationUrl.value,
                    isInEditMode = isReadOnly.value.not(),
                    onUrlChange = { output ->
                        imageExplanationUrl.value = LargePathAsset(urlPath = output)
                    },
                    onLoadState = { loadState ->
                        if(loadState is AsyncImagePainter.State.Success) {
                            question.value?.imageExplanationUrl = imageExplanationUrl.value
                            bridge.updateQuestion()
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
                    LocalTheme.current.shapes.betweenItemsSpace
                )
            ) {
                if(imageExplanationUrl.value == null) {
                    ImageAction(
                        modifier = Modifier,
                        leadingImageVector = Icons.Outlined.Image,
                        text = stringResource(id = R.string.button_add_explanation_image)
                    ) {
                        imageExplanationUrl.value = LargePathAsset()
                    }
                }
            }

            if(isReadOnly.value.not()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = LocalTheme.current.shapes.betweenItemsSpace)
                        .zIndex(10f),
                    horizontalArrangement = Arrangement.spacedBy(
                        LocalTheme.current.shapes.betweenItemsSpace
                    )
                ) {
                    BrandHeaderButton(
                        modifier = Modifier.weight(1f),
                        text = stringResource(id = R.string.question_detail_new_answer)
                    ) {
                        if(question.value?.answers?.firstOrNull()?.isEmpty != true) {
                            bridge.addNewAnswer()
                        }else {
                            selectedAnswerUid.value = question.value?.answers?.firstOrNull()?.uid
                        }
                    }
                }
            }

            // options row
            OptionsLayout(
                onCopyRequest = {
                    coroutineScope.launch(Dispatchers.Default) {
                        viewModel.clipBoard.answers.copyItems(
                            question.value?.answers?.filter { checkedAnswerUidList.contains(it.uid) }.orEmpty()
                        )
                        checkedAnswerUidList.clear()
                    }
                },
                onPasteRequest = { bridge.pasteRequest() },
                onDeleteRequest = { showDeleteDialog = true },
                onSelectAll = {
                    checkedAnswerUidList.addAll(question.value?.answers?.map { it.uid }.orEmpty())
                },
                onDeselectAll = { checkedAnswerUidList.clear() },
                isEditMode = checkedAnswerUidList.size > 0,
                hasPasteOption = viewModel.clipBoard.answers.isEmpty.value.not(),
                animateTopDown = true,
                onClipBoardRemoval = { viewModel.clipBoard.answers.clear() }
            )

            question.value?.answers?.forEach { answer ->
                QuestionAnswerCard(
                    modifier = Modifier
                        .scalingClickable(
                            onTap = {
                                if (checkedAnswerUidList.size > 0) {
                                    if (checkedAnswerUidList.contains(answer.uid)) {
                                        checkedAnswerUidList.remove(answer.uid)
                                    } else checkedAnswerUidList.add(answer.uid)
                                } else {
                                    selectedAnswerUid.value = answer.uid
                                }
                            },
                            onLongPress = {
                                checkedAnswerUidList.add(answer.uid)
                            }
                        )
                        .padding(vertical = 4.dp),
                    requestDataSave = {
                        bridge.updateAnswer(it)
                    },
                    data = answer,
                    isSelected = selectedAnswerUid.value == answer.uid,
                    isChecked = if(checkedAnswerUidList.size > 0) {
                        checkedAnswerUidList.contains(answer.uid)
                    }else null,
                    onCheckedChange = {
                        if(it && checkedAnswerUidList.contains(answer.uid).not()) {
                            checkedAnswerUidList.add(answer.uid)
                        }else {
                            checkedAnswerUidList.remove(answer.uid)
                        }
                        selectedAnswerUid.value = null
                    }
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}