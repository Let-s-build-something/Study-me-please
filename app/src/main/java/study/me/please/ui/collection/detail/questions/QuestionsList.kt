package study.me.please.ui.collection.detail.questions

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.squadris.squadris.compose.base.LocalNavController
import com.squadris.squadris.compose.components.ScrollBarProgressIndicator
import com.squadris.squadris.compose.components.chips.ChipState
import com.squadris.squadris.compose.components.chips.CustomChipGroup
import com.squadris.squadris.compose.components.chips.CustomChipType
import com.squadris.squadris.compose.components.chips.DEFAULT_ANIMATION_LENGTH_SHORT
import com.squadris.squadris.compose.components.chips.rememberCustomChipGroupState
import com.squadris.squadris.compose.theme.LocalTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.base.navigation.NavigationRoot
import study.me.please.data.io.QuestionIO
import study.me.please.ui.collection.EmptyLayout
import study.me.please.ui.collection.detail.CollectionDetailViewModel
import study.me.please.ui.collection.detail.questions.detail.INPUT_DELAYED_RESPONSE_MILLIS
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.BrandHeaderButton
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.ImageAction
import study.me.please.ui.components.InteractiveCardMode
import study.me.please.ui.components.OptionsLayout
import study.me.please.ui.components.QuestionCard
import study.me.please.ui.components.rememberInteractiveCardState
import study.me.please.ui.components.session.launcher.SessionLauncher

private const val CHIP_HAS_IMAGE_ID = "HAS_IMAGE_CHIP"
private const val CHIP_IS_INVALID_ID = "IS_INVALID_CHIP"

