package study.me.please.ui.collection.detail

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.QuestionIO
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

    /** Returns an array of questiong by their uid - [questionUids] */
    suspend fun getQuestionsByUid(questionUids: List<String>): List<QuestionIO>? {
        return withContext(Dispatchers.IO) {
            collectionDao.getQuestionsByUid(questionUids)
        }
    }

    /** removes all questions with uid from the provided list [uidList] */
    suspend fun deleteQuestions(uidList: List<String>) {
        withContext(Dispatchers.IO) {
            collectionDao.deleteQuestions(uidList)
        }
    }

    /** saves a collection */
    suspend fun saveCollection(collection: CollectionIO) {
        return withContext(Dispatchers.IO) {
            collectionDao.insertCollection(collection)
        }
    }

    /** saves a question */
    suspend fun saveQuestion(question: QuestionIO) {
        return withContext(Dispatchers.IO) {
            collectionDao.insertQuestion(question)
        }
    }
}