package study.me.please.ui.collection.detail.questions

/** data structure for saving filter of facts */
data class QuestionsFilter(

    /** text filter */
    val text: String = "",

    /** whether we want to see questions with images inside */
    val hasImage: Boolean = false,

    /** whether we want to see invalid questions - with no correct answer or not enough answers */
    val isInvalid: Boolean = false
) {
    /** checks whether this filter is empty or not */
    fun isEmpty() = text.isEmpty()
            && hasImage.not()
            && isInvalid.not()
}