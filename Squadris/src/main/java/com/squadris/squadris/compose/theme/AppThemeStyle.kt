package com.squadris.squadris.compose.theme

import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

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
                cursorColor = AppTheme.colors.secondary
            )
        }
}