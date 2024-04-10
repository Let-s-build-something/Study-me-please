package study.me.please.ui.collection

import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.MutableStateFlow
import study.me.please.data.io.CollectionIO
import javax.inject.Inject

/** Data storage */
@ActivityRetainedScoped
class CollectionDataManager @Inject constructor() {

    /** list of all collections saved locally */
    var collections: MutableStateFlow<List<CollectionIO>?> = MutableStateFlow(null)
}