package study.me.please.ui.collection.detail.questions.detail

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.QuestionIO
import study.me.please.data.room.QuestionDao
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
}