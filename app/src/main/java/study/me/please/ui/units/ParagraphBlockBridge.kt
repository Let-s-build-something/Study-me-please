package study.me.please.ui.units

interface ParagraphBlockBridge {

    /** Adds a new nested fact and saves TO */
    fun addFact(
        element: UnitsViewModel.ElementToDrag
    )

    /** removes a fact based on its uid from the UI layer */
    fun removeUiFact(uid: String)

    /** Requests a paste of current clipboard data */
    fun requestFactsPaste()

    /** Adds a new nested paragraph and saves TO */
    fun addParagraph(
        element: UnitsViewModel.ElementToDrag
    )

    /** removes a paragraph based on its uid from the UI layer */
    fun removeUiParagraph(uid: String)

    /** Adds a new bullet point */
    fun addNewBulletPoint(
        index: Int = 0,
        bulletPoint: String? = null
    )

    /** Removes a bullet point */
    fun removeBulletPoint(index: Int = 0)

    /** Updates a bullet point */
    fun updateBulletPoint(index: Int = 0, output: String)

    /** Refreshes the state of the block to reverse the changes in the paragraph */
    fun invalidate()
}