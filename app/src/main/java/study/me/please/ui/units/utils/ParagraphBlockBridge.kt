package study.me.please.ui.units.utils

import study.me.please.data.io.FactIO
import study.me.please.data.io.UnitElement
import study.me.please.data.io.subjects.ParagraphIO

interface ParagraphBlockBridge {

    /** Adds a new element from dragged source into recently activated paragraph */
    fun addNewElement()

    /**
     * Add element into the elements list layout after it being dropped from drag and drop
     * @param nestUnder whether the element should be nested under the target element
     */
    fun onItemDropped(
        element: UnitElement?,
        index: Int,
        nestUnder: Boolean = false
    )

    /** Adds a new bullet point */
    fun addNewBulletPoint(
        index: Int = 0,
        bulletPoint: String? = null
    )

    /** Removes a bullet point */
    fun removeBulletPoint(index: Int = 0)

    /** Updates a paragraph */
    fun updateParagraph(newTO: ParagraphIO)

    /** Updates a fact */
    fun updateFact(newTO: FactIO)

    /** Updates a bullet point */
    fun updateBulletPoint(index: Int = 0, output: String)

    /** Refreshes the state of the block to reverse the changes in the paragraph */
    fun invalidate()
}