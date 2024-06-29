package study.me.please.ui.units.utils

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.R
import study.me.please.data.io.BaseResponse
import study.me.please.data.io.FactIO
import study.me.please.data.io.FactType
import study.me.please.data.io.ImportSourceType
import study.me.please.data.io.ImportedSource
import study.me.please.data.io.QuestionAnswerIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.data.io.subjects.UnitIO
import java.security.MessageDigest
import java.util.Base64
import javax.inject.Inject

/**
 * Util class for creating sets of Questions from either Subjects or Facts.
 *      -In the case of Facts, each can have Category, by which facts are paired most importantly,
 *          secondly, they are paired by their [FactType], if neither can be done, they are mixed with pairing
 *      -Subjects are identified by its user inputted name, (can be further Categorized) and has further nested content
 *          that is Categorized by the Subject name and its Categories. Further nested Facts follow same rules as above,
 *          but they are also Categorized by the parent (its name and Categories as mentioned above).
 *          -Nested Paragraphs are always identified by a single Category and can have bullet points which are paired
 *          1:1 to the Category itself and their parent (as there can be multiple Paragraphs identified the same).
 */
class QuestionGenerator @Inject constructor() {

    companion object {

        /** Minimum amount of related information in order to generate a question */
        private const val MINIMUM_RELATED_DATA_TO_GENERATE = 3

        /** Minimum amount of related items from other lists for generating a question for a list */
        private const val MINIMUM_RELATED_ITEMS_TO_GENERATE_LIST = 2

        /** Maximum amount of related items from other lists for generating a question for a list */
        private const val MAXIMUM_RELATED_ITEMS_TO_GENERATE_LIST = 3

        /** identification of a parent for its efficient sorting */
        private const val I_AM_PARENT_IDENTIFIER = "I_AM_PARENT_IDENTIFIER"
    }

