package study.me.please.ui.home

import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.MutableStateFlow
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.SessionIO
import javax.inject.Inject

/** Data storage */
@ActivityRetainedScoped
class HomeDataManager @Inject constructor() {

    /** response with list of latest X collections */
    var collections: MutableStateFlow<List<CollectionIO>?> = MutableStateFlow(null)

    /** response with list of latest X sessions */
    var sessions: MutableStateFlow<List<SessionIO>?> = MutableStateFlow(null)
}