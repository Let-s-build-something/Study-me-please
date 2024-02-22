package study.me.please.ui.units

import study.me.please.data.io.subjects.ParagraphIO

/** Communication bridge and main controller for SubjectScreen */
interface UnitScreenBridge {
    /*
    *//** Adds new bullet point at any layer, identified by [parentUid] *//*
    fun addBulletPoint(parentUid: String)

    *//** Removes a bullet point at any layer, identified by [parentUid] and [index] within parent *//*
    fun removeBulletPoint(parentUid: String, index: Int)
*/

    fun updateBulletPoints()
    fun updateParagraph(paragraph: ParagraphIO)
    fun addParagraph()
    suspend fun removeParagraph(uid: String)
    fun addBulletPoint()
}