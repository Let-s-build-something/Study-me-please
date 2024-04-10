package study.me.please.ui.collection.detail

import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.MutableStateFlow
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.FactIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.session.SessionIO
import study.me.please.data.io.subjects.CategoryIO
import java.util.UUID
import javax.inject.Inject

/** Data storage */
class CollectionDetailDataManager @Inject constructor() {

    /** Detail of received collection from database */
    val collectionDetail: MutableStateFlow<CollectionIO?> = MutableStateFlow(null)

    /** local temporary save of downloaded questions */
    val collectionQuestions: MutableStateFlow<List<QuestionIO>> = MutableStateFlow(listOf())

    /** local temporary save of downloaded facts */
    val collectionFacts: MutableStateFlow<List<FactIO>> = MutableStateFlow(listOf())

    /** List of all categories from DB */
    val categories = MutableStateFlow<List<CategoryIO>?>(null)
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