package study.me.please.ui.collection.detail.subjects

import study.me.please.data.io.subjects.ParagraphIO

/** Communication bridge and main controller for SubjectScreen */
interface SubjectScreenBridge {
    /*
    *//** Adds new bullet point at any layer, identified by [parentUid] *//*
    fun addBulletPoint(parentUid: String)

    *//** Removes a bullet point at any layer, identified by [parentUid] and [index] within parent *//*
    fun removeBulletPoint(parentUid: String, index: Int)
*/

    fun updateSubjectBulletPoints()
    fun updateParagraph(paragraph: ParagraphIO)
    fun addSubjectParagraph()
    fun addSubjectBulletPoint()
}