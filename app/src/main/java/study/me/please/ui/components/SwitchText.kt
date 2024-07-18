package study.me.please.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.theme.LocalTheme
import study.me.please.base.theme.AppTheme

/** combination of a multiline text and a switch, must be subscribed to a state data */
@Composable
fun SwitchText(
    modifier: Modifier = Modifier,
    text: String,
    isChecked: Boolean = false,
    onCheckChanged: (Boolean) -> Unit = {},
) {
    Row(
        modifier = modifier
            .padding(start = 4.dp, bottom = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End,
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            text = text,
            color = LocalTheme.current.colors.secondary,
            fontSize = 16.sp
        )
        Switch(
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp)
                .wrapContentWidth(),
            checked = isChecked,
            onCheckedChange = onCheckChanged,
            colors = LocalTheme.current.styles.switchColorsDefault
        )
    }
}

@Preview
@Composable
private fun Preview() {
    AppTheme(isDarkTheme = true) {
        Column(
            modifier = Modifier
                .background(color = LocalTheme.current.colors.backgroundLight)
        ) {
            SwitchText(
                text = "switch text",
                isChecked = true
            )
        }
    }
}