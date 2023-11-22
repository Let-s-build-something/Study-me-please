package study.me.please.ui.session

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import study.me.please.base.BaseViewModel
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.session.SessionIO
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.ui.components.preference_chooser.PreferencePackDataManager
import study.me.please.ui.components.preference_chooser.PreferencePackRepository
import study.me.please.ui.components.preference_chooser.PreferencePackViewModel
import javax.inject.Inject

@HiltViewModel
class SessionViewModel @Inject constructor(
    private val repository: SessionRepository,
    private val dataManager: SessionDataManager
): BaseViewModel(), PreferencePackViewModel {

    override val coroutineScope: CoroutineScope = viewModelScope

    override val preferencePackDataManager: PreferencePackDataManager = dataManager

    override val preferencePackRepository: PreferencePackRepository = repository

    /** all existing preferences to choose from if in testing mode */
    override val preferencePacks: StateFlow<List<SessionPreferencePack>?> = dataManager.preferencePacks.asStateFlow()

    /** Received collection from database */
    val collection: StateFlow<CollectionIO?> = dataManager.collection.asStateFlow()

    /** Received session from database */
    val session: StateFlow<SessionIO?> = dataManager.session.asStateFlow()

    /** Received session preferences from database */
    val preferencePack: StateFlow<SessionPreferencePack?> = dataManager.preferencePack.asStateFlow()

    /** full list of questions for the session screen */
    val questions: StateFlow<List<QuestionIO>?> = dataManager.questions.asStateFlow()

    /** Requests for all information needed to start or return back to a session */
    fun requestStateData(
        isTestingMode: Boolean,
        collectionUid: String?,
        questionUid: String?,
        questionUids: List<String>?,
        sessionUid: String?,
        preferencePackUid: String?
    ) {
        viewModelScope.launch {
            val questions = mutableListOf<QuestionIO>()
            repository.getCollectionByUid(collectionUid)?.let { collectionDetail ->
                dataManager.collection.value = collectionDetail
                repository.getQuestionsByUid(collectionDetail.questionUidList.toList())?.let { questionsOut ->
                    questions.addAll(questionsOut)
                }
            }
            repository.getQuestionByUid(questionUid)?.let { question ->
                questions.add(question)
            }
            if(questionUids.isNullOrEmpty().not()) {
                repository.getQuestionsByUid(questionUids.orEmpty())?.let { questionsOut ->
                    questions.addAll(questionsOut)
                }
            }
            // session has both collections and questions
            // so we first retrieve collections to get all the necessary uids to get all questions needed
            repository.getSessionByUid(sessionUid)?.let { session ->
                dataManager.session.value = session
                dataManager.preferencePack.value = repository.getPreferencePackByUid(session.preferencePackUid)
                    ?: SessionPreferencePack()
                repository.getQuestionsByUid(session.questionUidList.toList())?.let { questionsOut ->
                    questions.addAll(questionsOut)
                }
                repository.getCollectionsByUidList(session.collectionUidList.toList())?.forEach { collection ->
                    repository.getQuestionsByUid(collection.questionUidList.toList())?.let { questionsOut ->
                        questions.addAll(questionsOut)
                    }
                }
            }
            repository.getPreferencePackByUid(preferencePackUid)?.let { preferencePack ->
                dataManager.preferencePack.value = preferencePack
            }
            if(isTestingMode) {
                repository.getPreferencePacks().let { preferencePacks ->
                    dataManager.preferencePacks.value = preferencePacks.toMutableList()
                }
            }
            // in case there is no preference pack, happens only while testing modules
            if(dataManager.session.value == null
                && (dataManager.preferencePack.value == null
                || dataManager.preferencePacks.value?.isEmpty() == true)
            ) {
                dataManager.preferencePack.value = SessionPreferencePack()
            }else if(dataManager.preferencePacks.value?.isNotEmpty() == true) {
                dataManager.preferencePack.value = dataManager.preferencePacks.value
                    ?.firstOrNull() ?: SessionPreferencePack()
            }
            dataManager.questions.value = questions
        }
    }

    /** Requests a save of the current session */
    fun requestSessionSave(
        questionModule: QuestionModule? = null,
        preferencePack: SessionPreferencePack? = null
    ) {
        dataManager.session.value?.let { currentSession ->
            viewModelScope.launch {
                repository.saveSession(currentSession.apply {
                    questionModule?.let { newModule ->
                        this.questionModule = newModule
                    }
                    preferencePack?.let { newPreference ->
                        this.preferencePackUid = newPreference.uid
                    }
                })
            }
        }
    }

    /** saves current session */
    fun requestQuestionModuleSave(questionModule: QuestionModule) {
        viewModelScope.launch {
            dataManager.session.value?.let { session ->
                repository.saveSession(session.apply {
                    this.questionModule = questionModule
                })
            }
            repository.saveQuestionModule(questionModule.apply {
                sessionUid = dataManager.session.value?.uid
            })
        }
    }
}