package study.me.please.ui.collection.detail.subjects

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.BaseResponse
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.subjects.CategoryIO
import study.me.please.data.io.subjects.SubjectIO
import study.me.please.data.room.CategoryDao
import study.me.please.data.room.CollectionDao
import study.me.please.data.room.QuestionDao
import study.me.please.data.room.SubjectDao
import javax.inject.Inject

/** Proxy for calling network end points */
class SubjectsRepository @Inject constructor(
    private val subjectsDao: SubjectDao,
    private val categoryDao: CategoryDao,
    private val collectionDao: CollectionDao,
    private val questionDao: QuestionDao
) {

    /** Returns list of subjects based off of a collection uid [collectionUid] */
    suspend fun getSubjectsByCollection(collectionUid: String): List<SubjectIO>? {
        return withContext(Dispatchers.IO) {
            subjectsDao.getSubjectsByCollectionUid(collectionUid)
        }
    }

    /** Creates a new record of subject or replaces it if it already exists */
    suspend fun updateSubject(subject: SubjectIO) {
        return withContext(Dispatchers.IO) {
            subjectsDao.insertSubject(subject)
        }
    }

    /** Deletes subject from the DB */
    suspend fun deleteSubject(subjectUid: String) {
        return withContext(Dispatchers.IO) {
            subjectsDao.deleteSubject(subjectUid)
        }
    }

    /** Returns all categories similiar to the given [query] */
    suspend fun getCategoriesBy(query: String): List<CategoryIO>? {
        return withContext(Dispatchers.IO) {
            categoryDao.getCategoriesByNameLike(query)
        }
    }

    /** Returns all categories */
    suspend fun getAllCategories(): List<CategoryIO>? {
        return withContext(Dispatchers.IO) {
            categoryDao.getAllCategories()
        }
    }

    /** Returns collection by its uid */
    suspend fun getCollection(collectionUid: String): CollectionIO? {
        return withContext(Dispatchers.IO) {
            collectionDao.getCollectionByUid(collectionUid)
        }
    }

    /** Updates a collection with new data */
    suspend fun updateCollection(collection: CollectionIO) {
        return withContext(Dispatchers.IO) {
            collectionDao.insertCollection(collection)
        }
    }

    /** Returns all questions within this collection */
    suspend fun getAllQuestions(collectionUid: String): List<QuestionIO>? {
        return withContext(Dispatchers.IO) {
            questionDao.getQuestionsByUid(
                collectionDao.getCollectionByUid(collectionUid)?.questionUidList?.toList().orEmpty()
            )
        }
    }

    /** Updates an existing record of category */
    suspend fun updateCategory(category: CategoryIO) {
        return withContext(Dispatchers.IO) {
            categoryDao.updateCategory(category)
        }
    }

    /** Creates a new record of category or replaces existing */
    suspend fun insertCategory(category: CategoryIO): Boolean {
        return withContext(Dispatchers.IO) {
            val exists = categoryDao.getCategoriesByNameExact(category.name) != null
            // we create a new record if it doesn't exist yet
            if(exists.not()) categoryDao.insertCategory(category)
            exists
        }
    }

    /** Creates new records of questions */
    suspend fun insertQuestions(questions: List<QuestionIO>) {
        return withContext(Dispatchers.IO) {
            questionDao.insertQuestions(questions)
        }
    }
}