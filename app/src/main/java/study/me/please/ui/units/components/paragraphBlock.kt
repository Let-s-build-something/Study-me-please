package study.me.please.ui.units.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.squadris.squadris.compose.theme.LocalTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.data.io.FactType
import study.me.please.data.io.UnitElement
import study.me.please.ui.collection.detail.REQUEST_DATA_SAVE_DELAY
import study.me.please.ui.components.EditFieldItemPicker
import study.me.please.ui.components.ExpandableContent
import study.me.please.ui.components.FactCard
import study.me.please.ui.components.InteractiveCardMode
import study.me.please.ui.components.ListItemEditField
import study.me.please.ui.units.CollectionUnitsViewModel
import study.me.please.ui.units.UnitViewModel
import study.me.please.ui.units.utils.BorderOrder
import study.me.please.ui.units.utils.DropTargetContainer
import study.me.please.ui.units.utils.ElementType
import study.me.please.ui.units.utils.ParagraphBlockBridge
import study.me.please.ui.units.utils.dragSource
import study.me.please.ui.units.utils.dragTarget
import study.me.please.ui.units.utils.drawSegmentedBorder
import study.me.please.ui.units.utils.getLayerIdentification
import study.me.please.ui.units.utils.highlightedText
import study.me.please.ui.units.utils.maxParagraphLayer

/**
 * Paragraph block with nested facts and paragraphs
 * @param elements - list of elements
 * @param bridge - bridge to communicate with the view model
 * @param viewModel - view model
 * @param activatedParent - mutable state of activated paragraph
 * @param selectedFact - mutable state of selected fact
 * @param screenWidthDp - screen width in dp
 * @param isLandscape - is landscape mode
 * @param dragAndDropTarget - mutable state of drag and drop target
 * @param collapsedParagraphs - list of collapsed paragraphs
 * @param scope - coroutine scope
 * @param collectionViewModel - collection view model
 * @param focusManager - focus manager
 */
