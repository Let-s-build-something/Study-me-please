package study.me.please.data.io.subjects

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.squadris.squadris.utils.DateUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.FactIO
import study.me.please.data.room.AppRoomDatabase.Companion.ROOM_UNIT_TABLE
import java.io.Serializable
import java.util.UUID

/** Primary IO responsible for saving subjects */
@Entity(tableName = ROOM_UNIT_TABLE)
data class UnitIO(

    /** unique identifier */
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString(),

    /** list of all categories by which this subject is categorized */
    var categoryUids: List<String> = listOf(),

    /**
     * Text-based points ideally specific to this subject,
     * non-specificity should be handled by quantity
     */
    var bulletPoints: MutableList<String> = mutableListOf(""),

    /** list of paragraph unique identifiers */
    var paragraphUidList: MutableList<String> = mutableListOf(),

    /** list of fact unique identifiers */
    var factUidList: MutableList<String> = mutableListOf(),

    /** non-unique user identification */
    var name: String = "",

    /** identifier of a collection holding this subject */
    @SerializedName("collection_uid")
    @ColumnInfo("collection_uid")
    val collectionUid: String,

    /** date of creation of this data object */
    @SerializedName("date_created")
    @ColumnInfo("date_created")
    val dateCreated: Long = DateUtils.now.timeInMillis,

    /** list of all collapsed paragraphs - they are expanded by default */
    var collapsedParagraphs: List<String> = listOf()
): Serializable {

    /** Categorized content */
    @Ignore
    val paragraphs: MutableList<ParagraphIO> = mutableListOf()

    /** Non-categorized, standalone content */
    @Ignore
    val facts: MutableList<FactIO> = mutableListOf()

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

    /** Whether this data can be taken seriously */
    suspend fun isSeriousDataPoint(): Boolean = withContext(Dispatchers.Default) {
        bulletPoints.any { it.isNotBlank() } && name.isNotEmpty()
    }

    /** Updates this object with new subject [subject] */
    fun updateTO(subject: UnitIO) {
        this.categoryUids = subject.categoryUids
        this.bulletPoints = subject.bulletPoints
        this.paragraphs.clear()
        this.facts.clear()
        this.paragraphs.addAll(subject.paragraphs)
        this.facts.addAll(subject.facts)
        this.paragraphUidList = subject.paragraphUidList
        this.collapsedParagraphs = subject.collapsedParagraphs
        this.factUidList = subject.factUidList
        this.name = subject.name
    }

    override fun toString(): String {
        return super.toString() +
                "{" +
                "uid: $uid" +
                "categoryUids: $categoryUids," +
                "bulletPoints: $bulletPoints," +
                "paragraphUidList: $paragraphUidList," +
                "factUidList: $factUidList," +
                "facts: $facts," +
                "name: $name," +
                "collectionUid: $collectionUid," +
                "dateCreated: $dateCreated" +
                "}"
    }
}