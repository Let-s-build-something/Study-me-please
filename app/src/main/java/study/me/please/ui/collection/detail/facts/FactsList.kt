package study.me.please.ui.collection.detail.facts

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imeNestedScroll
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.FactIO
import study.me.please.data.io.FactType
import study.me.please.ui.collection.detail.CollectionDetailViewModel
import study.me.please.ui.collection.detail.INPUT_DELAYED_RESPONSE_MILLIS
import study.me.please.ui.collection.detail.OptionsLayout
import study.me.please.ui.collection.detail.PAGE_INDEX_QUESTIONS
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.BrandHeaderButton
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.FactCard
import study.me.please.ui.components.InteractiveCardMode
import study.me.please.ui.components.rememberInteractiveCardState

/** List of facts */
@OptIn(ExperimentalFoundationApi::class, ExperimentalLayoutApi::class)
@Composable
fun FactsList(
    viewModel: CollectionDetailViewModel,
    collectionDetail: CollectionIO,
    requestCollectionSave: () -> Unit,
    onPageChange: (index: Int) -> Unit,
    requestFactSave: (fact: FactIO) -> Unit,
) {
    val facts = viewModel.collectionFacts.collectAsState(initial = listOf())
    val chipsFilter = viewModel.factsFilter.collectAsState()

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
                if(collectionDetail.factUidList.size < facts.value.size) {
                    interactiveStates.firstOrNull()?.mode?.value = InteractiveCardMode.EDIT
                }
                coroutineScope.launch(Dispatchers.Default) {
                    collectionDetail.factUidList.apply {
                        addAll(facts.value.map { it.uid })
                    }
                    requestCollectionSave()
                }
                stopChecking()
            }

            if(selectedFactUids.size > 0) {
                BackHandler {
                    stopChecking()
                }
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
                collectionDetail.factUidList.removeAll {
                    selectedFactUids.contains(it)
                }
                requestCollectionSave()
                viewModel.requestFactsDeletion(selectedFactUids.toSet())
                selectedFactUids.clear()
            }
        }

        override fun onGenerateQuestionsRequest() {
            if(selectedFactUids.size > 0) {
                coroutineScope.launch {
                    viewModel.requestQuestionGeneration(
                        context = context,
                        selectedFactUids = selectedFactUids,
                        facts = facts.value
                    )
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

    val questionGenerationResponse = viewModel.questionGenerationResponse.collectAsState(initial = null)
    //TODO use snackbar using Scaffold instead
    LaunchedEffect(key1 = questionGenerationResponse.value) {
        questionGenerationResponse.value?.let { response ->
            Toast.makeText(
                context,
                if(response.isSuccessful == true) {
                    "Successfuly generated ${response.questionsGenerated} questions!"
                }else "Failed to generate questions due to insufficient facts",
                Toast.LENGTH_LONG
            ).show()
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
                localFocusManager.clearFocus()
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
            dialogTitle = stringResource(id = R.string.fact_delete_dialog_title),
            dialogText = stringResource(
                id = R.string.fact_delete_dialog_description,
                controller.selectedFactUids.size
            ),
            icon = Icons.Outlined.Delete,
            confirmButtonState = ButtonState(
                text = stringResource(id = R.string.button_confirm)
            ) {
                viewModel.requestFactsDeletion(uidList = controller.selectedFactUids.toSet())
                controller.stopChecking()
                showDeleteDialog.value = false
            },
            dismissButtonState = ButtonState(
                text = stringResource(id = R.string.button_dismiss)
            ) { showDeleteDialog.value = false }
        )
    }

    val localDensity = LocalDensity.current
    var stickyHeaderHeight by remember { mutableStateOf(0.dp) }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .zIndex(10f)
                .onGloballyPositioned { coordinates ->
                    stickyHeaderHeight = with(localDensity) { coordinates.size.height.toDp() }
                }
                .constrainAs(btnAddItem) {
                    linkTo(parent.start, parent.end)
                    top.linkTo(parent.top)
                },
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
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 4.dp)
                .constrainAs(content) {
                    linkTo(parent.start, parent.end)
                    linkTo(parent.top, parent.bottom, bias = 0f)
                    width = Dimension.fillToConstraints
                }
                // glitchy .imeNestedScroll()
                .imePadding(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if(facts.value.isNotEmpty() || chipsFilter.value.isEmpty().not()) {
                item {
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
                            type = CustomChipType.SORT,
                            onChipPressed = {
                                //TODO popup of some sorts
                            }
                        )
                    )
                    FactType.values().forEach { factType ->
                        chips.add(
                            ChipState(
                                type = CustomChipType.REGULAR,
                                icon = factType.getIconImageVector(),
                                uid = factType.name,
                                isChecked = mutableStateOf(viewModel.factsFilter.value.types.contains(factType))
                            )
                        )
                    }
                    Column {
                        Spacer(modifier = Modifier.height(stickyHeaderHeight))
                        CustomChipGroup(
                            modifier = Modifier
                                .fillMaxWidth()
                                .zIndex(10f)
                                .animateItemPlacement(),
                            state = chipGroupState,
                            chips = remember { mutableStateListOf(*chips.toTypedArray()) }
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
                        viewModel.pasteFactsClipBoard()
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
                        controller.selectedFactUids.clear()
                    },
                    isEditMode = controller.selectedFactUids.size > 0,
                    hasPasteOption = viewModel.clipBoard.facts.isEmpty.value.not(),
                    animateTopDown = false
                )
            }
            itemsIndexed(
                facts.value,
                key = { _, fact -> fact.uid }
            ) { index, fact ->
                FactCard(
                    modifier = Modifier
                        .zIndex(1f)
                        .animateItemPlacement(
                            tween(
                                durationMillis = DEFAULT_ANIMATION_LENGTH_SHORT,
                                easing = LinearOutSlowInEasing
                            )
                        ),
                    data = fact,
                    state = (interactiveStates.getOrNull(index) ?: rememberInteractiveCardState()),
                    requestDataSave = requestFactSave
                )
                Spacer(modifier = Modifier.height(LocalTheme.shapes.betweenItemsSpace))
            }
        }
    }
}