package study.me.please.ui.units.detail

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.subjects.CategoryIO
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.data.room.CategoryDao
import study.me.please.data.room.QuestionDao
import javax.inject.Inject

/** Proxy for calling network end points */
class ParagraphRepository @Inject constructor(
    private val questionDao: QuestionDao,
    private val categoryDao: CategoryDao
) {

    /** Returns a paragraph based on its uid */
    suspend fun getParagraph(uid: String): ParagraphIO? {
        return withContext(Dispatchers.IO) {
            questionDao.getParagraphByUid(uid)
        }
    }

    /** Returns all categories */
    suspend fun getAllCategories(): List<CategoryIO>? {
        return withContext(Dispatchers.IO) {
            categoryDao.getAllCategories()
        }
    }
}