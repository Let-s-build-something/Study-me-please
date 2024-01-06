@file:OptIn(ExperimentalMaterial3Api::class)

package study.me.please.ui.components

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.FormatQuote
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material.icons.outlined.QuestionMark
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.PlainTooltipBox
import androidx.compose.material3.PlainTooltipState
import androidx.compose.material3.RichTooltipBox
import androidx.compose.material3.RichTooltipColors
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.rememberPlainTooltipState
import androidx.compose.material3.rememberRichTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupPositionProvider
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImagePainter
import com.squadris.squadris.compose.components.ChipState
import com.squadris.squadris.compose.components.CustomChipGroup
import com.squadris.squadris.compose.components.DEFAULT_ANIMATION_LENGTH_SHORT
import com.squadris.squadris.compose.components.MinimalisticIcon
import com.squadris.squadris.compose.components.input.EditFieldInput
import com.squadris.squadris.compose.theme.Colors
import com.squadris.squadris.compose.theme.LocalTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import study.me.please.R
import study.me.please.data.io.FactIO
import study.me.please.data.io.FactType
import study.me.please.data.io.LargePathAsset
import study.me.please.data.io.subjects.CategoryIO
import study.me.please.ui.collection.detail.questions.detail.INPUT_DELAYED_RESPONSE_MILLIS
import study.me.please.ui.components.tab_switch.MultiChoiceSwitch
import study.me.please.ui.components.tab_switch.rememberTabSwitchState

