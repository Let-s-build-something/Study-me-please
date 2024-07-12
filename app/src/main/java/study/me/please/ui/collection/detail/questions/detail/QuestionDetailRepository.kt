package study.me.please.ui.collection.detail.questions.detail

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.firebase.FirebaseCollections
import study.me.please.data.room.QuestionDao
import study.me.please.ui.units.NETWORK_UPDATE_DELAY
import javax.inject.Inject

/** Proxy for calling network end points */
class QuestionDetailRepository @Inject constructor(
    private val questionDao: QuestionDao
) {

    /** Returns a question by its identifier - [questionUid] */
    suspend fun getQuestionByUid(questionUid: String): QuestionIO? {
        return withContext(Dispatchers.IO) {
            questionDao.getQuestionByUid(questionUid)
        }
    }

    /** saves a question */
    suspend fun saveQuestion(question: QuestionIO) {
        return withContext(Dispatchers.IO) {
            questionDao.insertQuestion(question)
        }
    }

    private val cancellableScope = CoroutineScope(Dispatchers.IO)

    /** updates a specific unit within a collection */
    suspend fun updateFirebaseQuestion(
        collectionUid: String?,
        question: QuestionIO
    ) {
        if(collectionUid == null) return

        cancellableScope.coroutineContext.cancelChildren()
        cancellableScope.launch {
            delay(NETWORK_UPDATE_DELAY)
            Firebase.firestore
                .collection(FirebaseCollections.COLLECTIONS.name)
                .document(collectionUid)
                .update("questions.${question.uid}", question)
        }
    }
}