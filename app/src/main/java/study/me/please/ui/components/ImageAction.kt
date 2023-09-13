package study.me.please.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Dashboard
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.elevatedButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.theme.AppTheme

/** Simple action with image and maximum two line text */
@Composable
fun ImageAction(
    modifier: Modifier = Modifier,
    text: String? = null,
    imageVector: ImageVector,
    containerColor: Color = AppTheme.colors.brandMain,
    contentColor: Color = AppTheme.colors.tetrial,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .widthIn(0.dp, 240.dp),
        onClick = onClick,  
        contentPadding = PaddingValues(
            vertical = 6.dp,
            horizontal = 12.dp
        ),
        shape = AppTheme.shapes.componentShape,
        colors = ButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = AppTheme.colors.disabled,
            disabledContentColor = AppTheme.colors.secondary
        ),
        elevation = elevatedButtonElevation()
    ) {
        Icon(
            modifier = Modifier.size(ButtonDefaults.IconSize),
            imageVector = imageVector,
            contentDescription = null
        )
        if(text != null) {
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = text,
                color = AppTheme.colors.tetrial,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    ImageAction(
        text = "This is my long action, but actually very long",
        imageVector = Icons.Outlined.Dashboard
    ) {

    }
}