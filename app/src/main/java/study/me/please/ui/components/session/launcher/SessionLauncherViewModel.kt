package study.me.please.ui.components.session.launcher

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import study.me.please.base.BaseViewModel
import study.me.please.data.io.session.SessionIO
import javax.inject.Inject

@HiltViewModel
class SessionLauncherViewModel @Inject constructor(
    private val repository: SessionLauncherRepository,
    private val dataManager: SessionLauncherDataManager
): BaseViewModel() {

    /** list of all sessions saved locally */
    var sessions = dataManager.sessions.asStateFlow()

    /** Requests all collections */
    fun requestSessions(
        collectionUidList: List<String>? = null,
        questionUidList: List<String>? = null,
        containsAll: Boolean = true
    ) {
        viewModelScope.launch {
            repository.getSessions()?.let { sessions ->
                dataManager.sessions.value = sessions.apply {
                    onEach { session ->
                        session.isPlayable = if(containsAll) {
                            (collectionUidList.isNullOrEmpty().not()
                                    && session.collectionUidList.containsAll(collectionUidList.orEmpty()))
                                    || (questionUidList.isNullOrEmpty().not()
                                    && session.questionUidList.containsAll(questionUidList.orEmpty()))
                        }else {
                            (collectionUidList.isNullOrEmpty().not()
                                    && session.collectionUidList.any { collectionUidList?.contains(it) == true })
                                    || (questionUidList.isNullOrEmpty().not()
                                    && session.questionUidList.any { questionUidList?.contains(it) == true })
                        }
                    }
                }.sortedWith(
                    if(containsAll) {
                        compareBy<SessionIO> { it.isPlayable }
                            .thenByDescending { it.lastPlayed }
                    }else {
                        compareByDescending<SessionIO> { it.isPlayable }
                            .thenByDescending { it.lastPlayed }
                    }
                )
            }
        }
    }

    /** Saves selected session into the sessions */
    fun saveSessionSelection(
        selectedSessionUidList: List<String>,
        collectionUidList: List<String>? = null,
        questionUidList: List<String>? = null
    ) {
        viewModelScope.launch {
            selectedSessionUidList.forEach { sessionUid ->
                dataManager.sessions.update { sessions ->
                    sessions?.apply {
                        find { it.uid == sessionUid }?.apply {
                            collectionUidList?.let { collectionUidList ->
                                this.collectionUidList.addAll(collectionUidList)
                            }
                            questionUidList?.let { questionUidList ->
                                this.questionUidList.addAll(questionUidList)
                            }
                            repository.saveSession(this)
                        }
                    }
                }
            }
        }
    }
}