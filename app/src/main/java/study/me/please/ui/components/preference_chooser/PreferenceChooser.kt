package study.me.please.ui.components.preference_chooser

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.squadris.squadris.compose.components.DEFAULT_ANIMATION_LENGTH_LONG
import com.squadris.squadris.compose.components.DEFAULT_ANIMATION_LENGTH_SHORT
import com.squadris.squadris.compose.components.EditFieldInput
import com.squadris.squadris.compose.components.MinimalisticIcon
import com.squadris.squadris.compose.theme.Colors
import com.squadris.squadris.compose.theme.LocalTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.base.navigation.ActionBarIcon
import study.me.please.data.io.QuestionMode
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.ui.collection.detail.REQUEST_DATA_SAVE_DELAY
import study.me.please.ui.components.ImageAction
import study.me.please.ui.components.SwitchText
import study.me.please.ui.components.TextHeader

/**
 * Component for choosing and editing [SessionPreferencePack]
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PreferenceChooser(
    modifier: Modifier = Modifier,
    preferencePacks: List<SessionPreferencePack>?,
    controller: PreferenceChooserController,
    defaultPreferencePack: SessionPreferencePack? = null,
    mustHaveSelection: Boolean = true,
    expandedByDefault: Boolean = true,
) {
    val preferencesShown = remember {
        mutableStateOf((mustHaveSelection || defaultPreferencePack != null) && expandedByDefault)
    }
    val selectedPreferencePack = remember(defaultPreferencePack) { mutableStateOf(defaultPreferencePack) }

    val expandRotationState by animateFloatAsState(
        targetValue = if(preferencesShown.value) 180f else 0f,
        label = "",
        animationSpec = tween(DEFAULT_ANIMATION_LENGTH_LONG)
    )

    val localFocusManager = LocalFocusManager.current
    val coroutineScope = rememberCoroutineScope()
    val inputScope = rememberCoroutineScope()

    val isSwitchOneChecked = remember(
        selectedPreferencePack.value,
        defaultPreferencePack,
        preferencePacks,
        selectedPreferencePack
    ) {
        mutableStateOf(selectedPreferencePack.value?.waitForCorrectAnswer?.value)
    }
    val isSwitchTwoChecked = remember(
        selectedPreferencePack.value,
        defaultPreferencePack,
        preferencePacks,
        selectedPreferencePack
    ) {
        mutableStateOf(selectedPreferencePack.value?.manualValidation?.value)
    }
    val isSwitchThreeChecked = remember(
        selectedPreferencePack.value,
        defaultPreferencePack,
        preferencePacks,
        selectedPreferencePack
    ) {
        mutableStateOf(selectedPreferencePack.value?.repeatOnMistake?.value)
    }

    if(preferencePacks == null) {
        ShimmerLayout()
    }else {
        LaunchedEffect(
            isSwitchOneChecked.value,
            isSwitchTwoChecked.value,
            isSwitchThreeChecked.value
        ) {
            selectedPreferencePack.value?.let { controller.savePreference(it) }
        }
        val randomName = stringArrayResource(id = R.array.random_name).random()
        LaunchedEffect(selectedPreferencePack.value) {
            selectedPreferencePack.value?.let { controller.choosePreference(it) }
            localFocusManager.clearFocus()
            if(expandedByDefault) {
                preferencesShown.value = selectedPreferencePack.value != null
            }
            if(mustHaveSelection && selectedPreferencePack.value == null) {
                selectedPreferencePack.value = preferencePacks.firstOrNull()
            }
        }
        LaunchedEffect(preferencePacks) {
            if(preferencePacks.isEmpty() && mustHaveSelection) {
                selectedPreferencePack.value = controller.addPreferencePack(randomName)
            }
        }
        ConstraintLayout(
            modifier = modifier
                .pointerInput(Unit) {
                    detectTapGestures(onTap = {
                        localFocusManager.clearFocus()
                    })
                }
                .fillMaxWidth()
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = DEFAULT_ANIMATION_LENGTH_LONG,
                        easing = LinearOutSlowInEasing
                    )
                )
                .padding(top = 4.dp, bottom = 4.dp),
        ) {
            val (txtPreferencesHeader,
                rowPreferences,
                txtShowPreferences,
                imgShowPreferences,
                preferencesList
            ) = createRefs()
            TextHeader(
                modifier = Modifier
                    .constrainAs(txtPreferencesHeader) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        width = Dimension.fillToConstraints
                    },
                text = stringResource(id = R.string.preference_chooser_preferences_header)
            )
            LazyRow(
                modifier = Modifier
                    .constrainAs(rowPreferences) {
                        top.linkTo(txtPreferencesHeader.bottom, 6.dp)
                        linkTo(parent.start, parent.end)
                        width = Dimension.fillToConstraints
                    }
                    .clip(LocalTheme.shapes.componentShape)
                    .background(
                        color = LocalTheme.colors.brandMain,
                        shape = LocalTheme.shapes.componentShape
                    ),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                contentPadding = PaddingValues(4.dp)
            ) {
                item {
                    val randomPackName = stringArrayResource(id = R.array.random_name).random()
                    ActionBarIcon(
                        text = stringResource(id = R.string.preference_chooser_add_new),
                        imageVector = Icons.Outlined.Add
                    ) {
                        selectedPreferencePack.value = controller.addPreferencePack(randomPackName)
                    }
                }
                itemsIndexed(
                    preferencePacks,
                    key = { _, item -> item.uid }
                ) { _, preferencePack ->
                    val modeIcon = remember { mutableStateOf(preferencePack.estimatedMode.icon) }
                    // whenever we change setting, the mode changes
                    LaunchedEffect(
                        isSwitchOneChecked.value,
                        isSwitchTwoChecked.value,
                        isSwitchThreeChecked.value
                    ) {
                        modeIcon.value = preferencePack.estimatedMode.icon
                    }
                    ActionBarIcon(
                        modifier = (if(selectedPreferencePack.value?.uid == preferencePack.uid) {
                            Modifier
                                .border(
                                    width = 1.dp,
                                    color = LocalTheme.colors.tetrial,
                                    shape =  LocalTheme.shapes.rectangularActionShape
                                )
                        } else Modifier)
                            .animateItemPlacement(
                                tween(
                                    durationMillis = DEFAULT_ANIMATION_LENGTH_SHORT,
                                    easing = LinearOutSlowInEasing
                                )
                            ),
                        text = preferencePack.name,
                        imageVector = modeIcon.value
                    ) {
                        selectedPreferencePack.value = if(mustHaveSelection.not()
                            && selectedPreferencePack.value?.uid == preferencePack.uid
                        ) null else preferencePack
                    }
                }
            }
            if(selectedPreferencePack.value != null) {
                Text(
                    modifier = Modifier
                        .constrainAs(txtShowPreferences) {
                            linkTo(imgShowPreferences.top, imgShowPreferences.bottom)
                            linkTo(parent.start, parent.end)
                            width = Dimension.fillToConstraints
                        }
                        .zIndex(1f)
                        .clip(LocalTheme.shapes.componentShape)
                        .clickable(
                            indication = rememberRipple(),
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            preferencesShown.value = preferencesShown.value.not()
                        }
                        .padding(
                            horizontal = 8.dp,
                            vertical = 6.dp
                        ),
                    text = stringResource(
                        id = if(preferencesShown.value) {
                            R.string.preference_chooser_preferences_hide
                        }else R.string.preference_chooser_preferences_show
                    ),
                    color = LocalTheme.colors.secondary,
                    fontSize = 14.sp
                )
                Icon(
                    modifier = Modifier
                        .size(32.dp)
                        .constrainAs(imgShowPreferences) {
                            top.linkTo(rowPreferences.bottom, 6.dp)
                            end.linkTo(txtShowPreferences.end, 8.dp)
                        }
                        .padding(4.dp)
                        .rotate(expandRotationState),
                    imageVector = Icons.Outlined.KeyboardArrowDown,
                    tint = LocalTheme.colors.secondary,
                    contentDescription = null
                )
                if(preferencesShown.value) {
                    Column(
                        modifier = Modifier
                            .constrainAs(preferencesList) {
                                top.linkTo(imgShowPreferences.bottom, 6.dp)
                                linkTo(parent.start, parent.end)
                                width = Dimension.fillToConstraints
                            },
                        verticalArrangement = Arrangement.Top
                    ) {
                        selectedPreferencePack.value?.let { preferencePack ->
                            TextHeader(
                                text = stringResource(id = R.string.preference_chooser_field_name_hint)
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                EditFieldInput(
                                    modifier = Modifier
                                        .fillMaxWidth(0.6f)
                                        .padding(bottom = 6.dp),
                                    value = preferencePack.name,
                                    hint = stringResource(id = R.string.preference_chooser_field_name_hint),
                                    minLines = 1,
                                    maxLines = 1,
                                    maxLength = 15,
                                    clearable = true
                                ) { output ->
                                    preferencePack.name = output
                                    inputScope.coroutineContext.cancelChildren()
                                    inputScope.launch {
                                        delay(REQUEST_DATA_SAVE_DELAY)
                                        selectedPreferencePack.value?.let { controller.savePreference(it) }
                                    }
                                }
                                ImageAction(
                                    leadingImageVector = Icons.Outlined.Delete,
                                    containerColor = Colors.RED_ERROR
                                ) {
                                    coroutineScope.launch(Dispatchers.Default) {
                                        val oldIndex = preferencePacks.indexOfFirst { it.uid == selectedPreferencePack.value?.uid }
                                        selectedPreferencePack.value?.let { controller.deletePreference(it.uid) }
                                        selectedPreferencePack.value = (preferencePacks.getOrNull(oldIndex -1)
                                            ?: preferencePacks.getOrNull(oldIndex + 1) ?: preferencePacks.firstOrNull())?.also {
                                            controller.choosePreference(it)
                                        }
                                    }
                                }
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.Bottom
                            ) {
                                MinimalisticIcon(
                                    modifier = Modifier.wrapContentWidth(),
                                    imageVector = QuestionMode.LEARNING.icon,
                                    onClick = {
                                        preferencePack.clearPreferences()
                                        preferencePack.waitForCorrectAnswer.value = true
                                        isSwitchOneChecked.value = true
                                        isSwitchThreeChecked.value = false
                                        isSwitchTwoChecked.value = false
                                    }
                                )
                                TextHeader(
                                    modifier = Modifier
                                        .weight(1f)
                                        .fillMaxWidth(),
                                    text = stringResource(id = R.string.preference_chooser_studying_header)
                                )
                            }
                            SwitchText(
                                text = stringResource(id = R.string.preference_wait_for_correct_answer_desc),
                                isChecked = isSwitchOneChecked.value == true,
                                onCheckChanged = { isChecked ->
                                    preferencePack.waitForCorrectAnswer.value = isChecked
                                    isSwitchOneChecked.value = isChecked
                                }
                            )


                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.Bottom
                            ) {
                                MinimalisticIcon(
                                    modifier = Modifier.wrapContentWidth(),
                                    imageVector = QuestionMode.PRACTICING.icon,
                                    onClick = {
                                        preferencePack.clearPreferences()
                                        preferencePack.repeatOnMistake.value = true
                                        isSwitchThreeChecked.value = true
                                        isSwitchOneChecked.value = false
                                        isSwitchTwoChecked.value = false
                                    }
                                )
                                TextHeader(
                                    modifier = Modifier
                                        .weight(1f)
                                        .fillMaxWidth(),
                                    text = stringResource(id = R.string.preference_chooser_practicing_header)
                                )
                            }
                            SwitchText(
                                text = stringResource(id = R.string.preference_repeat_on_mistake_desc),
                                isChecked = isSwitchThreeChecked.value == true,
                                onCheckChanged = { isChecked ->
                                    preferencePack.repeatOnMistake.value = isChecked
                                    isSwitchThreeChecked.value = isChecked
                                }
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.Bottom
                            ) {
                                MinimalisticIcon(
                                    modifier = Modifier.wrapContentWidth(),
                                    imageVector = QuestionMode.TEST.icon,
                                    onClick = {
                                        preferencePack.clearPreferences()
                                        preferencePack.manualValidation.value = true
                                        isSwitchTwoChecked.value = true
                                        isSwitchOneChecked.value = false
                                        isSwitchThreeChecked.value = false
                                    }
                                )
                                TextHeader(
                                    modifier = Modifier
                                        .weight(1f)
                                        .fillMaxWidth(),
                                    text = stringResource(id = R.string.preference_chooser_examination_header)
                                )
                            }
                            SwitchText(
                                text = stringResource(id = R.string.preference_validate_manually_desc),
                                isChecked = isSwitchTwoChecked.value == true,
                                onCheckChanged = { isChecked ->
                                    preferencePack.manualValidation.value = isChecked
                                    isSwitchTwoChecked.value = isChecked
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ShimmerLayout() {
    Row {

    }
}

@Preview
@Composable
private fun Preview() {
    PreferenceChooser(
        modifier = Modifier
            .background(
                color = LocalTheme.colors.onBackgroundComponent,
                shape = RoundedCornerShape(8.dp)
            ),
        preferencePacks = mutableListOf(),
        controller = object: PreferenceChooserController {
            override fun addPreferencePack(name: String): SessionPreferencePack {
                return SessionPreferencePack()
            }
            override fun savePreference(preference: SessionPreferencePack) {
            }
            override fun deletePreference(preferenceUid: String) {
            }
            override fun choosePreference(preference: SessionPreferencePack) {
            }
        }
    )
}