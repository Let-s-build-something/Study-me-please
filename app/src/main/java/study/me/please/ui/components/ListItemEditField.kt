package study.me.please.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.squadris.squadris.compose.theme.LocalTheme
import study.me.please.R

/** Editable field intended for list of such items */
@Composable
fun ListItemEditField(
    modifier: Modifier = Modifier,
    value: AnnotatedString,
    enabled: Boolean = true,
    prefix: String,
    maxLines: Int = 20,
    identifier: String? = null,
    paddingValues: PaddingValues = PaddingValues(horizontal = 8.dp),
    onEntered: ((value: CharSequence) -> Unit)? = null,
    hint: String = stringResource(R.string.list_item_generic_hint),
    textStyle: TextStyle = LocalTheme.current.styles.category,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    onBackspaceKey: (output: String) -> Unit = {},
    onValueChange: (String) -> Unit = {},
) {
    val localDensity = LocalDensity.current

    val output = remember(value) { mutableStateOf(value) }
    var fieldLineCount by remember(identifier) { mutableIntStateOf(1) }
    val isFocused = remember(identifier) { mutableStateOf(false) }
    val focusRequester = remember(identifier) { FocusRequester() }

    EditFieldInput(
        modifier = modifier
            .padding(start = 16.dp)
            .wrapContentWidth()
            .animateContentSize()
            .heightIn(min = with(localDensity) {
                textStyle.fontSize
                    .toDp()
                    .plus(10.dp)
            })
            .focusRequester(focusRequester)
            .onFocusEvent { state ->
                isFocused.value = state.isFocused
            }
            .height(
                with(localDensity) {
                    textStyle.fontSize
                        .toDp()
                        .plus(1.5.dp)
                        .times(fieldLineCount)
                }
            )
            .widthIn(min = TextFieldDefaults.MinWidth),
        value = value,
        paddingValues = paddingValues,
        identifier = identifier,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        enabled = enabled,
        onEntered = onEntered,
        onBackspaceKey = onBackspaceKey,
        hint = hint,
        prefix = {
            Box(
                modifier = Modifier.fillMaxHeight(),
                contentAlignment = if(fieldLineCount > 1) Alignment.TopStart else Alignment.Center
            ) {
                Text(
                    text = prefix,
                    style = textStyle
                )
            }
        },
        textStyle = textStyle,
        isUnfocusedTransparent = true,
        minLines = 1,
        maxLines = maxLines,
        onTextLayout = { result ->
            fieldLineCount = result.lineCount
            if(result.didOverflowWidth) {
                fieldLineCount++
                if(isFocused.value) {
                    focusRequester.captureFocus()
                }
            }
        },
        onValueChange = { out ->
            output.value = out
            onValueChange(out.text)
        }
    )
}