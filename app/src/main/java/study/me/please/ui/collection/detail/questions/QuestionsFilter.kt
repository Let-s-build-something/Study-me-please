package study.me.please.ui.collection.detail.questions

import study.me.please.data.io.BasicSorter

/** data structure for saving filter of facts */
data class QuestionsFilter(

    /** text filter */
    val text: String = "",

    /** whether we want to see questions with images inside */
    val hasImage: Boolean = false,

    /** whether we want to see invalid questions - with no correct answer or not enough answers */
    val isInvalid: Boolean = false,

    /** Type of sorting */
    val sortBy: SortByType = SortByType.DATE_CREATED_DESC
) {
    /** checks whether this filter is empty or not */
    fun isEmpty() = text.isEmpty()
            && hasImage.not()
            && isInvalid.not()
}

/** Types of sorting questions */
enum class SortByType(override val isDescending: Boolean = false): BasicSorter {
    DATE_CREATED_ASC,
    DATE_CREATED_DESC(isDescending = true);
}