package study.me.please.ui.collection.detail

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.squadris.squadris.utils.DateUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import study.me.please.base.BaseViewModel
import study.me.please.base.GeneralClipBoard
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.FactIO
import study.me.please.data.io.FactType
import study.me.please.data.io.ImportSourceType
import study.me.please.data.io.ImportedSource
import study.me.please.data.io.QuestionAnswerIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.SessionIO
import javax.inject.Inject

@HiltViewModel
class CollectionDetailViewModel @Inject constructor(
    private val repository: CollectionDetailRepository,
    private val dataManager: CollectionDetailDataManager,
    val clipBoard: GeneralClipBoard
): BaseViewModel() {

    companion object {
        /** The minimum amount of facts required to make a question - 1 prompt 2 answers */
        private const val QUESTION_GENERATION_MINIMUM_FACTS = 3

        /** The maximum amount of answers in a generated question - 1 prompt 4 answers */
        private const val QUESTION_GENERATION_MAXIMUM_ANSWERS = 4
    }

    /** response from question generation */
    var questionGenerationResponse = MutableSharedFlow<QuestionGenerationResponse>()

    /** Detail of received collection from database */
    var collectionDetail = dataManager.collectionDetail.asStateFlow()

    /** list of all sessions saved locally */
    var sessions = dataManager.sessions.asStateFlow()

    /** local temporary save of downloaded questions */
    var collectionQuestions = dataManager.collectionQuestions.asStateFlow()

    /** local temporary save of downloaded facts */
    var collectionFacts = dataManager.collectionFacts.asStateFlow()

    /** Requests for a specific collection by an ID */
    fun requestCollectionByUid(collectionUid: String) {
        viewModelScope.launch {
            repository.getCollectionByUid(collectionUid)?.let { collectionDetail ->
                dataManager.collectionDetail.value = collectionDetail
                requestCachedQuestions(questionUidList = collectionDetail.questionUidList.toList())
                requestCachedFacts(factUidList = collectionDetail.factUidList.toList())
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

    private fun requestCachedQuestions(questionUidList: List<String>) {
        viewModelScope.launch {
            dataManager.collectionQuestions.value = repository.getQuestionsByUid(
                questionUidList
            ).orEmpty()
        }
    }

    /** Generates questions from facts */
    fun requestQuestionGeneration(
        selectedFactUids: List<String>,
        facts: List<FactIO>
    ) {
        // chunk facts into types
        // go fact by fact and generate 2 questions for each fact
        // any leftover facts match together

        viewModelScope.launch(Dispatchers.Default) {
            // we shouldn't be here at all, return error
            if(facts.size < QUESTION_GENERATION_MINIMUM_FACTS) {
                Log.e("collection_view_model", "NOT_ENOUGH_FACTS, size: ${facts.size}")
                questionGenerationResponse.emit(
                    QuestionGenerationResponse(errorType = ErrorType.NOT_ENOUGH_FACTS)
                )
            }

            val existingQuestions = collectionQuestions.value.map { it.importedSource.sourceUid }
            val newQuestions = mutableListOf<QuestionIO>()
            val factsToGenerate = facts.filter {
                selectedFactUids.contains(it.uid)
                        && existingQuestions.contains(it.uid).not()
            }.toMutableList()
            val leftOverFacts = mutableListOf<FactIO>()

            FactType.values().forEach { factType ->
                val factsToGenerateTyped = factsToGenerate.filter { it.type == factType }
                val factsToShuffle = facts.filter { it.type == factType }

                if(factsToGenerateTyped.isNotEmpty()) {
                    if(factsToShuffle.size >= QUESTION_GENERATION_MINIMUM_FACTS) {
                        generateQuestions(
                            factsToShuffle = factsToShuffle,
                            factsToGenerate = factsToGenerateTyped
                        ).let { res ->
                            // if logic wasn't able to generate anything, pass on the facts that failed
                            if(res.isNotEmpty()) {
                                newQuestions.addAll(res)
                            }else leftOverFacts.addAll(factsToGenerateTyped)
                        }
                    }else {
                        leftOverFacts.addAll(factsToGenerateTyped)
                    }
                }
            }
            newQuestions.addAll(
                generateQuestions(
                    factsToGenerate = leftOverFacts,
                    factsToShuffle = facts
                )
            )
            questionGenerationResponse.emit(
                if(newQuestions.size > 0) {
                    QuestionGenerationResponse(
                        isSuccessful = true,
                        questionsGenerated = newQuestions.size
                    )
                }else {
                    QuestionGenerationResponse(errorType = ErrorType.NOT_ENOUGH_FACTS)
                }
            )

            // save data
            dataManager.collectionDetail.update { collection ->
                collection.apply {
                    questionUidList.addAll(newQuestions.map { it.uid })
                }
            }
            requestCollectionSave(dataManager.collectionDetail.value)
            requestQuestionsSave(newQuestions)
            dataManager.collectionQuestions.update {
                newQuestions.plus(it)
            }
        }
    }

    private suspend fun generateQuestions(
        factsToGenerate: List<FactIO>,
        factsToShuffle: List<FactIO>
    ): List<QuestionIO> {
        return withContext(Dispatchers.Default) {
            val questions = mutableListOf<QuestionIO>()
            factsToGenerate.forEach { coreFact ->
                // short information as a prompt, long information as answers
                if(coreFact.shortKeyInformation.isNotEmpty()) {
                    val usableFacts = factsToShuffle
                        .filter { it.uid != coreFact.uid && it.longInformation.isNotEmpty() }
                    // do we have enough answers to generate question?
                    if(usableFacts.size >= QUESTION_GENERATION_MINIMUM_FACTS.minus(1)) {
                        questions.add(
                            QuestionIO(
                                importedSource = ImportedSource(ImportSourceType.FACT, sourceUid = coreFact.uid),
                                prompt = coreFact.shortKeyInformation,
                                textExplanation = coreFact.longInformation,
                                imageExplanationUrl = coreFact.promptImage,
                                answers = usableFacts
                                    .shuffled()
                                    .take(usableFacts.size.coerceIn(
                                        QUESTION_GENERATION_MINIMUM_FACTS.minus(1),
                                        QUESTION_GENERATION_MAXIMUM_ANSWERS,
                                    ))
                                    .map {
                                        QuestionAnswerIO(
                                            text = it.longInformation,
                                            explanationMessage = it.shortKeyInformation,
                                            imageExplanation = it.promptImage
                                        )
                                    }
                                    .toMutableList()
                            )
                        )
                    }
                    //TODO add image answers?
                }
                // long information as a prompt, short information as answers
                if(coreFact.longInformation.isNotEmpty()) {
                    val usableFacts = factsToShuffle
                        .filter { it.uid != coreFact.uid && it.shortKeyInformation.isNotEmpty() }
                    // do we have enough answers to generate question?
                    if(usableFacts.size >= QUESTION_GENERATION_MINIMUM_FACTS.minus(1)) {
                        questions.add(
                            QuestionIO(
                                importedSource = ImportedSource(ImportSourceType.FACT, sourceUid = coreFact.uid),
                                prompt = coreFact.longInformation,
                                imageExplanationUrl = coreFact.promptImage,
                                answers = usableFacts
                                    .shuffled()
                                    .take(usableFacts.size.coerceIn(
                                        QUESTION_GENERATION_MINIMUM_FACTS.minus(1),
                                        QUESTION_GENERATION_MAXIMUM_ANSWERS,
                                    ))
                                    .map {
                                        QuestionAnswerIO(
                                            text = it.shortKeyInformation,
                                            explanationMessage = it.longInformation,
                                            imageExplanation = it.promptImage
                                        )
                                    }
                                    .toMutableList()
                            )
                        )
                    }
                    //TODO add image answers?
                }
                // Image as a prompt, both short and long information as answers
                if(coreFact.promptImage?.isEmpty == false) {
                    val usableFactsShort = factsToShuffle
                        .filter { it.uid != coreFact.uid && it.shortKeyInformation.isNotEmpty() }
                    if(usableFactsShort.size >= QUESTION_GENERATION_MINIMUM_FACTS.minus(1)) {
                        questions.add(
                            QuestionIO(
                                importedSource = ImportedSource(ImportSourceType.FACT, sourceUid = coreFact.uid),
                                imagePromptUrl = coreFact.promptImage,
                                textExplanation = coreFact.imageExplanationText,
                                answers = usableFactsShort
                                    .shuffled()
                                    .take(usableFactsShort.size.coerceIn(
                                        QUESTION_GENERATION_MINIMUM_FACTS.minus(1),
                                        QUESTION_GENERATION_MAXIMUM_ANSWERS,
                                    ))
                                    .map {
                                        QuestionAnswerIO(
                                            text = it.shortKeyInformation,
                                            explanationMessage = it.longInformation
                                        )
                                    }
                                    .toMutableList()
                            )
                        )
                    }
                    val usableFactsLong = factsToShuffle
                        .filter { it.uid != coreFact.uid && it.shortKeyInformation.isNotEmpty() }
                    if(usableFactsLong.size >= QUESTION_GENERATION_MINIMUM_FACTS.minus(1)) {
                        questions.add(
                            QuestionIO(
                                importedSource = ImportedSource(ImportSourceType.FACT, sourceUid = coreFact.uid),
                                imagePromptUrl = coreFact.promptImage,
                                textExplanation = coreFact.imageExplanationText,
                                answers = usableFactsLong
                                    .shuffled()
                                    .take(usableFactsLong.size.coerceIn(
                                        QUESTION_GENERATION_MINIMUM_FACTS.minus(1),
                                        QUESTION_GENERATION_MAXIMUM_ANSWERS,
                                    ))
                                    .map {
                                        QuestionAnswerIO(
                                            text = it.longInformation,
                                            explanationMessage = it.shortKeyInformation
                                        )
                                    }
                                    .toMutableList()
                            )
                        )
                    }
                }
            }
            questions
        }
    }

    /** Requests for a question data save */
    fun requestQuestionSave(question: QuestionIO) {
        viewModelScope.launch(Dispatchers.Default) {
            repository.saveQuestion(question)
        }
    }

    /** Requests for a question data save */
    fun requestQuestionsSave(questions: List<QuestionIO>) {
        viewModelScope.launch(Dispatchers.Default) {
            questions.forEach { question ->
                repository.saveQuestion(question)
            }
        }
    }

    /** Requests for a removal of questions */
    fun requestQuestionsDeletion(uidList: Set<String>) {
        viewModelScope.launch {
            repository.deleteQuestions(uidList.toList())
        }
    }

    private fun requestCachedFacts(factUidList: List<String>) {
        viewModelScope.launch {
            dataManager.collectionFacts.value = repository.getFactsByUid(
                factUidList
            ).orEmpty()
        }
    }

    /** Requests for a fact data save */
    fun requestFactSave(fact: FactIO) {
        viewModelScope.launch {
            repository.saveFact(fact)
        }
    }

    /** Requests for a removal of facts */
    fun requestFactsDeletion(uidList: Set<String>) {
        viewModelScope.launch {
            repository.deleteFacts(uidList.toList())
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