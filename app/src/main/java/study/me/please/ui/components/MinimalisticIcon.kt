package study.me.please.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.squadris.squadris.compose.theme.LocalTheme

/**
 * Clickable basic Icon with vector image with minimalistic size
 */
@Composable
fun MinimalisticIcon(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    tint: Color = LocalTheme.colors.primary,
    contentDescription: String? = null,
    onClick: (() -> Unit)? = null
) {
    Icon(
        modifier = Modifier
            .size(34.dp)
            .clip(CircleShape)
            .then(if(onClick != null) {
                modifier.clickable(
                    indication = rememberRipple(bounded = false),
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = onClick
                )
            }else modifier)
            .padding(5.dp),
        imageVector = imageVector,
        contentDescription = contentDescription,
        tint = tint
    )
}