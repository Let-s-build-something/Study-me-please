package study.me.please.base.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.theme.AppTheme
import study.me.please.R

@Preview
@Composable
fun ActionBarIcon(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    text: String = stringResource(id = R.string.screen_collection_title),
    imageVector: ImageVector = Icons.Outlined.Dashboard
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .widthIn(32.dp, 72.dp)
            .wrapContentHeight()
            .clip(RoundedCornerShape(8.dp))
            .clickable(
                indication = rememberRipple(
                    bounded = true,
                    color = AppTheme.colors.contrastActionLight
                ),
                interactionSource = remember { MutableInteractionSource() }
            ) {
                onClick.invoke()
            }.padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier.size(32.dp),
            imageVector = imageVector,
            contentDescription = text,
            tint = AppTheme.colors.tetrial
        )
        Text(
            modifier = Modifier
                .wrapContentHeight()
                .padding(top = 4.dp),
            text = text,
            color = AppTheme.colors.tetrial,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}