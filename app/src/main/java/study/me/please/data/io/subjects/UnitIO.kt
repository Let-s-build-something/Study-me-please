package study.me.please.data.io.subjects

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.firebase.firestore.Exclude
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
    var collapsedParagraphs: List<String> = listOf(),

    /** last visible item within scroll field */
    var firstVisibleItemIndex: Int = 0,

    /** last Y direction scroll offset from [firstVisibleItemIndex] */
    var firstVisibleItemOffset: Int = 0,

    /** last paragraph that was focused */
    var activatedParagraph: String? = null,
): Serializable {

    /** Categorized content */
    @Ignore
    val paragraphs: MutableList<ParagraphIO> = mutableListOf()

    /** Non-categorized, standalone content */
    @Ignore
    val facts: MutableList<FactIO> = mutableListOf()

    /** attempts to remove a paragraph */
    @Exclude
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
    @Exclude
    fun removeFact(uid: String): Boolean {
        return factUidList.remove(uid).also {
            if(it) facts.removeIf { data -> data.uid == uid }
        }
    }

    /** Whether this data can be taken seriously */
    @Exclude
    suspend fun isSeriousDataPoint(): Boolean = withContext(Dispatchers.Default) {
        bulletPoints.any { it.isNotBlank() } && name.isNotEmpty()
    }

    /** Updates this object with new subject [subject] */
    fun updateTO(subject: UnitIO) {
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

    @Ignore
    @Exclude
    override fun toString(): String {
        return "{" +
                "uid: $uid" +
                "bulletPoints: $bulletPoints," +
                "paragraphUidList: $paragraphUidList," +
                "factUidList: $factUidList," +
                "facts: $facts," +
                "paragraphs: $paragraphs," +
                "name: $name," +
                "collectionUid: $collectionUid," +
                "dateCreated: $dateCreated" +
                "}"
    }

    @Ignore
    @Exclude
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UnitIO

        if (uid != other.uid) return false
        if (bulletPoints != other.bulletPoints) return false
        if (paragraphUidList != other.paragraphUidList) return false
        if (factUidList != other.factUidList) return false
        if (name != other.name) return false
        if (collectionUid != other.collectionUid) return false
        if (dateCreated != other.dateCreated) return false
        if (collapsedParagraphs != other.collapsedParagraphs) return false
        if (firstVisibleItemIndex != other.firstVisibleItemIndex) return false
        if (firstVisibleItemOffset != other.firstVisibleItemOffset) return false
        if (activatedParagraph != other.activatedParagraph) return false
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
        result = 31 * result + collectionUid.hashCode()
        result = 31 * result + dateCreated.hashCode()
        result = 31 * result + collapsedParagraphs.hashCode()
        result = 31 * result + firstVisibleItemIndex
        result = 31 * result + firstVisibleItemOffset
        result = 31 * result + (activatedParagraph?.hashCode() ?: 0)
        result = 31 * result + paragraphs.hashCode()
        result = 31 * result + facts.hashCode()
        return result
    }
}