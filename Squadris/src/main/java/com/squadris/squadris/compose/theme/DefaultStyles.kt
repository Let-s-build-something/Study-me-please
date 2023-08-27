package com.squadris.squadris.compose.theme

import androidx.compose.material3.CheckboxColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val checkBoxColorsDefault: CheckboxColors
    @Composable get() = CheckboxColors(
        checkedCheckmarkColor = AppTheme.colors.secondary,
        uncheckedCheckmarkColor = AppTheme.colors.secondary,
        checkedBoxColor = Color.Transparent,
        uncheckedBoxColor = Color.Transparent,
        checkedBorderColor = AppTheme.colors.brandMain,
        uncheckedBorderColor = AppTheme.colors.brandMain,
        disabledUncheckedBoxColor = Color.Transparent,
        disabledCheckedBoxColor = Color.Transparent,
        disabledBorderColor = AppTheme.colors.disabled,
        disabledIndeterminateBorderColor = AppTheme.colors.disabled,
        disabledIndeterminateBoxColor = Color.Transparent
    )