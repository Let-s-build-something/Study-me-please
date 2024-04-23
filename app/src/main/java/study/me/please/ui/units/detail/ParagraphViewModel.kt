package study.me.please.ui.units.detail

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import study.me.please.base.BaseViewModel
import study.me.please.data.io.subjects.ParagraphIO
import javax.inject.Inject

/** Communication bridge between UI and DB */
@HiltViewModel
class ParagraphViewModel @Inject constructor(
    private val repository: ParagraphRepository,
): BaseViewModel() {

    private val _paragraph = MutableStateFlow<ParagraphIO?>(null)

    /** returned paragraph */
    val paragraph = _paragraph.asStateFlow()

    /** requests for a paragraph */
    fun requestParagraph(uid: String) {
        viewModelScope.launch {
            _paragraph.value = repository.getParagraph(uid)?.apply {
                fillInParagraph()
            }
        }
    }

    /** Fills in all neccessary data to this paragraph */
    private suspend fun ParagraphIO.fillInParagraph() {
        withContext(Dispatchers.Default) {
            if(paragraphUidList.isNotEmpty()) {
                paragraphs = repository.getParagraphsByUid(paragraphUidList)
                    .orEmpty()
                    .toMutableList()
                    .onEach {
                        it.fillInParagraph()
                    }
            }
            if(factUidList.isNotEmpty()) {
                facts = repository.getFactsByUid(factUidList).orEmpty().toMutableList()
            }
        }
    }
}