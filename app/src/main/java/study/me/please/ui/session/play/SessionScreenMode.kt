package study.me.please.ui.session.play

/**
 * Modes of Session screen UI
 * @property REGULAR enabled question with possiblity to answer, is timed
 * @property LOCKED disabled question with no possibility to answer, is not timed
 */
enum class SessionScreenMode {
    REGULAR,
    LOCKED
}