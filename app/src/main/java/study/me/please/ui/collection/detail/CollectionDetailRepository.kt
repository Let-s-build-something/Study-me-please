package study.me.please.ui.collection.detail

import android.util.Log
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.CollectionIO
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
        updateMap: Map<String, Any?>
    ) {
        return withContext(Dispatchers.IO) {
            Firebase.firestore
                .collection(FirebaseCollections.COLLECTIONS.name)
                .document(collection.uid)
                .update(updateMap).addOnCompleteListener {
                    Log.d("kostka_test", "(${Firebase.auth.currentUser?.uid}) inserted collection," +
                            " success: ${it.isSuccessful},error: ${it.exception}")
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
}