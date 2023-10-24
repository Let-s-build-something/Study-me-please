package study.me.please.ui.collection.detail

import kotlinx.coroutines.flow.MutableStateFlow
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.FactIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.SessionIO
import java.util.UUID
import javax.inject.Inject

/** Data storage */
class CollectionDetailDataManager @Inject constructor() {

    /** Detail of received collection from database */
    var collectionDetail: MutableStateFlow<CollectionIO> = MutableStateFlow(CollectionIO())

    /** list of all sessions saved locally */
    var sessions: MutableStateFlow<List<SessionIO>?> = MutableStateFlow(null)

    /** local temporary save of downloaded questions */
    var collectionQuestions: MutableStateFlow<List<QuestionIO>> = MutableStateFlow(listOf())

    /** local temporary save of downloaded facts */
    var collectionFacts: MutableStateFlow<List<FactIO>> = MutableStateFlow(listOf())
}

enum class ErrorType {
    NOT_ENOUGH_FACTS
}

data class QuestionGenerationResponse(
    val uid: String = UUID.randomUUID().toString(),
    val errorType: ErrorType? = null,
    val isSuccessful: Boolean? = null,
    val questionsGenerated: Int? = null
)