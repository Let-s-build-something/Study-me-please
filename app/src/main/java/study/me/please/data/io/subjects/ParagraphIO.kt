package study.me.please.data.io.subjects

import androidx.room.Ignore
import study.me.please.data.io.FactIO
import java.io.Serializable
import java.util.UUID

/** Object identified by category, containing facts */
data class ParagraphIO(
    /** unique identifier */
    val uid: String = UUID.randomUUID().toString(),

    /** By what category this object is identified */
    var categoryUid: String? = null,

    /** Basic text information about this paragraph */
    var bulletPoints: List<String> = listOf(),

    /** Further categorized content */
    var paragraphs: List<ParagraphIO> = listOf(),

    /** Non-categorized, standalone content */
    var facts: List<FactIO> = listOf()
): Serializable {

    /** Locally saved category associated with this paragraph */
    @Ignore
    var localCategory: CategoryIO? = null

    /** Updates this object with new object */
    fun updateTO(newTO: ParagraphIO) {
        categoryUid = newTO.categoryUid
        bulletPoints = newTO.bulletPoints
        paragraphs = newTO.paragraphs
        facts = newTO.facts
    }
}