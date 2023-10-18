package study.me.please.ui.components.tab_switch

import android.annotation.SuppressLint
import androidx.compose.animation.Animatable
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.squadris.squadris.compose.theme.Colors
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.compose.theme.StudyMeAppTheme

const val DEFAULT_ANIMATION_LENGTH_SHORT = 300
const val DEFAULT_ANIMATION_LENGTH_LONG = 600

@Composable
fun MultiChoiceSwitch(
    modifier: Modifier = Modifier,
    state: TabSwitchState = rememberTabSwitchState(scrollState = rememberScrollState()),
    onItemCreation: (@Composable (Modifier, index: Int, animatedColor: Color) -> Unit)? = null
) {
    val indicatorWidth = remember { mutableStateOf((-1).dp) }
    val localDensity = LocalDensity.current
    val offsetX = remember { Animatable(0f) }
    LaunchedEffect(state.selectedTabIndex.value) {
        offsetX.animateTo(
            targetValue = indicatorWidth.value.times(state.selectedTabIndex.value).value,
            animationSpec = tween(if(offsetX.value == -1f) 0 else DEFAULT_ANIMATION_LENGTH_SHORT)
        )
    }
    LaunchedEffect(key1 = state.selectedTabIndex.value) {
        state.onSelectionChange(state.selectedTabIndex.value)
    }

    val shape = CircleShape

    val unselectedTextColor = LocalTheme.colors.brandMain
    val selectedTextColor = LocalTheme.colors.tetrial
    ConstraintLayout(
        modifier = modifier
            .background(
                color = LocalTheme.colors.tetrial,
                shape = shape
            )
    ) {
        val (tabs, indicator) = createRefs()
        Box(
            modifier = Modifier
                .shadow(
                    elevation = LocalTheme.styles.componentElevation,
                    shape = shape
                )
                .background(
                    color = LocalTheme.colors.brandMain,
                    shape = shape
                )
                .animateContentSize()
                .width(indicatorWidth.value)
                .animateContentSize()
                .constrainAs(indicator) {
                    linkTo(tabs.top, tabs.bottom)
                    start.linkTo(parent.start, offsetX.value.dp)
                    height = Dimension.fillToConstraints
                }
        )
        Row(
            modifier = Modifier
                .wrapContentHeight(unbounded = false)
                .constrainAs(tabs) {
                    linkTo(parent.start, parent.end)
                    linkTo(parent.top, parent.bottom)
                },
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            state.tabs.forEachIndexed { index, tab ->
                val textColor = remember(index) { Animatable(Colors.PRIMARY) }
                LaunchedEffect(state.selectedTabIndex.value) {
                    if(state.selectedTabIndex.value == index) {
                        textColor.animateTo(
                            targetValue = selectedTextColor,
                            animationSpec = tween(DEFAULT_ANIMATION_LENGTH_LONG)
                        )
                    }else textColor.animateTo(
                        unselectedTextColor,
                        animationSpec = tween(DEFAULT_ANIMATION_LENGTH_LONG)
                    )
                }

                (onItemCreation ?: { modifier, _, color ->
                    Text(
                        modifier = modifier
                            .padding(LocalTheme.shapes.betweenItemsSpace)
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) {
                                state.selectedTabIndex.value = index
                            },
                        text = tab,
                        color = color,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        textAlign = TextAlign.Center
                    )
                }).invoke(
                    Modifier
                        .onGloballyPositioned { coordinates ->
                            if (state.selectedTabIndex.value == index) {
                                indicatorWidth.value = with(localDensity) {
                                    coordinates.size.width.toDp()
                                }
                            }
                        }
                        .weight(1f),
                    index,
                    textColor.value
                )
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
private fun Preview() {
    StudyMeAppTheme(isDarkTheme = true) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = LocalTheme.colors.backgroundLight)
        ) {
            MultiChoiceSwitch(
                modifier = Modifier,
                state = rememberTabSwitchState(
                    tabs = mutableListOf("tab one", "tab two"),
                    selectedTabIndex = mutableIntStateOf(1)
                ),
                onItemCreation = { _, _, _ ->

                }
            )
        }
    }
}