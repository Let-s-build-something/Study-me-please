package study.me.please.ui.session

import study.me.please.data.io.QuestionIO
import study.me.please.data.io.SessionHistoryItem

/** UI data model for Session screen */
data class SessionQuestion(
    /** whether current item is historic - aka simulation of a [SessionScreenMode.LOCKED] */
    val isHistory: Boolean = false,

    /** information about historic question and answers */
    val historyItem: SessionHistoryItem? = null,

    /** current question to be answsered */
    val question: QuestionIO? = null,

    /** list of correct answers. Either from history or current question */
    val correctAnswers: List<String?>
)