package study.me.please.data.room

import androidx.room.*
import study.me.please.data.io.LargePathAsset
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.QuestionAnswerIO
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.UserPromptPreferences

@Database(
    entities = [
        CollectionIO::class,
        QuestionIO::class,
        QuestionAnswerIO::class,
        LargePathAsset::class,
        UserPromptPreferences::class
    ],
    version = 2,
    exportSchema = false
)
@TypeConverters(AppDatabaseConverter::class)
abstract class AppRoomDatabase: RoomDatabase() {

    abstract fun collectionDbDao(): CollectionDao

    companion object {

        /** Identification of the main database */
        const val ROOM_DATABASE_NAME = "ROOM_DATABASE_NAME"

        /** Identification of table for [CollectionIO] */
        const val ROOM_COLLECTION_TABLE = "ROOM_COLLECTION_TABLE"

        /** Identification of table for [QuestionIO] */
        const val ROOM_QUESTION_TABLE = "ROOM_QUESTION_TABLE"

        /** Identification of table for [QuestionAnswerIO] */
        const val ROOM_QUESTION_ANSWER_TABLE = "ROOM_QUESTION_ANSWER_TABLE"

        /** Identification of table for [UserPromptPreferences] */
        const val ROOM_USER_PROMPT_PREFERENCES_TABLE = "ROOM_USER_PROMPT_PREFERENCES_TABLE"

        /** Identification of table for [LargePathAsset] */
        const val ROOM_LARGE_PATH_ASSET_TABLE = "ROOM_LARGE_PATH_ASSET_TABLE"
    }
}