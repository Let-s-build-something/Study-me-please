package study.me.please.ui.home

import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.MutableStateFlow
import study.me.please.data.io.BannersResponse
import javax.inject.Inject

/** Data storage */
@ActivityRetainedScoped
class HomeDataManager @Inject constructor() {

    /** response with list of banner slides */
    var bannersResponse: MutableStateFlow<BannersResponse?> = MutableStateFlow(null)
}