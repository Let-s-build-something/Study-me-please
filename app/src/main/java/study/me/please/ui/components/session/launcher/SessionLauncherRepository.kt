package study.me.please.ui.components.session.launcher

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.session.SessionIO
import study.me.please.data.room.SessionDao
import javax.inject.Inject

/** Proxy for calling network end points */
class SessionLauncherRepository @Inject constructor(
    private val sessionDao: SessionDao
) {

    /** Get list of all sessions */
    suspend fun getSessions(): List<SessionIO>? {
        return withContext(Dispatchers.IO) {
            sessionDao.getAllSessions()
        }
    }

    /** removes all sessions */
    suspend fun saveSession(session: SessionIO) {
        withContext(Dispatchers.IO) {
            sessionDao.insertSession(session)
        }
    }
}