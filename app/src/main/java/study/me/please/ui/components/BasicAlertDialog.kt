package study.me.please.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.squadris.squadris.compose.theme.LocalTheme
import study.me.please.ui.components.simple_dialog.dismissibleDialogProperties

/**
 * Themed basic dialog
 */
@Composable
fun BasicAlertDialog(
    title: String? = null,
    content: String,
    confirmButtonState: ButtonState? = null,
    dismissButtonState: ButtonState? = null,
    extraContent: @Composable (() -> Unit)? = null,
    properties: DialogProperties = dismissibleDialogProperties,
    onDismissRequest: () -> Unit,
    icon: ImageVector,
) {
    AlertDialog(
        icon = null,
        title = if(title == null) null else {
            {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = "",
                        tint = LocalTheme.colors.secondary
                    )
                    Text(
                        text = title,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium,
                            color = LocalTheme.colors.primary
                        )
                    )
                }
            }
        },
        text = {
            Column {
                Text(
                    text = content,
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = LocalTheme.colors.primary
                    )
                )
                extraContent?.invoke()
            }
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            if(confirmButtonState != null) {
                OutlinedButton(
                    text = confirmButtonState.text,
                    onClick = {
                        confirmButtonState.onClick()
                        onDismissRequest()
                    },
                    enabled = confirmButtonState.enabled,
                    activeColor = LocalTheme.colors.brandMain
                )
            }
        },
        dismissButton = if(dismissButtonState == null) null else {
            {
                OutlinedButton(
                    text = dismissButtonState.text,
                    onClick = {
                        dismissButtonState.onClick()
                        onDismissRequest()
                    },
                    enabled = dismissButtonState.enabled,
                    activeColor = LocalTheme.colors.secondary
                )
            }
        },
        containerColor = LocalTheme.colors.onBackgroundComponent,
        properties = properties
    )
}