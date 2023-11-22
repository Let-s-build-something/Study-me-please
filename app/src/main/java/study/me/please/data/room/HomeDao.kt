package study.me.please.data.room

import androidx.room.Dao
import androidx.room.Query
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.session.SessionIO

/** Interface for communication with local Room database */
@Dao
interface HomeDao {

    /** Returns collections based on [limit] count */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_COLLECTION_TABLE} ORDER BY date_modified DESC LIMIT :limit")
    suspend fun getLatestCollections(limit: Int): List<CollectionIO>?

    /** Returns sessions based on [limit] count */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_SESSION_TABLE} ORDER BY last_played DESC LIMIT :limit")
    suspend fun getLatestSessions(limit: Int): List<SessionIO>?
}