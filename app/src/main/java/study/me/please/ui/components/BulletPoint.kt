package study.me.please.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.squadris.squadris.compose.theme.LocalTheme

@Composable
fun BulletPoint(
    modifier: Modifier = Modifier,
    prefix: String? = "\u2022",
    text: AnnotatedString,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    textStyle: TextStyle = LocalTheme.current.styles.category,
) {
    Row(
        modifier = modifier.padding(vertical = 4.dp),
    ) {
        AnimatedVisibility(
            modifier = Modifier.padding(end = 8.dp),
            visible = prefix != null
        ) {
            Text(
                text = prefix ?: "",
                style = textStyle
            )
        }
        Text(
            text = text,
            style = textStyle,
            overflow = overflow,
            softWrap = softWrap,
            maxLines = maxLines
        )
    }
}

@Composable
fun BulletPoint(
    modifier: Modifier = Modifier,
    prefix: String? = "\u2022",
    text: String,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    textStyle: TextStyle = LocalTheme.current.styles.category,
) {
    BulletPoint(
        modifier = modifier,
        prefix = prefix,
        text = AnnotatedString(text),
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        textStyle = textStyle
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