package study.me.please.ui.components

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import com.squadris.squadris.compose.components.MinimalisticIcon
import com.squadris.squadris.compose.components.chips.DEFAULT_ANIMATION_LENGTH_SHORT
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.ext.brandShimmerEffect
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.data.io.FactType
import study.me.please.data.io.LargePathAsset
import study.me.please.data.io.QuestionAnswerIO
import study.me.please.ui.collection.detail.questions.detail.INPUT_DELAYED_RESPONSE_MILLIS

/** Card with the option of editing data inside */
@Composable
fun QuestionAnswerCard(
    modifier: Modifier = Modifier,
    data: QuestionAnswerIO?,
    isSelected: Boolean,
    isChecked: Boolean?,
    onCheckedChange: (Boolean) -> Unit,
    requestDataSave: (QuestionAnswerIO) -> Unit
) {
    if(data != null) {
        ContentLayout(
            modifier = modifier,
            data = data,
            requestDataSave = requestDataSave,
            isSelected = isSelected,
            isChecked = isChecked,
            onCheckedChange = onCheckedChange
        )
    }else {
        ShimmerLayout(modifier = modifier)
    }
}

@Composable
private fun ContentLayout(
    modifier: Modifier,
    data: QuestionAnswerIO,
    isSelected: Boolean,
    isChecked: Boolean?,
    onCheckedChange: (Boolean) -> Unit,
    requestDataSave: (QuestionAnswerIO) -> Unit
) {
    val localDensity = LocalDensity.current
    var cardHeight by remember { mutableStateOf(0.dp) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(LocalTheme.current.shapes.componentShape),
        elevation = LocalTheme.current.styles.cardClickableElevation,
        shape = LocalTheme.current.shapes.componentShape,
        colors = CardDefaults.cardColors(
            containerColor = LocalTheme.current.colors.onBackgroundComponentContrast,
            contentColor = LocalTheme.current.colors.onBackgroundComponentContrast
        )
    ) {
        DataCard(
            modifier = Modifier.onGloballyPositioned { coordinates ->
                cardHeight = with(localDensity) { coordinates.size.height.toDp() }
            },
            data = data,
            requestDataSave = requestDataSave,
            isSelected = isSelected,
            isChecked = isChecked,
            onCheckedChange = onCheckedChange
        )
    }
}

