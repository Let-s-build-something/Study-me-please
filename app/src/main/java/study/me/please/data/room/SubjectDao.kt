package study.me.please.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.data.io.subjects.UnitIO

/** Interface for communication with local Room database */
@Dao
interface SubjectDao {

    /** Returns a list of subjects based on their collection identification [collectionUid] */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_UNIT_TABLE} WHERE collection_uid == :collectionUid ORDER BY date_created ASC")
    suspend fun getSubjectsByCollectionUid(collectionUid: String): List<UnitIO>?

    /** Removes subjects from the database by its identification [subjectUid] */
    @Query("DELETE FROM ${AppRoomDatabase.ROOM_UNIT_TABLE} WHERE uid == :subjectUid")
    suspend fun deleteSubject(subjectUid: String)

    /** Inserts or updates a new subject [subject] into the database */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: UnitIO)

    /** Inserts or updates a new paragraph [paragraph] into the database */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertParagraph(paragraph: ParagraphIO)
}