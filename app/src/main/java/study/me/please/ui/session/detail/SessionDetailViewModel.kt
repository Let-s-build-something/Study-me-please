package study.me.please.ui.session.detail

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import study.me.please.base.BaseViewModel
import study.me.please.data.io.session.SessionIO
import study.me.please.data.state.session.QuestionModule
import study.me.please.ui.collection.RefreshableViewModel
import study.me.please.ui.components.preference_chooser.PreferencePackViewModel
import javax.inject.Inject

@HiltViewModel
class SessionDetailViewModel @Inject constructor(
    private val repository: SessionDetailRepository,
    private val dataManager: SessionDetailDataManager
): BaseViewModel(), PreferencePackViewModel, RefreshableViewModel {

    override val isRefreshing = MutableStateFlow(false)
    override var lastRefreshTimeMillis = 0L

    override val coroutineScope = viewModelScope

    override val preferencePackDataManager = dataManager

    override val preferencePackRepository = repository

    /** all existing preferences to choose from if in testing mode */
    override val preferencePacks = dataManager.preferencePacks.asStateFlow()

    /** Downloaded session from database */
    val session = dataManager.session.asStateFlow()

    /** Questions inside current session */
    val questions = dataManager.questions.asStateFlow()

    /** Collections inside current session */
    val collections = dataManager.collections.asStateFlow()

    /** information about current session module - containing all major session state information */
    val questionModule = dataManager.questionModule.asStateFlow()

    //TODO refactor needed for the RefreshableViewModel
    var defaultName = ""
    var sessionUid: String? = null
    var collectionUidList: List<String> = listOf()
    var questionUidList: List<String> = listOf()

    override suspend fun onDataRequest(isSpecial: Boolean, isPullRefresh: Boolean) {
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
        dataManager.questionModule.value = repository.getQuestionModuleByUid(
            dataManager.session.value?.questionModuleUid
        ) ?: QuestionModule()
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