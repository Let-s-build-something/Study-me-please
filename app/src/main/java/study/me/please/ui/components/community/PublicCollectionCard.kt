package study.me.please.ui.components.community

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.ext.brandShimmerEffect
import com.squadris.squadris.ext.scalingClickable
import study.me.please.data.io.CollectionIO
import study.me.please.ui.components.CONTENT_TILE_HEIGHT_DP

/**
 * Collection card that is public to anyone who finds it
 * It contains general information about its content including rating
 */
@Composable
fun PublicCollectionCard(
    modifier: Modifier = Modifier,
    collection: CollectionIO? = null,
    onClick: () -> Unit = {},
) {
    Crossfade(
        modifier = modifier,
        targetState = collection != null,
        label = "crossfadeShimmerContent"
    ) { isLoaded ->
        if(isLoaded && collection != null) {
            ContentLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .scalingClickable(onTap = {
                        onClick()
                    }),
                collection = collection
            )
        }else {
            ShimmerLayout(modifier = modifier)
        }
    }
}

@Composable
private fun ContentLayout(
    modifier: Modifier = Modifier,
    collection: CollectionIO
) {
    Card(
        modifier = modifier
            .heightIn(min = 100.dp, max = CONTENT_TILE_HEIGHT_DP.dp),
        shape = LocalTheme.current.shapes.roundedComponentShape,
        colors = CardDefaults.cardColors(
            containerColor = LocalTheme.current.colors.onBackgroundComponent,
            contentColor = LocalTheme.current.colors.onBackgroundComponent
        )
    ) {
        Column(
            modifier = Modifier
                .padding(start = 10.dp, top = 10.dp, end = 8.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = collection.name,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = LocalTheme.current.colors.primary,
                    fontWeight = FontWeight.Medium
                )
            )
            Text(
                text = collection.description,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = LocalTheme.current.colors.secondary
                )
            )
        }
    }
}

@Composable
private fun ShimmerLayout(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(120.dp)
            .brandShimmerEffect()
    )
}