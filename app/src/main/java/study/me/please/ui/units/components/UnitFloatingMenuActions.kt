package study.me.please.ui.units.components

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.draganddrop.dragAndDropTarget
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ShortText
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Archive
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draganddrop.DragAndDropEvent
import androidx.compose.ui.draganddrop.DragAndDropTarget
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import com.squadris.squadris.compose.components.MinimalisticIcon
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.compose.theme.SharedColors
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.data.io.UnitElement
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.ButtonState
import study.me.please.ui.units.UnitViewModel
import study.me.please.ui.units.utils.ElementType
import study.me.please.ui.units.utils.ParagraphBlockBridge
import study.me.please.ui.units.utils.UnitActionType
import study.me.please.ui.units.utils.UnitActionType.ADD_CONTENT
import study.me.please.ui.units.utils.UnitActionType.DEFAULT
import study.me.please.ui.units.utils.UnitActionType.ELEMENT_ARCHIVE
import study.me.please.ui.units.utils.UnitActionType.ELEMENT_OPTIONS

/** bar with actions for unit */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UnitFloatingMenuActions(
    modifier: Modifier = Modifier,
    viewModel: UnitViewModel,
    unitActionType: MutableState<UnitActionType>,
    lazyGridState: LazyGridState,
    bridge: ParagraphBlockBridge
) {
    val scope = rememberCoroutineScope()
    val localDensity = LocalDensity.current
    val configuration = LocalConfiguration.current

    val showDeleteDialog = remember { mutableStateOf<String?>(null) }

    if(showDeleteDialog.value != null) {
        BasicAlertDialog(
            title = stringResource(id = R.string.generic_delete_dialog_title),
            content = stringResource(R.string.generic_delete_dialog_description),
            icon = Icons.Outlined.Delete,
            confirmButtonState = ButtonState(
                text = stringResource(id = R.string.button_confirm)
            ) {
                showDeleteDialog.value?.let { uid ->
                    scope.launch {
                        viewModel.requestElementRemoval(uid, delete = true)
                        unitActionType.value = DEFAULT
                    }
                }
            },
            dismissButtonState = ButtonState(
                text = stringResource(id = R.string.button_dismiss)
            ) { bridge.invalidate() },
            onDismissRequest = { showDeleteDialog.value = null }
        )
    }
    
    ConstraintLayout(
        modifier = modifier.fillMaxSize()
    ) {
        val (scrollUpBox,
            scrollDownBox,
            optionsRow,
            addContentRow
        ) = createRefs()

        val localStateElement = viewModel.localStateElement.collectAsState()

        val scrollingScope = rememberCoroutineScope()
        val xOffset: Float by animateFloatAsState(
            with(localDensity) {
                if(unitActionType.value == ELEMENT_OPTIONS) {
                    0f
                }else configuration.screenWidthDp.dp.toPx()
            },
            label = ""
        )
        val xOffsetOptions = with(localDensity) {
            if(unitActionType.value == ELEMENT_OPTIONS
                && localStateElement.value?.second != null
                && localStateElement.value?.second != -1
            ) {
                0f
            }else configuration.screenWidthDp.dp.toPx()
        }

        // scroll up box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(scrollUpBox) {
                    this.translationX = with(localDensity) {
                        xOffset.toDp()
                    }
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.top)
                    linkTo(parent.start, parent.end)
                }
                .height(configuration.screenHeightDp.times(0.075f).dp)
                .zIndex(100f)
                .dragAndDropTarget(
                    shouldStartDragAndDrop = { true },
                    target = object : DragAndDropTarget {
                        override fun onEntered(event: DragAndDropEvent) {
                            super.onEntered(event)
                            scrollingScope.coroutineContext.cancelChildren()
                            scrollingScope.launch {
                                while (true) {
                                    delay(SCROLL_TICK_MILLIS)
                                    lazyGridState.scrollBy(
                                        configuration.screenHeightDp.times(
                                            -SCROLL_HEIGHT_PERCENT
                                        )
                                    )
                                }
                            }
                        }

                        override fun onExited(event: DragAndDropEvent) {
                            super.onExited(event)
                            scrollingScope.coroutineContext.cancelChildren()
                        }

                        override fun onDrop(event: DragAndDropEvent): Boolean = false
                    }
                )
        )
        // scroll down box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .zIndex(-99f)
                .constrainAs(scrollDownBox) {
                    this.translationX = with(localDensity) {
                        xOffset.toDp()
                    }
                    if (localStateElement.value?.second != -1) {
                        top.linkTo(optionsRow.bottom)
                    } else {
                        bottom.linkTo(parent.bottom)
                        top.linkTo(parent.bottom)
                    }
                    linkTo(parent.start, parent.end)
                }
                .height(configuration.screenHeightDp.times(0.075f).dp)
                .dragAndDropTarget(
                    shouldStartDragAndDrop = { true },
                    target = object : DragAndDropTarget {
                        override fun onEntered(event: DragAndDropEvent) {
                            super.onEntered(event)
                            scrollingScope.coroutineContext.cancelChildren()
                            scrollingScope.launch {
                                while (true) {
                                    delay(SCROLL_TICK_MILLIS)
                                    lazyGridState.scrollBy(
                                        configuration.screenHeightDp.times(
                                            SCROLL_HEIGHT_PERCENT
                                        )
                                    )
                                }
                            }
                        }

                        override fun onExited(event: DragAndDropEvent) {
                            super.onExited(event)
                            scrollingScope.coroutineContext.cancelChildren()
                        }

                        override fun onDrop(event: DragAndDropEvent): Boolean = false
                    }
                )
        )

        Crossfade(
            modifier = Modifier
                .fillMaxWidth()
                .zIndex(1f)
                .constrainAs(addContentRow) {
                    bottom.linkTo(parent.bottom)
                    linkTo(parent.start, parent.end)
                },
            targetState = unitActionType.value,
            label = "",
        ) { actionType ->
            when(actionType) {
                DEFAULT -> {
                    Box(
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        ClickableSourceButton(
                            onClick = {
                                unitActionType.value = ADD_CONTENT
                            },
                            imageVector = Icons.Outlined.Add,
                            contentDescription = stringResource(R.string.accessibility_add_content)
                        )
                    }
                }
                ADD_CONTENT -> {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        if(!viewModel.clipBoard.facts.isEmpty.value
                            || !viewModel.clipBoard.paragraphs.isEmpty.value
                        ) {
                            ClickableSourceButton(
                                onClick = {
                                    unitActionType.value = ELEMENT_ARCHIVE
                                },
                                imageVector = Icons.Outlined.Archive,
                                contentDescription = stringResource(R.string.accessibility_clipboard)
                            )
                        }
                        DragAndDropSourceButton(
                            modifier = Modifier.weight(1f),
                            elementType = ElementType.PARAGRAPH,
                            imageVector = Icons.Outlined.Category,
                            contentDescription = stringResource(R.string.accessibility_add_paragraph),
                            text = stringResource(R.string.accessibility_add_paragraph),
                            viewModel = viewModel,
                            bridge = bridge
                        )
                        DragAndDropSourceButton(
                            modifier = Modifier.weight(1f),
                            elementType = ElementType.FACT,
                            imageVector = Icons.AutoMirrored.Outlined.ShortText,
                            contentDescription = stringResource(R.string.accessibility_add_fact),
                            text = stringResource(R.string.accessibility_add_fact),
                            viewModel = viewModel,
                            bridge = bridge
                        )
                        ClickableSourceButton(
                            onClick = {
                                unitActionType.value = DEFAULT
                            },
                            imageVector = Icons.Outlined.Close,
                            contentDescription = stringResource(R.string.accessibility_clipboard)
                        )
                    }
                }
                ELEMENT_ARCHIVE -> {
                    //TODO bottomsheet
                    val showClearClipboardDialog = remember { mutableStateOf(false) }

                    if(showClearClipboardDialog.value) {
                        BasicAlertDialog(
                            title = stringResource(id = R.string.dialog_clear_clipboard_title),
                            content = stringResource(R.string.dialog_clear_clipboard_content),
                            icon = Icons.Outlined.Delete,
                            confirmButtonState = ButtonState(
                                text = stringResource(id = R.string.button_confirm)
                            ) {
                                scope.launch {
                                    viewModel.clipBoard.clearClipBoard()
                                    unitActionType.value = DEFAULT
                                }
                            },
                            dismissButtonState = ButtonState(
                                text = stringResource(id = R.string.button_dismiss)
                            ),
                            onDismissRequest = { showDeleteDialog.value = null }
                        )
                    }

                    Column(
                        modifier = Modifier
                            .offset(y = WindowInsets.systemBars.getBottom(LocalDensity.current).dp)
                            .background(LocalTheme.current.colors.onBackgroundComponent)
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                modifier = Modifier.weight(1f),
                                text = stringResource(R.string.accessibility_clipboard),
                                style = LocalTheme.current.styles.subheading
                            )
                            MinimalisticIcon(
                                imageVector = Icons.Outlined.Delete,
                                tint = LocalTheme.current.colors.secondary,
                                onClick = {
                                    showClearClipboardDialog.value = true
                                }
                            )
                            MinimalisticIcon(
                                imageVector = Icons.Outlined.Close,
                                tint = LocalTheme.current.colors.secondary,
                                onClick = {
                                    unitActionType.value = DEFAULT
                                }
                            )
                        }
                    }
                }
                else -> {}
            }
        }

        Row(
            modifier = Modifier
                .height(62.dp)
                .zIndex(100f)
                .fillMaxWidth()
                .constrainAs(optionsRow) {
                    this.translationX = with(localDensity) {
                        xOffsetOptions.toDp()
                    }

                    bottom.linkTo(parent.bottom)
                    linkTo(parent.start, parent.end)
                },
        ) {
            DragAndDropTargetBox(
                colorActive = SharedColors.YELLOW,
                colorInactive = SharedColors.YELLOW_50,
                imageVector = Icons.Outlined.Archive,
                contentDescription = stringResource(R.string.button_archive),
                onDrop = {
                    viewModel.localStateElement.value?.first?.let { element ->
                        scope.launch {
                            when(element) {
                                is UnitElement.Paragraph -> {
                                    viewModel.clipBoard.paragraphs.copyItem(element.data)
                                }
                                is UnitElement.Fact -> {
                                    viewModel.clipBoard.facts.copyItem(element.data)
                                }
                            }
                            viewModel.requestElementRemoval(element.uid, delete = true)
                            unitActionType.value = ELEMENT_ARCHIVE
                        }
                    }
                }
            )
            DragAndDropTargetBox(
                colorActive = SharedColors.GREEN_CORRECT,
                colorInactive = SharedColors.GREEN_CORRECT_50,
                imageVector = Icons.Outlined.ContentCopy,
                contentDescription = stringResource(R.string.button_copy),
                onDrop = {
                    viewModel.localStateElement.value?.first?.let { element ->
                        scope.launch {
                            when(element) {
                                is UnitElement.Paragraph -> {
                                    viewModel.clipBoard.paragraphs.copyItem(element.data)
                                }
                                is UnitElement.Fact -> {
                                    viewModel.clipBoard.facts.copyItem(element.data)
                                }
                            }
                            unitActionType.value = ELEMENT_ARCHIVE
                            viewModel.cancelDragAndDrop()
                        }
                    }
                }
            )
            DragAndDropTargetBox(
                colorActive = SharedColors.RED_ERROR,
                colorInactive = SharedColors.RED_ERROR_50,
                imageVector = Icons.Outlined.Delete,
                contentDescription = stringResource(R.string.accessibility_delete),
                onDrop = {
                    viewModel.localStateElement.value?.first?.uid?.let { uid ->
                        showDeleteDialog.value = uid
                    }
                }
            )
        }
    }
}

/** by what fraction of screen height should automatic scroll move by */
private const val SCROLL_HEIGHT_PERCENT = .015f

/** tick in millisecond for automatic scroll */
private const val SCROLL_TICK_MILLIS = 10L