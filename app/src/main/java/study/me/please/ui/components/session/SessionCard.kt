package study.me.please.ui.components.session

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.ext.brandShimmerEffect
import study.me.please.data.io.QuestionMode
import study.me.please.data.io.session.SessionIO
import study.me.please.ui.components.InteractiveCardMode
import study.me.please.ui.components.InteractiveCardState
import study.me.please.ui.components.OptionsModeLayout

/**
 * Card displaying a session
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SessionCard(
    modifier: Modifier = Modifier,
    session: SessionIO?,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    state: InteractiveCardState,
    onEditOptionPressed: () -> Unit = {},
    onPlayOptionPressed: () -> Unit = {}
) {
    AnimatedContent(
        targetState = session == null,
        label = ""
    ) { shimmer ->
        if(shimmer) {
            ShimmerLayout(modifier = modifier)
        }else {
            val localDensity = LocalDensity.current
            var cardHeight by remember { mutableStateOf(0.dp) }

            Card(
                modifier = modifier
                    .wrapContentHeight()
                    .clip(LocalTheme.shapes.componentShape)
                    .combinedClickable(
                        interactionSource = remember {
                            MutableInteractionSource()
                        },
                        indication = rememberRipple(bounded = true),
                        onClick = {
                            if (state.mode.value == InteractiveCardMode.CHECKING) {
                                state.isChecked.value = state.isChecked.value.not()
                            } else if (state.mode.value == InteractiveCardMode.DATA_DISPLAY) {
                                state.mode.value = InteractiveCardMode.OPTIONS
                            }
                        },
                        onLongClick = {
                            state.isChecked.value = true
                        },
                        enabled = state.isEnabled.value
                    ),
                elevation = LocalTheme.styles.cardClickableElevation,
                shape = LocalTheme.shapes.componentShape,
                colors = CardDefaults.cardColors(
                    containerColor = LocalTheme.colors.onBackgroundComponent,
                    contentColor = LocalTheme.colors.onBackgroundComponent
                )
            ) {
                AnimatedContent(
                    targetState = state.mode.value == InteractiveCardMode.OPTIONS,
                    label = ""
                ) { isOptions ->
                    if(isOptions) {
                        OptionsModeLayout(
                            modifier = Modifier.height(cardHeight),
                            onEditOptionPressed = onEditOptionPressed,
                            onPlayOptionPressed = onPlayOptionPressed,
                            onCancelClick = {
                                state.mode.value = InteractiveCardMode.DATA_DISPLAY
                            }
                        )
                    }else if(session != null) {
                        ContentLayout(
                            modifier = Modifier.onGloballyPositioned { coordinates ->
                                cardHeight = with(localDensity) { coordinates.size.height.toDp() }
                            },
                            session = session,
                            verticalAlignment = verticalAlignment,
                            state = state
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ContentLayout(
    modifier: Modifier = Modifier,
    session: SessionIO,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    state: InteractiveCardState
) {
    Column(
        modifier = modifier
            .wrapContentHeight()
            .animateContentSize()
            .padding(vertical = 8.dp, horizontal = 12.dp)
    ) {
        Row(verticalAlignment = verticalAlignment) {
            AnimatedVisibility(
                visible = state.mode.value == InteractiveCardMode.CHECKING
            ) {
                Checkbox(
                    modifier = Modifier.offset(x = -(12).dp),
                    checked = state.isChecked.value,
                    enabled = state.isEnabled.value,
                    onCheckedChange = { isChecked ->
                        state.isChecked.value = isChecked
                    },
                    colors = LocalTheme.styles.checkBoxColorsDefault
                )
            }
            Image(
                modifier = Modifier
                    .size(LocalTheme.shapes.iconSizeMedium)
                    .background(
                        color = LocalTheme.colors.brandMain,
                        shape = LocalTheme.shapes.circularActionShape
                    )
                    .padding(8.dp),
                imageVector = (session.estimatedMode ?: QuestionMode.LEARNING).icon,
                contentDescription = (session.estimatedMode ?: QuestionMode.LEARNING).icon.name,
                colorFilter = ColorFilter.tint(color = LocalTheme.colors.tetrial)
            )
            Text(
                modifier = Modifier
                    .padding(start = 8.dp, end = 4.dp)
                    .fillMaxWidth(),
                text = session.name,
                color = LocalTheme.colors.primary,
                fontSize = 18.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

        }
        /*Text(
            modifier = Modifier
                .constrainAs(txtCollections) {
                    linkTo(imgMode.end, parent.end)
                    top.linkTo(txtName.bottom, 2.dp)
                    width = Dimension.fillToConstraints
                }
                .padding(horizontal = 6.dp),
            text = session.collectionUidList.joinToString(separator = ", "),
            color = LocalTheme.colors.secondary,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontSize = 14.sp
        )*/
    }
}

@Composable
private fun ShimmerLayout(
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .brandShimmerEffect(shape = LocalTheme.shapes.componentShape)
    )
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
private fun Preview() {
    SessionCard(
        session = SessionIO(
            name = "Session name",
            collectionUidList = mutableSetOf("asfdasdasdasd", "123412emsoiqjdwqaed")
        ).apply {
            questionCount = 13
        },
        state = InteractiveCardState(mode = mutableStateOf(InteractiveCardMode.CHECKING))
    ) {

    }
}