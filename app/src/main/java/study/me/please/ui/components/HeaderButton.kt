package study.me.please.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.compose.theme.SharedColors
import com.squadris.squadris.ext.scalingClickable
import study.me.please.R

/**
 * Item displaying collection and shortened information about it
 * @param text text content
 */
@Composable
private fun HeaderButton(
    modifier: Modifier = Modifier,
    text: String = "",
    enabled: Boolean = true,
    contentColor: Color,
    containerColor: Color,
    endIconVector: ImageVector? = Icons.Outlined.Add,
    extraContent: @Composable RowScope.() -> Unit = {},
    textStyle: TextStyle? = null,
    shape: Shape = LocalTheme.current.shapes.circularActionShape,
    onClick: () -> Unit = {}
) {
    val backgroundColor = animateColorAsState(
        targetValue = when {
            enabled.not() -> LocalTheme.current.colors.disabled
            else -> containerColor
        },
        label = ""
    )

    Row(
        modifier = modifier
            .scalingClickable(
                onTap = {
                    onClick()
                }
            )
            .background(
                color = backgroundColor.value,
                shape = shape
            )
            .padding(PaddingValues(vertical = 6.dp, horizontal = 10.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        if(text.isNotEmpty()) {
            Text(
                modifier = Modifier
                    .padding(end = 6.dp),
                text = text,
                style = textStyle ?: TextStyle(
                    fontSize = 16.sp,
                    color = contentColor,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        if(endIconVector != null) {
            Icon(
                endIconVector,
                contentDescription = stringResource(id = R.string.add_new_content_description),
                tint = contentColor,
                modifier = Modifier
                    .requiredSize(24.dp)
            )
        }
        extraContent()
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
    shape: Shape = LocalTheme.current.shapes.circularActionShape,
    textStyle: TextStyle? = null,
    startIconVector: ImageVector? = Icons.Outlined.Add,
    extraContent: @Composable RowScope.() -> Unit = {},
    onClick: () -> Unit = {}
) {
    HeaderButton(
        modifier = modifier,
        text = text,
        shape = shape,
        onClick = onClick,
        textStyle = textStyle,
        extraContent = extraContent,
        endIconVector = startIconVector,
        contentColor = LocalTheme.current.colors.secondary,
        containerColor = LocalTheme.current.colors.onBackgroundComponent
    )
}

/**
 * Item displaying collection and shortened information about it
 * @param text text content
 */
@Preview
@Composable
fun ErrorHeaderButton(
    modifier: Modifier = Modifier,
    text: String = "",
    shape: Shape = LocalTheme.current.shapes.circularActionShape,
    textStyle: TextStyle? = null,
    startIconVector: ImageVector? = Icons.Outlined.Add,
    extraContent: @Composable RowScope.() -> Unit = {},
    onClick: () -> Unit = {}
) {
    HeaderButton(
        modifier = modifier,
        text = text,
        shape = shape,
        onClick = onClick,
        textStyle = textStyle,
        extraContent = extraContent,
        endIconVector = startIconVector,
        contentColor = LocalTheme.current.colors.contrastAction,
        containerColor = SharedColors.RED_ERROR
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
    startIconVector: ImageVector? = Icons.Outlined.Add,
    onClick: () -> Unit = {}
) {
    HeaderButton(
        modifier = modifier
            .padding(bottom = 12.dp, top = 4.dp),
        text = text,
        onClick = onClick,
        endIconVector = startIconVector,
        contentColor = LocalTheme.current.colors.tetrial,
        containerColor = LocalTheme.current.colors.brandMain
    )
}