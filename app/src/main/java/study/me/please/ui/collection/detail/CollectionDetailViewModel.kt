package study.me.please.ui.collection.detail

import androidx.lifecycle.viewModelScope
import com.squadris.squadris.utils.DateUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import study.me.please.base.BaseViewModel
import study.me.please.base.GeneralClipBoard
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.SessionIO
import javax.inject.Inject

@HiltViewModel
class CollectionDetailViewModel @Inject constructor(
    private val repository: CollectionDetailRepository,
    val dataManager: CollectionDetailDataManager,
    val clipBoard: GeneralClipBoard
): BaseViewModel() {

    /** Requests for a specific collection by an ID */
    fun requestCollectionByUid(collectionUid: String) {
        viewModelScope.launch {
            repository.getCollectionByUid(collectionUid)?.let { collectionDetail ->
                dataManager.collectionDetail.value = collectionDetail.apply {
                    questions = repository.getQuestionsByUid(this.questionUidList.toList()).orEmpty()
                }
            }
        }
    }

    /** Requests for a collection data save */
    fun requestCollectionSave(collectionIO: CollectionIO) {
        viewModelScope.launch(Dispatchers.Default) {
            if(collectionIO.isNotEmpty) {
                repository.saveCollection(collection = collectionIO.apply {
                    dateModified = DateUtils.now.time
                    if(collectionIO.dateCreated == null) dateCreated = DateUtils.now.time
                })
            }
        }
    }

    /** Requests for a question data save */
    fun requestQuestionSave(question: QuestionIO) {
        viewModelScope.launch(Dispatchers.Default) {
            repository.saveQuestion(question)
        }
    }

    /** Requests for a removal of questions */
    fun requestQuestionsDeletion(uidList: Set<String>) {
        viewModelScope.launch {
            repository.deleteQuestions(uidList.toList())
        }
    }

    /** Requests for a removal of answers */
    fun requestAnswersDeletion(
        uidList: Set<String>,
        question: QuestionIO
    ) {
        viewModelScope.launch {
            repository.saveQuestion(
                question.apply {
                    answers.removeAll {
                        uidList.contains(it.uid)
                    }
                }
            )
        }
    }

    /** Requests all collections */
    fun requestSessions() {
        viewModelScope.launch {
            repository.getSessions()?.let { sessions ->
                dataManager.sessions.value = sessions
            }
        }
    }

    /** Requests a save for sessions */
    fun requestSessionsSave(sessions: List<SessionIO>) {
        viewModelScope.launch {
            repository.saveSessions(sessions)
        }
    }
}