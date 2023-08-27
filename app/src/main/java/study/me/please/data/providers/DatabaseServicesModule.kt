package study.me.please.data.providers

import android.content.Context
import androidx.room.Room
import study.me.please.data.room.AppDatabaseConverter
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import study.me.please.data.room.AppRoomDatabase

/** Main module provider for accessing interfaces for local Room database */
@Module
@InstallIn(ActivityRetainedComponent::class)
object DatabaseServicesModule {

    /** Interface for accessing collections in local Room database */
    @Provides
    fun provideCollectionDao(appDatabase: AppRoomDatabase) = appDatabase.collectionDbDao()

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
    ).fallbackToDestructiveMigration()
        .addTypeConverter(AppDatabaseConverter(gson))
        .build()

    /** Singleton instance of a Gson converter, since it's a costly initiated, it's faster this way */
    @ActivityRetainedScoped
    @Provides
    fun provideGsonInstance() = Gson()
}