    /**
     * Generates Questions from Units
     * @param excludedList list of UIDs excluded from generating
     */
    suspend fun generateQuestions(
        context: Context,
        units: List<UnitIO>,
        allUnits: List<UnitIO>,
        excludedList: List<String> = listOf()
    ): BaseResponse<List<QuestionIO>> {
        return withContext(Dispatchers.Default) {

            val questions = mutableListOf<QuestionIO>()
            val paragraphs = mutableListOf<ParagraphToGenerate>()
            val facts = mutableListOf<FactToGenerate>()

            // 1. Subject with the bullet points - 1:1, only if there are any
            // note: paragraphs:subject 1:1 don't work
            // 2. Paragraphs with their bullet points 1:1
            // 3. Paragraphs + Subject (name) with nested paragraphs and facts, just initial info - associating
            // 4. Add all parent categories to facts and paragraphs - list. Looking for similarities will bounce from number of ? (differences?)
            //          1 category to 1 category is highest match, 2 to 2 is the same, 1 to 2 is lower, 0 to 2 shouldn't be matched

            units.filter {
                excludedList.contains(it.uid).not()
            }.forEach { unit ->
                // facts within units
                unit.facts.filter {
                    excludedList.contains(it.uid).not()
                            && (it.isSeriousDataPoint() || it.facts.isNotEmpty())
                }.forEach { iteratedFact ->
                    facts.add(
                        FactToGenerate(
                            data = iteratedFact,
                            parentUnitUid = unit.uid,
                            sortedNames = listOf(),
                            sortedParentUid = listOf(unit.uid),
                            parentParagraph = ParagraphIO(name = unit.name, uid = unit.uid)
                        )
                    )
                    iteratedFact.facts.filter {
                        excludedList.contains(it.uid).not()
                    }.forEach { nestedFact ->
                        facts.add(
                            FactToGenerate(
                                data = nestedFact,
                                parentUnitUid = unit.uid,
                                sortedNames = listOf(iteratedFact.shortKeyInformation),
                                sortedParentUid = listOf(unit.uid).plus(iteratedFact.uid),
                                parentParagraph = ParagraphIO(name = unit.name, uid = unit.uid),
                                parentFact = iteratedFact
                            )
                        )
                    }
                }

                // Questions within units
                if(units.size > MINIMUM_RELATED_DATA_TO_GENERATE) {
                    UnitGeneratingGoal.values().forEach { goal ->
                        generateSubjectQuestion(
                            unit = unit,
                            units = allUnits,
                            generatingGoal = goal,
                            context = context
                        )?.let { nameQuestion ->
                            questions.add(nameQuestion)
                        }
                    }
                }

                // iterates further into all depths
                suspend fun iterateFurther(
                    paragraph: ParagraphIO,
                    parentParagraph: ParagraphIO?,
                    parentNames: List<String>,
                    parentUidList: List<String>,
                ) {
                    withContext(Dispatchers.Default) {

                        if(paragraph.name.isNotBlank()) {
                            paragraphs.add(
                                ParagraphToGenerate(
                                    data = paragraph,
                                    parentParagraph = parentParagraph,
                                    parentUnitUid = unit.uid,
                                    sortedNames = parentNames,
                                    parentUidList
                                )
                            )
                        }
                        paragraph.facts.filter {
                            excludedList.contains(it.uid).not()
                                    && (it.isSeriousDataPoint() || it.facts.isNotEmpty())
                        }.forEach { iteratedFact ->
                            facts.add(
                                FactToGenerate(
                                    data = iteratedFact,
                                    parentUnitUid = unit.uid,
                                    sortedNames = if(iteratedFact.facts.isNotEmpty()) {
                                        // parent facts should be grouped together by this "category"
                                        parentNames.plus(I_AM_PARENT_IDENTIFIER)
                                    }else parentNames,
                                    sortedParentUid = parentUidList,
                                    parentParagraph = paragraph
                                )
                            )
                            iteratedFact.facts.filter {
                                excludedList.contains(it.uid).not()
                            }.forEach { nestedFact ->
                                facts.add(
                                    FactToGenerate(
                                        data = nestedFact,
                                        parentUnitUid = unit.uid,
                                        sortedNames = parentNames.plus(iteratedFact.shortKeyInformation),
                                        sortedParentUid = parentUidList.plus(iteratedFact.uid),
                                        parentParagraph = paragraph,
                                        parentFact = iteratedFact
                                    )
                                )
                            }
                        }

                        paragraph.paragraphs.filter {
                            excludedList.contains(it.uid).not()
                        }.forEach { iteratedParagraph ->
                            iterateFurther(
                                parentParagraph = paragraph,
                                paragraph = iteratedParagraph,
                                parentNames = parentNames.toMutableList().apply {
                                    if(iteratedParagraph.name.isNotBlank()) {
                                        add(iteratedParagraph.name)
                                    }
                                },
                                parentUidList = parentUidList.toMutableList().apply {
                                    add(iteratedParagraph.uid)
                                }
                            )
                        }
                    }
                }

                unit.paragraphs.filter {
                    excludedList.contains(it.uid).not()
                }.forEach { paragraph ->
                    iterateFurther(
                        paragraph = paragraph,
                        parentParagraph = null,
                        parentNames = listOf(paragraph.name),
                        parentUidList = listOf(paragraph.uid)
                    )
                }
            }
            if(facts.size > MINIMUM_RELATED_DATA_TO_GENERATE) {
                FactGeneratingGoal.values().forEach { goal ->
                    questions.addAll(
                        generateFactQuestion(
                            context = context,
                            facts = facts,
                            generatingGoal = goal,
                        )
                    )
                }
            }

            // paragraphs turned into categories and no longer serve as a source of information
            /*if(paragraphs.size > MINIMUM_RELATED_DATA_TO_GENERATE) {
                paragraphs.filter { it.data.name.isNotBlank() }.forEach { iteratedParagraph ->
                    ParagraphGeneratingGoal.values().forEach { goal ->
                        questions.addAll(
                            generateParagraphQuestion(
                                paragraph = iteratedParagraph,
                                allParagraphs = paragraphs,
                                generatingGoal = goal,
                                context = context
                            ).orEmpty()
                        )
                    }
                }
            }*/

            BaseResponse(
                data = questions,
                responseCode = if(questions.size == 0) 204 else 200
            )
        }
    }


