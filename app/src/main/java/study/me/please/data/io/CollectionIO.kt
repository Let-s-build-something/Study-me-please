package study.me.please.data.io

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.squadris.squadris.utils.DateUtils
import study.me.please.data.room.AppRoomDatabase
import java.io.Serializable
import java.util.Date
import java.util.UUID

/** Collection of questions */
@Entity(tableName = AppRoomDatabase.ROOM_COLLECTION_TABLE)
data class CollectionIO(

    /** list of all questions */
    var questions: MutableList<QuestionIO> = mutableListOf(),

    /** What preferences are set to a session by default, only in session with one collection */
    @SerializedName("default_preference")
    val defaultPreference: UserPromptPreferences = UserPromptPreferences(),

    /** short name of the collection */
    var name: String = "",

    /** more detailed text description */
    var description: String = "",

    /** icon of the collection */
    val icon: LargePathAsset? = null,

    /** what date was this collection created */
    @SerializedName("date_created")
    @ColumnInfo(name = "date_created")
    var dateCreated: Date? = null,

    /** last time this data object was modified */
    @SerializedName("date_modified")
    @ColumnInfo(name = "date_modified")
    var dateModified: Date? = DateUtils.now.time,

    /** unique identifier */
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString(),

    //TODO
    val tasks: List<String> = listOf()
): Serializable {

    /** Checks whether object contains any non-default data */
    val isNotEmpty: Boolean
        get() = dateCreated != null
            || name.isNotEmpty()
            || description.isNotEmpty()
            || questions.isNotEmpty()

    override fun toString(): String {
        return "{" +
            "questions: $questions" +
            "defaultPreference: $defaultPreference" +
            "name: $name" +
            "description: $description" +
            "icon: $icon" +
            "dateCreated: $dateCreated" +
            "dateModified: $dateModified," +
            "uid: $uid," +
            "task: $tasks" +
            "}"
    }
}