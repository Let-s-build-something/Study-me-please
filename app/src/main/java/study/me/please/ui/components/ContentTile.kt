package study.me.please.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.ext.brandShimmerEffect
import com.squadris.squadris.ext.scalingClickable

/** Height of the content tile */
const val CONTENT_TILE_HEIGHT_DP = 160f

/**
 * Clickable tile with an image, title, and decription
 */
@Composable
fun ContentTile(
    modifier: Modifier = Modifier,
    imageUrl: String,
    title: String,
    description: String,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .height(CONTENT_TILE_HEIGHT_DP.dp)
            .scalingClickable(
                onTap = {
                    onClick()
                }
            ),
        shape = LocalTheme.current.shapes.roundedComponentShape,
        colors = CardDefaults.cardColors(
            containerColor = LocalTheme.current.colors.onBackgroundComponent,
            contentColor = LocalTheme.current.colors.onBackgroundComponent
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp, end = 8.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = LocalTheme.current.colors.primary,
                        fontWeight = FontWeight.Medium
                    )
                )
                Text(
                    text = description,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = LocalTheme.current.colors.secondary
                    )
                )
            }
            val isLoading = remember {
                mutableStateOf(false)
            }

            AsyncImage(
                modifier = Modifier
                    .clip(LocalTheme.current.shapes.roundedComponentShape)
                    .fillMaxHeight()
                    .then(if(isLoading.value) Modifier.brandShimmerEffect() else Modifier),
                model = imageUrl,
                contentDescription = null,
                onState = { loadState ->
                    isLoading.value = loadState is AsyncImagePainter.State.Loading
                }
            )
        }
    }
}