    //================================== FACTS AS A SOURCE =========================================

    /**
     * Generates a question from a fact with the most related facts
     * Facts are never really indexed, just layered, cannot be connected on index
     */
    private suspend fun generateFactQuestion(
        context: Context,
        facts: List<FactToGenerate>,
        generatingGoal: FactGeneratingGoal
    ): List<QuestionIO> {
        return withContext(Dispatchers.Default) {
            val questions = mutableListOf<QuestionIO>()
            val map = hashMapOf<FactType, MutableList<FactToGenerate>>()
            val leftovers = mutableListOf<FactToGenerate>()

            facts.filter {
                when(generatingGoal) {
                    FactGeneratingGoal.SHORT_INFORMATION,
                    FactGeneratingGoal.LONG_INFORMATION -> it.data.hasTextData()
                    FactGeneratingGoal.IMAGE_PROMPT -> it.data.promptImage != null
                    FactGeneratingGoal.NESTED_FACTS_LONG_KEY,
                    FactGeneratingGoal.NESTED_FACTS_SHORT_KEY -> it.data.facts.isNotEmpty()
                } && (it.data.type.isListType.not()
                        || it.data.textList.isNotEmpty()
                        || generatingGoal == FactGeneratingGoal.NESTED_FACTS_LONG_KEY
                        || generatingGoal == FactGeneratingGoal.NESTED_FACTS_SHORT_KEY)
            }.forEach { toGenerate ->
                if(map.containsKey(toGenerate.data.type)) {
                    map[toGenerate.data.type]?.add(toGenerate)
                }else map[toGenerate.data.type] = mutableListOf(toGenerate)
            }

            map.forEach { chunk ->
                if(chunk.value.size + facts.size >= MINIMUM_RELATED_DATA_TO_GENERATE) {
                    chunk.value.forEach { iteratedFact ->
                        val relatedFacts = chunk.value.plus(facts)
                            .filter {
                                it.data.uid != iteratedFact.data.uid
                                        && it.data.isSeriousDataPoint()
                            }
                            .shuffled()
                            .map { fact ->
                                fact to calculateWeights(
                                    anchorList = iteratedFact.sortedNames,
                                    currentList = fact.sortedNames
                                )
                            }
                            // first we sort by type, as that the priority, then by similarities
                            .sortedWith(compareByDescending<Pair<FactToGenerate, Int>> {
                                if(it.first.data.type == iteratedFact.data.type) 1 else 0
                            }.thenByDescending { it.second })
                            .distinctBy { it.first.data.uid }
                            .take(if(generatingGoal == FactGeneratingGoal.NESTED_FACTS_LONG_KEY
                                || generatingGoal == FactGeneratingGoal.NESTED_FACTS_SHORT_KEY) {
                                MINIMUM_RELATED_DATA_TO_GENERATE * 2
                            }else MINIMUM_RELATED_DATA_TO_GENERATE)

                        if(relatedFacts.isNotEmpty()) {
                            questions.add(
                                generateQuestionFinal(
                                    context = context,
                                    promptFact = iteratedFact,
                                    relatedFacts = relatedFacts.map { it.first },
                                    generatingGoal = generatingGoal
                                )
                            )
                        }
                    }
                }else {
                    leftovers.addAll(chunk.value)
                }
            }

            if(leftovers.size >= MINIMUM_RELATED_DATA_TO_GENERATE) {
                leftovers.forEach { iteratedFact ->
                    val otherFacts = leftovers.filter {
                        it.data.uid != iteratedFact.data.uid
                                /*&& (generatingGoal.isParent.not()
                                || it.sortedCategoryUid.lastOrNull() != iteratedFact.sortedCategoryUid.lastOrNull())*/
                    }
                    val sameType = otherFacts.filter { it.data.type == iteratedFact.data.type }
                    val relatedFacts = if(sameType.size >= MINIMUM_RELATED_DATA_TO_GENERATE) {
                        sameType.distinctBy { it.data.uid }
                    }else sameType.plus(
                        otherFacts.filter { it.data.type != iteratedFact.data.type }
                            .distinctBy { it.data.uid }
                            .shuffled()
                            .take(MINIMUM_RELATED_DATA_TO_GENERATE.minus(sameType.size))
                    )

                    if(relatedFacts.isNotEmpty()
                        && (iteratedFact.data.type.isListType.not()
                                || iteratedFact.data.textList.isNotEmpty())
                        && (generatingGoal != FactGeneratingGoal.IMAGE_PROMPT
                                || iteratedFact.data.promptImage != null)
                    ) {
                        questions.add(
                            generateQuestionFinal(
                                context = context,
                                promptFact = iteratedFact,
                                relatedFacts = relatedFacts,
                                generatingGoal = generatingGoal
                            )
                        )
                    }
                }
            }

            questions
        }
    }

