package study.me.please.ui.collection.detail

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Deselect
import androidx.compose.material.icons.outlined.DocumentScanner
import androidx.compose.material.icons.outlined.FileDownload
import androidx.compose.material.icons.outlined.FileUpload
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.SelectAll
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.Text
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.compose.theme.Colors
import com.squadris.squadris.ext.brandShimmerEffect
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.base.navigation.CollectionDetailAppBarActions
import study.me.please.base.navigation.NavigationUtils
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.QuestionIO
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.BrandHeaderButton
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.EditFieldInput
import study.me.please.ui.components.ImageAction
import study.me.please.ui.components.InteractiveCardMode
import study.me.please.ui.components.ListOptionsBottomSheet
import study.me.please.ui.components.QuestionCard
import study.me.please.ui.components.rememberInteractiveCardState

const val REQUEST_DATA_SAVE_DELAY = 1000L

/**
 * Screen for creating a new collection
 * including adding of questions, configuration and import of both
 */
@Composable
fun CollectionDetailScreen(
    collectionUid: String? = null,
    navController: NavController,
    changeActionBar: (actions: @Composable RowScope.() -> Unit) -> Unit,
    viewModel: CollectionDetailViewModel = hiltViewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    val collectionDetailFlow = viewModel.dataManager.collectionDetail.collectAsState()

    if(collectionUid.isNullOrEmpty().not()) {
        viewModel.requestCollectionByUid(collectionUid ?: "")
    }

    if(collectionUid.isNullOrEmpty().not() && collectionDetailFlow.value.dateCreated == null) {
        ShimmerLayout()
    }else {
        val collectionDetail = remember { collectionDetailFlow.value }
        LaunchedEffect(collectionDetailFlow.value) {
            changeActionBar {
                CollectionDetailAppBarActions {
                    NavigationUtils.navigateToSessionLobby(
                        navController,
                        collectionUid = collectionDetailFlow.value.uid
                    )
                }
            }
        }
        ContentLayout(
            collectionDetail = collectionDetail,
            requestCollectionSave = {
                coroutineScope.coroutineContext.cancelChildren()
                coroutineScope.launch {
                    delay(REQUEST_DATA_SAVE_DELAY)
                    viewModel.requestCollectionSave(collectionDetail)
                }
            },
            requestQuestionSave = { question ->
                if(question.uid.isNotEmpty()) {
                    coroutineScope.coroutineContext.cancelChildren()
                    coroutineScope.launch {
                        delay(REQUEST_DATA_SAVE_DELAY)
                        viewModel.requestQuestionSave(question)
                        if(collectionDetail.questionUids.contains(question.uid).not()) {
                            collectionDetail.questionUids.add(question.uid)
                            viewModel.requestCollectionSave(collectionDetail)
                        }
                    }
                }
            },
            onNavigateToQuestionTest = { question ->
                NavigationUtils.navigateToSession(
                    navController = navController,
                    toolbarTitle = question.prompt,
                    questionUid = question.uid,
                    isTesting = true
                )
            },
            viewModel = viewModel,
            navigateToSession = { questionUids ->
                NavigationUtils.navigateToSession(
                    navController = navController,
                    toolbarTitle = collectionDetail.name,
                    questionUids = questionUids
                )
            }
        )
    }
}

