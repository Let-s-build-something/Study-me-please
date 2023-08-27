package study.me.please.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import com.squadris.squadris.compose.components.InfiniteHorizontalPage
import study.me.please.data.io.BannerSlideResponse

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BannerHorizontalPager(
    pageCount: Int? = null,
    state: PagerState,
    data: List<BannerSlideResponse> = listOf()
) {
    if(pageCount != null) {
        InfiniteHorizontalPage(
            pageCount = pageCount,
            state = state
        ) { pageIndex ->
            data.getOrNull(pageIndex)?.let { slide ->
                BannerHorizontalSlide(slide)
            }
        }
    }else {
        //TODO shimmer
    }
}