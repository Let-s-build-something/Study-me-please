package study.me.please.ui.collection

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.BannersResponse
import study.me.please.data.io.CollectionIO
import study.me.please.data.room.CollectionDao
import javax.inject.Inject

/** Proxy for calling network end points */
class CollectionRepository @Inject constructor(
    private val collectionDao: CollectionDao
) {

    /** Get list of all breeds */
    suspend fun getCollections(): List<CollectionIO>? {
        return withContext(Dispatchers.IO) {
            collectionDao.getAllCollections()
        }
    }

    /** removes all collections with uid from the provided list [uidList] */
    suspend fun deleteCollections(uidList: List<String>) {
        withContext(Dispatchers.IO) {
            collectionDao.deleteCollections(uidList)
        }
    }
}