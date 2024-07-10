package study.me.please.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.data.io.subjects.UnitIO

/** Interface for communication with local Room database */
@Dao
interface UnitDao {

    /** Returns a list of units based on their collection identification [collectionUid] */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_UNIT_TABLE} WHERE collection_uid == :collectionUid ORDER BY date_created ASC")
    suspend fun getUnitsByCollectionUid(collectionUid: String): List<UnitIO>?

    /** returns all paragraphs */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_PARAGRAPH_TABLE} ORDER BY dateCreated DESC")
    suspend fun getParagraphs(): List<ParagraphIO>?

    /** returns all paragraph that are contained in given list */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_PARAGRAPH_TABLE} WHERE uid IN (:uidList)")
    suspend fun getParagraphsByUidList(uidList: List<String>): List<ParagraphIO>?

    /** Removes units from the database by its identification within [unitUidList] */
    @Query("DELETE FROM ${AppRoomDatabase.ROOM_UNIT_TABLE} WHERE uid IN (:unitUidList)")
    suspend fun deleteUnits(unitUidList: List<String>)

    /** Removes paragraphs from the database by its identification [paragraphUid] */
    @Query("DELETE FROM ${AppRoomDatabase.ROOM_PARAGRAPH_TABLE} WHERE uid == :paragraphUid")
    suspend fun deleteParagraph(paragraphUid: String)

    /** Inserts or updates a new unit [unit] into the database */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUnit(unit: UnitIO)

    /** Inserts or updates a new unit [unit] into the database */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUnits(units: List<UnitIO>)

    /** Inserts or updates a new paragraph [paragraph] into the database */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertParagraph(paragraph: ParagraphIO)

    /** Inserts or updates a new paragraph [paragraph] into the database */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertParagraphs(paragraphs: List<ParagraphIO>)
}