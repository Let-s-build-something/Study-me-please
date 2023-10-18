package study.me.please.ui.components

import android.annotation.SuppressLint
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImagePainter
import com.squadris.squadris.compose.theme.LocalTheme
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.data.io.LargePathAsset
import study.me.please.data.io.QuestionAnswerIO
import study.me.please.ui.collection.detail.INPUT_DELAYED_RESPONSE_MILLIS
import study.me.please.ui.components.tab_switch.DEFAULT_ANIMATION_LENGTH_SHORT

/** Card with the option of editing data inside */
@Composable
fun QuestionAnswerCard(
    modifier: Modifier = Modifier,
    state: InteractiveCardState = rememberInteractiveCardState(),
    data: QuestionAnswerIO?,
    requestDataSave: () -> Unit
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
    data: QuestionAnswerIO,
    state: InteractiveCardState,
    requestDataSave: () -> Unit,
    onClick: () -> Unit,
    onLongClick: () -> Unit
) {
    val localDensity = LocalDensity.current
    var cardHeight by remember { mutableStateOf(0.dp) }

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
            modifier = Modifier.onGloballyPositioned { coordinates ->
                cardHeight = with(localDensity) { coordinates.size.height.toDp() }
            },
            state = state,
            data = data,
            requestDataSave = requestDataSave
        )
    }
}

