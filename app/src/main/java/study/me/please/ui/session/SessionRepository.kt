package study.me.please.ui.session

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.SessionIO
import study.me.please.data.room.SessionDao
import javax.inject.Inject

/** Proxy for calling network end points */
class SessionRepository @Inject constructor(
    private val sessionDao: SessionDao
) {

    /** Returns a collection by its uid - [collectionUid] */
    suspend fun getCollectionByUid(collectionUid: String): CollectionIO? {
        return withContext(Dispatchers.IO) {
            sessionDao.getCollectionByUid(collectionUid)
        }
    }

    /** Returns a question by its uid - [questionUid] */
    suspend fun getQuestionByUid(questionUid: String): QuestionIO? {
        return withContext(Dispatchers.IO) {
            sessionDao.getQuestionByUid(questionUid)
        }
    }

    /** Returns a session by its uid - [sessionUid] */
    suspend fun getSessionByUid(sessionUid: String): SessionIO? {
        return withContext(Dispatchers.IO) {
            sessionDao.getSessionByUid(sessionUid)
        }
    }
}