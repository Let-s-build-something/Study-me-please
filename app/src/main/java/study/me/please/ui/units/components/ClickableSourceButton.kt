package study.me.please.ui.units.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.ext.scalingClickable

/** Button that is visually the same as [DragAndDropSourceButton] but is simply for clicks */
@Composable
fun ClickableSourceButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    imageVector: ImageVector,
    contentDescription: String
) {
    Box(
        modifier = modifier
            .scalingClickable(
                scaleInto = 0.85f,
                onTap = {
                    onClick()
                }
            )
            .shadow(
                elevation = LocalTheme.styles.actionElevation,
                shape = FloatingActionButtonDefaults.shape
            )
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = LocalTheme.colors.tetrial,
                    shape = FloatingActionButtonDefaults.shape
                )
            ,
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier
                    .size(56.dp)
                    .padding(12.dp),
                imageVector = imageVector,
                tint = LocalTheme.colors.brandMainDark,
                contentDescription = contentDescription
            )
        }
    }
}