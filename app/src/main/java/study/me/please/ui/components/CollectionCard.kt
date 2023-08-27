package study.me.please.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.squadris.squadris.compose.theme.AppTheme
import com.squadris.squadris.compose.theme.checkBoxColorsDefault
import com.squadris.squadris.utils.DateUtils
import study.me.please.data.io.QuestionMode
import java.util.Calendar
import java.util.Date

/**
 * Type of modes this card can be in
 * @property DATA_DISPLAY regular information/data displaying card
 * @property OPTIONS_MODE whenever
 */
enum class CollectionCardMode {
    DATA_DISPLAY,
    OPTIONS_MODE,
    CHECKING
}

/** remembers the current state */
@Composable
fun rememberCollectionCardState(
    mode: CollectionCardMode = CollectionCardMode.DATA_DISPLAY,
    isChecked: Boolean = false,
    onCheckedChange: ((Boolean) -> Unit) = {}
): CollectionCardState {
    val scope = rememberCoroutineScope()
    val state = remember(scope) {
        CollectionCardState(
            mode = mode,
            isChecked = isChecked,
            onCheckedChange = onCheckedChange
        )
    }
    return state
}

/**  */
data class CollectionCardState (
    var mode: CollectionCardMode,
    var isChecked: Boolean,
    val onCheckedChange: ((Boolean) -> Unit)
)

