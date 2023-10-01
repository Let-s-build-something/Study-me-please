package study.me.please.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.compose.theme.Colors
import com.squadris.squadris.compose.theme.StudyMeAppTheme
import study.me.please.R

@Composable
fun rememberEditFieldInputState(
    initialValue: String
): EditFieldInputState {
    val scope = rememberCoroutineScope()
    val state = remember(scope) {
        EditFieldInputState(initialValue = initialValue)
    }
    return state
}

data class EditFieldInputState(
    val initialValue: String
) {
    val currentValue = mutableStateOf(initialValue)
}

/**
 * Styled [TextField] with ability to remove written text
 */
@Composable
fun EditFieldInput(
    modifier: Modifier = Modifier,
    value: String = "",
    hint: String? = null,
    isError: Boolean = false,
    clearable: Boolean = false,
    focusRequester: FocusRequester? = null,
    leadingIcon: ImageVector? = null,
    minLines: Int = 1,
    maxLines: Int = 1,
    maxLength: Int? = null,
    onValueChange: (String) -> Unit = {},
) {
    val isFocused = remember(value) { mutableStateOf(false) }
    val text = remember(value) { mutableStateOf(value) }
    LaunchedEffect(key1 = value) {
        text.value = value
    }
    TextField(
        modifier = modifier
            .border(
                if (isFocused.value) 1.dp else 0.25.dp,
                if (isError) {
                    Colors.RED_ERROR
                } else if (isFocused.value) {
                    LocalTheme.colors.secondary
                } else LocalTheme.colors.brandMain,
                LocalTheme.shapes.componentShape
            )
            .onFocusChanged {
                isFocused.value = it.isFocused
            }
            .then(
                if (focusRequester != null) {
                    Modifier.focusRequester(focusRequester)
                } else Modifier
            ),
        isError = isError,
        minLines = minLines,
        maxLines = maxLines,
        singleLine = maxLines == 1,
        value = text.value,
        onValueChange = { outputValue ->
            if(maxLength == null || outputValue.length <= maxLength) {
                text.value = outputValue
                onValueChange(outputValue)
            }
        },
        textStyle = TextStyle(
            color = LocalTheme.colors.primary,
            fontSize = 16.sp
        ),
        leadingIcon = if(leadingIcon != null) {
            {
                MinimalisticIcon(imageVector = leadingIcon)
            }
        }else null,
        colors = LocalTheme.styles.textFieldColors,
        placeholder = {
            if(hint?.isNotEmpty() == true) {
                Text(
                    text = hint,
                    color = LocalTheme.colors.brandMain,
                    fontSize = 12.sp
                )
            }
        },
        trailingIcon = if(clearable && text.value.isNotEmpty()) {
            {
                MinimalisticIcon(
                    contentDescription = stringResource(id = R.string.btn_clear_content_description),
                    imageVector = Icons.Outlined.Clear
                ) {
                    text.value = ""
                    onValueChange("")
                }
            }
        }else null,
        shape = LocalTheme.shapes.componentShape
    )
}

@Preview
@Composable
private fun Preview() {
    StudyMeAppTheme(isDarkTheme = false) {
        Box(
            modifier = Modifier
                .background(LocalTheme.colors.backgroundLight)
                .padding(8.dp)
        ) {
            EditFieldInput(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .background(LocalTheme.colors.onBackgroundComponent),
                value = "",
                hint = "hint",
                onValueChange = {}
            )
        }
    }
}