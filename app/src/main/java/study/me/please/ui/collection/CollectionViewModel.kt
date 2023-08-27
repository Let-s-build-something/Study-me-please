package study.me.please.ui.collection

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import study.me.please.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class CollectionViewModel @Inject constructor(
    private val repository: CollectionRepository,
    val dataManager: CollectionDataManager
): BaseViewModel() {

    /** makes an API request for banner slides */
    fun requestBanners() {
        viewModelScope.launch {
            repository.getBanners()?.let { banners ->
                dataManager.bannersResponse.value = banners
            }
        }
    }

    /** Requests all collections */
    fun requestCollections() {
        viewModelScope.launch {
            repository.getCollections()?.let { collections ->
                dataManager.collections.value = collections
            }
        }
    }
}