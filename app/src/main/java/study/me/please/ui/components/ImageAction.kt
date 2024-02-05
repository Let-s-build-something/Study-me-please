package study.me.please.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForwardIos
import androidx.compose.material.icons.outlined.Dashboard
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.elevatedButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.theme.LocalTheme

/** Simple action with image and maximum two line text */
@Composable
fun ImageAction(
    modifier: Modifier = Modifier,
    text: String? = null,
    leadingImageVector: ImageVector? = null,
    trailingImageVector: ImageVector? = null,
    onTrailingIconClick: (() -> Unit)? = null,
    containerColor: Color = LocalTheme.colors.brandMain,
    contentColor: Color = LocalTheme.colors.tetrial,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick,  
        contentPadding = PaddingValues(
            vertical = 0.dp,
            horizontal = 12.dp
        ),
        shape = LocalTheme.shapes.circularActionShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = LocalTheme.colors.disabled,
            disabledContentColor = LocalTheme.colors.secondary
        ),
        elevation = elevatedButtonElevation()
    ) {
        leadingImageVector?.let { icon ->
            Icon(
                modifier = Modifier.size(ButtonDefaults.IconSize),
                imageVector = icon,
                contentDescription = null
            )
        }
        if(text != null) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                text = text,
                color = LocalTheme.colors.tetrial,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        trailingImageVector?.let { icon ->
            Icon(
                modifier = Modifier
                    .size(ButtonDefaults.IconSize)
                    .clip(CircleShape)
                    .then(if(onTrailingIconClick != null) {
                        Modifier.clickable(
                            indication = rememberRipple(bounded = false),
                            interactionSource = remember { MutableInteractionSource() },
                            onClick = onTrailingIconClick
                        )
                    }else Modifier),
                imageVector = icon,
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    ImageAction(
        text = "This is my long action, but actually very long",
        leadingImageVector = Icons.Outlined.Dashboard,
        trailingImageVector = Icons.AutoMirrored.Outlined.ArrowForwardIos,
    ) {

    }
}