package study.me.please.data.io.subjects

import androidx.room.Entity
import androidx.room.Ignore
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

    /** list of paragraph unique identifiers */
    var paragraphUidList: MutableList<String> = mutableListOf(),

    /** list of fact unique identifiers */
    var factUidList: MutableList<String> = mutableListOf(),
): Serializable {

    /** Further categorized content */
    @Ignore
    var paragraphs: MutableList<ParagraphIO> = mutableListOf()

    /** Non-categorized, standalone content */
    @Ignore
    var facts: MutableList<FactIO> = mutableListOf()

    /** Makes a full copy with a new UID */
    fun deepCopy() = ParagraphIO(
        uid = UUID.randomUUID().toString(),
        categoryUid = categoryUid,
        bulletPoints = bulletPoints,
        paragraphUidList = paragraphUidList,
        factUidList = factUidList
    ).apply {
        paragraphs = this@ParagraphIO.paragraphs
        facts = this@ParagraphIO.facts
    }

    /** Whether this data can be taken seriously */
    suspend fun isSeriousDataPoint() = withContext(Dispatchers.Default) {
        bulletPoints.any { it.isNotBlank() } && categoryUid.isNullOrEmpty().not()
    }

    /** attempts to remove a paragraph */
    fun removeParagraph(uid: String): Boolean {
        return paragraphUidList.remove(uid).also {
            if(it) paragraphs.removeIf { data -> data.uid == uid }
        }
    }

    /** adds a paragraph */
    fun addParagraph(index: Int, paragraph: ParagraphIO) {
        paragraphUidList.add(index, paragraph.uid)
        paragraphs.add(index, paragraph)
    }

    /** adds a fact */
    fun addFact(index: Int, fact: FactIO) {
        factUidList.add(index, fact.uid)
        facts.add(index, fact)
    }

    /** attempts to remove a fact */
    fun removeFact(uid: String): Boolean {
        return factUidList.remove(uid).also {
            if(it) facts.removeIf { data -> data.uid == uid }
        }
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
        paragraphUidList = newTO.paragraphUidList
        factUidList = newTO.factUidList
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
                "paragraphUidList: $paragraphUidList," +
                "factUidList: $factUidList" +
                "facts: $facts" +
                "}"
    }
}