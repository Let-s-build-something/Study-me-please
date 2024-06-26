package study.me.please.data.io

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ShortText
import androidx.compose.material.icons.outlined.FormatListNumbered
import androidx.compose.material.icons.outlined.FormatQuote
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Today
import study.me.please.R

/**
 * Type of fact inputted by the user
 */
enum class FactType {

    //BULLET_POINTS,

    /**
     * either single definition, or multiple lines of explanation as bullet points
     */
    DEFINITION,

    /** List of information paired onto a short text */
    LIST,

    /** Information about a person */
    PERSON,

    /** Information containing word per word quoting some entity */
    QUOTE,

    /** Information about a specific date */
    DATE;

    /** Whether this item should hold list of items */
    val isListType: Boolean
        get() = this == DEFINITION || this == LIST

    /** Icon identification of this type */
    fun getIconImageVector() = when(this) {
        DEFINITION -> Icons.AutoMirrored.Outlined.ShortText
        PERSON -> Icons.Outlined.Person
        DATE -> Icons.Outlined.Today
        LIST -> Icons.Outlined.FormatListNumbered
        QUOTE -> Icons.Outlined.FormatQuote
    }

    /** Text identification of this type */
    @StringRes
    fun getStringRes() = when(this) {
        DEFINITION -> R.string.facts_type_definition
        PERSON -> R.string.facts_type_person
        DATE -> R.string.facts_type_date
        LIST -> R.string.facts_type_list
        QUOTE -> R.string.facts_type_quote
    }

    /** Hint for short (key) information */
    @StringRes
    fun getShortHintStringRes() = when(this) {
        DEFINITION -> R.string.facts_type_short_definition_hint
        PERSON -> R.string.facts_type_short_person_hint
        DATE -> R.string.facts_type_short_date_hint
        LIST -> R.string.facts_type_short_list_hint
        QUOTE -> R.string.facts_type_short_quote_hint
    }

    /** Header for short (key) information input */
    @StringRes
    fun getShortHeaderStringRes() = when(this) {
        DEFINITION -> R.string.facts_type_short_bullet_point_header
        PERSON -> R.string.facts_type_short_person_header
        DATE -> R.string.facts_type_short_date_header
        QUOTE -> R.string.facts_type_short_quote_header
        LIST -> R.string.facts_type_short_list_header
    }

    /** Hint for long information */
    @StringRes
    fun getLongHintStringRes() = when(this) {
        DEFINITION -> R.string.facts_type_long_definition_hint
        PERSON -> R.string.facts_type_long_person_hint
        DATE -> R.string.facts_type_long_date_hint
        QUOTE -> R.string.facts_type_long_quote_hint
        else -> null
    }




    /** Header for long information input */
    @StringRes
    fun getLongHeaderStringRes() = when(this) {
        DEFINITION -> R.string.facts_type_long_definition_header
        PERSON -> R.string.facts_type_long_person_header
        DATE -> R.string.facts_type_long_date_header
        QUOTE -> R.string.facts_type_long_quote_header
        else -> null
    }

    companion object {

        /** Prefix for a bullet point item */
        const val BULLET_POINT_PREFIX = "-\t\t"
    }
}