package study.me.please.ui.collection.detail.questions

import study.me.please.data.io.QuestionIO

/** interface for interacting with list of questions */
interface QuestionsListController {
    fun addQuestion()
    fun deleteQuestions()
    fun openQuestion(question: QuestionIO)
    fun copyItems()
}