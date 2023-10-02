package study.me.please.base

import study.me.please.data.io.CollectionIO
import study.me.please.data.io.QuestionAnswerIO
import study.me.please.data.io.QuestionIO

/** General clipboard for copying and pasting any necessary information throughout the app */
data class GeneralClipBoard(
    /** clipboard for collections */
    val collections: ClipBoard<CollectionIO> = ClipBoard.CollectionClipBoard(),

    /** clipboard for questions */
    val questions: ClipBoard<QuestionIO> = ClipBoard.QuestionClipBoard(),

    /** clipboard for answers */
    val answers: ClipBoard<QuestionAnswerIO> = ClipBoard.AnswerClipBoard()
)