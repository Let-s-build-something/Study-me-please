package study.me.please.hilt

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Named

@Module
@InstallIn(ActivityRetainedComponent::class)
object SharedPreferencesModule {

    private const val MASTER_KEY = "masterKey"

    /** Shared preferences key for whether this app is in dark theme */
    const val SP_IS_DARK_THEME = "is_dark_theme"

    /** master key to this app's shared preferences */
    @ActivityRetainedScoped
    @Provides
    @Named(MASTER_KEY)
    fun provideMasterKey() = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

    /** Get base - general shared preferences */
    @ActivityRetainedScoped
    @Provides
    fun provideGeneralPreferences(
        @Named(MASTER_KEY) masterKey: String,
        @ApplicationContext appContext: Context
    ) = EncryptedSharedPreferences.create(
        "master",
        masterKey,
        appContext,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )
}