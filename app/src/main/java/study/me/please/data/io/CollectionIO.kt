package study.me.please.data.io

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.firebase.firestore.Exclude
import com.google.gson.annotations.SerializedName
import com.squadris.squadris.utils.DateUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
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
    val dateCreated: Long? = DateUtils.now.timeInMillis,

    /** last time this data object was modified */
    @SerializedName("date_modified")
    @ColumnInfo(name = "date_modified")
    var dateModified: Long = DateUtils.now.timeInMillis,

    /** unique identifier */
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString(),

    /** user who manages this collection */
    var authorUid: String? = null
): Serializable {

    /** list of all question identifiers contained in this collection */
    @Exclude
    var questionUidList: MutableList<String> = mutableListOf()

    /** index of last selected unit */
    @Exclude
    var lastSelectedUnitIndex: Int = 0

    /** list of all units, received only from firebase */
    @Ignore
    var units: Map<String, UnitIO> = mapOf()

    /** list of all questions, received only from firebase */
    @Ignore
    var questions: Map<String, QuestionIO> = mapOf()

    /** Checks whether object contains any non-default data */
    @get:Exclude
    @get:Ignore
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
    suspend fun newInstance(authorUid: String?): CollectionIO {
        return withContext(Dispatchers.Default) {
            CollectionIO(
                dateCreated = DateUtils.now.timeInMillis,
                authorUid = authorUid,
                name = name,
                description = description,
                icon = icon
            ).also { newInstance ->
                newInstance.units = units.onEach { it.value.collectionUid = newInstance.uid }
                newInstance.questions = questions
                newInstance.questionUidList = questions.map { it.key }.toMutableList()
                newInstance.questionUidList = questionUidList
            }
        }
    }
}