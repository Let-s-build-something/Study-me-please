package study.me.please.data.io

import java.util.UUID

data class PsychologyTerm (

    /** Question prompt for user */
    val prompt: String = "",

    /** Text description answer for the prompt */
    val textAnswer: String = "",

    /** Image description answer for the prompt */
    val imageAnswerUrl: String = "",

    /** List of options that can be answered */
    val answers: List<PsychologyTermAnswer> = listOf(),

    /** Number of question from workbook */
    val questionNumber: Int = -1,

    /** Specific category this question is part of */
    val categoryId: String = "",

    /** Index of the correct answer */
    val correctAnswer: Int = -1,

    /** whether this prompt is repeated for the sake of remembering */
    var isRepeated: Boolean = false,

    /** unique identifier */
    val uid: String = UUID.randomUUID().toString(),
)