package study.me.please.ui.session.play

import androidx.compose.runtime.MutableState
import com.squadris.squadris.utils.DateUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext
import study.me.please.data.io.QuestionAnswerIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.session.SessionAnswerValidation
import study.me.please.data.io.session.SessionHistoryItem
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.data.io.session.SessionItem
import java.util.Calendar

/** Saved state of screen for playing questions */
data class SessionScreenState(
    /** controlling engine for questioning */
    val module: QuestionModule,

    /** whether this questioning is for testing purposes only */
    val isTest: Boolean = false,

    /** Preferences for behavior in validating and other options */
    val sessionPreferencePack: MutableState<SessionPreferencePack>,

    /** called whenever there is a request for data save */
    val requestSave: () -> Unit
) {

    /**
     * Current question item.
     * No matter it's histry item or new question, it comes from here.
     */
    val liveIndex: MutableStateFlow<Int> = MutableStateFlow(module.currentIndex)

    /** Sync current data with state model */
    suspend fun initialize(questions: List<QuestionIO>) {
        module.setData(questions)
        timeOfStart = DateUtils.now
        liveIndex.value = module.currentIndex
    }

    private var timeOfStart: Calendar? = null

    /** Validates answer */
    suspend fun validateAnswer(item: SessionItem, answer: QuestionAnswerIO) {
        withContext(Dispatchers.Main) {
            // we don't accept duplicite validations
            if(item.validations.any { it.uid == answer.uid }) return@withContext
            item.validations.add(
                SessionAnswerValidation(
                    uid = answer.uid,
                    isCorrect = answer.isCorrect
                )
            )

            if(item.validations.any { it.isCorrect.not() }
                && sessionPreferencePack.value.waitForCorrectAnswer.value.not()
            ) {
                item.mode.value = SessionScreenMode.LOCKED
                item.injectCorrectValidations()
            }else if(item.validations.filter { it.isCorrect }.size == item.question?.answers?.count { it.isCorrect }) {
                item.mode.value = SessionScreenMode.LOCKED
                item.injectCorrectValidations()
            }

            // end of session
            if(item.mode.value == SessionScreenMode.LOCKED
                && item.validations.any { it.isCorrect.not() }
                && sessionPreferencePack.value.repeatOnMistake.value
                && item.isHistory.not()
            ) {
                item.data?.let { question ->
                    module.injectQuestion(
                        question = question,
                        isMistake = true
                    )
                }
            }
            if(item.mode.value == SessionScreenMode.LOCKED) {
                // if we are not in history
                if(liveIndex.value >= module.history.size.minus(1)) {
                    module.onQuestionAnswered(
                        SessionHistoryItem(
                            questionIO = item.question,
                            index = liveIndex.value.minus(module.history.size.minus(1)),
                            answers = item.validations.toSet().toList(),
                            timeToAnswer = DateUtils.now.timeInMillis,
                            timeOfStart = timeOfStart?.timeInMillis,
                            isRepetition = item.isRepetition
                        )
                    )
                }
            }
            requestSave()
        }
    }

    private suspend fun SessionItem.injectCorrectValidations() {
        withContext(Dispatchers.Default) {
            data?.answers?.forEach { answer ->
                if(validations.any { it.uid == answer.uid }.not() && answer.isCorrect) {
                    validations.add(
                        SessionAnswerValidation(
                            uid = answer.uid,
                            isCorrect = true
                        )
                    )
                }
            }
        }
    }
}