package com.squadris.squadris.compose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.theme.Colors
import com.squadris.squadris.compose.theme.LocalTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleChip(
    modifier: Modifier = Modifier,
    text: String,
    selected: Boolean = false,
    imageVector: ImageVector? = null,
    onClick: () -> Unit
) {
    val localDensity = LocalDensity.current
    FilterChip(
        modifier = modifier
            .height(with(localDensity) { 32.sp.toDp() }),
        shape = LocalTheme.shapes.chipShape,
        selected = selected,
        onClick = onClick,
        label = {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if(imageVector != null) {
                    Icon(
                        modifier = Modifier.size(18.dp),
                        imageVector = imageVector,
                        tint = if(selected) LocalTheme.colors.tetrial else LocalTheme.colors.brandMain,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                }
                if(text.isNotEmpty()) {
                    Text(
                        text = text,
                        fontSize = 14.sp
                    )
                }
            }
        },
        trailingIcon = {
            if(selected) {
                Icon(
                    modifier = Modifier
                        .size(18.dp),
                    imageVector = Icons.Outlined.Close,
                    tint = LocalTheme.colors.tetrial,
                    contentDescription = "Uncheck filter" //TODO string resources
                )
            }
        },
        colors = LocalTheme.styles.chipColorsDefault,
        border = LocalTheme.styles.chipBorderDefault
    )
}