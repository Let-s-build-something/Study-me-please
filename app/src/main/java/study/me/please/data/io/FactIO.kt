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

    /** Whether there is not visible data */
    @get:Ignore
    val isEmpty: Boolean
        get() = shortKeyInformation.isEmpty()
                && longInformation.isEmpty()
                && promptImage?.isEmpty != false
                && (textList.isEmpty() || type != FactType.LIST)

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

    /** returns formulated generic prompt and long information */
    @Deprecated("Need change of strategy")
    fun getGenericLongPrompt(context: Context) = context.getString(
        R.string.facts_information_generic_prompt,
        context.getString(type.getLongHeaderStringRes() ?: 0).lowercase(),
        longInformation
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