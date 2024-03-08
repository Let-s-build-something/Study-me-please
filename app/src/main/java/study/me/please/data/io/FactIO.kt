package study.me.please.data.io

import android.content.Context
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.squadris.squadris.utils.DateUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.R
import study.me.please.data.room.AppRoomDatabase
import java.io.Serializable
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

    /** List of information */
    var textList: List<String> = listOf(),

    /** Image which is coupled with [longInformation] */
    @SerializedName("long_information_image")
    @Deprecated("no use for now")
    var longInformationImage: LargePathAsset? = null,

    /** Image which can be questioned as well as answered with */
    @SerializedName("prompt_mage")
    var promptImage: LargePathAsset? = null,

    /** type of this fact */
    var type: FactType = FactType.DEFINITION,

    /** date of creation of this data object */
    @SerializedName("date_created")
    @ColumnInfo("date_created")
    val dateCreated: Long = DateUtils.now.timeInMillis,

    /** List of category unique identifiers to identify categories by which this fact is categorized */
    var categoryUids: List<String> = listOf()
): Serializable {

    override fun toString(): String {
        return super.toString() +
                "{" +
                "uid: $uid," +
                "shortKeyInformation: $shortKeyInformation," +
                "shortKeyImage: $shortKeyImage," +
                "longInformation: $longInformation," +
                "textList: $textList," +
                "longInformationImage: $longInformationImage," +
                "promptImage: $promptImage," +
                "type: $type," +
                "dateCreated: $dateCreated," +
                "categoryUids: $categoryUids" +
                "}"
    }

    fun deepCopy(): FactIO {
        return FactIO(
            shortKeyInformation = shortKeyInformation,
            shortKeyImage = shortKeyImage,
            longInformation = longInformation,
            textList = textList,
            longInformationImage = longInformationImage,
            promptImage = promptImage,
            type = type,
            dateCreated = dateCreated,
            categoryUids = categoryUids
        )
    }

    /** Whether there is not visible data */
    @get:Ignore
    val isEmpty: Boolean
        get() = shortKeyInformation.isEmpty()
                && longInformation.isEmpty()
                && promptImage?.isEmpty != false
                && (textList.isEmpty() || type.isListType.not())

    /** Whether this data can be taken seriously */
    suspend fun isSeriousDataPoint() = withContext(Dispatchers.Default) {
        (hasTextData() || promptImage?.isEmpty == false)
                && shortKeyInformation.isNotBlank()
    }

    /** Whether this data can be taken seriously */
    suspend fun hasTextData() = withContext(Dispatchers.Default) {
        (textList.any { it.isNotBlank() } || longInformation.isNotBlank())
                && shortKeyInformation.isNotBlank()
    }

    /**
     * Explanation of an image prompt, which is combination of both [shortKeyInformation] and [longInformation]
     */
    @get:Ignore
    val imageExplanationText: String
        get() = "$shortKeyInformation\n$longInformation"

    /** returns formulated prompt based on type and long information */
    fun getLongPrompt(context: Context) = context.getString(
        when(type) {
            FactType.BULLET_POINTS -> R.string.facts_type_long_fact_prompt
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
            FactType.BULLET_POINTS -> R.string.facts_type_short_fact_prompt
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
            FactType.BULLET_POINTS -> R.string.facts_type_image_fact_prompt
            FactType.DEFINITION -> R.string.facts_type_image_definition_prompt
            FactType.PERSON -> R.string.facts_type_image_person_prompt
            FactType.DATE -> R.string.facts_type_image_date_prompt
            FactType.QUOTE -> R.string.facts_type_image_quote_prompt
            FactType.LIST -> R.string.facts_type_image_fact_prompt
        }
    )

    /** returns formulated generic prompt and long information */
    @Deprecated("Need change of strategy")
    fun getGenericLongPrompt(context: Context) = context.getString(
        R.string.facts_information_generic_prompt,
        context.getString(type.getLongHeaderStringRes() ?: 0).lowercase(),
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

    /** Updates this object with new data */
    fun updateTO(fact: FactIO) {
        this.shortKeyInformation = fact.shortKeyInformation
        this.type = fact.type
        this.longInformation = fact.longInformation
        this.shortKeyImage = fact.shortKeyImage
        this.longInformationImage = fact.longInformationImage
        this.textList = fact.textList
        this.promptImage = fact.promptImage
        this.categoryUids = fact.categoryUids
    }
}