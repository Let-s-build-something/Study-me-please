package study.me.please.ui.components

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.FormatQuote
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import com.squadris.squadris.compose.components.DEFAULT_ANIMATION_LENGTH_SHORT
import com.squadris.squadris.compose.components.MinimalisticIcon
import com.squadris.squadris.compose.components.input.EditFieldInput
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.compose.theme.StudyMeAppTheme
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.data.io.FactIO
import study.me.please.data.io.FactType
import study.me.please.data.io.LargePathAsset
import study.me.please.ui.collection.detail.questions.detail.INPUT_DELAYED_RESPONSE_MILLIS
import study.me.please.ui.components.tab_switch.MultiChoiceSwitch
import study.me.please.ui.components.tab_switch.TabSwitchState
import study.me.please.ui.units.components.highlightedText


/** Card with the option of editing data inside */
@Composable
fun FactCard(
    modifier: Modifier = Modifier,
    thenModifier: Modifier = Modifier,
    mode: InteractiveCardMode = InteractiveCardMode.DATA_DISPLAY,
    data: FactIO?,
    hightlight: String? = null,
    onClick: () -> Unit,
    isReadOnly: Boolean = false,
    requestDataSave: (FactIO) -> Unit
) {
    Crossfade(targetState = data == null, label = "") { isShimmer ->
        if(isShimmer) {
            ShimmerLayout()
        }else if(data != null) {
            ContentLayout(
                modifier = modifier,
                thenModifier = thenModifier,
                data = data,
                hightlight = hightlight,
                isReadOnly = isReadOnly,
                mode = mode,
                requestDataSave = requestDataSave,
                onClick = {
                    onClick()
                }
            )
        }
    }
}

@Composable
private fun ContentLayout(
    modifier: Modifier,
    thenModifier: Modifier = Modifier,
    data: FactIO,
    hightlight: String? = null,
    mode: InteractiveCardMode,
    isReadOnly: Boolean = false,
    requestDataSave: (FactIO) -> Unit,
    onClick: () -> Unit,
) {
    DataCard(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(LocalTheme.shapes.componentShape),
        thenModifier = thenModifier,
        mode = mode,
        hightlight = hightlight,
        onClick = onClick,
        data = data,
        isReadOnly = isReadOnly,
        requestDataSave = {
            requestDataSave(data)
        }
    )
}