@Composable
private fun DataCard(
    modifier: Modifier = Modifier,
    state: InteractiveCardState,
    requestDataSave: () -> Unit,
    data: QuestionAnswerIO
) {
    val isCorrect = remember { mutableStateOf(data.isCorrect) }
    val imageAsset = remember { mutableStateOf(data.imageExplanation) }
    LaunchedEffect(data) {
        isCorrect.value = data.isCorrect
    }

    ConstraintLayout(
        modifier = modifier
            .padding(vertical = 8.dp, horizontal = 12.dp)
            .fillMaxWidth()
    ) {
        val (checkBox,
            imgRightAction,
            txtAnswerHeader,
            txtAnswer,
            txtExplanation,
            txtExplanationHeader,
            imgExplanation,
            btnAddImage,
            txtIsCorrect,
            checkBoxIsCorrect
        ) = createRefs()

        if(state.mode.value == InteractiveCardMode.CHECKING) {
            Checkbox(
                modifier = Modifier.constrainAs(checkBox) {
                    start.linkTo(parent.start, (-8).dp)
                    top.linkTo(parent.top, (-12).dp)
                },
                checked = state.isChecked.value,
                onCheckedChange = { isChecked ->
                    state.isChecked.value = isChecked
                },
                colors = LocalTheme.styles.checkBoxColorsDefault
            )
        }
        val rightIconActionModifier = Modifier
            .constrainAs(imgRightAction) {
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            }
        if(state.mode.value == InteractiveCardMode.DATA_DISPLAY) {
            MinimalisticIcon(
                modifier = rightIconActionModifier,
                imageVector = Icons.Outlined.Edit
            ) {
                state.mode.value = InteractiveCardMode.EDIT
            }
        }
        if(state.mode.value == InteractiveCardMode.EDIT) {
            MinimalisticIcon(
                modifier = rightIconActionModifier,
                imageVector = Icons.Outlined.Close
            ) {
                state.mode.value = InteractiveCardMode.DATA_DISPLAY
            }
        }

        Text(
            modifier = Modifier
                .constrainAs(txtAnswerHeader) {
                    start.linkTo(
                        if(state.mode.value == InteractiveCardMode.CHECKING) {
                            checkBox.end
                        }else parent.start
                    )
                },
            text = stringResource(id = R.string.answer_field_content_header),
            fontSize = 12.sp,
            color = LocalTheme.colors.secondary
        )
        Text(
            modifier = Modifier
                .constrainAs(txtExplanationHeader) {
                    start.linkTo(txtAnswerHeader.start)
                    top.linkTo(txtAnswer.bottom, 4.dp)
                },
            text = stringResource(id = R.string.answer_field_explanation_header),
            fontSize = 12.sp,
            color = LocalTheme.colors.secondary
        )

        val inputScope = rememberCoroutineScope()
        Crossfade(
            targetState = state.mode.value == InteractiveCardMode.EDIT,
            modifier = Modifier
                .animateContentSize()
                .constrainAs(txtAnswer) {
                    linkTo(txtAnswerHeader.start, imgRightAction.start)
                    top.linkTo(txtAnswerHeader.bottom, 2.dp)
                    width = Dimension.fillToConstraints
                },
            label = "",
            animationSpec = tween(durationMillis = DEFAULT_ANIMATION_LENGTH_SHORT)
        ) { inEditMode ->
            if(inEditMode) {
                EditFieldInput(
                    modifier = Modifier.fillMaxWidth(),
                    value = data.text,
                    hint = stringResource(id = R.string.answer_edit_field_hint_content),
                    minLines = 2,
                    maxLines = 2
                ) { output ->
                    data.text = output
                    inputScope.coroutineContext.cancelChildren()
                    inputScope.launch {
                        delay(INPUT_DELAYED_RESPONSE_MILLIS)
                        requestDataSave()
                    }
                }
            }else {
                Text(
                    text = data.text,
                    fontSize = 18.sp,
                    color = LocalTheme.colors.primary,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
        Crossfade(
            targetState = state.mode.value == InteractiveCardMode.EDIT,
            modifier = Modifier
                .animateContentSize()
                .constrainAs(txtExplanation) {
                    linkTo(
                        txtAnswerHeader.start,
                        if (state.mode.value == InteractiveCardMode.EDIT) {
                            imgRightAction.start
                        } else txtIsCorrect.start
                    )
                    top.linkTo(txtExplanationHeader.bottom, 2.dp)
                    width = Dimension.fillToConstraints
                },
            label = "",
            animationSpec = tween(durationMillis = DEFAULT_ANIMATION_LENGTH_SHORT)
        ) { inEditMode ->
            if(inEditMode) {
                EditFieldInput(
                    modifier = Modifier.fillMaxWidth(),
                    value = data.explanationMessage,
                    hint = stringResource(id = R.string.question_edit_field_hint_explanation),
                    minLines = 4,
                    maxLines = 4
                ) { output ->
                    data.explanationMessage = output
                    inputScope.coroutineContext.cancelChildren()
                    inputScope.launch {
                        delay(INPUT_DELAYED_RESPONSE_MILLIS)
                        requestDataSave()
                    }
                }
            }else {
                Text(
                    text = data.explanationMessage,
                    fontSize = 16.sp,
                    color = LocalTheme.colors.secondary,
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
        EditableImageAsset(
            modifier = Modifier
                .animateContentSize()
                .wrapContentHeight()
                .constrainAs(imgExplanation) {
                    linkTo(parent.start, parent.end)
                    top.linkTo(txtExplanation.bottom, 6.dp)
                    width = Dimension.fillToConstraints
                },
            asset = imageAsset.value,
            isInEditMode = state.mode.value == InteractiveCardMode.EDIT,
            onUrlChange = { output ->
                inputScope.coroutineContext.cancelChildren()
                inputScope.launch {
                    delay(INPUT_DELAYED_RESPONSE_MILLIS)
                    imageAsset.value = LargePathAsset(
                        urlPath = output
                    )
                }
                if(output.isEmpty()) {
                    requestDataSave()
                }
            },
            onLoadState = { loadState ->
                if(loadState is AsyncImagePainter.State.Success) {
                    data.imageExplanation = imageAsset.value
                    requestDataSave()
                }
            }
        )
        if(state.mode.value == InteractiveCardMode.EDIT && imageAsset.value == null) {
            ImageAction(
                modifier = Modifier
                    .animateContentSize()
                    .constrainAs(btnAddImage) {
                        linkTo(parent.start, parent.end)
                        top.linkTo(imgExplanation.bottom, 4.dp)
                    },
                leadingImageVector = Icons.Outlined.Image,
                text = stringResource(id = R.string.button_add_image)
            ) {
                imageAsset.value = LargePathAsset()
            }
        }
        OutlinedButton(
            modifier = Modifier.constrainAs(checkBoxIsCorrect) {
                end.linkTo(parent.end, -(8.dp))
                top.linkTo(imgExplanation.bottom, 6.dp)
            },
            isActivated = isCorrect.value,
            onClick = {
                data.isCorrect = isCorrect.value.not()
                isCorrect.value = isCorrect.value.not()
                requestDataSave()
            },
            text = stringResource(
                id = if(isCorrect.value) {
                    R.string.answer_is_correct_ticked
                }else R.string.answer_is_correct_not_ticked
            ),
            trailingIcon = if(isCorrect.value) {
                Icons.Outlined.Check
            }else Icons.Outlined.Close
        )
    }
}

@Composable
private fun ShimmerLayout() {

}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
private fun Preview() {
    QuestionAnswerCard(
        data = QuestionAnswerIO(
            text = "This is my answer",
            explanationMessage = "This answer isn't correct, due to gramatical error"
        ),
        requestDataSave = {},
        state = InteractiveCardState(
            mode = mutableStateOf(InteractiveCardMode.EDIT)
        )
    )
}