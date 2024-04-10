package study.me.please.ui.units

import com.squadris.squadris.utils.DateUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.FactIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.subjects.CategoryIO
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.data.io.subjects.UnitIO
import study.me.please.data.room.CategoryDao
import study.me.please.data.room.CollectionDao
import study.me.please.data.room.FactDao
import study.me.please.data.room.QuestionDao
import study.me.please.data.room.SubjectDao
import javax.inject.Inject

/** Proxy for calling network end points */
class UnitsRepository @Inject constructor(
    private val subjectsDao: SubjectDao,
    private val categoryDao: CategoryDao,
    private val factsDao: FactDao,
    private val collectionDao: CollectionDao,
    private val questionDao: QuestionDao
) {

    /** Returns list of subjects based off of a collection uid [collectionUid] */
    suspend fun getSubjectsByCollection(collectionUid: String): List<UnitIO>? {
        return withContext(Dispatchers.IO) {
            subjectsDao.getSubjectsByCollectionUid(collectionUid)
        }
    }

    /** Creates a new record of a subject or replaces it if it already exists */
    suspend fun updateUnit(subject: UnitIO) {
        return withContext(Dispatchers.IO) {
            subjectsDao.insertUnit(subject)
        }
    }

    /** Creates a new record of a paragraph or replaces it if it already exists */
    suspend fun updateParagraph(paragraph: ParagraphIO) {
        return withContext(Dispatchers.IO) {
            subjectsDao.insertParagraph(paragraph)
        }
    }

    /** Removes a paragraph from the DB */
    suspend fun deleteParagraph(paragraphUid: String) {
        return withContext(Dispatchers.IO) {
            subjectsDao.deleteParagraph(paragraphUid)
        }
    }

    /** Removes a subject from the DB */
    suspend fun deleteFact(factUid: String) {
        return withContext(Dispatchers.IO) {
            factsDao.deleteFacts(listOf(factUid))
        }
    }

    /** Deletes units from the DB */
    suspend fun deleteUnits(unitUidList: List<String>) {
        return withContext(Dispatchers.IO) {
            subjectsDao.deleteUnits(unitUidList = unitUidList)
        }
    }

    /** Returns all categories similiar to the given [query] */
    suspend fun getCategoriesBy(query: String): List<CategoryIO>? {
        return withContext(Dispatchers.IO) {
            categoryDao.getCategoriesByNameLike(query)
        }
    }

    /** Returns all categories similiar to the given [query] */
    suspend fun getParagraphsBy(uidList: List<String>): List<ParagraphIO>? {
        return withContext(Dispatchers.IO) {
            subjectsDao.getParagraphsByUidList(uidList)
        }
    }

    /** Returns all facts similar to the given list of uids */
    suspend fun getFactsBy(uidList: List<String>): List<FactIO>? {
        return withContext(Dispatchers.IO) {
            factsDao.getFactsByUid(uidList)
        }
    }

    /** updates a specific fact */
    suspend fun updateFact(fact: FactIO) {
        return withContext(Dispatchers.IO) {
            factsDao.insertFact(fact)
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

    /** Inserts or updates a new collection [collection] into the database */
    suspend fun insertCollection(collection: CollectionIO) {
        return withContext(Dispatchers.IO) {
            collectionDao.insertCollection(collection)
        }
    }

    /** Updates a collection with new data */
    suspend fun updateCollectionDateModified(collectionUid: String) {
        return withContext(Dispatchers.IO) {
            collectionDao.updateCollectionDateModified(
                collectionUid = collectionUid,
                dateModified = DateUtils.now.time
            )
        }
    }

    /** Updates a collection with new questions */
    suspend fun updateCollectionQuestions(uidList: Set<String>, collectionUid: String) {
        return withContext(Dispatchers.IO) {
            collectionDao.updateCollectionQuestions(
                collectionUid = collectionUid,
                questionUidList = uidList
            )
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