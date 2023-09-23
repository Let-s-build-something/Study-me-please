package com.squadris.squadris.compose.theme

import androidx.compose.material3.CardElevation
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp

/** Variables with default styles */
interface ThemeStyle {

    /** default colors for material3 text input */
    @get:Composable
    val textFieldColors: TextFieldColors

    /** default colors for material3 checkbox */
    @get:Composable
    val checkBoxColorsDefault: CheckboxColors

    /** default colors for material3 checkbox */
    @get:Composable
    val switchColorsDefault: SwitchColors

    val componentElevation: Dp
    val actionElevation: Dp
    val minimumElevation: Dp

    @get:Composable
    val cardClickableElevation: CardElevation
}