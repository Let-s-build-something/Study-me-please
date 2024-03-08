package study.me.please.data.io.subjects

import androidx.room.ColumnInfo
import androidx.room.Entity
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
     * Text-based points ideally specific to this subject, non-specificity should be handled by quantity
     */
    var bulletPoints: MutableList<String> = mutableListOf(""),

    /** Categorized content */
    @Deprecated("should be ignored by Room")
    var paragraphs: List<ParagraphIO> = listOf(),

    /** list of paragraph unique identifiers */
    var paragraphUidList: MutableList<String> = mutableListOf(),

    /** Non-categorized, standalone content */
    @Deprecated("Current UI doesn't make sense to have facts under subject")
    var facts: List<FactIO> = listOf(),

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

    /** Whether this data can be taken seriously */
    suspend fun isSeriousDataPoint(): Boolean = withContext(Dispatchers.Default) {
        bulletPoints.any { it.isNotBlank() } && name.isNotEmpty()
    }

    /** Updates this object with new subject [subject] */
    fun updateTO(subject: UnitIO) {
        this.categoryUids = subject.categoryUids
        this.bulletPoints = subject.bulletPoints
        this.paragraphs = subject.paragraphs
        this.paragraphUidList = subject.paragraphUidList
        this.collapsedParagraphs = subject.collapsedParagraphs
        this.facts = subject.facts
        this.name = subject.name
    }

    override fun toString(): String {
        return super.toString() +
                "{" +
                "uid: $uid" +
                "categoryUids: $categoryUids," +
                "bulletPoints: $bulletPoints," +
                "paragraphs: $paragraphs," +
                "facts: $facts," +
                "name: $name," +
                "collectionUid: $collectionUid," +
                "dateCreated: $dateCreated" +
                "}"
    }
}