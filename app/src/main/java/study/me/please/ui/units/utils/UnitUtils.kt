package study.me.please.ui.units.utils

import android.annotation.SuppressLint
import android.content.ClipData
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.draganddrop.dragAndDropSource
import androidx.compose.foundation.draganddrop.dragAndDropTarget
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draganddrop.DragAndDropEvent
import androidx.compose.ui.draganddrop.DragAndDropTarget
import androidx.compose.ui.draganddrop.DragAndDropTransferData
import androidx.compose.ui.draganddrop.mimeTypes
import androidx.compose.ui.draganddrop.toAndroidDragEvent
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.squadris.squadris.compose.theme.LocalTheme
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * composable target for drag and drop with display whenever supported item is dragged over
 * @param modifier - modifier for the container
 * @param enterModifier - modifier for the container when item is dragged over
 * @param padding - padding for the container
 * @param isEnabled - whether the container is enabled for drag and drop
 * @param dragAndDropTarget - state for the target
 * @param type - type of the element
 * @param collapsedParagraphs - list of collapsed paragraphs
 * @param onDropped - action to perform when item is dropped
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DropTargetContainer(
    modifier: Modifier = Modifier,
    enterModifier: Modifier = Modifier,
    padding: Dp = 0.dp,
    isEnabled: Boolean = true,
    isBelow: Boolean = true,
    dragAndDropTarget: MutableState<String>,
    type: ElementType,
    collapsedParagraphs: List<String>,
    onDropped: () -> Unit,
    onCanceled: () -> Unit,
    identifier: String,
    onStarted: (isStarted: Boolean) -> Unit = {},
    content: @Composable ColumnScope.() -> Unit = {}
) {
    val cancelableScope = rememberCoroutineScope()
    if(type == ElementType.PARAGRAPH && collapsedParagraphs.contains(identifier)) {
        LaunchedEffect(dragAndDropTarget.value == identifier) {
            cancelableScope.coroutineContext.cancelChildren()

            // if paragraph is collapsed and we hold above it for 1 second,
            // the paragraph should expand
            if(dragAndDropTarget.value == identifier) {
                cancelableScope.launch {
                    delay(1000)
                    if(collapsedParagraphs.contains(identifier)) {
                        //TODO collapsedParagraphs.remove(identifier)
                    }
                }
            }
        }
    }

    val dragDropModifier = if(isEnabled) {
        modifier.dragAndDropTarget(
            shouldStartDragAndDrop = { startEvent ->
                startEvent
                    .mimeTypes()
                    .contains(type.name)
            },
            target = object : DragAndDropTarget {
                override fun onDrop(event: DragAndDropEvent): Boolean {
                    val isValid = event.mimeTypes().contains(type.name)
                    if(isValid) {
                        onDropped()
                        dragAndDropTarget.value = ""
                    }
                    return isValid
                }

                override fun onEnded(event: DragAndDropEvent) {
                    super.onEnded(event)
                    onStarted(false)

                    if(event.toAndroidDragEvent().result.not()) {
                        onCanceled()
                    }
                }
                override fun onEntered(event: DragAndDropEvent) {
                    super.onEntered(event)
                    dragAndDropTarget.value = identifier
                }
                override fun onStarted(event: DragAndDropEvent) {
                    super.onStarted(event)
                    onStarted(true)
                }
                override fun onExited(event: DragAndDropEvent) {
                    super.onExited(event)
                    if(dragAndDropTarget.value == identifier) {
                        dragAndDropTarget.value = ""
                    }
                }
            }
        )
    }else modifier

    Column(modifier = dragDropModifier.fillMaxWidth()) {
        if(isBelow) content()
        AnimatedVisibility(visible = dragAndDropTarget.value == identifier) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = padding)
                    .height(64.dp)
                    .background(
                        color = LocalTheme.current.colors.brandMain,
                    )
                    .then(enterModifier)
            )
        }
        if(isBelow.not()) content()
    }
}

/**
 * composable target for drag and drop
 * @param isEnabled - whether the container is enabled for drag and drop
 * @param dragAndDropTarget - state for the target
 * @param type - type of the element
 * @param onDropped - action to perform when item is dropped
 */
