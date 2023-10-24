package study.me.please.ui.components.session

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.ext.brandShimmerEffect
import study.me.please.R
import study.me.please.data.io.QuestionMode
import study.me.please.data.io.SessionIO
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
                    .fillMaxWidth()
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
    state: InteractiveCardState
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .animateContentSize()
            .padding(vertical = 8.dp, horizontal = 12.dp)
    ) {
        val (checkBox, imgMode, txtName, txtQuestionCount) = createRefs()
        AnimatedVisibility(
            modifier = Modifier.constrainAs(checkBox) {
                start.linkTo(parent.start, (-8).dp)
                top.linkTo(parent.top, (-12).dp)
            },
            visible = state.mode.value == InteractiveCardMode.CHECKING
        ) {
            Checkbox(
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
                .padding(8.dp)
                .constrainAs(imgMode) {
                    start.linkTo(
                        if (state.mode.value == InteractiveCardMode.CHECKING) {
                            checkBox.end
                        } else parent.start
                    )
                    top.linkTo(parent.top)
                },
            imageVector = (session.estimatedMode ?: QuestionMode.LEARNING).icon,
            contentDescription = (session.estimatedMode ?: QuestionMode.LEARNING).icon.name,
            colorFilter = ColorFilter.tint(color = LocalTheme.colors.tetrial)
        )
        Text(
            modifier = Modifier
                .constrainAs(txtName) {
                    linkTo(
                        imgMode.end,
                        txtQuestionCount.start,
                        startMargin = 6.dp,
                        endMargin = 6.dp
                    )
                    top.linkTo(imgMode.top)
                    width = Dimension.fillToConstraints
                },
            text = session.name,
            color = LocalTheme.colors.primary,
            fontSize = 18.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            modifier = Modifier
                .constrainAs(txtQuestionCount) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                },
            text = stringResource(
                id = R.string.session_card_x_questions,
                session.questionCount
            ),
            color = LocalTheme.colors.secondary,
            fontSize = 16.sp
        )
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
        state = InteractiveCardState(mode = mutableStateOf(InteractiveCardMode.DATA_DISPLAY))
    ) {

    }
}