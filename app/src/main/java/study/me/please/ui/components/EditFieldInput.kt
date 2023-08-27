package study.me.please.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.theme.AppTheme
import com.squadris.squadris.compose.theme.StudyMeAppTheme
import study.me.please.R

/**
 * Styled [TextField] with ability to remove written text
 */
@Composable
fun EditFieldInput(
    modifier: Modifier = Modifier,
    value: String = "",
    hint: String? = null,
    clearable: Boolean = false,
    leadingIcon: ImageVector? = null,
    minLines: Int = 1,
    maxLines: Int = 1,
    onValueChange: (String) -> Unit = {},
) {
    val isFocused = remember { mutableStateOf(false) }
    val shape = RoundedCornerShape(12.dp)
    val text = remember { mutableStateOf(value) }
    TextField(
        modifier = modifier
            .border(
                if(isFocused.value) 1.dp else 0.25.dp,
                if(isFocused.value) AppTheme.colors.secondary else AppTheme.colors.brandMain,
                shape
            )
            .onFocusChanged {
                isFocused.value = it.isFocused
            },
        minLines = minLines,
        maxLines = maxLines,
        value = text.value,
        onValueChange = { outputValue ->
            text.value = outputValue
            onValueChange(outputValue)
        },
        textStyle = TextStyle(
            color = AppTheme.colors.primary,
            fontSize = 16.sp
        ),
        leadingIcon = if(leadingIcon != null) {
            {
                MinimalisticIcon(imageVector = leadingIcon)
            }
        }else null,
        colors = AppTheme.styles.textFieldColors,
        placeholder = {
            if(hint?.isNotEmpty() == true) {
                Text(
                    text = hint,
                    color = AppTheme.colors.brandMain,
                    fontSize = 12.sp
                )
            }
        },
        trailingIcon = if(clearable) {
            {
                MinimalisticIcon(
                    contentDescription = stringResource(id = R.string.btn_clear_content_description),
                    imageVector = Icons.Outlined.Clear
                ) {
                    text.value = ""
                }
            }
        }else null,
        shape = shape
    )
}

@Preview
@Composable
private fun Preview() {
    StudyMeAppTheme(isDarkTheme = false) {
        Box(
            modifier = Modifier
                .background(AppTheme.colors.backgroundLight)
                .padding(8.dp)
        ) {
            EditFieldInput(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .background(AppTheme.colors.onBackgroundComponent),
                value = "",
                hint = "hint",
                onValueChange = {}
            )
        }
    }
}