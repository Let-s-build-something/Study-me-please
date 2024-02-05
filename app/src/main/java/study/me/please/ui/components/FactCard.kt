@file:OptIn(ExperimentalMaterial3Api::class)

package study.me.please.ui.components

import android.annotation.SuppressLint
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
import androidx.compose.material3.ExperimentalMaterial3Api
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
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.data.io.FactIO
import study.me.please.data.io.FactType
import study.me.please.data.io.LargePathAsset
import study.me.please.data.io.subjects.CategoryIO
import study.me.please.ui.collection.detail.questions.detail.INPUT_DELAYED_RESPONSE_MILLIS
import study.me.please.ui.components.tab_switch.MultiChoiceSwitch
import study.me.please.ui.components.tab_switch.TabSwitchState


/** Card with the option of editing data inside */
@Composable
fun FactCard(
    modifier: Modifier = Modifier,
    mode: InteractiveCardMode = InteractiveCardMode.DATA_DISPLAY,
    data: FactIO?,
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
                data = data,
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

/** Card with the option of editing data inside */
@Composable
fun FactCard(
    modifier: Modifier = Modifier,
    state: InteractiveCardState = rememberInteractiveCardState(),
    data: FactIO?,
    isReadOnly: Boolean = false,
    requestDataSave: (FactIO) -> Unit
) {
    Crossfade(targetState = data == null, label = "") { isShimmer ->
        if(isShimmer) {
            ShimmerLayout()
        }else if(data != null) {
            ContentLayout(
                modifier = modifier,
                data = data,
                isReadOnly = isReadOnly,
                mode = state.mode.value,
                requestDataSave = requestDataSave,
                onClick = {
                    when(state.mode.value) {
                        InteractiveCardMode.CHECKING -> {
                            state.isChecked.value = state.isChecked.value.not()
                        }
                        InteractiveCardMode.DATA_DISPLAY -> {
                            state.mode.value = InteractiveCardMode.EDIT
                        }
                        else -> {}
                    }
                }
            )
        }
    }
}

@Composable
private fun ContentLayout(
    modifier: Modifier,
    data: FactIO,
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
        mode = mode,
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
    mode: InteractiveCardMode,
    isReadOnly: Boolean = false,
    requestDataSave: () -> Unit,
    onClick: () -> Unit,
    data: FactIO
) {
    val isInEdit = mode == InteractiveCardMode.EDIT && isReadOnly.not()
    val inputScope = rememberCoroutineScope()
    val scope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current

    val selectedFactType = remember(data) { mutableStateOf(data.type) }
    val switchTypeState = TabSwitchState(
        selectedTabIndex = remember(data) { mutableIntStateOf(data.type.ordinal) },
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

    val promptImage = remember(data) { mutableStateOf(data.promptImage) }
    val selectedListIndex = remember(data) { mutableIntStateOf(-1) }
    val listItems = remember { mutableStateListOf<String>() }

    LaunchedEffect(selectedFactType.value) {
        if(selectedFactType.value == FactType.BULLET_POINTS || selectedFactType.value == FactType.LIST) {
            listItems.clear()
            listItems.addAll(data.textList)
        }
    }
    LaunchedEffect(listItems.size) {
        data.textList = listItems.toList()
        requestDataSave()
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 6.dp, bottom = 6.dp, start = 12.dp, end = 8.dp)
            .then(
                if (data.isEmpty && mode == InteractiveCardMode.DATA_DISPLAY) {
                    Modifier.background(
                        color = LocalTheme.colors.onBackgroundComponent,
                        shape = LocalTheme.shapes.componentShape
                    )
                } else Modifier
            ),
        horizontalAlignment = Alignment.Start
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
            verticalAlignment = Alignment.Top
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
                            prefix = if(selectedFactType.value == FactType.QUOTE) { { QuoteIcon() } }else null,
                            suffix = if(selectedFactType.value == FactType.QUOTE) { { QuoteIcon() } }else null,
                            value = data.shortKeyInformation,
                            hint = stringResource(id = selectedFactType.value.getShortHintStringRes()),
                            textStyle = TextStyle(
                                color = LocalTheme.colors.primary,
                                fontSize = 18.sp,
                                textAlign = TextAlign.Start,
                                fontStyle = if(selectedFactType.value == FactType.QUOTE) FontStyle.Italic else FontStyle.Normal
                            ),
                            minLines = 2,
                            maxLines = 2
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
                                        text = data.shortKeyInformation,
                                        style = TextStyle(
                                            fontSize = 18.sp,
                                            color = LocalTheme.colors.primary,
                                            fontStyle = FontStyle.Italic
                                        ),
                                        maxLines = 2,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    QuoteIcon()
                                }
                            }else {
                                Text(
                                    text = data.shortKeyInformation,
                                    style = TextStyle(
                                        fontSize = 18.sp,
                                        color = LocalTheme.colors.primary
                                    ),
                                    maxLines = if(isReadOnly) Int.MAX_VALUE else 2,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }
            }
            AnimatedVisibility(
                visible = mode == InteractiveCardMode.DATA_DISPLAY
            ) {
                MinimalisticIcon(
                    imageVector = Icons.Outlined.Edit,
                    tint = LocalTheme.colors.secondary,
                    onClick = onClick
                )
            }
        }

        EditableImageAsset(
            modifier = Modifier
                .wrapContentHeight()
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
                }
                if(output.isEmpty()) {
                    requestDataSave()
                }
            },
            onLoadState = { loadState ->
                if(loadState is AsyncImagePainter.State.Success) {
                    data.promptImage = promptImage.value
                    requestDataSave()
                }
            }
        )
        AnimatedVisibility(
            visible = isInEdit && promptImage.value == null
        ) {
            ImageAction(
                leadingImageVector = Icons.Outlined.Image,
                text = stringResource(id = R.string.button_add_prompt_image)
            ) {
                promptImage.value = LargePathAsset()
            }
        }

        Crossfade(
            targetState = data.type == FactType.LIST || data.type == FactType.BULLET_POINTS,
            modifier = Modifier
                .padding(top = 8.dp)
                .animateContentSize(),
            label = "",
            animationSpec = tween(durationMillis = DEFAULT_ANIMATION_LENGTH_SHORT)
        ) { isListType ->
            if(isListType) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    AnimatedVisibility(
                        modifier = Modifier
                            .padding(4.dp)
                            .fillMaxWidth(),
                        visible = isInEdit
                    ) {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            ComponentHeaderButton(
                                onClick = {
                                    listItems.add(0, "")
                                    selectedListIndex.intValue = listItems.size.minus(1)
                                }
                            )
                        }
                    }
                    listItems.forEachIndexed { index, listItem ->
                        ListItemEditField(
                            prefix = if(selectedFactType.value == FactType.BULLET_POINTS) {
                                FactType.BULLET_POINT_PREFIX
                            }else "${index.plus(1)}.\t\t",
                            onBackspaceKey = {
                                if(it.isEmpty()) {
                                    if(index > 0) {
                                        focusManager.moveFocus(FocusDirection.Up)
                                    }
                                    listItems.removeAt(index)
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
                            value = listItem,
                            enabled = isInEdit,
                            onValueChange = { output ->
                                listItems[index] = output
                                data.textList = listItems.toList()
                                requestDataSave()
                            }
                        )
                    }
                }
            }else {
                Crossfade(
                    targetState = isInEdit,
                    label = "",
                    animationSpec = tween(durationMillis = DEFAULT_ANIMATION_LENGTH_SHORT)
                ) { inEditMode ->
                    if(inEditMode) {
                        val hint = selectedFactType.value.getLongHintStringRes()
                        EditFieldInput(
                            modifier = Modifier.fillMaxWidth(),
                            value = data.longInformation,
                            hint = if(hint != null) stringResource(hint) else "",
                            minLines = 5,
                            maxLines = 5
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
                            prefix = if(isReadOnly) "-" else null
                        )
                    }
                }
            }
        }
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

/** Use case for categorizing facts */
interface FactCardCategoryUseCase {

    /** List of all current categories */
    val categories: StateFlow<List<CategoryIO>?>

    /** Requests for a new category */
    fun requestAddNewCategory(category: CategoryIO)

    /** Makes a request for all existing categories */
    fun requestAllCategories()
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
private fun Preview() {
    StudyMeAppTheme(isDarkTheme = true) {
        Box(modifier = Modifier.background(LocalTheme.colors.backgroundLight)) {
            FactCard(
                data = FactIO(
                    shortKeyInformation = "",
                    longInformation = ""
                ),
                requestDataSave = {},
                state = InteractiveCardState(
                    mode = mutableStateOf(InteractiveCardMode.DATA_DISPLAY)
                ),
                isReadOnly = false
            )
        }
    }
}