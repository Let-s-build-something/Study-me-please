package study.me.please.ui.community.collection

import androidx.lifecycle.viewModelScope
import com.squadris.squadris.compose.base.BaseViewModel
import com.squadris.squadris.utils.RefreshableViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.data.shared.SharedDataManager
import javax.inject.Inject

/** Communication bridge between UI and DB */
@HiltViewModel
class PublicCollectionViewModel @Inject constructor(
    private val repository: PublicCollectionRepository,
    private val sharedDataManager: SharedDataManager
): BaseViewModel(), RefreshableViewModel {

    override val isRefreshing = MutableStateFlow(false)

    override var lastRefreshTimeMillis: Long = 0L

    override suspend fun onDataRequest(isSpecial: Boolean, isPullRefresh: Boolean) {
        requestCollection()
    }

    private val _collection = MutableStateFlow<CollectionIO?>(null)

    /** current collection */
    val collection = _collection.asStateFlow()

    /** identifier of collection that should be requested */
    var collectionUid: String = ""

    /** Makes a request to return subjects */
    private suspend fun requestCollection() {
        repository.getFirebaseCollection(collectionUid).addOnSuccessListener { result ->
            _collection.value = result.toObject(CollectionIO::class.java)
        }
    }

    /** Downloads the collection */
    fun downloadCollection(onSuccess: (uid: String) -> Unit = {}) {
        viewModelScope.launch {
            //TODO move to some shared firebase repository
            //TODO questions are not getting saved to firebase - fix
            collection.value?.newInstance(sharedDataManager.currentUser.value?.uid)?.let { newInstance ->
                repository.insertCollection(newInstance)
                repository.insertQuestions(newInstance.questions)
                repository.insertUnits(
                    newInstance.units.map { it.value }.onEach {
                        repository.insertFacts(it.facts.onEach { fact ->
                            repository.insertFacts(fact.facts)
                        })
                        repository.insertParagraphs(it.paragraphs)
                        iterateFurtherAction(it.paragraphs) { paragraph ->
                            repository.insertParagraphs(paragraph.paragraphs)
                            repository.insertFacts(paragraph.facts.onEach { fact ->
                                repository.insertFacts(fact.facts)
                            })
                        }
                    }
                )
                onSuccess(newInstance.uid)
            }
        }
    }

    /** iterates into all possible depths */
    private suspend fun iterateFurtherAction(
        paragraphs: List<ParagraphIO>,
        action: suspend (ParagraphIO) -> Unit
    ) {
        withContext(Dispatchers.Default) {
            paragraphs.forEach { iterationParagraph ->
                action(iterationParagraph)
                iterateFurtherAction(
                    paragraphs = iterationParagraph.paragraphs,
                    action = action,
                )
            }
        }
    }
}