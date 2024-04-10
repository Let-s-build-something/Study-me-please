package com.squadris.squadris.compose.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/** Styles specific to main app theme [LocalTheme] */
class AppThemeStyle: ThemeStyle {
    override val textFieldColors: TextFieldColors
        @Composable get() {
            return TextFieldDefaults.colors(
                focusedContainerColor = LocalTheme.colors.onBackgroundComponentContrast,
                unfocusedContainerColor = LocalTheme.colors.onBackgroundComponentContrast,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                disabledTextColor = LocalTheme.colors.disabled,
                focusedTextColor = LocalTheme.colors.primary,
                unfocusedTextColor = LocalTheme.colors.secondary,
                cursorColor = LocalTheme.colors.secondary,
                disabledIndicatorColor = Color.Transparent,
                errorContainerColor = LocalTheme.colors.onBackgroundComponentContrast,
                errorIndicatorColor = Color.Transparent,
                errorTextColor = Colors.RED_ERROR,
                errorTrailingIconColor = Colors.RED_ERROR
            )
        }

    override val textFieldColorsOnFocus: TextFieldColors
        @Composable get() {
            return TextFieldDefaults.colors(
                focusedContainerColor = LocalTheme.colors.onBackgroundComponentContrast,
                unfocusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedLabelColor = Color.Transparent,
                disabledTextColor = LocalTheme.colors.secondary,
                focusedTextColor = LocalTheme.colors.primary,
                unfocusedTextColor = LocalTheme.colors.secondary,
                cursorColor = LocalTheme.colors.secondary,
                disabledIndicatorColor = Color.Transparent,
                errorContainerColor = LocalTheme.colors.onBackgroundComponentContrast,
                errorIndicatorColor = Color.Transparent,
                errorTextColor = Colors.RED_ERROR,
                errorTrailingIconColor = Colors.RED_ERROR,
                disabledContainerColor = Color.Transparent,
                disabledLabelColor = Color.Transparent,
                disabledPrefixColor = LocalTheme.colors.secondary,
                disabledSuffixColor = LocalTheme.colors.secondary
            )
        }

    override val checkBoxColorsDefault: CheckboxColors
        @Composable get() = CheckboxColors(
            checkedCheckmarkColor = LocalTheme.colors.primary,
            uncheckedCheckmarkColor = LocalTheme.colors.secondary,
            checkedBoxColor = Color.Transparent,
            uncheckedBoxColor = Color.Transparent,
            checkedBorderColor = LocalTheme.colors.brandMain,
            uncheckedBorderColor = LocalTheme.colors.brandMain,
            disabledUncheckedBoxColor = Color.Transparent,
            disabledCheckedBoxColor = Color.Transparent,
            disabledBorderColor = LocalTheme.colors.disabled,
            disabledIndeterminateBorderColor = LocalTheme.colors.disabled,
            disabledIndeterminateBoxColor = Color.Transparent,
            disabledUncheckedBorderColor = LocalTheme.colors.disabled
        )

    override val switchColorsDefault: SwitchColors
        @Composable get() = SwitchDefaults.colors(
            checkedTrackColor = LocalTheme.colors.brandMain,
            checkedThumbColor = LocalTheme.colors.tetrial,
            uncheckedBorderColor = LocalTheme.colors.secondary,
            uncheckedThumbColor = LocalTheme.colors.secondary,
            uncheckedTrackColor = LocalTheme.colors.onBackgroundComponent
        )

    override val componentElevation: Dp = 6.dp
    override val actionElevation: Dp = 8.dp
    override val minimumElevation: Dp = 2.dp
    override val cardClickableElevation: CardElevation
        @Composable get() = CardDefaults.cardElevation(
            defaultElevation = componentElevation,
            pressedElevation = minimumElevation,
            draggedElevation = actionElevation,
            focusedElevation = minimumElevation,
            hoveredElevation = minimumElevation,
            disabledElevation = minimumElevation
        )

    override val chipBorderDefault: BorderStroke
        @Composable get() = FilterChipDefaults.filterChipBorder(
            borderColor = Color.Transparent,
            selectedBorderColor = Color.Transparent,
            disabledBorderColor = Color.Transparent,
            disabledSelectedBorderColor = Color.Transparent,
            borderWidth = 0.dp,
            selectedBorderWidth = 0.dp,
            enabled = true,
            selected = false
        )

    @OptIn(ExperimentalMaterial3Api::class)
    override val chipColorsDefault: SelectableChipColors
        @Composable get() = FilterChipDefaults.filterChipColors(
            containerColor = LocalTheme.colors.tetrial,
            labelColor = LocalTheme.colors.brandMain,
            selectedContainerColor = LocalTheme.colors.brandMain,
            selectedLabelColor = LocalTheme.colors.tetrial
        )
    override val heading: TextStyle
        @Composable
        get() = TextStyle(
            color = LocalTheme.colors.primary,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

    override val subheading: TextStyle
        @Composable
        get() = TextStyle(
            color = LocalTheme.colors.primary,
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium
        )

    override val category: TextStyle
        @Composable
        get() = TextStyle(
            color = LocalTheme.colors.secondary,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        )

    override val menuItem: TextStyle
        @Composable
        get() = TextStyle(
            color = LocalTheme.colors.brandMainDark,
            fontSize = 19.sp,
            fontWeight = FontWeight.Medium
        )

    override val linkText: TextStyle
        @Composable
        get() = TextStyle(
            color = LocalTheme.colors.brandMainDark,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
}