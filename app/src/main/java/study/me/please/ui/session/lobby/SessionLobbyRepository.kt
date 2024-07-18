package study.me.please.ui.session.lobby

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.session.SessionIO
import study.me.please.data.room.SessionDao
import javax.inject.Inject

/** Proxy for calling network end points */
class SessionLobbyRepository @Inject constructor(
    private val sessionDao: SessionDao
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

    /** deletes sessions based on their uid [uids] */
    suspend fun deleteSessions(uids: Set<String>) {
        return withContext(Dispatchers.IO) {
            sessionDao.deleteSessions(uids)
        }
    }
}