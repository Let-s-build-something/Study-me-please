package study.me.please.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
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
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.SessionIO

/**
 * Card displaying a session
 */
@Composable
fun SessionCard(
    modifier: Modifier = Modifier,
    session: SessionIO?,
    onClick: () -> Unit,
    onLongClick: () -> Unit
) {
    if(session != null) {
        ContentLayout(
            modifier = modifier,
            session = session,
            onClick = onClick,
            onLongClick = onLongClick
        )
    }else {
        ShimmerLayout(modifier = modifier)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ContentLayout(
    modifier: Modifier = Modifier,
    session: SessionIO,
    onClick: () -> Unit,
    onLongClick: () -> Unit
) {
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
                onClick = onClick,
                onLongClick = onLongClick
            ),
        elevation = LocalTheme.styles.cardClickableElevation,
        shape = LocalTheme.shapes.componentShape,
        colors = CardDefaults.cardColors(
            containerColor = LocalTheme.colors.onBackgroundComponentContrast,
            contentColor = LocalTheme.colors.onBackgroundComponentContrast
        )
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(
                    start = 8.dp,
                    end = 10.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
        ) {
            val (imgMode, txtName, txtQuestionCount, txtCollections) = createRefs()
            Image(
                modifier = Modifier
                    .size(LocalTheme.shapes.iconSizeMedium)
                    .background(
                        color = LocalTheme.colors.brandMain,
                        shape = LocalTheme.shapes.circularActionShape
                    )
                    .padding(8.dp)
                    .constrainAs(imgMode) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                    },
                imageVector = session.preferences.estimatedMode.icon,
                contentDescription = session.preferences.estimatedMode.icon.name,
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
                    session.allQuestionUids.size
                ),
                color = LocalTheme.colors.primary,
                fontSize = 16.sp
            )
            Text(
                modifier = Modifier
                    .constrainAs(txtCollections) {
                        linkTo(imgMode.end, parent.end)
                        top.linkTo(txtName.bottom, 2.dp)
                        width = Dimension.fillToConstraints
                    }
                    .padding(horizontal = 6.dp),
                text = session.collections.joinToString(separator = ", ") { it.name },
                color = LocalTheme.colors.secondary,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontSize = 14.sp
            )
        }
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

@Preview
@Composable
private fun Preview() {
    SessionCard(
        session = SessionIO(name = "Session name").apply {
            allQuestionUids = listOf("", "", "", "", "", "", "", "", "", "", "", "", "")
            collections = listOf(
                CollectionIO(name = "first collection"),
                CollectionIO(name = "second collection"),
                CollectionIO(name = "second collection"),
                CollectionIO(name = "second collection"),
                CollectionIO(name = "second collection"),
                CollectionIO(name = "third collection")
            )
        },
        onClick = { }
    ) {

    }
}