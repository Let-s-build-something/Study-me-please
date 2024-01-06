package study.me.please.ui.collection.detail

import android.content.Context
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.squadris.squadris.utils.DateUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
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
import study.me.please.data.io.session.SessionIO
import study.me.please.data.io.clip_board.CollectionExport
import study.me.please.data.io.subjects.CategoryIO
import study.me.please.ui.collection.RefreshableViewModel
import study.me.please.ui.collection.detail.facts.FactsFilter
import study.me.please.ui.collection.detail.questions.QuestionsFilter
import study.me.please.ui.collection.detail.questions.SortByType
import study.me.please.ui.components.FactCardCategoryUseCase
import study.me.please.ui.components.collapsing_layout.CollapsingLayoutState
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class CollectionDetailViewModel @Inject constructor(
    private val repository: CollectionDetailRepository,
    private val dataManager: CollectionDetailDataManager,
    val clipBoard: GeneralClipBoard
): BaseViewModel(), RefreshableViewModel, FactCardCategoryUseCase {

    companion object {
        /** The minimum amount of facts required to make a question - 1 prompt 2 answers */
        private const val QUESTION_GENERATION_MINIMUM_FACTS = 3

        /** The maximum amount of answers in a generated question - 1 prompt 4 answers */
        private const val QUESTION_GENERATION_MAXIMUM_ANSWERS = 4
    }

    override val isRefreshing: MutableStateFlow<Boolean> = MutableStateFlow(false)
    override var lastRefreshTimeMillis: Long = 0L

    override val categories = dataManager.categories.asStateFlow()
        get() {
            if(field.value == null) requestAllCategories()
            return field
        }

    /** state for scrollable collapsing layout above everything else */
    val collapsingLayoutState = CollapsingLayoutState()

    /** response from question generation */
    var questionGenerationResponse = MutableSharedFlow<QuestionGenerationResponse>()

    /** Detail of received collection from database */
    var collectionDetail = dataManager.collectionDetail.asStateFlow()

    /** list of all sessions saved locally */
    var sessions = dataManager.sessions.asStateFlow()

    /** filter for questions */
    val questionsFilter: MutableStateFlow<QuestionsFilter> = MutableStateFlow(QuestionsFilter())

    /** local temporary save of downloaded questions */
    var collectionQuestions = dataManager.collectionQuestions.combine(questionsFilter) { collections, filter ->
        withContext(Dispatchers.Default) {
            collections.filter { question ->
                (filter.text.isEmpty() || (question.prompt.lowercase().contains(filter.text.lowercase())
                            || question.textExplanation.lowercase().contains(filter.text.lowercase())))
                        && (filter.isInvalid.not() || (question.answers.any { it.isCorrect }.not() || question.prompt.isEmpty()))
                        && (filter.hasImage.not() || (question.imagePromptUrl?.isEmpty == false
                            || question.imageExplanationUrl?.isEmpty == false
                            || question.answers.any { answer -> answer.imageExplanation?.isEmpty == false }))
            }.sortedWith(
                if(filter.sortBy == SortByType.DATE_CREATED_ASC) {
                    compareBy { it.dateCreated }
                }else compareByDescending { it.dateCreated }
            )
        }
    }

    /** filter for facts */
    val factsFilter: MutableStateFlow<FactsFilter> = MutableStateFlow(FactsFilter())

    /** local temporary save of downloaded facts */
    var collectionFacts = dataManager.collectionFacts.combine(factsFilter) { collections, filter ->
        withContext(Dispatchers.Default) {
            collections.filter { fact ->
                (filter.types.isEmpty() || filter.types.contains(fact.type))
                        && (filter.textFilter.isEmpty()
                                || (fact.shortKeyInformation.lowercase().contains(filter.textFilter.lowercase())
                                || fact.longInformation.lowercase().contains(filter.textFilter.lowercase())))
            }.sortedWith(
                if(filter.sortBy == SortByType.DATE_CREATED_ASC) {
                    compareBy { it.dateCreated }
                }else compareByDescending { it.dateCreated }
            )
        }
    }

    /** currently displayed colection identifier */
    var collectionUid: String = ""

    override fun requestData(isSpecial: Boolean, isPullRefresh: Boolean) {
        viewModelScope.launch {
            if(isPullRefresh) setRefreshing(true)
            repository.getCollectionByUid(collectionUid)?.let { collectionDetail ->
                dataManager.collectionDetail.value = collectionDetail
                requestCachedQuestions(questionUidList = collectionDetail.questionUidList.toList())
                requestCachedFacts(factUidList = collectionDetail.factUidList.toList())
            }
            if(isPullRefresh) setRefreshing(false)
        }
    }

    /** Requests for a collection data save */
    fun requestCollectionSave(collection: CollectionIO) {
        viewModelScope.launch(Dispatchers.Default) {
            if(collection.isNotEmpty) {
                repository.saveCollection(collection = collection.apply {
                    dateModified = DateUtils.now.time
                    if(collection.dateCreated == null) dateCreated = DateUtils.now.time
                })
            }
        }
    }

    override fun requestAllCategories() {
        viewModelScope.launch {
            dataManager.categories.value = repository.getAllCategories()
        }
    }

    override fun requestAddNewCategory(name: String) {
        viewModelScope.launch {
            val category = CategoryIO(name = name)
            dataManager.categories.update { previousCategories ->
                previousCategories?.toMutableList()?.apply {
                    add(category)
                }
            }
        }
    }

    private fun requestCachedQuestions(questionUidList: List<String>) {
        viewModelScope.launch {
            dataManager.collectionQuestions.value = repository.getQuestionsByUid(
                questionUidList
            ).orEmpty().also { newList ->
                if(newList.isNotEmpty()
                    && newList.size != dataManager.collectionDetail.value.questionUidList.size
                ) {
                    dataManager.collectionDetail.value.questionUidList = newList.map { it.uid }.toMutableSet()
                }
            }
        }
    }

    private fun requestCachedFacts(factUidList: List<String>) {
        viewModelScope.launch {
            dataManager.collectionFacts.value = repository.getFactsByUid(
                factUidList
            ).orEmpty().also { newList ->
                if(newList.isNotEmpty()
                    && newList.size != dataManager.collectionDetail.value.factUidList.size
                ) {
                    dataManager.collectionDetail.value.factUidList = newList.map { it.uid }.toMutableSet()
                }
            }
        }
    }

    /** Generates questions from facts */
    fun requestQuestionGeneration(
        context: Context,
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

            val existingQuestions = dataManager.collectionQuestions.value.map { it.importedSource.sourceUid }
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
                            factsToGenerate = factsToGenerateTyped,
                            context = context
                        ).let { res ->
                            // if logic wasn't able to generate anything, pass on the facts that failed
                            if(res.isNotEmpty()) {
                                newQuestions.addAll(0, res)
                            }else leftOverFacts.addAll(0, factsToGenerateTyped)
                        }
                    }else {
                        leftOverFacts.addAll(0, factsToGenerateTyped)
                    }
                }
            }
            newQuestions.addAll(0,
                generateQuestions(
                    factsToGenerate = leftOverFacts,
                    factsToShuffle = facts,
                    context = context,
                    isLeftOvers = true
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
        context: Context,
        isLeftOvers: Boolean = false,
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
                        questions.add(0,
                            QuestionIO(
                                importedSource = ImportedSource(ImportSourceType.FACT, sourceUid = coreFact.uid),
                                prompt = if(isLeftOvers) {
                                    coreFact.getGenericShortPrompt(context)
                                } else coreFact.getShortPrompt(context),
                                textExplanation = coreFact.longInformation,
                                imageExplanationUrl = coreFact.promptImage,
                                answers = usableFacts
                                    .shuffled()
                                    .take(usableFacts.size.coerceIn(
                                        QUESTION_GENERATION_MINIMUM_FACTS.minus(1),
                                        QUESTION_GENERATION_MAXIMUM_ANSWERS.minus(1),
                                    ))
                                    .map {
                                        QuestionAnswerIO(
                                            text = it.longInformation,
                                            explanationMessage = it.shortKeyInformation,
                                            imageExplanation = it.promptImage
                                        )
                                    }
                                    .plus(
                                        QuestionAnswerIO(
                                            text = coreFact.longInformation,
                                            explanationMessage = coreFact.shortKeyInformation,
                                            imageExplanation = coreFact.promptImage,
                                            isCorrect = true
                                        )
                                    )
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
                        questions.add(0,
                            QuestionIO(
                                importedSource = ImportedSource(ImportSourceType.FACT, sourceUid = coreFact.uid),
                                prompt = if(isLeftOvers) {
                                    coreFact.getGenericLongPrompt(context)
                                }else coreFact.getLongPrompt(context),
                                imageExplanationUrl = coreFact.promptImage,
                                answers = usableFacts
                                    .shuffled()
                                    .take(usableFacts.size.coerceIn(
                                        QUESTION_GENERATION_MINIMUM_FACTS.minus(1),
                                        QUESTION_GENERATION_MAXIMUM_ANSWERS.minus(1),
                                    ))
                                    .map {
                                        QuestionAnswerIO(
                                            text = it.shortKeyInformation,
                                            explanationMessage = it.longInformation,
                                            imageExplanation = it.promptImage
                                        )
                                    }
                                    .plus(
                                        QuestionAnswerIO(
                                            text = coreFact.shortKeyInformation,
                                            explanationMessage = coreFact.longInformation,
                                            imageExplanation = coreFact.promptImage,
                                            isCorrect = true
                                        )
                                    )
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
                        questions.add(0,
                            QuestionIO(
                                importedSource = ImportedSource(ImportSourceType.FACT, sourceUid = coreFact.uid),
                                prompt = if(isLeftOvers) {
                                    coreFact.getGenericImagePrompt(context)
                                } else coreFact.getImagePrompt(context),
                                imagePromptUrl = coreFact.promptImage,
                                textExplanation = coreFact.imageExplanationText,
                                answers = usableFactsShort
                                    .shuffled()
                                    .take(usableFactsShort.size.coerceIn(
                                        QUESTION_GENERATION_MINIMUM_FACTS.minus(1),
                                        QUESTION_GENERATION_MAXIMUM_ANSWERS.minus(1),
                                    ))
                                    .map {
                                        QuestionAnswerIO(
                                            text = it.shortKeyInformation,
                                            explanationMessage = it.longInformation
                                        )
                                    }
                                    .plus(
                                        QuestionAnswerIO(
                                            text = coreFact.shortKeyInformation,
                                            explanationMessage = coreFact.longInformation,
                                            isCorrect = true
                                        )
                                    )
                                    .toMutableList()
                            )
                        )
                    }
                    val usableFactsLong = factsToShuffle
                        .filter { it.uid != coreFact.uid && it.shortKeyInformation.isNotEmpty() }
                    if(usableFactsLong.size >= QUESTION_GENERATION_MINIMUM_FACTS.minus(1)) {
                        questions.add(0,
                            QuestionIO(
                                importedSource = ImportedSource(ImportSourceType.FACT, sourceUid = coreFact.uid),
                                prompt = if(isLeftOvers) {
                                    coreFact.getGenericImagePrompt(context)
                                } else coreFact.getImagePrompt(context),
                                imagePromptUrl = coreFact.promptImage,
                                textExplanation = coreFact.imageExplanationText,
                                answers = usableFactsLong
                                    .shuffled()
                                    .take(usableFactsLong.size.coerceIn(
                                        QUESTION_GENERATION_MINIMUM_FACTS.minus(1),
                                        QUESTION_GENERATION_MAXIMUM_ANSWERS.minus(1),
                                    ))
                                    .map {
                                        QuestionAnswerIO(
                                            text = it.longInformation,
                                            explanationMessage = it.shortKeyInformation
                                        )
                                    }
                                    .plus(
                                        QuestionAnswerIO(
                                            text = coreFact.longInformation,
                                            explanationMessage = coreFact.shortKeyInformation,
                                            isCorrect = true
                                        )
                                    )
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
    private fun requestQuestionsSave(questions: List<QuestionIO>) {
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
            dataManager.collectionQuestions.update { questions ->
                questions.toMutableList().apply {
                    removeAll { uidList.contains(it.uid) }
                }
            }
        }
    }

    /** Requests for a fact data save */
    fun requestFactSave(fact: FactIO) {
        viewModelScope.launch {
            repository.saveFact(fact)
        }
    }

    /** Adds a new fact */
    fun addNewFact(isEmpty: Boolean = false) {
        viewModelScope.launch {
            val newFact = if(isEmpty && factsFilter.value.isEmpty().not()) {
                FactIO(
                    shortKeyInformation = factsFilter.value.textFilter,
                    type = factsFilter.value.types.firstOrNull() ?: FactType.BULLET_POINTS
                )
            }else FactIO()
            dataManager.collectionFacts.update {
                it.toMutableList().apply { add(0, newFact) }
            }
        }
    }

    /** Adds a new question */
    fun addNewQuestion(): QuestionIO {
        val newQuestion = QuestionIO(uid = "TESTING QUESTION CREATION".plus(UUID.randomUUID().toString()))
        dataManager.collectionQuestions.update {
            it.toMutableList().apply {
                add(0, newQuestion)
            }
        }
        viewModelScope.launch {
            requestCollectionSave(dataManager.collectionDetail.value.apply {
                questionUidList.add(newQuestion.uid)
            })
        }
        return newQuestion
    }

    /** Pastes current clipboard */
    fun pasteFactsClipBoard() {
        viewModelScope.launch {
            val clipBoard = clipBoard.facts.paste()
            clipBoard.forEach {
                requestFactSave(it)
            }
            dataManager.collectionFacts.update {
                it.toMutableList().apply { addAll(0, clipBoard) }
            }
            requestCollectionSave(dataManager.collectionDetail.value.apply {
                questionUidList.addAll(clipBoard.map { it.uid })
            })
        }
    }

    /** Pastes current clipboard */
    fun pasteQuestionsClipBoard() {
        viewModelScope.launch {
            val clipBoard = clipBoard.questions.paste()
            clipBoard.forEach {
                requestQuestionSave(it)
            }
            dataManager.collectionQuestions.update {
                it.toMutableList().apply { addAll(0, clipBoard) }
            }
        }
    }

    /** Requests for a removal of facts */
    fun requestFactsDeletion(uidList: Set<String>) {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                dataManager.collectionFacts.update { facts ->
                    facts.toMutableList().apply {
                        removeAll { uidList.contains(it.uid) }
                    }
                }
            }
            repository.deleteFacts(uidList.toList())
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

    /** Returns a json string in [onSuccess] for quick clipboard export */
    fun getExportString(onSuccess: (json: String) -> Unit) {
        viewModelScope.launch {
            repository.exportCollection(
                CollectionExport(
                    collection = collectionDetail.value,
                    questions = dataManager.collectionQuestions.value,
                    facts = dataManager.collectionFacts.value,
                ),
                onSuccess = onSuccess
            )
        }
    }

    /** Update current TO with new one */
    fun updateCollection(collection: CollectionIO) {
        dataManager.collectionDetail.update { previousCollection ->
            previousCollection.copy(
                description = collection.description,
                name = collection.name
            )
        }
    }
}