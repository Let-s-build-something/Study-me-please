package study.me.please.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.SessionIO
import study.me.please.data.io.preferences.SessionPreferencePack

/** Interface for communication with local Room database */
@Dao
interface SessionDao {

    /** Returns a single collection based on their identification [collectionUid] */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_COLLECTION_TABLE} WHERE uid == :collectionUid LIMIT 1")
    suspend fun getCollectionByUid(collectionUid: String): CollectionIO?

    /** Returns a single collection based on their identification [collectionUid] */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_COLLECTION_TABLE} WHERE uid in (:collectionUids)")
    suspend fun getCollectionsByUid(collectionUids: List<String>): List<CollectionIO>?

    /** Returns a single question based on their identification [questionUid] */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_QUESTION_TABLE} WHERE uid == :questionUid LIMIT 1")
    suspend fun getQuestionByUid(questionUid: String): QuestionIO?

    /** Returns a single session based on their identification [sessionUid] */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_SESSION_TABLE} WHERE uid == :sessionUid LIMIT 1")
    suspend fun getSessionByUid(sessionUid: String): SessionIO?

    /** Returns all sessions */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_SESSION_TABLE} ORDER BY last_played DESC")
    suspend fun getAllSessions(): List<SessionIO>?

    /** Returns a single session based on their identification [uid] */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_SESSION_PREFERENCE_PACK_TABLE} WHERE uid == :uid LIMIT 1")
    suspend fun getPreferencePackByUid(uid: String): SessionPreferencePack?

    /** Returns a single collection based on their identification [questionUids] */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_QUESTION_TABLE} WHERE uid in (:questionUids) ORDER BY date_created DESC")
    suspend fun getQuestionsByUid(questionUids: List<String>): List<QuestionIO>?

    /** Inserts or updates a session [SessionIO] into the database */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSession(session: SessionIO)
}