package com.squadris.squadris.ext

import java.math.RoundingMode
import java.text.DecimalFormat

/** rounds a double into two decimals */
fun Double.roundOffDecimal(): Double {
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.CEILING
    return df.format(this).toDouble()
}