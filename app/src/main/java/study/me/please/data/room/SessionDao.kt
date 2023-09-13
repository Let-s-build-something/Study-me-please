package study.me.please.data.room

import androidx.room.Dao
import androidx.room.Query
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.SessionIO

/** Interface for communication with local Room database */
@Dao
interface SessionDao {

    /** Returns a single collection based on their identification [collectionUid] */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_COLLECTION_TABLE} WHERE uid == :collectionUid LIMIT 1")
    suspend fun getCollectionByUid(collectionUid: String): CollectionIO?

    /** Returns a single question based on their identification [questionUid] */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_QUESTION_TABLE} WHERE uid == :questionUid LIMIT 1")
    suspend fun getQuestionByUid(questionUid: String): QuestionIO?

    /** Returns a single session based on their identification [sessionUid] */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_SESSION_TABLE} WHERE uid == :sessionUid LIMIT 1")
    suspend fun getSessionByUid(sessionUid: String): SessionIO?
}