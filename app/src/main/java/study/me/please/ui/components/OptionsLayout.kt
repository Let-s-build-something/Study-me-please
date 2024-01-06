package study.me.please.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material.icons.outlined.ContentPaste
import androidx.compose.material.icons.outlined.DeleteSweep
import androidx.compose.material.icons.outlined.Deselect
import androidx.compose.material.icons.outlined.SelectAll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.zIndex
import com.squadris.squadris.compose.components.DEFAULT_ANIMATION_LENGTH_SHORT
import com.squadris.squadris.compose.theme.Colors
import com.squadris.squadris.compose.theme.LocalTheme
import study.me.please.R

/**
 * Standardised way of giving user options for editing or handling list of items
 */
@Composable
fun OptionsLayout(
    modifier: Modifier = Modifier,
    onDeleteRequest: () -> Unit = {},
    onCopyRequest: () -> Unit = {},
    onPasteRequest: () -> Unit = {},
    onClipBoardRemoval: () -> Unit,
    selectAllVisible: Boolean = true,
    onSelectAll: () -> Unit = {},
    deselectAllVisible: Boolean = true,
    onDeselectAll: () -> Unit = {},
    isEditMode: Boolean = false,
    hasPasteOption: Boolean = false,
    animateTopDown: Boolean = true,
    content: @Composable RowScope.() -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .horizontalScroll(rememberScrollState())
            .zIndex(-1f),
        horizontalArrangement = Arrangement.spacedBy(
            LocalTheme.shapes.betweenItemsSpace
        )
    ) {
        AnimatedVisibility(
            modifier = Modifier.zIndex(-1f),
            visible = hasPasteOption,
            enter = slideInVertically(
                initialOffsetY = { it.times(if(animateTopDown) -2 else 2) },
                animationSpec = tween(DEFAULT_ANIMATION_LENGTH_SHORT)
            ),
            exit = slideOutVertically(
                targetOffsetY = { it.times(if(animateTopDown) -2 else 2) },
                animationSpec = tween(DEFAULT_ANIMATION_LENGTH_SHORT)
            )
        ) {
            ImageAction(
                leadingImageVector = Icons.Outlined.ContentPaste,
                text = stringResource(id = R.string.button_paste),
                onClick = onPasteRequest,
                trailingImageVector = Icons.Outlined.Close,
                onTrailingIconClick = onClipBoardRemoval
            )
        }
        AnimatedVisibility(
            modifier = Modifier.zIndex(-1f),
            visible = isEditMode,
            enter = slideInVertically(
                initialOffsetY = { it.times(if(animateTopDown) -2 else 2) },
                animationSpec = tween(DEFAULT_ANIMATION_LENGTH_SHORT)
            ),
            exit = slideOutVertically(
                targetOffsetY = { it.times(if(animateTopDown) -2 else 2) },
                animationSpec = tween(DEFAULT_ANIMATION_LENGTH_SHORT)
            )
        ) {
            Row(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.spacedBy(
                    LocalTheme.shapes.betweenItemsSpace
                )
            ) {
                ImageAction(
                    leadingImageVector = Icons.Outlined.ContentCopy,
                    text = stringResource(id = R.string.button_copy),
                    onClick = onCopyRequest
                )
                if(selectAllVisible) {
                    ImageAction(
                        leadingImageVector = Icons.Outlined.SelectAll,
                        text = stringResource(id = R.string.button_select_all),
                        onClick = onSelectAll
                    )
                }
                if(deselectAllVisible) {
                    ImageAction(
                        leadingImageVector = Icons.Outlined.Deselect,
                        text = stringResource(id = R.string.button_deselect),
                        onClick = onDeselectAll
                    )
                }
                ImageAction(
                    leadingImageVector = Icons.Outlined.DeleteSweep,
                    text = stringResource(id = R.string.button_delete),
                    containerColor = Colors.RED_ERROR,
                    onClick = onDeleteRequest
                )
            }
        }
        content(this)
        Spacer(modifier = Modifier.width(LocalTheme.shapes.betweenItemsSpace))
    }
}