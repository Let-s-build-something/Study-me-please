package study.me.please.ui.session

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import study.me.please.data.io.preferences.SessionPreferencePack

/**
 * remembers state of session screen and controls it
 */
@Composable
fun rememberSessionScreenState(
    module: QuestionModule,
    isTest: Boolean,
    sessionPreferencePack: MutableState<SessionPreferencePack>
): SessionScreenState {
    val scope = rememberCoroutineScope()
    val state = remember(scope) {
        SessionScreenState(
            module = module,
            isTest = isTest,
            sessionPreferencePack = sessionPreferencePack
        )
    }
    return state
}