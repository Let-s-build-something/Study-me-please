package study.me.please.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import study.me.please.base.GeneralClipBoard
import study.me.please.base.GeneralClipBoardRepository
import study.me.please.data.room.FactDao
import study.me.please.data.room.UnitDao

@Module
@InstallIn(ActivityRetainedComponent::class)
object BaseDataModule {

    /** Current clipboard */
    @ActivityRetainedScoped
    @Provides
    fun provideClipBoard(repository: GeneralClipBoardRepository) = GeneralClipBoard(repository = repository)

    /** Current clipboard */
    @ActivityRetainedScoped
    @Provides
    fun provideGeneralClipBoardRepository(
        unitDao: UnitDao,
        factDao: FactDao
    ) = GeneralClipBoardRepository(
        unitDao = unitDao,
        factDao = factDao
    )
}