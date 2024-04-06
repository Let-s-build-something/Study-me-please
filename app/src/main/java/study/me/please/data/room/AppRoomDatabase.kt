package study.me.please.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.FactIO
import study.me.please.data.io.LargePathAsset
import study.me.please.data.io.QuestionAnswerIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.data.io.session.SessionIO
import study.me.please.data.io.subjects.CategoryIO
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.data.io.subjects.UnitIO
import study.me.please.data.state.session.QuestionModule

@Database(
    entities = [
        CollectionIO::class,
        QuestionIO::class,
        QuestionAnswerIO::class,
        LargePathAsset::class,
        SessionPreferencePack::class,
        SessionIO::class,
        QuestionModule::class,
        FactIO::class,
        UnitIO::class,
        CategoryIO::class,
        ParagraphIO::class
    ],
    version = 6,
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
    abstract fun subjectDbDao(): SubjectDao
    abstract fun categoryDbDao(): CategoryDao

    companion object {

        val MIGRATION_3_4 = object : Migration(3, 4) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE $ROOM_UNIT_TABLE ADD COLUMN paragraphUidList TEXT NOT NULL DEFAULT ''")
            }
        }

        val MIGRATION_4_5 = object : Migration(4, 5) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE ROOM_SUBJECT_TABLE ADD COLUMN paragraphs TEXT NOT NULL DEFAULT ''")
                db.execSQL("ALTER TABLE ROOM_SUBJECT_TABLE ADD COLUMN facts TEXT NOT NULL DEFAULT ''")
            }
        }

        val MIGRATION_5_6 = object : Migration(5, 6) {
            override fun migrate(db: SupportSQLiteDatabase) {
                // Add paragraphUidList column to the ROOM_PARAGRAPH_TABLE
                db.execSQL("ALTER TABLE ROOM_PARAGRAPH_TABLE ADD COLUMN paragraphUidList TEXT NOT NULL DEFAULT ''")

                // Add factUidList column to the ROOM_PARAGRAPH_TABLE
                db.execSQL("ALTER TABLE ROOM_PARAGRAPH_TABLE ADD COLUMN factUidList TEXT NOT NULL DEFAULT ''")

                // Create new table with desired structure
                db.execSQL("""
            CREATE TABLE new_ROOM_PARAGRAPH_TABLE (
                uid TEXT PRIMARY KEY NOT NULL,
                bulletPoints TEXT NOT NULL DEFAULT '',
                paragraphUidList TEXT NOT NULL DEFAULT '',
                categoryUid TEXT,
                factUidList TEXT NOT NULL DEFAULT '',
                localCategory TEXT
            )
        """.trimIndent())

                // Copy data from old table to new table
                db.execSQL("""
            INSERT INTO new_ROOM_PARAGRAPH_TABLE (uid, bulletPoints, paragraphUidList, categoryUid, factUidList, localCategory)
            SELECT uid, bulletPoints, paragraphUidList, categoryUid, factUidList, localCategory FROM ROOM_PARAGRAPH_TABLE
        """.trimIndent())

                // Drop old table
                db.execSQL("DROP TABLE ROOM_PARAGRAPH_TABLE")

                // Rename new table to old table's name
                db.execSQL("ALTER TABLE new_ROOM_PARAGRAPH_TABLE RENAME TO ROOM_PARAGRAPH_TABLE")
            }
        }

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

        /** Identification of table for [ParagraphIO] */
        const val ROOM_PARAGRAPH_TABLE = "ROOM_PARAGRAPH_TABLE"

        /** Identification of table for [FactIO] */
        const val ROOM_FACT_TABLE = "ROOM_FACT_TABLE"

        /** Identification of table for [UnitIO] */
        const val ROOM_UNIT_TABLE = "ROOM_SUBJECT_TABLE"

        /** Identification of table for [CategoryIO] */
        const val ROOM_CATEGORY_TABLE = "ROOM_SUBJECTS_TABLE"

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