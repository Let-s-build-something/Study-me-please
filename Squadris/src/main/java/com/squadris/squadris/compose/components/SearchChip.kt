package com.squadris.squadris.compose.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.isImeVisible
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.components.input.EditFieldInput
import com.squadris.squadris.compose.theme.LocalTheme

private const val PERCENTAGE_OF_SCREEN_WIDTH = 0.3f

/** Chip for searching text */
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SearchChip(
    modifier: Modifier = Modifier,
    imageVector: ImageVector = Icons.Outlined.Search,
    maxHeight: TextUnit = 32.sp,
    enabled: Boolean = true,
    text: String,
    isChecked: MutableState<Boolean> = mutableStateOf(false),
    isFieldError: MutableState<Boolean> = mutableStateOf(false),
    extraContent: @Composable RowScope.() -> Unit = {},
    onSearchOutput: (String) -> Unit,
    onClick: () -> Unit
) {
    val isImeVisible = WindowInsets.isImeVisible
    val localDensity = LocalDensity.current
    val configuration = LocalConfiguration.current
    val focusRequester = FocusRequester()

    val isFocused = remember { mutableStateOf(false) }
    val fieldOutput = rememberSaveable(text) { mutableStateOf(text) }

    LaunchedEffect(isChecked.value) {
        if(isChecked.value) {
            focusRequester.requestFocus()
        }
    }
    LaunchedEffect(isImeVisible) {
        if(isImeVisible.not() && fieldOutput.value.isEmpty()) {
            isChecked.value = false
        }
    }

    Row(
        modifier = modifier
            .padding(vertical = 8.dp, horizontal = if (isChecked.value) 8.dp else 4.dp)
            .height(with(localDensity) { maxHeight.toDp() })
            .widthIn(min = with(localDensity) { maxHeight.toDp() })
            .background(
                color = LocalTheme.colors.brandMain,
                shape = LocalTheme.shapes.chipShape
            )
            .focusRequester(focusRequester)
            .onFocusEvent { state ->
                if (fieldOutput.value.isEmpty() && isChecked.value && state.hasFocus.not() && isFocused.value) {
                    isChecked.value = false
                } else {
                    isFocused.value = state.hasFocus
                }
            }
            .clip(LocalTheme.shapes.chipShape)
            .clickable(
                enabled = enabled,
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple()
            ),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .size(18.dp),
            imageVector = imageVector,
            tint = LocalTheme.colors.tetrial,
            contentDescription = null
        )
        Crossfade(
            modifier = Modifier.animateContentSize(),
            targetState = isChecked.value,
            label = "crossFadeSearchChip"
        ) { isInEdit ->
            if(isInEdit) {
                EditFieldInput(
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .widthIn(
                            min = configuration.screenWidthDp.times(
                                PERCENTAGE_OF_SCREEN_WIDTH
                            ).dp
                        ),
                    value = AnnotatedString(text),
                    paddingValues = PaddingValues(start = 8.dp),
                    minLines = 1,
                    maxLines = 1,
                    textStyle = TextStyle(
                        color = LocalTheme.colors.primary,
                        fontSize = 16.sp
                    ),
                    isError = isFieldError.value,
                    shape = LocalTheme.shapes.circularActionShape,
                    clearable = true,
                    onValueClear = {
                        isChecked.value = false
                    }
                ) { output ->
                    fieldOutput.value = output.text
                    onSearchOutput(output.text)
                    isFieldError.value = false
                }
            }else {
                AnimatedVisibility(visible = fieldOutput.value.isNotEmpty()) {
                    Text(
                        text = fieldOutput.value,
                        style = TextStyle(
                            color = LocalTheme.colors.primary,
                            fontSize = 16.sp
                        ),
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }
        }
        extraContent()
    }
}