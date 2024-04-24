package study.me.please.ui.units

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.FactIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.data.io.subjects.UnitIO
import study.me.please.data.room.CategoryDao
import study.me.please.data.room.CollectionDao
import study.me.please.data.room.FactDao
import study.me.please.data.room.QuestionDao
import study.me.please.data.room.UnitDao
import javax.inject.Inject

/** Proxy for calling network end points */
class UnitsRepository @Inject constructor(
    private val unitDao: UnitDao,
    private val categoryDao: CategoryDao,
    private val factsDao: FactDao,
    private val collectionDao: CollectionDao,
    private val questionDao: QuestionDao
) {

    /** Returns list of units based off of a collection uid [collectionUid] */
    suspend fun getUnitsByCollection(collectionUid: String): List<UnitIO>? {
        return withContext(Dispatchers.IO) {
            unitDao.getSubjectsByCollectionUid(collectionUid)
        }
    }

    /** Creates a new record of a unit or replaces it if it already exists */
    suspend fun updateUnit(unit: UnitIO) {
        return withContext(Dispatchers.IO) {
            unitDao.insertUnit(unit)
        }
    }

    /** Creates a new record of a paragraph or replaces it if it already exists */
    suspend fun updateParagraph(paragraph: ParagraphIO) {
        return withContext(Dispatchers.IO) {
            unitDao.insertParagraph(paragraph)
        }
    }

    /** Removes a paragraph from the DB */
    suspend fun deleteParagraph(paragraphUid: String) {
        return withContext(Dispatchers.IO) {
            unitDao.deleteParagraph(paragraphUid)
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
            unitDao.deleteUnits(unitUidList = unitUidList)
        }
    }

    /** Returns all categories similiar to the given [uidList] */
    suspend fun getParagraphsBy(uidList: List<String>): List<ParagraphIO>? {
        return withContext(Dispatchers.IO) {
            unitDao.getParagraphsByUidList(uidList)
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

    /** Returns all paragraphs */
    suspend fun getAllParagraphs(): List<ParagraphIO>? {
        return withContext(Dispatchers.IO) {
            unitDao.getParagraphs()
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

    /** Creates new records of questions */
    suspend fun insertQuestions(questions: List<QuestionIO>) {
        return withContext(Dispatchers.IO) {
            questionDao.insertQuestions(questions)
        }
    }
}