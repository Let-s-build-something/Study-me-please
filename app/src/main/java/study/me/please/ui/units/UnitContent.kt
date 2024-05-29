package study.me.please.ui.units

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.res.Configuration
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.animation.Animatable
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.draganddrop.dragAndDropSource
import androidx.compose.foundation.draganddrop.dragAndDropTarget
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draganddrop.DragAndDropEvent
import androidx.compose.ui.draganddrop.DragAndDropTarget
import androidx.compose.ui.draganddrop.DragAndDropTransferData
import androidx.compose.ui.draganddrop.mimeTypes
import androidx.compose.ui.draganddrop.toAndroidDragEvent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.squadris.squadris.compose.components.input.EditFieldInput
import com.squadris.squadris.compose.theme.LocalTheme
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.base.LocalIsTablet
import study.me.please.data.io.FactIO
import study.me.please.data.io.FactType
import study.me.please.data.io.UnitElement
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.data.io.subjects.UnitIO
import study.me.please.ui.collection.detail.REQUEST_DATA_SAVE_DELAY
import study.me.please.ui.components.ListItemEditField
import study.me.please.ui.units.UnitActionType.DEFAULT
import study.me.please.ui.units.UnitActionType.ELEMENT_OPTIONS
import study.me.please.ui.units.UnitViewModel.Companion.INITIAL_LAYER
import study.me.please.ui.units.utils.DropTargetContainer
import study.me.please.ui.units.utils.ElementType

private const val MAX_LENGTH_SHORT_TEXT = 84

/**
 * Detail of a subject specific to a collection
 */
