package com.squadris.squadris.compose.theme

import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable

/** Variables with default styles */
interface ThemeStyle {
    @get:Composable
    val textFieldColors: TextFieldColors
}