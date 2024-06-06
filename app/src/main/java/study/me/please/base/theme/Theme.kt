package study.me.please.base.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.squadris.squadris.compose.theme.LocalAppColors
import com.squadris.squadris.compose.theme.LocalAppIcons
import com.squadris.squadris.compose.theme.LocalTheme

/** Main theme of this app */
@Composable
fun AppTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if(isDarkTheme) DarkAppColors else LightAppColors
    val icons = if(isDarkTheme) AppThemeIconsDark() else AppThemeIconsLight()

    CompositionLocalProvider(
        LocalAppColors provides colors,
        LocalAppIcons provides icons,
        LocalTheme provides StudyMeAppTheme(),
        content = content
    )
}