package study.me.please.ui.collection.detail

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarDuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.squadris.squadris.compose.theme.Colors
import com.squadris.squadris.compose.theme.LocalTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.FactIO
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.BrandHeaderButton
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.FactCard
import study.me.please.ui.components.InteractiveCardMode
import study.me.please.ui.components.rememberInteractiveCardState

/** List of facts */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FactsList(
    viewModel: CollectionDetailViewModel,
    collectionDetail: CollectionIO,
    requestCollectionSave: () -> Unit,
    requestFactSave: (fact: FactIO) -> Unit,
) {
    val collectionFacts = viewModel.collectionFacts.collectAsState()

    val facts = remember(collectionFacts.value) { mutableStateListOf(
        *collectionFacts.value.toTypedArray()
    ) }

    val interactiveStates = facts.map { rememberInteractiveCardState() }
    val showDeleteDialog = remember(collectionDetail) { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()
    val localFocusManager = LocalFocusManager.current

    val controller = object: FactListController {
        val selectedFactUids = remember(collectionFacts.value) { mutableStateListOf<String>() }

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
            LaunchedEffect(key1 = facts.size) {
                if(collectionDetail.factUidList.size < facts.size) {
                    interactiveStates.firstOrNull()?.mode?.value = InteractiveCardMode.EDIT
                }
                coroutineScope.launch(Dispatchers.Default) {
                    collectionDetail.factUidList.apply {
                        addAll(facts.map { it.uid })
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
            val newFact = FactIO()
            facts.add(newFact)
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
                viewModel.requestQuestionGeneration(selectedFactUids, facts = facts)
            }else {
                interactiveStates.firstOrNull()?.isChecked?.value = true
            }
        }
    }

    val questionGenerationResponse = viewModel.questionGenerationResponse.collectAsState(initial = null)
    //TODO use snackbar using Scaffold instead
    val context = LocalContext.current
    LaunchedEffect(key1 = questionGenerationResponse.value) {
        if(questionGenerationResponse.value != null) {
            Toast.makeText(
                context,
                if(questionGenerationResponse.value?.isSuccessful == true) {
                    "Successfuly generated ${questionGenerationResponse.value?.questionsGenerated} questions!"
                }else "Failed to generate questions due to insufficient facts",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    facts.forEachIndexed { index, fact ->
        interactiveStates.getOrNull(index)?.let { state ->
            LaunchedEffect(state.isChecked.value) {
                if(state.isChecked.value) {
                    controller.selectedFactUids.add(fact.uid)
                }else controller.selectedFactUids.remove(fact.uid)
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
                coroutineScope.launch(Dispatchers.Default) {
                    facts.removeAll { controller.selectedFactUids.contains(it.uid) }
                    viewModel.requestFactsDeletion(uidList = controller.selectedFactUids.toSet())
                    controller.stopChecking()
                    showDeleteDialog.value = false
                }
            },
            dismissButtonState = ButtonState(
                text = stringResource(id = R.string.button_dismiss)
            ) { showDeleteDialog.value = false }
        )
    }

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
                .fillMaxSize()
                .padding(top = 4.dp)
                .constrainAs(content) {
                    linkTo(parent.start, parent.end)
                    linkTo(parent.top, parent.bottom, bias = 0f)
                    width = Dimension.fillToConstraints
                },
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            stickyHeader {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.weight(0.05f))
                    BrandHeaderButton(
                        modifier = (if (facts.size > 0) {
                            Modifier.weight(0.45f)
                        } else Modifier.requiredSize(0.dp))
                            .zIndex(100f)
                            .animateContentSize(),
                        text = stringResource(id = R.string.facts_list_generate_questions)
                    ) {
                        controller.onGenerateQuestionsRequest()
                    }
                    Spacer(
                        modifier = (if(facts.size > 0) {
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
            }
            stickyHeader {
                OptionsLayout(
                    onCopyRequest = {
                        coroutineScope.launch(Dispatchers.Default) {
                            viewModel.clipBoard.facts.copyItems(
                                facts.filter { controller.selectedFactUids.contains(it.uid) }
                            )
                            controller.stopChecking()
                        }
                    },
                    onPasteRequest = {
                        facts.addAll(0, viewModel.clipBoard.facts.paste())
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
                facts,
                key = { _, fact -> fact.uid }
            ) { index, fact ->
                FactCard(
                    modifier = Modifier.zIndex(1f),
                    data = fact,
                    state = (interactiveStates.getOrNull(index) ?: rememberInteractiveCardState()),
                    requestDataSave = requestFactSave
                )
                Spacer(modifier = Modifier.height(LocalTheme.shapes.betweenItemsSpace))
            }
        }
    }
}