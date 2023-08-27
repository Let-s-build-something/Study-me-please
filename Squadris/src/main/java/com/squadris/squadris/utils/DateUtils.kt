package com.squadris.squadris.utils

import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale


object DateUtils {

    /** Current [Locale] */
    val locale: Locale
        get() = Locale.getDefault()

    /** formats given [date] based on given [pattern] */
    fun formatDateAs(
        date: Date?,
        pattern: String
    ): String = if(date != null) {
        DateTimeFormatter.ofPattern(pattern, locale).format(
            date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        )
    }else ""

}