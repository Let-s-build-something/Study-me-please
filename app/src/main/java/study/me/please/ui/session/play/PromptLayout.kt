package study.me.please.ui.session.play

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Repeat
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.theme.Colors
import com.squadris.squadris.compose.theme.LocalTheme
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.base.LocalSnackbarHost
import study.me.please.base.navigation.NavIconType
import study.me.please.data.io.LargePathAsset
import study.me.please.data.io.QuestionAnswerIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.data.io.session.SessionItem
import study.me.please.ui.components.ComponentHeaderButton
import study.me.please.ui.components.EditableImageAsset
import study.me.please.ui.components.OutlinedButton

/** Screen for the Session play prompt */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PromptLayout(
    modifier: Modifier = Modifier,
    sessionItem: SessionItem,
    stepForward: () -> Unit,
    index: Int,
    state: SessionScreenState,
    sessionPreferencePack: SessionPreferencePack
) {
    val screenMode = if(sessionItem.isHistory) SessionScreenMode.LOCKED else sessionItem.mode.value
    val question = sessionItem.question
    val answers = remember(index) {
        if(sessionItem.isHistory || sessionItem.mode.value == SessionScreenMode.LOCKED) {
            sessionItem.question?.answers
        }else sessionItem.question?.answers?.shuffled()
    }

    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val snackbarHost = LocalSnackbarHost.current

    Scaffold(
        contentColor = Color.Transparent,
        containerColor = Color.Transparent,
        floatingActionButton = {
            Column(horizontalAlignment = Alignment.End) {
                val nextItem = state.module.getStepAt(index.plus(1))

                AnimatedVisibility(
                    // current item is locked, yet next one isn't
                    visible = (nextItem?.isHistory == false && nextItem.mode.value != SessionScreenMode.LOCKED)
                            && (sessionItem.isHistory || sessionItem.mode.value == SessionScreenMode.LOCKED),
                    enter = slideInHorizontally (initialOffsetX = { it }),
                    exit = slideOutHorizontally (targetOffsetX = { -it.times(4) }),
                ) {
                    FloatingActionButton(
                        modifier = Modifier.padding(bottom = 8.dp),
                        containerColor = LocalTheme.colors.tetrial,
                        contentColor = LocalTheme.colors.brandMain,
                        onClick = {
                            stepForward()
                        }
                    ) {
                        NavIconType.BACK.imageVector?.let { icon ->
                            Icon(
                                modifier = Modifier
                                    .size(32.dp)
                                    .rotate(190f),
                                imageVector = icon.first,
                                contentDescription = icon.second
                            )
                        }
                    }
                }

                if(sessionPreferencePack.repeatOnMistake.value) {
                    val actualItem = state.module.getStepAt(index)
                    val isRepetition = remember(actualItem?.isRepetition) { mutableStateOf(actualItem?.isRepetition) }

                    AnimatedVisibility(
                        visible = isRepetition.value == false
                                && (sessionItem.isHistory || sessionItem.mode.value == SessionScreenMode.LOCKED)
                                && (actualItem?.historyItem?.answers ?: actualItem?.validations)?.none { it.isCorrect.not() } == true,
                        enter = slideInHorizontally (initialOffsetX = { it }),
                        exit = slideOutHorizontally (targetOffsetX = { -it.times(4) }),
                    ) {
                        ComponentHeaderButton(
                            startIconVector = Icons.Outlined.Repeat,
                            text = stringResource(id = R.string.button_repeat),
                            onClick = {
                                isRepetition.value = true
                                coroutineScope.launch {
                                    state.module.repeatQuestion(sessionItem)
                                    snackbarHost?.showSnackbar(context.getString(R.string.session_play_repeated_snackbar))
                                }
                            }
                        )
                    }
                }
            }
        }
    ) {
        LazyColumn(
            modifier = modifier
                .padding(horizontal = 24.dp)
                .fillMaxSize()
        ) {
            item {
                Text(
                    text = question?.prompt ?: "",
                    fontSize = 22.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(
                            top = 18.dp,
                            end = 12.dp,
                            bottom = 12.dp
                        ),
                    color = LocalTheme.colors.primary,
                    fontWeight = FontWeight.Medium,
                    maxLines = 100,
                    softWrap = true,
                    lineHeight = 24.sp
                )
                EditableImageAsset(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    asset = question?.imagePromptUrl
                )
                if(screenMode == SessionScreenMode.LOCKED) {
                    if(question?.textExplanation.isNullOrEmpty().not()) {
                        Text(
                            text = question?.textExplanation ?: "",
                            color = LocalTheme.colors.secondary,
                            fontSize = 14.sp
                        )
                    }
                    if(question?.imageExplanationUrl?.isEmpty == false) {
                        EditableImageAsset(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            asset = question.imageExplanationUrl
                        )
                    }
                }
            }

            items(
                answers.orEmpty(),
                key = { it.uid }
            ) { answer ->
                val validation = (sessionItem.historyItem?.answers ?: sessionItem.validations).find { it.uid == answer.uid }
                val showResult = validation != null

                OutlinedButton(
                    modifier = if(showResult) {
                        Modifier
                            .background(
                                color = if(validation?.isCorrect == true) {
                                    Colors.GREEN_CORRECT
                                }else Colors.RED_ERROR,
                                shape = LocalTheme.shapes.componentShape
                            )
                    }else Modifier,
                    thenModifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                    text = answer.text,
                    trailingIcon = if(showResult) {
                        if(validation?.isCorrect == true) {
                            Icons.Outlined.Check
                        }else Icons.Outlined.Close
                    }else if(sessionItem.selectedAnswers.contains(answer)) Icons.Outlined.Check else null,
                    // we don't want to validate again, it's pointless
                    enabled = (screenMode == SessionScreenMode.REGULAR || validation != null)
                            && sessionItem.isHistory.not(),
                    onClick = {
                        if(sessionPreferencePack.manualValidation.value) {
                            if(sessionItem.selectedAnswers.contains(answer)) {
                                sessionItem.selectedAnswers.remove(answer)
                            }else sessionItem.selectedAnswers.add(answer)
                        }else {
                            coroutineScope.launch {
                                state.validateAnswer(sessionItem, answer)
                            }
                        }
                    },
                    activeColor = if(showResult) Color.White else LocalTheme.colors.primary,
                    inactiveColor = if(showResult) Color.White else LocalTheme.colors.secondary
                )
                if(screenMode == SessionScreenMode.LOCKED) {
                    if(answer.explanationMessage.isNotEmpty()) {
                        Text(
                            modifier = Modifier.padding(top = 6.dp, start = 4.dp),
                            text = answer.explanationMessage,
                            color = LocalTheme.colors.secondary,
                            fontSize = 14.sp
                        )
                    }
                    if(answer.imageExplanation?.isEmpty == false) {
                        EditableImageAsset(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp, bottom = 20.dp),
                            asset = answer.imageExplanation
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                Spacer(modifier = Modifier.height(48.dp))
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
private fun PromptPreview() {
    Box(modifier = Modifier.background(LocalTheme.colors.backgroundLight)) {
        val question = QuestionIO(
            prompt = "Some random prompt",
            textExplanation = "Text explanation",
            imageExplanationUrl = LargePathAsset(
                urlPath = "https://www.imgonline.com.ua/examples/bee-on-daisy-mini.jpg"
            ),
            answers = mutableListOf(
                QuestionAnswerIO(text = "Answer 1", isCorrect = false),
                QuestionAnswerIO(text = "Answer 2", isCorrect = true),
                QuestionAnswerIO(text = "Answer 3", isCorrect = false),
                QuestionAnswerIO(text = "Answer 4", isCorrect = false),
                QuestionAnswerIO(text = "Answer 5", isCorrect = true)
            )
        )
        PromptLayout(
            sessionItem = SessionItem(
                isHistory = false,
                data = question
            ),
            state = SessionScreenState(
                QuestionModule(),
                sessionPreferencePack = mutableStateOf(SessionPreferencePack()),
                requestSave = {}
            ),
            sessionPreferencePack = SessionPreferencePack(),
            stepForward = {},
            index = 0
        )
    }
}