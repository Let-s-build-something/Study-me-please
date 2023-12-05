package study.me.please.ui.components

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImagePainter
import com.squadris.squadris.compose.components.DEFAULT_ANIMATION_LENGTH_SHORT
import com.squadris.squadris.compose.components.input.EditFieldInput
import com.squadris.squadris.compose.components.MinimalisticIcon
import com.squadris.squadris.compose.theme.LocalTheme
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.data.io.FactIO
import study.me.please.data.io.FactType
import study.me.please.data.io.LargePathAsset
import study.me.please.ui.collection.detail.questions.detail.INPUT_DELAYED_RESPONSE_MILLIS
import study.me.please.ui.components.tab_switch.MultiChoiceSwitch
import study.me.please.ui.components.tab_switch.rememberTabSwitchState

/** Card with the option of editing data inside */
@Composable
fun FactCard(
    modifier: Modifier = Modifier,
    state: InteractiveCardState = rememberInteractiveCardState(),
    data: FactIO?,
    requestDataSave: (FactIO) -> Unit
) {
    if(data != null) {
        ContentLayout(
            modifier = modifier,
            data = data,
            state = state,
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
    }else {
        ShimmerLayout()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ContentLayout(
    modifier: Modifier,
    data: FactIO,
    state: InteractiveCardState,
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
    requestDataSave: () -> Unit,
    data: FactIO
) {
    val promptImage = remember(data) { mutableStateOf(data.promptImage) }

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

        val switchTypeState = rememberTabSwitchState(
            selectedTabIndex = remember(data) { mutableIntStateOf(data.type.ordinal) },
            tabs = arrayOfNulls<String?>(FactType.values().size).map { "" }.toMutableList(),
            onSelectionChange = { index ->
                FactType.values().getOrNull(index)?.let { factType ->
                    data.type = factType
                }
                requestDataSave()
            }
        )

        val selectedType = FactType.values().getOrNull(switchTypeState.selectedTabIndex.value)
        val showCheckbox = state.mode.value == InteractiveCardMode.CHECKING
        val showRightAction = state.mode.value == InteractiveCardMode.DATA_DISPLAY
                || state.mode.value == InteractiveCardMode.EDIT

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
                    MinimalisticIcon(imageVector = Icons.Outlined.Close) {
                        state.mode.value = InteractiveCardMode.DATA_DISPLAY
                    }
                }else {
                    MinimalisticIcon(imageVector = Icons.Outlined.Edit) {
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
                    text = if(selectedType != null) stringResource(id = selectedType.getStringRes()) else "",
                    fontSize = 12.sp,
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
            text = if(selectedType != null) stringResource(id = selectedType.getShortHeaderStringRes()) else "",
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
                    value = data.shortKeyInformation,
                    hint = if(selectedType != null) stringResource(id = selectedType.getShortHintStringRes()) else "",
                    minLines = 2,
                    maxLines = 2
                ) { output ->
                    data.shortKeyInformation = output
                    requestDataSave()
                }
            }else {
                Text(
                    text = data.shortKeyInformation,
                    fontSize = 18.sp,
                    color = LocalTheme.colors.primary,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        Text(
            modifier = Modifier
                .constrainAs(txtLongInformationHeader) {
                    linkTo(txtShortInformationHeader.start, txtShortInformationHeader.end, bias = 0f)
                    top.linkTo(txtShortInformation.bottom, 6.dp)
                },
            text = if(selectedType != null) stringResource(id = selectedType.getLongHeaderStringRes()) else "",
            fontSize = 12.sp,
            color = LocalTheme.colors.secondary
        )



        Crossfade(
            targetState = data.type == FactType.LIST,
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
                LazyColumn {

                }
            }else {
                Crossfade(
                    targetState = state.mode.value == InteractiveCardMode.EDIT,
                    label = "",
                    animationSpec = tween(durationMillis = DEFAULT_ANIMATION_LENGTH_SHORT)
                ) { inEditMode ->
                    if(inEditMode) {
                        EditFieldInput(
                            modifier = Modifier.fillMaxWidth(),
                            value = data.longInformation,
                            hint = if(selectedType != null) stringResource(id = selectedType.getLongHintStringRes()) else "",
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
        if(state.mode.value == InteractiveCardMode.EDIT && promptImage.value == null) {
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
        )
    )
}