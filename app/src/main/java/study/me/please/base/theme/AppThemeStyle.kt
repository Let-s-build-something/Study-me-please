package study.me.please.base.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CheckboxColors
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
import com.squadris.squadris.compose.theme.BaseTheme
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.compose.theme.SharedColors
import com.squadris.squadris.compose.theme.ThemeStyle

/** Styles specific to main app theme [BaseTheme.current] */
class AppThemeStyle: ThemeStyle {
    override val textFieldColors: TextFieldColors
        @Composable get() {
            return TextFieldDefaults.colors(
                focusedContainerColor = LocalTheme.current.colors.onBackgroundComponentContrast,
                unfocusedContainerColor = LocalTheme.current.colors.onBackgroundComponentContrast,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                disabledTextColor = LocalTheme.current.colors.disabled,
                focusedTextColor = LocalTheme.current.colors.primary,
                unfocusedTextColor = LocalTheme.current.colors.secondary,
                cursorColor = LocalTheme.current.colors.secondary,
                disabledIndicatorColor = Color.Transparent,
                errorContainerColor = LocalTheme.current.colors.onBackgroundComponentContrast,
                errorIndicatorColor = Color.Transparent,
                errorTextColor = SharedColors.RED_ERROR,
                errorTrailingIconColor = SharedColors.RED_ERROR
            )
        }

    override val textFieldColorsOnFocus: TextFieldColors
        @Composable get() {
            return TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedLabelColor = Color.Transparent,
                disabledTextColor = LocalTheme.current.colors.secondary,
                focusedTextColor = LocalTheme.current.colors.primary,
                unfocusedTextColor = LocalTheme.current.colors.secondary,
                cursorColor = LocalTheme.current.colors.secondary,
                disabledIndicatorColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                errorTextColor = SharedColors.RED_ERROR,
                errorTrailingIconColor = SharedColors.RED_ERROR,
                disabledContainerColor = Color.Transparent,
                disabledLabelColor = Color.Transparent,
                disabledPrefixColor = LocalTheme.current.colors.secondary,
                disabledSuffixColor = LocalTheme.current.colors.secondary
            )
        }

    override val checkBoxColorsDefault: CheckboxColors
        @Composable get() = CheckboxColors(
            checkedCheckmarkColor = LocalTheme.current.colors.primary,
            uncheckedCheckmarkColor = LocalTheme.current.colors.secondary,
            checkedBoxColor = Color.Transparent,
            uncheckedBoxColor = Color.Transparent,
            checkedBorderColor = LocalTheme.current.colors.brandMain,
            uncheckedBorderColor = LocalTheme.current.colors.brandMain,
            disabledUncheckedBoxColor = Color.Transparent,
            disabledCheckedBoxColor = Color.Transparent,
            disabledBorderColor = LocalTheme.current.colors.disabled,
            disabledIndeterminateBorderColor = LocalTheme.current.colors.disabled,
            disabledIndeterminateBoxColor = Color.Transparent,
            disabledUncheckedBorderColor = LocalTheme.current.colors.disabled
        )

    override val switchColorsDefault: SwitchColors
        @Composable get() = SwitchDefaults.colors(
            checkedTrackColor = LocalTheme.current.colors.brandMain,
            checkedThumbColor = LocalTheme.current.colors.tetrial,
            uncheckedBorderColor = LocalTheme.current.colors.secondary,
            uncheckedThumbColor = LocalTheme.current.colors.secondary,
            uncheckedTrackColor = LocalTheme.current.colors.onBackgroundComponent
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

    override val chipColorsDefault: SelectableChipColors
        @Composable get() = FilterChipDefaults.filterChipColors(
            containerColor = LocalTheme.current.colors.tetrial,
            labelColor = LocalTheme.current.colors.brandMain,
            selectedContainerColor = LocalTheme.current.colors.brandMain,
            selectedLabelColor = LocalTheme.current.colors.tetrial
        )
    override val heading: TextStyle
        @Composable
        get() = TextStyle(
            color = LocalTheme.current.colors.primary,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

    override val subheading: TextStyle
        @Composable
        get() = TextStyle(
            color = LocalTheme.current.colors.primary,
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium
        )

    override val category: TextStyle
        @Composable
        get() = TextStyle(
            color = LocalTheme.current.colors.secondary,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )

    override val title: TextStyle
        @Composable
        get() = TextStyle(
            color = LocalTheme.current.colors.primary,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
        )

    override val content: TextStyle
        @Composable
        get() = TextStyle(
            color = LocalTheme.current.colors.secondary,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal
        )

    override val menuItem: TextStyle
        @Composable
        get() = TextStyle(
            color = LocalTheme.current.colors.brandMainDark,
            fontSize = 19.sp,
            fontWeight = FontWeight.Medium
        )

    override val linkText: TextStyle
        @Composable
        get() = TextStyle(
            color = LocalTheme.current.colors.brandMainDark,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
}