package study.me.please.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.components.DEFAULT_ANIMATION_LENGTH_SHORT
import com.squadris.squadris.compose.theme.LocalTheme

/** Content that can be hidden below a line button */
@Composable
fun ExpandableContent(
    modifier: Modifier = Modifier,
    text: String,
    containerColor: Color = LocalTheme.colors.onBackgroundComponent,
    contentColor: Color = LocalTheme.colors.secondary,
    defaultValue: Boolean = false,
    onExpansionChange: (isExpanded: Boolean) -> Unit = {},
    collapsedContent: (@Composable RowScope.() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    var isExpanded by rememberSaveable { mutableStateOf(defaultValue) }
    val arrowDegreeRotation = remember { Animatable(90f) }
    LaunchedEffect(isExpanded) {
        arrowDegreeRotation.animateTo(
            if(isExpanded) 270f else 90f,
            animationSpec = tween(DEFAULT_ANIMATION_LENGTH_SHORT)
        )
        onExpansionChange(isExpanded)
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize()
    ) {
        LineButton(
            containerColor = containerColor,
            contentColor = contentColor,
            arrowModifier = Modifier.graphicsLayer {
                rotationZ = arrowDegreeRotation.value
            },
            collapsedContent = collapsedContent,
            onClick = {
                isExpanded = isExpanded.not()
            },
            text = text
        )
        if(isExpanded) {
            content()
        }
    }
}

/**
 * Horizontal button with icon for display of functionality the button has and text on the left side
 */
@Composable
fun LineButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    arrowModifier: Modifier = Modifier,
    onClick: () -> Unit,
    arrowRotation: Float = 180f,
    collapsedContent: (@Composable RowScope.() -> Unit)? = null,
    containerColor: Color = LocalTheme.colors.onBackgroundComponent,
    contentColor: Color = LocalTheme.colors.secondary
) {
    Row(
        modifier = modifier
            .background(containerColor)
            .fillMaxWidth()
            .clickable(
                enabled = enabled,
                indication = rememberRipple(bounded = true),
                interactionSource = remember { MutableInteractionSource() },
                onClick = onClick
            )
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if(collapsedContent != null) {
            collapsedContent()
        }else {
            Text(
                text = text,
                style = TextStyle(
                    color = contentColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            )
        }
        Icon(
            modifier = arrowModifier
                .size(18.dp)
                .rotate(arrowRotation),
            imageVector = Icons.Outlined.ArrowBackIosNew,
            contentDescription = null,
            tint = contentColor
        )
    }
}

@Preview
@Composable
private fun Preview() {
    Column {
        ExpandableContent(
            text = "Click me to expand XYZ",
            containerColor = LocalTheme.colors.brandMainDark,
            contentColor = LocalTheme.colors.tetrial
        ) {
            Text(
                modifier = Modifier.height(400.dp),
                text = "BLABLABLABLA",
                fontSize = 28.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}