@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UnitContent(
    unit: UnitIO,
    collectionViewModel: CollectionUnitsViewModel = hiltViewModel(),
    viewModel: UnitViewModel = hiltViewModel<UnitViewModel>(key = unit.uid),
    unitActionType: MutableState<UnitActionType>,
    requestRefresh: () -> Unit
) {
    val focusManager = LocalFocusManager.current
    val localDensity = LocalDensity.current
    val configuration = LocalConfiguration.current

    val scope = rememberCoroutineScope()
    val lazyGridState = rememberLazyGridState()

    val isLandscape = configuration.layoutDirection == Configuration.ORIENTATION_LANDSCAPE
            || LocalIsTablet.current

    val elements = viewModel.elements.collectAsState()

    val dragAndDropTarget = rememberSaveable  {
        mutableStateOf("")
    }
    val selectedFact = rememberSaveable(unit.uid) {
        mutableStateOf<String?>(null)
    }
    val activatedParagraph = rememberSaveable(unit.uid) {
        mutableStateOf(unit.activatedParagraph)
    }
    val bulletPoints = remember(unit.bulletPoints) {
        mutableStateListOf(*unit.bulletPoints.toTypedArray())
    }
    val hasScrolled = rememberSaveable(unit.uid) {
        mutableStateOf(false)
    }
    val collapsedParagraphs = viewModel.collapsedParagraphs.collectAsState()

    LaunchedEffect(activatedParagraph.value) {
        unit.activatedParagraph = activatedParagraph.value
    }

    LaunchedEffect(Unit) {
        collectionViewModel.scrollToElement.collectLatest { element ->
            if(element != null && element.unitUid == unit.uid) {
                viewModel.expandUntil(element)
                val index = elements.value.indexOfFirst { it.uid == element.elementUidList.lastOrNull() }
                if(index >= 0) {
                    lazyGridState.animateScrollToItem(index)
                }
                collectionViewModel.scrollToElement.value = null
            }
        }
    }
    LaunchedEffect(Unit) {
        viewModel.currentUnit = unit
        viewModel.requestElements()
    }
    LaunchedEffect(Unit) {
        viewModel.elements.collectLatest {
            if(it.isNotEmpty() && hasScrolled.value.not()) {
                hasScrolled.value = true
                if(unit.firstVisibleItemIndex > 0) {
                    lazyGridState.animateScrollToItem(unit.firstVisibleItemIndex, unit.firstVisibleItemOffset)
                }
            }
        }
    }

    val saveScrollScope = rememberCoroutineScope()
    LaunchedEffect(lazyGridState) {
        snapshotFlow { lazyGridState.firstVisibleItemScrollOffset }.collect { offset ->
            if(elements.value.isNotEmpty() && hasScrolled.value) {
                saveScrollScope.coroutineContext.cancelChildren()
                saveScrollScope.launch {
                    delay(REQUEST_DATA_SAVE_DELAY * 2)
                    viewModel.saveScrollPosition(
                        lazyGridState.firstVisibleItemIndex,
                        offset
                    )
                }
            }
        }
    }


    val bridge = remember(unit.uid) {
        object: ParagraphBlockBridge {
            override fun updateFact(newTO: FactIO) {
                viewModel.updateFact(newTO)
            }
            override fun updateParagraph(newTO: ParagraphIO) {
                viewModel.updateParagraph(newTO)
            }
            override fun addNewElement() {
                // adding new element to either activated paragraph or unit
                scope.launch {
                    val paragraph = elements.value.find { it.uid == activatedParagraph.value }
                    // shouldn't be able to add items to collapsed paragraphs
                    val index = if(paragraph != null && collapsedParagraphs.value.contains(activatedParagraph.value).not()) {
                        elements.value.indexOf(paragraph)
                    }else 0
                    onItemDropped(
                        element = paragraph,
                        index = lazyGridState.firstVisibleItemIndex.coerceAtLeast(index)
                    )
                }
                unitActionType.value = DEFAULT
            }
            override fun onItemDropped(element: UnitElement?, index: Int) {
                val superiorIndex = elements.value.indexOfFirst { it.uid == element?.uid }
                viewModel.localStateElement.value?.let { droppedElement ->
                    scope.launch {
                        var targetIndex = 0
                        var data: UnitElement? = null

                        when(element) {
                            is UnitElement.Paragraph -> {
                                if(collapsedParagraphs.value.contains(element.data.uid)) {
                                    viewModel.expandParagraph(elements.value.indexOf(element))
                                }

                                (droppedElement.first as? UnitElement.Paragraph)?.let { paragraph ->
                                    activatedParagraph.value = paragraph.uid
                                    data = UnitElement.Paragraph(
                                        data = paragraph.data,
                                        layer = element.layer.plus(1),
                                        notLastLayers = element.notLastLayers.toMutableList().apply {
                                            if(element.data.paragraphs.isNotEmpty()) add(element.layer.plus(1))
                                        }
                                    )
                                    targetIndex = superiorIndex + element.data.facts.size + 1
                                }
                                (droppedElement.first as? UnitElement.Fact)?.let { fact ->
                                    data = UnitElement.Fact(
                                        data = fact.data,
                                        //TODO is it needed? innerIndex = ,
                                        layer = element.layer,
                                        notLastLayers = element.notLastLayers,
                                        isLastParagraph = element.data.paragraphs.isEmpty(),
                                        parentUid = element.data.uid
                                    )
                                    targetIndex = superiorIndex + 1
                                }
                            }
                            is UnitElement.Fact -> {
                                (droppedElement.first as? UnitElement.Fact)?.data?.let { fact ->
                                    data = UnitElement.Fact(
                                        data = fact,
                                        //TODO is it needed? innerIndex = ,
                                        layer = element.layer,
                                        notLastLayers = element.notLastLayers,
                                        isLastParagraph = element.isLastParagraph,
                                        parentUid = element.parentUid
                                    )
                                    targetIndex = superiorIndex + 1
                                }
                            }
                            // UNIT
                            else -> {
                                (droppedElement.first as? UnitElement.Paragraph)?.let { paragraph ->
                                    activatedParagraph.value = paragraph.uid
                                    data = UnitElement.Paragraph(
                                        data = paragraph.data,
                                        layer = INITIAL_LAYER,
                                        notLastLayers = listOf()
                                    )
                                    targetIndex = viewModel.currentUnit?.facts?.size ?: 0
                                }
                                (droppedElement.first as? UnitElement.Fact)?.let { fact ->
                                    data = UnitElement.Fact(
                                        data = fact.data,
                                        //TODO is it needed? innerIndex = ,
                                        layer = INITIAL_LAYER,
                                        notLastLayers = listOf(),
                                        isLastParagraph = true,
                                        parentUid = unit.uid
                                    )
                                    targetIndex = 0
                                }
                            }
                        }
                        data?.let {
                            viewModel.onDragEnded(it, targetIndex, requestRefresh = requestRefresh)
                            if ((droppedElement.first as? UnitElement.Fact)?.data?.isEmpty == true) {
                                selectedFact.value = droppedElement.first.uid
                            }
                            if(targetIndex !in lazyGridState.firstVisibleItemIndex until lazyGridState.firstVisibleItemIndex
                                    .plus(lazyGridState.layoutInfo.visibleItemsInfo.size)
                            ) {
                                lazyGridState.animateScrollToItem(targetIndex)
                            }
                        }
                    }
                    selectedFact.value = null
                    dragAndDropTarget.value = ""
                }
            }
            override fun addNewBulletPoint(index: Int, bulletPoint: String?) {
                bulletPoints.add(index, bulletPoint ?: "")
            }
            override fun removeBulletPoint(index: Int) {
                bulletPoints.removeAt(index)
                viewModel.currentUnit?.bulletPoints = bulletPoints.toMutableList()
                collectionViewModel.updateUnit(unit)
            }
            override fun updateBulletPoint(index: Int, output: String) {
                if(index < bulletPoints.size) {
                    bulletPoints[index] = output
                    viewModel.currentUnit?.bulletPoints = bulletPoints.toMutableList()
                    collectionViewModel.updateUnit(unit)
                    unitActionType.value = DEFAULT
                }
            }
            override fun invalidate() {
                viewModel.cancelDragAndDrop()
                unitActionType.value = DEFAULT
            }
        }
    }

    BackHandler(unitActionType.value != DEFAULT) {
        unitActionType.value = DEFAULT
    }

    Scaffold(
        modifier = Modifier
            .onKeyEvent {
                when (it.key) {
                    Key.Escape -> {
                        focusManager.clearFocus(true)
                        selectedFact.value = null
                        true
                    }

                    else -> false
                }
            }
            .dragAndDropTarget(
                shouldStartDragAndDrop = { startEvent ->
                    startEvent
                        .mimeTypes()
                        .contains(ElementType.PARAGRAPH.name)
                            || startEvent
                        .mimeTypes()
                        .contains(ElementType.FACT.name)
                },
                target = object : DragAndDropTarget {
                    override fun onStarted(event: DragAndDropEvent) {
                        super.onStarted(event)
                        focusManager.clearFocus(true)
                        unitActionType.value = ELEMENT_OPTIONS
                    }

                    override fun onEnded(event: DragAndDropEvent) {
                        super.onEnded(event)
                        unitActionType.value = DEFAULT
                    }

                    override fun onDrop(event: DragAndDropEvent): Boolean = false
                }
            ),
        contentColor = Color.Transparent,
        containerColor = Color.Transparent,
        floatingActionButton = {
            UnitFloatingMenuActions(
                viewModel = viewModel,
                unitActionType = unitActionType,
                bridge = bridge,
                collectionViewModel = collectionViewModel,
                isLandscape = isLandscape,
                lazyGridState = lazyGridState
            )
        },
        floatingActionButtonPosition = FabPosition.Center
    ) {
        LazyVerticalGrid(
            modifier = Modifier
                .imePadding()
                .fillMaxSize(),
            state = lazyGridState,
            columns = GridCells.Fixed(if(isLandscape) 2 else 1),
            horizontalArrangement = if(isLandscape) Arrangement.spacedBy(4.dp) else Arrangement.Start
        ) {
            item(
                span = { GridItemSpan(if(isLandscape) 2 else 1) },
                key = unit.uid
            ) {
                val lineCount = remember {
                    mutableIntStateOf(1)
                }

                DropTargetContainer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp, bottom = 8.dp),
                    collapsedParagraphs = collapsedParagraphs.value,
                    identifier = unit.uid,
                    onDropped = {
                        bridge.onItemDropped(null, index = 0)
                    },
                    type = ElementType.PARAGRAPH,
                    dragAndDropTarget = dragAndDropTarget,
                    isEnabled = true,
                    onCanceled = {
                        bridge.invalidate()
                    }
                ) {
                    EditFieldInput(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .widthIn(min = TextFieldDefaults.MinWidth)
                            .height(with(localDensity) {
                                LocalTheme.styles.heading.fontSize.value.sp
                                    .toDp()
                                    .times(lineCount.intValue)
                                    .plus(16.dp)
                            }),
                        value = viewModel.currentUnit?.name ?: unit.name,
                        onTextLayout = { result ->
                            lineCount.intValue = result.lineCount
                        },
                        textStyle = LocalTheme.styles.heading,
                        isUnfocusedTransparent = true,
                        hint = stringResource(id = R.string.unit_heading_prefix),
                        maxLines = 4,
                        minLines = 1,
                        paddingValues = PaddingValues(horizontal = 8.dp),
                        maxLength = MAX_LENGTH_SHORT_TEXT,
                        onValueChange = { output ->
                            viewModel.currentUnit?.name = output
                            collectionViewModel.updateUnit(unit)
                        }
                    )
                }
            }
            itemsIndexed(
                bulletPoints,
                span = { _, _ -> GridItemSpan(if(isLandscape) 2 else 1) }
            ) { index, point ->
                val isIrremovable = bulletPoints.size == 1

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    ListItemEditField(
                        modifier = Modifier.padding(bottom = 2.dp),
                        prefix = FactType.BULLET_POINT_PREFIX,
                        identifier = "${index}_${unit.uid}",
                        value = point,
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
                                    focusManager.moveFocus(FocusDirection.Up)
                                }
                                if(it.isEmpty() || index > 0) {
                                    bridge.removeBulletPoint(index)
                                }
                            }
                        },
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = {
                                bulletPoints.add(index + 1, "")
                                scope.launch {
                                    delay(50)
                                    focusManager.moveFocus(FocusDirection.Down)
                                }
                            }
                        ),
                        onEntered = { text ->
                            bulletPoints.add(index + 1, text.toString())
                            scope.launch {
                                delay(50)
                                focusManager.moveFocus(FocusDirection.Down)
                            }
                        },
                        onValueChange = { output ->
                            bridge.updateBulletPoint(index, output)
                        }
                    )
                }
            }
            paragraphBlock(
                elements = elements,
                bridge = bridge,
                screenWidthDp = configuration.screenWidthDp,
                viewModel = viewModel,
                activatedParagraph = activatedParagraph,
                selectedFact = selectedFact,
                dragAndDropTarget = dragAndDropTarget,
                collapsedParagraphs = collapsedParagraphs,
                scope = scope,
                collectionViewModel = collectionViewModel,
                focusManager = focusManager,
                isLandscape = isLandscape
            )
            item {
                Spacer(modifier = Modifier.height(configuration.screenHeightDp.times(.25f).dp))
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RowScope.DragAndDropTargetBox(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    colorInactive: Color,
    colorActive: Color,
    contentDescription: String,
    onDrop: () -> Unit
) {
    val scope = rememberCoroutineScope()
    val textColor = remember(colorActive) { Animatable(colorActive) }
    val backgroundColor = remember(colorActive) { Animatable(colorInactive) }

    Box(
        modifier = modifier
            .weight(1f)
            .fillMaxHeight()
            .background(color = backgroundColor.value)
            .dragAndDropTarget(
                shouldStartDragAndDrop = { startEvent ->
                    startEvent
                        .mimeTypes()
                        .any {
                            it == ElementType.PARAGRAPH.name
                                    || it == ElementType.FACT.name
                        }
                },
                target = object : DragAndDropTarget {
                    override fun onEntered(event: DragAndDropEvent) {
                        Log.d("kostka_test", "onEntered")
                        super.onEntered(event)
                        scope.launch {
                            textColor.animateTo(Color.White)
                            backgroundColor.animateTo(colorActive)
                        }
                    }

                    override fun onExited(event: DragAndDropEvent) {
                        super.onExited(event)
                        scope.launch {
                            textColor.animateTo(colorActive)
                            backgroundColor.animateTo(colorInactive)
                        }
                    }

                    override fun onDrop(event: DragAndDropEvent): Boolean {
                        val clipData = event.toAndroidDragEvent().clipData
                        if (clipData != null) {
                            onDrop()
                        }
                        return clipData != null
                    }

                    override fun onEnded(event: DragAndDropEvent) {
                        super.onEnded(event)
                        scope.launch {
                            textColor.animateTo(colorActive)
                            backgroundColor.animateTo(colorInactive)
                        }
                    }
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(32.dp),
            imageVector = imageVector,
            tint = textColor.value,
            contentDescription = contentDescription
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DragAndDropSourceButton(
    modifier: Modifier = Modifier,
    viewModel: UnitViewModel,
    imageVector: ImageVector,
    text: String = "",
    contentDescription: String,
    bridge: ParagraphBlockBridge,
    elementType: ElementType
) {
    Box(
        modifier = modifier
            .dragAndDropSource {
                detectTapGestures(
                    onLongPress = {
                        viewModel.localStateElement.value = (if(elementType == ElementType.PARAGRAPH) {
                            UnitElement.Paragraph(data = ParagraphIO())
                        }else {
                            UnitElement.Fact(data = FactIO())
                        }) to -1
                        this@dragAndDropSource.startTransfer(
                            DragAndDropTransferData(
                                ClipData(
                                    "",
                                    // restrict to this type + paragraph, which is always supported
                                    arrayOf(elementType.name, ElementType.PARAGRAPH.name),
                                    ClipData.Item("")
                                )
                            )
                        )
                    },
                    onTap = {
                        viewModel.localStateElement.value = (if(elementType == ElementType.PARAGRAPH) {
                            UnitElement.Paragraph(data = ParagraphIO())
                        }else {
                            UnitElement.Fact(data = FactIO())
                        }) to -1
                        bridge.addNewElement()
                    }
                )
            },
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = LocalTheme.colors.tetrial,
                    shape = FloatingActionButtonDefaults.shape
                )
                .shadow(
                    elevation = LocalTheme.styles.actionElevation,
                    shape = FloatingActionButtonDefaults.shape
                ),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                if(text.isNotBlank()) {
                    Text(
                        modifier = Modifier.padding(end = 4.dp),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = LocalTheme.colors.brandMainDark
                        ),
                        text = text.uppercase()
                    )
                }
                Icon(
                    modifier = Modifier.size(32.dp),
                    imageVector = imageVector,
                    tint = LocalTheme.colors.brandMainDark,
                    contentDescription = contentDescription
                )
            }
        }
    }
}

enum class UnitActionType {
    DEFAULT,
    ADD_CONTENT,
    ELEMENT_OPTIONS,
    ELEMENT_ARCHIVE
}