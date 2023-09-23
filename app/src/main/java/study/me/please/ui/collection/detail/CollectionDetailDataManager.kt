package study.me.please.ui.collection.detail

import kotlinx.coroutines.flow.MutableStateFlow
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.QuestionIO
import javax.inject.Inject

/** Data storage */
class CollectionDetailDataManager @Inject constructor() {

    /** Detail of received collection from database */
    var collectionDetail: MutableStateFlow<CollectionIO> = MutableStateFlow(CollectionIO())

    /** list of questions based on uids */
    var questions: MutableStateFlow<MutableList<QuestionIO>?> = MutableStateFlow(null)
}