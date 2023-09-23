package study.me.please.data.io

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.squadris.squadris.utils.DateUtils
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.data.room.AppRoomDatabase
import study.me.please.ui.session.QuestionModule
import java.io.Serializable
import java.util.Date
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

    /** preferences specific to this session */
    var preferences: SessionPreferencePack = SessionPreferencePack(),

    /** saved question module for control and history of questioning */
    @SerializedName("question_module")
    var questionModule: QuestionModule? = null,

    /** What was the last time this session was played */
    @SerializedName("last_played")
    @ColumnInfo(name = "last_played")
    val lastPlayed: Date = DateUtils.now.time,

    /** identifiers of collections in this session */
    val collectionUids: MutableList<String> = mutableListOf(),

    /** identifiers of questions in this session */
    val questionUids: MutableList<String> = mutableListOf()
): Serializable {

    /** all current questions in this session */
    @Ignore
    var allQuestionUids: List<String> = listOf()

    /** all current collections in this session */
    @Ignore
    var collections: List<CollectionIO> = listOf()
}