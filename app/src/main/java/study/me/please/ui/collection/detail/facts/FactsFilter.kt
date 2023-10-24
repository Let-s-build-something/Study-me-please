package study.me.please.ui.collection.detail.facts

import study.me.please.data.io.FactType

/** data structure for saving filter of facts */
data class FactsFilter(
    /** text filter */
    val textFilter: String = "",
    
    /** [FactType] restriction */
    val types: List<FactType> = listOf()
) {
    /** checks whether this filter is empty or not */
    fun isEmpty() = textFilter.isEmpty()
            && types.isEmpty()
}