package study.me.please.ui.collection.detail

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.CollectionIO
import study.me.please.data.room.CollectionDao
import javax.inject.Inject

/** Proxy for calling network end points */
class CollectionDetailRepository @Inject constructor(
    private val collectionDao: CollectionDao
) {

    /** Returns a collection by its uid - [collectionUid] */
    suspend fun getCollectionByUid(collectionUid: String): CollectionIO? {
        return withContext(Dispatchers.IO) {
            collectionDao.getCollectionByUid(collectionUid)
        }
    }
}