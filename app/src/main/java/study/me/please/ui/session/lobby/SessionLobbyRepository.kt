package study.me.please.ui.session.lobby

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.SessionIO
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.data.room.PreferencesDao
import study.me.please.data.room.SessionDao
import javax.inject.Inject

/** Proxy for calling network end points */
class SessionLobbyRepository @Inject constructor(
    private val sessionDao: SessionDao,
    private val preferencesDao: PreferencesDao
) {

    /** returns all sessions and calculates the amount of questions in each */
    suspend fun getAllSessions(): List<SessionIO>? {
        return withContext(Dispatchers.IO) {
            val sessions = sessionDao.getAllSessions()
            withContext(Dispatchers.Default) {
                sessions?.forEach { session ->
                    //TODO
                    /*session.questionCount = session.collectionUidList.sumOf { it.questionUidList.size }
                        .plus(session.questionUidList.size)*/
                }
            }
            sessions
        }
    }

    /** saves a session */
    suspend fun saveSession(session: SessionIO) {
        return withContext(Dispatchers.IO) {
            sessionDao.insertSession(session)
        }
    }

    /** Saves a preference pack */
    suspend fun savePreferencePack(preferencePack: SessionPreferencePack) {
        return withContext(Dispatchers.IO) {
            preferencesDao.insertPreferencePack(preferencePack)
        }
    }

    /** Returns all user preferences */
    suspend fun getAllPreferences(): List<SessionPreferencePack>? {
        return withContext(Dispatchers.IO) {
            preferencesDao.getAllPreferences()
        }
    }

    /** deletes a preference pack */
    suspend fun deletePreferencePack(uid: String) {
        return withContext(Dispatchers.IO) {
            preferencesDao.deletePreferencePack(uid)
        }
    }

    /** deletes sessions based on their uid [uids] */
    suspend fun deleteSessions(uids: Set<String>) {
        return withContext(Dispatchers.IO) {
            preferencesDao.deleteSessions(uids)
        }
    }
}