package study.me.please.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.squadris.squadris.compose.theme.LocalTheme

@Composable
fun BulletPoint(
    modifier: Modifier = Modifier,
    prefix: String = "\u2022",
    text: String,
    textStyle: TextStyle = LocalTheme.styles.category,
) {
    Text(
        modifier = modifier.padding(vertical = 2.dp),
        text = "$prefix\t\t$text",
        style = textStyle
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        BulletPoint(
            text = "This is very very"
        )
        BulletPoint(
            text = "This is very very very very very looooooong bullet point"
        )
    }
}