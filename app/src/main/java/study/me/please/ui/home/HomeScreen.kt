package study.me.please.ui.home

import android.app.Activity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Switch
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import com.squadris.squadris.compose.components.getDefaultPullRefreshSize
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import study.me.please.base.DraggableRefreshIndicator
import study.me.please.base.ProgressBarRefreshIndicator

/** Main screen, visible first when user opens the app */
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    activity: Activity,
    viewModel: HomeViewModel = hiltViewModel(),
    isDarkTheme: Boolean,
    onThemeChange: (isDarkTheme: Boolean) -> Unit = {}
) {
    val banners = viewModel.dataManager.bannersResponse.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    val isRefreshing = remember { mutableStateOf(false) }
    val pullRefreshSize = getDefaultPullRefreshSize(activity = activity)
    val pullRefreshState = rememberPullRefreshState(
        refreshing = isRefreshing.value,
        onRefresh = {
            coroutineScope.launch {
                isRefreshing.value = true
                delay(2000)
                isRefreshing.value = false
            }
        },
        refreshThreshold = pullRefreshSize,
        refreshingOffset = pullRefreshSize
    )
    val pagerState = rememberPagerState(
        initialPage = 1,
        initialPageOffsetFraction = 0f
    ) {
        banners.value?.bannerSlides?.size ?: 0
    }
    val indicatorOffset = remember { mutableStateOf(0.dp) }

    DraggableRefreshIndicator(
        pullRefreshSize = pullRefreshSize,
        state = pullRefreshState,
        isRefreshing = isRefreshing.value
    ) { indicatorOffsetDp ->
        indicatorOffset.value = indicatorOffsetDp
    }
    ConstraintLayout(
        modifier = Modifier
            .pullRefresh(pullRefreshState)
            .fillMaxSize()
            .graphicsLayer {
                translationY = indicatorOffset.value.toPx()
            }
    ) {
        val mainContent = createRef()
        ProgressBarRefreshIndicator(isRefreshing = isRefreshing.value, state = pullRefreshState)
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .constrainAs(mainContent) {
                    linkTo(
                        parent.top,
                        parent.bottom
                    )
                    linkTo(parent.start, parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                },
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Switch(
                modifier = Modifier.padding(12.dp),
                checked = isDarkTheme,
                onCheckedChange = onThemeChange
            )
            if(banners.value?.bannerSlides?.isNotEmpty() == true) {
                BannerHorizontalPager(
                    pageCount = banners.value?.bannerSlides?.size,
                    state = pagerState
                )
            }
        }
    }
}