package study.me.please.ui.home

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.session.SessionIO
import study.me.please.data.room.HomeDao
import javax.inject.Inject

/** Proxy for calling network end points */
class HomeRepository @Inject constructor(
    private val homeDao: HomeDao
) {

    /**
     * Retrieve most recently edited collections
     * @param limit how many latest collections we want
     */
    suspend fun getLatestCollections(limit: Int): List<CollectionIO>? {
        return withContext(Dispatchers.IO) {
            homeDao.getLatestCollections(limit)
        }
    }

    /**
     * Retrieve most recently played sessions
     * @param limit how many latest sessions we want
     */
    suspend fun getLatestSessions(limit: Int): List<SessionIO>? {
        return withContext(Dispatchers.IO) {
            homeDao.getLatestSessions(limit)
        }
    }
}