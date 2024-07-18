package study.me.please.ui.session.detail

import androidx.lifecycle.viewModelScope
import com.squadris.squadris.compose.base.BaseViewModel
import com.squadris.squadris.utils.RefreshableViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.data.io.session.SessionIO
import study.me.please.data.state.session.QuestionModule
import java.util.UUID


/** Communication bridge between UI and DB */
@HiltViewModel(assistedFactory = SessionDetailViewModel.SessionDetailViewModelFactory::class)
class SessionDetailViewModel @AssistedInject constructor(
    @Assisted("sessionUid") private val sessionUid: String,
    @Assisted("defaultName") private val defaultName: String,
    @Assisted("collectionUidList") private val collectionUidList: List<String> = listOf(),
    @Assisted("questionUidList") private val questionUidList: List<String> = listOf(),
    private val repository: SessionDetailRepository,
    private val dataManager: SessionDetailDataManager,
): BaseViewModel(), RefreshableViewModel {

    /** factory for creating session detail viewmodel with an argument */
    @AssistedFactory
    interface SessionDetailViewModelFactory {
        /** creates an instance with an argument */
        fun create(
            @Assisted("sessionUid") sessionUid: String?,
            @Assisted("defaultName") defaultName: String,
            @Assisted("collectionUidList") collectionUidList: List<String> = listOf(),
            @Assisted("questionUidList") questionUidList: List<String> = listOf()
        ): SessionDetailViewModel
    }


    override val isRefreshing = MutableStateFlow(false)
    override var lastRefreshTimeMillis = 0L

    /** Downloaded session from database */
    val session = dataManager.session.asStateFlow()

    /** Questions inside current session */
    val questions = dataManager.questions.asStateFlow()

    /** Collections inside current session */
    val collections = dataManager.collections.asStateFlow()

    /** information about current session module - containing all major session state information */
    val sessionPreferenceModule = dataManager.questionModule.asStateFlow()

    override suspend fun onDataRequest(isSpecial: Boolean, isPullRefresh: Boolean) {
        if(sessionUid.isEmpty()) {
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
            dataManager.session.value = repository.getSessionDetail(sessionUid)?.also {
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
    private fun saveSessionDetail() {
        viewModelScope.launch {
            dataManager.session.value?.let { session ->
                repository.saveSession(session)
            }
        }
    }

    /** Updates the preference's name */
    fun updateSessionName(name: String) {
        viewModelScope.launch {
            repository.saveSession(
                dataManager.session.value?.apply {
                    this.name = name
                } ?: return@launch
            )
        }
    }

    /** Updates the preferences of this session */
    fun updatePreferencePack(newPack: SessionPreferencePack) {
        viewModelScope.launch {
            dataManager.session.update { previousSession ->
                previousSession?.copy(preferencePack = newPack)?.apply {
                    changeHash = UUID.randomUUID().toString()
                    repository.saveSession(this)
                }
            }
        }
    }

    /** Makes a request for removal of items from the session */
    fun removeItems(uidList: Set<String>) {
        viewModelScope.launch {
            dataManager.session.update { previousSession ->
                previousSession?.also { session ->
                    session.questionUidList.removeAll(uidList)
                    session.collectionUidList.removeAll(uidList)
                    repository.saveSession(session)
                }
            }
        }
    }
}