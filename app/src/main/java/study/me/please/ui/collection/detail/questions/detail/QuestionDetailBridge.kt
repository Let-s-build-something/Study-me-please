package study.me.please.ui.collection.detail.questions.detail

import study.me.please.data.io.QuestionAnswerIO

/** Main communication bridge for question detail */
interface QuestionDetailBridge {

    /** stops checking the items */
    fun stopChecking()

    /** request to delete question answers and update data */
    fun deleteAnswers(uids: List<String>)

    /** updates current question detail from local state value */
    fun updateQuestion()

    /** Add a new question to the data object */
    fun addNewAnswer()

    /** Updates single answer with different data */
    fun updateAnswer(answer: QuestionAnswerIO)

    /** Handles the request to paste copied answers */
    fun pasteRequest()
}