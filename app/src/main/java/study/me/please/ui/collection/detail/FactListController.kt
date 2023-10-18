package study.me.please.ui.collection.detail

/** interface for interacting with list of facts */
interface FactListController {
    fun onFactAdded()
    fun stopChecking()
    fun onDeleteRequest()
    fun onGenerateQuestionsRequest()
}