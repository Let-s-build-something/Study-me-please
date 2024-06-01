package study.me.please.data.io.subjects

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.firebase.firestore.Exclude
import com.google.gson.annotations.SerializedName
import com.squadris.squadris.utils.DateUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.FactIO
import study.me.please.data.io.LargePathAsset
import study.me.please.data.room.AppRoomDatabase
import java.io.Serializable
import java.util.UUID

/** Object identified by category, containing facts */
@Entity(tableName = AppRoomDatabase.ROOM_PARAGRAPH_TABLE)
data class ParagraphIO(

    /** unique identifier */
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString(),

    /** Basic text information about this paragraph */
    var bulletPoints: MutableList<String> = mutableListOf(""),

    /** list of paragraph unique identifiers */
    var paragraphUidList: MutableList<String> = mutableListOf(),

    /** list of fact unique identifiers */
    var factUidList: MutableList<String> = mutableListOf(),

    /** Name of the paragraph */
    var name: String = "",

    /** date of creating of this object */
    val dateCreated: Long = DateUtils.now.timeInMillis,

    /** Image which can be questioned as well as answered with */
    @SerializedName("prompt_mage")
    var imageAsset: LargePathAsset? = null,
): Serializable {

    /** Further categorized content */
    @Ignore
    var paragraphs: MutableList<ParagraphIO> = mutableListOf()

    /** Non-categorized, standalone content */
    @Ignore
    var facts: MutableList<FactIO> = mutableListOf()

    /** Whether this data can be taken seriously */
    suspend fun isSeriousDataPoint() = withContext(Dispatchers.Default) {
        bulletPoints.any { it.isNotBlank() } && name.isBlank().not()
    }

    /** attempts to remove a paragraph */
    fun removeParagraph(uid: String): Boolean {
        return paragraphUidList.remove(uid).also {
            if(it) paragraphs.removeIf { data -> data.uid == uid }
        }
    }

    /** adds a paragraph */
    fun addParagraph(index: Int, paragraph: ParagraphIO) {
        val safeIndex = index.coerceIn(0, paragraphs.size)
        paragraphUidList.add(safeIndex, paragraph.uid)
        paragraphs.add(safeIndex, paragraph)
    }

    /** adds a fact */
    fun addFact(index: Int, fact: FactIO) {
        val safeIndex = index.coerceIn(0, facts.size)
        factUidList.add(safeIndex, fact.uid)
        facts.add(safeIndex, fact)
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

    /** Updates this object with new object */
    fun updateTO(newTO: ParagraphIO) {
        bulletPoints = newTO.bulletPoints
        paragraphUidList = newTO.paragraphUidList
        factUidList = newTO.factUidList
        name = newTO.name
        paragraphs = newTO.paragraphs
        facts = newTO.facts
    }

    @Ignore
    @Exclude
    override fun toString(): String {
        return "{" +
                "uid: $uid," +
                "bulletPoints: $bulletPoints," +
                "paragraphs: $paragraphs," +
                "paragraphUidList: $paragraphUidList," +
                "factUidList: $factUidList" +
                "facts: $facts" +
                "name: $name" +
                "}"
    }

    @Ignore
    @Exclude
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ParagraphIO

        if (uid != other.uid) return false
        if (bulletPoints != other.bulletPoints) return false
        if (paragraphUidList != other.paragraphUidList) return false
        if (factUidList != other.factUidList) return false
        if (name != other.name) return false
        if (dateCreated != other.dateCreated) return false
        if (imageAsset != other.imageAsset) return false
        if (paragraphs != other.paragraphs) return false
        if (facts != other.facts) return false

        return true
    }

    @Ignore
    @Exclude
    override fun hashCode(): Int {
        var result = uid.hashCode()
        result = 31 * result + bulletPoints.hashCode()
        result = 31 * result + paragraphUidList.hashCode()
        result = 31 * result + factUidList.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + dateCreated.hashCode()
        result = 31 * result + (imageAsset?.hashCode() ?: 0)
        result = 31 * result + paragraphs.hashCode()
        result = 31 * result + facts.hashCode()
        return result
    }
}