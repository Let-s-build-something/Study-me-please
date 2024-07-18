package study.me.please.ui.components.preference_chooser

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.components.AutoResizeText
import com.squadris.squadris.compose.components.FontSizeRange
import com.squadris.squadris.compose.components.MinimalisticIcon
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.ext.scalingClickable
import study.me.please.R
import study.me.please.data.io.QuestionMode
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.ui.components.ExpandableContent
import study.me.please.ui.components.SwitchText
import study.me.please.ui.components.tab_switch.MultiChoiceSwitch
import study.me.please.ui.components.tab_switch.rememberTabSwitchState

/**
 * Component for choosing and editing [SessionPreferencePack]
 */
@Composable
fun PreferenceChooser(
    modifier: Modifier = Modifier,
    preferencePack: SessionPreferencePack?,
    onSaveRequest: (SessionPreferencePack) -> Unit
) {
    val isAdvancedExpanded = rememberSaveable {
        mutableStateOf(false)
    }

    if(preferencePack == null) {
        ShimmerLayout()
    }else {
        val switchTypeState = rememberTabSwitchState(
            selectedTabIndex = rememberSaveable {
                mutableIntStateOf(preferencePack.estimatedMode.ordinal)
            },
            tabs = arrayOfNulls<String?>(QuestionMode.entries.size).map { "" }.toMutableList(),
            onSelectionChange = { index ->
                QuestionMode.entries.getOrNull(index)?.let { newMode ->
                    onSaveRequest(preferencePack.update(newMode))
                }
            }
        )

        Column(modifier = modifier) {
            MultiChoiceSwitch(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                state = switchTypeState,
                shape = LocalTheme.current.shapes.componentShape,
                onItemCreation = { modifier, index, animatedColor ->
                    QuestionMode.entries.getOrNull(index)?.let { mode ->
                        Column(
                            modifier = modifier
                                .padding(vertical = 8.dp)
                                .scalingClickable(
                                    onTap = {
                                        switchTypeState.selectedTabIndex.value = index
                                    },
                                ),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                modifier = Modifier.size(32.dp),
                                imageVector = mode.icon,
                                contentDescription = null,
                                tint = animatedColor
                            )
                            AutoResizeText(
                                modifier = Modifier
                                    .wrapContentHeight()
                                    .padding(top = 2.dp),
                                text = when(mode) {
                                    QuestionMode.LEARNING -> stringResource(R.string.preference_chooser_studying_header)
                                    QuestionMode.PRACTICING -> stringResource(R.string.preference_chooser_practicing_header)
                                    QuestionMode.TEST -> stringResource(R.string.preference_chooser_examination_header)
                                },
                                color = animatedColor,
                                fontWeight = FontWeight.Medium,
                                textAlign = TextAlign.Center,
                                maxLines = 1,
                                fontSizeRange = FontSizeRange(
                                    min = 9.5.sp,
                                    max = 14.sp
                                )
                            )
                        }
                    }
                }
            )

            ExpandableContent(
                modifier = Modifier
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        isAdvancedExpanded.value = !isAdvancedExpanded.value
                    }
                    .background(color = LocalTheme.current.colors.onBackgroundComponent)
                    .padding(8.dp),
                text = AnnotatedString(stringResource(R.string.preference_chooser_advanced_options)),
                isExpanded = isAdvancedExpanded.value
            ) {
                Column(
                    modifier = Modifier
                        .clickable { }
                        .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                ) {
                    QuestionMode.entries.forEach { mode ->
                        Column {
                            mode.preferenceOptions.forEach { option ->
                                val isChecked = remember(option) {
                                    mutableStateOf(
                                        preferencePack.preferences[option] == true
                                    )
                                }

                                LaunchedEffect(
                                    preferencePack.preferences[option],
                                    preferencePack
                                ) {
                                    isChecked.value = preferencePack.preferences[option] == true
                                }

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    MinimalisticIcon(
                                        modifier = Modifier.wrapContentWidth(),
                                        imageVector = mode.icon
                                    )
                                    SwitchText(
                                        text = stringResource(option.stringRes),
                                        isChecked = isChecked.value,
                                        onCheckChanged = { value ->
                                            isChecked.value = value
                                            onSaveRequest(preferencePack.apply {
                                                this.preferences[option] = value
                                            })
                                        }
                                    )
                                }
                            }
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
                color = LocalTheme.current.colors.onBackgroundComponent,
                shape = RoundedCornerShape(8.dp)
            ),
        preferencePack = SessionPreferencePack(),
        onSaveRequest = {}
    )
}