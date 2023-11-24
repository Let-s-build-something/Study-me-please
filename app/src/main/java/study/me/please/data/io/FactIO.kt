package study.me.please.data.io

import android.content.Context
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.squadris.squadris.utils.DateUtils
import study.me.please.R
import study.me.please.data.room.AppRoomDatabase
import java.io.Serializable
import java.util.Date
import java.util.UUID

/** Fact containing specific related 2 information sets */
@Entity(tableName = AppRoomDatabase.ROOM_FACT_TABLE)
data class FactIO(

    /** unique identifier */
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString(),

    /** short content, that is a key to [longInformation], it works as a prompt in most of the cases */
    @SerializedName("short_key_information")
    var shortKeyInformation: String = "",

    /** Image which is prompted instead of text */
    @SerializedName("short_key_image")
    @Deprecated("no use for now")
    var shortKeyImage: LargePathAsset? = null,

    /** longer content, that could possibly explaing the [shortKeyInformation] */
    @SerializedName("long_information")
    var longInformation: String = "",

    /** Image which is coupled with [longInformation] */
    @SerializedName("long_information_image")
    @Deprecated("no use for now")
    var longInformationImage: LargePathAsset? = null,

    /** List content of this fact, will be changed and used only in case of [FactType.LIST] */
    val listContent: MutableList<String> = mutableListOf(),

    /** Image which can be questioned as well as answered with */
    @SerializedName("prompt_mage")
    var promptImage: LargePathAsset? = null,

    /** type of this fact */
    var type: FactType = FactType.DEFINITION,

    /** date of creation of this data object */
    @SerializedName("date_created")
    @ColumnInfo("date_created")
    val dateCreated: Long = DateUtils.now.timeInMillis
): Serializable {

    /** whether this data object is savable into the database - meaning lost progress if not */
    @get:Ignore
    val isSavable: Boolean
        get() = shortKeyInformation.isNotEmpty()
                || longInformation.isNotEmpty()
                || shortKeyImage?.isEmpty == false
                || longInformationImage?.isEmpty == false
                || promptImage?.isEmpty == false

    /**
     * Explanation of an image prompt, which is combination of both [shortKeyInformation] and [longInformation]
     */
    @get:Ignore
    val imageExplanationText: String
        get() = "$shortKeyInformation\n$longInformation"

    /** returns formulated prompt based on type and long information */
    fun getLongPrompt(context: Context) = context.getString(
        when(type) {
            FactType.FACT -> R.string.facts_type_long_fact_prompt
            FactType.DEFINITION -> R.string.facts_type_long_person_prompt
            FactType.PERSON -> R.string.facts_type_long_person_prompt
            FactType.DATE -> R.string.facts_type_long_date_prompt
            /*FactType.QUOTE*/ else -> R.string.facts_type_long_quote_prompt
        },
        longInformation
    )

    /** returns formulated prompt based on type and short information */
    fun getShortPrompt(context: Context) = context.getString(
        when(type) {
            FactType.FACT -> R.string.facts_type_short_fact_prompt
            FactType.DEFINITION -> R.string.facts_type_short_definition_prompt
            FactType.PERSON -> R.string.facts_type_short_person_prompt
            FactType.DATE -> R.string.facts_type_short_date_prompt
            FactType.QUOTE -> R.string.facts_type_short_quote_prompt
            FactType.LIST -> R.string.facts_type_short_list_prompt
        },
        shortKeyInformation
    )

    /** returns formulated prompt for image based on type */
    fun getImagePrompt(context: Context) = context.getString(
        when(type) {
            FactType.FACT -> R.string.facts_type_image_fact_prompt
            FactType.DEFINITION -> R.string.facts_type_image_definition_prompt
            FactType.PERSON -> R.string.facts_type_image_person_prompt
            FactType.DATE -> R.string.facts_type_image_date_prompt
            FactType.QUOTE -> R.string.facts_type_image_quote_prompt
            FactType.LIST -> R.string.facts_type_image_fact_prompt
        }
    )

    /** returns formulated generic prompt and long information */
    fun getGenericLongPrompt(context: Context) = context.getString(
        R.string.facts_information_generic_prompt,
        context.getString(type.getLongHeaderStringRes()).lowercase(),
        longInformation
    )

    /** returns formulated generic prompt and short information */
    fun getGenericShortPrompt(context: Context) = context.getString(
        R.string.facts_information_generic_prompt,
        context.getString(type.getStringRes()).lowercase(),
        shortKeyInformation
    )

    /** returns formulated generic prompt and short information */
    fun getGenericImagePrompt(context: Context) = context.getString(
        R.string.facts_type_image_quote_prompt
    )
}