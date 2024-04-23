package study.me.please.base

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.room.ClipboardDao
import study.me.please.data.io.UnitElement
import javax.inject.Inject

/** Proxy for calling network end points */
class GeneralClipBoardRepository @Inject constructor(
    private val clipBoardDao: ClipboardDao
) {

    /** returns all unit element paragraphs */
    suspend fun getUnitElementParagraphs(): List<UnitElement.Paragraph>? {
        return withContext(Dispatchers.IO) {
            clipBoardDao.getUnitElementParagraphs()
        }
    }

    /** returns all unit element facts */
    suspend fun getUnitElementFacts(): List<UnitElement.Fact>? {
        return withContext(Dispatchers.IO) {
            clipBoardDao.getUnitElementFacts()
        }
    }


    /** Removes all unit elements */
    suspend fun clearUnitElements() {
        withContext(Dispatchers.IO) {
            clipBoardDao.clearUnitElementParagraphs()
            clipBoardDao.clearUnitElementFacts()
        }
    }


    /** Inserts or updates a new unit element paragraph [element] into the database */
    suspend fun insertUnitElementParagraph(element: UnitElement.Paragraph) {
        return withContext(Dispatchers.IO) {
            clipBoardDao.insertUnitElementParagraph(element)
        }
    }

    /** Inserts or updates a new unit element fact [element] into the database */
    suspend fun insertUnitElementFact(element: UnitElement.Fact) {
        withContext(Dispatchers.IO) {
            clipBoardDao.insertUnitElementFact(element)
        }
    }
}