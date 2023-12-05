package study.me.please.data.io

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.North
import androidx.compose.material.icons.outlined.South
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Base class for sorting classes
 */
interface BasicSorter {
    /** Whether this sorting is descending or not */
    val isDescending: Boolean

    /** Returns an icon for indicating in which direction the sorting is */
    fun getDirectionIcon(): ImageVector {
        return if(isDescending) Icons.Outlined.South else Icons.Outlined.North
    }
}