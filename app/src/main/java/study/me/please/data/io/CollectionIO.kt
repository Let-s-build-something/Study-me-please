package study.me.please.data.io

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import study.me.please.data.room.AppRoomDatabase
import java.io.Serializable
import java.util.Date
import java.util.UUID

/** Collection of questions */
@Entity(tableName = AppRoomDatabase.ROOM_COLLECTION_TABLE)
data class CollectionIO(

    /** list of all questions */
    val questions: List<QuestionIO> = listOf(),

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
    val dateCreated: Date? = null,

    /** unique identifier */
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString(),

    //TODO
    val tasks: List<String> = listOf()
): Serializable