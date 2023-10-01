package study.me.please.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import study.me.please.data.io.preferences.SessionPreferencePack

/** Interface for communication with local Room database */
@Dao
interface PreferencesDao {

    /** Returns all user preferences */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_SESSION_PREFERENCE_PACK_TABLE} ORDER BY date_modified DESC")
    suspend fun getAllPreferences(): List<SessionPreferencePack>?

    /** Returns a single session based on their identification [uid] */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_SESSION_PREFERENCE_PACK_TABLE} WHERE uid == :uid LIMIT 1")
    suspend fun getPreferencePackByUid(uid: String): SessionPreferencePack?

    /** Inserts or updates a new preference pack [SessionPreferencePack] into the database */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPreferencePack(preferencePack: SessionPreferencePack)

    /** Removes preference pack from the database based on its primary key [uid] */
    @Query("DELETE FROM ${AppRoomDatabase.ROOM_SESSION_PREFERENCE_PACK_TABLE} WHERE uid == :uid")
    suspend fun deletePreferencePack(uid: String)

    /** Removes sessions from the database based on their primary key [uids] */
    @Query("DELETE FROM ${AppRoomDatabase.ROOM_SESSION_TABLE} WHERE uid in (:uids)")
    suspend fun deleteSessions(uids: Set<String>)
}