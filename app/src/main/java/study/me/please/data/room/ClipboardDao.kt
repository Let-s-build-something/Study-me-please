package study.me.please.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import study.me.please.data.io.UnitElement

/** Interface for communication with local Room database */
@Dao
interface ClipboardDao {

    /** returns all unit element paragraphs */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_UNIT_ELEMENT_PARAGRAPH}")
    suspend fun getUnitElementParagraphs(): List<UnitElement.Paragraph>?

    /** returns all unit element facts */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_UNIT_ELEMENT_FACT}")
    suspend fun getUnitElementFacts(): List<UnitElement.Fact>?


    /** Removes all unit element paragraphs */
    @Query("DELETE FROM ${AppRoomDatabase.ROOM_UNIT_ELEMENT_PARAGRAPH}")
    suspend fun clearUnitElementParagraphs()

    /** Removes all unit element facts */
    @Query("DELETE FROM ${AppRoomDatabase.ROOM_UNIT_ELEMENT_FACT}")
    suspend fun clearUnitElementFacts()


    /** Inserts or updates a new unit element paragraph [element] into the database */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUnitElementParagraph(element: UnitElement.Paragraph)

    /** Inserts or updates a new unit element fact [element] into the database */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUnitElementFact(element: UnitElement.Fact)
}