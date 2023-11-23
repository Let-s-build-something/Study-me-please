package study.me.please.base.navigation

import androidx.navigation.NavBackStackEntry
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

/** Helper object for Jetpack Compose navigation component  */
object NavigationComponent {

    /** collection identifier */
    const val COLLECTION_UID = "collectionUid"

    /** question identifier list split by a comma */
    const val QUESTION_UID_LIST = "questionUidList"

    /** collection identifier list split by a comma */
    const val COLLECTION_UID_LIST = "collectionUidList"

    /** argument identifier for a question */
    const val QUESTION_UID = "questionUid"

    /** argument identifier for a session */
    const val SESSION_UID = "sessionUid"

    /** argument identifier for a testing mode flag */
    const val IS_TESTING_MODE = "isTestingMode"

    /** toolbar title */
    const val TOOLBAR_TITLE = "toolbarTitle"

    /** whether new item should be create the moment screen opens */
    const val CREATE_NEW_ITEM = "createNewItem"

    /** Returns parsed argument */
    fun NavBackStackEntry.getArgument(identifier: String): String? {
        val rawValue = arguments?.getString(identifier)
        return if(rawValue == "") ""
        else if(rawValue != null) URLDecoder.decode(rawValue, StandardCharsets.UTF_8)
        else null
    }
}