package study.me.please.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope

/** remembers the current state */
@Composable
fun rememberInteractiveCardState(
    mode: MutableState<InteractiveCardMode> = mutableStateOf(InteractiveCardMode.DATA_DISPLAY),
    isChecked: MutableState<Boolean> = mutableStateOf(false),
    onCheckedChange: ((Boolean) -> Unit) = {}
): InteractiveCardState {
    val scope = rememberCoroutineScope()
    val state = remember(scope) {
        InteractiveCardState(
            mode = mode,
            isChecked = isChecked,
            onCheckedChange = onCheckedChange
        )
    }
    return state
}