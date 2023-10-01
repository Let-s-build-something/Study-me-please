package study.me.please.ui.session.detail

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.SessionIO
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.data.room.CollectionDao
import study.me.please.data.room.PreferencesDao
import study.me.please.data.room.QuestionDao
import study.me.please.data.room.SessionDao
import javax.inject.Inject

/** Proxy for calling network end points */
class SessionDetailRepository @Inject constructor(
    private val sessionDao: SessionDao,
    private val collectionDao: CollectionDao,
    private val preferencesDao: PreferencesDao,
    private val questionDao: QuestionDao
) {

    /** saves a session */
    suspend fun saveSession(session: SessionIO) {
        return withContext(Dispatchers.IO) {
            sessionDao.insertSession(session)
        }
    }

    /** Returns collections by their uids - [collectionUids] */
    suspend fun getCollectionsByUids(collectionUids: List<String>): List<CollectionIO>? {
        return withContext(Dispatchers.IO) {
            if(collectionUids.isEmpty()) {
                listOf()
            }else {
                collectionDao.getCollectionsByUid(collectionUids)
            }
        }
    }

    /** Returns an array of questiong by their uid - [questionUids] */
    suspend fun getQuestionsByUid(questionUids: List<String>): List<QuestionIO>? {
        return withContext(Dispatchers.IO) {
            if(questionUids.isEmpty()) {
                listOf()
            }else {
                questionDao.getQuestionsByUid(questionUids)
            }
        }
    }

    /** Returns a session object based on its identifier [sessionUid] */
    suspend fun getSessionDetail(sessionUid: String): SessionIO? {
        return withContext(Dispatchers.IO) {
            sessionDao.getSessionByUid(sessionUid)
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
}