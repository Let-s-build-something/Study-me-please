package study.me.please.ui.settings

import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import study.me.please.base.BaseViewModel
import study.me.please.hilt.SharedPreferencesModule
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    val sharedPreferences: SharedPreferences
): BaseViewModel() {

    /** Requests for a theme preference change */
    fun requestThemeChange(
        isDarkTheme: Boolean
    ) {
        viewModelScope.launch {
            sharedPreferences.edit {
                putBoolean(
                    SharedPreferencesModule.SP_IS_DARK_THEME,
                    isDarkTheme
                )
                commit()
            }
        }
    }
}