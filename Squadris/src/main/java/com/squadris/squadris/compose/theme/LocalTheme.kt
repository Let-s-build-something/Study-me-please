package com.squadris.squadris.compose.theme

import androidx.compose.runtime.Composable

/** Main theme with current colors and styles */
object LocalTheme {

    /** base set of colors based on configurations */
    val colors: BaseColors
        @Composable
        get() = LocalAppColors.current

    /** base styles for the main app theme [LocalTheme] */
    val styles: ThemeStyle = AppThemeStyle()

    /** base icons for the main app theme [LocalTheme] */
    val icons: ThemeIcons
        @Composable
        get() = LocalAppIcons.current

    /** base shapes for the main app theme [LocalTheme] */
    val shapes: AppThemeShapes = AppThemeShapes()
}