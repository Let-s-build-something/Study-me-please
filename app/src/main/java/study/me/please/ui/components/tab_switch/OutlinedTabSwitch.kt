package study.me.please.ui.components.tab_switch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.squadris.squadris.compose.theme.LocalTheme
import study.me.please.ui.components.OutlinedButton

/**
 * Component with similiar behaviour to a [TabRow] but made out of [OutlinedButton]
 */
@Composable
fun OutlinedTabSwitch(
    state: TabSwitchState = rememberTabSwitchState(scrollState = rememberScrollState())
) {
    LaunchedEffect(state.selectedTabIndex) {
        state.scrollState.animateScrollTo(state.selectedTabIndex.value)
    }
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = LocalTheme.shapes.betweenItemsSpace),
        horizontalArrangement = Arrangement.spacedBy(LocalTheme.shapes.betweenItemsSpace)
    ) {
        items(state.tabs.size) { index ->
            state.tabs.getOrNull(index)?.let { tab ->
                OutlinedButton(
                    text = tab,
                    isActivated = state.selectedTabIndex.value == index,
                    onClick = {
                        state.selectedTabIndex.value = index
                    }
                )
            }
        }
    }
}