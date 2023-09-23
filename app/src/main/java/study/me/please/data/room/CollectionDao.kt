package study.me.please.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.SessionIO

/** Interface for communication with local Room database */
@Dao
interface CollectionDao {

    //TODO custom order from user
    /** Returns all collections */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_COLLECTION_TABLE} ORDER BY date_modified DESC")
    suspend fun getAllCollections(): List<CollectionIO>?

    /** Returns a single collection based on their identification [collectionUid] */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_COLLECTION_TABLE} WHERE uid == :collectionUid LIMIT 1")
    suspend fun getCollectionByUid(collectionUid: String): CollectionIO?

    /** Returns a single collection based on their identification [questionUids] */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_QUESTION_TABLE} WHERE uid in (:questionUids) ORDER BY date_created DESC")
    suspend fun getQuestionsByUid(questionUids: List<String>): List<QuestionIO>?

    /** Inserts or updates a new collection [collection] into the database */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCollection(collection: CollectionIO)

    /** Inserts or updates a new question [question] into the database */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(question: QuestionIO)

    /** Removes collections from the database within given list */
    @Query("DELETE FROM ${AppRoomDatabase.ROOM_COLLECTION_TABLE} WHERE uid IN (:uidList)")
    suspend fun deleteCollections(uidList: List<String>)

    /** Removes questions from the database within given list */
    @Query("DELETE FROM ${AppRoomDatabase.ROOM_QUESTION_TABLE} WHERE uid IN (:uidList)")
    suspend fun deleteQuestions(uidList: List<String>)
}