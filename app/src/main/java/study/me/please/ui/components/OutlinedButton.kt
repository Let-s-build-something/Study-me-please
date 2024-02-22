package study.me.please.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.theme.LocalTheme

/**
 * Outlined text with transparent background
 */
@Composable
fun OutlinedButton(
    modifier: Modifier = Modifier,
    thenModifier: Modifier = Modifier,
    text: String? = null,
    isActivated: Boolean = true,
    enabled: Boolean = true,
    trailingIcon: ImageVector? = null,
    content: @Composable RowScope.(TextStyle) -> Unit = {},
    activeColor: Color = LocalTheme.colors.primary,
    inactiveColor: Color = LocalTheme.colors.secondary,
    onClick: () -> Unit
) {
    val color = if (isActivated && enabled) activeColor else inactiveColor
    Row(
        modifier = modifier
            .border(
                width = if (enabled) 1.dp else 0.dp,
                shape = LocalTheme.shapes.componentShape,
                color = color
            )
            .clip(LocalTheme.shapes.componentShape)
            .clickable(
                enabled = enabled,
                indication = rememberRipple(bounded = false),
                interactionSource = remember { MutableInteractionSource() },
                onClick = onClick
            )
            .padding(horizontal = 12.dp, vertical = 6.dp)
            .then(thenModifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val textStyle = TextStyle(
            color = color,
            fontSize = 14.sp
        )
        content(textStyle)
        if(text != null) {
            Text(
                modifier = Modifier.weight(1f, fill = false),
                text = text,
                style = textStyle
            )
        }
        trailingIcon?.let { icon ->
            Icon(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .requiredHeight(
                        with(LocalDensity.current) {
                            14.sp.toDp()
                        }
                    )
                    .requiredWidth(
                        with(LocalDensity.current) {
                            14.sp.toDp()
                        }
                    ),
                imageVector = icon,
                contentDescription = null,
                tint = color
            )
        }
    }
}

@Composable
@Preview
private fun Preview() {
    Row(
        modifier = Modifier
            .background(LocalTheme.colors.backgroundLight)
            .padding(16.dp)
    ) {
        val activated = true
        OutlinedButton(
            text = if(activated) "Activated" else "Inactivated",
            isActivated = activated,
            trailingIcon = if(activated) Icons.Outlined.Check else Icons.Outlined.Close,
            onClick = {},
            activeColor = LocalTheme.colors.disabled,
            inactiveColor = LocalTheme.colors.secondary,
        )
    }
}