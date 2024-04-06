package study.me.please.ui.units

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.res.Configuration
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.animation.Animatable
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.draganddrop.dragAndDropSource
import androidx.compose.foundation.draganddrop.dragAndDropTarget
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ShortText
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Archive
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.squadris.squadris.compose.components.input.EditFieldInput
import com.squadris.squadris.compose.theme.Colors
import com.squadris.squadris.compose.theme.LocalTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import study.me.please.R
import study.me.please.base.LocalIsTablet
import study.me.please.data.io.FactIO
import study.me.please.data.io.FactType
import study.me.please.data.io.subjects.CategoryIO
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.data.io.subjects.UnitIO
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.FactCard
import study.me.please.ui.components.InteractiveCardMode
import study.me.please.ui.components.ListItemEditField
import study.me.please.ui.units.UnitsViewModel.ElementToDrag
import java.util.UUID

private const val MAX_LENGTH_SHORT_TEXT = 42

/**
 * Detail of a subject specific to a collection
 */
@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UnitContent(
    unit: UnitIO,
    filtersContent: @Composable () -> Unit,
    viewModel: UnitsViewModel = hiltViewModel()
) {
    val categories = viewModel.categories.collectAsState()

    val focusManager = LocalFocusManager.current
    val localDensity = LocalDensity.current
    val configuration = LocalConfiguration.current
    val scope = rememberCoroutineScope()
    val lazyGridState = rememberLazyGridState()
    val screenWidth = configuration.screenWidthDp

    val isLandscape = configuration.layoutDirection == Configuration.ORIENTATION_LANDSCAPE
            || LocalIsTablet.current

    val addContentVisible = rememberSaveable { mutableStateOf(false) }
    val showDeleteDialog = remember { mutableStateOf<String?>(null) }
    val dragAndDropStarted = remember {
        mutableStateOf(false)
    }
    val dragAndDropTarget = rememberSaveable  {
        mutableStateOf("")
    }

    val unitBulletPoints = remember(unit.bulletPoints) {
        mutableStateListOf(*unit.bulletPoints.toTypedArray())
    }
    val selectedFact = rememberSaveable(unit.facts) {
        mutableStateOf<String?>(null)
    }
    val nestedParagraphs = remember(unit.paragraphs) {
        mutableStateListOf(*unit.paragraphs.toTypedArray())
    }
    val nestedFacts = remember(unit.facts) {
        mutableStateListOf(*unit.facts.toTypedArray())
    }
    val collapsedParagraphs = remember(unit.collapsedParagraphs) {
        mutableStateListOf(*unit.collapsedParagraphs.toTypedArray())
    }

    LaunchedEffect(collapsedParagraphs.size) {
        unit.collapsedParagraphs = collapsedParagraphs
    }


    val bridge = remember {
        object: ParagraphBlockBridge {
            override fun addFact(element: ElementToDrag) {
                if(element.fact != null) {
                    nestedFacts.run {
                        removeIf { it.uid == element.fact.uid }
                        add(element.index, element.fact)
                    }

                    if(element.fact.isEmpty) {
                        selectedFact.value = element.fact.uid
                    }
                }
            }
            override fun removeUiFact(uid: String) {
                nestedFacts.removeIf { it.uid == uid }
            }
            override fun requestFactsPaste() { }
            override fun addParagraph(element: ElementToDrag) {
                if(element.paragraph != null) {
                    nestedParagraphs.run {
                        removeIf { it.uid == element.paragraph.uid }
                        add(element.index, element.paragraph)
                    }
                }
            }
            override fun removeUiParagraph(uid: String) {
                nestedParagraphs.removeIf { it.uid == uid }
            }
            override fun addNewBulletPoint(index: Int, bulletPoint: String?) {
                unitBulletPoints.add(index, bulletPoint ?: "")
            }
            override fun removeBulletPoint(index: Int) {
                unitBulletPoints.removeAt(index)
                unit.bulletPoints = unitBulletPoints.toMutableList()
                viewModel.updateUnit(unit)
            }
            override fun updateBulletPoint(index: Int, output: String) {
                unitBulletPoints[index] = output
                unit.bulletPoints = unitBulletPoints.toMutableList()
                viewModel.updateUnit(unit)
            }
            override fun invalidate() {
                dragAndDropTarget.value = ""
                scope.launch(Dispatchers.Default) {
                    if(unit.facts.size != nestedFacts.size) {
                        unit.facts.forEachIndexed { index, factIO ->
                            if(nestedFacts.none { it.uid == factIO.uid }) {
                                nestedFacts.add(index, factIO)
                            }
                        }
                    }
                    if(unit.paragraphs.size != nestedParagraphs.size) {
                        unit.paragraphs.forEachIndexed { index, paragraphIO ->
                            nestedParagraphs.add(index, paragraphIO)
                        }
                    }
                }
            }
        }
    }

    val paragraphBlocks = nestedParagraphs.map { paragraph ->
        rememberParagraphBlockState(
            parentLayer = -1,
            categories = categories,
            selectedFact = selectedFact,
            clipBoard = viewModel.clipBoard,
            paragraphArg = paragraph,
            viewModel = viewModel,
            updateParagraph = { updatedParagraph ->
                viewModel.updateParagraph(unit, newParagraph = updatedParagraph)
            },
            updateFact = { updatedFact ->
                viewModel.updateFact(unit = unit, fact = updatedFact)
            }
        )
    }

    LaunchedEffect(Unit) {
        viewModel.elementUidToRemove.collectLatest { elementUid ->
            withContext(Dispatchers.Default) {
                if(elementUid != null) {
                    viewModel.requestObjectRemoval(unit, elementUid)
                    addContentVisible.value = false
                }
            }
        }
    }

    BackHandler(addContentVisible.value) {
        addContentVisible.value = false
    }

    if(showDeleteDialog.value != null) {
        BasicAlertDialog(
            title = stringResource(id = R.string.generic_delete_dialog_title),
            content = stringResource(R.string.generic_delete_dialog_description),
            icon = Icons.Outlined.Delete,
            confirmButtonState = ButtonState(
                text = stringResource(id = R.string.button_confirm)
            ) {
                showDeleteDialog.value?.let { uid ->
                    viewModel.elementUidToRemove.value = uid
                }
                showDeleteDialog.value = null
            },
            dismissButtonState = ButtonState(
                text = stringResource(id = R.string.button_dismiss)
            ) {
                showDeleteDialog.value = null
                bridge.invalidate()
            }
        )
    }

    val xOffset: Float by animateFloatAsState(
        with(localDensity) {
            if(dragAndDropStarted.value) {
                0f
            }else configuration.screenWidthDp.dp.plus(100.dp).toPx()
        },
        label = ""
    )

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
                        dragAndDropStarted.value = true
                    }

                    override fun onEnded(event: DragAndDropEvent) {
                        super.onEnded(event)
                        dragAndDropStarted.value = false
                    }

                    override fun onDrop(event: DragAndDropEvent): Boolean = false
                }
            ),
        contentColor = Color.Transparent,
        containerColor = Color.Transparent,
        floatingActionButton = {
            ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                val (scrollUpBox,
                    scrollDownBox,
                    optionsRow,
                    addContentRow
                ) = createRefs()

                // scroll up box
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(scrollUpBox) {
                            this.translationX = with(localDensity) {
                                xOffset.toDp()
                            }
                            top.linkTo(parent.top)
                            linkTo(parent.start, parent.end)
                        }
                        .height(configuration.screenHeightDp.times(0.075f).dp)
                        .zIndex(100f)
                        .dragAndDropTarget(
                            shouldStartDragAndDrop = { true },
                            target = object : DragAndDropTarget {
                                override fun onMoved(event: DragAndDropEvent) {
                                    super.onMoved(event)
                                    scope.launch {
                                        lazyGridState.scrollBy(-30f)
                                    }
                                }

                                override fun onDrop(event: DragAndDropEvent): Boolean = false
                            }
                        )
                )
                // scroll down box + options
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .zIndex(99f)
                        .constrainAs(scrollDownBox) {
                            this.translationX = with(localDensity) {
                                xOffset.toDp()
                            }
                            bottom.linkTo(optionsRow.top)
                            linkTo(parent.start, parent.end)
                        }
                        .height(configuration.screenHeightDp.times(0.075f).dp)
                        .dragAndDropTarget(
                            shouldStartDragAndDrop = { true },
                            target = object : DragAndDropTarget {
                                override fun onMoved(event: DragAndDropEvent) {
                                    super.onMoved(event)
                                    scope.launch {
                                        lazyGridState.scrollBy(30f)
                                    }
                                }

                                override fun onDrop(event: DragAndDropEvent): Boolean = false
                            }
                        )
                )
                Row(
                    modifier = Modifier
                        .height(62.dp)
                        .zIndex(100f)
                        .constrainAs(optionsRow) {
                            this.translationX = with(localDensity) {
                                xOffset.toDp()
                            }
                            bottom.linkTo(parent.bottom)
                            linkTo(parent.start, parent.end)
                        }
                        .fillMaxWidth()
                ) {
                    DragAndDropTargetBox(
                        colorActive = Colors.GREEN_CORRECT,
                        colorInactive = Colors.GREEN_CORRECT_50,
                        imageVector = Icons.Outlined.ContentCopy,
                        contentDescription = stringResource(R.string.button_copy),
                        onDrop = {
                            //TODO copying
                        }
                    )
                    DragAndDropTargetBox(
                        colorActive = Colors.YELLOW,
                        colorInactive = Colors.YELLOW_50,
                        imageVector = Icons.Outlined.Archive,
                        contentDescription = stringResource(R.string.button_archive),
                        onDrop = {
                            //TODO archive
                        }
                    )
                    DragAndDropTargetBox(
                        colorActive = Colors.RED_ERROR,
                        colorInactive = Colors.RED_ERROR_50,
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = stringResource(R.string.accessibility_delete),
                        onDrop = {
                            viewModel.localStateElement?.uid?.let { uid ->
                                showDeleteDialog.value = uid
                            }
                        }
                    )
                }

                AnimatedVisibility(
                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(addContentRow) {
                            bottom.linkTo(parent.bottom)
                            linkTo(parent.start, parent.end)
                        },
                    visible = dragAndDropStarted.value.not(),
                ) {
                    Crossfade(
                        modifier = Modifier
                            .fillMaxWidth(),
                        targetState = addContentVisible.value,
                        label = "",
                    ) { interfaceVisible ->
                        if(interfaceVisible) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                DragAndDropSourceButton(
                                    modifier = Modifier.weight(1f, fill = false),
                                    elementType = ElementType.PARAGRAPH,
                                    imageVector = Icons.Outlined.Category,
                                    contentDescription = stringResource(R.string.accessibility_add_paragraph),
                                    viewModel = viewModel
                                )
                                DragAndDropSourceButton(
                                    modifier = Modifier.weight(1f, fill = false),
                                    elementType = ElementType.FACT,
                                    imageVector = Icons.AutoMirrored.Outlined.ShortText,
                                    contentDescription = stringResource(R.string.accessibility_add_fact),
                                    viewModel = viewModel
                                )
                            }
                        }else {
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.BottomEnd
                            ) {
                                FloatingActionButton(
                                    containerColor = LocalTheme.colors.tetrial,
                                    contentColor = LocalTheme.colors.brandMain,
                                    onClick = {
                                        addContentVisible.value = true
                                    }
                                ) {
                                    Icon(
                                        modifier = Modifier.size(32.dp),
                                        imageVector = Icons.Outlined.Add,
                                        contentDescription = stringResource(R.string.accessibility_add_content)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(Unit) {
                        detectTapGestures(onTap = {
                            focusManager.clearFocus()
                            addContentVisible.value = false
                        })
                    },
                state = lazyGridState,
                columns = GridCells.Fixed(if(isLandscape) 2 else 1),
                horizontalArrangement = if(isLandscape) Arrangement.spacedBy(4.dp) else Arrangement.Start
            ) {
                item(span = { GridItemSpan(if(isLandscape) 2 else 1) }) {
                    filtersContent()
                }
                item(
                    span = { GridItemSpan(if(isLandscape) 2 else 1) },
                    contentType = UUID.randomUUID().toString()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        val lineCount = remember {
                            mutableIntStateOf(1)
                        }

                        DropTargetContainer(
                            collapsedParagraphs = collapsedParagraphs,
                            identifier = unit.uid,
                            onDropped = {
                                val localStateElement = viewModel.localStateElement?.data
                                Log.d("kostka_test", "onDropped, localState: $localStateElement")
                                when(localStateElement) {
                                    is FactIO -> {
                                        val index = nestedFacts
                                            .indexOfFirst { inner ->
                                                inner.uid == localStateElement.uid
                                            }
                                            .coerceAtLeast(0)
                                        scope.launch {
                                            val element = viewModel.onDragEnded(
                                                ElementToDrag(
                                                    data = localStateElement,
                                                    parentUid = unit.uid,
                                                    index = index
                                                )
                                            )
                                            bridge.addFact(element)
                                        }
                                    }
                                    is ParagraphIO -> {
                                        val index = nestedParagraphs
                                            .indexOfFirst { inner ->
                                                inner.uid == localStateElement.uid
                                            }
                                            .coerceAtLeast(0)
                                        scope.launch {
                                            val element = viewModel.onDragEnded(
                                                ElementToDrag(
                                                    data = localStateElement,
                                                    parentUid = unit.uid,
                                                    index = index
                                                )
                                            )
                                            bridge.addParagraph(element)
                                        }
                                    }
                                    else -> {}
                                }
                            },
                            type = ElementType.PARAGRAPH,
                            dragAndDropTarget = dragAndDropTarget,
                            isEnabled = true,
                            onCanceled = {
                                bridge.invalidate()
                            }
                        ) { modifier ->
                            EditFieldInput(
                                modifier = modifier
                                    .padding(start = 16.dp)
                                    .widthIn(min = TextFieldDefaults.MinWidth)
                                    .height(with(localDensity) {
                                        LocalTheme.styles.heading.fontSize.value.sp
                                            .toDp()
                                            .times(lineCount.intValue)
                                            .plus(16.dp)
                                    }),
                                value = unit.name,
                                onTextLayout = { result ->
                                    lineCount.intValue = result.lineCount
                                },
                                textStyle = LocalTheme.styles.heading,
                                isUnfocusedTransparent = true,
                                hint = stringResource(id = R.string.subject_heading_prefix),
                                maxLines = 4,
                                minLines = 1,
                                paddingValues = PaddingValues(horizontal = 8.dp),
                                maxLength = MAX_LENGTH_SHORT_TEXT,
                                onValueChange = { output ->
                                    unit.name = output
                                    viewModel.updateUnit(unit)
                                }
                            )
                        }
                    }
                }
                itemsIndexed(unitBulletPoints) { index, point ->
                    val isIrremovable = unitBulletPoints.size == 1

                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.CenterStart
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
                                    unitBulletPoints.add(index + 1, "")
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
                }
                itemsIndexed(
                    items = nestedFacts,
                    key = { _, fact -> fact.uid }
                ) { index, fact ->
                    FactCard(
                        modifier = Modifier
                            .dragSource(
                                onClick = {
                                    if (selectedFact.value != fact.uid) {
                                        selectedFact.value = fact.uid
                                    }
                                },
                                elementType = ElementType.FACT,
                                uid = fact.uid,
                                onStarted = {
                                    viewModel.localStateElement = ElementToDrag(
                                        data = fact,
                                        parentUid = unit.uid,
                                        index = index
                                    )
                                    Log.d(
                                        "kostka_test",
                                        "before, nestedFacts: ${nestedFacts.map { it.uid }}"
                                    )
                                    bridge.removeUiFact(fact.uid)
                                    Log.d(
                                        "kostka_test",
                                        "after, nestedFacts: ${nestedFacts.map { it.uid }}"
                                    )
                                }
                            )
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        data = fact,
                        requestDataSave = { newFact ->
                            viewModel.updateFact(unit = unit, fact = newFact)
                        },
                        onClick = {
                            selectedFact.value = if(selectedFact.value == fact.uid) null else fact.uid
                        },
                        mode = when {
                            selectedFact.value == fact.uid -> InteractiveCardMode.EDIT
                            else -> InteractiveCardMode.DATA_DISPLAY
                        }
                    )
                }
                paragraphBlocks.forEachIndexed { index, state ->
                    paragraphBlock(
                        modifier = Modifier.dragSource(
                            onClick = {
                                Log.d("kostka_test", "onClick, collapsedParagraphs: $collapsedParagraphs")
                                if (collapsedParagraphs.contains(state.paragraph.uid)) {
                                    collapsedParagraphs.remove(state.paragraph.uid)
                                } else {
                                    collapsedParagraphs.add(state.paragraph.uid)
                                }
                            },
                            elementType = ElementType.PARAGRAPH,
                            uid = state.paragraph.uid,
                            onStarted = {
                                viewModel.localStateElement = UnitsViewModel.ElementToDrag(
                                    data = state.paragraph,
                                    parentUid = unit.uid,
                                    index = index
                                )
                                bridge.removeUiParagraph(state.paragraph.uid)
                            }
                        ),
                        state = state,
                        unitsViewModel = viewModel,
                        collapsedParagraphs = collapsedParagraphs,
                        generalScope = scope,
                        dragAndDropTarget = dragAndDropTarget,
                        addNewCategory = { name ->
                            val newCategory = CategoryIO(name = name)
                            viewModel.requestAddNewCategory(newCategory)
                            newCategory
                        },
                        addContentVisible = addContentVisible,
                        screenWidthDp = screenWidth,
                        onNewCategoryChosen = { chosenCategory ->
                            /* TODO remove categories and just save names and use them as "categories" with duplicite being allowed
                            nestedParagraphs.getOrNull(index)?.apply {
                                localCategory = chosenCategory
                                categoryUid = chosenCategory.uid
                                bridge.updateParagraph(this)
                            }*/
                        },
                        isLandscape = isLandscape
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(240.dp))
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun RowScope.DragAndDropTargetBox(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    colorInactive: Color,
    colorActive: Color,
    contentDescription: String,
    onDrop: () -> Unit
) {
    val scope = rememberCoroutineScope()
    val textColor = remember { Animatable(colorActive) }
    val backgroundColor = remember { Animatable(colorInactive) }

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
private fun DragAndDropSourceButton(
    modifier: Modifier = Modifier,
    viewModel: UnitsViewModel,
    imageVector: ImageVector,
    contentDescription: String,
    elementType: ElementType
) {
    Box(
        modifier = modifier
            .dragAndDropSource {
                detectTapGestures(
                    onLongPress = {
                        viewModel.localStateElement = ElementToDrag(
                            data = if(elementType == ElementType.PARAGRAPH) {
                                ParagraphIO()
                            }else FactIO(),
                            parentUid = "",
                            index = 0
                        )
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
                    }
                )
            },
    ) {
        Box(
            modifier = Modifier
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
                modifier = Modifier.padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.padding(end = 4.dp),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = LocalTheme.colors.brandMainDark
                    ),
                    text = contentDescription
                )
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