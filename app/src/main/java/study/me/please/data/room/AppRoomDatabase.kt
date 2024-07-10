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
    version = 12,
    exportSchema = true
)
@TypeConverters(AppDatabaseConverter::class)
abstract class AppRoomDatabase: RoomDatabase() {

    /** An interface for interacting with local database for collections */
    abstract fun collectionDbDao(): CollectionDao

    /** An interface for interacting with local database for questions */
    abstract fun questionDbDao(): QuestionDao

    /** An interface for interacting with local database for sessions */
    abstract fun sessionDbDao(): SessionDao

    /** An interface for interacting with local database for question modules */
    abstract fun questionModuleDbDao(): QuestionModuleDao

    /** An interface for interacting with local database for homepage */
    abstract fun homeDbDao(): HomeDao

    /** An interface for interacting with local database for preferences */
    abstract fun preferencesDbDao(): PreferencesDao

    /** An interface for interacting with local database for facts */
    abstract fun factDbDao(): FactDao

    /** An interface for interacting with local database for units */
    abstract fun unitDao(): UnitDao

    companion object {

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE ROOM_PARAGRAPH_TABLE ADD COLUMN dateCreated INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE ROOM_PARAGRAPH_TABLE ADD COLUMN imageAsset TEXT")
            }
        }

        val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(db: SupportSQLiteDatabase) {
                // Delete the tables
                db.execSQL("DROP TABLE IF EXISTS ROOM_UNIT_ELEMENT_FACT")
                db.execSQL("DROP TABLE IF EXISTS ROOM_UNIT_ELEMENT_PARAGRAPH")
            }
        }

        val MIGRATION_3_4 = object : Migration(3, 4) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE ROOM_SUBJECT_TABLE ADD COLUMN activatedParagraph TEXT")
            }
        }

        val MIGRATION_4_5 = object : Migration(4, 5) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE $ROOM_SESSION_TABLE ADD COLUMN questionModuleUid TEXT")
                db.execSQL("ALTER TABLE $ROOM_SESSION_TABLE ADD COLUMN lastSnapshotHash INTEGER")
                db.execSQL("ALTER TABLE $ROOM_SESSION_PREFERENCE_PACK_TABLE ADD COLUMN selectedUidList TEXT NOT NULL DEFAULT ''")

                db.execSQL("ALTER TABLE $ROOM_SESSION_TABLE DROP COLUMN q_module_sessionUid")
                db.execSQL("ALTER TABLE $ROOM_SESSION_TABLE DROP COLUMN q_module_questionsStack")
                db.execSQL("ALTER TABLE $ROOM_SESSION_TABLE DROP COLUMN q_module_uid")
                db.execSQL("ALTER TABLE $ROOM_SESSION_TABLE DROP COLUMN q_module_history")
                db.execSQL("ALTER TABLE $ROOM_SESSION_TABLE DROP COLUMN q_module_currentIndex")
            }
        }

        val MIGRATION_5_6 = object : Migration(5, 6) {
            override fun migrate(db: SupportSQLiteDatabase) {
                // Create new table with updated schema
                db.execSQL("""
            CREATE TABLE new_ROOM_SESSION_TABLE (
                name TEXT NOT NULL,
                uid TEXT NOT NULL PRIMARY KEY,
                preferencePackUid TEXT NOT NULL,
                estimatedMode TEXT,
                questionModuleUid TEXT,
                lastSnapshotHash TEXT,
                last_played INTEGER NOT NULL,
                collectionUidList TEXT NOT NULL,
                questionUidList TEXT NOT NULL,
                questionCount INTEGER NOT NULL
            )
        """.trimIndent())

                // Copy data from old table to new table
                db.execSQL("""
            INSERT INTO new_ROOM_SESSION_TABLE SELECT
                name,
                uid,
                preferencePackUid,
                estimatedMode,
                questionModuleUid,
                CAST(lastSnapshotHash AS TEXT),
                last_played,
                collectionUidList,
                questionUidList,
                questionCount
            FROM ROOM_SESSION_TABLE
        """.trimIndent())

                // Drop old table
                db.execSQL("DROP TABLE ROOM_SESSION_TABLE")

                // Rename new table to old table's name
                db.execSQL("ALTER TABLE new_ROOM_SESSION_TABLE RENAME TO ROOM_SESSION_TABLE")
            }
        }

        val MIGRATION_6_7 = object : Migration(6, 7) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE ROOM_FACT_TABLE DROP COLUMN shortKeyImage")
                db.execSQL("ALTER TABLE ROOM_FACT_TABLE DROP COLUMN longInformationImage")
                db.execSQL("ALTER TABLE ROOM_FACT_TABLE DROP COLUMN categoryUids")
                db.execSQL("ALTER TABLE $ROOM_FACT_TABLE ADD COLUMN nestedFacts TEXT NOT NULL DEFAULT ''")
            }
        }

        val MIGRATION_7_8 = object : Migration(7, 8) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE $ROOM_FACT_TABLE DROP COLUMN nestedFacts")
                db.execSQL("ALTER TABLE $ROOM_FACT_TABLE ADD COLUMN factUidList TEXT NOT NULL DEFAULT ''")
            }
        }

        val MIGRATION_8_9 = object : Migration(8, 9) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE $ROOM_UNIT_TABLE DROP COLUMN activatedParagraph")
                db.execSQL("ALTER TABLE $ROOM_UNIT_TABLE ADD COLUMN activatedParent TEXT")
            }
        }

        val MIGRATION_9_10 = object : Migration(9, 10) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE $ROOM_COLLECTION_TABLE ADD COLUMN lastSelectedUnitIndex INTEGER NOT NULL DEFAULT 0")
            }
        }

        val MIGRATION_10_11 = object : Migration(10, 11) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE $ROOM_COLLECTION_TABLE DROP COLUMN defaultPreference")
                db.execSQL("ALTER TABLE $ROOM_COLLECTION_TABLE ADD COLUMN categoryUidList TEXT NOT NULL DEFAULT ''")
            }
        }

        val MIGRATION_11_12 = object : Migration(11, 12) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE $ROOM_COLLECTION_TABLE DROP COLUMN userUid")
                db.execSQL("ALTER TABLE $ROOM_COLLECTION_TABLE ADD COLUMN authorUid TEXT")
            }
        }


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