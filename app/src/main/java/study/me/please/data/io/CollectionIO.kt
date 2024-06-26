package study.me.please.data.io

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.firebase.firestore.Exclude
import com.google.gson.annotations.SerializedName
import com.squadris.squadris.utils.DateUtils
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.data.io.subjects.UnitIO
import study.me.please.data.room.AppRoomDatabase
import java.io.Serializable
import java.util.UUID

/** Collection of questions */
@Entity(tableName = AppRoomDatabase.ROOM_COLLECTION_TABLE)
data class CollectionIO(

    /** What preferences are set to a session by default, only in session with one collection */
    @SerializedName("default_preference")
    val defaultPreference: SessionPreferencePack = SessionPreferencePack(),

    /** short name of the collection */
    var name: String = "",

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
    var userUid: String? = null
): Serializable {

    /** list of all units, received only from firebase */
    @Ignore
    val units: Map<String, UnitIO> = mapOf()

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
            "defaultPreference: $defaultPreference" +
            "name: $name" +
            "description: $description" +
            "icon: $icon" +
            "dateCreated: $dateCreated" +
            "dateModified: $dateModified," +
            "uid: $uid," +
            "}"
    }
}