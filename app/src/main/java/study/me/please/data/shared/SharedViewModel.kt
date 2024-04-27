package study.me.please.data.shared

import android.content.SharedPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import study.me.please.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
open class SharedViewModel @Inject constructor(
    private val sharedDataManager: SharedDataManager,
    val sharedPreferences: SharedPreferences
): BaseViewModel() {

    /** currently signed in user */
    val currentUser = sharedDataManager.currentUser.asStateFlow()
}