/** Card with the option of editing data inside */
@Composable
fun FactCard(
    modifier: Modifier = Modifier,
    state: InteractiveCardState = rememberInteractiveCardState(),
    data: FactIO?,
    categoryUseCase: FactCardCategoryUseCase,
    requestDataSave: (FactIO) -> Unit
) {
    Crossfade(targetState = data == null, label = "") { isShimmer ->
        if(isShimmer) {
            ShimmerLayout()
        }else if(data != null) {
            ContentLayout(
                modifier = modifier,
                data = data,
                state = state,
                categoryUseCase = categoryUseCase,
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
                },
                onLongClick = {
                    state.isChecked.value = true
                }
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ContentLayout(
    modifier: Modifier,
    data: FactIO,
    state: InteractiveCardState,
    categoryUseCase: FactCardCategoryUseCase,
    requestDataSave: (FactIO) -> Unit,
    onClick: () -> Unit,
    onLongClick: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(LocalTheme.shapes.componentShape)
            .combinedClickable(
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = rememberRipple(
                    bounded = true
                ),
                onClick = onClick,
                onLongClick = onLongClick
            ),
        elevation = LocalTheme.styles.cardClickableElevation,
        shape = LocalTheme.shapes.componentShape,
        colors = CardDefaults.cardColors(
            containerColor = LocalTheme.colors.onBackgroundComponentContrast,
            contentColor = LocalTheme.colors.onBackgroundComponentContrast
        )
    ) {
        DataCard(
            state = state,
            data = data,
            categoryUseCase = categoryUseCase,
            requestDataSave = {
                requestDataSave(data)
            }
        )
    }
}

@Composable
private fun DataCard(
    modifier: Modifier = Modifier,
    state: InteractiveCardState,
    categoryUseCase: FactCardCategoryUseCase,
    requestDataSave: () -> Unit,
    data: FactIO
) {
    val coroutineScope = rememberCoroutineScope()

    val showAddNewCategory = remember { mutableStateOf(false) }

    val categories = categoryUseCase.categories.collectAsState()
    val chosenCategories = remember(data) {
        mutableStateListOf(
            *categories.value?.filter { data.categoryUids.contains(it.uid) }.orEmpty().toTypedArray()
        )
    }
    val newCategories = remember(data) {
        derivedStateOf {
            categories.value.orEmpty().filter { chosenCategories.contains(it).not() }
        }
    }
    val categoryChips = remember {
        mutableStateListOf<ChipState>()
    }

    LaunchedEffect(chosenCategories.size) {
        withContext(Dispatchers.Default) {
            if(categories.value != null) {
                data.categoryUids = chosenCategories.toList().map { it.uid }
                requestDataSave()
                categoryChips.clear()
                categoryChips.addAll(chosenCategories.map { category ->
                    ChipState(
                        uid = category.uid,
                        chipText = mutableStateOf(category.name),
                        isChecked = mutableStateOf(false),
                        isCheckable = false,
                        onChipPressed = {
                            if(state.mode.value == InteractiveCardMode.EDIT) {
                                chosenCategories.removeIf { it.uid == category.uid }
                            }
                        }
                    )
                })
            }
        }
    }
    LaunchedEffect(categories.value) {
        withContext(Dispatchers.Default) {
            chosenCategories.clear()
            chosenCategories.addAll(
                categories.value?.filter { data.categoryUids.contains(it.uid) }.orEmpty()
            )
        }
    }
    LaunchedEffect(state.mode.value) {
        if(state.mode.value != InteractiveCardMode.EDIT) {
            showAddNewCategory.value = false
        }
    }

    val selectedFactType = remember { mutableStateOf(data.type) }
    val switchTypeState = rememberTabSwitchState(
        selectedTabIndex = remember(data) { mutableIntStateOf(data.type.ordinal) },
        tabs = arrayOfNulls<String?>(FactType.values().size).map { "" }.toMutableList(),
        onSelectionChange = { index ->
            FactType.values().getOrNull(index)?.let { factType ->
                data.type = factType
                selectedFactType.value = factType
            }
            requestDataSave()
        }
    )
    val showCheckbox = state.mode.value == InteractiveCardMode.CHECKING
    val showRightAction = state.mode.value == InteractiveCardMode.DATA_DISPLAY
            || state.mode.value == InteractiveCardMode.EDIT

    val promptImage = remember(data) { mutableStateOf(data.promptImage) }
    val selectedListIndex = remember(data) { mutableIntStateOf(-1) }
    val listItems = remember(data) { mutableStateListOf<String>() }

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

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        AnimatedVisibility(visible = state.mode.value == InteractiveCardMode.EDIT) {
            Crossfade(targetState = showAddNewCategory, label = "") { showInput ->
                if(showInput.value) {
                    EditFieldItemPicker(
                        modifier = Modifier
                            .padding(start = 8.dp, top = 4.dp)
                            .zIndex(1f),
                        values = newCategories.value,
                        defaultValue = "",
                        onValueChosen = { chosenCategory ->
                            showAddNewCategory.value = false
                            chosenCategories.add(chosenCategory)
                        },
                        hint = stringResource(R.string.subject_categorize_paragraph),
                        onEmptyStateClicked = { inputValue ->
                            categoryUseCase.requestAddNewCategory(inputValue)
                        },
                        onFocusLost = {
                            showAddNewCategory.value = false
                        }
                    )
                }else {
                    ComponentHeaderButton(
                        modifier = Modifier.padding(start = 8.dp, top = 4.dp),
                        text = stringResource(R.string.tags_add_new),
                        onClick = {
                            showAddNewCategory.value = true
                        }
                    )
                }
            }
        }
        AnimatedVisibility(
            visible = (categories.value?.size ?: 6) < 5 && state.mode.value == InteractiveCardMode.EDIT
        ) {
            val tooltipState = rememberRichTooltipState(isPersistent = true)
            RichTooltipBox(
                tooltipState = tooltipState,
                text = {
                    Text(
                        stringResource(R.string.tags_explanation),
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color.White
                        )
                    )
                },
                colors = RichTooltipColors(
                    containerColor = LocalTheme.colors.backgroundLight,
                    contentColor = Color.White,
                    titleContentColor = Color.White,
                    actionContentColor = Color.White
                )
            ) {
                Icon(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .size(24.dp)
                        .background(color = LocalTheme.colors.tetrial, shape = CircleShape)
                        .tooltipTrigger()
                        .clip(CircleShape)
                        .clickable(
                            onClick = {
                                coroutineScope.launch {
                                    tooltipState.show()
                                }
                            },
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple()
                        )
                        .padding(4.dp),
                    imageVector = Icons.Outlined.QuestionMark,
                    contentDescription = null,
                    tint = Colors.DARK_GREY
                )
            }
        }

        AnimatedVisibility(visible = categoryChips.isNotEmpty()) {
            CustomChipGroup(
                chips = categoryChips
            )
        }
    }

    ConstraintLayout(
        modifier = modifier
            .padding(vertical = 10.dp, horizontal = 12.dp)
            .fillMaxWidth()
    ) {
        val (checkBox,
            imgRightAction,
            txtShortInformationHeader,
            txtShortInformation,
            txtLongInformationHeader,
            txtLongInformation,
            imgLongImage,
            btnAddLongImage,
            switchType
        ) = createRefs()

        AnimatedVisibility(
            modifier = Modifier.constrainAs(checkBox) {
                start.linkTo(parent.start, (-8).dp)
                top.linkTo(parent.top, (-12).dp)
            },
            visible = showCheckbox
        ) {
            Checkbox(
                checked = state.isChecked.value,
                onCheckedChange = { isChecked ->
                    state.isChecked.value = isChecked
                },
                colors = LocalTheme.styles.checkBoxColorsDefault
            )
        }

        AnimatedVisibility(
            modifier = Modifier
                .constrainAs(imgRightAction) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                },
            visible = showRightAction
        ) {
            Crossfade(
                targetState = state.mode.value == InteractiveCardMode.EDIT,
                label = "",
                animationSpec = tween(durationMillis = DEFAULT_ANIMATION_LENGTH_SHORT)
            ) { isClose ->
                if(isClose) {
                    MinimalisticIcon(
                        imageVector = Icons.Outlined.Close,
                        tint = LocalTheme.colors.secondary
                    ) {
                        state.mode.value = InteractiveCardMode.DATA_DISPLAY
                    }
                }else {
                    MinimalisticIcon(
                        imageVector = Icons.Outlined.Edit,
                        tint = LocalTheme.colors.secondary
                    ) {
                        state.mode.value = InteractiveCardMode.EDIT
                    }
                }
            }
        }

        AnimatedVisibility(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(switchType) {
                    top.linkTo(parent.top, 6.dp)
                    linkTo(txtShortInformationHeader.start, txtShortInformationHeader.end)
                    width = Dimension.fillToConstraints
                },
            visible = state.mode.value == InteractiveCardMode.EDIT
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
            ) {
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

        Text(
            modifier = Modifier
                .constrainAs(txtShortInformationHeader) {
                    linkTo(
                        if (showCheckbox) checkBox.end else parent.start,
                        if (showRightAction) imgRightAction.start else parent.end,
                        bias = 0f
                    )
                    top.linkTo(switchType.bottom, 8.dp)
                    width = Dimension.fillToConstraints
                },
            text = stringResource(selectedFactType.value.getShortHeaderStringRes()),
            fontSize = 12.sp,
            color = LocalTheme.colors.secondary
        )

        val inputScope = rememberCoroutineScope()
        Crossfade(
            targetState = state.mode.value == InteractiveCardMode.EDIT,
            modifier = Modifier
                .animateContentSize()
                .constrainAs(txtShortInformation) {
                    linkTo(txtShortInformationHeader.start, txtShortInformationHeader.end)
                    top.linkTo(txtShortInformationHeader.bottom, 2.dp)
                    width = Dimension.fillToConstraints
                },
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
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }

        val longHeaderRes = selectedFactType.value.getLongHeaderStringRes()
        Text(
            modifier = Modifier
                .constrainAs(txtLongInformationHeader) {
                    linkTo(txtShortInformationHeader.start, txtShortInformationHeader.end, bias = 0f)
                    top.linkTo(txtShortInformation.bottom, 6.dp)
                },
            text = if(longHeaderRes != null) stringResource(longHeaderRes) else "",
            fontSize = 12.sp,
            color = LocalTheme.colors.secondary
        )

        Crossfade(
            targetState = data.type == FactType.LIST || data.type == FactType.BULLET_POINTS,
            modifier = Modifier
                .animateContentSize()
                .constrainAs(txtLongInformation) {
                    linkTo(txtShortInformationHeader.start, txtShortInformationHeader.end)
                    top.linkTo(txtLongInformationHeader.bottom, 2.dp)
                    width = Dimension.fillToConstraints
                },
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
                        visible = state.mode.value == InteractiveCardMode.EDIT
                    ) {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            ComponentHeaderButton(
                                onClick = {
                                    listItems.add(0, " ")
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
                            value = listItem,
                            enabled = state.mode.value == InteractiveCardMode.EDIT,
                            onValueChange = { output ->
                                if(output.isBlank()) {
                                    listItems.removeAt(index)
                                    selectedListIndex.intValue--
                                }else {
                                    listItems.removeAt(index)
                                    listItems.add(index, output)
                                    data.textList = listItems.toList()
                                    requestDataSave()
                                }
                            }
                        )
                    }
                }
            }else {
                Crossfade(
                    targetState = state.mode.value == InteractiveCardMode.EDIT,
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
                        Text(
                            text = data.longInformation,
                            fontSize = 16.sp,
                            color = LocalTheme.colors.secondary,
                            maxLines = 5,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
        EditableImageAsset(
            modifier = Modifier
                .animateContentSize()
                .wrapContentHeight()
                .constrainAs(imgLongImage) {
                    linkTo(txtShortInformationHeader.start, txtShortInformationHeader.end)
                    top.linkTo(txtLongInformation.bottom, 6.dp)
                    width = Dimension.fillToConstraints
                },
            asset = promptImage.value,
            isInEditMode = state.mode.value == InteractiveCardMode.EDIT,
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
            visible = state.mode.value == InteractiveCardMode.EDIT && promptImage.value == null
        ) {
            ImageAction(
                modifier = Modifier
                    .animateContentSize()
                    .constrainAs(btnAddLongImage) {
                        linkTo(txtShortInformationHeader.start, txtShortInformationHeader.end)
                        top.linkTo(imgLongImage.bottom, 4.dp)
                    },
                leadingImageVector = Icons.Outlined.Image,
                text = stringResource(id = R.string.button_add_prompt_image)
            ) {
                promptImage.value = LargePathAsset()
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
    fun requestAddNewCategory(name: String)

    /** Makes a request for all existing categories */
    fun requestAllCategories()
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
private fun Preview() {
    FactCard(
        data = FactIO(
            shortKeyInformation = "Short key information",
            longInformation = "This longInformation isn't correct, due to gramatical error",
            promptImage = LargePathAsset(urlPath = "asdj")
        ),
        requestDataSave = {},
        state = InteractiveCardState(
            mode = mutableStateOf(InteractiveCardMode.EDIT)
        ),
        categoryUseCase = object: FactCardCategoryUseCase {
            override val categories: StateFlow<List<CategoryIO>?>
                get() = MutableStateFlow(listOf(
                    CategoryIO(name = "test")
                )).asStateFlow()

            override fun requestAddNewCategory(name: String) {

            }

            override fun requestAllCategories() {

            }
        }
    )
}