@Composable
private fun DataCard(
    modifier: Modifier = Modifier,
    thenModifier: Modifier = Modifier,
    mode: InteractiveCardMode,
    hightlight: String? = null,
    isReadOnly: Boolean = false,
    requestDataSave: () -> Unit,
    onClick: () -> Unit,
    data: FactIO
) {
    val isInEdit = mode == InteractiveCardMode.EDIT && isReadOnly.not()
    val inputScope = rememberCoroutineScope()
    val scope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current
    val shortFocusRequester = remember(data.uid) { FocusRequester() }
    val longFocusRequester = remember(data.uid) { FocusRequester() }
    val singleInputFocusRequester = remember(data.uid) { FocusRequester() }

    val selectedFactType = remember(data.type) { mutableStateOf(data.type) }
    val switchTypeState = TabSwitchState(
        selectedTabIndex = remember(data.type.ordinal) { mutableIntStateOf(data.type.ordinal) },
        tabs = arrayOfNulls<String?>(FactType.values().size).map { "" }.toMutableList(),
        onSelectionChange = { index ->
            FactType.values().getOrNull(index)?.let { factType ->
                data.type = factType
                selectedFactType.value = factType
            }
            requestDataSave()
        },
        scrollState = rememberScrollState()
    )

    val promptImage = remember(data.promptImage) { mutableStateOf(data.promptImage) }
    val listItems = remember(data.uid, data.type) {
        mutableStateListOf(
            *data.textList.ifEmpty { listOf("") }.toTypedArray()
        )
    }

    LaunchedEffect(mode) {
        if(mode == InteractiveCardMode.EDIT) {
            if(data.shortKeyInformation.isBlank()) {
                shortFocusRequester.requestFocus()
            }else {
                delay(300)
                if(listItems.size == 1 && selectedFactType.value == FactType.DEFINITION) {
                    singleInputFocusRequester.requestFocus()
                }else {
                    longFocusRequester.requestFocus()
                }
            }
        }
    }
    LaunchedEffect(listItems.size) {
        if(data.textList.size != listItems.size) {
            data.textList = listItems.toList()
            Log.d("kostka_test", "factCard listItems.size")
            requestDataSave()
        }
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 6.dp, bottom = 6.dp, start = 12.dp, end = 8.dp)
            .then(
                if (data.isEmpty && mode == InteractiveCardMode.DATA_DISPLAY) {
                    Modifier.background(
                        color = LocalTheme.colors.onBackgroundComponentContrast,
                        shape = LocalTheme.shapes.componentShape
                    )
                } else Modifier
            )
            .then(thenModifier),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            AnimatedVisibility(visible = isInEdit) {
                MinimalisticIcon(
                    imageVector = Icons.Outlined.Close,
                    tint = LocalTheme.colors.secondary,
                    onClick = onClick
                )
            }
        }
        AnimatedVisibility(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp),
            visible = isInEdit
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 2.dp, start = 4.dp),
                    text = stringResource(id = selectedFactType.value.getStringRes()),
                    fontSize = 16.sp,
                    color = LocalTheme.colors.secondary,
                    textAlign = TextAlign.Left
                )
                MultiChoiceSwitch(
                    modifier = Modifier.fillMaxWidth(),
                    state = switchTypeState,
                    onItemCreation = { modifier, index, animatedColor ->
                        FactType.values().getOrNull(index)?.getIconImageVector()?.let { imageVector ->
                            MinimalisticIcon(
                                modifier = modifier,
                                indication = null,
                                tint = animatedColor,
                                imageVector = imageVector,
                                onClick = {
                                    switchTypeState.selectedTabIndex.value = index
                                }
                            )
                        }
                    }
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 8.dp)
            ) {
                Crossfade(
                    targetState = isInEdit,
                    modifier = Modifier.animateContentSize(),
                    label = "",
                    animationSpec = tween(durationMillis = DEFAULT_ANIMATION_LENGTH_SHORT)
                ) { inEditMode ->
                    if(inEditMode) {
                        EditFieldInput(
                            modifier = Modifier.fillMaxWidth(),
                            focusRequester = shortFocusRequester,
                            prefix = if(selectedFactType.value == FactType.QUOTE) {
                                { QuoteIcon() }
                            } else null,
                            suffix = if(selectedFactType.value == FactType.QUOTE) {
                                { QuoteIcon() }
                            } else null,
                            value = data.shortKeyInformation,
                            hint = stringResource(selectedFactType.value.getShortHintStringRes()),
                            textStyle = TextStyle(
                                color = LocalTheme.colors.primary,
                                fontSize = 18.sp,
                                textAlign = TextAlign.Start,
                                fontStyle = if(selectedFactType.value == FactType.QUOTE) FontStyle.Italic else FontStyle.Normal
                            ),
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                            minLines = 1,
                            maxLines = 2,
                            identifier = data.uid
                        ) { output ->
                            data.shortKeyInformation = output
                            requestDataSave()
                        }
                    }else {
                        Crossfade(
                            targetState = selectedFactType.value == FactType.QUOTE,
                            label = "QuoteLayoutChange"
                        ) { isQuote ->
                            if(isQuote) {
                                Row(
                                    verticalAlignment = Alignment.Top
                                ) {
                                    QuoteIcon()
                                    Text(
                                        modifier = Modifier.weight(1f),
                                        text = highlightedText(
                                            highlight = hightlight ?: "",
                                            text = data.shortKeyInformation
                                        ),
                                        style = TextStyle(
                                            fontSize = 18.sp,
                                            color = LocalTheme.colors.primary,
                                            fontStyle = FontStyle.Italic
                                        ),
                                        maxLines = if(isReadOnly) Int.MAX_VALUE else 2,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    QuoteIcon()
                                }
                            }else {
                                Text(
                                    text = highlightedText(
                                        highlight = hightlight ?: "",
                                        text = data.shortKeyInformation
                                    ),
                                    style = TextStyle(
                                        fontSize = 18.sp,
                                        color = LocalTheme.colors.primary
                                    ),
                                    maxLines = if(isReadOnly) Int.MAX_VALUE else 3,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }
            }
            AnimatedVisibility(
                visible = mode == InteractiveCardMode.DATA_DISPLAY && isReadOnly.not()
            ) {
                MinimalisticIcon(
                    imageVector = Icons.Outlined.Edit,
                    tint = LocalTheme.colors.secondary,
                    onClick = onClick
                )
            }
        }

        Crossfade(
            modifier = Modifier
                .padding(top = 2.dp)
                .animateContentSize(),
            targetState = selectedFactType.value == FactType.LIST || selectedFactType.value == FactType.DEFINITION,
            label = "",
            animationSpec = tween(durationMillis = DEFAULT_ANIMATION_LENGTH_SHORT)
        ) { isListType ->
            if(isListType) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    val isIrremovable = listItems.size <= 1

                    listItems.forEachIndexed { index, listItem ->
                        Crossfade(
                            modifier = Modifier.animateContentSize(),
                            targetState = selectedFactType.value == FactType.DEFINITION && listItems.size == 1,
                            label = "SingleEditToMultipleCrossfade"
                        ) { isSingleItem ->
                            if(isSingleItem) {
                                Crossfade(
                                    targetState = isInEdit,
                                    label = "",
                                    animationSpec = tween(durationMillis = DEFAULT_ANIMATION_LENGTH_SHORT)
                                ) { inEditMode ->
                                    if(inEditMode) {
                                        EditFieldInput(
                                            modifier = Modifier
                                                .focusRequester(singleInputFocusRequester)
                                                .fillMaxWidth(),
                                            value = listItem,
                                            hint = stringResource(selectedFactType.value.getLongHintStringRes() ?: R.string.facts_type_long_fact_header),
                                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                                            keyboardActions = KeyboardActions(
                                                onNext = {
                                                    listItems.add("")
                                                    scope.launch {
                                                        delay(50)
                                                        focusManager.moveFocus(FocusDirection.Down)
                                                    }
                                                }
                                            ),
                                            onEntered = { text ->
                                                listItems.add(index + 1, text.toString())
                                                scope.launch {
                                                    delay(50)
                                                    focusManager.moveFocus(FocusDirection.Down)
                                                }
                                            },
                                            minLines = 1,
                                            maxLines = 5,
                                            identifier = "${index}_${data.uid}"
                                        ) { output ->
                                            listItems[0] = output
                                            data.textList = listOf(output)
                                            requestDataSave()
                                        }
                                    }else {
                                        BulletPoint(
                                            text = highlightedText(
                                                highlight = hightlight ?: "",
                                                text = listItem
                                            ),
                                            textStyle = LocalTheme.styles.category,
                                            maxLines = if(isReadOnly) Int.MAX_VALUE else 5,
                                            overflow = TextOverflow.Ellipsis,
                                            prefix = if(listItem.isNotEmpty()) "-" else null
                                        )
                                    }
                                }
                            }else {
                                ListItemEditField(
                                    modifier = Modifier
                                        .padding(bottom = 2.dp)
                                        .then(
                                            if (index == listItems.lastIndex) {
                                                Modifier.focusRequester(longFocusRequester)
                                            } else Modifier
                                        ),
                                    prefix = if(selectedFactType.value == FactType.DEFINITION) {
                                        FactType.BULLET_POINT_PREFIX
                                    }else "${index.plus(1)}.\t\t",
                                    identifier = "${index}_${data.uid}",
                                    onBackspaceKey = {
                                        if(isIrremovable.not()) {
                                            if(index > 0 && it.isNotBlank()) {
                                                listItems[index - 1] += it
                                            }
                                            if(listItems.size > 1 && index != 0) {
                                                focusManager.moveFocus(FocusDirection.Up)
                                            }
                                            if(it.isEmpty() || index > 0) {
                                                listItems.removeAt(index)
                                            }
                                        }
                                    },
                                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                                    keyboardActions = KeyboardActions(
                                        onNext = {
                                            listItems.add(index + 1, "")
                                            scope.launch {
                                                delay(50)
                                                focusManager.moveFocus(FocusDirection.Down)
                                            }
                                        }
                                    ),
                                    onEntered = { text ->
                                        listItems.add(index + 1, text.toString())
                                        scope.launch {
                                            delay(50)
                                            focusManager.moveFocus(FocusDirection.Down)
                                        }
                                    },
                                    hint = stringResource(
                                        if(selectedFactType.value == FactType.LIST) {
                                            R.string.list_item_generic_hint
                                        }else R.string.list_item_bulletin_hint
                                    ),
                                    value = highlightedText(
                                        highlight = hightlight ?: "",
                                        text = listItem
                                    ),
                                    enabled = isInEdit,
                                    onValueChange = { output ->
                                        if(listItems.size > index) {
                                            listItems[index] = output
                                            data.textList = listItems.toList()
                                            requestDataSave()
                                        }
                                    }
                                )
                            }
                        }
                    }
                }
            }else {
                Crossfade(
                    targetState = isInEdit,
                    label = "",
                    animationSpec = tween(durationMillis = DEFAULT_ANIMATION_LENGTH_SHORT)
                ) { inEditMode ->
                    if(inEditMode) {
                        EditFieldInput(
                            modifier = Modifier.fillMaxWidth(),
                            value = data.longInformation,
                            hint = stringResource(selectedFactType.value.getLongHintStringRes() ?: R.string.facts_type_long_fact_header),
                            minLines = 1,
                            maxLines = 5,
                            identifier = data.uid
                        ) { output ->
                            data.longInformation = output
                            requestDataSave()
                        }
                    }else {
                        BulletPoint(
                            text = data.longInformation,
                            textStyle = LocalTheme.styles.category,
                            maxLines = if(isReadOnly) Int.MAX_VALUE else 5,
                            overflow = TextOverflow.Ellipsis,
                            prefix = if(data.longInformation.isNotEmpty()) "-" else null
                        )
                    }
                }
            }
        }

        AnimatedVisibility(
            visible = isInEdit && promptImage.value == null
        ) {
            ImageAction(
                modifier = Modifier.padding(bottom = 8.dp),
                leadingImageVector = Icons.Outlined.Image,
                text = stringResource(id = R.string.button_add_prompt_image)
            ) {
                promptImage.value = LargePathAsset()
            }
        }

        //TODO refactor needed for image adding (rarely used and button takes a lot of space, ability to add image to a paragraph)
        //prompt dialog with local file/url input
        EditableImageAsset(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
                .animateContentSize(),
            asset = promptImage.value,
            isInEditMode = isInEdit,
            onUrlChange = { output ->
                inputScope.coroutineContext.cancelChildren()
                inputScope.launch {
                    delay(INPUT_DELAYED_RESPONSE_MILLIS)
                    promptImage.value = LargePathAsset(
                        urlPath = output
                    )
                    if(output.isBlank()) {
                        requestDataSave()
                    }
                }
            },
            onLoadState = { loadState ->
                if(loadState is AsyncImagePainter.State.Success) {
                    data.promptImage = promptImage.value
                    requestDataSave()
                }
            }
        )
    }
}

@Composable
private fun ShimmerLayout() {

}

@Composable
private fun QuoteIcon() {
    Icon(
        modifier = Modifier.size(24.dp),
        imageVector = Icons.Outlined.FormatQuote,
        contentDescription = null,
        tint = LocalTheme.colors.brandMain
    )
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
private fun Preview() {
    StudyMeAppTheme(isDarkTheme = true) {
        Box(modifier = Modifier.background(LocalTheme.colors.backgroundLight)) {
            FactCard(
                data = FactIO(
                    shortKeyInformation = "short key information",
                    longInformation = "",
                    type = FactType.LIST,
                    textList = listOf("item 1", "item 2", "item 3")
                ),
                onClick = {},
                requestDataSave = {},
                mode = InteractiveCardMode.EDIT,
                isReadOnly = false
            )
        }
    }
}