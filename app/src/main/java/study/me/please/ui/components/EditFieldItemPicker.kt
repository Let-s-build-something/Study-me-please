package study.me.please.ui.components

import android.icu.text.Normalizer2
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.components.input.EditFieldInput
import com.squadris.squadris.compose.theme.LocalTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import study.me.please.R

/**
 * Component for finding item within provided [values]
 *
 * @param defaultValue text to be searched
 */
@Composable
fun EditFieldItemPicker(
    modifier: Modifier = Modifier,
    values: Map<String, Int>,
    defaultValue: AnnotatedString,
    onFocusLost: () -> Unit = {},
    onValueChanged: (String) -> Unit,
    hint: String,
    enabled: Boolean = true,
    textStyle: TextStyle = LocalTheme.styles.subheading
) {
    val listShape = RoundedCornerShape(
        topStart = 0.dp,
        topEnd = LocalTheme.shapes.componentCornerRadius,
        bottomStart = LocalTheme.shapes.componentCornerRadius,
        bottomEnd = LocalTheme.shapes.componentCornerRadius
    )
    val coroutineScope = rememberCoroutineScope()
    val localDensity = LocalDensity.current
    val localConfiguration = LocalConfiguration.current
    val focusManager = LocalFocusManager.current

    var inputValue by remember(defaultValue) { mutableStateOf(defaultValue) }
    var isFocused by remember { mutableStateOf(false) }
    val filteredValues = remember { mutableStateOf(values.keys.toList()) }

    val normalizer = remember { Normalizer2.getNFDInstance() }

    LaunchedEffect(inputValue) {
        coroutineScope.launch {
            withContext(Dispatchers.Default) {
                /*filteredValues.value = values.filter { (key, _) ->
                    key != defaultValue && normalizer
                        .normalize(key.filterNot(Char::isWhitespace)).lowercase().contains(
                            normalizer.normalize(inputValue.filterNot(Char::isWhitespace)).lowercase()
                        )
                }.toList()
                    .sortedByDescending { it.second }
                    .take(4)
                    .map { it.first }*/

                filteredValues.value = values.asSequence()
                    .filter {
                        it.key != inputValue.text && normalizer
                            .normalize(it.key.filterNot(Char::isWhitespace)).lowercase().contains(
                                normalizer.normalize(inputValue.filterNot(Char::isWhitespace)).lowercase()
                            )
                    }
                    .sortedByDescending { it.value }
                    .take(4)
                    .map { it.key }
                    .toList()
            }
        }
    }

    var previousFocusState = false
    Column(modifier = modifier) {
        val lineCount = remember {
            mutableStateOf<Int?>(null)
        }

        EditFieldInput(
            modifier = Modifier
                .widthIn(min = 40.dp)
                .height(with(localDensity) {
                    textStyle.fontSize.value.sp
                        .toDp()
                        .times(lineCount.value ?: 1)
                        .plus(16.dp)
                })
                .onFocusEvent { state ->
                    if (state.hasFocus.not() && previousFocusState) {
                        onFocusLost()
                    }
                    previousFocusState = state.hasFocus
                    isFocused = state.hasFocus
                },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            value = inputValue,
            textStyle = textStyle,
            isUnfocusedTransparent = true,
            onTextLayout = { result ->
                if(result.didOverflowWidth) {
                    lineCount.value = result.lineCount
                        .plus(1)
                        .coerceAtMost(3)
                }else {
                    lineCount.value = result.lineCount.coerceAtMost(3)
                }
            },
            hint = if(enabled) hint else "",
            enabled = enabled,
            // only if needed, so it doesn't get pushed up
            maxLines = 3,
            minLines = 1,
            paddingValues = PaddingValues(horizontal = 8.dp),
            onValueChange = { output ->
                inputValue = output
                onValueChanged(output.text)
            }
        )
        //TODO richtooltip?
        AnimatedVisibility(visible = isFocused && inputValue.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier
                    .background(
                        color = LocalTheme.colors.backgroundLight,
                        shape = listShape
                    )
                    .fillMaxWidth(0.5f)
                    .heightIn(max = localConfiguration.screenHeightDp.div(4).dp)
            ) {
                itemsIndexed(filteredValues.value) { index, name ->
                    Column {
                        if(index == 0) {
                            HorizontalDivider(
                                modifier = Modifier.padding(horizontal = 12.dp),
                                thickness = 1.dp,
                                color = LocalTheme.colors.backgroundLight
                            )
                        }
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable(
                                    indication = rememberRipple(bounded = true),
                                    interactionSource = remember { MutableInteractionSource() }
                                ) {
                                    inputValue = AnnotatedString(name)
                                    focusManager.clearFocus()
                                    onValueChanged(name)
                                }
                                .padding(12.dp)
                                .padding(start = 4.dp),
                            text = name,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = LocalTheme.styles.category
                        )
                        if(filteredValues.value.lastIndex != index) {
                            HorizontalDivider(
                                modifier = Modifier.padding(horizontal = 12.dp),
                                thickness = 1.dp,
                                color = LocalTheme.colors.secondary
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun AddMoreRow(onClick: () -> Unit) {
    val focusManager = LocalFocusManager.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                indication = rememberRipple(),
                interactionSource = remember { MutableInteractionSource() },
                onClick = {
                    onClick()
                    focusManager.clearFocus()
                }
            )
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(LocalTheme.shapes.betweenItemsSpace)
    ) {
        Icon(
            modifier = Modifier.sizeIn(minHeight = 24.dp, minWidth = 24.dp),
            imageVector = Icons.Outlined.Add,
            contentDescription = null,
            tint = LocalTheme.colors.primary
        )
        Text(
            text = stringResource(R.string.edit_field_item_picked_create),
            style = LocalTheme.styles.category
        )
    }
}