package com.squadris.squadris.compose.theme

import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

/** Variables with default shapes */
interface ThemeShapes {

    /** shape for a component */
    val componentShape: Shape

    /** base component corner radius */
    val componentCornerRadius: Dp
}