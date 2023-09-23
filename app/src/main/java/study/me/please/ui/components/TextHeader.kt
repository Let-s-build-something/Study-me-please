package study.me.please.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.theme.LocalTheme

@Composable
fun TextHeader(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(top = 8.dp, start = 8.dp, bottom = 2.dp),
        text = text,
        fontSize = 16.sp,
        color = LocalTheme.colors.secondary,
        fontWeight = FontWeight.Bold
    )
}