@Composable
private fun DataCard(
    modifier: Modifier = Modifier,
    requestDataSave: (QuestionAnswerIO) -> Unit,
    isSelected: Boolean,
    isChecked: Boolean?,
    onCheckedChange: (Boolean) -> Unit,
    data: QuestionAnswerIO
) {
    val focusManager = LocalFocusManager.current

    val inputScope = rememberCoroutineScope()
    val scope = rememberCoroutineScope()

    val isCorrect = remember(data) { mutableStateOf(data.isCorrect) }
    val imageAsset = remember(data) { mutableStateOf(data.imageExplanation) }
    val answerSingleFR = remember(data) { FocusRequester() }
    val answerMultiFR = remember(data) { FocusRequester() }
    val explanationFR = remember(data) { FocusRequester() }

    val listItems = remember(data.uid) {
        mutableStateListOf(
            *data.textList.ifEmpty { listOf(data.text) }.toTypedArray()
        )
    }

    LaunchedEffect(data) {
        isCorrect.value = data.isCorrect
    }

    LaunchedEffect(Unit) {
        if(isSelected) {
            if(listItems.firstOrNull()?.isBlank() == true && data.explanationMessage.isEmpty()) {
                explanationFR.requestFocus()
            }else {
                delay(300)
                if(listItems.size == 1) {
                    answerSingleFR.requestFocus()
                }else {
                    answerMultiFR.requestFocus()
                }
            }
        }
    }

    Column(
        modifier = modifier
            .padding(vertical = 8.dp, horizontal = 12.dp)
            .animateContentSize()
            .fillMaxWidth()
    ) {
        Crossfade(
            modifier = Modifier.align(Alignment.End),
            targetState = isSelected,
            label = "crossfadeRightIcon"
        ) { isEditMode ->
            if(isEditMode) {
                MinimalisticIcon(imageVector = Icons.Outlined.Close) {
                    onCheckedChange(false)
                }
            }else {
                MinimalisticIcon(imageVector = Icons.Outlined.Edit)
            }
        }

        AnimatedVisibility(visible = isSelected) {
            Text(
                modifier = Modifier.padding(bottom = 2.dp),
                text = stringResource(R.string.answer_field_content_header),
                fontSize = 12.sp,
                color = LocalTheme.current.colors.secondary
            )
        }

        Row {
            this@Row.AnimatedVisibility(
                visible = isChecked != null
            ) {
                Checkbox(
                    modifier = Modifier
                        .offset(x = -(12).dp, y = (-8).dp),
                    checked = isChecked == true,
                    onCheckedChange = onCheckedChange,
                    colors = LocalTheme.current.styles.checkBoxColorsDefault
                )
            }
            Column {
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    val isIrremovable = listItems.size <= 1

                    listItems.forEachIndexed { index, listItem ->
                        Crossfade(
                            modifier = Modifier.animateContentSize(),
                            targetState = listItems.size == 1,
                            label = "SingleEditToMultipleCrossfade"
                        ) { isSingleItem ->
                            if(isSingleItem) {
                                Crossfade(
                                    targetState = isSelected,
                                    label = "",
                                    animationSpec = tween(durationMillis = DEFAULT_ANIMATION_LENGTH_SHORT)
                                ) { inEditMode ->
                                    if(inEditMode) {
                                        EditFieldInput(
                                            modifier = Modifier
                                                .focusRequester(answerSingleFR)
                                                .fillMaxWidth(),
                                            value = listItem,
                                            enabled = isSelected,
                                            hint = stringResource(R.string.answer_edit_field_hint_content),
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
                                            requestDataSave(data.apply {
                                                textList = listOf(output)
                                            })
                                        }
                                    }else {
                                        BulletPoint(
                                            text = listItem,
                                            textStyle = LocalTheme.current.styles.category,
                                            maxLines = 5,
                                            overflow = TextOverflow.Ellipsis,
                                            prefix = if(listItem.isNotEmpty()) "-" else null
                                        )
                                    }
                                }
                            }else {
                                ListItemEditField(
                                    modifier = Modifier
                                        .then(
                                            if (index == listItems.lastIndex) {
                                                Modifier.focusRequester(answerMultiFR)
                                            } else Modifier
                                        ),
                                    prefix = FactType.BULLET_POINT_PREFIX,
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
                                    hint = stringResource(R.string.list_item_generic_hint),
                                    value = AnnotatedString(listItem),
                                    onValueChange = { output ->
                                        if(listItems.size > index) {
                                            listItems[index] = output
                                            requestDataSave(data.apply {
                                                textList = listItems.toList()
                                            })
                                        }
                                    }
                                )
                            }
                        }
                    }
                }

                AnimatedVisibility(visible = isSelected) {
                    Text(
                        text = stringResource(id = R.string.answer_field_explanation_header),
                        fontSize = 12.sp,
                        color = LocalTheme.current.colors.secondary
                    )
                }
                Crossfade(
                    targetState = isSelected,
                    modifier = Modifier.animateContentSize(),
                    label = "",
                    animationSpec = tween(durationMillis = DEFAULT_ANIMATION_LENGTH_SHORT)
                ) { inEditMode ->
                    if(inEditMode) {
                        EditFieldInput(
                            modifier = Modifier
                                .focusRequester(explanationFR)
                                .fillMaxWidth(),
                            value = data.explanationMessage,
                            enabled = isSelected,
                            identifier = data.uid,
                            hint = stringResource(id = R.string.question_edit_field_hint_explanation),
                            minLines = 2,
                            maxLines = 2
                        ) { output ->
                            //data.explanationMessage = output
                            inputScope.coroutineContext.cancelChildren()
                            inputScope.launch {
                                delay(INPUT_DELAYED_RESPONSE_MILLIS)
                                requestDataSave(
                                    data.apply {
                                        explanationMessage = output
                                    }
                                )
                            }
                        }
                    }else {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = data.explanationMessage,
                            fontSize = 16.sp,
                            color = LocalTheme.current.colors.secondary,
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
                .wrapContentHeight(),
            asset = imageAsset.value,
            isInEditMode = isSelected,
            onUrlChange = { output ->
                inputScope.coroutineContext.cancelChildren()
                inputScope.launch {
                    delay(INPUT_DELAYED_RESPONSE_MILLIS)
                    imageAsset.value = LargePathAsset(
                        urlPath = output
                    )
                }
                if(output.isEmpty()) {
                    requestDataSave(data.apply {
                        imageExplanation = imageAsset.value
                    })
                }
            },
            onLoadState = { loadState ->
                if(loadState is AsyncImagePainter.State.Success) {
                    data.imageExplanation = imageAsset.value
                    requestDataSave(
                        data.apply {
                            imageExplanation = imageAsset.value
                        }
                    )
                }
            }
        )
        if(isSelected && imageAsset.value == null) {
            ImageAction(
                modifier = Modifier.animateContentSize(),
                leadingImageVector = Icons.Outlined.Image,
                text = stringResource(id = R.string.button_add_image)
            ) {
                imageAsset.value = LargePathAsset()
            }
        }
        OutlinedButton(
            modifier = Modifier.align(Alignment.End),
            isActivated = isCorrect.value,
            onClick = {
                data.isCorrect = isCorrect.value.not()
                isCorrect.value = isCorrect.value.not()
                requestDataSave(
                    data.apply {
                        this.isCorrect = isCorrect.value
                    }
                )
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
private fun ShimmerLayout(modifier: Modifier) {
    Box(
        modifier = modifier
            .height(80.dp)
            .brandShimmerEffect()
    )
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
private fun Preview() {
    QuestionAnswerCard(
        data = QuestionAnswerIO(
            text = "This is my answer",
            explanationMessage = "This answer isn't correct, due to gramatical error"
        ),
        requestDataSave = {},
        isSelected = true,
        isChecked = true,
        onCheckedChange = {}
    )
}