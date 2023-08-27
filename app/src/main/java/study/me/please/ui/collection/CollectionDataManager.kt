package study.me.please.ui.collection

import kotlinx.coroutines.flow.MutableStateFlow
import study.me.please.data.io.BannersResponse
import study.me.please.data.io.CollectionIO
import javax.inject.Inject

/** Data storage */
class CollectionDataManager @Inject constructor() {

    /** response with list of banner slides */
    var bannersResponse: MutableStateFlow<BannersResponse?> = MutableStateFlow(null)

    //TODO paginaton
    //TODO cloud backup
    /** list of all collections saved locally */
    var collections: MutableStateFlow<List<CollectionIO>?> = MutableStateFlow(null)
}