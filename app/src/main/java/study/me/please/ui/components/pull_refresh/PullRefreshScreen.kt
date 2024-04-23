package study.me.please.ui.components.pull_refresh

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.FabPosition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.squadris.squadris.compose.components.getDefaultPullRefreshSize
import study.me.please.base.BrandBaseScreen
import study.me.please.base.DraggableRefreshIndicator
import study.me.please.base.LocalIsTablet
import study.me.please.base.navigation.NavIconType
import study.me.please.ui.collection.RefreshableViewModel

/**
 * Implementation of the [BrandBaseScreen] with pull to refresh logic
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PullRefreshScreen(
    modifier: Modifier = Modifier,
    viewModel: RefreshableViewModel,
    navIconType: NavIconType = NavIconType.BACK,
    title: String? = null,
    subtitle: String? = null,
    onBackPressed: () -> Boolean = { true },
    actionIcons: (@Composable RowScope.() -> Unit)? = null,
    appBarVisible: Boolean = true,
    onNavigationIconClick: (() -> Unit)? = null,
    containerColor: Color = Color.Transparent,
    contentColor: Color = Color.Transparent,
    floatingActionButtonPosition: FabPosition = FabPosition.End,
    floatingActionButton: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit,
) {
    val refreshScope = rememberCoroutineScope()
    val isTablet = LocalIsTablet.current
    val pullRefreshSize = getDefaultPullRefreshSize(isTablet = isTablet)
    val indicatorOffset = remember { mutableStateOf(0.dp) }

    val isRefreshing = viewModel.isRefreshing.collectAsState()

    val pullRefreshState = rememberPullRefreshState(
        refreshing = isRefreshing.value,
        onRefresh = {
            viewModel.requestData(scope = refreshScope, isSpecial = true, isPullRefresh = true)
        },
        refreshingOffset = pullRefreshSize,
        refreshThreshold = pullRefreshSize
    )

    BrandBaseScreen(
        modifier = modifier,
        navIconType = navIconType,
        title = title,
        subtitle = subtitle,
        onBackPressed = onBackPressed,
        actionIcons = actionIcons,
        onNavigationIconClick = onNavigationIconClick,
        appBarVisible = appBarVisible,
        containerColor = containerColor,
        contentColor = contentColor,
        floatingActionButtonPosition = floatingActionButtonPosition,
        floatingActionButton = floatingActionButton
    ) { paddingValues ->
        DraggableRefreshIndicator(
            modifier = Modifier.padding(paddingValues),
            pullRefreshSize = pullRefreshSize,
            state = pullRefreshState,
            isRefreshing = isRefreshing.value
        ) { indicatorOffsetDp ->
            indicatorOffset.value = indicatorOffsetDp
        }
        Box(
            modifier = Modifier
                .offset {
                    IntOffset(
                        x = 0,
                        y = indicatorOffset.value.roundToPx()
                    )
                }
                .pullRefresh(pullRefreshState)
        ) {
            content(paddingValues)
        }
    }
}