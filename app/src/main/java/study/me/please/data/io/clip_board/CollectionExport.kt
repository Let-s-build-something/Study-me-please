package study.me.please.data.io.clip_board

import study.me.please.data.io.CollectionIO
import study.me.please.data.io.FactIO
import study.me.please.data.io.QuestionIO
import java.io.Serializable

/** data class designed only for purpose of manual export */
data class CollectionExport(
    val collection: CollectionIO?,
    val questions: List<QuestionIO>,
    val facts: List<FactIO>
): Serializable