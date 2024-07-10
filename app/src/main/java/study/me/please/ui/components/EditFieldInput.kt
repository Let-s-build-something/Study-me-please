package study.me.please.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.components.MinimalisticIcon
import com.squadris.squadris.compose.components.input.CustomTextField
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.compose.theme.SharedColors
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Styled [TextField] with ability to remove written text
 */
@Composable
fun EditFieldInput(
    modifier: Modifier = Modifier,
    value: AnnotatedString = AnnotatedString(""),
    identifier: String? = null,
    hint: String? = null,
    isError: Boolean = false,
    errorText: String? = null,
    clearable: Boolean = false,
    focusRequester: FocusRequester? = null,
    leadingIcon: ImageVector? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    minLines: Int = 1,
    maxLines: Int = 1,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    enabled: Boolean = true,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    paddingValues: PaddingValues = TextFieldDefaults.contentPaddingWithoutLabel(),
    textStyle: TextStyle = TextStyle(
        color = LocalTheme.current.colors.primary,
        fontSize = 16.sp,
        textAlign = TextAlign.Start
    ),
    isUnfocusedTransparent: Boolean = false,
    shape: Shape = LocalTheme.current.shapes.componentShape,
    maxLength: Int? = null,
    onEntered: ((value: CharSequence) -> Unit)? = null,
    onBackspaceKey: (output: String) -> Unit = {},
    onValueClear: () -> Unit = {},
    onValueChange: (AnnotatedString) -> Unit = {}
) {
    val scope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current

    val isFirstLineSelected = remember(value) { mutableStateOf(false) }
    val isFocused = remember(value) { mutableStateOf(false) }
    val selectedIndex = remember(identifier) { mutableIntStateOf(value.length) }
    val delayedSelectedIndex = remember(identifier) { mutableIntStateOf(value.length) }
    val text = remember(value) {
        mutableStateOf(TextFieldValue(value, TextRange(selectedIndex.intValue.coerceAtMost(value.length))))
    }
    val delayedOutput = remember(value) { mutableStateOf(value) }
    val controlColor by animateColorAsState(
        when {
            isError -> SharedColors.RED_ERROR
            isFocused.value -> LocalTheme.current.colors.secondary
            else -> LocalTheme.current.colors.brandMain
        },
        label = "controlColorChange"
    )

    CustomTextField(
        modifier = modifier
            .then(
                if (isUnfocusedTransparent.not()) {
                    Modifier.border(
                        if (isFocused.value) 1.dp else 0.25.dp,
                        controlColor,
                        shape
                    )
                } else Modifier
            )
            .onFocusChanged {
                isFocused.value = it.isFocused
            }
            .onKeyEvent { keyEvent ->
                when (keyEvent.key) {
                    Key.Tab -> {
                        focusManager.moveFocus(FocusDirection.Next)
                        true
                    }

                    Key.DirectionUp -> {
                        if (delayedSelectedIndex.intValue == 0) {
                            if (keyboardActions.onPrevious == null) {
                                focusManager.moveFocus(FocusDirection.Up)
                            } else {
                                keyboardActions.onPrevious?.invoke(object : KeyboardActionScope {
                                    override fun defaultKeyboardAction(imeAction: ImeAction) {}
                                }) != null
                            }
                        } else {
                            if (isFirstLineSelected.value) {
                                selectedIndex.intValue = 0
                                delayedSelectedIndex.intValue = 0
                                text.value = text.value.copy(selection = TextRange(0))
                                true
                            } else false
                        }
                    }

                    Key.Backspace -> {
                        if (delayedSelectedIndex.intValue == 0) {
                            onBackspaceKey(delayedOutput.value.text)
                            true
                        } else false
                    }

                    Key.DirectionDown -> {
                        if (delayedSelectedIndex.intValue == text.value.text.length) {
                            if (keyboardActions.onGo == null) {
                                focusManager.moveFocus(FocusDirection.Down)
                            } else {
                                keyboardActions.onGo?.invoke(object : KeyboardActionScope {
                                    override fun defaultKeyboardAction(imeAction: ImeAction) {}
                                }) != null
                            }
                        } else {
                            if (isFirstLineSelected.value) {
                                selectedIndex.intValue = text.value.text.length
                                delayedSelectedIndex.intValue = text.value.text.length
                                text.value =
                                    text.value.copy(selection = TextRange(text.value.text.length))
                                true
                            } else false
                        }
                    }

                    Key.DirectionLeft -> {
                        if (delayedSelectedIndex.intValue == 0) {
                            focusManager.moveFocus(FocusDirection.Previous)
                            true
                        } else false
                    }

                    Key.DirectionRight -> {
                        if (delayedSelectedIndex.intValue == text.value.text.length) {
                            focusManager.moveFocus(FocusDirection.Next)
                            true
                        } else false
                    }

                    Key.Enter -> {
                        if (minLines == 1) {
                            if (onEntered == null) {
                                focusManager.moveFocus(FocusDirection.Next)
                            } else {
                                onEntered.invoke(
                                    text.value.text.subSequence(
                                        text.value.selection.start.coerceAtMost(text.value.text.length),
                                        text.value.text.length
                                    )
                                )
                                val newText = text.value.text
                                    .subSequence(
                                        0,
                                        text.value.selection.start.coerceAtMost(text.value.text.length)
                                    )
                                    .toString()
                                text.value = text.value.copy(
                                    text = newText
                                )
                                onValueChange(AnnotatedString(newText))
                            }
                            true
                        } else false
                    }

                    else -> false
                }
            }
            .then(
                if (focusRequester != null) {
                    Modifier.focusRequester(focusRequester)
                } else Modifier
            ),
        prefix = prefix,
        suffix = suffix,
        isError = isError,
        onTextLayout = { result ->
            isFirstLineSelected.value = result.getLineForOffset(selectedIndex.intValue) == 0
            onTextLayout(result)
        },
        keyboardActions = keyboardActions,
        keyboardOptions = if(keyboardOptions == KeyboardOptions.Default) {
            KeyboardOptions(imeAction = ImeAction.Next)
        } else keyboardOptions,
        minLines = minLines,
        paddingValues = paddingValues,
        singleLine = maxLines == 1,
        value = text.value,
        onValueChange = { outputValue ->
            text.value = if(minLines == 1) {
                outputValue.copy(
                    selection = if(outputValue.text.contains("\n")) {
                        TextRange(outputValue.selection.start - 1, outputValue.selection.end - 1)
                    }else outputValue.selection,
                    text = outputValue.text.take(maxLength ?: outputValue.text.length)
                        .replace("\n", "")
                )
            }else {
                outputValue.copy(
                    text = outputValue.text.take(maxLength ?: outputValue.text.length)
                )
            }
            selectedIndex.intValue = outputValue.selection.end.coerceAtMost(outputValue.text.length)
            onValueChange(AnnotatedString(text.value.text))
            scope.launch {
                delay(200)
                delayedSelectedIndex.intValue = outputValue.selection.end.coerceAtMost(
                    outputValue.text.length
                )
                delayedOutput.value = AnnotatedString(outputValue.text)
            }
        },
        supportingText = if(isError && errorText?.isNotEmpty() == true) {
            {
                AnimatedVisibility(visible = errorText.isNotEmpty()) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = errorText,
                        color = controlColor
                    )
                }
            }
        }else null,
        textStyle = textStyle,
        leadingIcon = if(leadingIcon != null) {
            {
                MinimalisticIcon(
                    imageVector = leadingIcon,
                    tint = LocalTheme.current.colors.secondary
                )
            }
        }else null,
        colors = if(isUnfocusedTransparent) LocalTheme.current.styles.textFieldColorsOnFocus else LocalTheme.current.styles.textFieldColors,
        placeholder = {
            if(hint?.isNotEmpty() == true) {
                Text(
                    text = hint,
                    style = textStyle.copy(
                        color = LocalTheme.current.colors.brandMain
                    )
                )
            }
        },
        trailingIcon = if(clearable && text.value.text.isNotEmpty()) {
            {
                MinimalisticIcon(
                    contentDescription = "Clear",
                    imageVector = Icons.Outlined.Clear,
                    tint = LocalTheme.current.colors.secondary
                ) {
                    text.value = TextFieldValue("")
                    onValueChange(AnnotatedString(""))
                    onValueClear()
                }
            }
        }else null,
        enabled = enabled,
        shape = shape
    )
}

