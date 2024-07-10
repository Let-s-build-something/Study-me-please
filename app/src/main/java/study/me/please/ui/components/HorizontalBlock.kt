package study.me.please.ui.components

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForwardIos
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    onActionClicked: (Boolean) -> Unit,
    content: @Composable () -> Unit
) {
    Column(modifier = modifier.fillMaxWidth()) {
        OutlinedButton(
            modifier = Modifier
                .padding(top = 16.dp, start = 8.dp, bottom = 4.dp),
            text = heading,
            activeColor = LocalTheme.current.colors.secondary,
            onClick = {
                onActionClicked(false)
            }
        )
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
                        onActionClicked(true)
                    }
                )
            }else {
                content()
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