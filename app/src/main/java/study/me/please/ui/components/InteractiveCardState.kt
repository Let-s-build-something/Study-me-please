package study.me.please.ui.components

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

/** Base behaviour for an interactive card */
data class InteractiveCardState (
    var mode: MutableState<InteractiveCardMode> = mutableStateOf(InteractiveCardMode.DATA_DISPLAY),
    var isChecked: MutableState<Boolean> = mutableStateOf(false),
    val onCheckedChange: ((Boolean) -> Unit) = {}
)