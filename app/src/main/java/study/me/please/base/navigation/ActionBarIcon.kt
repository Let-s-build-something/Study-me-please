package study.me.please.base.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Dashboard
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.squadris.squadris.compose.theme.LocalTheme
import study.me.please.R
import study.me.please.ui.components.AutoResizeText
import study.me.please.ui.components.FontSizeRange

@Composable
fun ActionBarIcon(
    modifier: Modifier = Modifier,
    text: String,
    imageVector: ImageVector? = null,
    imageUrl: String? = null,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .heightIn(max = 64.0.dp)
            .then(modifier)
            .widthIn(32.dp, 100.dp)
            .fillMaxHeight()
            .clip(LocalTheme.shapes.rectangularActionShape)
            .clickable(
                indication = rememberRipple(
                    bounded = true,
                    color = LocalTheme.colors.contrastActionLight
                ),
                interactionSource = remember { MutableInteractionSource() }
            ) {
                onClick.invoke()
            }.padding(vertical = 4.dp, horizontal = 6.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when {
            imageUrl != null -> {
                AsyncImage(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(24.dp),
                    model = imageUrl,
                    contentDescription = text
                )
            }
            imageVector != null -> {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = imageVector,
                    contentDescription = text,
                    tint = LocalTheme.colors.tetrial
                )
            }
        }
        AutoResizeText(
            modifier = Modifier
                .wrapContentHeight()
                .padding(top = 4.dp),
            text = text,
            color = LocalTheme.colors.tetrial,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            maxLines = 2,
            // some users tune up font size so high we can draw it otherwise
            fontSizeRange = FontSizeRange(
                min = 9.5.sp,
                max = 14.sp
            )
        )
    }
}

@Preview
@Composable
private fun Preview() {
    ActionBarIcon(
        text = stringResource(id = R.string.screen_collection_title),
        imageVector = Icons.Outlined.Dashboard
    )
}