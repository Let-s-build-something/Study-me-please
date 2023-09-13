package study.me.please.ui.home

import android.content.SharedPreferences
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import study.me.please.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository,
    val dataManager: HomeDataManager,
    val sharedPreferences: SharedPreferences
): BaseViewModel() {

    /** makes an API request for banner slides */
    fun requestBanners() {
        viewModelScope.launch {
            repository.getBanners()?.let { banners ->
                dataManager.bannersResponse.value = banners
            }
        }
    }
}