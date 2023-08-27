package study.me.please.ui.home

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.BannersResponse
import javax.inject.Inject

/** Proxy for calling network end points */
class HomeRepository @Inject constructor(

) {

    /** Get list of all breeds */
    suspend fun getBanners(): BannersResponse? {
        return withContext(Dispatchers.IO) {
            //TODO firebase
            null
        }
    }
}