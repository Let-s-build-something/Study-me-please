package study.me.please.ui.units.detail

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import study.me.please.base.BaseViewModel
import study.me.please.data.io.subjects.CategoryIO
import study.me.please.data.io.subjects.ParagraphIO
import javax.inject.Inject

/** Communication bridge between UI and DB */
@HiltViewModel
class ParagraphViewModel @Inject constructor(
    private val repository: ParagraphRepository,
): BaseViewModel() {

    private val _paragraph = MutableStateFlow<ParagraphIO?>(null)

    /** List of all categories */
    private val _categories = MutableStateFlow<List<CategoryIO>?>(null)

    /** List of all categories */
    val categories = _categories.asStateFlow()

    /** returned paragraph */
    val paragraph = _paragraph.asStateFlow()

    /** requests for a paragraph */
    fun requestParagraph(uid: String) {
        viewModelScope.launch {
            _paragraph.value = repository.getParagraph(uid)
        }
    }

    /** Makes a request for all existing categories */
    fun requestAllCategories() {
        viewModelScope.launch {
            _categories.value = repository.getAllCategories()
        }
    }
}