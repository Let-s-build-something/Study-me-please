package study.me.please.ui.collection.detail.questions.detail

import kotlinx.coroutines.flow.MutableStateFlow
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.FactIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.session.SessionIO
import java.util.UUID
import javax.inject.Inject

/** Data storage */
class QuestionDetailDataManager @Inject constructor() {

    /** Received question detail from database */
    var questionDetail: MutableStateFlow<QuestionIO?> = MutableStateFlow(null)
}