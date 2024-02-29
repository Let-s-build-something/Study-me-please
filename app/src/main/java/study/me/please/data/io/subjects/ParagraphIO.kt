package study.me.please.data.io.subjects

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.FactIO
import study.me.please.data.room.AppRoomDatabase
import java.io.Serializable
import java.util.UUID

/** Object identified by category, containing facts */
@Entity(tableName = AppRoomDatabase.ROOM_PARAGRAPH_TABLE)
data class ParagraphIO(

    /** unique identifier */
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString(),

    /** By what category this object is identified */
    var categoryUid: String? = null,

    /** Basic text information about this paragraph */
    var bulletPoints: MutableList<String> = mutableListOf(""),

    /** Further categorized content */
    var paragraphs: MutableList<ParagraphIO> = mutableListOf(),

    /** Non-categorized, standalone content */
    var facts: MutableList<FactIO> = mutableListOf()
): Serializable {

    /** Whether this data can be taken seriously */
    suspend fun isSeriousDataPoint() = withContext(Dispatchers.Default) {
        bulletPoints.any { it.isNotBlank() }
                && categoryUid.isNullOrEmpty().not()
    }

    /** Whether this data is empty or not */
    val isEmpty: Boolean
        get() = bulletPoints.isEmpty() && paragraphs.isEmpty() && facts.isEmpty()

    /** Locally saved category associated with this paragraph */
    var localCategory: CategoryIO? = null

    /** Updates this object with new object */
    fun updateTO(newTO: ParagraphIO) {
        categoryUid = newTO.categoryUid
        bulletPoints = newTO.bulletPoints
        paragraphs = newTO.paragraphs
        facts = newTO.facts
        localCategory = newTO.localCategory
    }

    override fun toString(): String {
        return super.toString() +
                "{" +
                "uid: $uid," +
                "categoryUid: $categoryUid," +
                "bulletPoints: $bulletPoints," +
                "paragraphs: $paragraphs," +
                "facts: $facts" +
                "}"
    }
}