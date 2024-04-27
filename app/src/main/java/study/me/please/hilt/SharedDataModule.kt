package study.me.please.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import study.me.please.data.shared.SharedDataManager
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedDataModule {

    /** Shared data manager with most common information */
    @Singleton
    @Provides
    fun provideSharedDataManager() = SharedDataManager()
}