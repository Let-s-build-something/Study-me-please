package study.me.please.ui.components.session

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
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
import study.me.please.ui.components.OptionsModeLayout

/**
 * Card displaying a session
 */
@Composable
fun SessionCard(
    modifier: Modifier = Modifier,
    session: SessionIO?,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    isChecked: Boolean? = null,
    isSelected: Boolean = false,
    enabled: Boolean = true,
    onCheckedChange: (Boolean) -> Unit = {},
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
                            onEditOptionPressed = onEditOptionPressed,
                            onPlayOptionPressed = onPlayOptionPressed,
                            onCancelClick = {
                                onCheckedChange(false)
                            }
                        )
                    }else if(session != null) {
                        ContentLayout(
                            modifier = Modifier.onGloballyPositioned { coordinates ->
                                cardHeight = with(localDensity) { coordinates.size.height.toDp() }
                            },
                            enabled = enabled,
                            session = session,
                            verticalAlignment = verticalAlignment,
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
private fun ContentLayout(
    modifier: Modifier = Modifier,
    session: SessionIO,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    isChecked: Boolean?,
    enabled: Boolean = true,
    onCheckedChange: (Boolean) -> Unit
) {
    Column(
        modifier = modifier
            .wrapContentHeight()
            .animateContentSize()
            .padding(vertical = 8.dp, horizontal = 12.dp)
    ) {
        Row(verticalAlignment = verticalAlignment) {
            AnimatedVisibility(visible = isChecked != null) {
                Checkbox(
                    modifier = Modifier.offset(x = -(12).dp),
                    checked = isChecked == true,
                    enabled = enabled,
                    onCheckedChange = onCheckedChange,
                    colors = LocalTheme.current.styles.checkBoxColorsDefault
                )
            }
            Image(
                modifier = Modifier
                    .size(LocalTheme.current.shapes.iconSizeMedium)
                    .background(
                        color = LocalTheme.current.colors.brandMain,
                        shape = LocalTheme.current.shapes.circularActionShape
                    )
                    .padding(8.dp),
                imageVector = (session.preferencePack?.estimatedMode ?: QuestionMode.LEARNING).icon,
                contentDescription = (session.preferencePack?.estimatedMode ?: QuestionMode.LEARNING).icon.name,
                colorFilter = ColorFilter.tint(color = LocalTheme.current.colors.tetrial)
            )
            Text(
                modifier = Modifier
                    .padding(start = 8.dp, end = 4.dp)
                    .fillMaxWidth(),
                text = session.name,
                color = LocalTheme.current.colors.primary,
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
            .brandShimmerEffect(shape = LocalTheme.current.shapes.componentShape)
    )
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
private fun Preview() {
    SessionCard(session = SessionIO(name = "Session name"))
}