@OptIn(ExperimentalFoundationApi::class)
fun LazyGridScope.paragraphBlock(
    elements: State<List<UnitElement>>,
    bridge: ParagraphBlockBridge?,
    screenWidthDp: Int,
    isReadOnly: Boolean = false,
    viewModel: UnitViewModel,
    collectionViewModel: CollectionUnitsViewModel?,
    activatedParent: MutableState<String?>,
    selectedFact: MutableState<String?>,
    dragAndDropTarget: MutableState<String>,
    collapsedParagraphs: State<List<String>>,
    scope: CoroutineScope,
    focusManager: FocusManager?,
    isLandscape: Boolean
) {
    itemsIndexed(
        items = elements.value,
        key = { _, element -> element.uid },
        span = { _, element -> GridItemSpan(
            if(isLandscape && element is UnitElement.Paragraph) 2 else 1
        ) },
        contentType = { _, element -> element.uid } // to avoid Modifier reuse
    ) { index, element ->
        val filter = collectionViewModel?.filter?.collectAsState(initial = null)
        val paddingStart = remember(element.uid) {
            if(element.layer >= 0) {
                screenWidthDp.dp * (element.layer.plus(1)).coerceIn(
                    minimumValue = 1,
                    maximumValue = maxParagraphLayer
                ) / 30
            }else 0.dp
        }

        when(element) {
            is UnitElement.Paragraph -> {
                element.data.let { paragraph ->
                    val saveScope = rememberCoroutineScope()
                    val identification = getLayerIdentification(element.layer)
                    val focusRequester = remember { FocusRequester() }

                    LaunchedEffect(Unit) {
                        if(element.uid == activatedParent.value && element.data.name.isBlank()) {
                            focusRequester.requestFocus()
                        }
                    }

                    val editDragModifier = Modifier.dragSource(
                        onClick = {
                            scope.launch {
                                if (collapsedParagraphs.value.contains(paragraph.uid)) {
                                    viewModel.expandParagraph(index)
                                    activatedParent.value = paragraph.uid
                                } else {
                                    viewModel.collapseParagraph(index, onSelectionRequest = {
                                        activatedParent.value = it
                                    })
                                }
                            }
                        },
                        elementType = ElementType.PARAGRAPH,
                        uid = paragraph.uid,
                        onStarted = {
                            viewModel.localStateElement.value = element to index
                            viewModel.removeElement(element, onSelectionRequest = {
                                activatedParent.value = it
                            })
                        }
                    )

                    DropTargetContainer(
                        modifier = Modifier.animateItemPlacement(),
                        type = ElementType.PARAGRAPH,
                        enterModifier = Modifier.drawSegmentedBorder(
                            borderOrder = if (paragraph.paragraphs.isNotEmpty()) {
                                BorderOrder.Center
                            } else BorderOrder.None,
                            screenWidthDp = screenWidthDp,
                            notLastLayers = element.notLastLayers,
                            parentLayer = element.layer
                        ),
                        padding = paddingStart,
                        identifier = paragraph.uid,
                        onDropped = {
                            activatedParent.value = paragraph.uid
                            bridge?.onItemDropped(
                                targetElement = element,
                                index = index
                            )
                        },
                        dragAndDropTarget = dragAndDropTarget,
                        collapsedParagraphs = collapsedParagraphs.value,
                        onCanceled = {
                            bridge?.invalidate()
                        }
                    ) {
                        ExpandableContent(
                            modifier = Modifier
                                .padding(start = paddingStart)
                                .fillMaxWidth()
                                .then(
                                    if (isReadOnly.not()) {
                                        editDragModifier
                                    } else Modifier
                                )
                                .then(
                                    if (element.layer >= 0) Modifier
                                        .drawSegmentedBorder(
                                            borderOrder = BorderOrder.Start,
                                            screenWidthDp = screenWidthDp,
                                            notLastLayers = element.notLastLayers,
                                            parentLayer = element.layer
                                        )
                                    else Modifier
                                )
                                .padding(top = 2.dp),
                            text = highlightedText(
                                highlight = filter?.value?.textFilter ?: "",
                                text = paragraph.name
                            ),
                            isExpanded = collapsedParagraphs.value.contains(paragraph.uid).not(),
                            shape = if(element.layer >= 0) RoundedCornerShape(
                                topStart = LocalTheme.current.shapes.componentCornerRadius
                            ) else RectangleShape,
                            collapsedContent = {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    if(element.layer >= 0) {
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

                                    val paragraphNames = collectionViewModel?.paragraphNames?.collectAsState()

                                    EditFieldItemPicker(
                                        modifier = Modifier
                                            .wrapContentWidth()
                                            .focusRequester(focusRequester)
                                            .padding(start = 8.dp)
                                            .zIndex(1f),
                                        values = paragraphNames?.value.orEmpty(),
                                        enabled = isReadOnly.not() && collapsedParagraphs.value.contains(paragraph.uid).not(),
                                        defaultValue = highlightedText(
                                            highlight = filter?.value?.textFilter ?: "",
                                            text = paragraph.name
                                        ),
                                        hint = stringResource(R.string.subject_categorize_paragraph),
                                        textStyle = LocalTheme.current.styles.subheading,
                                        onValueChanged = { output ->
                                            paragraph.name = output
                                            activatedParent.value = paragraph.uid

                                            saveScope.coroutineContext.cancelChildren()
                                            saveScope.launch {
                                                delay(REQUEST_DATA_SAVE_DELAY * 2)
                                                bridge?.updateParagraph(paragraph)
                                                collectionViewModel?.invalidateParagraphNames()
                                            }
                                        }
                                    )
                                }
                            }
                        ) {
                            val bulletPoints = remember(element.data.uid) {
                                mutableStateListOf(*element.data.bulletPoints.toTypedArray())
                            }

                            Column(
                                modifier = Modifier
                                    .then(
                                        if (paragraph.paragraphs.isNotEmpty()) {
                                            Modifier.drawSegmentedBorder(
                                                borderOrder = BorderOrder.Center,
                                                screenWidthDp = screenWidthDp,
                                                notLastLayers = element.notLastLayers,
                                                parentLayer = element.layer
                                            )
                                        } else Modifier
                                    )
                                    .fillMaxWidth()
                            ) {
                                AnimatedVisibility(visible = activatedParent.value == paragraph.uid) {
                                    HorizontalDivider(color = LocalTheme.current.colors.brandMainDark)
                                }
                                Spacer(modifier = Modifier.height(8.dp))

                                val isIrremovable = bulletPoints.size <= 1

                                bulletPoints.forEachIndexed { index, point ->
                                    ListItemEditField(
                                        modifier = Modifier.padding(bottom = 2.dp),
                                        identifier = "${index}_${paragraph.uid}",
                                        prefix = FactType.BULLET_POINT_PREFIX,
                                        value = highlightedText(
                                            highlight = filter?.value?.textFilter ?: "",
                                            text = point
                                        ),
                                        hint = stringResource(
                                            if(isIrremovable) {
                                                R.string.list_item_first_bulletin_hint
                                            }else R.string.list_item_bulletin_hint
                                        ),
                                        onBackspaceKey = {
                                            if(isIrremovable.not()) {
                                                if(index > 0 && it.isNotBlank()) {
                                                    bulletPoints[index - 1] += it
                                                }
                                                if(bulletPoints.size > 1 && index != 0) {
                                                    focusManager?.moveFocus(FocusDirection.Up)
                                                }
                                                if(it.isEmpty() || index > 0) {
                                                    bulletPoints.removeAt(index)
                                                    element.data.bulletPoints = bulletPoints.toMutableList()
                                                    viewModel.updateParagraph(element.data)
                                                }
                                            }
                                        },
                                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                                        keyboardActions = KeyboardActions(
                                            onNext = {
                                                bulletPoints.add(index + 1, "")
                                                scope.launch {
                                                    delay(50)
                                                    focusManager?.moveFocus(FocusDirection.Down)
                                                }
                                            }
                                        ),
                                        onEntered = { text ->
                                            bulletPoints.add(index + 1, text.toString())
                                            scope.launch {
                                                delay(50)
                                                focusManager?.moveFocus(FocusDirection.Down)
                                            }
                                        },
                                        onValueChange = { output ->
                                            if(index < bulletPoints.size) {
                                                activatedParent.value = paragraph.uid
                                                bulletPoints[index] = output
                                                element.data.bulletPoints = bulletPoints.toMutableList()
                                                viewModel.updateParagraph(element.data)
                                            }
                                        }
                                    )
                                }
                                Spacer(modifier = Modifier.height(12.dp))
                            }
                        }
                    }
                }
            }
            is UnitElement.Fact -> {
                val saveScope = rememberCoroutineScope()
                val density = LocalDensity.current

                val refocus = {
                    // nested facts within facts don't change focus
                    if(element.isNested.not()) {
                        activatedParent.value = if(element.data.facts.isEmpty()) {
                            element.parentUid
                        }else element.data.uid
                    }
                }

                element.data.let { fact ->
                    Column(
                        modifier = Modifier
                            .padding(
                                start = if (isLandscape) {
                                    if (element.innerIndex % 2 == 0) paddingStart.div(2) else 0.dp
                                } else paddingStart,
                                end = if (isLandscape && element.innerIndex % 2 != 0) paddingStart.div(
                                    2
                                ) else 0.dp
                            )
                            .offset(
                                x = if (isLandscape) paddingStart.div(2) else 0.dp
                            )
                            .then(
                                if (isLandscape.not() || element.innerIndex % 2 == 0) {
                                    Modifier.drawSegmentedBorder(
                                        borderOrder = if (element.isLastParagraph) {
                                            BorderOrder.None
                                        } else BorderOrder.Center,
                                        screenWidthDp = screenWidthDp,
                                        notLastLayers = element.notLastLayers,
                                        parentLayer = element.layer
                                    )
                                } else Modifier
                            )
                    ) {
                        var cardHeight by remember { mutableStateOf(0.dp) }

                        Box(
                            modifier = Modifier.padding(
                                start = 8.dp,
                                bottom = if(element.isLast) 8.dp else 0.dp
                            )
                        ) {
                            if(selectedFact.value != fact.uid) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(cardHeight * 0.7f)
                                        .dragTarget(
                                            isEnabled = isReadOnly.not() && element.isNested.not(),
                                            type = ElementType.FACT,
                                            identifier = fact.uid,
                                            onDropped = {
                                                bridge?.onItemDropped(
                                                    targetElement = element,
                                                    index = index,
                                                    nestUnder = true
                                                )
                                            },
                                            dragAndDropTarget = dragAndDropTarget,
                                            onCanceled = {
                                                bridge?.invalidate()
                                            }
                                        )
                                )
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .align(Alignment.BottomCenter)
                                        .height(cardHeight * 0.3f)
                                        .dragTarget(
                                            isEnabled = isReadOnly.not(),
                                            type = ElementType.FACT,
                                            identifier = "${fact.uid}_bottom",
                                            onDropped = {
                                                bridge?.onItemDropped(
                                                    targetElement = element,
                                                    index = index,
                                                    nestUnder = (element.isNested && element.isLast.not())
                                                            || fact.facts.isNotEmpty()
                                                )
                                            },
                                            dragAndDropTarget = dragAndDropTarget,
                                            onCanceled = {
                                                bridge?.invalidate()
                                            }
                                        )
                                )
                            }
                            FactCard(
                                modifier = Modifier
                                    .animateItemPlacement()
                                    .fillMaxWidth()
                                    .onGloballyPositioned { coordinates ->
                                        cardHeight = with(density) { coordinates.size.height.toDp() }
                                    }
                                    .then(
                                        if (isReadOnly.not() && selectedFact.value != fact.uid) {
                                            Modifier.dragSource(
                                                onClick = {
                                                    refocus()
                                                    if (selectedFact.value != fact.uid) {
                                                        selectedFact.value = fact.uid
                                                    }
                                                },
                                                elementType = if (element.data.facts.isEmpty()) {
                                                    ElementType.FACT
                                                }else ElementType.FACT_MOTHER,
                                                uid = fact.uid,
                                                onStarted = {
                                                    viewModel.localStateElement.value = element to index
                                                    viewModel.removeElement(
                                                        element,
                                                        onSelectionRequest = {
                                                            activatedParent.value = it
                                                        }
                                                    )
                                                }
                                            )
                                        } else Modifier
                                    )
                                    .fillMaxWidth()
                                    // background for indication of nested Facts
                                    .then(
                                        when {
                                            element.data.facts.size > 0 -> {
                                                Modifier.background(
                                                    color = LocalTheme.current.colors.onBackgroundComponent,
                                                    shape = RoundedCornerShape(
                                                        topStart = LocalTheme.current.shapes.componentCornerRadius,
                                                        topEnd = LocalTheme.current.shapes.componentCornerRadius
                                                    )
                                                )
                                            }
                                            element.isNested -> {
                                                Modifier.background(
                                                    color = LocalTheme.current.colors.onBackgroundComponent,
                                                    shape = if(element.isLast) {
                                                        RoundedCornerShape(
                                                            bottomStart = LocalTheme.current.shapes.componentCornerRadius,
                                                            bottomEnd = LocalTheme.current.shapes.componentCornerRadius
                                                        )
                                                    }else RectangleShape
                                                )
                                            }
                                            else -> Modifier.padding(bottom = 8.dp)
                                        }
                                    )
                                    // if this is a nested Fact, it should be offset from the parent one
                                    .padding(start = if(element.isNested) screenWidthDp.dp * 2 / 30 else 0.dp)
                                    // indication of this Fact being focused as a last parent
                                    .then(
                                        if(fact.facts.isNotEmpty()) {
                                            Modifier.border(
                                                width = if (activatedParent.value == fact.uid) {
                                                    0.75.dp
                                                } else 0.1.dp,
                                                color = if (activatedParent.value == fact.uid) {
                                                    LocalTheme.current.colors.brandMain
                                                } else LocalTheme.current.colors.secondary,
                                                shape = LocalTheme.current.shapes.componentShape
                                            )
                                        }else Modifier
                                    )
                                    // drag and drop target for nesting a Fact
                                    .then(
                                        if (dragAndDropTarget.value == fact.uid) {
                                            Modifier.border(
                                                width = 2.dp,
                                                color = LocalTheme.current.colors.brandMain,
                                                shape = LocalTheme.current.shapes.componentShape
                                            )
                                        } else Modifier
                                    ),
                                data = fact,
                                showBackground = fact.isEmpty || fact.facts.isNotEmpty(),
                                isReadOnly = isReadOnly,
                                requestDataSave = { newFact ->
                                    refocus()
                                    saveScope.coroutineContext.cancelChildren()
                                    saveScope.launch {
                                        delay(REQUEST_DATA_SAVE_DELAY * 2)
                                        bridge?.updateFact(newFact)
                                    }
                                },
                                highlight = filter?.value?.textFilter,
                                onClick = {
                                    refocus()
                                    selectedFact.value = if(selectedFact.value == fact.uid) null else fact.uid
                                },
                                mode = when {
                                    selectedFact.value == fact.uid -> InteractiveCardMode.EDIT
                                    else -> InteractiveCardMode.DATA_DISPLAY
                                }
                            )
                        }
                        // indication of dropping an element behind this Fact
                        AnimatedVisibility(visible = dragAndDropTarget.value == "${fact.uid}_bottom") {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(64.dp)
                                    .background(
                                        color = LocalTheme.current.colors.brandMain,
                                    )
                            )
                        }
                    }
                }
            }
        }
    }
}