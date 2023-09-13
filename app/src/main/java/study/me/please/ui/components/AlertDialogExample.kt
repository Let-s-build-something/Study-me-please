package study.me.please.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun BasicAlertDialog(
    dialogTitle: String,
    dialogText: String,
    confirmButtonState: ButtonState? = null,
    dismissButtonState: ButtonState? = null,
    icon: ImageVector,
) {
    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "")
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            dismissButtonState?.onClick?.invoke()
        },
        confirmButton = {
            confirmButtonState?.let { btn ->
                TextButton(
                    onClick = {
                        btn.onClick()
                    },
                    enabled = btn.enabled
                ) {
                    Text(btn.text)
                }
            }
        },
        dismissButton = {
            dismissButtonState?.let { btn ->
                TextButton(
                    onClick = {
                        btn.onClick()
                    },
                    enabled = btn.enabled
                ) {
                    Text(btn.text)
                }
            }
        }
    )
}