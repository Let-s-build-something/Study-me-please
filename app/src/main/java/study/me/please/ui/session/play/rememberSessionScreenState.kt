package study.me.please.ui.session.play

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import study.me.please.data.io.preferences.SessionPreferencePack

/**
 * remembers state of session screen and controls it
 * @param requestSave called whenever there is a request for data save
 */
@Composable
fun rememberSessionScreenState(
    module: QuestionModule,
    isTest: Boolean,
    sessionPreferencePack: MutableState<SessionPreferencePack>,
    requestSave: (QuestionModule) -> Unit
): SessionScreenState {
    val scope = rememberCoroutineScope()
    val state = remember(scope) {
        SessionScreenState(
            module = module,
            isTest = isTest,
            sessionPreferencePack = sessionPreferencePack,
            requestSave = {
                requestSave(module)
            }
        )
    }
    return state
}