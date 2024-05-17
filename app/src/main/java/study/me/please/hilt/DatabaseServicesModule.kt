package study.me.please.hilt

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import study.me.please.data.room.AppDatabaseConverter
import study.me.please.data.room.AppRoomDatabase

/** Main module provider for accessing interfaces for local Room database */
@Module
@InstallIn(ActivityRetainedComponent::class)
object DatabaseServicesModule {

    /** Interface for accessing collections in local Room database */
    @Provides
    fun provideCollectionDao(appDatabase: AppRoomDatabase) = appDatabase.collectionDbDao()

    /** Interface for accessing questions in local Room database */
    @Provides
    fun provideQuestionDao(appDatabase: AppRoomDatabase) = appDatabase.questionDbDao()

    /** Interface for accessing sessions in local Room database */
    @Provides
    fun provideSessionDao(appDatabase: AppRoomDatabase) = appDatabase.sessionDbDao()

    /** Interface for accessing sessions in local Room database */
    @Provides
    fun provideQuestionModuleDao(appDatabase: AppRoomDatabase) = appDatabase.questionModuleDbDao()

    /** Interface for accessing home data in local Room database */
    @Provides
    fun provideHomeDao(appDatabase: AppRoomDatabase) = appDatabase.homeDbDao()

    /** Interface for accessing preferences data in local Room database */
    @Provides
    fun providePreferencesDao(appDatabase: AppRoomDatabase) = appDatabase.preferencesDbDao()

    /** Interface for accessing preferences data in local Room database */
    @Provides
    fun provideFactDao(appDatabase: AppRoomDatabase) = appDatabase.factDbDao()

    /** Interface for accessing preferences data in local Room database */
    @Provides
    fun provideSubjectsDao(appDatabase: AppRoomDatabase) = appDatabase.unitDao()

    /** Interface for accessing preferences data in local Room database */
    @Provides
    fun provideCategoryDao(appDatabase: AppRoomDatabase) = appDatabase.categoryDbDao()

    /** Local main Room database */
    @ActivityRetainedScoped
    @Provides
    fun provideAppDatabase(
        @ApplicationContext appContext: Context,
        gson: Gson
    ) = Room.databaseBuilder(
        appContext,
        AppRoomDatabase::class.java,
        AppRoomDatabase.ROOM_DATABASE_NAME
    ).addTypeConverter(AppDatabaseConverter(gson))
        .addMigrations(AppRoomDatabase.MIGRATION_1_2)
        .addMigrations(AppRoomDatabase.MIGRATION_2_3)
        .addMigrations(AppRoomDatabase.MIGRATION_3_4)
        .build()

    /** Singleton instance of a Gson converter, since it's a costly initiated, it's faster this way */
    @ActivityRetainedScoped
    @Provides
    fun provideGsonInstance() = Gson()
}