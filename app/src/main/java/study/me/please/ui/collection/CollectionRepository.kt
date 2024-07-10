package study.me.please.ui.collection

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.session.SessionIO
import study.me.please.data.room.CollectionDao
import study.me.please.data.room.SessionDao
import study.me.please.data.shared.SharedDataManager
import javax.inject.Inject

/** Proxy for calling network end points */
class CollectionRepository @Inject constructor(
    private val collectionDao: CollectionDao,
    private val sessionDao: SessionDao,
    private val sharedDataManager: SharedDataManager
) {

    /** Get list of all collections */
    suspend fun getCollections(): List<CollectionIO>? {
        return withContext(Dispatchers.IO) {
            collectionDao.getUserCollections(sharedDataManager.currentUser.value?.uid)
        }
    }

    /** Get list of all sessions */
    suspend fun getSessions(): List<SessionIO>? {
        return withContext(Dispatchers.IO) {
            sessionDao.getAllSessions()
        }
    }

    /** removes all collections with uid from the provided list [uidList] */
    suspend fun deleteCollections(uidList: List<String>) {
        withContext(Dispatchers.IO) {
            collectionDao.deleteCollections(uidList)
        }
    }

    /** removes all sessions */
    suspend fun saveSessions(sessions: List<SessionIO>) {
        withContext(Dispatchers.IO) {
            sessionDao.insertSessions(sessions)
        }
    }
}