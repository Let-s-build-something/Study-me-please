package study.me.please.data.io

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.firebase.firestore.Exclude
import com.google.gson.annotations.SerializedName
import com.squadris.squadris.utils.DateUtils
import study.me.please.data.io.subjects.UnitIO
import study.me.please.data.room.AppRoomDatabase
import java.io.Serializable
import java.util.UUID

/** Collection of questions */
@Entity(tableName = AppRoomDatabase.ROOM_COLLECTION_TABLE)
data class CollectionIO @JvmOverloads constructor(

    /** short name of the collection */
    var name: String = "",

    /** list of all category identifiers */
    val categoryUidList: MutableList<String> = mutableListOf(),

    /** more detailed text description */
    var description: String = "",

    /** icon of the collection */
    val icon: LargePathAsset? = null,

    /** what date was this collection created */
    @SerializedName("date_created")
    @ColumnInfo(name = "date_created")
    var dateCreated: Long? = null,

    /** last time this data object was modified */
    @SerializedName("date_modified")
    @ColumnInfo(name = "date_modified")
    var dateModified: Long = DateUtils.now.timeInMillis,

    /** unique identifier */
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString(),

    /** list of all question identifiers contained in this collection */
    var questionUidList: MutableList<String> = mutableListOf(),

    /** list of all fact identifiers related to this collection */
    var factUidList: MutableList<String> = mutableListOf(),

    /** user who manages this collection */
    var authorUid: String? = null,

    /** index of last selected unit */
    @Exclude
    var lastSelectedUnitIndex: Int = 0
): Serializable {

    /** list of all units, received only from firebase */
    @Ignore
    var units: Map<String, UnitIO> = mapOf()

    /** list of all questions, received only from firebase */
    @Ignore
    var questions: List<QuestionIO> = listOf()

    /** Checks whether object contains any non-default data */
    @get:Exclude
    val isNotEmpty: Boolean
        get() = (dateCreated != null
            || name.isNotEmpty()
            || description.isNotEmpty()
            || questionUidList.isNotEmpty())

    override fun toString(): String {
        return "{" +
            "questionUids: $questionUidList" +
            "categoryUidList: $categoryUidList" +
            "name: $name" +
            "description: $description" +
            "icon: $icon" +
            "units: $units" +
            "dateCreated: $dateCreated" +
            "dateModified: $dateModified," +
            "authorUid: $authorUid," +
            "uid: $uid," +
            "}"
    }

    /** creates a new instance from this */
    @Exclude
    @Ignore
    fun newInstance(authorUid: String?): CollectionIO {
        return CollectionIO(
            dateCreated = DateUtils.now.timeInMillis,
            authorUid = authorUid,
            name = name,
            description = description,
            icon = icon,
            questionUidList = questionUidList
        ).also { newInstance ->
            newInstance.units = units.onEach { it.value.collectionUid = newInstance.uid }
            newInstance.questions = questions
        }
    }
}