package study.me.please.base.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Dashboard
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.theme.LocalTheme
import study.me.please.R

@Composable
fun ActionBarIcon(
    modifier: Modifier = Modifier,
    text: String,
    imageVector: ImageVector,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .then(modifier)
            .widthIn(32.dp, 110.dp)
            .wrapContentHeight()
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
        Icon(
            modifier = Modifier.size(32.dp),
            imageVector = imageVector,
            contentDescription = text,
            tint = LocalTheme.colors.tetrial
        )
        Text(
            modifier = Modifier
                .wrapContentHeight()
                .padding(top = 4.dp),
            text = text,
            color = LocalTheme.colors.tetrial,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            maxLines = 1,
            minLines = 1,
            overflow = TextOverflow.Clip
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