    /** Final step in generating question */
    private suspend fun generateQuestionFinal(
        context: Context,
        promptFact: FactToGenerate,
        relatedFacts: List<FactToGenerate>,
        generatingGoal: FactGeneratingGoal
    ): QuestionIO {
        val importedSource = promptFact.makeImportedSourceRoute(generatingGoal)

        // list is different in that we try to list all items together with other options
        return when {
            generatingGoal == FactGeneratingGoal.NESTED_FACTS_SHORT_KEY
                    || generatingGoal == FactGeneratingGoal.NESTED_FACTS_LONG_KEY -> {
                val incorrectFacts = relatedFacts
                    .filter {
                        it.parentFact?.uid != promptFact.data.uid
                                && it.data.isSeriousDataPoint()
                                && it.data.shortKeyInformation.lowercase() != promptFact.data.shortKeyInformation.lowercase()
                                && promptFact.data.facts.none { i -> i.uid == it.data.uid }
                    }
                    .take((MINIMUM_RELATED_ITEMS_TO_GENERATE_LIST..MAXIMUM_RELATED_ITEMS_TO_GENERATE_LIST).random())

                QuestionIO(
                    answers = incorrectFacts.map { mappingItem ->
                        QuestionAnswerIO(
                            text = if(generatingGoal == FactGeneratingGoal.NESTED_FACTS_LONG_KEY) {
                                mappingItem.data.longInformation
                            }else mappingItem.data.shortKeyInformation,
                            explanationMessage = mappingItem.data.shortKeyInformation,
                            isCorrect = false,
                            textList = if(generatingGoal == FactGeneratingGoal.NESTED_FACTS_LONG_KEY) {
                                mappingItem.data.textList
                            } else emptyList(),
                            importedSource = mappingItem.makeImportedSourceRoute(null)
                        )
                    }.toMutableList().apply {
                        // we add the correct answer
                        addAll(
                            promptFact.data.facts.map { mapped ->
                                QuestionAnswerIO(
                                    text = if(generatingGoal == FactGeneratingGoal.NESTED_FACTS_LONG_KEY) {
                                        mapped.longInformation
                                    }else mapped.shortKeyInformation,
                                    isCorrect = true,
                                    explanationMessage = if(generatingGoal == FactGeneratingGoal.NESTED_FACTS_LONG_KEY) {
                                        mapped.shortKeyInformation
                                    }else mapped.longInformation,
                                    textList = if(generatingGoal == FactGeneratingGoal.NESTED_FACTS_LONG_KEY) {
                                        mapped.textList
                                    } else emptyList()
                                )
                            }
                        )
                    },
                    importedSource = importedSource,
                    prompt = context.getString(
                        R.string.question_generating_fact_nested,
                        promptFact.data.shortKeyInformation,
                        promptFact.parentParagraph.name
                    )
                )
            }
            promptFact.data.type == FactType.LIST -> {
                if(generatingGoal == FactGeneratingGoal.SHORT_INFORMATION) {
                    // [Pair.first] - item, [Pair.second] - fact short key information
                    val relatedItems = relatedFacts
                        .take((MINIMUM_RELATED_ITEMS_TO_GENERATE_LIST..MAXIMUM_RELATED_ITEMS_TO_GENERATE_LIST).random())

                    QuestionIO(
                        answers = relatedItems.map { mappingItem ->
                            QuestionAnswerIO(
                                text = mappingItem.data.textList
                                    // no duplicate items
                                    .filter { filteredItem ->
                                        promptFact.data.textList.none {
                                            it.equals(filteredItem, true)
                                        }
                                    }
                                    .random()
                                    .ifBlank {
                                        mappingItem.data.longInformation
                                    },
                                explanationMessage = mappingItem.data.shortKeyInformation,
                                isCorrect = false,
                                importedSource = mappingItem.makeImportedSourceRoute(null)
                            )
                        }.toMutableList().apply {
                            // we add the correct answer
                            addAll(
                                promptFact.data.textList.map { mappingItem ->
                                    QuestionAnswerIO(
                                        text = mappingItem,
                                        isCorrect = true
                                    )
                                }
                            )
                        },
                        importedSource = importedSource,
                        prompt = context.getString(
                            R.string.question_generating_fact_list,
                            promptFact.data.shortKeyInformation,
                            promptFact.parentFact?.shortKeyInformation ?: promptFact.parentParagraph.name
                        )
                    )
                }else {
                    QuestionIO(
                        answers = relatedFacts.map { mappingFact ->
                            QuestionAnswerIO(
                                text = "${mappingFact.data.shortKeyInformation} (${mappingFact.parentParagraph.name})",
                                explanationMessage = mappingFact.data.longInformation,
                                imageExplanation = mappingFact.data.promptImage,
                                explanationList = mappingFact.data.textList,
                                isCorrect = false,
                                importedSource = mappingFact.makeImportedSourceRoute(null)
                            )
                        }.toMutableList().apply {
                            // we add the correct answer
                            add(
                                QuestionAnswerIO(
                                    text = "${promptFact.data.shortKeyInformation} (${
                                        promptFact.parentFact?.shortKeyInformation ?: promptFact.parentParagraph.name
                                    })",
                                    isCorrect = true
                                )
                            )
                        },
                        importedSource = importedSource,
                        promptList = promptFact.data.textList,
                        prompt = context.getString(R.string.question_generating_fact_list_short_key)
                    )
                }
            }
            else -> {
                QuestionIO(
                    answers = relatedFacts.map { mappingFact ->
                        val shortKeyInformation = "${mappingFact.data.shortKeyInformation} (${
                            promptFact.parentFact?.shortKeyInformation ?: promptFact.parentParagraph.name
                        })"

                        QuestionAnswerIO(
                            textList = if(generatingGoal == FactGeneratingGoal.SHORT_INFORMATION
                                && mappingFact.data.type.isListType
                            ) {
                                mappingFact.data.textList
                            }else listOf(),
                            text = when(generatingGoal) {
                                FactGeneratingGoal.SHORT_INFORMATION -> {
                                    if(mappingFact.data.type.isListType) "" else mappingFact.data.longInformation
                                }
                                else -> shortKeyInformation
                            },
                            isCorrect = false,
                            explanationMessage = when(generatingGoal) {
                                FactGeneratingGoal.SHORT_INFORMATION -> shortKeyInformation
                                else -> mappingFact.data.longInformation
                            },
                            explanationList = mappingFact.data.textList,
                            imageExplanation = mappingFact.data.promptImage,
                            importedSource = mappingFact.makeImportedSourceRoute(null)
                        )
                    }.toMutableList().apply {
                        val shortKeyInformation = "${promptFact.data.shortKeyInformation} (${
                            promptFact.parentFact?.shortKeyInformation ?: promptFact.parentParagraph.name
                        })"

                        // we add the correct answer
                        add(
                            QuestionAnswerIO(
                                textList = if(generatingGoal == FactGeneratingGoal.SHORT_INFORMATION){
                                    promptFact.data.textList
                                }else listOf(),
                                text = when(generatingGoal) {
                                    FactGeneratingGoal.SHORT_INFORMATION -> promptFact.data.longInformation
                                    else -> shortKeyInformation
                                },
                                isCorrect = true
                            )
                        )
                    },
                    imagePromptUrl = if(generatingGoal == FactGeneratingGoal.IMAGE_PROMPT) {
                        promptFact.data.promptImage
                    }else null,
                    importedSource = importedSource,
                    prompt = when(generatingGoal) {
                        FactGeneratingGoal.IMAGE_PROMPT -> context.getString(R.string.question_generating_fact_image)
                        FactGeneratingGoal.SHORT_INFORMATION -> {
                            context.getString(
                                R.string.question_generating_fact_short,
                                promptFact.data.shortKeyInformation,
                                promptFact.parentFact?.shortKeyInformation ?: promptFact.parentParagraph.name
                            )
                        }
                        FactGeneratingGoal.LONG_INFORMATION -> {
                            if(promptFact.data.type.isListType) {
                                context.getString(R.string.question_generating_bulletin_points)
                            }else context.getString(
                                R.string.question_generating_fact_long,
                                promptFact.data.longInformation,
                                promptFact.parentFact?.shortKeyInformation ?: promptFact.parentParagraph.name
                            )
                        }
                        else -> "" //shouldn't happen
                    },
                    promptList = if(generatingGoal == FactGeneratingGoal.LONG_INFORMATION) {
                        promptFact.data.textList
                    }else listOf()
                )
            }
        }
    }

    //================================= SUBJECT AS A SOURCE ========================================

    /** Generates a question for specific Subject */
    private suspend fun generateSubjectQuestion(
        unit: UnitIO,
        units: List<UnitIO>,
        generatingGoal: UnitGeneratingGoal,
        context: Context
    ): QuestionIO? {
        return withContext(Dispatchers.Default) {
            if(unit.isSeriousDataPoint()) {
                // we find related subjects to mislead question, there may be none,
                // in which case we pick unrelated ones
                val subjectForUse = units
                    .filter { filterSubject ->
                        filterSubject.uid != unit.uid && filterSubject.isSeriousDataPoint()
                    }

                // if there are less than minimum related subjects, we use other relatedness
                if(subjectForUse.size < MINIMUM_RELATED_DATA_TO_GENERATE) {
                    // index in the field
                    val subjectsByIndex = units.sortedBy { sortedSubject ->
                        kotlin.math.abs(
                            units.indexOf(sortedSubject).minus(units.indexOf(unit))
                        )
                    }
                    // if there are any category matches, we want to use them
                    subjectForUse
                        .plus(subjectsByIndex)
                        .take(MINIMUM_RELATED_DATA_TO_GENERATE)
                }else {
                    subjectForUse.take(MINIMUM_RELATED_DATA_TO_GENERATE)
                }.let { subjectForGenerating ->
                    QuestionIO(
                        answers = subjectForGenerating.map { mappingSubject ->
                            if(generatingGoal == UnitGeneratingGoal.NAME) {
                                QuestionAnswerIO(
                                    textList = mappingSubject.bulletPoints,
                                    isCorrect = false,
                                    explanationMessage = mappingSubject.name,
                                    importedSource = ImportedSource(
                                        sourceUid = mappingSubject.uid,
                                        type = ImportSourceType.UNIT
                                    )
                                )
                            }else QuestionAnswerIO(
                                text = mappingSubject.name,
                                isCorrect = false,
                                explanationList = mappingSubject.bulletPoints,
                                importedSource = ImportedSource(
                                    sourceUid = mappingSubject.uid,
                                    type = ImportSourceType.UNIT
                                )
                            )
                        }.toMutableList().apply {
                            // we add the correct answer
                            add(
                                if(generatingGoal == UnitGeneratingGoal.NAME) {
                                    QuestionAnswerIO(textList = unit.bulletPoints, isCorrect = true)
                                }else QuestionAnswerIO(text = unit.name, isCorrect = true)
                            )
                        },
                        importedSource = ImportedSource(
                            type = ImportSourceType.UNIT,
                            sourceUid = unit.uid
                        ),
                        prompt = if(generatingGoal == UnitGeneratingGoal.NAME) {
                            context.getString(R.string.question_generating_bulletin_name, unit.name)
                        }else context.getString(R.string.question_generating_bulletin_points),
                        promptList = if(generatingGoal == UnitGeneratingGoal.BULLET_POINTS) {
                            unit.bulletPoints
                        }else listOf()
                    )
                }
            }else null
        }
    }

    /** Calculates weights of a [currentList] based on similarity to a [anchorList] */
    private fun calculateWeights(
        anchorList: List<Any>,
        currentList: List<Any>
    ): Int {
        return currentList.sumOf { value ->
            val anchorIndex = anchorList.lastIndexOf(value)
            val currentIndex = currentList.lastIndexOf(value)
            val anchorPercent = anchorIndex.toDouble().div(anchorList.size.toDouble())
            val currentPercent = currentIndex.toDouble().div(currentList.size.toDouble())

            val difference = kotlin.math.abs(
                anchorList.size.minus(anchorIndex)
                    .minus(currentList.size.minus(currentIndex))
            )

            if(anchorIndex != -1 && currentIndex != -1) {
                if(difference == 0 && anchorIndex == anchorList.lastIndex) 300
                else (anchorList.size
                    .plus(currentList.size)
                    .minus(difference))
                    .toDouble()
                    .times(1.0 + if(anchorPercent >= 0.5) anchorPercent else 0.0)
                    .times(1.0 + if(currentPercent >= 0.5) currentPercent else 0.0)
                    .toInt()
            }else 0
        }
    }

    /** What is the goal data by which we ask the question - what will be a prompt */
    enum class UnitGeneratingGoal {
        NAME,
        BULLET_POINTS
    }

    /** What is the goal data by which we ask the question - what will be a prompt */
    enum class FactGeneratingGoal {
        /** Prompt is a short information */
        SHORT_INFORMATION,

        /** Prompt is an image */
        IMAGE_PROMPT,

        /** prompts the nested fact with shortKeyInformation */
        NESTED_FACTS_LONG_KEY,

        /** prompts the nested fact with longKeyInformation */
        NESTED_FACTS_SHORT_KEY,

        /** Prompt is a long information */
        LONG_INFORMATION;
    }

    private data class FactToGenerate(
        val data: FactIO,
        val parentParagraph: ParagraphIO,
        val parentFact: FactIO? = null,
        val parentUnitUid: String,
        val sortedNames: List<String>,
        val sortedParentUid: List<String>,
    ) {

        /** Creates imported source route from this paragraph */
        fun makeImportedSourceRoute(generatingGoal: FactGeneratingGoal?): ImportedSource {
            var currentImportedSource = ImportedSource(
                sourceUid = parentUnitUid,
                type = ImportSourceType.UNIT
            )
            sortedParentUid.forEach { parentUid ->
                val newImportedSource = ImportedSource(
                    sourceUid = parentUid,
                    type = ImportSourceType.PARAGRAPH,
                    parent = currentImportedSource
                )
                currentImportedSource = newImportedSource
            }

            return ImportedSource(
                sourceUid = data.uid,
                type = ImportSourceType.FACT,
                parent = currentImportedSource,
                reason = generatingGoal?.name
            )
        }
    }

    /**
     * Mainly for generating the bullet-point:category name questions
     */
    private data class ParagraphToGenerate(
        val data: ParagraphIO,
        val parentParagraph: ParagraphIO?,
        val parentUnitUid: String,
        val sortedNames: List<String>,
        val sortedParentUid: List<String>
    ) {

        /** Creates imported source route from this paragraph */
        fun makeImportedSourceRoute(): ImportedSource {
            var currentImportedSource = ImportedSource(
                sourceUid = parentUnitUid,
                type = ImportSourceType.UNIT
            )

            sortedParentUid.forEach { parentUid ->
                val newImportedSource = ImportedSource(
                    sourceUid = parentUid,
                    type = ImportSourceType.PARAGRAPH,
                    parent = currentImportedSource
                )
                currentImportedSource = newImportedSource
            }

            return currentImportedSource
        }
    }
}

/** converts a string to SHA256 */
fun convertToSha256(input: String): String {
    val md = MessageDigest.getInstance("SHA-256")
    return Base64
        .getEncoder()
        .encodeToString(md.digest(input.toByteArray()))
}