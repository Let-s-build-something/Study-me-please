package study.me.please.ui.session

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext
import study.me.please.data.io.QuestionAnswerIO
import study.me.please.data.io.SessionAnswerValidation
import study.me.please.data.io.preferences.SessionPreferencePack

/** Saved state of screen for playing questions */
data class SessionScreenState(
    /** controlling engine for questioning */
    val module: QuestionModule,

    /** whether this questioning is for testing purposes only */
    val isTest: Boolean = false,

    /** Preferences for behavior in validating and other options */
    val sessionPreferencePack: MutableState<SessionPreferencePack>
) {
    /** current screen mode */
    val mode: MutableState<SessionScreenMode> = mutableStateOf(SessionScreenMode.REGULAR)

    /**
     * Current question item.
     * No matter it's histry item or new question, it comes from here.
     */
    val currentItem: MutableStateFlow<SessionQuestion> = MutableStateFlow(
        SessionQuestion(correctAnswers = listOf())
    )

    /** List of all current validations */
    val validations = mutableStateListOf<SessionAnswerValidation>()

    /** Sync current data with state model */
    fun initialize() {
        if(currentItem.value.historyItem == null
            && currentItem.value.historyItem == null
        ) {
            module.getCurrentStep()?.let { question ->
                currentItem.value = question
            }
        }
    }

    /** steps forward in questions or history */
    suspend fun stepForward(forceRepeat: Boolean = false) {
        module.stepForward(
            timeElapsed = 0L,//TODO
            responseList = validations.toSet(),
            forceRepeat = forceRepeat,
            // we can't repeat history item, only recent questions
            currentQuestion = currentItem.value.question
        )?.let { newItem ->
            validations.clear()
            mode.value = if(newItem.isHistory) SessionScreenMode.HISTORY else SessionScreenMode.REGULAR
            currentItem.value = newItem
        }
    }

    /** steps backwards in history */
    suspend fun stepBackward() {
        module.stepBackward()?.let { newItem ->
            validations.clear()
            mode.value = if(newItem.isHistory) SessionScreenMode.HISTORY else SessionScreenMode.REGULAR
            currentItem.value = newItem
            if(newItem.isHistory) {
                validations.addAll(newItem.historyItem?.answers.orEmpty())
            }
        }
    }

    /** Validates answer */
    suspend fun validateAnswer(answer: QuestionAnswerIO) {
        withContext(Dispatchers.Default) {
            // we don't accept duplicite validations
            if(validations.any { it.uid == answer.uid }) return@withContext
            validations.add(
                SessionAnswerValidation(
                    uid = answer.uid,
                    isCorrect = answer.isCorrect
                )
            )

            if(validations.any { it.isCorrect.not() }
                && sessionPreferencePack.value.waitForCorrectAnswer.value.not()
            ) {
                mode.value = SessionScreenMode.LOCKED
            }else if(validations.filter { it.isCorrect }.size == currentItem.value.correctAnswers.size) {
                mode.value = SessionScreenMode.LOCKED
            }
            if(mode.value == SessionScreenMode.LOCKED
                && validations.any { it.isCorrect.not() }
                && sessionPreferencePack.value.repeatOnMistake.value
            ) {
                currentItem.value.question?.let { question ->
                    module.injectQuestion(
                        question = question,
                        isMistake = true
                    )
                }
            }
        }
    }
}