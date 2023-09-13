package study.me.please.ui.components

/**
 * Type of modes this card can be in
 * @property DATA_DISPLAY regular information/data displaying card
 * @property OPTIONS multiple actions within the card itself
 * @property CHECKING checkbox is visible and we are choosing from global actions over multiple cards
 * @property EDIT changing data in the card
 */
enum class InteractiveCardMode {
    DATA_DISPLAY,
    OPTIONS,
    CHECKING,
    EDIT
}