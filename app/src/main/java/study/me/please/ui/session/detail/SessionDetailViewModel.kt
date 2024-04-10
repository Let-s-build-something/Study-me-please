package study.me.please.ui.session.detail

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import study.me.please.base.BaseViewModel
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.data.io.session.SessionIO
import study.me.please.ui.collection.RefreshableViewModel
import study.me.please.ui.components.preference_chooser.PreferencePackDataManager
import study.me.please.ui.components.preference_chooser.PreferencePackRepository
import study.me.please.ui.components.preference_chooser.PreferencePackViewModel
import javax.inject.Inject

@HiltViewModel
class SessionDetailViewModel @Inject constructor(
    private val repository: SessionDetailRepository,
    private val dataManager: SessionDetailDataManager
): BaseViewModel(), PreferencePackViewModel, RefreshableViewModel {

    override val isRefreshing: MutableStateFlow<Boolean> = MutableStateFlow(false)
    override var lastRefreshTimeMillis: Long = 0L

    override val coroutineScope: CoroutineScope = viewModelScope

    override val preferencePackDataManager: PreferencePackDataManager = dataManager

    override val preferencePackRepository: PreferencePackRepository = repository

    /** all existing preferences to choose from if in testing mode */
    override val preferencePacks: StateFlow<List<SessionPreferencePack>?> = dataManager.preferencePacks.asStateFlow()

    /** Downloaded session from database */
    val session: StateFlow<SessionIO?> = dataManager.session.asStateFlow()

    /** Questions inside current session */
    val questions: StateFlow<List<QuestionIO>?> = dataManager.questions.asStateFlow()

    /** Collections inside current session */
    val collections: StateFlow<List<CollectionIO>?> = dataManager.collections.asStateFlow()

    //TODO refactor needed for the RefreshableViewModel
    var defaultName = ""
    var sessionUid: String? = null
    var collectionUidList: List<String> = listOf()
    var questionUidList: List<String> = listOf()

    override fun requestData(isSpecial: Boolean, isPullRefresh: Boolean) {
        viewModelScope.launch {
            if(isPullRefresh) setRefreshing(true)
            viewModelScope.launch {
                if(sessionUid.isNullOrEmpty()) {
                    if(dataManager.session.value == null) {
                        requestQuestions(questionUidList)
                        requestCollections(collectionUidList)

                        val collections = dataManager.collections.value.orEmpty()
                        val componentName = if(collections.size == 1) {
                            collections.firstOrNull()?.name ?: ""
                        }else ""

                        dataManager.session.value = SessionIO(
                            name = "$defaultName $componentName",
                            collectionUidList = collectionUidList.toMutableSet(),
                            questionUidList = questionUidList.toMutableSet()
                        )
                        saveSessionDetail()
                    }
                }else {
                    dataManager.session.value = repository.getSessionDetail(sessionUid ?: "")?.also {
                        requestCollections(it.collectionUidList.toList())
                    }
                }
            }
            if(isPullRefresh) setRefreshing(false)
        }
    }

    private suspend fun requestQuestions(uidList: List<String>) {
        dataManager.questions.value = repository.getQuestionsByUid(uidList).orEmpty()
    }

    private suspend fun requestCollections(uidList: List<String>) {
        dataManager.collections.value = repository.getCollectionsByUids(uidList)
    }

    /** Makes a request for a session save */
    fun saveSessionDetail() {
        viewModelScope.launch {
            dataManager.session.value?.let { session ->
                repository.saveSession(session)
            }
        }
    }
}