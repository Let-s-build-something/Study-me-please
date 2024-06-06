package study.me.please.base.theme

import androidx.compose.runtime.Composable
import com.squadris.squadris.compose.theme.BaseColors
import com.squadris.squadris.compose.theme.BaseTheme
import com.squadris.squadris.compose.theme.LocalAppColors
import com.squadris.squadris.compose.theme.LocalAppIcons
import com.squadris.squadris.compose.theme.ThemeIcons
import com.squadris.squadris.compose.theme.ThemeStyle

/** Main theme with current colors and styles */
class StudyMeAppTheme: BaseTheme {

    /** base set of colors based on configurations */
    override val colors: BaseColors
        @Composable
        get() = LocalAppColors.current

    /** base styles for the main app theme [BaseTheme.current] */
    override val styles: ThemeStyle = AppThemeStyle()

    /** base icons for the main app theme [BaseTheme.current] */
    override val icons: ThemeIcons
        @Composable
        get() = LocalAppIcons.current

    /** base shapes for the main app theme [BaseTheme.current] */
    override val shapes: AppThemeShapes = AppThemeShapes()
}