/** Interactive list of questions */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun QuestionsList(
    modifier: Modifier = Modifier,
    viewModel: CollectionDetailViewModel
) {
    val questions = viewModel.collectionQuestions.collectAsState(initial = listOf())
    val chipsFilter = viewModel.questionsFilter.collectAsState()

    val coroutineScope = rememberCoroutineScope()
    val inputScope = rememberCoroutineScope()
    val localFocusManager = LocalFocusManager.current
    val navController = LocalNavController.current
    val context = LocalContext.current

    val interactiveStates = questions.value.map { rememberInteractiveCardState() }
    val showSessionLauncher = remember(questions.value) { mutableStateOf(false) }
    val showDeleteDialog = remember(questions.value) { mutableStateOf(false) }
    val chipGroupState = rememberCustomChipGroupState(
        onCheckedChipsChanged = { chipUids ->
            viewModel.questionsFilter.update { previousFilter ->
                previousFilter.copy(
                    hasImage = chipUids.contains(CHIP_HAS_IMAGE_ID),
                    isInvalid = chipUids.contains(CHIP_IS_INVALID_ID),
                )
            }
        }
    )

    val sortChipIcon = remember {
        mutableStateOf<ImageVector?>(chipsFilter.value.sortBy.getDirectionIcon())
    }
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
                        previousFilter.copy(text = output)
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
            chipText = remember {
                mutableStateOf(context.getString(R.string.facts_type_date))
            },
            type = CustomChipType.SORT,
            icon = sortChipIcon,
            onChipPressed = {
                viewModel.questionsFilter.update { previousFilter ->
                    sortChipIcon.value = (if(previousFilter.sortBy == SortByType.DATE_CREATED_ASC) {
                        SortByType.DATE_CREATED_DESC
                    }else SortByType.DATE_CREATED_ASC).getDirectionIcon()

                    previousFilter.copy(
                        sortBy = if(previousFilter.sortBy == SortByType.DATE_CREATED_ASC) {
                            SortByType.DATE_CREATED_DESC
                        }else SortByType.DATE_CREATED_ASC
                    )
                }
            }
        )
    )

    val controller = object: QuestionsListController {
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
            val newQuestion = viewModel.addNewQuestion()
            navController?.navigate(
                NavigationRoot.QuestionDetail.createRoute(
                    NavigationRoot.QuestionDetail.QuestionDetailArgument(
                        toolbarTitle = newQuestion.prompt,
                        questionUid = newQuestion.uid
                    )
                )
            )
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
        override fun openQuestion(question: QuestionIO) {
            navController?.navigate(
                NavigationRoot.QuestionDetail.createRoute(
                    NavigationRoot.QuestionDetail.QuestionDetailArgument(
                        toolbarTitle = question.prompt,
                        questionUid = question.uid
                    )
                )
            )
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

    if(showDeleteDialog.value) {
        BasicAlertDialog(
            title = stringResource(id = R.string.question_delete_dialog_title),
            content = stringResource(
                id = R.string.question_delete_dialog_description,
                controller.selectedQuestionUids.size
            ),
            icon = Icons.Outlined.Delete,
            confirmButtonState = ButtonState(
                text = stringResource(id = R.string.button_confirm)
            ) {
                coroutineScope.launch(Dispatchers.Default) {
                    controller.deleteQuestions()
                }
            },
            dismissButtonState = ButtonState(
                text = stringResource(id = R.string.button_dismiss)
            ),
            onDismissRequest = { showDeleteDialog.value = false }
        )
    }

    if(showSessionLauncher.value) {
        SessionLauncher(
            questionUidList = controller.selectedQuestionUids,
            onDismissRequest = {
                showSessionLauncher.value = false
            }
        )
    }

    Crossfade(
        modifier = modifier.fillMaxSize(),
        targetState = questions.value.isEmpty(),
        label = "crossfadeLoadingContent"
    ) { isLoading ->
        if(isLoading) {
            EmptyLayout(
                emptyText = stringResource(id = R.string.collection_questions_empty_error)
            )
        }else {
            Box {
                val questionsScrollState = rememberLazyListState()

                ScrollBarProgressIndicator(
                    modifier = Modifier
                        .zIndex(2f)
                        .rotate(90f)
                        .width(LocalConfiguration.current.screenHeightDp.dp)
                        .offset(y = (-LocalConfiguration.current.screenWidthDp.dp / 2) + 6.dp)
                        .align(Alignment.CenterEnd),
                    scrollState = questionsScrollState,
                    totalItems = questions.value.size
                )
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .imePadding(),
                    state = questionsScrollState,
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    stickyHeader {
                        Column(modifier = Modifier.fillMaxWidth()) {
                            if(questions.value.isNotEmpty() || chipsFilter.value.isEmpty().not()) {
                                CustomChipGroup(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 4.dp)
                                        .zIndex(10f),
                                    state = chipGroupState,
                                    chips = remember {
                                        mutableStateListOf(*chips.toTypedArray())
                                    }
                                )
                            }

                            BrandHeaderButton(
                                modifier = Modifier
                                    .padding(horizontal = 8.dp)
                                    .zIndex(10f)
                                    .fillMaxWidth(),
                                text = stringResource(id = R.string.collection_detail_add_question)
                            ) {
                                controller.stopChecking()
                                controller.addQuestion()
                            }

                            OptionsLayout(
                                onCopyRequest = { controller.copyItems() },
                                onPasteRequest = {
                                    viewModel.pasteQuestionsClipBoard()
                                    controller.stopChecking()
                                },
                                onDeleteRequest = { showDeleteDialog.value = true },
                                onSelectAll = {
                                    interactiveStates.forEach {
                                        it.isChecked.value = true
                                    }
                                },
                                onDeselectAll = { controller.selectedQuestionUids.clear() },
                                isEditMode = controller.selectedQuestionUids.size > 0,
                                hasPasteOption = viewModel.clipBoard.questions.isEmpty.value.not(),
                                animateTopDown = true,
                                onClipBoardRemoval = { viewModel.clipBoard.questions.clear() }
                            ) {
                                AnimatedVisibility(visible = controller.selectedQuestionUids.size > 0) {
                                    ImageAction(
                                        leadingImageVector = Icons.Outlined.PlayArrow,
                                        text = stringResource(id = R.string.button_start_session)
                                    ) {
                                        controller.stopChecking()
                                        showSessionLauncher.value = true
                                    }
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
                                .fillMaxWidth()
                                .animateItemPlacement(
                                    tween(
                                        durationMillis = DEFAULT_ANIMATION_LENGTH_SHORT,
                                        easing = LinearOutSlowInEasing
                                    )
                                ),
                            data = question,
                            state = interactiveStates.getOrNull(index) ?: rememberInteractiveCardState(),
                            onClick = {
                                controller.openQuestion(question)
                            }
                        )
                        Spacer(modifier = Modifier.height(LocalTheme.current.shapes.betweenItemsSpace))
                    }
                }
            }
        }
    }
}