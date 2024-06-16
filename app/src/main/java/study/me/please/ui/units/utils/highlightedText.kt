package study.me.please.ui.units.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.squadris.squadris.compose.theme.SharedColors

/** Build an [AnnotatedString] with given highlight */
@Composable
fun highlightedText(
    highlight: String,
    text: String
): AnnotatedString {
    return buildAnnotatedString {
        if(highlight.isNotBlank() && text.lowercase().contains(highlight.lowercase())) {
            var textLeft = text

            while(textLeft.isNotEmpty()) {
                val index = textLeft.lowercase().indexOf(highlight.lowercase())

                if(index != -1) {
                    append(textLeft.substring(0, index))
                    withStyle(style = SpanStyle(
                        fontWeight = FontWeight.ExtraBold,
                        color = SharedColors.GREEN_CORRECT
                    )
                    ) {
                        append(textLeft.substring(index, index + highlight.length))
                    }
                    textLeft = textLeft.substring(index + highlight.length, textLeft.length)
                }else {
                    append(textLeft)
                    textLeft = ""
                }
            }
        }else {
            append(text)
        }
    }
}