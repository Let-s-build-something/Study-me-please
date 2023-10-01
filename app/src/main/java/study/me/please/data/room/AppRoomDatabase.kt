package study.me.please.data.room

import androidx.room.*
import study.me.please.data.io.LargePathAsset
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.QuestionAnswerIO
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.SessionIO
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.ui.session.QuestionModule

@Database(
    entities = [
        CollectionIO::class,
        QuestionIO::class,
        QuestionAnswerIO::class,
        LargePathAsset::class,
        SessionPreferencePack::class,
        SessionIO::class,
        QuestionModule::class,
    ],
    version = 3,
    exportSchema = false
)
@TypeConverters(AppDatabaseConverter::class)
abstract class AppRoomDatabase: RoomDatabase() {

    abstract fun collectionDbDao(): CollectionDao
    abstract fun questionDbDao(): QuestionDao
    abstract fun sessionDbDao(): SessionDao
    abstract fun homeDbDao(): HomeDao
    abstract fun preferencesDbDao(): PreferencesDao

    companion object {

        /** Identification of the main database */
        const val ROOM_DATABASE_NAME = "ROOM_DATABASE_NAME"

        /** Identification of table for [CollectionIO] */
        const val ROOM_COLLECTION_TABLE = "ROOM_COLLECTION_TABLE"

        /** Identification of table for [QuestionModule] */
        const val ROOM_QUESTION_MODULE_TABLE = "ROOM_QUESTION_MODULE_TABLE"

        /** Identification of table for [QuestionIO] */
        const val ROOM_QUESTION_TABLE = "ROOM_QUESTION_TABLE"

        /** Identification of table for [QuestionAnswerIO] */
        const val ROOM_QUESTION_ANSWER_TABLE = "ROOM_QUESTION_ANSWER_TABLE"

        /** Identification of table for [LargePathAsset] */
        const val ROOM_LARGE_PATH_ASSET_TABLE = "ROOM_LARGE_PATH_ASSET_TABLE"

        /** Identification of table for [SessionIO] */
        const val ROOM_SESSION_TABLE = "ROOM_SESSION_TABLE"

        /** Identification of table for [SessionPreferencePack] */
        const val ROOM_SESSION_PREFERENCE_PACK_TABLE = "ROOM_SESSION_PREFERENCE_PACK_TABLE"
    }
}