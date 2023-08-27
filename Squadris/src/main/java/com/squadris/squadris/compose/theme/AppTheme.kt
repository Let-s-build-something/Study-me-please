package com.squadris.squadris.compose.theme

import androidx.compose.runtime.Composable

/** Main theme with current colors and styles */
object AppTheme {

    /** base set of colors based on configurations */
    val colors: BaseColors
        @Composable
        get() = LocalAppColors.current

    /** base styles for the main app theme [AppTheme] */
    val styles: ThemeStyle = AppThemeStyle()
}