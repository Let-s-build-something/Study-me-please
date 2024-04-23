package study.me.please.ui.units.detail

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.FactIO
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.data.room.FactDao
import study.me.please.data.room.QuestionDao
import study.me.please.data.room.UnitDao
import javax.inject.Inject

/** Proxy for calling network end points */
class ParagraphRepository @Inject constructor(
    private val questionDao: QuestionDao,
    private val subjectsDao: UnitDao,
    private val factDao: FactDao
) {

    /** Returns a paragraph based on its uid */
    suspend fun getParagraph(uid: String): ParagraphIO? {
        return withContext(Dispatchers.IO) {
            questionDao.getParagraphByUid(uid)
        }
    }

    /** Returns paragraphs based on their uid */
    suspend fun getParagraphsByUid(uidList: List<String>): List<ParagraphIO>? {
        return withContext(Dispatchers.IO) {
            subjectsDao.getParagraphsByUidList(uidList)
        }
    }

    /** Returns a list of facts by their identifiers - [factsUidList] */
    suspend fun getFactsByUid(factsUidList: List<String>): List<FactIO>? {
        return withContext(Dispatchers.IO) {
            factDao.getFactsByUid(factsUidList)
        }
    }
}