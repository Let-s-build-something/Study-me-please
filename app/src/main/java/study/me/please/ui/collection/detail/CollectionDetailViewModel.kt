package study.me.please.ui.collection.detail

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import study.me.please.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class CollectionDetailViewModel @Inject constructor(
    private val repository: CollectionDetailRepository,
    val dataManager: CollectionDetailDataManager
): BaseViewModel() {

    /** Requests for a specific collection by an ID */
    fun requestCollectionByUid(collectionUid: String) {
        viewModelScope.launch {
            repository.getCollectionByUid(collectionUid)?.let { collectionDetail ->
                dataManager.collectionDetail.value = collectionDetail
            }
        }
    }
}