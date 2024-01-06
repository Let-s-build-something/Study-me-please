package study.me.please.ui.collection.detail.subjects

import android.app.Activity
import androidx.compose.ui.util.fastForEach
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
import study.me.please.data.io.subjects.CategoryIO
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.data.io.subjects.SubjectIO
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
        private const val MINIMUM_RELATED_DATA_TO_GENERATE = 3
    }

    /**
     * Generates Questions from Subjects
     * @param excludedList list of UIDs excluded from generating
     */
    suspend fun generateQuestions(
        activity: Activity,
        subjects: List<SubjectIO>,
        allSubject: List<SubjectIO>,
        excludedList: List<String>,
        categories: List<CategoryIO>
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

            subjects.filter {
                excludedList.contains(it.uid).not()
            }.forEach { subject ->
                // Questions within subjects
                if(subjects.size > MINIMUM_RELATED_DATA_TO_GENERATE) {
                    SubjectGeneratingGoal.values().forEach { goal ->
                        generateSubjectQuestion(
                            subject = subject,
                            subjects = allSubject,
                            generatingGoal = goal,
                            activity = activity
                        )?.let { nameQuestion ->
                            questions.add(nameQuestion)
                        }
                    }
                }

                // iterates further into all depths
                fun iterateFurther(paragraph: ParagraphIO, parentCategoryUid: List< String>) {
                    paragraphs.add(ParagraphToGenerate(
                        data = paragraph.apply {
                            localCategory = categories.find { category -> category.uid == this.categoryUid }
                        },
                        parentSubjectUid = subject.uid,
                        sortedCategoryUid = parentCategoryUid.plus(paragraph.uid)
                    ))
                    paragraph.facts.filter {
                        excludedList.contains(it.uid).not()
                    }.forEach { iteratedFact ->
                        facts.add(
                            FactToGenerate(
                                data = iteratedFact,
                                parentSubjectUid = subject.uid,
                                sortedCategoryUid = parentCategoryUid.plus(paragraph.uid)
                            )
                        )
                    }

                    paragraph.paragraphs.filter {
                        excludedList.contains(it.uid).not()
                    }.forEach { iteratedParagraph ->
                        iterateFurther(
                            paragraph = iteratedParagraph,
                            parentCategoryUid = parentCategoryUid.plus(iteratedParagraph.uid)
                        )
                    }
                }

                subject.paragraphs.filter {
                    excludedList.contains(it.uid).not()
                }.forEach { paragraph ->
                    iterateFurther(
                        paragraph = paragraph,
                        parentCategoryUid = listOf(paragraph.uid)
                    )
                }
            }

            if(facts.size > MINIMUM_RELATED_DATA_TO_GENERATE) {
                FactGeneratingGoal.values().forEach { goal ->
                    questions.addAll(
                        generateFactQuestion(
                            activity = activity,
                            facts = facts,
                            generatingGoal = goal,
                            subjects = allSubject,
                            paragraphs = paragraphs,
                            categories = categories
                        )
                    )
                }
            }
            if(paragraphs.size > MINIMUM_RELATED_DATA_TO_GENERATE) {
                paragraphs.filter { it.data.categoryUid != null }.forEach { iteratedParagraph ->
                    ParagraphGeneratingGoal.values().forEach { goal ->
                        questions.addAll(
                            generateParagraphQuestion(
                                paragraph = iteratedParagraph,
                                allParagraphs = paragraphs,
                                generatingGoal = goal,
                                activity = activity,
                                subjects = allSubject
                            ).orEmpty()
                        )
                    }
                }
            }

            BaseResponse(
                data = questions,
                errorCode = if(questions.size == 0) GeneratingQuestionErrorCode.NOT_ENOUGH_DATA.name else null
            )
        }
    }


    //================================== FACTS AS A SOURCE =========================================

    /**
     * Generates a question from a fact with the most related facts
     * Facts are never really indexed, just layered, cannot be connected on index
     */
    private suspend fun generateFactQuestion(
        activity: Activity,
        facts: List<FactToGenerate>,
        generatingGoal: FactGeneratingGoal,
        subjects: List<SubjectIO>,
        paragraphs: List<ParagraphToGenerate>,
        categories: List<CategoryIO>
    ): List<QuestionIO> {
        return withContext(Dispatchers.Default) {
            val questions = mutableListOf<QuestionIO>()
            val map = hashMapOf<FactType, MutableList<FactToGenerate>>()
            val leftovers = mutableListOf<FactToGenerate>()

            facts.forEach { toGenerate ->
                if(map.containsKey(toGenerate.data.type)) {
                    map[toGenerate.data.type]?.add(toGenerate)
                }else map[toGenerate.data.type] = mutableListOf(toGenerate)
            }
            map.forEach { chunk ->
                if(chunk.value.size >= MINIMUM_RELATED_DATA_TO_GENERATE) {
                    chunk.value.forEach { iteratedFact ->
                        val relatedFacts = chunk.value
                            .filter {
                                it.data.uid != iteratedFact.data.uid
                                        && (generatingGoal.isParent.not()
                                        || it.sortedCategoryUid.lastOrNull() != iteratedFact.sortedCategoryUid.lastOrNull())
                            }
                            .map { fact ->
                                fact to calculateWeights(
                                    anchorList = iteratedFact.sortedCategoryUid,
                                    currentList = fact.sortedCategoryUid
                                )
                            }
                            .sortedByDescending { it.second }
                            .take(MINIMUM_RELATED_DATA_TO_GENERATE)

                        if(relatedFacts.isNotEmpty()) {
                            questions.add(
                                generateQuestionFinal(
                                    activity = activity,
                                    promptFact = iteratedFact,
                                    facts = relatedFacts.map { it.first },
                                    generatingGoal = generatingGoal,
                                    allSubjects = subjects,
                                    allParagraphs = paragraphs,
                                    categories = categories
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
                                && (generatingGoal.isParent.not()
                                || it.sortedCategoryUid.lastOrNull() != iteratedFact.sortedCategoryUid.lastOrNull())
                    }
                    val sameType = otherFacts.filter { it.data.type == iteratedFact.data.type }
                    val relatedFacts = if(sameType.size >= MINIMUM_RELATED_DATA_TO_GENERATE) {
                        sameType
                    }else sameType.plus(
                        otherFacts.filter { it.data.type != iteratedFact.data.type }
                            .shuffled()
                            .take(MINIMUM_RELATED_DATA_TO_GENERATE.minus(sameType.size))
                    )

                    if(relatedFacts.isNotEmpty()) {
                        questions.add(
                            generateQuestionFinal(
                                activity = activity,
                                promptFact = iteratedFact,
                                facts = relatedFacts,
                                generatingGoal = generatingGoal,
                                allSubjects = subjects,
                                allParagraphs = paragraphs,
                                categories = categories
                            )
                        )
                    }
                }
            }

            questions
        }
    }

    /** Final step in generating question */
    private fun generateQuestionFinal(
        activity: Activity,
        promptFact: FactToGenerate,
        facts: List<FactToGenerate>,
        allSubjects: List<SubjectIO>,
        allParagraphs: List<ParagraphToGenerate>,
        generatingGoal: FactGeneratingGoal,
        categories: List<CategoryIO>
    ): QuestionIO {
        return QuestionIO(
            answers = facts.map { mappingFact ->
                QuestionAnswerIO(
                    textList = if(generatingGoal == FactGeneratingGoal.SHORT_INFORMATION
                        || generatingGoal == FactGeneratingGoal.SHORT_INFORMATION_PARENT_NAME_LONG
                    ) mappingFact.data.textList
                    else listOf(),
                    text = when(generatingGoal) {
                        FactGeneratingGoal.SHORT_INFORMATION_PARENT_NAME_LONG -> mappingFact.data.longInformation
                        FactGeneratingGoal.SHORT_INFORMATION_PARENT_NAME_SHORT -> mappingFact.data.shortKeyInformation
                        FactGeneratingGoal.SHORT_INFORMATION -> mappingFact.data.longInformation
                        FactGeneratingGoal.LONG_INFORMATION -> mappingFact.data.shortKeyInformation
                    },
                    isCorrect = false
                )
            }.toMutableList().apply {
                // we add the correct answer
                add(
                    QuestionAnswerIO(
                        textList = if(generatingGoal == FactGeneratingGoal.SHORT_INFORMATION
                            || generatingGoal == FactGeneratingGoal.SHORT_INFORMATION_PARENT_NAME_LONG
                        ) promptFact.data.textList
                        else listOf(),
                        text = when(generatingGoal) {
                            FactGeneratingGoal.SHORT_INFORMATION_PARENT_NAME_LONG -> promptFact.data.longInformation
                            FactGeneratingGoal.SHORT_INFORMATION_PARENT_NAME_SHORT -> promptFact.data.shortKeyInformation
                            FactGeneratingGoal.SHORT_INFORMATION -> promptFact.data.longInformation
                            FactGeneratingGoal.LONG_INFORMATION -> promptFact.data.shortKeyInformation
                        },
                        isCorrect = true
                    )
                )
            },
            importedSource = ImportedSource(
                type = ImportSourceType.FACT,
                sourceUid = promptFact.data.uid
            ),
            prompt = when(generatingGoal) {
                FactGeneratingGoal.SHORT_INFORMATION_PARENT_NAME_SHORT,
                FactGeneratingGoal.SHORT_INFORMATION_PARENT_NAME_LONG -> {
                    val previousCategory = if(promptFact.sortedCategoryUid.size > 1) {
                        categories.find { category ->
                            category.uid == allParagraphs.find {
                                it.data.uid == promptFact.sortedCategoryUid.getOrNull(
                                    promptFact.sortedCategoryUid.size.minus(2)
                                )
                            }?.data?.categoryUid
                        }
                    }else null
                    val category = categories.find { category ->
                        category.uid == allParagraphs.find { it.data.uid == promptFact.sortedCategoryUid.lastOrNull() }
                            ?.data?.categoryUid
                    }
                    val subject = allSubjects.find { it.uid == promptFact.parentSubjectUid }

                    activity.getString(
                        if(generatingGoal == FactGeneratingGoal.SHORT_INFORMATION_PARENT_NAME_LONG) {
                            R.string.question_generating_fact_parent_name_long
                        }else R.string.question_generating_fact_parent_name_short,
                        category?.name ?: "",
                        category?.uid ?: "",
                        subject?.name ?: "",
                        subject?.uid ?: "",
                        if(previousCategory != null) {
                            activity.getString(
                                R.string.question_generating_fact_parent_addition,
                                previousCategory.name,
                                previousCategory.uid
                            )
                        }else ""
                    )
                }
                FactGeneratingGoal.SHORT_INFORMATION -> {
                    activity.getString(
                        R.string.question_generating_fact_short,
                        promptFact.data.shortKeyInformation
                    )
                }
                FactGeneratingGoal.LONG_INFORMATION -> {
                    activity.getString(
                        R.string.question_generating_fact_long,
                        promptFact.data.longInformation
                    )
                }
            },
            promptList = if(generatingGoal == FactGeneratingGoal.LONG_INFORMATION) {
                promptFact.data.textList
            }else listOf()
        )
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
    private enum class FactGeneratingGoal {

        /** Short information together with name(s) of the parent(s) to further specify */
        SHORT_INFORMATION_PARENT_NAME_SHORT,

        /** Long information together with name(s) of the parent(s) to further specify */
        SHORT_INFORMATION_PARENT_NAME_LONG,

        /** list of facts under specific paragraph */
        SHORT_INFORMATION,
        /** list of paragraphs under specific paragraph */
        LONG_INFORMATION;

        /** Whether parent is centre of generating */
        val isParent: Boolean
            get() = this == SHORT_INFORMATION_PARENT_NAME_SHORT || this == SHORT_INFORMATION_PARENT_NAME_LONG
    }


    //================================ PARAGRAPH AS A SOURCE =======================================

    /**
     * Generates a question from a paragraph with the most related paragraphs
     * Facts are never really indexed, just layered, cannot be connected on index
     */
    private suspend fun generateParagraphQuestion(
        paragraph: ParagraphToGenerate,
        activity: Activity,
        subjects: List<SubjectIO>,
        allParagraphs: List<ParagraphToGenerate>,
        generatingGoal: ParagraphGeneratingGoal
    ): List<QuestionIO>? {
        return withContext(Dispatchers.Default) {
            when {
                // only paragraphs that act as a form of a "fact" - have some paragraphs
                generatingGoal == ParagraphGeneratingGoal.LIST_OF_CHILDREN_PARAGRAPHS
                        && paragraph.data.paragraphs.none { it.isSeriousDataPoint } -> {
                    return@withContext null
                }
                // we need correct answers
                generatingGoal == ParagraphGeneratingGoal.LIST_OF_CHILDREN_FACTS
                        && paragraph.data.facts.isEmpty() -> {
                    return@withContext null
                }
            }

            val relatedParagraphs = allParagraphs
                .filter {
                    it.data.uid != paragraph.data.uid
                }
                .map { paragraph ->
                    paragraph to calculateWeights(
                        anchorList = paragraph.sortedCategoryUid,
                        currentList = paragraph.sortedCategoryUid
                    )
                }
                .sortedByDescending { it.second }

            when(generatingGoal) {
                ParagraphGeneratingGoal.BULLET_POINTS_NAME -> {
                    if(paragraph.data.isSeriousDataPoint.not()) return@withContext null
                    val chosenParagraphs = relatedParagraphs
                        .filter {
                            it.first.data.isSeriousDataPoint
                                    && it.first.data.uid != paragraph.data.uid
                        }

                    if(chosenParagraphs.isEmpty()) return@withContext null

                    listOf(
                        QuestionIO(
                            answers = chosenParagraphs
                                .take(MINIMUM_RELATED_DATA_TO_GENERATE)
                                .map { relatedParagraph ->
                                    QuestionAnswerIO(
                                        isCorrect = false,
                                        textList = relatedParagraph.first.data.bulletPoints,
                                        explanationMessage = activity.getString(
                                            R.string.question_generating_explanation_paragraph,
                                            relatedParagraph.first.data.uid
                                        )
                                    )
                                }.toMutableList().apply {
                                    add(
                                        QuestionAnswerIO(
                                            isCorrect = true,
                                            textList = paragraph.data.bulletPoints,
                                            explanationMessage = activity.getString(
                                                R.string.question_generating_explanation_paragraph,
                                                paragraph.data.uid
                                            )
                                        )
                                    )
                                },
                            prompt = activity.getString(
                                R.string.question_generating_bulletin_name,
                                paragraph.data.localCategory?.name ?: ""
                            )
                        )
                    )
                }
                ParagraphGeneratingGoal.BULLET_POINTS_VALUES -> {
                    if(paragraph.data.isSeriousDataPoint.not()) return@withContext null
                    val chosenParagraphs = relatedParagraphs
                        .filter {
                            it.first.data.isSeriousDataPoint
                                    && it.first.data.uid != paragraph.data.uid
                        }

                    if(chosenParagraphs.isEmpty()) return@withContext null

                    listOf(
                        QuestionIO(
                            answers = chosenParagraphs
                                .take(MINIMUM_RELATED_DATA_TO_GENERATE)
                                .map { relatedParagraph ->
                                    QuestionAnswerIO(
                                        isCorrect = false,
                                        text = relatedParagraph.first.data.localCategory?.name ?: "",
                                        explanationMessage = activity.getString(
                                            R.string.question_generating_explanation_paragraph,
                                            relatedParagraph.first.data.uid
                                        )
                                    )
                                }.toMutableList().apply {
                                    add(
                                        QuestionAnswerIO(
                                            isCorrect = true,
                                            text = paragraph.data.localCategory?.name ?: "",
                                            explanationMessage = activity.getString(
                                                R.string.question_generating_explanation_paragraph,
                                                paragraph.data.uid
                                            )
                                        )
                                    )
                                },
                            prompt = activity.getString(R.string.question_generating_bulletin_points),
                            promptList = paragraph.data.bulletPoints
                        )
                    )
                }
                ParagraphGeneratingGoal.LIST_OF_CHILDREN_PARAGRAPHS -> {
                    val correctParagraphs = paragraph.data.paragraphs
                        .filter { it.isSeriousDataPoint }
                        .toMutableList()
                    val relatedChildrenParagraphs = relatedParagraphs
                        .filter { it.first.data.isSeriousDataPoint }
                        .filter { related -> correctParagraphs.none { it.uid == related.first.data.uid }  }
                        .take(correctParagraphs.size)
                        .flatMap { it.first.data.paragraphs }
                    // if there are no related paragraphs
                    if(relatedChildrenParagraphs.isEmpty()) return@withContext listOf()

                    val questions = mutableListOf<QuestionIO>()
                    val subject = subjects.find { it.uid == paragraph.parentSubjectUid }

                    while (correctParagraphs.size > 0) {
                        questions.add(
                            QuestionIO(
                                answers = relatedChildrenParagraphs
                                    .shuffled()
                                    .take(MINIMUM_RELATED_DATA_TO_GENERATE)
                                    .map { childrenParagraph ->
                                        QuestionAnswerIO(
                                            text = childrenParagraph.localCategory?.name ?: "",
                                            explanationMessage = activity.getString(
                                                R.string.question_generating_explanation_paragraph,
                                                childrenParagraph.uid
                                            ),
                                            isCorrect = false
                                        )
                                    }.toMutableList().apply {
                                    correctParagraphs.take(MINIMUM_RELATED_DATA_TO_GENERATE).forEach { correctParagraph ->
                                        correctParagraph.localCategory?.name?.let { name ->
                                            add(
                                                QuestionAnswerIO(
                                                    text = name,
                                                    explanationMessage = activity.getString(
                                                        R.string.question_generating_explanation_paragraph,
                                                        correctParagraph.uid
                                                    ),
                                                    isCorrect = true
                                                )
                                            )
                                        }
                                    }
                                },
                                prompt = activity.getString(
                                    R.string.question_generating_children_items,
                                    paragraph.data.localCategory?.name ?: "",
                                    paragraph.data.uid,
                                    subject?.name ?: "",
                                    subject?.uid ?: ""
                                )
                            )
                        )
                        repeat(MINIMUM_RELATED_DATA_TO_GENERATE) {
                            if(correctParagraphs.removeFirstOrNull() == null) return@withContext questions
                        }
                    }
                    questions
                }
                ParagraphGeneratingGoal.LIST_OF_CHILDREN_FACTS -> {
                    if(paragraph.data.localCategory == null) return@withContext null
                    val correctFacts = paragraph.data.facts.toMutableList()
                    val relatedFacts = relatedParagraphs
                        .flatMap { it.first.data.facts }
                        .filter { related -> correctFacts.none { it.uid == related.uid }  }
                        .take(correctFacts.size)
                    // if there are no related facts
                    if(relatedFacts.isEmpty()) return@withContext null

                    val questions = mutableListOf<QuestionIO>()
                    val subject = subjects.find { it.uid == paragraph.parentSubjectUid }

                    while (correctFacts.size > 0) {
                        QuestionIO(
                            answers = relatedFacts
                                .shuffled()
                                .take(MINIMUM_RELATED_DATA_TO_GENERATE)
                                .map { childrenFact ->
                                    QuestionAnswerIO(
                                        text = childrenFact.shortKeyInformation,
                                        explanationMessage = childrenFact.longInformation,
                                        imageExplanation = childrenFact.promptImage,
                                        isCorrect = false
                                    )
                                }.toMutableList().apply {
                                    correctFacts.take(MINIMUM_RELATED_DATA_TO_GENERATE).forEach { fact ->
                                        add(
                                            QuestionAnswerIO(
                                                text = fact.shortKeyInformation,
                                                explanationMessage = fact.longInformation,
                                                imageExplanation = fact.promptImage,
                                                isCorrect = true
                                            )
                                        )
                                    }
                                },
                            prompt = activity.getString(
                                R.string.question_generating_children_items,
                                paragraph.data.localCategory?.name ?: "",
                                paragraph.data.uid,
                                subject?.name ?: "",
                                subject?.uid ?: ""
                            )
                        )
                        repeat(MINIMUM_RELATED_DATA_TO_GENERATE) {
                            if(correctFacts.removeFirstOrNull() == null) return@withContext questions
                        }
                    }
                    questions
                }
            }.onEach {
                it.importedSource = ImportedSource(
                    type = ImportSourceType.PARAGRAPH,
                    sourceUid = paragraph.data.uid
                )
            }
        }
    }

    /** What is the goal data by which we ask the question - what will be a prompt */
    private enum class ParagraphGeneratingGoal {
        /** Name of a paragraph together with name(s) of the parent(s) to further specify */
        //NAME_PARENT_NAME,

        /** bullet points under specific paragraph */
        BULLET_POINTS_NAME,

        /** bullet points under specific paragraph */
        BULLET_POINTS_VALUES,

        /** list of paragraphs under specific paragraph */
        LIST_OF_CHILDREN_PARAGRAPHS,

        /** list of facts under specific paragraph */
        LIST_OF_CHILDREN_FACTS,
    }


    //================================= SUBJECT AS A SOURCE ========================================

    /** Generates a question for specific Subject */
    private suspend fun generateSubjectQuestion(
        subject: SubjectIO,
        subjects: List<SubjectIO>,
        generatingGoal: SubjectGeneratingGoal,
        activity: Activity
    ): QuestionIO? {
        return withContext(Dispatchers.Default) {
            if(subject.isSeriousDataPoint) {
                // we find related subjects to mislead question, there may be none,
                // in which case we pick unrelated ones
                val subjectForUse = subjects
                    .filter { filterSubject ->
                        filterSubject.uid != subject.uid && filterSubject.isSeriousDataPoint
                    }
                    .map {
                        // we give each a score by category matches
                        mapSubject -> mapSubject to mapSubject.categoryUids.count { subject.categoryUids.contains(it) }
                    }
                    // sort by score, highest first
                    .sortedByDescending { it.second }

                // if there are less than minimum related subjects, we use other relatedness
                if(subjectForUse.filter { it.second > 0 }.size < MINIMUM_RELATED_DATA_TO_GENERATE) {
                    // index in the field
                    val subjectsByIndex = subjects.sortedBy { sortedSubject ->
                        kotlin.math.abs(
                            subjects.indexOf(sortedSubject).minus(subjects.indexOf(subject))
                        )
                    }
                    // if there are any category matches, we want to use them
                    subjectForUse.filter { it.second > 0 }
                        .map { it.first }
                        .plus(subjectsByIndex)
                        .take(MINIMUM_RELATED_DATA_TO_GENERATE)
                }else {
                    subjectForUse.map { it.first }
                        .take(MINIMUM_RELATED_DATA_TO_GENERATE)
                }.let { subjectForGenerating ->
                    QuestionIO(
                        answers = subjectForGenerating.map { mappingSubject ->
                            if(generatingGoal == SubjectGeneratingGoal.NAME) {
                                QuestionAnswerIO(textList = mappingSubject.bulletPoints, isCorrect = false)
                            }else QuestionAnswerIO(text = mappingSubject.name, isCorrect = false)
                        }.toMutableList().apply {
                            // we add the correct answer
                            add(
                                if(generatingGoal == SubjectGeneratingGoal.NAME) {
                                    QuestionAnswerIO(textList = subject.bulletPoints, isCorrect = true)
                                }else QuestionAnswerIO(text = subject.name, isCorrect = true)
                            )
                        },
                        importedSource = ImportedSource(
                            type = ImportSourceType.PARAGRAPH,
                            sourceUid = subject.uid
                        ),
                        prompt = if(generatingGoal == SubjectGeneratingGoal.NAME) {
                            activity.getString(R.string.question_generating_bulletin_name, subject.name)
                        }else activity.getString(R.string.question_generating_bulletin_points),
                        promptList = if(generatingGoal == SubjectGeneratingGoal.BULLET_POINTS) {
                            subject.bulletPoints
                        }else listOf()
                    )
                }
            }else null
        }
    }

    /** What is the goal data by which we ask the question - what will be a prompt */
    private enum class SubjectGeneratingGoal {
        NAME,
        BULLET_POINTS
    }

    enum class GeneratingQuestionErrorCode {
        /** In case there is not enough data to generate any question */
        NOT_ENOUGH_DATA
    }

    private data class FactToGenerate(
        val data: FactIO,
        val parentSubjectUid: String,
        val sortedCategoryUid: List<String>
    )

    /**
     * Mainly for generating the bullet-point:category name questions
     */
    private data class ParagraphToGenerate(
        val data: ParagraphIO,
        val parentSubjectUid: String,
        val sortedCategoryUid: List<String>
    )
}