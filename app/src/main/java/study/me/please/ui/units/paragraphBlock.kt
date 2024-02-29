package study.me.please.ui.units

import android.annotation.SuppressLint
import android.content.ClipData
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.draganddrop.dragAndDropSource
import androidx.compose.foundation.draganddrop.dragAndDropTarget
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draganddrop.DragAndDropEvent
import androidx.compose.ui.draganddrop.DragAndDropTarget
import androidx.compose.ui.draganddrop.DragAndDropTransferData
import androidx.compose.ui.draganddrop.mimeTypes
import androidx.compose.ui.draganddrop.toAndroidDragEvent
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.squadris.squadris.compose.theme.Colors
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.compose.theme.StudyMeAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import study.me.please.R
import study.me.please.base.BaseScreen
import study.me.please.base.GeneralClipBoard
import study.me.please.data.io.FactIO
import study.me.please.data.io.FactType
import study.me.please.data.io.subjects.CategoryIO
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.ui.components.ComponentHeaderButton
import study.me.please.ui.components.EditFieldItemPicker
import study.me.please.ui.components.ExpandableContent
import study.me.please.ui.components.FactCard
import study.me.please.ui.components.InteractiveCardMode
import study.me.please.ui.components.ListItemEditField
import java.util.UUID

data class ParagraphBlockState(
    val parentLayer: Int,
    val categories: State<List<CategoryIO>?> = mutableStateOf(listOf()),
    val selectedFact: MutableState<String?>,
    val clipBoard: GeneralClipBoard?,
    val paragraph: ParagraphIO,
    val isReadOnly: Boolean = false,
    val updateParagraph: (ParagraphIO) -> Unit,
): ParagraphBlockBridge {

    enum class ElementType {
        FACT,
        BULLET_POINT,
        EMPTY_SPACE,
        PARAGRAPH
    }

    val nestedBulletPoints = mutableStateListOf(*paragraph.bulletPoints.toTypedArray())
    val nestedFacts = mutableStateListOf(*paragraph.facts.toTypedArray())
    val nestedParagraphs = mutableStateListOf(*paragraph.paragraphs.toTypedArray())

    override fun removeBulletPoint(index: Int) {
        nestedBulletPoints.removeAt(index)
        paragraph.bulletPoints = nestedBulletPoints
        updateParagraph(paragraph)
    }

    override fun updateBulletPoint(index: Int, output: String) {
        nestedBulletPoints[index] = output
        paragraph.bulletPoints = nestedBulletPoints
        updateParagraph(paragraph)
    }

    override fun addNewBulletPoint(index: Int, bulletPoint: String?) {
        nestedBulletPoints.add(index, bulletPoint ?: "")
        paragraph.bulletPoints = nestedBulletPoints
        updateParagraph(paragraph)
    }

    override fun addNewFact(
        index: Int,
        fact: FactIO?,
        uid: String?
    ) {
        val newFact = fact?.deepCopy() ?: FactIO()
        Log.d("kostka_test", "adding new fact: ${newFact.uid} (${fact?.uid}), facts: ${nestedFacts.map { it.uid }}")
        // update source of truth first
        paragraph.facts.apply {
            add(index, newFact)
            removeIf {
                it.uid == fact?.uid
            }
        }
        updateParagraph(paragraph)

        nestedFacts.apply {
            add(index, newFact)
            removeIf {
                it.uid == fact?.uid
            }
        }
        if(fact == null) {
            selectedFact.value = newFact.uid
        }
        Log.d("kostka_test", "facts: ${nestedFacts.map { it.uid }}")
    }

    override fun addNewParagraph(
        index: Int,
        paragraph: ParagraphIO?,
        uid: String?
    ) {
        val newParagraph = paragraph?.copy(uid = UUID.randomUUID().toString()) ?: ParagraphIO()
        // update source of truth first
        this.paragraph.paragraphs.apply {
            add(index, newParagraph)
            removeIf {
                it.uid == uid
            }
        }
        updateParagraph(this.paragraph)

        nestedParagraphs.apply {
            add(index, newParagraph)
            removeIf {
                it.uid == uid
            }
        }
    }

    override fun requestFactsPaste() {
        nestedFacts.addAll(0, clipBoard?.facts?.paste().orEmpty())
        paragraph.facts = nestedFacts
        updateParagraph(paragraph)
    }

    override fun requestFactDeletion(uid: String): Boolean {
        val res = nestedFacts.removeIf {
            it.uid == uid
        }
        if(res) {
            Log.d("kostka_test", "removed fact, uid: $uid")
            paragraph.facts.removeIf {
                it.uid == uid
            }
            updateParagraph(paragraph)
        }
        return res
    }

    override fun requestParagraphDeletion(uid: String): Boolean {
        val res = nestedParagraphs.removeIf {
            it.uid == uid
        }
        if(res) {
            Log.d("kostka_test", "removed paragraph, uid: $uid")
            paragraph.paragraphs.removeIf {
                it.uid == uid
            }
            updateParagraph(paragraph)
        }
        return res
    }
}