/** Layout for main content - showing actual information */
@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun ContentLayout(
    collectionDetail: CollectionIO,
    onNavigateToQuestionTest: (questionIO: QuestionIO) -> Unit,
    viewModel: CollectionDetailViewModel,
    requestCollectionSave: () -> Unit,
    navigateToSession: (questionUids: List<String>) -> Unit,
    requestQuestionSave: (question: QuestionIO) -> Unit
) {
    LaunchedEffect(collectionDetail) {
        if(collectionDetail.uid.isNotEmpty()) {
            viewModel.requestQuestionsByUid(collectionDetail.questionUids)
        }
    }
    val questionInEdit: MutableState<QuestionIO> = remember {
        mutableStateOf(QuestionIO(uid = ""))
    }
    val localFocusManager = LocalFocusManager.current

    val questionSheetState = rememberBottomSheetScaffoldState()
    val optionsSheetState = rememberBottomSheetScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val showDeleteDialog = remember { mutableStateOf(false) }
    val selectedQuestionUids = remember { mutableStateListOf<String>() }
    val questionsFlow = viewModel.dataManager.questions.collectAsState()
    val questions = remember { mutableStateListOf<QuestionIO>() }
    val interactiveStates = questions.map { rememberInteractiveCardState() }
    val stopChecking = {
        interactiveStates.forEach {
            it.isChecked.value = false
            it.mode.value = InteractiveCardMode.DATA_DISPLAY
        }
        selectedQuestionUids.clear()
        coroutineScope.launch {
            optionsSheetState.bottomSheetState.collapse()
        }
    }
    LaunchedEffect(questionInEdit.value) {
        if(questionInEdit.value.uid.isNotEmpty()) {
            localFocusManager.clearFocus()
            questionSheetState.bottomSheetState.expand()
        }else questionSheetState.bottomSheetState.collapse()
    }
    LaunchedEffect(key1 = selectedQuestionUids.size) {
        coroutineScope.launch {
            if(selectedQuestionUids.size > 0) {
                interactiveStates.forEach {
                    it.mode.value = InteractiveCardMode.CHECKING
                }
                optionsSheetState.bottomSheetState.expand()
                localFocusManager.clearFocus()
            }else stopChecking()
        }
    }
    LaunchedEffect(key1 = questions.size) {
        viewModel.dataManager.questions.value?.apply {
            clear()
            addAll(questions)
        }
    }
    LaunchedEffect(questionsFlow.value) {
        questions.clear()
        questions.addAll(questionsFlow.value.orEmpty().toTypedArray())
    }

    if(selectedQuestionUids.size > 0) {
        BackHandler {
            stopChecking()
        }
    }

    val itemModifier = Modifier
        .padding(horizontal = 4.dp, vertical = 4.dp)
        .wrapContentHeight()
        .fillMaxWidth()

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
    val localDensity = LocalDensity.current
    var optionsSheet by remember { mutableStateOf(0.dp) }

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
        content = {
            ListOptionsBottomSheet(
                modifier = Modifier
                    .pointerInput(Unit) {
                        detectTapGestures(onTap = {
                            localFocusManager.clearFocus()
                        })
                    }
                    .fillMaxSize(),
                onDismissRequest = {
                    stopChecking()
                },
                sheetContentModifier = Modifier.onGloballyPositioned { coordinates ->
                    optionsSheet = with(localDensity) { coordinates.size.height.toDp() }
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
                        coroutineScope.launch(Dispatchers.Default) {
                            val missingItems = questions.filter { selectedQuestionUids.contains(it.uid).not() }.map { it.uid }
                            selectedQuestionUids.addAll(missingItems)
                        }
                    }
                    ImageAction(
                        leadingImageVector = Icons.Outlined.Deselect,
                        text = stringResource(id = R.string.button_deselect)
                    ) {
                        selectedQuestionUids.clear()
                    }
                    ImageAction(
                        leadingImageVector = Icons.Outlined.PlayArrow,
                        text = stringResource(id = R.string.button_start_session)
                    ) {
                        navigateToSession(selectedQuestionUids)
                        stopChecking()
                    }
                },
                state = optionsSheetState
            ) { paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(
                            top = 4.dp,
                            start = 4.dp,
                            end = 4.dp,
                            bottom = if (optionsSheetState.bottomSheetState.isExpanded) {
                                optionsSheet
                            } else 0.dp
                        )
                        .shadow(
                            elevation = LocalTheme.styles.componentElevation,
                            shape = LocalTheme.shapes.componentShape,
                            clip = true
                        )
                        .background(
                            color = LocalTheme.colors.onBackgroundComponent,
                            shape = LocalTheme.shapes.componentShape
                        )
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(paddingValues)
                        .padding(horizontal = 12.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState())
                            .padding(start = 6.dp, top = 6.dp, end = 6.dp),
                        horizontalArrangement = Arrangement.spacedBy(
                            LocalTheme.shapes.betweenItemsSpace
                        )
                    ) {
                        ImageAction(
                            modifier = Modifier,
                            leadingImageVector = Icons.Outlined.FileDownload,
                            text = stringResource(id = R.string.button_import)
                        ) {

                        }
                        ImageAction(
                            modifier = Modifier,
                            leadingImageVector = Icons.Outlined.FileUpload,
                            text = stringResource(id = R.string.button_import)
                        ) {

                        }
                        ImageAction(
                            modifier = Modifier,
                            leadingImageVector = Icons.Outlined.DocumentScanner,
                            text = stringResource(id = R.string.button_scan)
                        ) {

                        }
                    }

                    EditFieldInput(
                        modifier = itemModifier,
                        value = collectionDetail.name,
                        hint = stringResource(id = R.string.collection_detail_name_hint),
                        maxLines = 1,
                        minLines = 1
                    ) { output ->
                        collectionDetail.apply {
                            name = output
                        }
                        requestCollectionSave()
                    }
                    EditFieldInput(
                        modifier = itemModifier,
                        value = collectionDetail.description,
                        hint = stringResource(id = R.string.collection_detail_description_hint),
                        minLines = 8,
                        maxLines = 8
                    ) { output ->
                        collectionDetail.apply {
                            description = output
                        }
                        requestCollectionSave()
                    }

                    Text(
                        modifier = itemModifier
                            .padding(top = 6.dp),
                        text = stringResource(id = R.string.collection_detail_questions_heading),
                        color = LocalTheme.colors.secondary,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    BrandHeaderButton(
                        modifier = itemModifier,
                        text = stringResource(id = R.string.collection_detail_add_question)
                    ) {
                        stopChecking()
                        collectionDetail.apply {
                            questions.add(
                                index = 0,
                                QuestionIO().also { newQuestion ->
                                    questionInEdit.value = newQuestion
                                }
                            )
                        }
                    }
                    questions.forEachIndexed { index, question ->
                        (interactiveStates.getOrNull(index) ?: rememberInteractiveCardState()).let { state ->
                            LaunchedEffect(state.isChecked.value) {
                                if(state.isChecked.value) {
                                    selectedQuestionUids.add(question.uid)
                                }else selectedQuestionUids.remove(question.uid)
                            }
                            QuestionCard(
                                modifier = itemModifier
                                    .padding(bottom = if(index == questions.lastIndex) 48.dp else 0.dp),
                                data = question,
                                requestDataSave = {
                                    requestQuestionSave(question)
                                },
                                onNavigateToSession = onNavigateToQuestionTest,
                                state = state,
                                onClick = {
                                    if(state.mode.value == InteractiveCardMode.CHECKING) {
                                        state.isChecked.value = state.isChecked.value.not()
                                    }else questionInEdit.value = question
                                }
                            )
                        }
                    }
                }
            }
        },
        state = questionSheetState
    )
}