@OptIn(ExperimentalFoundationApi::class)
fun Modifier.dragTarget(
    isEnabled: Boolean = true,
    dragAndDropTarget: MutableState<String>,
    type: ElementType,
    onDropped: () -> Unit,
    onCanceled: () -> Unit,
    identifier: String,
    onStarted: (isStarted: Boolean) -> Unit = {}
): Modifier {
    return if(isEnabled) {
        this.dragAndDropTarget(
            shouldStartDragAndDrop = { startEvent ->
                startEvent
                    .mimeTypes()
                    .contains(type.name)
            },
            target = object : DragAndDropTarget {
                override fun onDrop(event: DragAndDropEvent): Boolean {
                    val isValid = event.mimeTypes().contains(type.name)
                    if(isValid) {
                        onDropped()
                        dragAndDropTarget.value = ""
                    }
                    return isValid
                }

                override fun onEnded(event: DragAndDropEvent) {
                    super.onEnded(event)
                    onStarted(false)

                    if(event.toAndroidDragEvent().result.not()) {
                        onCanceled()
                    }
                }
                override fun onEntered(event: DragAndDropEvent) {
                    super.onEntered(event)
                    dragAndDropTarget.value = identifier
                }
                override fun onStarted(event: DragAndDropEvent) {
                    super.onStarted(event)
                    onStarted(true)
                }
                override fun onExited(event: DragAndDropEvent) {
                    super.onExited(event)
                    if(dragAndDropTarget.value == identifier) {
                        dragAndDropTarget.value = ""
                    }
                }
            }
        )
    }else this
}

/** Source for dragging element to some action/place */
@OptIn(ExperimentalFoundationApi::class)
fun Modifier.dragSource(
    onClick: () -> Unit,
    onStarted: () -> Unit,
    elementType: ElementType,
    uid: String
) = composed(
    factory = {
        val density = LocalDensity.current
        val rectColor = LocalTheme.current.colors.onBackgroundComponent
        val cornerRadius = with(density) {
            LocalTheme.current.shapes.componentCornerRadius.toPx()
        }

        this.dragAndDropSource(
            drawDragDecoration = {
                drawRoundRect(
                    color = rectColor,
                    cornerRadius = CornerRadius(cornerRadius, cornerRadius)
                )
            }
        ) {
            detectTapGestures(
                onLongPress = {
                    startTransfer(
                        DragAndDropTransferData(
                            ClipData(
                                "",
                                arrayOf(elementType.name, ElementType.PARAGRAPH.name),
                                ClipData.Item(uid)
                            )
                        )
                    )
                    onStarted()
                },
                onTap = { onClick() }
            )
        }
    }
)

enum class BorderOrder {
    Start, Center, None
}

/** maximum nested paragraph depth */
const val maxParagraphLayer = 9

@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.drawSegmentedBorder(
    borderOrder: BorderOrder,
    notLastLayers: List<Int> = listOf(),
    parentLayer: Int,
    screenWidthDp: Int
) = composed(
    factory = {
        val color = LocalTheme.current.colors.secondary
        val density = LocalDensity.current
        val strokeWidthPx = density.run { 1.dp.toPx() }
        val xOffset = density.run {
            screenWidthDp.dp.toPx()
                .times(
                    (if(borderOrder == BorderOrder.Center) 0 else 2)
                        .coerceAtMost(maxParagraphLayer)
                )
                .div(30)
        }

        Modifier.drawBehind {
            val height = size.height

            notLastLayers.forEach { layer ->
                val offset = strokeWidthPx - (screenWidthDp.dp * (1)
                    .coerceAtMost(maxParagraphLayer) / 30).toPx()
                    .times(parentLayer.coerceAtMost(maxParagraphLayer - 1).minus(layer - 1))

                drawLine(
                    color = color,
                    start = Offset(x = offset, y = 0f),
                    end = Offset(x = offset, y = height),
                    strokeWidth = strokeWidthPx
                )
            }

            when {
                borderOrder == BorderOrder.None -> { }
                borderOrder == BorderOrder.Start && parentLayer < maxParagraphLayer -> {
                    val offset = -xOffset.div(2).plus(-strokeWidthPx)
                    drawLine(
                        color = color,
                        start = Offset(x = offset, y = 0f),
                        end = Offset(
                            x = offset,
                            y = 2.5f
                        ),
                        strokeWidth = strokeWidthPx
                    )
                    // Bottom left arc
                    drawArc(
                        color = color,
                        startAngle = 90f,
                        sweepAngle = 90f,
                        useCenter = false,
                        topLeft = Offset(x = offset, y = offset),
                        size = Size(xOffset, xOffset),
                        style = Stroke(width = strokeWidthPx)
                    )
                }
                borderOrder == BorderOrder.Center || parentLayer >= maxParagraphLayer -> {
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

/** type of the element in the paragraph */
enum class ElementType {
    FACT,
    FACT_MOTHER,
    EMPTY_SPACE,
    PARAGRAPH
}