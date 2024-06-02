package study.me.please.data.io.session

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.squadris.squadris.utils.DateUtils
import study.me.please.data.io.QuestionMode
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

    /** preference specific to this session */
    var preferencePackUid: String = "",

    /** last value of estimated value from Preferencepack */
    var estimatedMode: QuestionMode? = null,

    /** saved question module for control and history of questioning */
    var questionModuleUid: String? = null,

    /**
     * hash of the last snapshot of objects selected
     * selection information is saved in the preferencePack ([preferencePackUid])
     */
    var lastSnapshotHash: String? = null,

    /** What was the last time this session was played */
    @SerializedName("last_played")
    @ColumnInfo(name = "last_played")
    val lastPlayed: Long = DateUtils.now.timeInMillis,

    /** all current collections in this session */
    val collectionUidList: MutableSet<String> = mutableSetOf(),

    /** all current questions in this session */
    val questionUidList: MutableSet<String> = mutableSetOf(),

    /** number of questions in this session */
    var questionCount: Int = 0
): Serializable {

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
                "preferencePackUid: $preferencePackUid, " +
                "estimatedMode: $estimatedMode, " +
                "lastPlayed: $lastPlayed, " +
                "collectionUidList: $collectionUidList, " +
                "questionUidList: $questionUidList, " +
                "questionCount: $questionCount, " +
                "}"
    }
}