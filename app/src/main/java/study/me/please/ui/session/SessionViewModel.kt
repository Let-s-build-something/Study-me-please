package study.me.please.ui.session

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import study.me.please.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class SessionViewModel @Inject constructor(
    private val repository: SessionRepository,
    val dataManager: SessionDataManager
): BaseViewModel() {

    /** Requests for a specific collection by an ID */
    fun requestCollectionByUid(collectionUid: String) {
        viewModelScope.launch {
            repository.getCollectionByUid(collectionUid)?.let { collectionDetail ->
                dataManager.collection.value = collectionDetail
            }
        }
    }

    /** Requests for a specific question by an ID */
    fun requestQuestionByUid(questionUid: String) {
        viewModelScope.launch {
            repository.getQuestionByUid(questionUid)?.let { question ->
                dataManager.question.value = question
            }
        }
    }

    /** Requests for a specific session by an ID */
    fun requestSessionByUid(sessionUid: String) {
        viewModelScope.launch {
            repository.getSessionByUid(sessionUid)?.let { session ->
                dataManager.session.value = session
            }
        }
    }
}