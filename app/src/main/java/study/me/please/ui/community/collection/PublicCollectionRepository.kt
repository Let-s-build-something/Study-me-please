package study.me.please.ui.community.collection

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.FactIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.firebase.FirebaseCollections
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.data.io.subjects.UnitIO
import study.me.please.data.room.CollectionDao
import study.me.please.data.room.FactDao
import study.me.please.data.room.QuestionDao
import study.me.please.data.room.UnitDao
import javax.inject.Inject

/** Proxy for calling network end points */
class PublicCollectionRepository @Inject constructor(
    private val unitDao: UnitDao,
    private val collectionDao: CollectionDao,
    private val factsDao: FactDao,
    private val questionDao: QuestionDao
) {

    /** Returns collection by its uid */
    suspend fun getFirebaseCollection(collectionUid: String): Task<DocumentSnapshot> {
        return withContext(Dispatchers.IO) {
            Firebase.firestore
                .collection(FirebaseCollections.COLLECTIONS.name)
                .document(collectionUid)
                .get()
        }
    }

    /** saves questions to local DB */
    suspend fun insertQuestions(questions: List<QuestionIO>) {
        return withContext(Dispatchers.IO) {
            questionDao.insertQuestions(questions)
        }
    }

    /** Creates new records of units or replaces them if it already exists */
    suspend fun insertUnits(units: List<UnitIO>) {
        return withContext(Dispatchers.IO) {
            unitDao.insertUnits(units)
        }
    }

    /** updates facts */
    suspend fun insertFacts(facts: List<FactIO>) {
        return withContext(Dispatchers.IO) {
            factsDao.insertFacts(facts)
        }
    }

    /** Creates paragraphs */
    suspend fun insertParagraphs(paragraphs: List<ParagraphIO>) {
        return withContext(Dispatchers.IO) {
            unitDao.insertParagraphs(paragraphs)
        }
    }

    /** Inserts or updates a new collection [collection] into the database */
    suspend fun insertCollection(collection: CollectionIO) {
        return withContext(Dispatchers.IO) {
            Firebase.auth.currentUser?.uid?.let { userUid ->
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
}