package study.me.please.ui.components

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import com.squadris.squadris.compose.theme.LocalTheme

/** Indication of scroll via [LinearProgressIndicator] */
@Composable
fun ProgressIndicator(
    modifier: Modifier = Modifier,
    scrollState: LazyListState
) {
    LinearProgressIndicator(
        modifier = modifier,
        progress = 0f, //TODO
        color = LocalTheme.colors.brandMain,
        trackColor = LocalTheme.colors.tetrial,
        strokeCap = StrokeCap.Round
    )
}