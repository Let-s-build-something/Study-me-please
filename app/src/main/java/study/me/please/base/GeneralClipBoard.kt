package study.me.please.base

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.FactIO
import study.me.please.data.io.QuestionAnswerIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.subjects.ParagraphIO

/** General clipboard for copying and pasting any necessary information throughout the app */
data class GeneralClipBoard(
    /** repository for access to working with local DB for clipboard */
    val repository: GeneralClipBoardRepository,

    /** clipboard for collections */
    val collections: ClipBoard<CollectionIO> = ClipBoard.CollectionClipBoard(),

    /** clipboard for questions */
    val questions: ClipBoard<QuestionIO> = ClipBoard.QuestionClipBoard(),

    /** clipboard for answers */
    val answers: ClipBoard<QuestionAnswerIO> = ClipBoard.AnswerClipBoard(),

    /** clipboard for facts */
    val facts: ClipBoard<FactIO> = ClipBoard.FactClipBoard(),

    /** clipboard for paragraphs */
    val paragraphs: ClipBoard<ParagraphIO> = ClipBoard.ParagraphsClipBoard()
) {

    /** whether clipboard has been initialized */
    private var isInitialized = false

    /** initializes clipboard with data fom the local database */
    suspend fun initialize() {
        if(isInitialized) return

        withContext(Dispatchers.Default) {
            //TODO: implement initialization of clipboard
            isInitialized = true
        }
    }

    /** Removes all DB saved items */
    suspend fun clearClipBoard() {
        withContext(Dispatchers.Default) {
            //TODO: implement clearing of clipboard
        }
    }
}