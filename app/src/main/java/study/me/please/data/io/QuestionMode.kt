package study.me.please.data.io

/**
 * Types of question modes
 */
enum class QuestionMode {
    /** fast-pace repeating of questions */
    PRACTICING,
    /** perfecting timing, test format and number of mistakes/correct answers */
    TEST,
    /** shows description and image before answering and then repeats the same without it */
    LEARNING,
}