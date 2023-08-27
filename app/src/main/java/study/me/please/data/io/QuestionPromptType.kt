package study.me.please.data.io

/**
 * Types of questions
 */
enum class QuestionPromptType {
    /** One question, multiple possible options or single option only */
    TEXT_QUESTION,
    DRAG_TO_FILL,
    SHUFFLED_TEXT,
    AUDIO
}