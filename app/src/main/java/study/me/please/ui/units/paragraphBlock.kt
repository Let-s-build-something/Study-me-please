package study.me.please.ui.units

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.squadris.squadris.compose.theme.Colors
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.compose.theme.StudyMeAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.base.BaseScreen
import study.me.please.data.io.FactIO
import study.me.please.data.io.FactType
import study.me.please.data.io.subjects.CategoryIO
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.ui.components.EditFieldItemPicker
import study.me.please.ui.components.ExpandableContent
import study.me.please.ui.components.FactCard
import study.me.please.ui.components.InteractiveCardMode
import study.me.please.ui.components.ListItemEditField
import study.me.please.ui.units.UnitsViewModel.ElementToDrag
import java.util.UUID

/**
 * Paragraph block with nested facts and paragraphs
 * @param state - paragraph block state
 * @param screenWidthDp - screen width in dp
 * @param isLandscape - is landscape mode
 * @param notLastLayers - list of layers that are not last in the hierarchy
 * @param generalScope - coroutine scope
 * @param addContentVisible - mutable state of content visibility
 * @param unitsViewModel - view model
 * @param dragAndDropTarget - mutable state of drag and drop target
 * @param collapsedParagraphs - list of collapsed paragraphs
 * @param addNewCategory - function to add new category
 * @param onNewCategoryChosen - function to choose new category
 */
