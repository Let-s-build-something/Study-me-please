package study.me.please.data.io

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Notes
import androidx.compose.material.icons.outlined.FormatQuote
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Today
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import study.me.please.R

/**
 * Type of fact inputted by the user
 */
enum class FactType {
    /** Default type with 2 text based informations */
    FACT,

    /** Information about a person */
    PERSON,

    /** Information about a specific date */
    DATE,

    /** Information containing word per word quoting some entity */
    QUOTE;

    fun getIconImageVector() = when(this) {
        FACT -> Icons.AutoMirrored.Outlined.Notes
        PERSON -> Icons.Outlined.Person
        DATE -> Icons.Outlined.Today
        QUOTE -> Icons.Outlined.FormatQuote
    }

    @StringRes
    fun getStringRes() = when(this) {
        FACT -> R.string.facts_type_fact
        PERSON -> R.string.facts_type_person
        DATE -> R.string.facts_type_date
        QUOTE -> R.string.facts_type_quote
    }

    @StringRes
    fun getShortHintStringRes() = when(this) {
        FACT -> R.string.facts_type_short_fact_hint
        PERSON -> R.string.facts_type_short_person_hint
        DATE -> R.string.facts_type_short_date_hint
        QUOTE -> R.string.facts_type_short_quote_hint
    }

    @StringRes
    fun getShortHeaderStringRes() = when(this) {
        FACT -> R.string.facts_type_short_fact_header
        PERSON -> R.string.facts_type_short_person_header
        DATE -> R.string.facts_type_short_date_header
        QUOTE -> R.string.facts_type_short_quote_header
    }

    @StringRes
    fun getLongHintStringRes() = when(this) {
        FACT -> R.string.facts_type_long_fact_hint
        PERSON -> R.string.facts_type_long_person_hint
        DATE -> R.string.facts_type_long_date_hint
        QUOTE -> R.string.facts_type_long_quote_hint
    }

    @StringRes
    fun getLongHeaderStringRes() = when(this) {
        FACT -> R.string.facts_type_long_fact_header
        PERSON -> R.string.facts_type_long_person_header
        DATE -> R.string.facts_type_long_date_header
        QUOTE -> R.string.facts_type_long_quote_header
    }
}