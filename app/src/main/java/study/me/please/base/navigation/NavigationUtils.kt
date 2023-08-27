package study.me.please.base.navigation

import androidx.navigation.NavController
import study.me.please.base.navigation.NavigationComponent.COLLECTION_DETAIL_NAME
import study.me.please.base.navigation.NavigationComponent.COLLECTION_DETAIL_UID
import study.me.please.base.navigation.NavigationComponent.putNavigationArgument

object NavigationUtils {
    fun navigateToCollectionDetail(
        navController: NavController,
        name: String,
        uid: String? = null
    ) {
        navController.navigate(
            NavigationDestination.COLLECTION_DETAIL.route
                .putNavigationArgument(COLLECTION_DETAIL_NAME, name)
                .apply {
                    if(uid != null) {
                        putNavigationArgument(COLLECTION_DETAIL_UID, uid)
                    }
                }
        )
    }
}