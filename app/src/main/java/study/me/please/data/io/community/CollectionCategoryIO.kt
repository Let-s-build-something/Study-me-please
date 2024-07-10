package study.me.please.data.io.community

import androidx.room.Ignore
import com.google.firebase.Timestamp
import com.google.gson.annotations.SerializedName
import java.util.UUID

/** Category for categorizing collections */
data class CollectionCategoryIO(

    /** Name, that can also serve as a unique identifier */
    val name: String = "",

    /** Description of this category */
    val description: String = "",

    /** Image url for this category */
    val imageUrl: String = "",

    /** unique identifier, main use for this identifier is to update [name] */
    val uid: String = UUID.randomUUID().toString(),

    /** Date when this category was created */
    @Ignore
    private val _dateCreated: Timestamp? = null
) {
    /** date of creation of this data object */
    @get:SerializedName("date_created")
    val dateCreated: Long
        get() = _dateCreated?.toDate()?.time ?: 0L
}