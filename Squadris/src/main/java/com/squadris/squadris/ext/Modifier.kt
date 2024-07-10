package com.squadris.squadris.ext

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.draganddrop.DragAndDropSourceScope
import androidx.compose.foundation.draganddrop.dragAndDropSource
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.squadris.squadris.compose.theme.LocalTheme

/** Pseudo shimmer effect, animating a brush around an element */
@Composable
fun Modifier.shimmerEffect(
    stripeColor: Color,
    startEndColor: Color,
    shape: Shape = RoundedCornerShape(8.dp)
): Modifier = composed {
    var size by remember { mutableStateOf(IntSize.Zero) }
    val startOffsetX by rememberInfiniteTransition(label = "").animateFloat(
        initialValue = (-2 * size.width).toFloat(),
        targetValue = (2 * size.width).toFloat(),
        animationSpec = infiniteRepeatable(animation = tween(800)),
        label = ""
    )

    background(
        brush = Brush.linearGradient(
            colors = listOf(
                startEndColor,
                stripeColor,
                startEndColor
            ),
            start = Offset(startOffsetX, 0f),
            end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat())
        ),
        shape = shape
    ).onGloballyPositioned {
        size = it.size
    }
}

/** shimmer loading effect via background color based on Brand colors */
@Composable
fun Modifier.brandShimmerEffect(
    shape: Shape = RoundedCornerShape(8.dp)
): Modifier = composed {
    shimmerEffect(
        stripeColor = LocalTheme.current.colors.overShimmer,
        startEndColor = LocalTheme.current.colors.shimmer,
        shape = shape
    )
}

/**
 * Clickable modifier, which enables clickable to be scaled based on the presses
 */
@Composable
fun Modifier.scalingClickable(
    onTap: ((Offset) -> Unit)? = null,
    onDoubleTap: ((Offset) -> Unit)? = null,
    onLongPress: ((Offset) -> Unit)? = null,
    scaleInto: Float = 0.9f
): Modifier = composed {
    val isPressed = remember { mutableStateOf(false) }
    val scale = animateFloatAsState(
        if (isPressed.value) scaleInto else 1f,
        label = "scalingClickableAnimation"
    )

    scale(scale.value)
        .pointerInput(Unit) {
            detectTapGestures(
                onPress = {
                    isPressed.value = true
                    tryAwaitRelease()
                    isPressed.value = false
                },
                onTap = onTap,
                onDoubleTap = onDoubleTap,
                onLongPress = onLongPress
            )
        }
}

/**
 * Clickable modifier, which enables draggable to be scaled based on the presses
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Modifier.scalingDragSource(
    onTap: (DragAndDropSourceScope.(Offset) -> Unit)? = null,
    onDoubleTap: (DragAndDropSourceScope.(Offset) -> Unit)? = null,
    onLongPress: (DragAndDropSourceScope.(Offset) -> Unit)? = null,
    scaleInto: Float = 0.9f
): Modifier = composed {
    val isPressed = remember { mutableStateOf(false) }
    val scale = animateFloatAsState(
        if (isPressed.value) scaleInto else 1f,
        label = "scalingClickableAnimation"
    )

    scale(scale.value)
        .dragAndDropSource {
            detectTapGestures(
                onPress = {
                    isPressed.value = true
                    tryAwaitRelease()
                    isPressed.value = false
                },
                onTap = {
                    onTap?.invoke(this, it)
                },
                onDoubleTap = {
                    onDoubleTap?.invoke(this, it)
                },
                onLongPress = {
                    onLongPress?.invoke(this, it)
                }
            )
        }
}

/**
 * [Modifier] that takes up all the available width inside the [TabRow], and then animates
 * the offset of the indicator it is applied to, depending on the [currentTabPosition].
 *
 * @param currentTabPosition [TabPosition] of the currently selected tab. This is used to
 * calculate the offset of the indicator this modifier is applied to, as well as its width.
 */
fun Modifier.customTabIndicatorOffset(
    currentTabPosition: TabPosition,
    horizontalPadding: Dp = 4.dp
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "tabIndicatorOffset"
        value = currentTabPosition
    }
) {
    val currentTabWidth by animateDpAsState(
        targetValue = currentTabPosition.width,
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing),
        label = "tabWidthAnimation"
    )
    val indicatorOffset by animateDpAsState(
        targetValue = currentTabPosition.left,
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing),
        label = "tabOffsetAnimation"
    )
    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset.plus(horizontalPadding))
        .width(currentTabWidth.minus(horizontalPadding.times(2)))
}