/** Item displaying collection and shortened information about it */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CollectionCard(
    modifier: Modifier = Modifier,
    imageVector: ImageVector?,
    iconUrlPath: String?,
    questionMode: QuestionMode?,
    heading: String,
    description: String,
    dateCreated: Date?,
    state: CollectionCardState,
    onLongClick: () -> Unit
) {
    val localDensity = LocalDensity.current
    var cardHeight by remember { mutableStateOf(0.dp) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable(
                indication = rememberRipple(bounded = false),
                interactionSource = remember { MutableInteractionSource() }
            ) {
                state.mode = CollectionCardMode.OPTIONS_MODE
            }
            .combinedClickable(
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = rememberRipple(bounded = true),
                onClick = {
                    state.mode = CollectionCardMode.OPTIONS_MODE
                },
                onLongClick = onLongClick
            ),
        elevation = cardElevation(
            defaultElevation = 2.dp,
            pressedElevation = 4.dp,
            draggedElevation = 12.dp
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        if(state.mode == CollectionCardMode.OPTIONS_MODE) {
            OptionsModeLayout(
                modifier = Modifier.height(cardHeight)
            )
        }else {
            DataCard(
                modifier = Modifier.onGloballyPositioned { coordinates ->
                    cardHeight = with(localDensity) { coordinates.size.height.toDp() }
                },
                imageVector = imageVector,
                iconUrlPath = iconUrlPath,
                questionMode = questionMode,
                heading = heading,
                description = description,
                dateCreated = dateCreated,
                state = state
            )
        }
    }
}

@Composable
private fun DataCard(
    modifier: Modifier = Modifier,
    imageVector: ImageVector?,
    iconUrlPath: String?,
    questionMode: QuestionMode?,
    heading: String,
    description: String,
    dateCreated: Date?,
    state: CollectionCardState
) {
    ConstraintLayout(
        modifier = modifier
            .padding(vertical = 6.dp, horizontal = 8.dp)
            .fillMaxWidth()
    ) {
        val (
            txtHeading,
            txtDescription,
            imgIcon,
            txtDateCreated,
            divider,
            txtMode,
            checkBox
        ) = createRefs()

        if(state.mode == CollectionCardMode.CHECKING) {
            Checkbox(
                modifier = Modifier.constrainAs(checkBox) {
                    start.linkTo(parent.start, (-8).dp)
                    top.linkTo(parent.top, (-12).dp)
                },
                checked = state.isChecked,
                onCheckedChange = {
                    state.isChecked = it
                    state.onCheckedChange(it)
                },
                colors = checkBoxColorsDefault
            )
        }
        if(questionMode != null) {
            Text(
                text = questionMode.toString(),
                modifier = Modifier.constrainAs(txtMode) {
                    top.linkTo(parent.top, 4.dp)
                    end.linkTo(parent.end)
                },
                fontSize = 10.sp,
                color = AppTheme.colors.secondary
            )
        }
        Text(
            text = heading,
            modifier = Modifier.constrainAs(txtHeading) {
                top.linkTo(parent.top, 4.dp)
                start.linkTo(
                    if(state.mode == CollectionCardMode.CHECKING) {
                        checkBox.end
                    }else parent.start
                )
            },
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = AppTheme.colors.primary
        )
        val iconModifier = Modifier
            .size(48.dp)
            .background(
                color = AppTheme.colors.brandMain,
                shape = RoundedCornerShape(8.dp)
            )
            .clip(RoundedCornerShape(8.dp))
            .constrainAs(imgIcon) {
                top.linkTo(txtMode.bottom, 2.dp)
                end.linkTo(parent.end)
            }
        if(imageVector != null) {
            Icon(
                modifier = iconModifier,
                imageVector = imageVector,
                contentDescription = "icon"
            )
        }else {
            AsyncImage(
                modifier = iconModifier,
                model = ImageRequest.Builder(LocalContext.current)
                    .data(iconUrlPath)
                    .build(),
                contentDescription = "icon",
                contentScale = ContentScale.Inside
            )
        }
        HorizontalDivider(
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .constrainAs(divider) {
                    top.linkTo(imgIcon.bottom, 4.dp)
                    linkTo(parent.start, parent.end)
                },
            color = AppTheme.colors.onBackgroundComponentContrast
        )
        Text(
            text = description,
            modifier = Modifier
                .constrainAs(txtDescription) {
                    top.linkTo(txtHeading.bottom, 4.dp)
                    start.linkTo(parent.start)
                    end.linkTo(imgIcon.start, 6.dp)
                    width = Dimension.fillToConstraints
                },
            fontSize = 12.sp,
            color = AppTheme.colors.secondary,
            minLines = 2,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = DateUtils.formatDateAs(
                date = dateCreated,
                pattern = "d. MMM yyyy"
            ),
            modifier = Modifier.constrainAs(txtDateCreated) {
                top.linkTo(divider.bottom, 4.dp)
                end.linkTo(parent.end)
            },
            fontSize = 12.sp,
            color = AppTheme.colors.secondary
        )
    }
}

@Composable
private fun OptionsModeLayout(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            Icons.Default.List,
            contentDescription = "Filter",
            tint = Color.DarkGray,
            modifier = Modifier
                .weight(1f)
                .clickable(
                    indication = rememberRipple(bounded = false),
                    interactionSource = remember { MutableInteractionSource() }
                ) {

                }
        )
        Icon(
            Icons.Default.List,
            contentDescription = "Filter",
            tint = Color.DarkGray,
            modifier = Modifier
                .weight(1f)
                .clickable(
                    indication = rememberRipple(bounded = false),
                    interactionSource = remember { MutableInteractionSource() }
                ) {

                }
        )
        Icon(
            Icons.Default.List,
            contentDescription = "Filter",
            tint = Color.DarkGray,
            modifier = Modifier
                .weight(1f)
                .clickable(
                    indication = rememberRipple(bounded = false),
                    interactionSource = remember { MutableInteractionSource() }
                ) {

                }
        )
        //TODO buttons icons and transparent color background which looses the
        //TODO transparency after pressing
    }
}

@Preview(widthDp = 360)
@Composable
private fun Preview() {
    CollectionCard(
        questionMode = QuestionMode.LEARNING,
        heading = "Social psychology",
        description = "looooooong description of whatever it is that user wants" + " to be seen here. Perhaps even longer than previously thought to be",
        iconUrlPath = "",
        imageVector = null,
        state = CollectionCardState(
            mode = CollectionCardMode.OPTIONS_MODE,
            isChecked = false
        ) {},
        dateCreated = Calendar.getInstance(DateUtils.locale).time
    ) {}
}