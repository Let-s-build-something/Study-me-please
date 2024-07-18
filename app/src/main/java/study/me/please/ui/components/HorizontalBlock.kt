package study.me.please.ui.components

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForwardIos
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.theme.LocalTheme

/**
 * Horizontal block with content
 * @param isEmpty whether the content is empty
 * @param heading title of the block
 * @param emptyTitle title of the empty content
 * @param emptyText text of the empty content
 * @param onActionClicked action to be performed when action is clicked
 * @param content content of the block
 */
@Composable
fun HorizontalBlock(
    modifier: Modifier = Modifier,
    isEmpty: Boolean = false,
    heading: String,
    emptyTitle: String = "",
    emptyText: String = "",
    onActionClicked: ((Boolean) -> Unit)? = null,
    content: LazyListScope.() -> Unit
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Box(modifier = Modifier.padding(
            top = 16.dp,
            start = 8.dp,
            bottom = 6.dp
        )) {
            if(onActionClicked != null) {
                OutlinedButton(
                    text = heading,
                    activeColor = LocalTheme.current.colors.secondary,
                    onClick = {
                        onActionClicked(false)
                    }
                )
            }else {
                Text(
                    text = heading,
                    style = TextStyle(
                        color = LocalTheme.current.colors.secondary,
                        fontSize = 14.sp
                    )
                )
            }
        }
        Crossfade(
            modifier = modifier.fillMaxWidth(),
            targetState = isEmpty,
            label = "crossfadeEmptyContent"
        ) { empty ->
            if(empty) {
                EmptyElement(
                    emptyText = emptyTitle,
                    actionText = emptyText,
                    onActionClicked = {
                        onActionClicked?.invoke(true)
                    }
                )
            }else {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(LocalTheme.current.shapes.betweenItemsSpace),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    item {
                        Spacer(modifier = Modifier.width(6.dp))
                    }
                    content()
                    item {
                        Spacer(modifier = Modifier.width(6.dp))
                    }
                }
            }
        }
    }
}

/** Element to place shown whenever row content is empty */
@Composable
private fun EmptyElement(
    emptyText: String = "",
    actionText: String = "",
    onActionClicked: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = emptyText,
            color = LocalTheme.current.colors.primary,
            fontSize = 16.sp
        )
        ImageAction(
            text = actionText,
            trailingImageVector = Icons.AutoMirrored.Outlined.ArrowForwardIos,
            onClick = onActionClicked
        )
    }
}