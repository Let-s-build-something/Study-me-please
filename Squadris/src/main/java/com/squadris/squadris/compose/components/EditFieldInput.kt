package com.squadris.squadris.compose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.theme.Colors
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.compose.theme.StudyMeAppTheme

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
    paddingValues: PaddingValues = TextFieldDefaults.contentPaddingWithoutLabel(),
    textStyle: TextStyle = TextStyle(
        color = LocalTheme.colors.primary,
        fontSize = 16.sp
    ),
    shape: Shape = LocalTheme.shapes.componentShape,
    maxLength: Int? = null,
    onValueClear: () -> Unit = {},
    onValueChange: (String) -> Unit = {},
) {
    val isFocused = remember(value) { mutableStateOf(false) }
    val text = remember(value) { mutableStateOf(value) }
    LaunchedEffect(key1 = value) {
        text.value = value
    }
    CustomTextField(
        modifier = modifier
            .border(
                if (isFocused.value) 1.dp else 0.25.dp,
                if (isError) {
                    Colors.RED_ERROR
                } else if (isFocused.value) {
                    LocalTheme.colors.secondary
                } else LocalTheme.colors.brandMain,
                shape
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
        paddingValues = paddingValues,
        singleLine = maxLines == 1,
        value = text.value,
        onValueChange = { outputValue ->
            if(maxLength == null || outputValue.length <= maxLength) {
                text.value = outputValue
                onValueChange(outputValue)
            }
        },
        textStyle = textStyle,
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
                    fontSize = 16.sp
                )
            }
        },
        trailingIcon = if(clearable && text.value.isNotEmpty()) {
            {
                MinimalisticIcon(
                    contentDescription = "Clear",
                    imageVector = Icons.Outlined.Clear
                ) {
                    text.value = ""
                    onValueChange("")
                    onValueClear()
                }
            }
        }else null,
        shape = shape
    )
}

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