/**
 * Styled [TextField] with ability to remove written text
 */
@Composable
fun EditFieldInput(
    modifier: Modifier = Modifier,
    value: String = "",
    identifier: String? = null,
    hint: String? = null,
    isError: Boolean = false,
    errorText: String? = null,
    clearable: Boolean = false,
    focusRequester: FocusRequester? = null,
    leadingIcon: ImageVector? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    minLines: Int = 1,
    maxLines: Int = 1,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    enabled: Boolean = true,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    paddingValues: PaddingValues = TextFieldDefaults.contentPaddingWithoutLabel(),
    textStyle: TextStyle = TextStyle(
        color = LocalTheme.current.colors.primary,
        fontSize = 16.sp,
        textAlign = TextAlign.Start
    ),
    isUnfocusedTransparent: Boolean = false,
    shape: Shape = LocalTheme.current.shapes.componentShape,
    maxLength: Int? = null,
    onEntered: ((value: CharSequence) -> Unit)? = null,
    onBackspaceKey: (output: String) -> Unit = {},
    onValueClear: () -> Unit = {},
    onValueChange: (String) -> Unit = {}
) {
    EditFieldInput(
        modifier = modifier,
        value = AnnotatedString(value),
        identifier = identifier,
        hint = hint,
        isError = isError,
        errorText = errorText,
        clearable = clearable,
        focusRequester = focusRequester,
        leadingIcon = leadingIcon,
        prefix = prefix,
        suffix = suffix,
        minLines = minLines,
        maxLines = maxLines,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        enabled = enabled,
        onTextLayout = onTextLayout,
        paddingValues = paddingValues,
        textStyle = textStyle,
        isUnfocusedTransparent = isUnfocusedTransparent,
        shape = shape,
        maxLength = maxLength,
        onEntered = onEntered,
        onBackspaceKey = onBackspaceKey,
        onValueClear = onValueClear,
        onValueChange = { output ->
            onValueChange(output.text)
        }
    )
}

@Preview
@Composable
private fun Preview() {
    Box(
        modifier = Modifier
            .background(LocalTheme.current.colors.backgroundLight)
            .padding(8.dp)
    ) {
        EditFieldInput(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .background(LocalTheme.current.colors.onBackgroundComponent),
            value = "",
            hint = "hint",
            onValueChange = {}
        )
    }
}