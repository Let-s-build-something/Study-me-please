package study.me.please.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import study.me.please.data.io.FactIO

/** Interface for communication with local Room database */
@Dao
interface FactDao {

    /** Returns a list of facts based on their identification [factUids] */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_FACT_TABLE} WHERE uid in (:factUids) ORDER BY date_created DESC")
    suspend fun getFactsByUid(factUids: List<String>): List<FactIO>?

    /** Removes facts from the database within given list */
    @Query("DELETE FROM ${AppRoomDatabase.ROOM_FACT_TABLE} WHERE uid IN (:uidList)")
    suspend fun deleteFacts(uidList: List<String>)

    /** Inserts or updates a new fact [fact] into the database */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFact(fact: FactIO)

    /** Inserts or updates a new fact [fact] into the database */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFacts(facts: List<FactIO>)
}