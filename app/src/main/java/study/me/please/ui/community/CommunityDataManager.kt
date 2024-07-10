package study.me.please.ui.community

import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.MutableStateFlow
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.community.CollectionCategoryIO
import javax.inject.Inject

/** Data storage */
@ActivityRetainedScoped
class CommunityDataManager @Inject constructor() {

    /** response with list of latest X collections */
    val collections: MutableStateFlow<List<CollectionIO>?> = MutableStateFlow(null)

    /** list of all possible categories */
    val categories: MutableStateFlow<List<CollectionCategoryIO>?> = MutableStateFlow(null)

    /** current community filter */
    val filter = MutableStateFlow(CommunityDashboardFilter())
}