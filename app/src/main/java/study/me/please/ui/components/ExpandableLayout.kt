package study.me.please.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.components.chips.DEFAULT_ANIMATION_LENGTH_SHORT
import com.squadris.squadris.compose.theme.LocalTheme

/** Content that can be hidden below a line button */
@Composable
fun ExpandableContent(
    modifier: Modifier = Modifier,
    text: AnnotatedString = AnnotatedString(""),
    containerColor: Color = LocalTheme.current.colors.onBackgroundComponent,
    contentColor: Color = LocalTheme.current.colors.secondary,
    textStyle: TextStyle = LocalTheme.current.styles.menuItem,
    isExpanded: Boolean = false,
    collapsedPadding: Dp = 0.dp,
    arrowModifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    collapsedContent: (@Composable () -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    val arrowDegreeRotation = remember { Animatable(90f) }
    LaunchedEffect(isExpanded) {
        arrowDegreeRotation.animateTo(
            if(isExpanded) 270f else 90f,
            animationSpec = tween(DEFAULT_ANIMATION_LENGTH_SHORT)
        )
    }

    Column(
        modifier = modifier.animateContentSize()
    ) {
        LineButton(
            modifier = Modifier.padding(collapsedPadding),
            containerColor = containerColor,
            contentColor = contentColor,
            textStyle = textStyle,
            arrowModifier = arrowModifier.graphicsLayer {
                rotationZ = arrowDegreeRotation.value
            },
            shape = shape,
            collapsedContent = collapsedContent,
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
    text: AnnotatedString,
    arrowModifier: Modifier = Modifier,
    arrowRotation: Float = 180f,
    textStyle: TextStyle = LocalTheme.current.styles.linkText,
    shape: Shape = RectangleShape,
    collapsedContent: (@Composable () -> Unit)? = null,
    containerColor: Color = LocalTheme.current.colors.onBackgroundComponent,
    contentColor: Color = LocalTheme.current.colors.secondary
) {
    Row(
        modifier = Modifier
            .clip(shape)
            .background(
                color = containerColor,
                shape = shape
            )
            .fillMaxWidth()
            .padding(horizontal = 6.dp, vertical = 4.dp)
            .then(modifier),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(end = 16.dp)
                .weight(1f)
        ) {
            if(collapsedContent != null) {
                collapsedContent()
            }else {
                Text(
                    text = text,
                    style = textStyle.copy(color = contentColor)
                )
            }
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
            text = AnnotatedString(
                "Click me to expand XYZasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdafgwsegdrthfth"
            ),
            containerColor = LocalTheme.current.colors.brandMainDark,
            contentColor = LocalTheme.current.colors.tetrial
        ) {
            Text(
                modifier = Modifier.height(400.dp),
                text = AnnotatedString("BLABLABLABLA"),
                fontSize = 28.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}