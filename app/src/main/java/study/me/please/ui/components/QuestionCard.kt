package study.me.please.ui.components

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.squadris.squadris.compose.components.chips.DEFAULT_ANIMATION_LENGTH_SHORT
import com.squadris.squadris.compose.theme.LocalTheme
import study.me.please.data.io.QuestionIO

/** Card with the option of editing data inside */
@Composable
fun QuestionCard(
    modifier: Modifier = Modifier,
    state: InteractiveCardState = rememberInteractiveCardState(),
    data: QuestionIO?,
    onNavigateToSession: (questionIO: QuestionIO) -> Unit = {},
    onClick: () -> Unit
) {
    if(data != null) {
        ContentLayout(
            modifier = modifier,
            data = data,
            state = state,
            onNavigateToSession = onNavigateToSession,
            onClick = {
                if(state.mode.value == InteractiveCardMode.CHECKING) {
                    state.isChecked.value = state.isChecked.value.not()
                }else onClick()
            }
        )
    }else {
        ShimmerLayout()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ContentLayout(
    modifier: Modifier,
    data: QuestionIO,
    state: InteractiveCardState,
    onNavigateToSession: (questionIO: QuestionIO) -> Unit,
    onClick: () -> Unit
) {
    val localDensity = LocalDensity.current
    var cardHeight by remember { mutableStateOf(0.dp) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(LocalTheme.current.shapes.componentShape)
            .combinedClickable(
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = rememberRipple(
                    bounded = true
                ),
                onClick = onClick,
                onLongClick = {
                    state.isChecked.value = true
                }
            ),
        elevation = LocalTheme.current.styles.cardClickableElevation,
        shape = LocalTheme.current.shapes.componentShape,
        colors = CardDefaults.cardColors(
            containerColor = LocalTheme.current.colors.onBackgroundComponent,
            contentColor = LocalTheme.current.colors.onBackgroundComponent
        )
    ) {
        Crossfade(
            targetState = state.mode.value == InteractiveCardMode.OPTIONS,
            label = "",
            animationSpec = tween(durationMillis = DEFAULT_ANIMATION_LENGTH_SHORT)
        ) { isOptions ->
            if (isOptions) {
                OptionsModeLayout(
                    modifier = Modifier.height(cardHeight),
                    onEditOptionPressed = {
                        state.mode.value = InteractiveCardMode.EDIT
                    },
                    onPlayOptionPressed = {
                        onNavigateToSession(data)
                    },
                    onCancelClick = {
                        state.mode.value = InteractiveCardMode.DATA_DISPLAY
                    }
                )
            } else {
                DataCard(
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        cardHeight = with(localDensity) { coordinates.size.height.toDp() }
                    },
                    state = state,
                    data = data
                )
            }
        }
    }
}

@Composable
private fun DataCard(
    modifier: Modifier = Modifier,
    data: QuestionIO,
    state: InteractiveCardState
) {
    ConstraintLayout(
        modifier = modifier
            .padding(vertical = 8.dp, horizontal = 12.dp)
            .fillMaxWidth()
    ) {
        val (
            checkBox,
            txtAnswer,
            txtExplanation,
            imgExplanation
        ) = createRefs()

        if(state.mode.value == InteractiveCardMode.CHECKING) {
            Checkbox(
                modifier = Modifier.constrainAs(checkBox) {
                    start.linkTo(parent.start, (-8).dp)
                    top.linkTo(parent.top, (-12).dp)
                },
                checked = state.isChecked.value,
                onCheckedChange = { isChecked ->
                    state.isChecked.value = isChecked
                },
                colors = LocalTheme.current.styles.checkBoxColorsDefault
            )
        }
        val answerModifier = Modifier
            .constrainAs(txtAnswer) {
                start.linkTo(
                    if(state.mode.value == InteractiveCardMode.CHECKING) {
                        checkBox.end
                    }else parent.start
                )
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                width = Dimension.fillToConstraints
            }
        val explanationModifier = Modifier
            .constrainAs(txtExplanation) {
                start.linkTo(txtAnswer.start)
                end.linkTo(parent.end)
                top.linkTo(txtAnswer.bottom, 4.dp)
                width = Dimension.fillToConstraints
            }

        Text(
            modifier = answerModifier,
            text = data.prompt,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = LocalTheme.current.colors.secondary,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            modifier = explanationModifier,
            text = data.textExplanation,
            fontSize = 14.sp,
            color = LocalTheme.current.colors.secondary,
            maxLines = 5,
            overflow = TextOverflow.Ellipsis
        )
        EditableImageAsset(
            modifier = Modifier
                .wrapContentHeight()
                .constrainAs(imgExplanation) {
                    linkTo(parent.start, parent.end)
                    top.linkTo(txtExplanation.bottom, 6.dp)
                    width = Dimension.fillToConstraints
                },
            asset = data.imagePromptUrl
        )
    }
}

@Composable
private fun ShimmerLayout() {

}

@Preview
@Composable
private fun Preview() {
    QuestionCard(
        data = QuestionIO(
            prompt = "This is my question prompt",
            textExplanation = "This question is veeeeeeery easy, so If you failed, you're a loser lol"
        ),
        onNavigateToSession = {},
        onClick = {}
    )
}