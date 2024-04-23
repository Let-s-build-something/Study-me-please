package study.me.please.ui.units

import kotlinx.coroutines.flow.MutableStateFlow
import study.me.please.data.io.UnitElement
import javax.inject.Inject

class UnitDataManager @Inject constructor() {
    /** list of all elements within this unit */
    val elements = MutableStateFlow<List<UnitElement>>(listOf())

    /** list of all collapsed paragraphs */
    val collapsedParagraphs = MutableStateFlow<List<String>>(listOf())
}