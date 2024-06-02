package study.me.please.ui.session.detail

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.session.SessionIO
import study.me.please.data.room.CollectionDao
import study.me.please.data.room.PreferencesDao
import study.me.please.data.room.QuestionDao
import study.me.please.data.room.QuestionModuleDao
import study.me.please.data.room.SessionDao
import study.me.please.data.state.session.QuestionModule
import study.me.please.ui.components.preference_chooser.PreferencePackRepository
import javax.inject.Inject

/** Proxy for calling network end points */
class SessionDetailRepository @Inject constructor(
    private val sessionDao: SessionDao,
    private val collectionDao: CollectionDao,
    private val questionModuleDao: QuestionModuleDao,
    private val questionDao: QuestionDao,
    override val preferencesDao: PreferencesDao
): PreferencePackRepository {

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

    /** return a question module based on its unique identifier */
    suspend fun getQuestionModuleByUid(uid: String?): QuestionModule? {
        return withContext(Dispatchers.IO) {
            if(uid == null) null else questionModuleDao.getQuestionModuleByUid(uid)
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
}