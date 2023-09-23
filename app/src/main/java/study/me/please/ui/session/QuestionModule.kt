package study.me.please.ui.session

import android.util.Log
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.SessionAnswerValidation
import study.me.please.data.io.SessionHistoryItem
import study.me.please.data.room.AppRoomDatabase
import java.util.UUID

/**
 * Module for sourcing and advancing within provided data set
 */
@Entity(tableName = AppRoomDatabase.ROOM_QUESTION_MODULE_TABLE)
data class QuestionModule(
    /** identifier */
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString(),

    /** history for displaying users' answers */
    val history: MutableList<SessionHistoryItem> = mutableListOf()
) {
    /** lazy loaded, local saving of questions for this module */
    @Ignore
    var questions: List<QuestionIO> = listOf()
        set(value) {
            field = value
            if(value.isNotEmpty()) {
                Log.d("question_module", "init, questionStack: ${questionsStack.size}")
                // TODO if we want to support browsing through history, this has to change
                if(questionsStack.isEmpty()) {
                    questionsStack.addAll(questions.shuffled())
                }
            }
        }

    @SerializedName("questions_stack")
    var questionsStack = mutableListOf<QuestionIO>()

    /** current index for [questionsStack] */
    @SerializedName("current_question_index")
    var currentQuestionIndex: Int = 0

    /** current index for [history] */
    @SerializedName("current_history_index")
    var currentHistoryIndex: Int = 0

    /** steps forward in questions or history */
    @Ignore
    suspend fun stepForward(
        currentQuestion: QuestionIO?,
        responseList: Set<SessionAnswerValidation>,
        timeElapsed: Long,
        forceRepeat: Boolean = false
    ): SessionQuestion? {
        if(questions.isEmpty()) return null
        if(forceRepeat && currentQuestion != null) {
            injectQuestion(
                question = currentQuestion,
                isMistake = false
            )
        }

        // browsing history
        return withContext(Dispatchers.Default) {
            if(currentHistoryIndex.plus(1) < history.size) {
                history.getOrNull(++currentHistoryIndex)?.let { question ->
                    SessionQuestion(
                        isHistory = true,
                        historyItem = question,
                        correctAnswers = question.answers.filter { it.isCorrect }.map { it.uid }
                    )
                }
            }else {
                questionsStack.getOrNull(currentQuestionIndex)?.let { question ->
                    history.add(SessionHistoryItem(
                        questionIO = question,
                        index = currentQuestionIndex,
                        answers = responseList.toList(),
                        timeElapsed = timeElapsed,
                    ))
                    currentHistoryIndex = history.size.minus(1)
                }
                if(currentQuestionIndex >= questionsStack.size.minus(1)) {
                    // adding one right after this, can't start with 0
                    currentQuestionIndex = -1
                    questionsStack.clear()
                    questionsStack.addAll(questions.shuffled())

                }
                questionsStack.getOrNull(++currentQuestionIndex)?.let { question ->
                    SessionQuestion(
                        isHistory = false,
                        question = question,
                        correctAnswers = question.answers.filter { it.isCorrect }.map { it.uid }
                    )
                }
            }
        }
    }

    /** retrieves current step position without changing any data */
    fun getCurrentStep(): SessionQuestion? {
        if(questions.isEmpty()) return null
        // browsing history
        return if(currentHistoryIndex < history.size) {
            history.getOrNull(currentHistoryIndex)?.let { question ->
                SessionQuestion(
                    isHistory = true,
                    historyItem = question,
                    correctAnswers = question.answers.filter { it.isCorrect }.map { it.uid }
                )
            }
        }else {
            questionsStack.getOrNull(currentQuestionIndex)?.let { question ->
                SessionQuestion(
                    isHistory = false,
                    question = question,
                    correctAnswers = question.answers.filter { it.isCorrect }.map { it.uid }
                )
            }
        }
    }

    /** steps backwards in history */
    @Ignore
    suspend fun stepBackward(): SessionQuestion? {
        if(history.isEmpty() || currentHistoryIndex.minus(1) < 0) return null
        currentHistoryIndex = 0

        return withContext(Dispatchers.Default) {
            history.getOrNull(--currentHistoryIndex)?.let { question ->
                SessionQuestion(
                    isHistory = true,
                    historyItem = question,
                    correctAnswers = question.answers.filter { it.isCorrect }.map { it.uid }
                )
            }
        }
    }

    /** Injects question into future steps in order to repeat it */
    fun injectQuestion(
        question: QuestionIO,
        isMistake: Boolean
    ) {
        if(isMistake) {
            injectQuestionOnce(question, 3, true)
            injectQuestionOnce(question, 10, true)
            injectQuestionOnce(question, 30, isMistake = true)
            injectQuestionOnce(question, 999999, true)
        }else {
            injectQuestionOnce(question, 6, isMistake = false)
            injectQuestionOnce(question, 16, isMistake = false)
        }
    }

    /** Injects a question into the stack once */
    private fun injectQuestionOnce(
        question: QuestionIO,
        index: Int,
        isMistake: Boolean
    ) {
        val newIndex = this.currentQuestionIndex.plus(index)
        if(newIndex < questionsStack.size) {
            questionsStack.add(newIndex, question)
        }else if(isMistake) {
            questionsStack.add(question)
        }
    }
}