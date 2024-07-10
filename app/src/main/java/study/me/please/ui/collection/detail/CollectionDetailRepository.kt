package study.me.please.ui.collection.detail

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.FactIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.firebase.FirebaseCollections
import study.me.please.data.room.CollectionDao
import study.me.please.data.room.FactDao
import study.me.please.data.room.QuestionDao
import javax.inject.Inject

/** Proxy for calling network end points */
class CollectionDetailRepository @Inject constructor(
    private val collectionDao: CollectionDao,
    private val questionDao: QuestionDao,
    private val factDao: FactDao
) {

    /** Returns a collection by its uid - [collectionUid] */
    suspend fun getCollectionByUid(collectionUid: String): CollectionIO? {
        return withContext(Dispatchers.IO) {
            collectionDao.getCollectionByUid(collectionUid)
        }
    }

    /** Returns a list of questions by their identifiers - [questionUidList] */
    suspend fun getQuestionsByUid(questionUidList: List<String>): List<QuestionIO>? {
        return withContext(Dispatchers.IO) {
            questionDao.getQuestionsByUid(questionUidList)
        }
    }

    /** removes all questions with uid from the provided list [uidList] */
    suspend fun deleteQuestions(uidList: List<String>, excludedList: List<String> = emptyList()) {
        withContext(Dispatchers.IO) {
            questionDao.deleteQuestions(uidList, excludedList = excludedList)
        }
    }

    /** saves a collection */
    suspend fun saveCollection(
        collection: CollectionIO,
        userUid: String? = null
    ) {
        return withContext(Dispatchers.IO) {
            userUid?.let { userUid ->
                Firebase.firestore
                    .collection(FirebaseCollections.COLLECTIONS.name)
                    .document(collection.uid)
                    .set(collection.apply {
                        this.authorUid = userUid
                    })
            }

            collectionDao.insertCollection(collection)
        }
    }

    /** saves a question */
    suspend fun saveQuestion(question: QuestionIO) {
        return withContext(Dispatchers.IO) {
            questionDao.insertQuestion(question)
        }
    }

    //========= FACTS ===========

    /** removes all facts with uid from the provided list [uidList] */
    suspend fun deleteFacts(uidList: List<String>) {
        withContext(Dispatchers.IO) {
            factDao.deleteFacts(uidList)
        }
    }

    /** saves a fact */
    suspend fun saveFact(fact: FactIO) {
        return withContext(Dispatchers.IO) {
            factDao.insertFact(fact)
        }
    }
}