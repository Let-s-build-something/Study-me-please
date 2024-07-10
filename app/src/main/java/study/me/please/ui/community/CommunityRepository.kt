package study.me.please.ui.community

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.firebase.FirebaseCollections
import study.me.please.data.io.firebase.FirebaseDocuments
import study.me.please.data.room.HomeDao
import javax.inject.Inject

/** Proxy for calling network end points */
class CommunityRepository @Inject constructor(
    private val homeDao: HomeDao
) {

    /** returns full list of categories for collections */
    suspend fun getCategories(): Task<DocumentSnapshot> {
        return withContext(Dispatchers.IO) {
            Firebase.firestore
                .collection(FirebaseCollections.GENERAL.name)
                .document(FirebaseDocuments.COMMUNITY_CATEGORIES.path)
                .get()
        }
    }

    /** Returns all collections based on a filter */
    suspend fun getCollections(filter: CommunityDashboardFilter): Task<QuerySnapshot> {
        return withContext(Dispatchers.IO) {
            when {
                filter.categoryUid.isNullOrBlank().not() -> {
                    Firebase.firestore
                        .collection(FirebaseCollections.COLLECTIONS.name)
                        .whereArrayContains("categoryUidList", filter.categoryUid ?: "")
                        .get()
                }
                else -> Firebase.firestore
                    .collection(FirebaseCollections.COLLECTIONS.name)
                    .get()
            }
        }
    }
}