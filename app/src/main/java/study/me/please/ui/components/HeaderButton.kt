package study.me.please.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.theme.LocalTheme
import study.me.please.R

/**
 * Item displaying collection and shortened information about it
 * @param text text content
 */
@Composable
private fun HeaderButton(
    modifier: Modifier = Modifier,
    text: String = "",
    contentColor: Color,
    containerColor: Color,
    startIconVector: ImageVector? = Icons.Outlined.Add,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        contentPadding = PaddingValues(
            vertical = 6.dp,
            horizontal = 10.dp
        ),
        shape = LocalTheme.shapes.circularActionShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = LocalTheme.colors.disabled,
            disabledContentColor = LocalTheme.colors.secondary
        ),
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = LocalTheme.styles.actionElevation
        )
    ) {
        if(startIconVector != null) {
            Icon(
                startIconVector,
                contentDescription = stringResource(id = R.string.add_new_content_description),
                tint = contentColor,
                modifier = Modifier
                    .size(24.dp)
            )
        }
        if(text.isNotEmpty()) {
            Text(
                modifier = Modifier
                    .padding(end = 4.dp),
                text = text,
                fontSize = 16.sp,
                color = contentColor,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

/**
 * Item displaying collection and shortened information about it
 * @param text text content
 */
@Preview
@Composable
fun ComponentHeaderButton(
    modifier: Modifier = Modifier,
    text: String = "",
    startIconVector: ImageVector? = Icons.Outlined.Add,
    onClick: () -> Unit = {}
) {
    HeaderButton(
        modifier = modifier,
        text = text,
        onClick = onClick,
        startIconVector = startIconVector,
        contentColor = LocalTheme.colors.secondary,
        containerColor = LocalTheme.colors.onBackgroundComponent
    )
}

/**
 * Item displaying collection and shortened information about it
 * @param text text content
 */
@Preview
@Composable
fun BrandHeaderButton(
    modifier: Modifier = Modifier,
    text: String = "",
    onClick: () -> Unit = {}
) {
    HeaderButton(
        modifier = modifier
            .padding(bottom = 12.dp, top = 4.dp),
        text = text,
        onClick = onClick,
        contentColor = LocalTheme.colors.tetrial,
        containerColor = LocalTheme.colors.brandMain
    )
}