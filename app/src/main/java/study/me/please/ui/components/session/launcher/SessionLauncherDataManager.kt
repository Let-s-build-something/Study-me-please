package study.me.please.ui.components.session.launcher

import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.MutableStateFlow
import study.me.please.data.io.session.SessionIO
import javax.inject.Inject

/** Data storage */
@ActivityRetainedScoped
class SessionLauncherDataManager @Inject constructor() {

    /** list of all sessions saved locally */
    var sessions: MutableStateFlow<List<SessionIO>?> = MutableStateFlow(null)
}