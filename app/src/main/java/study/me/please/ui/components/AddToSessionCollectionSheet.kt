package study.me.please.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.squadris.squadris.compose.components.DEFAULT_ANIMATION_LENGTH_SHORT
import com.squadris.squadris.compose.theme.LocalTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.session.SessionIO
import study.me.please.ui.components.session.SessionCard
import study.me.please.ui.components.tab_switch.OutlinedTabSwitch
import study.me.please.ui.components.tab_switch.TabSwitchState
import study.me.please.ui.components.tab_switch.rememberTabSwitchState

const val SESSIONS_TAB_INDEX = 0
const val COLLECTIONS_TAB_INDEX = 1

/**
 * Base sheet for adding item to either session or collection
 */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun AddToSessionCollectionSheet(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    isShimmering: Boolean = false,
    tabs: MutableList<String> = mutableListOf(),
    collections: List<CollectionIO>? = null,
    sessions: List<SessionIO>? = null,
    selectedCollections: List<String>? = null,
    selectedQuestions: List<String>? = null,
    state: TabSwitchState = rememberTabSwitchState(
        scrollState = rememberScrollState(),
        tabs = tabs
    ),
    onConfirmation: (List<SessionIO>?, List<CollectionIO>?) -> Unit,
    sheetState: SheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
) {
    SimpleModalBottomSheet(
        onDismissRequest = onDismissRequest,
        sheetState = sheetState
    ) {
        AnimatedContent(
            targetState = isShimmering,
            label = ""
        ) { isShimmer ->
            if(isShimmer) {
                //TODO shimmer
            }else {
                val coroutineScope = rememberCoroutineScope()
                val selectedSessionUidList = remember { mutableStateListOf<String>() }
                val selectedCollectionUidList = remember { mutableStateListOf<String>() }

                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .animateContentSize()
                        .padding(16.dp)
                        .padding(bottom = 16.dp)
                ) {
                    if(tabs.size > 1) {
                        OutlinedTabSwitch(
                            state = state
                        )
                    }else if(state.tabs.firstOrNull() != null) {
                        TextHeader(text = state.tabs.firstOrNull() ?: "")
                    }
                    AnimatedContent(
                        targetState = state.selectedTabIndex.value,
                        label = "",
                        transitionSpec = {
                            val animationSpec: FiniteAnimationSpec<IntOffset> = tween(220, delayMillis = 90)
                            if(this.targetState == COLLECTIONS_TAB_INDEX) {
                                slideInHorizontally(animationSpec, initialOffsetX = { it.times(2) })
                                    .togetherWith(slideOutHorizontally(animationSpec, targetOffsetX = { it.times(-1) }))
                            }else slideInHorizontally(animationSpec, initialOffsetX = { it.times(-1) })
                                .togetherWith(slideOutHorizontally(animationSpec, targetOffsetX = { it.times(2) }))
                        }
                    ) { index ->
                        val footerItem: @Composable () -> Unit = {
                            AnimatedVisibility(
                                visible = selectedCollectionUidList.size > 0 || selectedSessionUidList.size > 0,
                                enter = slideInVertically(initialOffsetY = { it.times(2) }),
                                exit = slideOutVertically(targetOffsetY = { it.times(2) })
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 12.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    OutlinedButton(
                                        thenModifier = Modifier
                                            .padding(vertical = 6.dp, horizontal = 6.dp),
                                        text = stringResource(id = R.string.button_cancel),
                                        isActivated = false,
                                        onClick = {
                                            selectedCollectionUidList.clear()
                                            selectedSessionUidList.clear()
                                            coroutineScope.launch {
                                                sheetState.hide()
                                            }
                                        }
                                    )
                                    Spacer(modifier = Modifier.width(12.dp))
                                    ImageAction(
                                        text = stringResource(id = R.string.button_confirm),
                                        onClick = {
                                            coroutineScope.launch(Dispatchers.Default) {
                                                val chosenSessions = sessions?.filter { selectedSessionUidList.contains(it.uid) }
                                                val chosenCollections = collections?.filter { selectedCollectionUidList.contains(it.uid) }
                                                chosenSessions?.forEach {
                                                    it.collectionUidList.addAll(selectedCollections.orEmpty())
                                                    it.questionUidList.addAll(selectedQuestions.orEmpty())
                                                }
                                                chosenCollections?.forEach {
                                                    it.questionUidList.addAll(selectedQuestions.orEmpty())
                                                }

                                                onConfirmation(chosenSessions, chosenCollections)
                                            }
                                        }
                                    )
                                }
                            }
                        }

                        when(index) {
                            SESSIONS_TAB_INDEX -> {
                                if(sessions != null) {
                                    val interactiveCardStates = sessions.map {
                                        rememberInteractiveCardState(mode = mutableStateOf(InteractiveCardMode.CHECKING))
                                    }

                                    LazyColumn(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .wrapContentHeight(),
                                        verticalArrangement = Arrangement.spacedBy(LocalTheme.shapes.betweenItemsSpace)
                                    ) {
                                        itemsIndexed(
                                            sessions,
                                            key = { _, session -> session.uid }
                                        ) { index, session ->
                                            interactiveCardStates.getOrNull(index)?.let { state ->
                                                LaunchedEffect(state.isChecked.value) {
                                                    if(state.isChecked.value && state.isEnabled.value) {
                                                        selectedSessionUidList.add(session.uid)
                                                    }else selectedSessionUidList.remove(session.uid)
                                                }
                                                SessionCard(
                                                    modifier = Modifier
                                                        .animateItemPlacement(
                                                            tween(
                                                                durationMillis = DEFAULT_ANIMATION_LENGTH_SHORT,
                                                                easing = LinearOutSlowInEasing
                                                            )
                                                        ),
                                                    session = session,
                                                    state = state
                                                )
                                                val containsAll = (selectedCollections.isNullOrEmpty().not()
                                                    && session.collectionUidList.containsAll(selectedCollections.orEmpty()))
                                                    || (selectedQuestions.isNullOrEmpty().not()
                                                    && session.questionUidList.containsAll(selectedQuestions.orEmpty()))
                                                if(containsAll) {
                                                    state.isEnabled.value = false
                                                    state.isChecked.value = true
                                                }
                                            }
                                        }
                                        item {
                                            footerItem()
                                        }
                                    }
                                }
                            }
                            COLLECTIONS_TAB_INDEX -> {
                                if(collections != null) {
                                    val interactiveCardStates = collections.map {
                                        rememberInteractiveCardState(mode = mutableStateOf(InteractiveCardMode.CHECKING))
                                    }

                                    LazyColumn(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .wrapContentHeight(),
                                        horizontalAlignment = Alignment.End,
                                        verticalArrangement = Arrangement.spacedBy(LocalTheme.shapes.betweenItemsSpace)
                                    ) {
                                        itemsIndexed(
                                            collections,
                                            key = { _, session -> session.uid }
                                        ) { index, collection ->
                                            interactiveCardStates.getOrNull(index)?.let { state ->
                                                LaunchedEffect(state.isChecked) {
                                                    if(state.isChecked.value) {
                                                        selectedCollectionUidList.add(collection.uid)
                                                    }else selectedCollectionUidList.remove(collection.uid)
                                                }
                                                CollectionCard(
                                                    modifier = Modifier
                                                        .animateItemPlacement(
                                                            tween(
                                                                durationMillis = DEFAULT_ANIMATION_LENGTH_SHORT,
                                                                easing = LinearOutSlowInEasing
                                                            )
                                                        ),
                                                    data = collection,
                                                    state = state,
                                                    skipOptions = true
                                                )
                                            }
                                        }
                                        item {
                                            footerItem()
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}