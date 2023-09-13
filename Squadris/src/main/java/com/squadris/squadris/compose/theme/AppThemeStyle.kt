package com.squadris.squadris.compose.theme

import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/** Styles specific to main app theme [AppTheme] */
class AppThemeStyle: ThemeStyle {
    override val textFieldColors: TextFieldColors
        @Composable get() {
            return TextFieldDefaults.colors(
                focusedContainerColor = AppTheme.colors.onBackgroundComponentContrast,
                unfocusedContainerColor = AppTheme.colors.onBackgroundComponentContrast,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                disabledTextColor = AppTheme.colors.disabled,
                focusedTextColor = AppTheme.colors.primary,
                unfocusedTextColor = AppTheme.colors.secondary,
                cursorColor = AppTheme.colors.secondary,
                disabledIndicatorColor = Color.Transparent,
                errorContainerColor = AppTheme.colors.onBackgroundComponentContrast,
                errorIndicatorColor = Color.Transparent,
                errorTextColor = Colors.RED_ERROR,
                errorTrailingIconColor = Colors.RED_ERROR
            )
        }

    override val checkBoxColorsDefault: CheckboxColors
        @Composable get() = CheckboxColors(
            checkedCheckmarkColor = AppTheme.colors.primary,
            uncheckedCheckmarkColor = AppTheme.colors.secondary,
            checkedBoxColor = Color.Transparent,
            uncheckedBoxColor = Color.Transparent,
            checkedBorderColor = AppTheme.colors.brandMain,
            uncheckedBorderColor = AppTheme.colors.brandMain,
            disabledUncheckedBoxColor = Color.Transparent,
            disabledCheckedBoxColor = Color.Transparent,
            disabledBorderColor = AppTheme.colors.disabled,
            disabledIndeterminateBorderColor = AppTheme.colors.disabled,
            disabledIndeterminateBoxColor = Color.Transparent,
            disabledUncheckedBorderColor = AppTheme.colors.brandMain
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
}