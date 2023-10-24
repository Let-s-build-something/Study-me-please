package com.squadris.squadris.compose.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.theme.LocalTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreChip(
    modifier: Modifier = Modifier,
    text: String,
    imageVector: ImageVector = Icons.Outlined.FilterList,
    onClick: () -> Unit = {}
) {
    val localDensity = LocalDensity.current
    FilterChip(
        modifier = modifier
            .padding(horizontal = 4.dp)
            .height(with(localDensity) { 32.sp.toDp() }),
        shape = LocalTheme.shapes.chipShape,
        selected = false,
        onClick = onClick,
        label = {
            Text(
                text = text,
                fontSize = 14.sp
            )
        },
        trailingIcon = {
            Icon(
                modifier = Modifier
                    .size(18.dp),
                imageVector = imageVector,
                tint = LocalTheme.colors.tetrial,
                contentDescription = "Sort" //TODO string resources
            )
        },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = LocalTheme.colors.brandMain,
            labelColor = LocalTheme.colors.tetrial,
            selectedContainerColor = LocalTheme.colors.brandMain,
            selectedLabelColor = LocalTheme.colors.tetrial
        ),
        border = LocalTheme.styles.chipBorderDefault
    )
}