package study.me.please.ui.units.components

import androidx.compose.animation.Animatable
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.draganddrop.dragAndDropTarget
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draganddrop.DragAndDropEvent
import androidx.compose.ui.draganddrop.DragAndDropTarget
import androidx.compose.ui.draganddrop.mimeTypes
import androidx.compose.ui.draganddrop.toAndroidDragEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import study.me.please.ui.units.utils.ElementType

/**
 * Box into which any draggable object can be dropped into
 * It indicated when item is hovered over it and clears the indication after it isn't
 */
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
                target = remember(imageVector) {
                    object : DragAndDropTarget {
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