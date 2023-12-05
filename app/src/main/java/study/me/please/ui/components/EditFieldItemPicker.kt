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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.components.input.EditFieldInput
import com.squadris.squadris.compose.theme.LocalTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import study.me.please.R
import study.me.please.data.io.subjects.CategoryIO

/**
 * Component for finding item within provided [values]
 *
 * @param defaultValue text to be searched
 */
@Composable
fun EditFieldItemPicker(
    modifier: Modifier = Modifier,
    values: List<CategoryIO>,
    defaultValue: String,
    emptyContent: (@Composable (inputValue: String) -> Unit)? = null,
    onValueChosen: (category: CategoryIO) -> Unit,
    hint: String,
    textStyle: TextStyle = LocalTheme.styles.subheading,
    onEmptyStateClicked: (inputValue: String) -> Unit = {}
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
    val filteredValues = remember { mutableStateOf(values) }
    val isValid = remember {
        derivedStateOf {
            inputValue.isNotEmpty() && values.none { it.name == inputValue }
        }
    }
    val showAddMore = remember {
        derivedStateOf {
            filteredValues.value.isEmpty().not() && isValid.value
        }
    }

    val inputShape = if(isFocused) {
        RoundedCornerShape(
            topStart = LocalTheme.shapes.componentCornerRadius,
            topEnd = LocalTheme.shapes.componentCornerRadius,
            bottomStart = 0.dp,
            bottomEnd = 0.dp
        )
    }else LocalTheme.shapes.componentShape

    LaunchedEffect(inputValue) {
        coroutineScope.launch {
            withContext(Dispatchers.Default) {
                filteredValues.value = values.filter { value ->
                    value.name != inputValue && value.name != defaultValue
                            && Normalizer2.getNFDInstance().normalize(
                        value.name.filter { it.isWhitespace().not() }
                    ).lowercase().contains(inputValue)
                }
            }
        }
    }

    Column(modifier = modifier) {
        EditFieldInput(
            modifier = Modifier
                .widthIn(min = 40.dp)
                .height(with(localDensity) {
                    textStyle.fontSize.value.sp
                        .toDp()
                        .plus(16.dp)
                })
                .onFocusEvent { state ->
                    isFocused = state.hasFocus
                },
            shape = inputShape,
            value = inputValue,
            textStyle = textStyle,
            isUnfocusedTransparent = true,
            hint = hint,
            maxLines = 1,
            minLines = 1,
            paddingValues = PaddingValues(horizontal = 8.dp),
            onValueChange = { output ->
                inputValue = output
            }
        )
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
                item {
                    AnimatedVisibility(visible = showAddMore.value) {
                        AddMoreRow(
                            onClick = {
                                onEmptyStateClicked(inputValue)
                            }
                        )
                    }
                }
                itemsIndexed(filteredValues.value) { index, category ->
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
                                focusManager.clearFocus()
                                onValueChosen(category)
                                inputValue = category.name
                            }
                            .padding(12.dp)
                            .padding(start = 4.dp),
                        text = category.name,
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
                item {
                    AnimatedVisibility(
                        visible = filteredValues.value.isEmpty() && isValid.value
                    ) {
                        if(emptyContent == null) {
                            AddMoreRow(
                                onClick = {
                                    onEmptyStateClicked(inputValue)
                                }
                            )
                        }else emptyContent(inputValue)
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