/** Block of a paragraph under a subject */
@OptIn(ExperimentalFoundationApi::class)
fun LazyGridScope.paragraphBlock(
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
        val isExpanded = derivedStateOf {
            collapsedParagraphs.contains(paragraph.uid).not()
        }

        val paddingStart = if(parentLayer >= 0) {
            screenWidthDp.dp * (parentLayer.plus(1)).coerceAtMost(maxLayer) / 30
        }else 0.dp

        @Composable
        fun DropTargetContainer(
            modifier: Modifier = Modifier,
            padding: Dp = 0.dp,
            type: ParagraphBlockState.ElementType,
            identifier: String,
            content: @Composable ColumnScope.() -> Unit
        ) {
            val cancelableScope = rememberCoroutineScope()
            if(type == ParagraphBlockState.ElementType.PARAGRAPH && collapsedParagraphs.contains(identifier)) {
                LaunchedEffect(dragAndDropTarget.value == identifier) {
                    cancelableScope.coroutineContext.cancelChildren()

                    // if paragraph is collapsed and we hold above it for 1 second,
                    // the paragraph should expand
                    if(isExpanded.value.not() && dragAndDropTarget.value == identifier) {
                        cancelableScope.launch {
                            delay(1000)
                            if(collapsedParagraphs.contains(paragraph.uid)) {
                                collapsedParagraphs.remove(paragraph.uid)
                            }
                        }
                    }
                }
            }

            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .dragAndDropTarget(
                        shouldStartDragAndDrop = { startEvent ->
                            val uid = unitsViewModel?.dragAndDroppedParagraph
                                ?: unitsViewModel?.dragAndDroppedFact

                            // restrict paragraph to be not injected into its child
                            val sourceParagraph = unitsViewModel?.dragAndDroppedParagraph
                            startEvent
                                .mimeTypes()
                                .contains(type.name)
                                    && uid != identifier
                                    && (type != ParagraphBlockState.ElementType.PARAGRAPH
                                    || (sourceParagraph == null
                                    || (sourceParagraph.uid != identifier && !unitsViewModel.isNestedOfParagraph(
                                sourceParagraph = sourceParagraph,
                                targetUid = identifier
                            )))
                                    )
                        },
                        target = object : DragAndDropTarget {
                            override fun onDrop(event: DragAndDropEvent): Boolean {
                                generalScope?.launch(Dispatchers.Default) {
                                    val clipData = event.toAndroidDragEvent().clipData
                                    val firstMimeType = event
                                        .mimeTypes()
                                        .firstOrNull()
                                    Log.d(
                                        "kostka_test",
                                        "clipData: $clipData, firstMimeType: $firstMimeType"
                                    )
                                    if (clipData != null) {
                                        for (i in 0 until clipData.itemCount) {
                                            ParagraphBlockState.ElementType
                                                .values()
                                                .find {
                                                    it.name == firstMimeType
                                                }
                                                ?.let {
                                                    Log.d(
                                                        "kostka_test",
                                                        "element from clipdata: $it"
                                                    )
                                                    val uid = clipData.getItemAt(i).text.toString()
                                                    when (it) {
                                                        ParagraphBlockState.ElementType.BULLET_POINT -> {
                                                            // there's no drag and drop of existing bullet point
                                                            // so we always create a new one
                                                            addNewBulletPoint()
                                                            addContentVisible.value = false
                                                        }

                                                        ParagraphBlockState.ElementType.FACT -> {
                                                            val index =
                                                                if (type == ParagraphBlockState.ElementType.FACT) {
                                                                    nestedFacts
                                                                        .indexOfFirst { fact ->
                                                                            fact.uid == identifier
                                                                        }
                                                                        .coerceAtLeast(0)
                                                                } else 0
                                                            Log.d("kostka_test", "new fact - $uid")
                                                            val isNotNested =
                                                                nestedFacts.none { fact -> fact.uid == uid }
                                                            addNewFact(
                                                                index = index,
                                                                fact = unitsViewModel?.dragAndDroppedFact,
                                                                uid = uid
                                                            )
                                                            // remove from only other paragraphs
                                                            if (isNotNested) {
                                                                unitsViewModel?.elementUidToRemove?.emit(
                                                                    uid
                                                                )
                                                            }
                                                            unitsViewModel?.dragAndDroppedFact =
                                                                null
                                                            addContentVisible.value = false
                                                        }

                                                        ParagraphBlockState.ElementType.PARAGRAPH -> {
                                                            val index =
                                                                if (type == ParagraphBlockState.ElementType.PARAGRAPH) {
                                                                    nestedParagraphs
                                                                        .indexOfFirst { paragraph ->
                                                                            paragraph.uid == identifier
                                                                        }
                                                                        .coerceAtLeast(0)
                                                                } else 0
                                                            val isNotNested =
                                                                nestedParagraphs.none { fact -> fact.uid == uid }
                                                            addNewParagraph(
                                                                index = index,
                                                                paragraph = unitsViewModel?.dragAndDroppedParagraph,
                                                                uid = uid
                                                            )
                                                            // remove from only other paragraphs
                                                            if (isNotNested) {
                                                                unitsViewModel?.elementUidToRemove?.emit(
                                                                    uid
                                                                )
                                                            }
                                                            unitsViewModel?.dragAndDroppedParagraph =
                                                                null
                                                            addContentVisible.value = false
                                                        }

                                                        else -> {}
                                                    }
                                                }
                                        }
                                    }
                                }
                                dragAndDropTarget.value = ""
                                return true
                            }

                            override fun onEntered(event: DragAndDropEvent) {
                                super.onEntered(event)
                                dragAndDropTarget.value = identifier
                            }

                            override fun onExited(event: DragAndDropEvent) {
                                super.onExited(event)
                                dragAndDropTarget.value = ""
                            }
                        }
                    )
            ) {
                if(type == ParagraphBlockState.ElementType.PARAGRAPH) content()
                AnimatedVisibility(visible = dragAndDropTarget.value == identifier) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = padding)
                            .height(64.dp)
                            .background(
                                color = LocalTheme.colors.brandMain,
                            )
                            .drawSegmentedBorder(
                                borderOrder = if (nestedParagraphs.isNotEmpty()) BorderOrder.Center else BorderOrder.None,
                                screenWidthDp = screenWidthDp,
                                notLastLayers = notLastLayers,
                                parentLayer = parentLayer
                            )
                    )
                }
                if(type != ParagraphBlockState.ElementType.PARAGRAPH) content()
            }
        }

        /** Source for dragging element to some action/place */
        fun Modifier.dragSource(
            onClick: () -> Unit,
            elementType: ParagraphBlockState.ElementType,
            uid: String,
            fact: FactIO? = null,
            paragraph: ParagraphIO? = null
        ) = composed(
            factory = {
                val density = LocalDensity.current
                val rectColor = LocalTheme.colors.onBackgroundComponent
                val cornerRadius = with(density) {
                    LocalTheme.shapes.componentCornerRadius.toPx()
                }

                dragAndDropSource(
                    drawDragDecoration = {
                        drawRoundRect(
                            color = rectColor,
                            cornerRadius = CornerRadius(cornerRadius, cornerRadius)
                        )
                    }
                ) {
                    detectTapGestures(
                        onLongPress = {
                            unitsViewModel?.dragAndDroppedFact = fact
                            unitsViewModel?.dragAndDroppedParagraph = paragraph
                            startTransfer(
                                DragAndDropTransferData(
                                    ClipData(
                                        "",
                                        arrayOf(elementType.name, ParagraphBlockState.ElementType.PARAGRAPH.name),
                                        ClipData.Item(uid)
                                    )
                                )
                            )
                        },
                        onTap = { onClick() }
                    )
                }
            }
        )

        item(
            key = paragraph.uid,
            contentType = { paragraph.uid },
            span = { GridItemSpan(if(isLandscape) 2 else 1) }
        ) {
            val identification = getLayerIdentification(parentLayer)

            LaunchedEffect(Unit) {
                unitsViewModel?.elementUidToRemove?.collectLatest { elementUid ->
                    withContext(Dispatchers.Default) {
                        if(elementUid != null) {
                            Log.d("kostka_test", "paragraphBlock, elementUidToRemove: $elementUid")
                            nestedParagraphs.removeIf {
                                it.uid == elementUid
                            }
                            unitsViewModel.elementUidToRemove.emit(null)
                            addContentVisible.value = false
                        }
                    }
                }
            }

            DropTargetContainer(
                modifier = Modifier.animateItemPlacement(),
                type = ParagraphBlockState.ElementType.PARAGRAPH,
                padding = paddingStart,
                identifier = paragraph.uid
            ) {
                ExpandableContent(
                    modifier = Modifier
                        .dragSource(
                            onClick = {
                                if (isExpanded.value.not()) {
                                    collapsedParagraphs.remove(paragraph.uid)
                                } else if (collapsedParagraphs
                                        .contains(paragraph.uid)
                                        .not()
                                ) {
                                    collapsedParagraphs.add(paragraph.uid)
                                }
                            },
                            elementType = ParagraphBlockState.ElementType.PARAGRAPH,
                            uid = paragraph.uid,
                            paragraph = paragraph
                        )
                        .animateItemPlacement()
                        .padding(start = paddingStart)
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
                    isExpanded = isExpanded.value,
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
        item {
            AnimatedVisibility(
                modifier = Modifier
                    .padding(start = paddingStart)
                    .drawSegmentedBorder(
                        borderOrder = if (nestedParagraphs.isNotEmpty()) BorderOrder.Center else BorderOrder.None,
                        screenWidthDp = screenWidthDp,
                        notLastLayers = notLastLayers,
                        parentLayer = parentLayer
                    ),
                visible = isExpanded.value
            ) {
                val focusManager = LocalFocusManager.current
                val scope = rememberCoroutineScope()

                Column(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Spacer(modifier = Modifier.height(8.dp))

                    val isIrremovable = nestedBulletPoints.size <= 1

                    nestedBulletPoints.forEachIndexed { index, point ->
                        DropTargetContainer(
                            type = ParagraphBlockState.ElementType.BULLET_POINT,
                            identifier = "${paragraph.uid}_$index"
                        ) {
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
                                        removeBulletPoint(index)
                                    }
                                },
                                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                                keyboardActions = KeyboardActions(
                                    onNext = {
                                        addNewBulletPoint(index = index + 1)
                                        scope.launch {
                                            delay(50)
                                            focusManager.moveFocus(FocusDirection.Down)
                                        }
                                    }
                                ),
                                onValueChange = { output ->
                                    updateBulletPoint(index, output)
                                }
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }

        items(
            items = if(isExpanded.value) nestedFacts else listOf(),
            key = { fact -> fact.uid }
        ) { fact ->
            LaunchedEffect(Unit) {
                unitsViewModel?.elementUidToRemove?.collectLatest { elementUid ->
                    withContext(Dispatchers.Default) {
                        if(elementUid == fact.uid) {
                            Log.d("kostka_test", "fact, elementUidToRemove: $elementUid")
                            nestedFacts.removeIf {
                                it.uid == elementUid
                            }
                            unitsViewModel.elementUidToRemove.emit(null)
                            addContentVisible.value = false
                        }
                    }
                }
            }

            DropTargetContainer(
                modifier = Modifier
                    .animateItemPlacement()
                    .fillMaxWidth()
                    .padding(start = paddingStart)
                    .drawSegmentedBorder(
                        borderOrder = if (nestedParagraphs.isNotEmpty()) {
                            BorderOrder.Center
                        } else BorderOrder.None,
                        screenWidthDp = screenWidthDp,
                        notLastLayers = notLastLayers,
                        parentLayer = parentLayer
                    ),
                type = ParagraphBlockState.ElementType.FACT,
                identifier = fact.uid
            ) {
                FactCard(
                    modifier = Modifier
                        .dragSource(
                            onClick = {
                                if (selectedFact.value != fact.uid) {
                                    state.selectedFact.value = fact.uid
                                }
                            },
                            elementType = ParagraphBlockState.ElementType.FACT,
                            uid = fact.uid,
                            fact = fact
                        )
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    data = fact,
                    isReadOnly = isReadOnly,
                    requestDataSave = { newFact ->
                        paragraph.facts.find { it.uid == newFact.uid }?.updateTO(newFact)
                        updateParagraph(paragraph)
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

        if(isExpanded.value) {
            nestedParagraphs.forEachIndexed { index, nestedParagraph ->
                paragraphBlock(
                    unitsViewModel = unitsViewModel,
                    state = ParagraphBlockState(
                        categories = categories,
                        isReadOnly = isReadOnly,
                        paragraph = nestedParagraph,
                        parentLayer = parentLayer.plus(1),
                        clipBoard = clipBoard,
                        updateParagraph = updateParagraph,
                        selectedFact = selectedFact
                    ),
                    collapsedParagraphs = collapsedParagraphs,
                    addNewCategory = addNewCategory,
                    onNewCategoryChosen = { chosenCategory ->
                        nestedParagraphs.getOrNull(index)?.apply {
                            localCategory = chosenCategory
                            categoryUid = chosenCategory.uid
                            updateParagraph(this)
                        }
                    },
                    addContentVisible = addContentVisible,
                    notLastLayers = notLastLayers.toMutableList().apply {
                        if(index != nestedParagraphs.lastIndex) add(parentLayer.plus(1))
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

@Composable
private fun ButtonAddFact(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    ComponentHeaderButton(
        modifier = modifier,
        text = stringResource(R.string.subject_add_fact),
        onClick = onClick
    )
}

interface ParagraphBlockBridge {

    /** Adds a new nested fact and saves TO */
    fun addNewFact(
        index: Int = 0,
        fact: FactIO? = null,
        uid: String? = null
    )
    fun addNewBulletPoint(
        index: Int = 0,
        bulletPoint: String? = null
    )
    fun addNewParagraph(
        index: Int = 0,
        paragraph: ParagraphIO? = null,
        uid: String? = null
    )
    fun removeBulletPoint(index: Int = 0)
    fun updateBulletPoint(index: Int = 0, output: String)

    /** Requests a paste of current clipboard data */
    fun requestFactsPaste()

    /** Requests for a fact deletion */
    fun requestFactDeletion(uid: String): Boolean

    /** Requests for a paragraph deletion */
    fun requestParagraphDeletion(uid: String): Boolean
}

enum class BorderOrder {
    Start, Center, None
}

private const val maxLayer = 9

@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.drawSegmentedBorder(
    borderOrder: BorderOrder,
    notLastLayers: List<Int> = listOf(),
    parentLayer: Int,
    screenWidthDp: Int
) = composed(
    factory = {
        val color = LocalTheme.colors.secondary
        val density = LocalDensity.current
        val strokeWidthPx = density.run { 1.dp.toPx() }
        val xOffset = density.run {
            (screenWidthDp.dp * (if(borderOrder == BorderOrder.Center) 0 else 2)
                .coerceAtMost(maxLayer) / 30).toPx()
        }

        Modifier.drawBehind {
            val height = size.height

            notLastLayers.forEach { layer ->
                val offset = strokeWidthPx - (screenWidthDp.dp * (1)
                    .coerceAtMost(maxLayer) / 30).toPx()
                    .times(parentLayer.coerceAtMost(maxLayer - 1).minus(layer - 1))

                drawLine(
                    color = color,
                    start = Offset(x = offset, y = 0f),
                    end = Offset(x = offset, y = height),
                    strokeWidth = strokeWidthPx
                )
            }

            when {
                borderOrder == BorderOrder.None -> { }
                borderOrder == BorderOrder.Start && parentLayer < maxLayer -> {
                    val offset = -xOffset.div(2).plus(-strokeWidthPx)
                    drawLine(
                        color = color,
                        start = Offset(x = offset, y = 0f),
                        end = Offset(
                            x = offset,
                            y = xOffset.div(2).plus(1f)
                        ),
                        strokeWidth = strokeWidthPx
                    )
                    // Bottom left arc
                    drawArc(
                        color = color,
                        startAngle = 90f,
                        sweepAngle = 90f,
                        useCenter = false,
                        topLeft = Offset(x = offset, y = 0f),
                        size = Size(xOffset, xOffset),
                        style = Stroke(width = strokeWidthPx)
                    )
                }
                borderOrder == BorderOrder.Center || parentLayer >= maxLayer -> {
                    drawLine(
                        color = color,
                        start = Offset(x = strokeWidthPx, y = 0f),
                        end = Offset(x = strokeWidthPx, y = height),
                        strokeWidth = strokeWidthPx
                    )
                }
            }
        }
    }
)

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