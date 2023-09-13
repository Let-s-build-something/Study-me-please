package study.me.please.ui.collection.detail

import androidx.activity.compose.BackHandler
import androidx.compose.animation.animateContentSize
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.DocumentScanner
import androidx.compose.material.icons.outlined.FileDownload
import androidx.compose.material.icons.outlined.FileUpload
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.squadris.squadris.compose.theme.AppTheme
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

    if(collectionUid.isNullOrEmpty().not() && collectionDetailFlow.value.isNotEmpty.not()) {
        ShimmerLayout()
    }else {
        val collectionDetail = remember { collectionDetailFlow.value }
        LaunchedEffect(collectionDetailFlow.value) {
            changeActionBar {
                CollectionDetailAppBarActions {
                    NavigationUtils.navigateToSession(
                        navController,
                        toolbarTitle = collectionDetailFlow.value.name,
                        collectionUid = collectionDetailFlow.value.uid,
                        isTesting = true
                    )
                }
            }
        }
        ContentLayout(
            collectionDetail = collectionDetail,
            requestDataSave = {
                coroutineScope.coroutineContext.cancelChildren()
                coroutineScope.launch {
                    delay(REQUEST_DATA_SAVE_DELAY)
                    viewModel.requestSave(collectionDetail)
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
            viewModel = viewModel
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
    requestDataSave: () -> Unit
) {
    val questionInEdit: MutableState<QuestionIO> = remember {
        mutableStateOf(QuestionIO(uid = ""))
    }
    val localFocusManager = LocalFocusManager.current

    val questionSheetState = rememberBottomSheetScaffoldState()
    val optionsSheetState = rememberBottomSheetScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val showDeleteDialog = remember { mutableStateOf(false) }
    val selectedQuestionUids = remember { mutableStateListOf<String>() }
    val questions = remember {
        mutableStateListOf(
            *collectionDetail.questions.toTypedArray()
        )
    }
    val interactiveStates = questions.map {
        rememberInteractiveCardState()
    }
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

    QuestionEditBottomSheetContent(
        questionIO = questionInEdit.value,
        onDismissRequest = {
            questionInEdit.value = QuestionIO(uid = "")
        },
        requestDataSave = requestDataSave,
        onDeleteRequest = { uids ->
            viewModel.requestAnswersDeletion(uids.toSet())
        },
        onQuestionTestPlay = onNavigateToQuestionTest,
        content = {
            ListOptionsBottomSheet(
                modifier = Modifier
                    .pointerInput(Unit) {
                        detectTapGestures(onTap = {
                            stopChecking()
                            localFocusManager.clearFocus()
                        })
                    }
                    .fillMaxSize(),
                onDismissRequest = {
                    stopChecking()
                },
                actions = {
                    ImageAction(
                        imageVector = Icons.Outlined.Delete,
                        text = stringResource(id = R.string.collection_list_delete_item),
                        containerColor = Colors.RED_ERROR
                    ) {
                        showDeleteDialog.value = true
                    }
                    ImageAction(
                        imageVector = Icons.Outlined.PlayArrow,
                        text = stringResource(id = R.string.button_start_session)
                    ) {
                        stopChecking()
                    }
                },
                state = optionsSheetState
            ) { paddingValues ->
                LazyColumn(
                    modifier = Modifier
                        .padding(top = 4.dp, start = 2.dp, end = 2.dp)
                        .shadow(
                            elevation = AppTheme.styles.componentElevation,
                            shape = AppTheme.shapes.componentShape
                        )
                        .background(
                            color = AppTheme.colors.onBackgroundComponent,
                            shape = AppTheme.shapes.componentShape
                        )
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(paddingValues)
                        .padding(horizontal = 12.dp)
                ) {
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState())
                                .padding(horizontal = 8.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            ImageAction(
                                modifier = Modifier,
                                imageVector = Icons.Outlined.FileDownload,
                                text = stringResource(id = R.string.button_import)
                            ) {

                            }
                            ImageAction(
                                modifier = Modifier,
                                imageVector = Icons.Outlined.FileUpload,
                                text = stringResource(id = R.string.button_import)
                            ) {

                            }
                            ImageAction(
                                modifier = Modifier,
                                imageVector = Icons.Outlined.DocumentScanner,
                                text = stringResource(id = R.string.button_scan)
                            ) {

                            }
                        }
                    }
                    item {
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
                            requestDataSave()
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
                            requestDataSave()
                        }
                    }
                    item {
                        Text(
                            modifier = itemModifier,
                            text = stringResource(id = R.string.collection_detail_questions_heading),
                            color = AppTheme.colors.secondary,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        BrandHeaderButton(
                            modifier = itemModifier,
                            text = stringResource(id = R.string.collection_detail_add_question)
                        ) {
                            collectionDetail.apply {
                                questions.add(
                                    QuestionIO().also { newQuestion ->
                                        questionInEdit.value = newQuestion
                                    }
                                )
                            }
                        }
                    }
                    itemsIndexed(
                        questions,
                        key = { _, item -> item.uid }
                    ) { index, question ->
                        (interactiveStates.getOrNull(index) ?: rememberInteractiveCardState()).let { state ->
                            LaunchedEffect(state.isChecked.value) {
                                if(state.isChecked.value) {
                                    selectedQuestionUids.add(question.uid)
                                }else selectedQuestionUids.remove(question.uid)
                            }
                            QuestionCard(
                                modifier = itemModifier,
                                data = question,
                                requestDataSave = requestDataSave,
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
                    item {
                        Spacer(
                            modifier = Modifier
                                .animateContentSize()
                                .height(
                                    if (optionsSheetState.bottomSheetState.isExpanded) {
                                        72.dp
                                    } else 12.dp
                                )
                        )
                    }
                }
            }
        },
        state = questionSheetState
    )

    LaunchedEffect(questionInEdit.value) {
        if(questionInEdit.value.uid.isNotEmpty()) {
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
            }else stopChecking()
        }
    }
    LaunchedEffect(key1 = questions.size) {
        // only when adding a new one
        if(collectionDetail.questions.size < questions.size) {
            collectionDetail.questions = questions
            requestDataSave()
        }else {
            collectionDetail.questions = questions
        }
    }
}

/** Layout for loading - shimmer effect */
@Composable
private fun ShimmerLayout() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
        ) {
            repeat(5) {
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .width(120.dp)
                        .brandShimmerEffect(RoundedCornerShape(12.dp))
                )
            }
        }
    }
}