package study.me.please.ui.session.detail

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import study.me.please.base.BaseViewModel
import study.me.please.data.io.SessionIO
import study.me.please.data.io.preferences.SessionPreferencePack
import javax.inject.Inject

@HiltViewModel
class SessionDetailViewModel @Inject constructor(
    private val repository: SessionDetailRepository,
    val dataManager: SessionDetailDataManager
): BaseViewModel() {

    init {
        requestAllPreferences()
    }

    /** Makes a request for a session detail */
    fun requestSessionDetail(
        sessionUid: String?,
        collectionUidList: List<String>,
        questionUidList: List<String>
    ) {
        viewModelScope.launch {
            if(sessionUid.isNullOrEmpty()) {
                val questions = repository.getQuestionsByUid(questionUidList).orEmpty()
                val collections = repository.getCollectionsByUids(questionUidList).orEmpty()
                dataManager.session.value = SessionIO(
                    collectionUidList = collectionUidList.toMutableSet(),
                    questionUidList = questionUidList.toMutableSet()
                ).apply {
                    this.collections = collections
                    this.questions = questions
                }
            }else {
                repository.getSessionDetail(sessionUid)?.let { session ->
                    repository.getCollectionsByUids(session.collectionUidList.toList())?.let { collections ->
                        dataManager.session.value = session.apply {
                            this.collections = collections
                        }
                    }
                }
            }
            withContext(Dispatchers.Default) {
                dataManager.session.value?.run {
                    val newQuestionCount = this.questions.size.plus(collections.sumOf { it.questionUidList.size })
                    if(dataManager.session.value?.questionCount != newQuestionCount) {
                        dataManager.session.value?.questionCount = newQuestionCount
                        repository.saveSession(this)
                    }
                }
            }
        }
    }

    /** Makes a request for a session save */
    fun saveSessionDetail() {
        viewModelScope.launch {
            dataManager.session.value?.let { session ->
                repository.saveSession(session)
            }
        }
    }

    /** requests for all preferences */
    private fun requestAllPreferences() {
        viewModelScope.launch {
            repository.getAllPreferences()?.let { preferencePacks ->
                dataManager.preferencePacks.value = preferencePacks.toMutableList()
            }
        }
    }

    /** requests a save of preference pack */
    fun requestPreferencePackSave(preferencePack: SessionPreferencePack?) {
        if(preferencePack == null) return
        viewModelScope.launch {
            repository.savePreferencePack(preferencePack)
        }
    }

    /** requests a save of preference pack */
    fun requestPreferencePackDelete(uid: String?) {
        if(uid == null) return
        viewModelScope.launch {
            repository.deletePreferencePack(uid)
        }
    }
}