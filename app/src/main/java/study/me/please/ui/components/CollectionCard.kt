package study.me.please.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Memory
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.compose.theme.Colors
import com.squadris.squadris.utils.DateUtils
import study.me.please.R
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.QuestionMode
import java.util.Calendar
import java.util.Date

/** Item displaying collection and shortened information about it */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CollectionCard(
    modifier: Modifier = Modifier,
    data: CollectionIO? = null,
    state: InteractiveCardState,
    skipOptions: Boolean = false,
    onNavigateToDetail: () -> Unit,
    onNavigateToSession: () -> Unit = {}
) {
    //TODO shimmer effect
    AnimatedContent(
        targetState = data == null,
        label = ""
    ) { shimmer ->
        if(shimmer) {
            ShimmerLayout()
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
                        indication = rememberRipple(
                            bounded = true
                        ),
                        onClick = {
                            if (state.mode.value == InteractiveCardMode.CHECKING) {
                                state.isChecked.value = state.isChecked.value.not()
                            } else if (state.mode.value == InteractiveCardMode.DATA_DISPLAY) {
                                if(skipOptions) {
                                    onNavigateToDetail()
                                }else state.mode.value = InteractiveCardMode.OPTIONS
                            }
                        },
                        onLongClick = {
                            state.isChecked.value = true
                        }
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
                            onEditOptionPressed = onNavigateToDetail,
                            onPlayOptionPressed = onNavigateToSession,
                            onCancelClick = {
                                state.mode.value = InteractiveCardMode.DATA_DISPLAY
                            }
                        )
                    }else if(data != null) {
                        DataCard(
                            modifier = Modifier.onGloballyPositioned { coordinates ->
                                cardHeight = with(localDensity) { coordinates.size.height.toDp() }
                            },
                            data = data,
                            state = state
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ShimmerLayout() {

}

@Composable
private fun DataCard(
    modifier: Modifier = Modifier,
    data: CollectionIO,
    state: InteractiveCardState
) {
    ConstraintLayout(
        modifier = modifier
            .padding(vertical = 8.dp, horizontal = 12.dp)
            .fillMaxWidth()
    ) {
        val (
            txtHeading,
            txtDescription,
            imgIcon,
            txtDateCreated,
            txtMode,
            checkBox
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
                colors = LocalTheme.styles.checkBoxColorsDefault
            )
        }
        Text(
            text = data.name,
            modifier = Modifier.constrainAs(txtHeading) {
                top.linkTo(parent.top, 4.dp)
                start.linkTo(
                    if(state.mode.value == InteractiveCardMode.CHECKING) {
                        checkBox.end
                    }else parent.start
                )
            },
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = LocalTheme.colors.primary
        )
        Image(
            modifier = Modifier
                .size(LocalTheme.shapes.iconSizeMedium)
                .background(
                    color = LocalTheme.colors.brandMain,
                    shape = LocalTheme.shapes.circularActionShape
                )
                .clip(LocalTheme.shapes.circularActionShape)
                .constrainAs(imgIcon) {
                    top.linkTo(parent.top, 4.dp)
                    end.linkTo(parent.end)
                },
            imageVector = Icons.Outlined.Memory,
            contentDescription = null,
            colorFilter = ColorFilter.tint(color = LocalTheme.colors.tetrial)
        )
        Text(
            text = data.defaultPreference.estimatedMode.toString(),
            modifier = Modifier.constrainAs(txtMode) {
                top.linkTo(txtMode.bottom, 2.dp)
                end.linkTo(parent.end)
            },
            fontSize = 10.sp,
            color = LocalTheme.colors.secondary
        )
        Text(
            text = data.description,
            modifier = Modifier
                .constrainAs(txtDescription) {
                    top.linkTo(txtHeading.bottom, 4.dp)
                    start.linkTo(txtHeading.start)
                    end.linkTo(imgIcon.start, 6.dp)
                    width = Dimension.fillToConstraints
                },
            fontSize = 12.sp,
            color = LocalTheme.colors.secondary,
            minLines = 2,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = DateUtils.formatDateAs(
                date = data.dateCreated,
                pattern = "d. MMM yyyy"
            ),
            modifier = Modifier.constrainAs(txtDateCreated) {
                top.linkTo(imgIcon.bottom, 4.dp)
                end.linkTo(parent.end)
            },
            fontSize = 12.sp,
            color = LocalTheme.colors.secondary
        )
    }
}

@Composable
fun OptionsModeLayout(
    modifier: Modifier = Modifier,
    onEditOptionPressed: () -> Unit,
    onPlayOptionPressed: () -> Unit,
    onCancelClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .background(color = LocalTheme.colors.onBackgroundComponent)
            .fillMaxWidth()
            .then(modifier),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val itemModifier = Modifier
            .weight(1f)
            .fillMaxSize()

        Icon(
            modifier = itemModifier
                .padding(
                    start = 12.dp,
                    top = 12.dp,
                    bottom = 12.dp
                )
                .background(
                    color = Colors.RED_ERROR.copy(alpha = 0.4f),
                    shape = RoundedCornerShape(
                        topStart = LocalTheme.shapes.componentCornerRadius,
                        bottomStart = LocalTheme.shapes.componentCornerRadius
                    )
                )
                .clickable(
                    indication = rememberRipple(bounded = true),
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    onCancelClick()
                }
                .padding(16.dp),
            imageVector = Icons.Outlined.Close,
            contentDescription = stringResource(id = R.string.close_content_description),
            tint = Colors.DARK_BLUE_70
        )
        Icon(
            modifier = itemModifier
                .padding(vertical = 12.dp, horizontal = 6.dp)
                .background(
                    color = LocalTheme.colors.tetrial.copy(alpha = 0.4f)
                )
                .clickable(
                    indication = rememberRipple(bounded = true),
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    onEditOptionPressed()
                }
                .padding(16.dp),
            imageVector = Icons.Outlined.Edit,
            contentDescription = stringResource(id = R.string.edit_content_description),
            tint = Colors.DARK_BLUE_70
        )
        Icon(
            modifier = itemModifier
                .padding(end = 12.dp, top = 12.dp, bottom = 12.dp)
                .background(
                    color = Colors.GREEN_CORRECT.copy(alpha = 0.4f),
                    shape = RoundedCornerShape(
                        topEnd = LocalTheme.shapes.componentCornerRadius,
                        bottomEnd = LocalTheme.shapes.componentCornerRadius
                    )
                )
                .clickable(
                    indication = rememberRipple(bounded = true),
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    onPlayOptionPressed()
                }
                .padding(16.dp),
            imageVector = Icons.Outlined.PlayArrow,
            contentDescription = stringResource(id = R.string.play_content_description),
            tint = Colors.DARK_BLUE_70
        )
        //TODO buttons icons and transparent color background which looses the
        //TODO transparency after pressing
    }
}

@Preview(widthDp = 360)
@Composable
private fun Preview() {
    CollectionCard(
        data = CollectionIO(),
        onNavigateToSession = {},
        onNavigateToDetail = {},
        state = rememberInteractiveCardState()
    )
}