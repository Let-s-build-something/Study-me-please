package study.me.please.ui.session

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.SessionIO
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.data.room.PreferencesDao
import study.me.please.data.room.SessionDao
import javax.inject.Inject

/** Proxy for calling network end points */
class SessionRepository @Inject constructor(
    private val sessionDao: SessionDao,
    private val preferencesDao: PreferencesDao
) {

    /** Returns a collection by its uid - [collectionUid] */
    suspend fun getCollectionByUid(collectionUid: String?): CollectionIO? {
        return withContext(Dispatchers.IO) {
            if(collectionUid == null) {
                null
            }else {
                sessionDao.getCollectionByUid(collectionUid)
            }
        }
    }

    /** Returns collections by their uids - [collectionUids] */
    suspend fun getCollectionsByUids(collectionUids: List<String>): List<CollectionIO>? {
        return withContext(Dispatchers.IO) {
            if(collectionUids.isEmpty()) {
                listOf()
            }else {
                sessionDao.getCollectionsByUid(collectionUids)
            }
        }
    }

    /** Returns a question by its uid - [questionUid] */
    suspend fun getQuestionByUid(questionUid: String?): QuestionIO? {
        return withContext(Dispatchers.IO) {
            if(questionUid == null) {
                null
            }else {
                sessionDao.getQuestionByUid(questionUid)
            }
        }
    }

    /** Returns an array of questiong by their uid - [questionUids] */
    suspend fun getQuestionsByUid(questionUids: List<String>): List<QuestionIO>? {
        return withContext(Dispatchers.IO) {
            sessionDao.getQuestionsByUid(questionUids)
        }
    }

    /** Returns a question by its uid - [uid] */
    suspend fun getPreferencePackByUid(uid: String?): SessionPreferencePack? {
        return withContext(Dispatchers.IO) {
            if(uid == null) {
                null
            }else {
                sessionDao.getPreferencePackByUid(uid)
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

    /** Saves a session */
    suspend fun saveSession(session: SessionIO) {
        return withContext(Dispatchers.IO) {
            sessionDao.insertSession(session)
        }
    }

    /** deletes a preference pack */
    suspend fun deletePreferencePack(uid: String) {
        return withContext(Dispatchers.IO) {
            preferencesDao.deletePreferencePack(uid)
            getAllPreferences()
        }
    }
}