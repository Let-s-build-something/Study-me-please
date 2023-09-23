package study.me.please.ui.session.lobby

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.SessionIO
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
                sessions?.map { it.collectionUids }?.flatten()?.let { collectionUids ->
                    withContext(Dispatchers.IO) {
                        val collections = sessionDao.getCollectionsByUid(collectionUids)
                        withContext(Dispatchers.Default) {
                            sessions.forEach { session ->
                                val relatedCollections = collections?.filter { session.collectionUids.contains(it.uid) }.orEmpty()
                                session.allQuestionUids = relatedCollections.flatMap { it.questionUids }.plus(session.questionUids)
                                session.collections = relatedCollections
                            }
                        }
                    }
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
}