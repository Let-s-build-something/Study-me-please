package study.me.please.ui.collection.detail.facts

import androidx.activity.compose.BackHandler
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.squadris.squadris.compose.components.ChipState
import com.squadris.squadris.compose.components.CustomChipGroup
import com.squadris.squadris.compose.components.CustomChipType
import com.squadris.squadris.compose.components.rememberCustomChipGroupState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.base.LocalSnackbarHost
import study.me.please.data.io.FactType
import study.me.please.ui.collection.detail.CollectionDetailViewModel
import study.me.please.ui.collection.detail.PAGE_INDEX_QUESTIONS
import study.me.please.ui.collection.detail.questions.SortByType
import study.me.please.ui.collection.detail.questions.detail.INPUT_DELAYED_RESPONSE_MILLIS
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.BrandHeaderButton
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.InteractiveCardMode
import study.me.please.ui.components.OptionsLayout
import study.me.please.ui.components.ScrollBarProgressIndicator
import study.me.please.ui.components.rememberInteractiveCardState

/** List of facts */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FactsList(
    viewModel: CollectionDetailViewModel,
    onPageChange: (index: Int) -> Unit
) {
    val facts = viewModel.collectionFacts.collectAsState(initial = listOf())
    val chipsFilter = viewModel.factsFilter.collectAsState()
    val collectionDetail = viewModel.collectionDetail.collectAsState()
    val questionGenerationResponse = viewModel.questionGenerationResponse.collectAsState(initial = null)

    val interactiveStates = facts.value.map { rememberInteractiveCardState() }
    val showDeleteDialog = remember(collectionDetail) { mutableStateOf(false) }
    val chipGroupState = rememberCustomChipGroupState(
        onCheckedChipsChanged = { chipUids ->
            viewModel.factsFilter.update { previousFilter ->
                FactsFilter(
                    textFilter = previousFilter.textFilter,
                    types = chipUids.mapNotNull { uid -> FactType.values().find { it.name == uid } }
                )
            }
        }
    )

    val inputScope = rememberCoroutineScope()
    val coroutineScope = rememberCoroutineScope()
    val localFocusManager = LocalFocusManager.current
    val context = LocalContext.current
    val snackbarHost = LocalSnackbarHost.current


    val sortChipIcon = remember {
        mutableStateOf<ImageVector?>(chipsFilter.value.sortBy.getDirectionIcon())
    }
    val isSearchActivated = remember(chipsFilter.value) { mutableStateOf(chipsFilter.value.textFilter.isNotEmpty()) }
    val chips = mutableListOf(
        ChipState(
            type = CustomChipType.SEARCH,
            chipText = remember(chipsFilter.value) { mutableStateOf(chipsFilter.value.textFilter) },
            onSearchOutput = { output ->
                inputScope.coroutineContext.cancelChildren()
                inputScope.launch {
                    delay(INPUT_DELAYED_RESPONSE_MILLIS)
                    viewModel.factsFilter.update { previousFilter ->
                        FactsFilter(
                            textFilter = output,
                            types = previousFilter.types
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
            chipText = remember {
                mutableStateOf(context.getString(R.string.facts_type_date))
            },
            type = CustomChipType.SORT,
            icon = sortChipIcon,
            onChipPressed = {
                viewModel.factsFilter.update { previousFilter ->
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
    FactType.values().forEach { factType ->
        chips.add(
            ChipState(
                type = CustomChipType.REGULAR,
                icon = remember {
                    mutableStateOf(factType.getIconImageVector())
                },
                uid = factType.name,
                isChecked = mutableStateOf(viewModel.factsFilter.value.types.contains(factType))
            )
        )
    }

    val controller = object: FactListController {
        val selectedFactUids = remember(facts.value) { mutableStateListOf<String>() }

        init {
            LaunchedEffect(key1 = selectedFactUids.size) {
                coroutineScope.launch {
                    if(selectedFactUids.size > 0) {
                        interactiveStates.forEach {
                            it.mode.value = InteractiveCardMode.CHECKING
                        }
                        localFocusManager.clearFocus()
                    }else stopChecking()
                }
            }
            LaunchedEffect(facts.value.size) {
                if((collectionDetail.value?.factUidList?.size ?: 0) != facts.value.size) {
                    if((collectionDetail.value?.factUidList?.size ?: 0) < facts.value.size) {
                        interactiveStates.firstOrNull()?.mode?.value = InteractiveCardMode.EDIT
                    }
                    coroutineScope.launch(Dispatchers.Default) {
                        collectionDetail.value?.factUidList?.apply {
                            addAll(facts.value.map { it.uid })
                        }
                    }
                }
            }

            BackHandler(selectedFactUids.size > 0) {
                stopChecking()
            }
        }

        override fun onFactAdded() {
            stopChecking()
            viewModel.addNewFact(facts.value.isEmpty())
        }
        override fun stopChecking() {
            localFocusManager.clearFocus()
            interactiveStates.forEach {
                it.isChecked.value = false
                it.mode.value = InteractiveCardMode.DATA_DISPLAY
            }
            selectedFactUids.clear()
        }
        override fun onDeleteRequest() {
            coroutineScope.launch(Dispatchers.Default) {
                collectionDetail.value?.factUidList?.removeAll {
                    selectedFactUids.contains(it)
                }
                viewModel.requestFactsDeletion(selectedFactUids.toSet())
                selectedFactUids.clear()
            }
        }

        override fun onGenerateQuestionsRequest() {
            if(selectedFactUids.size > 0) {
                coroutineScope.launch {
                    /*viewModel.requestQuestionGeneration(
                        context = context,
                        selectedFactUids = selectedFactUids,
                        facts = facts.value
                    )*/
                    delay(300)
                    stopChecking()
                }
            }else {
                interactiveStates.firstOrNull()?.isChecked?.value = true
            }
        }
        override fun copyItems() {
            coroutineScope.launch(Dispatchers.Default) {
                viewModel.clipBoard.facts.copyItems(
                    facts.value.filter { selectedFactUids.contains(it.uid) }
                )
                stopChecking()
            }
        }
    }

    LaunchedEffect(key1 = questionGenerationResponse.value) {
        questionGenerationResponse.value?.let { response ->
            snackbarHost?.showSnackbar(
                if(response.isSuccessful == true) {
                    "Successfuly generated ${response.questionsGenerated} questions!"
                }else "Failed to generate questions due to insufficient facts"
            )
            if(response.isSuccessful == true) onPageChange(PAGE_INDEX_QUESTIONS)
        }
    }

    facts.value.forEachIndexed { index, fact ->
        interactiveStates.getOrNull(index)?.let { state ->
            LaunchedEffect(state.isChecked.value) {
                if(state.isChecked.value) {
                    controller.selectedFactUids.add(fact.uid)
                }else controller.selectedFactUids.remove(fact.uid)
            }
            LaunchedEffect(state.mode.value) {
                //localFocusManager.clearFocus()
                if(state.mode.value == InteractiveCardMode.EDIT) {
                    interactiveStates.forEachIndexed { stateIndex, state ->
                        if(index != stateIndex) {
                            state.mode.value = InteractiveCardMode.DATA_DISPLAY
                        }
                    }
                }
            }
        }
    }

    if(showDeleteDialog.value) {
        BasicAlertDialog(
            title = stringResource(id = R.string.fact_delete_dialog_title),
            content = stringResource(
                id = R.string.fact_delete_dialog_description,
                controller.selectedFactUids.size
            ),
            icon = Icons.Outlined.Delete,
            confirmButtonState = ButtonState(
                text = stringResource(id = R.string.button_confirm)
            ) {
                viewModel.requestFactsDeletion(uidList = controller.selectedFactUids.toSet())
                controller.stopChecking()
            },
            dismissButtonState = ButtonState(
                text = stringResource(id = R.string.button_dismiss)
            ),
            onDismissRequest = { showDeleteDialog.value = false }
        )
    }

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (progressScrollbar, content) = createRefs()

        val factsScrollState = rememberLazyListState()
        ScrollBarProgressIndicator(
            modifier = Modifier
                .zIndex(2f)
                .rotate(90f)
                .width(LocalConfiguration.current.screenHeightDp.dp)
                .constrainAs(progressScrollbar) {
                    linkTo(content.end, content.end)
                    linkTo(content.top, content.bottom)
                },
            scrollState = factsScrollState,
            totalItems = facts.value.size
        )

        LazyColumn(
            modifier = Modifier
                .constrainAs(content) {
                    linkTo(parent.start, parent.end, 4.dp, 4.dp)
                    linkTo(parent.top, parent.bottom)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
                .imePadding(),
            state = factsScrollState,
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            stickyHeader {
                Column(modifier = Modifier.fillMaxWidth()) {
                    // filters if not empty
                    if(facts.value.isNotEmpty() || chipsFilter.value.isEmpty().not()) {
                        CustomChipGroup(
                            modifier = Modifier
                                .fillMaxWidth()
                                .zIndex(10f)
                                .animateItemPlacement(),
                            state = chipGroupState,
                            chips = remember { mutableStateListOf(*chips.toTypedArray()) }
                        )
                    }

                    // buttons for adding new items
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .zIndex(10f),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier = Modifier.weight(0.05f))
                        BrandHeaderButton(
                            modifier = (if (facts.value.isNotEmpty()) {
                                Modifier.weight(0.45f)
                            } else Modifier.requiredSize(0.dp))
                                .animateContentSize(),
                            text = stringResource(id = R.string.facts_list_generate_questions)
                        ) {
                            controller.onGenerateQuestionsRequest()
                        }
                        Spacer(
                            modifier = (if(facts.value.isNotEmpty()) {
                                Modifier.weight(0.05f)
                            }else Modifier.requiredSize(0.dp))
                                .animateContentSize()
                        )
                        BrandHeaderButton(
                            modifier = Modifier
                                .zIndex(100f)
                                .weight(0.45f),
                            text = stringResource(id = R.string.facts_list_add_new)
                        ) {
                            controller.onFactAdded()
                        }
                        Spacer(modifier = Modifier.weight(0.05f))
                    }
                    OptionsLayout(
                        onCopyRequest = { controller.copyItems() },
                        onPasteRequest = {
                            viewModel.pasteFactsClipBoard()
                            controller.stopChecking()
                        },
                        onDeleteRequest = { showDeleteDialog.value = true },
                        onSelectAll = {
                            interactiveStates.forEach {
                                it.isChecked.value = true
                            }
                        },
                        onDeselectAll = { controller.selectedFactUids.clear() },
                        isEditMode = controller.selectedFactUids.size > 0,
                        hasPasteOption = viewModel.clipBoard.facts.isEmpty.value.not(),
                        animateTopDown = true,
                        onClipBoardRemoval = { viewModel.clipBoard.facts.clear() }
                    )
                }
            }
            itemsIndexed(
                facts.value,
                key = { _, fact -> fact.uid }
            ) { index, fact ->
            }
        }
    }
}