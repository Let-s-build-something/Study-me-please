package study.me.please.ui.components

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material.icons.outlined.ContentPaste
import androidx.compose.material.icons.outlined.DeleteSweep
import androidx.compose.material.icons.outlined.Deselect
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.SelectAll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.zIndex
import com.squadris.squadris.compose.components.chips.DEFAULT_ANIMATION_LENGTH_LONG
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.compose.theme.SharedColors
import study.me.please.R

/** default option for items selection */
val checkedOptionsItems = listOf(
    OptionsLayoutAction.SelectAll,
    OptionsLayoutAction.DeselectAll,
    OptionsLayoutAction.Delete
)

/**
 * Standardised way of giving user options for editing or handling list of items
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OptionsLayout(
    modifier: Modifier = Modifier,
    actions: List<OptionsLayoutAction> = emptyList(),
    onClick: (OptionsLayoutAction) -> Unit = {},
    onClearClick: () -> Unit = {},
    content: LazyListScope.() -> Unit = {}
) {
    AnimatedVisibility(
        modifier = Modifier.zIndex(-1f),
        visible = actions.isNotEmpty(),
        enter = slideInHorizontally(
            initialOffsetX = { -it },
            animationSpec = tween(DEFAULT_ANIMATION_LENGTH_LONG)
        ),
        exit = slideOutHorizontally(
            targetOffsetX = { -it },
            animationSpec = tween(DEFAULT_ANIMATION_LENGTH_LONG)
        )
    ) {
        LazyRow(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .zIndex(-1f),
            horizontalArrangement = Arrangement.spacedBy(
                LocalTheme.current.shapes.betweenItemsSpace
            )
        ) {
            item {
                Spacer(modifier = Modifier.width(LocalTheme.current.shapes.betweenItemsSpace))
            }
            items(
                items = actions,
                key = { action -> action.toString() }
            ) { action ->
                ImageAction(
                    modifier = Modifier.animateItemPlacement(),
                    leadingImageVector = action.leadingImageVector,
                    text = stringResource(action.textRes),
                    onClick = {
                        onClick(action)
                    },
                    containerColor = action.containerColor ?: LocalTheme.current.colors.brandMain,
                    onTrailingIconClick = onClearClick,
                    trailingImageVector = action.trailingImageVector
                )
            }
            content()
            item {
                Spacer(modifier = Modifier.width(LocalTheme.current.shapes.betweenItemsSpace))
            }
        }
    }
}



sealed class OptionsLayoutAction(
    @StringRes open val textRes: Int,
    open val leadingImageVector: ImageVector,
    open val trailingImageVector: ImageVector? = null,
    open val containerColor: Color? = null
) {
    data object Copy: OptionsLayoutAction(
        textRes = R.string.button_copy,
        leadingImageVector = Icons.Outlined.ContentCopy
    )

    data object Paste: OptionsLayoutAction(
        textRes = R.string.button_paste,
        leadingImageVector = Icons.Outlined.ContentPaste,
        trailingImageVector = Icons.Outlined.Close
    )

    data class Play(
        override val textRes: Int = R.string.button_start_session
    ): OptionsLayoutAction(
        leadingImageVector = Icons.Outlined.PlayArrow,
        textRes = textRes
    )

    data object SelectAll: OptionsLayoutAction(
        textRes = R.string.button_select_all,
        leadingImageVector = Icons.Outlined.SelectAll
    )

    data object DeselectAll: OptionsLayoutAction(
        textRes = R.string.button_deselect,
        leadingImageVector = Icons.Outlined.Deselect
    )

    data object Delete: OptionsLayoutAction(
        textRes = R.string.button_delete,
        leadingImageVector = Icons.Outlined.DeleteSweep,
        containerColor = SharedColors.RED_ERROR
    )
}