package study.me.please.data.room

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.FactIO
import study.me.please.data.io.LargePathAsset
import study.me.please.data.io.QuestionAnswerIO
import study.me.please.data.io.QuestionIO
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
        FactIO::class
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(AppDatabaseConverter::class)
abstract class AppRoomDatabase: RoomDatabase() {

    abstract fun collectionDbDao(): CollectionDao
    abstract fun questionDbDao(): QuestionDao
    abstract fun sessionDbDao(): SessionDao
    abstract fun questionModuleDbDao(): QuestionModuleDao
    abstract fun homeDbDao(): HomeDao
    abstract fun preferencesDbDao(): PreferencesDao

    abstract fun factDbDao(): FactDao

    companion object {

        /*val MIGRATION_3_4 = object : Migration(3, 4) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE $ROOM_COLLECTION_TABLE ADD COLUMN factUidList TEXT NOT NULL DEFAULT ''")
                database.execSQL("CREATE TABLE $ROOM_FACT_TABLE (uid TEXT NOT NULL DEFAULT '', shortKeyInformation TEXT NOT NULL DEFAULT ''," +
                        " longInformation TEXT NOT NULL DEFAULT '', longInformationImage TEXT DEFAULT ''," +
                        " date_created TEXT NOT NULL DEFAULT '', type TEXT NOT NULL DEFAULT 'FACT', shortKeyImage TEXT DEFAULT '', PRIMARY KEY('uid'))")
            }
        }

        val MIGRATION_4_5 = object : Migration(4, 5) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("DROP TABLE $ROOM_FACT_TABLE")
                database.execSQL("CREATE TABLE $ROOM_FACT_TABLE (uid TEXT NOT NULL DEFAULT '', shortKeyInformation TEXT NOT NULL DEFAULT ''," +
                        " longInformation TEXT NOT NULL DEFAULT '', longInformationImage TEXT DEFAULT ''," +
                        " date_created TEXT NOT NULL DEFAULT '', type TEXT NOT NULL DEFAULT 'FactType.FACT', shortKeyImage TEXT DEFAULT '', PRIMARY KEY('uid'))")
            }
        }

        val MIGRATION_5_6 = object : Migration(5, 6) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("DROP TABLE $ROOM_FACT_TABLE")
                database.execSQL("CREATE TABLE $ROOM_FACT_TABLE (uid TEXT NOT NULL DEFAULT '', shortKeyInformation TEXT NOT NULL DEFAULT ''," +
                        " longInformation TEXT NOT NULL DEFAULT '', longInformationImage TEXT DEFAULT ''," +
                        " date_created TEXT NOT NULL DEFAULT '', type TEXT NOT NULL DEFAULT 'FactType.FACT', shortKeyImage TEXT DEFAULT '', PRIMARY KEY('uid'))")
            }
        }*/

        /** Identification of the main database */
        const val ROOM_DATABASE_NAME = "ROOM_DATABASE_NAME"

        /** Identification of table for [CollectionIO] */
        const val ROOM_COLLECTION_TABLE = "ROOM_COLLECTION_TABLE"

        /** Identification of table for [QuestionModule] */
        const val ROOM_QUESTION_MODULE_TABLE = "ROOM_QUESTION_MODULE_TABLE"

        /** Identification of table for [QuestionIO] */
        const val ROOM_QUESTION_TABLE = "ROOM_QUESTION_TABLE"

        /** Identification of table for [FactIO] */
        const val ROOM_FACT_TABLE = "ROOM_FACT_TABLE"

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