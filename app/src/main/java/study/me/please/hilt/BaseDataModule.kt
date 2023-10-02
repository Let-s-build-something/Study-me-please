package study.me.please.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import study.me.please.base.GeneralClipBoard

@Module
@InstallIn(ActivityRetainedComponent::class)
object BaseDataModule {

    /** Current clipboard */
    @ActivityRetainedScoped
    @Provides
    fun provideClipBoard() = GeneralClipBoard()
}

