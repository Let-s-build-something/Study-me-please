package study.me.please.ui.session.play

import android.content.Context
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.squadris.squadris.compose.base.BaseViewModel
import com.squadris.squadris.utils.DateUtils
import com.squadris.squadris.utils.RefreshableViewModel.Companion.MINIMUM_REFRESH_DELAY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import study.me.please.data.io.BaseResponse
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.data.io.subjects.UnitIO
import study.me.please.data.state.session.QuestionModule
import study.me.please.ui.components.preference_chooser.PreferencePackDataManager
import study.me.please.ui.components.preference_chooser.PreferencePackRepository
import study.me.please.ui.components.preference_chooser.PreferencePackViewModel
import study.me.please.ui.units.utils.QuestionGenerator
import study.me.please.ui.units.utils.UnitsUseCase
import study.me.please.ui.units.utils.convertToSha256
import javax.inject.Inject

@HiltViewModel
class SessionViewModel @Inject constructor(
    private val repository: SessionRepository,
    private val dataManager: SessionDataManager,
    private val questionGenerator: QuestionGenerator,
    private val unitsUseCase: UnitsUseCase
): BaseViewModel(), PreferencePackViewModel {

    /** time in millisecond of the last refresh */
    private var lastRefreshTimeMillis: Long = 0

    override val coroutineScope: CoroutineScope = viewModelScope

    override val preferencePackDataManager: PreferencePackDataManager = dataManager

    override val preferencePackRepository: PreferencePackRepository = repository

    /** response from generating questions */
    private val _questionsGeneratingResponse = MutableStateFlow<BaseResponse<List<QuestionIO>>?>(null)


    /** all existing preferences to choose from if in testing mode */
    override val preferencePacks = dataManager.preferencePacks.asStateFlow()

    /** Received collection from database */
    val collections = dataManager.collections.asStateFlow()

    /** information about current session module - containing all major session state information */
    val questionModule = dataManager.questionModule.asStateFlow()

    /** Received session preferences from database */
    val preferencePack = dataManager.preferencePack.asStateFlow()

    /** full list of questions for the session screen */
    val questions = dataManager.questions.asStateFlow()

    /** response from generating questions */
    val questionsGeneratingResponse = _questionsGeneratingResponse.asStateFlow()

    /**
     * Prepares questions for this session in multiple steps:
     *
     * 1. selects units from selected collections based on user preferences
     * 2. if new user selection is detected, generates new questions, otherwise continues
     * 3. checks whether there is change in any of the units
     * 4. if change was detected, generates new questions, otherwise uses the existing questions
     *
     * Any generation leads to local save of the questions paired by the session uid
     *
     * @param context required for generating questions - retrieving resources
     * @param selectedUidList mixture of both collection uids and unit uids
     * @param excludedList list of elements to exclude from the generation, with specific reason - [Pair.second]
     */
    private suspend fun prepareQuestions(
        context: Context,
        sessionPreference: SessionPreferencePack,
        selectedUidList: List<String>,
        excludedList: List<Pair<String?, String?>>,
        historyQuestionUidList: List<String> = emptyList()
    ): List<QuestionIO> {
        Log.d("Session_Play", "prepareQuestions, excludedSize: ${excludedList.size}, historySize: ${historyQuestionUidList.size}")
        return withContext(Dispatchers.Default) {
            if(dataManager.session.value == null) {
                throw IllegalStateException(
                    "Session is not initialized. It is needed for hash comparison and retrieval of questions."
                )
            }

            val units = mutableListOf<UnitIO>()
            val selectedCollections = dataManager.collections.value?.filter { collection ->
                selectedUidList.isEmpty() || selectedUidList.contains(collection.uid)
            }

            selectedCollections?.map { it.uid }?.forEach { uid ->
                units.addAll(
                    unitsUseCase.getUnitsByCollection(uid).filter { unit ->
                        selectedUidList.isEmpty() || selectedUidList.contains(unit.uid)
                    }
                )
            }

            val snapshotHash = convertToSha256(
                units.sortedBy { it.uid }.joinToString(",")
            )
            Log.d("Session_Play", "previousSnapshotHash: ${dataManager.session.value?.lastSnapshotHash}," +
                    " newSnapshotHash: $snapshotHash, string: ${units.sortedBy { it.uid }.joinToString(",")}")
            val isSnapshotDifferent = snapshotHash != dataManager.session.value?.lastSnapshotHash
            val isSelectionDifferent = sessionPreference.selectedUidList.size != selectedUidList.size
                    || sessionPreference.selectedUidList.sorted() != selectedUidList.sorted()

            // generate new questions either due to different selection or different hash
            (if(isSelectionDifferent || isSnapshotDifferent) {
                val response = questionGenerator.generateQuestions(
                    context = context,
                    units = units,
                    allUnits = units,
                    excludedList = excludedList
                )
                Log.d("Session_Play", "prepareQuestions, number of questions generated: ${response.data?.size}")
                // new questions generated - clear old ones, save new ones. Saves new snapshot hash
                if(response.data?.isNotEmpty() == true) {
                    // delete old unused questions outside of the historic questions
                    repository.deleteQuestions(
                        dataManager.session.value?.questionUidList?.toList().orEmpty(),
                        excludedList = historyQuestionUidList
                    )

                    dataManager.session.value?.apply {
                        if(isSnapshotDifferent) {
                            lastSnapshotHash = snapshotHash
                        }
                        questionUidList.clear()
                        questionUidList.addAll(response.data.map { it.uid })
                    }

                    // save the new questions
                    repository.saveQuestions(response.data)
                    requestSessionSave(
                        // if selection changed, we need to save it as well
                        preferencePack = if(isSelectionDifferent) {
                            sessionPreference.copy(
                                selectedUidList = selectedUidList
                            )
                        }else null
                    )
                }
                _questionsGeneratingResponse.emit(response.copy(
                    responseCode = response.responseCode
                ))
                response.data?.shuffled()
            }else repository.getQuestionsByUid(
                dataManager.session.value?.questionUidList?.toList().orEmpty()
            )).orEmpty()
        }
    }

    /** Requests for all information needed to start or return back to a session */
    fun requestStateData(
        context: Context,
        isTestingMode: Boolean,
        collectionUid: String?,
        questionUid: String?,
        questionUids: List<String>?,
        sessionUid: String?,
        preferencePackUid: String?
    ) {
        viewModelScope.launch {
            lastRefreshTimeMillis = DateUtils.now.timeInMillis

            val questions = mutableListOf<QuestionIO>()
            val collections = mutableListOf<CollectionIO>()
            repository.getCollectionByUid(collectionUid)?.let { collectionDetail ->
                collections.add(collectionDetail)
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
                    Log.d("Session_Play", "static questions: ${questionsOut.size}")
                }
            }
            // session has both collections and questions
            // so we first retrieve collections to get all the necessary uids to get all questions needed
            repository.getSessionByUid(sessionUid)?.let { session ->
                dataManager.session.value = session

                dataManager.questionModule.value = repository.getQuestionModuleByUid(session.questionModuleUid)
                    ?: QuestionModule()
                dataManager.preferencePack.value = repository.getPreferencePackByUid(session.preferencePackUid)
                    ?: SessionPreferencePack()
                repository.getCollectionsByUidList(session.collectionUidList.toList())?.forEach { collection ->
                    collections.add(collection)
                    repository.getQuestionsByUid(collection.questionUidList.toList())?.let { questionsOut ->
                        questions.addAll(questionsOut)
                        Log.d("Session_Play", "static questions: ${questionsOut.size}")
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
                if(dataManager.questionModule.value == null) {
                    dataManager.questionModule.value = QuestionModule()
                }
            }

            // in case there is no preference pack, happens only while testing modules
            dataManager.preferencePack.value = if(dataManager.session.value == null
                && (dataManager.preferencePack.value == null
                        || dataManager.preferencePacks.value?.isEmpty() == true)
            ) {
                SessionPreferencePack()
            }else if(dataManager.preferencePacks.value?.isNotEmpty() == true) {
                dataManager.preferencePacks.value?.firstOrNull() ?: SessionPreferencePack()
            }else SessionPreferencePack()


            // finalizing the data and generation of questions if needed
            dataManager.collections.value = collections

            if(isTestingMode.not()) {
                val historyQuestionUidList = dataManager.questionModule.value?.history?.mapNotNull {
                    if(it.isRepetition.not()) {
                        it.importedSource?.sourceUid
                    }else null
                }.orEmpty().distinct()

                dataManager.preferencePack.value?.let { preferencePack ->
                    withContext(Dispatchers.Default) {
                        questions.addAll(
                            prepareQuestions(
                                context = context,
                                sessionPreference = preferencePack,
                                selectedUidList = preferencePack.selectedUidList,
                                historyQuestionUidList = historyQuestionUidList,
                                excludedList = dataManager.questionModule.value?.history?.mapNotNull {
                                    if(it.isRepetition.not()) {
                                        it.importedSource?.parent?.let { source ->
                                            source.sourceUid to source.reason
                                        }
                                    }else null
                                }.orEmpty()
                            )
                        )
                    }
                }

                // add historic questions - especially important for repetitions
                questions.addAll(
                    repository.getQuestionsByUid(historyQuestionUidList).orEmpty()
                )

                // save new module if it was just created
                if(dataManager.session.value?.questionModuleUid.isNullOrEmpty()) {
                    dataManager.questionModule.value?.let { newModule ->
                        repository.saveQuestionModule(newModule)
                    }
                }
            }

            delay(kotlin.math.max(
                DateUtils.now.timeInMillis.minus(lastRefreshTimeMillis),
                MINIMUM_REFRESH_DELAY
            ))

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
                        if(currentSession.questionModuleUid.isNullOrEmpty()) {
                            this.questionModuleUid = newModule.uid
                        }
                        repository.saveQuestionModule(newModule)
                    }
                    preferencePack?.let { newPreference ->
                        if(currentSession.preferencePackUid.isEmpty()) {
                            this.preferencePackUid = newPreference.uid
                        }
                        repository.savePreferencePack(newPreference)
                    }
                })
            }
        }
    }
}