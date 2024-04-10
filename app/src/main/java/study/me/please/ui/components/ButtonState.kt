package study.me.please.ui.components

data class ButtonState(
    val text: String,
    val enabled: Boolean = true,
    val onClick: () -> Unit = {}
)