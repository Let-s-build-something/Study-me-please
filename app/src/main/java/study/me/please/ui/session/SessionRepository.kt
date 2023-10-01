package study.me.please.ui.session

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
class SessionRepository @Inject constructor(
    private val sessionDao: SessionDao,
    private val collectionDao: CollectionDao,
    private val questionDao: QuestionDao,
    private val preferencesDao: PreferencesDao
) {

    /** Returns a collection by its uid - [collectionUid] */
    suspend fun getCollectionByUid(collectionUid: String?): CollectionIO? {
        return withContext(Dispatchers.IO) {
            if(collectionUid == null) {
                null
            }else {
                collectionDao.getCollectionByUid(collectionUid)
            }
        }
    }

    /** Returns a list of collections by their uid - [uidList] */
    suspend fun getCollectionsByUidList(uidList: List<String>?): List<CollectionIO>? {
        return withContext(Dispatchers.IO) {
            if(uidList == null) {
                null
            }else {
                collectionDao.getCollectionsByUid(uidList)
            }
        }
    }

    /** Returns a question by its uid - [questionUid] */
    suspend fun getQuestionByUid(questionUid: String?): QuestionIO? {
        return withContext(Dispatchers.IO) {
            if(questionUid == null) {
                null
            }else {
                questionDao.getQuestionByUid(questionUid)
            }
        }
    }

    /** Returns an array of questiong by their uid - [questionUids] */
    suspend fun getQuestionsByUid(questionUids: List<String>): List<QuestionIO>? {
        return withContext(Dispatchers.IO) {
            questionDao.getQuestionsByUid(questionUids)
        }
    }

    /** Returns a question by its uid - [uid] */
    suspend fun getPreferencePackByUid(uid: String?): SessionPreferencePack? {
        return withContext(Dispatchers.IO) {
            if(uid == null) {
                null
            }else {
                preferencesDao.getPreferencePackByUid(uid)
            }
        }
    }

    /** Returns all user preferences */
    suspend fun getAllPreferences(): List<SessionPreferencePack>? {
        return withContext(Dispatchers.IO) {
            preferencesDao.getAllPreferences()
        }
    }

    /** Returns a session by its uid - [sessionUid] */
    suspend fun getSessionByUid(sessionUid: String?): SessionIO? {
        return withContext(Dispatchers.IO) {
            if(sessionUid == null) {
                null
            }else {
                sessionDao.getSessionByUid(sessionUid)
            }
        }
    }

    /** Saves a preference pack */
    suspend fun savePreferencePack(preferencePack: SessionPreferencePack) {
        return withContext(Dispatchers.IO) {
            preferencesDao.insertPreferencePack(preferencePack)
        }
    }

    /** deletes a preference pack */
    suspend fun deletePreferencePack(uid: String) {
        return withContext(Dispatchers.IO) {
            preferencesDao.deletePreferencePack(uid)
        }
    }

    /** Saves a session */
    suspend fun saveSession(session: SessionIO) {
        return withContext(Dispatchers.IO) {
            sessionDao.insertSession(session)
        }
    }
}