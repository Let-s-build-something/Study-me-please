package study.me.please.data.io.subjects

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.squadris.squadris.utils.DateUtils
import study.me.please.data.io.FactIO
import study.me.please.data.room.AppRoomDatabase.Companion.ROOM_SUBJECT_TABLE
import java.io.Serializable
import java.util.UUID

/** Primary IO responsible for saving subjects */
@Entity(tableName = ROOM_SUBJECT_TABLE)
data class SubjectIO(

    /** unique identifier */
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString(),

    /** list of all categories by which this subject is categorized */
    var categoryUids: List<String> = listOf(),

    /**
     * Text-based points ideally specific to this subject, non-specificity should be handled by quantity
     */
    var bulletPoints: MutableList<String> = mutableListOf(),

    /** Categorized content */
    var paragraphs: List<ParagraphIO> = listOf(),

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
    val dateCreated: Long = DateUtils.now.timeInMillis
): Serializable {

    /** Whether this data can be taken seriously */
    val isSeriousDataPoint: Boolean
        get() = bulletPoints.isNotEmpty() && name.isNotEmpty()

    /** Updates this object with new subject [subject] */
    fun updateTO(subject: SubjectIO) {
        this.categoryUids = subject.categoryUids
        this.bulletPoints = subject.bulletPoints
        this.paragraphs = subject.paragraphs
        this.facts = subject.facts
        this.name = subject.name
    }
}