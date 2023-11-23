package study.me.please.base.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import study.me.please.R

/**
 * Type of a navigation icon
 */
enum class NavIconType {
    /** simple cross for closing a screen */
    CLOSE,

    /** arrow back to navigate back from the screen */
    BACK,

    /** icon of a home to navigate to home page */
    HOME,

    /** no navigation icon */
    NONE;

    /** ImageVector resource with content description for accessibility */
    val imageVector: Pair<ImageVector, String>?
        @Composable
        get() = when(this) {
            HOME -> Icons.Outlined.Home to stringResource(id = R.string.home_screen_title)
            CLOSE -> Icons.Outlined.Close to stringResource(id = R.string.navigate_close)
            BACK -> Icons.Outlined.ArrowBackIosNew to stringResource(id = R.string.navigate_back)
            else -> null
        }
}