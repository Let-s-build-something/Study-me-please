package com.squadris.squadris.compose.components

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.AnimationState
import androidx.compose.animation.core.DecayAnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDecay
import androidx.compose.animation.core.animateTo
import androidx.compose.animation.core.spring
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.Velocity
import kotlin.math.abs
import kotlin.math.roundToInt

@Composable
fun CollapsingLayout(
    modifier: Modifier = Modifier,
    snapAnimationSpec: AnimationSpec<Float>? = spring(stiffness = Spring.StiffnessMediumLow),
    flingAnimationSpec: DecayAnimationSpec<Float>? = rememberSplineBasedDecay(),
    collapsingToolbar: @Composable BoxScope.() -> Unit,
    content: @Composable BoxScope.() -> Unit,
) {
    var collapsingTopHeight by remember { mutableFloatStateOf(0f) }

    var offset by remember { mutableFloatStateOf(0f) }

    fun calculateOffset(availableY: Float): Offset {
        val oldOffset = offset
        val newOffset = (oldOffset + availableY).coerceIn(-collapsingTopHeight, 0f)
        offset = newOffset
        return Offset(0f, newOffset - oldOffset)
    }

    suspend fun calculateVelocity(availableY: Float): Velocity {
        var remainingVelocity = availableY
        if (flingAnimationSpec != null && abs(availableY) > 1f) {
            var lastValue = 0f
            AnimationState(
                initialValue = 0f,
                initialVelocity = availableY,
            ).animateDecay(flingAnimationSpec) {
                val delta = value - lastValue
                val initialHeightOffset = offset
                offset = (initialHeightOffset + delta).coerceIn(-collapsingTopHeight, 0f)
                val consumed = abs(initialHeightOffset - offset)
                lastValue = value
                remainingVelocity = this.velocity
                if (abs(delta - consumed) > 0.5f) this.cancelAnimation()
            }
        }
        if(snapAnimationSpec != null) {
            if(offset < 0 &&
                offset > collapsingTopHeight
            ) {
                AnimationState(initialValue = offset).animateTo(
                    if(((collapsingTopHeight.minus(abs(offset))) / collapsingTopHeight) < 0.5f) {
                        0f
                    }else {
                        collapsingTopHeight
                    },
                    animationSpec = snapAnimationSpec
                ) { offset = value.coerceIn(-collapsingTopHeight, 0f) }
            }
        }
        return Velocity(0f, remainingVelocity)
    }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset = when {
                available.y >= 0 -> Offset.Zero
                offset == -collapsingTopHeight -> Offset.Zero
                else -> calculateOffset(available.y)
            }
            override fun onPostScroll(
                consumed: Offset,
                available: Offset,
                source: NestedScrollSource,
            ): Offset = when {
                available.y <= 0 -> Offset.Zero
                offset == 0f -> Offset.Zero
                else -> calculateOffset(available.y)
            }

            /*override suspend fun onPostFling(
                consumed: Velocity,
                available: Velocity
            ): Velocity = when (offset) {
                -collapsingTopHeight -> Velocity.Zero
                0f -> Velocity.Zero
                else -> super.onPostFling(consumed, available) + calculateVelocity(available.y)
            }*/
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .nestedScroll(nestedScrollConnection),
    ) {
        Box(
            modifier = Modifier
                .onSizeChanged { size ->
                    collapsingTopHeight = size.height.toFloat()
                }
                .offset { IntOffset(x = 0, y = offset.roundToInt()) },
            content = collapsingToolbar,
        )
        Box(
            modifier = Modifier.offset {
                IntOffset(
                    x = 0,
                    y = (collapsingTopHeight + offset).roundToInt()
                )
            },
            content = content,
        )
    }
}