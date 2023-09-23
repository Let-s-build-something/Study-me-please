package study.me.please.ui.session

/**
 * Modes of Session screen UI
 * @property REGULAR enabled question with possiblity to answer, is timed
 * @property LOCKED disabled question with no possibility to answer, is not timed
 * @property HISTORY simulation of [LOCKED] mode
 */
enum class SessionScreenMode {
    REGULAR,
    LOCKED,
    HISTORY
}