@OptIn(ExperimentalFoundationApi::class)
fun LazyGridScope.paragraphBlock(
    modifier: Modifier = Modifier,
    state: ParagraphBlockState,
    screenWidthDp: Int,
    isLandscape: Boolean,
    notLastLayers: List<Int> = listOf(),
    generalScope: CoroutineScope? = null,
    addContentVisible: MutableState<Boolean> = mutableStateOf(false),
    unitsViewModel: UnitsViewModel? = null,
    dragAndDropTarget: MutableState<String> = mutableStateOf(""),
    collapsedParagraphs: SnapshotStateList<String> = mutableStateListOf(),
    addNewCategory: ((name: String) -> CategoryIO)?,
    onNewCategoryChosen: (category: CategoryIO) -> Unit
) {
    with(state) {
        val paddingStart = if(parentLayer >= 0) {
            screenWidthDp.dp * (parentLayer.plus(1)).coerceAtMost(maxParagraphLayer) / 30
        }else 0.dp

        /** Called whenever there is item requested to be added */
        fun onItemDropped() {
            val localStateElement = unitsViewModel?.localStateElement?.data
            Log.d("kostka_test", "onDropped, localState: $${unitsViewModel?.localStateElement?.uid}")
            when (localStateElement) {
                is FactIO -> {
                    val index = facts
                        .indexOfFirst { fact ->
                            fact.uid == localStateElement.uid
                        }
                        .coerceAtLeast(0)
                    generalScope?.launch {
                        val element = unitsViewModel.onDragEnded(
                            ElementToDrag(
                                data = localStateElement,
                                parentUid = state.paragraph.uid,
                                index = index
                            )
                        )
                        bridge.addFact(element)
                    }
                }
                is ParagraphIO -> {
                    val index = paragraphs
                        .indexOfFirst { paragraph ->
                            paragraph.uid == localStateElement.uid
                        }
                        .coerceAtLeast(0)
                    generalScope?.launch {
                        val element = unitsViewModel.onDragEnded(
                            ElementToDrag(
                                data = localStateElement,
                                parentUid = state.paragraph.uid,
                                index = index
                            )
                        )
                        bridge.addParagraph(element)
                    }
                }
                else -> {}
            }
        }

        item(
            key = paragraph.uid,
            contentType = { UUID.randomUUID().toString() },
            span = { GridItemSpan(if(isLandscape) 2 else 1) }
        ) {
            val identification = getLayerIdentification(parentLayer)

            DropTargetContainer(
                modifier = Modifier.animateItemPlacement(),
                type = ElementType.PARAGRAPH,
                padding = paddingStart,
                isEnabled = isReadOnly.not(),
                identifier = paragraph.uid,
                onDropped = ::onItemDropped,
                dragAndDropTarget = dragAndDropTarget,
                collapsedParagraphs = collapsedParagraphs,
                onCanceled = {
                    bridge.invalidate()
                }
            ) {
                ExpandableContent(
                    modifier = Modifier
                        .padding(start = paddingStart)
                        .fillMaxWidth()
                        .then(modifier)
                        .then(
                            if (parentLayer >= 0) Modifier
                                .drawSegmentedBorder(
                                    borderOrder = BorderOrder.Start,
                                    screenWidthDp = screenWidthDp,
                                    notLastLayers = notLastLayers,
                                    parentLayer = parentLayer
                                )
                            else Modifier
                        )
                        .padding(top = 2.dp),
                    text = paragraph.localCategory?.name ?: "",
                    isExpanded = collapsedParagraphs.contains(state.paragraph.uid).not(),
                    shape = if(parentLayer >= 0) RoundedCornerShape(
                        topStart = LocalTheme.shapes.componentCornerRadius
                    ) else RectangleShape,
                    collapsedContent = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            if(parentLayer >= 0) {
                                Text(
                                    modifier = Modifier.padding(end = 6.dp),
                                    text = identification.first,
                                    style = TextStyle(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 14.sp,
                                        color = identification.second
                                    )
                                )
                            }

                            EditFieldItemPicker(
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .padding(start = 8.dp)
                                    .zIndex(1f),
                                enabled = isReadOnly.not(),
                                values = categories.value.orEmpty(),
                                defaultValue = paragraph.localCategory?.name ?: "",
                                onValueChosen = onNewCategoryChosen,
                                hint = stringResource(R.string.subject_categorize_paragraph),
                                onEmptyStateClicked = { inputValue ->
                                    addNewCategory?.invoke(inputValue)?.let(onNewCategoryChosen)
                                },
                                textStyle = LocalTheme.styles.subheading.copy(
                                    textDecoration = TextDecoration.Underline
                                )
                            )
                        }
                    }
                ) {}
            }
        }
        item(
            span = { GridItemSpan(if(isLandscape) 2 else 1) }
        ) {
            AnimatedVisibility(
                modifier = Modifier
                    .padding(start = paddingStart)
                    .drawSegmentedBorder(
                        borderOrder = if (paragraphs.isNotEmpty()) BorderOrder.Center else BorderOrder.None,
                        screenWidthDp = screenWidthDp,
                        notLastLayers = notLastLayers,
                        parentLayer = parentLayer
                    ),
                visible = collapsedParagraphs.contains(state.paragraph.uid).not()
            ) {
                val focusManager = LocalFocusManager.current
                val scope = rememberCoroutineScope()

                Column(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Spacer(modifier = Modifier.height(8.dp))

                    val isIrremovable = bulletPoints.size <= 1

                    bulletPoints.forEachIndexed { index, point ->
                        ListItemEditField(
                            modifier = Modifier.padding(bottom = 2.dp),
                            prefix = FactType.BULLET_POINT_PREFIX,
                            value = point,
                            hint = stringResource(
                                if(isIrremovable) {
                                    R.string.list_item_first_bulletin_hint
                                }else R.string.list_item_bulletin_hint
                            ),
                            enabled = isReadOnly.not(),
                            onBackspaceKey = {
                                if(it.isEmpty() && isIrremovable.not()) {
                                    if(index > 0) {
                                        focusManager.moveFocus(FocusDirection.Up)
                                    }
                                    bridge.removeBulletPoint(index)
                                }
                            },
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                            keyboardActions = KeyboardActions(
                                onNext = {
                                    bridge.addNewBulletPoint(index = index + 1)
                                    scope.launch {
                                        delay(50)
                                        focusManager.moveFocus(FocusDirection.Down)
                                    }
                                }
                            ),
                            onValueChange = { output ->
                                bridge.updateBulletPoint(index, output)
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }

        itemsIndexed(
            items = if(collapsedParagraphs.contains(state.paragraph.uid)) listOf() else facts,
            key = { _, fact -> fact.uid }
        ) { index, fact ->
            DropTargetContainer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = if(isLandscape) {
                            if(index % 2 == 0) paddingStart.div(2) else 0.dp
                        } else paddingStart,
                        end = if(isLandscape && index % 2 != 0) paddingStart.div(2) else 0.dp
                    )
                    .offset(
                        x = if(isLandscape) paddingStart.div(2) else 0.dp
                    )
                    .animateItemPlacement()
                    .then(
                        if(isLandscape.not() || index % 2 == 0) {
                            Modifier.drawSegmentedBorder(
                                borderOrder = if (paragraphs.isNotEmpty()) {
                                    BorderOrder.Center
                                } else BorderOrder.None,
                                screenWidthDp = screenWidthDp,
                                notLastLayers = notLastLayers,
                                parentLayer = parentLayer
                            )
                        }else Modifier
                    ),
                isEnabled = isReadOnly.not(),
                type = ElementType.FACT,
                identifier = fact.uid,
                onDropped = ::onItemDropped,
                dragAndDropTarget = dragAndDropTarget,
                collapsedParagraphs = collapsedParagraphs,
                onCanceled = {
                    bridge.invalidate()
                }
            ) {
                FactCard(
                    modifier = Modifier
                        .then(
                            if(isReadOnly.not()) {
                                Modifier.dragSource(
                                    onClick = {
                                        if (selectedFact.value != fact.uid) {
                                            state.selectedFact.value = fact.uid
                                        }
                                    },
                                    elementType = ElementType.FACT,
                                    uid = fact.uid,
                                    onStarted = {
                                        unitsViewModel?.localStateElement = ElementToDrag(
                                            data = fact,
                                            parentUid = state.paragraph.uid,
                                            index = index
                                        )
                                        bridge.removeUiFact(fact.uid)
                                    }
                                )
                            }else Modifier
                        )
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    data = fact,
                    isReadOnly = isReadOnly,
                    requestDataSave = { newFact ->
                        //paragraph.facts.find { it.uid == newFact.uid }?.updateTO(newFact)
                        updateFact(newFact)
                    },
                    onClick = {
                        state.selectedFact.value = if(selectedFact.value == fact.uid) null else fact.uid
                    },
                    mode = when {
                        selectedFact.value == fact.uid -> InteractiveCardMode.EDIT
                        else -> InteractiveCardMode.DATA_DISPLAY
                    }
                )
            }
        }

        if(collapsedParagraphs.contains(state.paragraph.uid).not()) {
            blockStates.forEachIndexed { index, state ->
                //Log.d("kostka_test", "nestedBlockStates: ${nestedBlockStates.map { it.paragraph.uid }}")
                paragraphBlock(
                    modifier = if(isReadOnly.not()) {
                        Modifier.dragSource(
                            onClick = {
                                if (collapsedParagraphs.contains(state.paragraph.uid)) {
                                    collapsedParagraphs.remove(state.paragraph.uid)
                                } else {
                                    collapsedParagraphs.add(state.paragraph.uid)
                                }
                            },
                            elementType = ElementType.PARAGRAPH,
                            uid = state.paragraph.uid,
                            onStarted = {
                                unitsViewModel?.localStateElement = ElementToDrag(
                                    data = state.paragraph,
                                    parentUid = paragraph.uid,
                                    index = index
                                )
                                Log.d("kostka_test", "onStarted, uid: ${state.paragraph.uid}," +
                                        " nestedBlockStates: ${blockStates.map { it.paragraph.uid }}")
                                bridge.removeUiParagraph(state.paragraph.uid)
                            }
                        )
                    }else Modifier,
                    unitsViewModel = unitsViewModel,
                    state = state,
                    collapsedParagraphs = collapsedParagraphs,
                    addNewCategory = addNewCategory,
                    onNewCategoryChosen = { chosenCategory ->
                        paragraphs.getOrNull(index)?.apply {
                            localCategory = chosenCategory
                            categoryUid = chosenCategory.uid
                            updateParagraph(this)
                        }
                    },
                    addContentVisible = addContentVisible,
                    notLastLayers = notLastLayers.toMutableList().apply {
                        if(index != paragraphs.lastIndex) add(parentLayer.plus(1))
                    },
                    screenWidthDp = screenWidthDp,
                    isLandscape = isLandscape,
                    dragAndDropTarget = dragAndDropTarget,
                    generalScope = generalScope
                )
            }
        }
    }
}

/** Returns text with its color based on the layer depth */
@Composable
private fun getLayerIdentification(layerDepth: Int): Pair<String, Color> {
    val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()
    val colors = listOf(
        Colors.PALETTE_YELLOW,
        Colors.PALETTE_BLUE_LIGHT,
        Colors.PALETTE_ORANGE,
        Colors.PALETTE_GREEN
    )

    val decimalRes = layerDepth.div(alphabet.size.coerceAtLeast(1))
    val res = layerDepth % alphabet.size

    val color = colors.getOrNull((if(decimalRes > 0) decimalRes else res) % colors.size)

    return (if(decimalRes > 0) {
        alphabet.getOrNull(decimalRes).toString() + res.toString()
    } else alphabet.getOrNull(res)?.toString() ?: "") to (color ?: Colors.GREEN_CORRECT)
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    StudyMeAppTheme(isDarkTheme = true) {
        BaseScreen {
            val screenWidth = LocalConfiguration.current.screenWidthDp
            LazyVerticalGrid(
                modifier = Modifier
                    .padding(it)
                    .background(color = LocalTheme.colors.backgroundLight)
                    .fillMaxSize(),
                columns = GridCells.Fixed(1)
            ) {
                paragraphBlock(
                    state = paragraphBlockMockDataState,
                    addNewCategory = null,
                    screenWidthDp = screenWidth,
                    onNewCategoryChosen = {},
                    isLandscape = true
                )
            }
        }
    }
}