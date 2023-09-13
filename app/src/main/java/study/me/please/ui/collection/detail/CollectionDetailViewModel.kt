package study.me.please.ui.collection.detail

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.squadris.squadris.utils.DateUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import study.me.please.base.BaseViewModel
import study.me.please.data.io.CollectionIO
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

    /** Requests for a data change */
    fun requestSave(collectionIO: CollectionIO) {
        viewModelScope.launch {
            if(collectionIO.isNotEmpty) {
                Log.d("collection_viewmodel", "saving. Answers: ${collectionIO.questions.map { it.answers.toList() }}")
                repository.saveDetail(collection = collectionIO.apply {
                    dateModified = DateUtils.now.time
                    if(collectionIO.dateCreated == null) dateCreated = DateUtils.now.time
                })
            }
        }
    }

    /** Requests for a removal of questions */
    fun requestQuestionsDeletion(uidList: Set<String>) {
        viewModelScope.launch {
            repository.deleteQuestions(uidList.toList())
        }
    }

    /** Requests for a removal of answers */
    fun requestAnswersDeletion(uidList: Set<String>) {
        viewModelScope.launch {
            repository.deleteAnswers(uidList.toList())
        }
    }
}