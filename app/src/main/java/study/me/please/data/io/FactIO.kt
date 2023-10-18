package study.me.please.data.io

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.squadris.squadris.utils.DateUtils
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

    /** Image which can be questioned as well as answered with */
    @SerializedName("prompt_mage")
    var promptImage: LargePathAsset? = null,

    /** type of this fact */
    var type: FactType = FactType.FACT,

    /** date of creation of this data object */
    @SerializedName("date_created")
    @ColumnInfo("date_created")
    val dateCreated: Date = DateUtils.now.time
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
}