package study.me.please.data.io.subjects

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.squadris.squadris.utils.DateUtils
import study.me.please.data.room.AppRoomDatabase.Companion.ROOM_CATEGORY_TABLE
import java.util.UUID

/** Category for categorizing any data set */
@Entity(tableName = ROOM_CATEGORY_TABLE)
data class CategoryIO(

    /** Name, that should also serve as a unique identifier */
    val name: String,

    /** unique identifier, main use for this identifier is to update [name] */
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString(),

    /** date of creation of this data object */
    @SerializedName("date_created")
    @ColumnInfo("date_created")
    val dateCreated: Long = DateUtils.now.timeInMillis
)