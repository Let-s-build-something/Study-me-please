package study.me.please.data.state.session

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.squadris.squadris.utils.DateUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.StopwatchCounter
import study.me.please.data.io.session.QuestionItem
import study.me.please.data.io.session.SessionHistoryItem
import study.me.please.data.io.session.SessionIO
import study.me.please.data.io.session.SessionItem
import study.me.please.data.room.AppRoomDatabase
import java.util.UUID

/**
 * Module for sourcing and advancing within provided data set
 */
@Entity(tableName = AppRoomDatabase.ROOM_QUESTION_MODULE_TABLE)
data class QuestionModule(

    /** foreign key for a [SessionIO] item that holds this module */
    var sessionUid: String? = null,

    @SerializedName("questions_stack")
    val questionsStack: MutableList<QuestionItem> = mutableListOf(),

    /** identifier */
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString(),

    /** history for displaying users' answers */
    val history: MutableList<SessionHistoryItem> = mutableListOf(),

    /** current index for both [history] and [questionsStack] */
    @SerializedName("current_index")
    var currentIndex: Int = 0
) {

    /** lazy loaded, local saving of questions for this module */
    @Ignore
    var questions: List<QuestionIO> = listOf()

    /** number of total items including history */
    @Ignore
    val totalItemsCount: MutableStateFlow<Int> = MutableStateFlow(history.size.plus(questionsStack.size))

    /** whether current index is historic */
    @get:Ignore
    val isHistory
        get() = currentIndex < history.size.minus(1) && history.isNotEmpty()


    /** stopwatch for counting time elapsed */
    @Ignore
    val stopwatch = StopwatchCounter()

    /** sets all te necessary data for running questions */
    suspend fun setData(questions: List<QuestionIO>) {
        withContext(Dispatchers.Default) {
            val questionUids = mutableListOf<String>()
            val questionItems = mutableListOf<QuestionItem>()

            this@QuestionModule.questions = questions
            this@QuestionModule.questions.forEach { question ->
                questionUids.add(question.uid)
                questionItems.add(QuestionItem(question.uid))
            }

            if(questionsStack.isEmpty()) {
                questionsStack.addAll(questionItems.shuffled().toMutableList())
            }else {
                // if any questions were added
                val allQuestions = questionsStack.map { it.uid }.plus(history.map { it.questionIO?.uid })
                questionItems.forEach { item ->
                    if(allQuestions.contains(item.uid).not()) {
                        questionsStack.add(item)
                    }
                }
                // if any questions were removed
                questionsStack.removeAll { questionUids.contains(it.uid).not() }
            }
            updateTotalBackStack()
        }
    }

    /** Called whenever a question is requested to be repeated in the backstack */
    fun repeatQuestion(currentItem: SessionItem?) {
        currentItem?.historyItem?.wasRepeated = true
        // we don't want to allow user to repeat it again
        currentItem?.isRepetition = true
        (currentItem?.data ?: currentItem?.historyItem?.questionIO)?.let { questionIO ->
            injectQuestion(
                question = questionIO,
                isMistake = false
            )
        }
    }

    /** retrieves current step position without changing any data */
    @Ignore
    fun getStepAt(index: Int = 0): SessionItem? {
        if(questions.isEmpty()) return null
        // browsing history
        return if(index < history.size) {
            history.getOrNull(index)?.let { historyItem ->
                SessionItem(
                    isHistory = true,
                    historyItem = historyItem,
                    isRepetition = historyItem.isRepetition
                )
            }
        }else {
            val newItem = questionsStack.getOrNull(index.minus(history.size))
            questions.find { it.uid == newItem?.uid }?.copy()?.let { question ->

                SessionItem(
                    isHistory = false,
                    data = question,
                    isRepetition = newItem?.isRepetition == true
                )
            }
        }
    }

    /**
     * Called whenever a new answered has been answered.
     * It is then removed from backstack and added to history
     */
    suspend fun onQuestionAnswered(historyItem: SessionHistoryItem) {
        withContext(Dispatchers.Default) {
            if(isHistory.not()) {
                history.lastOrNull()?.timeToAnswer = stopwatch.flush()
                history.lastOrNull()?.timeToContinue = DateUtils.now.timeInMillis
            }

            history.add(historyItem)
            questionsStack.removeAt(0)

            // if we reach end of the backstack, we reset all questions again
            if(questionsStack.isEmpty()) {
                questionsStack.addAll(questions.shuffled().map { QuestionItem(it.uid) })
            }

            updateTotalBackStack()
        }
    }

    /** Injects question into future steps in order to repeat it */
    fun injectQuestion(
        question: QuestionIO,
        isMistake: Boolean
    ) {
        if(isMistake) {
            injectQuestionOnce(question, 3)
            injectQuestionOnce(question, 10)
            injectQuestionOnce(question, 30)
            injectQuestionOnce(question, 999999)
        }else {
            injectQuestionOnce(question, 6)
            injectQuestionOnce(question, 16)
        }
        updateTotalBackStack()
    }

    /** Injects a question into the stack once */
    private fun injectQuestionOnce(
        question: QuestionIO,
        index: Int
    ) {
        if(index < questionsStack.size) {
            questionsStack.add(index, QuestionItem(question.uid, isRepetition = true))
        }else {
            questionsStack.add(QuestionItem(question.uid, isRepetition = true))
        }
    }

    /** updates the overall item count of backstack */
    private fun updateTotalBackStack() {
        totalItemsCount.value = history.size.plus(questionsStack.size)
    }
}