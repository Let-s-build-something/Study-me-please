package study.me.please.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
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
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.compose.theme.SharedColors
import com.squadris.squadris.ext.brandShimmerEffect
import study.me.please.R
import study.me.please.base.theme.AppTheme
import study.me.please.base.theme.Colors
import study.me.please.data.io.CollectionIO

/** Item displaying collection and shortened information about it */
@Composable
fun CollectionCard(
    modifier: Modifier = Modifier,
    data: CollectionIO? = null,
    isChecked: Boolean? = null,
    isSelected: Boolean = false,
    onCheckedChange: (Boolean) -> Unit = {},
    onNavigateToDetail: () -> Unit = {},
    onNavigateToSession: () -> Unit = {}
) {
    AnimatedContent(
        targetState = data == null,
        label = ""
    ) { shimmer ->
        if(shimmer) {
            ShimmerLayout(modifier)
        }else {
            val localDensity = LocalDensity.current
            var cardHeight by remember { mutableStateOf(0.dp) }

            Card(
                modifier = modifier
                    .wrapContentHeight()
                    .clip(LocalTheme.current.shapes.componentShape),
                elevation = LocalTheme.current.styles.cardClickableElevation,
                shape = LocalTheme.current.shapes.componentShape,
                colors = CardDefaults.cardColors(
                    containerColor = LocalTheme.current.colors.onBackgroundComponent,
                    contentColor = LocalTheme.current.colors.onBackgroundComponent
                )
            ) {
                AnimatedContent(
                    targetState = isSelected,
                    label = ""
                ) { isOptions ->
                    if(isOptions) {
                        OptionsModeLayout(
                            modifier = Modifier.height(cardHeight),
                            onEditOptionPressed = onNavigateToDetail,
                            onPlayOptionPressed = onNavigateToSession,
                            onCancelClick = {
                                onCheckedChange(false)
                            }
                        )
                    }else if(data != null) {
                        DataCard(
                            modifier = Modifier
                                .onGloballyPositioned { coordinates ->
                                    cardHeight = with(localDensity) { coordinates.size.height.toDp() }
                                },
                            data = data,
                            isChecked = isChecked,
                            onCheckedChange = onCheckedChange
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ShimmerLayout(modifier: Modifier) {
    Box(
        modifier = modifier
            .height(72.dp)
            .brandShimmerEffect()
    )
}

@Composable
private fun DataCard(
    modifier: Modifier,
    data: CollectionIO,
    onCheckedChange: (Boolean) -> Unit = {},
    isChecked: Boolean? = null
) {
    Row(
        modifier = modifier.padding(vertical = 8.dp, horizontal = 12.dp)
    ) {
        AnimatedVisibility(visible = isChecked != null) {
            Checkbox(
                modifier = Modifier
                    .offset(x = -(12).dp, y = (-8).dp),
                checked = isChecked == true,
                onCheckedChange = onCheckedChange,
                colors = LocalTheme.current.styles.checkBoxColorsDefault
            )
        }
        Column {
            Text(
                text = data.name,
                modifier = Modifier.padding(top = 4.dp),
                fontSize = 16.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Medium,
                color = LocalTheme.current.colors.primary,
                textAlign = TextAlign.Start
            )
            Text(
                text = data.description,
                modifier = Modifier,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = LocalTheme.current.colors.secondary,
                ),
                minLines = 2,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
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
            .background(color = LocalTheme.current.colors.onBackgroundComponent)
            .fillMaxWidth()
            .clip(LocalTheme.current.shapes.componentShape)
            .then(modifier),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val itemModifier = Modifier
            .weight(1f)
            .fillMaxSize()
            .aspectRatio(1f)

        Box(
            modifier = itemModifier
                .padding(top = 12.dp, bottom = 12.dp, end = 3.dp)
                .background(
                    color = SharedColors.RED_ERROR.copy(alpha = 0.4f),
                    shape = RoundedCornerShape(
                        topStart = LocalTheme.current.shapes.componentCornerRadius,
                        bottomStart = LocalTheme.current.shapes.componentCornerRadius
                    )
                )
                .clickable(
                    indication = rememberRipple(bounded = true),
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    onCancelClick()
                }
                .padding(4.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier
                    .sizeIn(maxHeight = 38.dp, maxWidth = 38.dp)
                    .aspectRatio(1f),
                imageVector = Icons.Outlined.Close,
                contentDescription = stringResource(id = R.string.close_content_description),
                tint = Colors.DARK_BLUE_70
            )
        }
        Box(
            modifier = itemModifier
                .padding(vertical = 12.dp, horizontal = 3.dp)
                .background(
                    color = LocalTheme.current.colors.tetrial.copy(alpha = 0.4f)
                )
                .clickable(
                    indication = rememberRipple(bounded = true),
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    onEditOptionPressed()
                }
                .padding(4.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier
                    .sizeIn(maxHeight = 38.dp, maxWidth = 38.dp)
                    .aspectRatio(1f),
                imageVector = Icons.Outlined.Edit,
                contentDescription = stringResource(id = R.string.edit_content_description),
                tint = Colors.DARK_BLUE_70
            )
        }
        Box(
            modifier = itemModifier
                .padding(top = 12.dp, bottom = 12.dp, start = 3.dp)
                .background(
                    color = SharedColors.GREEN_CORRECT.copy(alpha = 0.4f),
                    shape = RoundedCornerShape(
                        topEnd = LocalTheme.current.shapes.componentCornerRadius,
                        bottomEnd = LocalTheme.current.shapes.componentCornerRadius
                    )
                )
                .clickable(
                    indication = rememberRipple(bounded = true),
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    onPlayOptionPressed()
                }
                .padding(4.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier
                    .sizeIn(maxHeight = 38.dp, maxWidth = 38.dp)
                    .aspectRatio(1f),
                imageVector = Icons.Outlined.PlayArrow,
                contentDescription = stringResource(id = R.string.play_content_description),
                tint = Colors.DARK_BLUE_70
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    AppTheme(isDarkTheme = true) {
        Row(modifier = Modifier.fillMaxWidth()) {
            CollectionCard(
                modifier = Modifier.weight(1f),
                data = null
            )
            CollectionCard(
                modifier = Modifier.weight(1f),
                data = CollectionIO(name = "collection", description = "description"),
                isChecked = true
            )
        }
    }
}