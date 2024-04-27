package com.squadris.squadris.compose.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

/** Main theme of this app */
@Composable
fun StudyMeAppTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if(isDarkTheme) DarkAppColors else LightAppColors
    val icons = if(isDarkTheme) AppThemeIconsDark() else AppThemeIconsLight()

    CompositionLocalProvider(
        LocalAppColors provides colors,
        LocalAppIcons provides icons,
        content = content
    )
}

/** current set of colors */
internal val LocalAppColors = staticCompositionLocalOf<BaseColors> {
    LightAppColors
}

/** current set of colors */
internal val LocalAppIcons = staticCompositionLocalOf<ThemeIcons> {
    AppThemeIconsLight()
}