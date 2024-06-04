package study.me.please.ui.units

import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.FactIO
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.data.io.subjects.UnitIO
import study.me.please.data.room.CollectionDao
import study.me.please.data.room.FactDao
import study.me.please.data.room.UnitDao
import javax.inject.Inject

private const val NETWORK_UPDATE_DELAY = 5_000L

/** Proxy for calling network end points */
class UnitsRepository @Inject constructor(
    private val unitDao: UnitDao,
    private val factsDao: FactDao,
    private val collectionDao: CollectionDao
) {

    /** Returns list of units based off of a collection uid [collectionUid] */
    suspend fun getUnitsByCollection(collectionUid: String): List<UnitIO>? {
        return withContext(Dispatchers.IO) {
            unitDao.getUnitsByCollectionUid(collectionUid)
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

    private val cancellableScope = CoroutineScope(Dispatchers.IO)

    /** updates a specific unit within a collection */
    suspend fun updateFirebaseUnit(
        unit: UnitIO,
        collectionUid: String
    ) {
        cancellableScope.coroutineContext.cancelChildren()
        cancellableScope.launch {
            delay(NETWORK_UPDATE_DELAY)
            Firebase.firestore
                .collection(FirebaseCollections.COLLECTIONS.name)
                .document(collectionUid)
                .update("units.${unit.uid}", unit)
        }
    }

    /** updates a specific unit within a collection */
    suspend fun deleteFirebaseUnits(
        unitUidList: List<String>,
        collectionUid: String
    ) {
        val updateMap = mutableMapOf<String, Any>()
        unitUidList.forEach {
            updateMap["units.$it"] = FieldValue.delete()
        }
        withContext(Dispatchers.IO) {
            Firebase.firestore
                .collection(FirebaseCollections.COLLECTIONS.name)
                .document(collectionUid)
                .update(updateMap)
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

    enum class FirebaseCollections {
        COLLECTIONS
    }

    /** Inserts or updates a new collection [collection] into the database */
    suspend fun insertCollection(collection: CollectionIO) {
        return withContext(Dispatchers.IO) {
            Firebase.auth.currentUser?.uid?.let { userUid ->
                Firebase.firestore
                    .collection(FirebaseCollections.COLLECTIONS.name)
                    .document(collection.uid)
                    .set(collection.apply {
                        this.userUid = userUid
                    })
            }

            collectionDao.insertCollection(collection)
        }
    }
}