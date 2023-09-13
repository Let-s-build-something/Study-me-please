package com.squadris.squadris.compose.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


/** Styles specific to main app theme [AppTheme] */
class AppThemeShapes: ThemeShapes {

    override val componentCornerRadius: Dp = 16.dp
    override val componentShape: Shape = RoundedCornerShape(componentCornerRadius)
}