package com.squadris.squadris.compose.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.squadris.squadris.compose.theme.DefaultValues.defaultBaseColors
import com.squadris.squadris.compose.theme.DefaultValues.defaultThemeIcons

interface BaseTheme {

    /** base set of colors based on configurations */
    @get:Composable
    val colors: BaseColors

    /** base styles of components */
    val styles: ThemeStyle

    /** base icons specific to an app */
    @get:Composable
    val icons: ThemeIcons

    /** base shapes specific to an app */
    val shapes: ThemeShapes
}

private object DefaultValues {
    val defaultThemeIcons = object: ThemeIcons {
        override val googleSignUp: Int = -1
    }
    val defaultBaseColors = object: BaseColors {
        override val primary: Color = Color(0x00000000)
        override val secondary: Color = Color(0x00000000)
        override val contrastAction: Color = Color(0x00000000)
        override val contrastActionLight: Color = Color(0x00000000)
        override val disabled: Color = Color(0x00000000)
        override val brandMain: Color = Color(0x00000000)
        override val brandMainDark: Color = Color(0x00000000)
        override val tetrial: Color = Color(0x00000000)
        override val backgroundLight: Color = Color(0x00000000)
        override val onBackGroundLight: Color = Color(0x00000000)
        override val onBackgroundComponentContrast: Color = Color(0x00000000)
        override val onBackgroundComponent: Color = Color(0x00000000)
        override val shimmer: Color = Color(0x00000000)
        override val overShimmer: Color = Color(0x00000000)
    }
}

/** current set of colors */
val LocalAppColors = staticCompositionLocalOf {
    defaultBaseColors
}

/** current set of colors */
val LocalAppIcons = staticCompositionLocalOf {
    defaultThemeIcons
}

/** current set of colors */
val LocalTheme = staticCompositionLocalOf<BaseTheme> {
    object: BaseTheme {
        override val colors: BaseColors
            @Composable
            get() = defaultBaseColors

        override val styles: ThemeStyle = object: ThemeStyle {
            override val componentElevation: Dp
                get() = 0.dp
            override val actionElevation: Dp
                get() = 0.dp
            override val minimumElevation: Dp
                get() = 0.dp

            override val textFieldColors: TextFieldColors
                @Composable
                get() = OutlinedTextFieldDefaults.colors()
            override val textFieldColorsOnFocus: TextFieldColors
                @Composable
                get() = OutlinedTextFieldDefaults.colors()
            override val checkBoxColorsDefault: CheckboxColors
                @Composable
                get() = CheckboxDefaults.colors()
            override val switchColorsDefault: SwitchColors
                @Composable
                get() = SwitchDefaults.colors()
            override val cardClickableElevation: CardElevation
                @Composable
                get() = CardDefaults.cardElevation()
            override val chipBorderDefault: BorderStroke
                @Composable
                get() = FilterChipDefaults.filterChipBorder(
                    borderColor = Color.Transparent,
                    selectedBorderColor = Color.Transparent,
                    disabledBorderColor = Color.Transparent,
                    disabledSelectedBorderColor = Color.Transparent,
                    borderWidth = 0.dp,
                    selectedBorderWidth = 0.dp,
                    enabled = true,
                    selected = false
                )
            override val chipColorsDefault: SelectableChipColors
                @Composable
                get() = FilterChipDefaults.filterChipColors()
            override val heading: TextStyle
                @Composable
                get() = TextStyle.Default
            override val subheading: TextStyle
                @Composable
                get() = TextStyle.Default
            override val category: TextStyle
                @Composable
                get() = TextStyle.Default
            override val title: TextStyle
                @Composable
                get() = TextStyle.Default
            override val content: TextStyle
                @Composable
                get() = TextStyle.Default
            override val linkText: TextStyle
                @Composable
                get() = TextStyle.Default
            override val menuItem: TextStyle
                @Composable
                get() = TextStyle.Default
        }

        override val icons: ThemeIcons
            @Composable
            get() = defaultThemeIcons

        override val shapes: ThemeShapes = object: ThemeShapes {
            override val circularActionShape: Shape
                get() = RectangleShape
            override val rectangularActionShape: Shape
                get() = RectangleShape
            override val componentShape: Shape
                get() = RectangleShape
            override val chipShape: Shape
                get() = RectangleShape
            override val roundedComponentShape: Shape
                get() = RectangleShape
            override val componentCornerRadius: Dp
                get() = 0.dp
            override val iconSizeSmall: Dp
                get() = 0.dp
            override val iconSizeMedium: Dp
                get() = 0.dp
            override val betweenItemsSpace: Dp
                get() = 0.dp
            override val iconSizeLarge: Dp
                get() = 0.dp
        }
    }
}