package study.me.please.data.io

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.firestore.Exclude
import study.me.please.data.room.AppRoomDatabase
import java.io.Serializable
import java.util.UUID

/**
 * Asset with all neccessary information to display either locally stored or online stored image
 */
@Entity(tableName = AppRoomDatabase.ROOM_LARGE_PATH_ASSET_TABLE)
data class LargePathAsset(

    /** URL path to image location */
    var urlPath: String? = null,

    /** local path to an image */
    val localUri: Uri? = null,

    /** FireBase storage url path to an image */
    val fbStoragePath: String? = null,

    /** uid of preset image */
    val presetImageUid: String? = null,

    /** unique identifier */
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString()

): Serializable {

    /** whether the file is sourced locally */
    @get:Exclude
    val isLocal: Boolean
        get() = localUri?.path.isNullOrEmpty().not()

    /** whether this object is empty or not */
    @get:Exclude
    val isEmpty: Boolean
        get() = urlPath.isNullOrEmpty()
            && localUri?.path.isNullOrEmpty()
            && fbStoragePath.isNullOrEmpty()
            && presetImageUid.isNullOrEmpty()

    /** returns url of the file */
    @get:Exclude
    val url: String?
        get() = urlPath ?: fbStoragePath
}