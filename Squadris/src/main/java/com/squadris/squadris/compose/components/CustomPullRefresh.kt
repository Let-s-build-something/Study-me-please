package com.squadris.squadris.compose.components

import android.app.Activity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshState
import androidx.compose.material.pullrefresh.pullRefreshIndicatorTransform
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.squadris.squadris.R
import com.squadris.squadris.compose.theme.Colors
import com.squadris.squadris.ext.isTablet

private const val REFRESH_WIDTH_PERCENTILE_PHONE = 0.25
private const val REFRESH_WIDTH_PERCENTILE_TABLET = 0.175
const val REFRESH_RETURN_ANIMATION_LENGTH = 600L

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomPullRefresh(
    modifier: Modifier = Modifier,
    isRefreshing: Boolean,
    state: PullRefreshState,
    content: @Composable (isRefreshing: Boolean) -> Unit = { }
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .pullRefreshIndicatorTransform(state),
        contentAlignment = Alignment.BottomCenter
    ) {
        content(isRefreshing)
    }
}

@Composable
fun getDefaultPullRefreshSize(activity: Activity): Dp {
    return (LocalConfiguration.current.screenWidthDp).times(if(isTablet(activity = activity)) {
        REFRESH_WIDTH_PERCENTILE_TABLET
    }else REFRESH_WIDTH_PERCENTILE_PHONE).dp
}

/** Gives random loading lottie animation */
val randomLoadingLottieAnim: Pair<Int, Color>
    get() = listOf(
        R.raw.loading_animation_3a3a3a to Colors.LOADING_ANIMATION_3a3a3a,
        R.raw.loading_animation_45ddd2 to Colors.LOADING_ANIMATION_45ddd2,
        R.raw.loading_animation_755334 to Colors.LOADING_ANIMATION_755334,
        R.raw.loading_animation_798c8e to Colors.LOADING_ANIMATION_798c8e,
        R.raw.loading_animation_88fcac to Colors.LOADING_ANIMATION_88fcac,
        R.raw.loading_animation_a6dfff to Colors.LOADING_ANIMATION_a6dfff,
        R.raw.loading_animation_a87b2a to Colors.LOADING_ANIMATION_a87b2a,
        R.raw.loading_animation_aa7d2e to Colors.LOADING_ANIMATION_aa7d2e,
        R.raw.loading_animation_bcd8cb to Colors.LOADING_ANIMATION_bcd8cb,
        R.raw.loading_animation_c0e0ed to Colors.LOADING_ANIMATION_c0e0ed,
        R.raw.loading_animation_c0f3ff to Colors.LOADING_ANIMATION_c0f3ff,
        R.raw.loading_animation_c19a2d to Colors.LOADING_ANIMATION_c19a2d,
        R.raw.loading_animation_c1a58e to Colors.LOADING_ANIMATION_c1a58e,
        R.raw.loading_animation_c5eae8 to Colors.LOADING_ANIMATION_c5eae8,
        R.raw.loading_animation_cebb8e to Colors.LOADING_ANIMATION_cebb8e,
        R.raw.loading_animation_d5edef to Colors.LOADING_ANIMATION_d5edef,
        R.raw.loading_animation_e2c888 to Colors.LOADING_ANIMATION_e2c888,
        R.raw.loading_animation_e51749 to Colors.LOADING_ANIMATION_e51749,
        R.raw.loading_animation_e8e1cf to Colors.LOADING_ANIMATION_e8e1cf,
        R.raw.loading_animation_efc6f7 to Colors.LOADING_ANIMATION_efc6f7,
        R.raw.loading_animation_f27d2f to Colors.LOADING_ANIMATION_f27d2f,
        R.raw.loading_animation_f8ffb6 to Colors.LOADING_ANIMATION_f8ffb6,
        R.raw.loading_animation_fcc0de to Colors.LOADING_ANIMATION_fcc0de,
        R.raw.loading_animation_ff0000 to Colors.LOADING_ANIMATION_ff0000,
        R.raw.loading_animation_ffb6ae to Colors.LOADING_ANIMATION_ffb6ae,
        R.raw.loading_animation_ffdbc0 to Colors.LOADING_ANIMATION_ffdbc0,
        R.raw.loading_animation_fff4c0 to Colors.LOADING_ANIMATION_fff4c0,
    ).random()