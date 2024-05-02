package study.me.please.ui.units

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.squadris.squadris.compose.theme.Colors
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

/**
 * Paragraph block with nested facts and paragraphs
 * @param elements - list of elements
 * @param bridge - bridge to communicate with the view model
 * @param viewModel - view model
 * @param activatedParagraph - mutable state of activated paragraph
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
    onDragStarted: ((Pair<UnitElement, Int>) -> Unit)? = null,
    activatedParagraph: MutableState<String?>,
    selectedFact: MutableState<String?>,
    dragAndDropTarget: MutableState<String>,
    collapsedParagraphs: State<List<String>>,
    scope: CoroutineScope,
    collectionViewModel: CollectionUnitsViewModel?,
    focusManager: FocusManager?,
    isLandscape: Boolean
) {
    itemsIndexed(
        items = elements.value,
        key = { _, element -> element.uid },
        span = { _, element -> GridItemSpan(
            if(isLandscape && element is UnitElement.Paragraph) 2 else 1
        ) }
    ) { index, element ->
        val paddingStart = remember(element.uid) {
            if(element.layer >= 0) {
                screenWidthDp.dp * (element.layer.plus(1)).coerceAtMost(maxParagraphLayer) / 30
            }else 0.dp
        }

        when(element) {
            is UnitElement.Paragraph -> {
                element.data.let { paragraph ->
                    val identification = getLayerIdentification(element.layer)

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
                            activatedParagraph.value = paragraph.uid
                            bridge?.onItemDropped(
                                element = element,
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
                                    if(isReadOnly.not() || onDragStarted != null) {
                                        Modifier.dragSource(
                                            onClick = {
                                                scope.launch {
                                                    activatedParagraph.value = if (collapsedParagraphs.value.contains(paragraph.uid)) {
                                                        viewModel.expandParagraph(index)
                                                        paragraph.uid
                                                    }else {
                                                        viewModel.collapseParagraph(index)
                                                        null
                                                    }
                                                }
                                            },
                                            elementType = ElementType.PARAGRAPH,
                                            uid = paragraph.uid,
                                            onStarted = {
                                                if(onDragStarted != null) {
                                                    onDragStarted(element to index)
                                                }else {
                                                    viewModel.localStateElement.value = element to index
                                                    viewModel.removeElement(index)
                                                }
                                            }
                                        )
                                    }else Modifier
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
                            text = paragraph.name,
                            isExpanded = collapsedParagraphs.value.contains(paragraph.uid).not(),
                            shape = if(element.layer >= 0) RoundedCornerShape(
                                topStart = LocalTheme.shapes.componentCornerRadius
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

                                    val saveScope = rememberCoroutineScope()

                                    EditFieldItemPicker(
                                        modifier = Modifier
                                            .wrapContentWidth()
                                            .padding(start = 8.dp)
                                            .zIndex(1f),
                                        values = collectionViewModel?.paragraphNames.orEmpty(),
                                        enabled = isReadOnly.not() && collapsedParagraphs.value.contains(paragraph.uid).not(),
                                        defaultValue = paragraph.name,
                                        hint = stringResource(R.string.subject_categorize_paragraph),
                                        textStyle = LocalTheme.styles.subheading,
                                        onValueChanged = { output ->
                                            paragraph.name = output
                                            activatedParagraph.value = paragraph.uid

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
                                AnimatedVisibility(visible = activatedParagraph.value == paragraph.uid) {
                                    HorizontalDivider(color = LocalTheme.colors.brandMainDark)
                                }
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
                                        onBackspaceKey = {
                                            activatedParagraph.value = paragraph.uid
                                            if(it.isEmpty() && isIrremovable.not()) {
                                                if(index > 0) {
                                                    focusManager?.moveFocus(FocusDirection.Up)
                                                }
                                                bulletPoints.removeAt(index)
                                                element.data.bulletPoints = bulletPoints.toMutableList()
                                                viewModel.updateParagraph(element.data)
                                            }
                                        },
                                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                                        keyboardActions = KeyboardActions(
                                            onNext = {
                                                if(point.isNotBlank()) {
                                                    bulletPoints.add(index + 1, "")
                                                    scope.launch {
                                                        delay(50)
                                                        focusManager?.moveFocus(FocusDirection.Down)
                                                    }
                                                }
                                            }
                                        ),
                                        onValueChange = { output ->
                                            activatedParagraph.value = paragraph.uid
                                            bulletPoints[index] = output
                                            element.data.bulletPoints = bulletPoints.toMutableList()
                                            viewModel.updateParagraph(element.data)
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

                element.data.let { fact ->
                    DropTargetContainer(
                        modifier = Modifier
                            .animateItemPlacement()
                            .fillMaxWidth()
                            .padding(
                                start = if (isLandscape) {
                                    if (index % 2 == 0) paddingStart.div(2) else 0.dp
                                } else paddingStart,
                                end = if (isLandscape && index % 2 != 0) paddingStart.div(2) else 0.dp
                            )
                            .offset(
                                x = if (isLandscape) paddingStart.div(2) else 0.dp
                            )
                            .then(
                                if (isLandscape.not() || index % 2 == 0) {
                                    Modifier.drawSegmentedBorder(
                                        borderOrder = if (element.isLastParagraph) {
                                            BorderOrder.None
                                        } else BorderOrder.Center,
                                        screenWidthDp = screenWidthDp,
                                        notLastLayers = element.notLastLayers,
                                        parentLayer = element.layer
                                    )
                                } else Modifier
                            ),
                        isEnabled = isReadOnly.not(),
                        type = ElementType.FACT,
                        identifier = fact.uid,
                        onDropped = {
                            activatedParagraph.value = element.parentUid
                            bridge?.onItemDropped(
                                element = element,
                                index = index
                            )
                        },
                        dragAndDropTarget = dragAndDropTarget,
                        collapsedParagraphs = collapsedParagraphs.value,
                        onCanceled = {
                            bridge?.invalidate()
                        }
                    ) {
                        FactCard(
                            modifier = Modifier
                                .then(
                                    if (isReadOnly.not() || onDragStarted != null) {
                                        Modifier.dragSource(
                                            onClick = {
                                                activatedParagraph.value = element.parentUid
                                                if (selectedFact.value != fact.uid) {
                                                    selectedFact.value = fact.uid
                                                }
                                            },
                                            elementType = ElementType.FACT,
                                            uid = fact.uid,
                                            onStarted = {
                                                if(onDragStarted != null) {
                                                    onDragStarted(element to index)
                                                }else {
                                                    viewModel.localStateElement.value = element to index
                                                    viewModel.removeElement(index)
                                                }
                                            }
                                        )
                                    } else Modifier
                                )
                                .fillMaxWidth()
                                .padding(bottom = 8.dp),
                            data = fact,
                            isReadOnly = isReadOnly,
                            requestDataSave = { newFact ->
                                activatedParagraph.value = element.parentUid
                                saveScope.coroutineContext.cancelChildren()
                                saveScope.launch {
                                    delay(REQUEST_DATA_SAVE_DELAY * 2)
                                    bridge?.updateFact(newFact)
                                }
                            },
                            onClick = {
                                activatedParagraph.value = element.parentUid
                                selectedFact.value = if(selectedFact.value == fact.uid) null else fact.uid
                            },
                            mode = when {
                                selectedFact.value == fact.uid -> InteractiveCardMode.EDIT
                                else -> InteractiveCardMode.DATA_DISPLAY
                            }
                        )
                    }
                }
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