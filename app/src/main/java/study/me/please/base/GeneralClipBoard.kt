package study.me.please.base

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.FactIO
import study.me.please.data.io.QuestionAnswerIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.UnitElement
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.ui.units.UnitViewModel.Companion.INITIAL_LAYER
import java.util.UUID

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
    val paragraphs: ClipBoard<ParagraphIO> = ClipBoard.ParagraphsClipBoard(),

    /** clipboard for unit elements */
    val unitElements: ClipBoard<UnitElement> = ClipBoard.UnitElementClipBoard()
) {

    /** initializes clipboard with data fom the local database */
    suspend fun initialize() {
        withContext(Dispatchers.Default) {
            if(unitElements.isEmpty.value) {
                val elements = mutableListOf<UnitElement>()
                elements.addAll(repository.getUnitElementFacts().orEmpty())
                elements.addAll(repository.getUnitElementParagraphs().orEmpty())

                unitElements.copyItems(elements.map {
                    it.apply {
                        layer = INITIAL_LAYER
                    }
                })
            }
        }
    }

    /** Removes all unit elements */
    suspend fun clearUnitElements() {
        withContext(Dispatchers.Default) {
            repository.clearUnitElements()
            unitElements.clear()
        }
    }

    /** copies a single unit element into the DB and clipboard */
    suspend fun copyUnitElement(item: UnitElement) {
        when(item) {
            is UnitElement.Fact -> {
                repository.insertUnitElementFact(
                    item.copy(
                        layer = INITIAL_LAYER,
                        notLastLayers = listOf(INITIAL_LAYER),
                        isLastParagraph = true,
                        data = item.data.copy(
                            uid = UUID.randomUUID().toString()
                        )
                    )
                )
            }
            is UnitElement.Paragraph -> {
                repository.insertUnitElementParagraph(item.copy(
                    layer = INITIAL_LAYER,
                    notLastLayers = listOf(INITIAL_LAYER),
                    data = item.data.copy(
                        uid = UUID.randomUUID().toString()
                    )
                ))
            }
        }
        unitElements.copyItem(item)
    }
}