/** Layout for loading - shimmer effect */
@Preview
@Composable
private fun ShimmerLayout() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .background(
                LocalTheme.colors.onBackgroundComponent,
                shape = LocalTheme.shapes.componentShape
            )
            .padding(start = 4.dp, end = 4.dp, top = 8.dp, bottom = 32.dp)
    ) {
        Box(
            modifier = Modifier
                .height(60.dp)
                .padding(top = 16.dp, start = 4.dp, end = 4.dp)
                .fillMaxWidth()
                .brandShimmerEffect(LocalTheme.shapes.componentShape)
        )
        Box(
            modifier = Modifier
                .height(100.dp)
                .padding(top = 8.dp, start = 4.dp, end = 4.dp)
                .fillMaxWidth()
                .brandShimmerEffect(LocalTheme.shapes.componentShape)
        )
        Box(
            modifier = Modifier
                .height(55.dp)
                .padding(top = 24.dp, start = 4.dp, end = 4.dp)
                .fillMaxWidth()
                .brandShimmerEffect(LocalTheme.shapes.componentShape)
        )
        Spacer(modifier = Modifier.height(32.dp))
        repeat(5) {
            Box(
                modifier = Modifier
                    .height(40.dp)
                    .padding(top = 8.dp, start = 4.dp, end = 4.dp)
                    .fillMaxWidth()
                    .brandShimmerEffect(LocalTheme.shapes.componentShape)
            )
        }
    }
}