package study.me.please.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import study.me.please.data.io.SessionIO

/** Interface for communication with local Room database */
@Dao
interface SessionDao {

    /** Returns a single session based on their identification [sessionUid] */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_SESSION_TABLE} WHERE uid == :sessionUid LIMIT 1")
    suspend fun getSessionByUid(sessionUid: String): SessionIO?

    /** Returns all sessions */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_SESSION_TABLE} ORDER BY last_played DESC")
    suspend fun getAllSessions(): List<SessionIO>?

    /** Inserts or updates a session [session] into the database */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSession(session: SessionIO)

    /** Inserts or updates sessions [sessions] into the database */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSessions(sessions: List<SessionIO>)
}