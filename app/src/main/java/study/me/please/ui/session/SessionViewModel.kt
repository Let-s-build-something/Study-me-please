package study.me.please.ui.session

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import study.me.please.base.BaseViewModel
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.preferences.SessionPreferencePack
import javax.inject.Inject

@HiltViewModel
class SessionViewModel @Inject constructor(
    private val repository: SessionRepository,
    val dataManager: SessionDataManager
): BaseViewModel() {

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
                repository.getQuestionsByUid(collectionDetail.questionUids)?.let { questionsOut ->
                    questions.addAll(questionsOut)
                }
            }
            repository.getQuestionByUid(questionUid)?.let { question ->
                dataManager.question.value = question
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
                repository.getCollectionsByUids(session.collectionUids)?.let { collections ->
                    withContext(Dispatchers.Default) {
                        repository.getQuestionsByUid(
                            session.questionUids.plus(collections.map { it.questionUids }.flatten())
                        )?.let { questionsOut ->
                            questions.addAll(questionsOut)
                        }
                    }
                }
            }
            repository.getPreferencePackByUid(preferencePackUid)?.let { preferencePack ->
                dataManager.preferencePack.value = preferencePack
            }
            if(isTestingMode) {
                repository.getAllPreferences()?.let { preferencePacks ->
                    dataManager.preferencePacks.value = preferencePacks
                }
            }
            // in case there is no preference pack, happens only while testing modules
            if(dataManager.session.value == null
                && dataManager.preferencePack.value == null
                && dataManager.preferencePacks.value?.isEmpty() == true
            ) {
                dataManager.preferencePack.value = SessionPreferencePack()
            }else if(dataManager.preferencePacks.value?.isNotEmpty() == true) {
                dataManager.preferencePack.value = dataManager.preferencePacks.value
                    ?.firstOrNull() ?: SessionPreferencePack()
            }
            dataManager.questions.value = questions
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
                        this.preferences = newPreference
                    }
                })
            }
        }
    }
}