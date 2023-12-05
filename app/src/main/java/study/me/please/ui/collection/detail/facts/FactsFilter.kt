package study.me.please.ui.collection.detail.facts

import study.me.please.data.io.FactType
import study.me.please.ui.collection.detail.questions.SortByType

/** data structure for saving filter of facts */
data class FactsFilter(
    /** text filter */
    val textFilter: String = "",
    
    /** [FactType] restriction */
    val types: List<FactType> = listOf(),

    /** Type of sorting */
    val sortBy: SortByType = SortByType.DATE_CREATED_DESC
) {
    /** checks whether this filter is empty or not */
    fun isEmpty() = textFilter.isEmpty()
            && types.isEmpty()
}