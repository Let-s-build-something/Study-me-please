package study.me.please.data.io

import androidx.room.Entity
import androidx.room.PrimaryKey
import study.me.please.data.room.AppRoomDatabase
import java.io.Serializable
import java.util.UUID

/**
 * Asset with all neccessary information to display either locally stored or online stored image
 */
@Entity(tableName = AppRoomDatabase.ROOM_LARGE_PATH_ASSET_TABLE)
data class LargePathAsset(

    /** URL path to image location */
    val urlPath: String? = null,

    /** local path to an image */
    val localPath: String? = null,

    /** FireBase storage url path to an image */
    val fbStoragePath: String? = null,

    /** uid of preset image */
    val presetImageUid: String? = null,

    /** unique identifier */
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString()

): Serializable {

    /** whether the file is sourced locally */
    val isLocal: Boolean
        get() = localPath?.isNotEmpty() == true

    /** returns url of the file */
    val url: String?
        get() = if(isLocal) localPath else urlPath ?: fbStoragePath
}