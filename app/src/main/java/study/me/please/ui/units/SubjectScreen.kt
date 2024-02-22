package study.me.please.ui.units

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.res.Configuration
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.animation.Animatable
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateContentSize
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.FormatListBulleted
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
import study.me.please.data.io.FactType
import study.me.please.data.io.subjects.CategoryIO
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.data.io.subjects.UnitIO
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.ListItemEditField
import java.util.UUID

private const val MAX_LENGTH_SHORT_TEXT = 42

/**
 * Detail of a subject specific to a collection
 */
@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UnitScreen(
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
    val unitBulletPoints = remember {
        mutableStateListOf(*unit.bulletPoints.toTypedArray())
    }
    val selectedFact = remember {
        mutableStateOf<String?>(null)
    }
    val nestedParagraphs = remember(unit) {
        mutableStateListOf(*unit.paragraphs.toTypedArray())
    }
    val collapsedParagraphs = remember {
        mutableStateListOf(*unit.collapsedParagraphs.toTypedArray())
    }

    LaunchedEffect(collapsedParagraphs.size) {
        unit.collapsedParagraphs = collapsedParagraphs
    }

    val bridge = remember {
        object: UnitScreenBridge {
            override fun updateBulletPoints() {
                unit.bulletPoints = unitBulletPoints.toMutableList()
                viewModel.updateUnit(unit)
            }
            override fun updateParagraph(paragraph: ParagraphIO) {
                viewModel.updateParagraph(unit, newParagraph = paragraph)
            }
            override fun addParagraph() {
                addContentVisible.value = false
                nestedParagraphs.add(0, ParagraphIO())
            }
            override suspend fun removeParagraph(uid: String) {
                if(nestedParagraphs.removeIf { it.uid == uid }) {
                    viewModel.elementUidToRemove.emit(null)
                    addContentVisible.value = false
                }
            }
            override fun addBulletPoint() {
                addContentVisible.value = false
                unitBulletPoints.add(0, "")
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.elementUidToRemove.collectLatest { elementUid ->
            withContext(Dispatchers.Default) {
                if(elementUid != null) {
                    bridge.removeParagraph(elementUid)
                }
            }
        }
    }

    LaunchedEffect(unitBulletPoints.size) {
        bridge.updateBulletPoints()
    }
    LaunchedEffect(nestedParagraphs.size) {
        unit.paragraphs = nestedParagraphs
        viewModel.updateUnit(unit)
    }

    BackHandler(addContentVisible.value) {
        addContentVisible.value = false
    }


    /*TODO add back functionality of mass selection and action
    *
        val coroutineScope = rememberCoroutineScope()

        LaunchedEffect(bridge.selectedFactUids.size) {
            if(bridge.selectedFactUids.size > 0) {
                nestedFacts.forEach {
                    it.second.mode.value = InteractiveCardMode.CHECKING
                }
            }else {
                bridge.stopChecking()
            }
        }

        BackHandler(bridge.selectedFactUids.size > 0) {
            bridge.stopChecking()
        }

        OptionsLayout(
            modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp),
            onCopyRequest = {
                coroutineScope.launch(Dispatchers.Default) {
                    clipBoard?.facts?.copyItems(
                        paragraph.facts.filter { bridge.selectedFactUids.contains(it.uid) }
                    )
                    bridge.stopChecking()
                }
            },
            onPasteRequest = { bridge.requestFactsPaste() },
            onDeleteRequest = { showDeleteDialog = true },
            onSelectAll = {
                nestedFacts.forEach {
                    it.second.isChecked.value = true
                }
            },
            onDeselectAll = { bridge.stopChecking() },
            isEditMode = bridge.selectedFactUids.size > 0,
            hasPasteOption = clipBoard?.facts?.isEmpty?.value == false,
            animateTopDown = false,
            onClipBoardRemoval = { clipBoard?.facts?.clear() }
        )
    *
    */

    if(showDeleteDialog.value != null) {
        BasicAlertDialog(
            title = stringResource(id = R.string.generic_delete_dialog_title),
            content = stringResource(R.string.generic_delete_dialog_description),
            icon = Icons.Outlined.Delete,
            confirmButtonState = ButtonState(
                text = stringResource(id = R.string.button_confirm)
            ) {
                showDeleteDialog.value?.let { uid ->
                    Log.d("kostka_test", "elementUidToRemove: $uid")
                    scope.launch {
                        viewModel.elementUidToRemove.emit(uid)
                    }
                }
                showDeleteDialog.value = null
            },
            dismissButtonState = ButtonState(
                text = stringResource(id = R.string.button_dismiss)
            ) {
                showDeleteDialog.value = null
            }
        )
    }

    val dragAndDropStarted = remember {
        mutableStateOf(false)
    }
    val dragAndDropTarget = rememberSaveable  {
        mutableStateOf("")
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
            .dragAndDropTarget(
                shouldStartDragAndDrop = { startEvent ->
                    startEvent
                        .mimeTypes()
                        .contains(ParagraphBlockState.ElementType.PARAGRAPH.name)
                            || startEvent
                        .mimeTypes()
                        .contains(ParagraphBlockState.ElementType.BULLET_POINT.name)
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
                        onDrop = { type, uid ->
                            when(type) {
                                ParagraphBlockState.ElementType.FACT -> {
                                    viewModel.copyFactByUid(paragraphs = unit.paragraphs, uid = uid)
                                }
                                ParagraphBlockState.ElementType.PARAGRAPH -> {
                                    viewModel.copyParagraphByUid(paragraphs = unit.paragraphs, uid = uid)
                                }
                                else -> {}
                            }
                        }
                    )
                    DragAndDropTargetBox(
                        colorActive = Colors.YELLOW,
                        colorInactive = Colors.YELLOW_50,
                        imageVector = Icons.Outlined.Archive,
                        contentDescription = stringResource(R.string.button_archive),
                        onDrop = { type, uid ->
                            when(type) {
                                ParagraphBlockState.ElementType.FACT -> {
                                    viewModel.copyFactByUid(paragraphs = unit.paragraphs, uid = uid)
                                }
                                ParagraphBlockState.ElementType.PARAGRAPH -> {
                                    viewModel.copyParagraphByUid(paragraphs = unit.paragraphs, uid = uid)
                                }
                                else -> {}
                            }
                            scope.launch {
                                viewModel.elementUidToRemove.emit(uid)
                            }
                        }
                    )
                    DragAndDropTargetBox(
                        colorActive = Colors.RED_ERROR,
                        colorInactive = Colors.RED_ERROR_50,
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = stringResource(R.string.accessibility_delete),
                        onDrop = { _, uid ->
                            if(uid.isNotEmpty()) showDeleteDialog.value = uid
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
                                    elementType = ParagraphBlockState.ElementType.BULLET_POINT,
                                    imageVector = Icons.AutoMirrored.Outlined.FormatListBulleted,
                                    contentDescription = stringResource(R.string.accessibility_add_bullet_point)
                                )
                                DragAndDropSourceButton(
                                    modifier = Modifier.weight(1f, fill = false),
                                    elementType = ParagraphBlockState.ElementType.PARAGRAPH,
                                    imageVector = Icons.Outlined.Category,
                                    contentDescription = stringResource(R.string.accessibility_add_paragraph)
                                )
                                DragAndDropSourceButton(
                                    modifier = Modifier.weight(1f, fill = false),
                                    elementType = ParagraphBlockState.ElementType.FACT,
                                    imageVector = Icons.AutoMirrored.Outlined.ShortText,
                                    contentDescription = stringResource(R.string.accessibility_add_fact)
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
                    }
                    .animateContentSize(),
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
                        EditFieldInput(
                            modifier = Modifier
                                .padding(start = 16.dp)
                                .widthIn(min = TextFieldDefaults.MinWidth)
                                .wrapContentHeight(),
                            value = unit.name,
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

                        val started = remember { mutableStateOf(false) }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .animateContentSize()
                                .height(if(started.value) 40.dp else 0.dp)
                                .dragAndDropTarget(
                                    shouldStartDragAndDrop = { startEvent ->
                                        startEvent
                                            .mimeTypes()
                                            .contains(ParagraphBlockState.ElementType.PARAGRAPH.name)
                                                || startEvent
                                            .mimeTypes()
                                            .contains(ParagraphBlockState.ElementType.BULLET_POINT.name)
                                    },
                                    target = object : DragAndDropTarget {
                                        override fun onDrop(event: DragAndDropEvent): Boolean {
                                            val clipData = event.toAndroidDragEvent().clipData
                                            val firstMimeType = event
                                                .mimeTypes()
                                                .firstOrNull()

                                            scope.launch(Dispatchers.Default) {
                                                if (clipData != null) {
                                                    for (i in 0 until clipData.itemCount) {
                                                        ParagraphBlockState.ElementType
                                                            .values()
                                                            .find {
                                                                it.name == firstMimeType
                                                            }
                                                            ?.let {
                                                                when (it) {
                                                                    ParagraphBlockState.ElementType.BULLET_POINT -> {
                                                                        bridge.addBulletPoint()
                                                                        addContentVisible.value =
                                                                            false
                                                                    }

                                                                    ParagraphBlockState.ElementType.PARAGRAPH -> {
                                                                        bridge.addParagraph()
                                                                        //clipData.getItemAt(i).text
                                                                        addContentVisible.value =
                                                                            false
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
                                            dragAndDropTarget.value = unit.uid
                                        }

                                        override fun onExited(event: DragAndDropEvent) {
                                            super.onExited(event)
                                            dragAndDropTarget.value = ""
                                        }

                                        override fun onStarted(event: DragAndDropEvent) {
                                            super.onStarted(event)
                                            started.value = true
                                        }

                                        override fun onEnded(event: DragAndDropEvent) {
                                            super.onEnded(event)
                                            started.value = false
                                        }
                                    }
                                )
                                .then(
                                    if (dragAndDropTarget.value == unit.uid) {
                                        Modifier.background(
                                            color = LocalTheme.colors.brandMain,
                                        )
                                    } else if (started.value) {
                                        Modifier.background(
                                            color = LocalTheme.colors.tetrial,
                                        )
                                    } else Modifier
                                )
                        )
                    }
                }
                itemsIndexed(unitBulletPoints) { index, point ->
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        ListItemEditField(
                            prefix = FactType.BULLET_POINT_PREFIX,
                            value = point,
                            onBackspaceKey = {
                                if(it.isEmpty()) {
                                    if(index > 0) {
                                        focusManager.moveFocus(FocusDirection.Up)
                                    }
                                    unitBulletPoints.removeAt(index)
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
                                unitBulletPoints[index] = output
                                bridge.updateBulletPoints()
                            }
                        )
                    }
                }
                nestedParagraphs.forEachIndexed { index, paragraph ->
                    paragraphBlock(
                        unitsViewModel = viewModel,
                        collapsedParagraphs = collapsedParagraphs,
                        generalScope = scope,
                        dragAndDropTarget = dragAndDropTarget,
                        state = ParagraphBlockState(
                            categories = categories,
                            paragraph = paragraph,
                            parentLayer = -1,
                            clipBoard = viewModel.clipBoard,
                            updateParagraph = { updatedParagraph ->
                                bridge.updateParagraph(updatedParagraph)
                            },
                            selectedFact = selectedFact
                        ),
                        addNewCategory = { name ->
                            val newCategory = CategoryIO(name = name)
                            viewModel.requestAddNewCategory(newCategory)
                            newCategory
                        },
                        addContentVisible = addContentVisible,
                        screenWidthDp = screenWidth,
                        onNewCategoryChosen = { chosenCategory ->
                            nestedParagraphs.getOrNull(index)?.apply {
                                localCategory = chosenCategory
                                categoryUid = chosenCategory.uid
                                bridge.updateParagraph(this)
                            }
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
    onDrop: (type: ParagraphBlockState.ElementType, uid: String) -> Unit
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
                        .contains(ParagraphBlockState.ElementType.PARAGRAPH.name)
                            || startEvent
                        .mimeTypes()
                        .contains(ParagraphBlockState.ElementType.BULLET_POINT.name)
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
                        val firstMimeType = event
                            .mimeTypes()
                            .firstOrNull()
                        scope.launch(Dispatchers.Default) {
                            if (clipData != null) {
                                for (i in 0 until clipData.itemCount) {
                                    ParagraphBlockState.ElementType
                                        .values()
                                        .find {
                                            it.name == firstMimeType
                                        }
                                        ?.let {
                                            onDrop(it, clipData.getItemAt(i).text?.toString() ?: "")
                                        }
                                }
                            }
                        }
                        return true
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
    imageVector: ImageVector,
    contentDescription: String,
    elementType: ParagraphBlockState.ElementType
) {
    Box(
        modifier = modifier
            .dragAndDropSource {
                detectTapGestures(
                    onLongPress = {
                        this@dragAndDropSource.startTransfer(
                            DragAndDropTransferData(
                                ClipData(
                                    "",
                                    // restrict to this type + paragraph, which is always supported
                                    arrayOf(elementType.name, ParagraphBlockState.ElementType.PARAGRAPH.name),
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