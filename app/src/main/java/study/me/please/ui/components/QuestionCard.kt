package study.me.please.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.ext.brandShimmerEffect
import study.me.please.data.io.QuestionIO

/** Card with the option of editing data inside */
@Composable
fun QuestionCard(
    modifier: Modifier = Modifier,
    state: InteractiveCardState = rememberInteractiveCardState(),
    data: QuestionIO?,
    onClick: () -> Unit = {}
) {
    if(data != null) {
        ContentLayout(
            modifier = modifier,
            data = data,
            state = state,
            onClick = {
                if(state.mode.value == InteractiveCardMode.CHECKING) {
                    state.isChecked.value = state.isChecked.value.not()
                }else onClick()
            }
        )
    }else {
        ShimmerLayout(modifier = modifier)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ContentLayout(
    modifier: Modifier,
    data: QuestionIO,
    state: InteractiveCardState,
    onClick: () -> Unit
) {
    val localDensity = LocalDensity.current
    var cardHeight by remember { mutableStateOf(0.dp) }

    Card(
        modifier = modifier
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
        DataCard(
            modifier = Modifier.onGloballyPositioned { coordinates ->
                cardHeight = with(localDensity) { coordinates.size.height.toDp() }
            },
            state = state,
            data = data
        )
    }
}

@Composable
private fun DataCard(
    modifier: Modifier = Modifier,
    data: QuestionIO,
    state: InteractiveCardState
) {
    Column(
        modifier = modifier.padding(vertical = 8.dp, horizontal = 12.dp)
    ) {
        Row {
            AnimatedVisibility(state.mode.value == InteractiveCardMode.CHECKING) {
                Checkbox(
                    modifier = Modifier.offset(x = -(12).dp, y = (-8).dp),
                    checked = state.isChecked.value,
                    onCheckedChange = { isChecked ->
                        state.isChecked.value = isChecked
                    },
                    colors = LocalTheme.current.styles.checkBoxColorsDefault
                )
            }
            Text(
                text = data.prompt,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = LocalTheme.current.colors.secondary,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
        Text(
            text = data.textExplanation,
            fontSize = 14.sp,
            color = LocalTheme.current.colors.secondary,
            maxLines = 5,
            overflow = TextOverflow.Ellipsis
        )
        EditableImageAsset(
            modifier = Modifier
                .wrapContentHeight()
                .padding(top = 6.dp),
            asset = data.imagePromptUrl
        )
    }
}

@Composable
private fun ShimmerLayout(modifier: Modifier) {
    Box(
        modifier = modifier
            .brandShimmerEffect()
            .height(165.dp)
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    QuestionCard(
        modifier = Modifier.fillMaxWidth(),
        data = QuestionIO(
            prompt = "This is my question prompt",
            textExplanation = "This question is veeeeeeery easy, so If you failed, you're a loser lol"
        ),
        onClick = {}
    )
}