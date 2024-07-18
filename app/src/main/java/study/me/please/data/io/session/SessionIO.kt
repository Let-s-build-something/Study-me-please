package study.me.please.data.io.session

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.firebase.firestore.Exclude
import com.google.gson.annotations.SerializedName
import com.squadris.squadris.utils.DateUtils
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.data.room.AppRoomDatabase
import java.io.Serializable
import java.util.UUID

/**
 * Data storage for a questioning session
 */
@Entity(tableName = AppRoomDatabase.ROOM_SESSION_TABLE)
data class SessionIO(

    /** user name of this session */
    var name: String = "",

    /** identification */
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString(),

    /** saved question module for control and history of questioning */
    var questionModuleUid: String? = null,

    /** user preferences for the session behavior */
    val preferencePack: SessionPreferencePack? = SessionPreferencePack(),

    /** hash of the last snapshot of objects selected */
    var lastSnapshotHash: String? = null,

    /** What was the last time this session was played */
    @SerializedName("date_created")
    @ColumnInfo(name = "date_created")
    val dateCreated: Long = DateUtils.now.timeInMillis,

    /** What was the last time this session was played */
    @SerializedName("last_played")
    @ColumnInfo(name = "last_played")
    var lastPlayed: Long = dateCreated,

    /** all current collections in this session */
    val collectionUidList: MutableSet<String> = mutableSetOf(),

    /** all current questions in this session */
    val questionUidList: MutableSet<String> = mutableSetOf()
): Serializable {

    /** hash for registering changes */
    @Exclude
    @Ignore
    var changeHash: String = ""

    /** local variable for whether this object is playable */
    @Ignore
    var isPlayable: Boolean = false

    override fun toString(): String {
        return "{" +
                "name: $name, " +
                "uid: $uid, " +
                "isPlayable: $isPlayable, " +
                "lastSnapshotHash: $lastSnapshotHash, " +
                "questionModuleUid: $questionModuleUid, " +
                "dateCreated: $dateCreated, " +
                "preferencePack: $preferencePack, " +
                "lastPlayed: $lastPlayed, " +
                "collectionUidList: $collectionUidList, " +
                "questionUidList: $questionUidList, " +
                "changeHash: $changeHash, " +
                "}"
    }
}