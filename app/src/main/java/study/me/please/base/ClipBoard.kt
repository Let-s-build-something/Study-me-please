package study.me.please.base

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.FactIO
import study.me.please.data.io.QuestionAnswerIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.data.io.UnitElement
import java.util.UUID

sealed class ClipBoard<T: Any>(val list: SnapshotStateList<T> = mutableStateListOf()) {

    /** returns whether clipboard is empty */
    val isEmpty = derivedStateOf {
        list.isEmpty()
    }

    /** clears current backstack */
    fun clear() {
        list.clear()
    }

    /** pastes current backstack of copied data */
    fun paste(): List<T> {
        val listToPaste = list.toList()
        list.clear()
        return listToPaste
    }

    /** copies a list of items into the backstack */
    open suspend fun copyItems(items: List<T>) {
        clear()
    }

    /** copies single item into the backstack */
    open fun copyItem(item: T) {
        list.add(item)
    }
    
    class CollectionClipBoard: ClipBoard<CollectionIO>() {
        override suspend fun copyItems(items: List<CollectionIO>) {
            withContext(Dispatchers.Default) {
                list.addAll(
                    items.map {
                        it.copy(
                            uid = UUID.randomUUID().toString(),
                        )
                    }
                )
            }
        }
    }
    class QuestionClipBoard: ClipBoard<QuestionIO>() {
        override suspend fun copyItems(items: List<QuestionIO>) {
            withContext(Dispatchers.Default) {
                list.addAll(
                    items.map {
                        it.copy(
                            uid = UUID.randomUUID().toString(),
                            answers = it.answers.map { answer -> answer.copy(uid = UUID.randomUUID().toString()) }
                                .toMutableList()
                        )
                    }
                )
            }
        }
    }
    class AnswerClipBoard: ClipBoard<QuestionAnswerIO>() {
        override suspend fun copyItems(items: List<QuestionAnswerIO>) {
            withContext(Dispatchers.Default) {
                list.addAll(
                    items.map {
                        it.copy(
                            uid = UUID.randomUUID().toString(),
                            isCorrect = false
                        )
                    }
                )
            }
        }
    }

    class FactClipBoard: ClipBoard<FactIO>() {
        override suspend fun copyItems(items: List<FactIO>) {
            withContext(Dispatchers.Default) {
                list.addAll(
                    items.map {
                        it.copy(
                            uid = UUID.randomUUID().toString()
                        )
                    }
                )
            }
        }
    }

    class ParagraphsClipBoard: ClipBoard<ParagraphIO>() {
        override suspend fun copyItems(items: List<ParagraphIO>) {
            withContext(Dispatchers.Default) {
                list.addAll(
                    items.map {
                        it.copy(
                            uid = UUID.randomUUID().toString()
                        )
                    }
                )
            }
        }
    }

    class UnitElementClipBoard: ClipBoard<UnitElement>() {
        override suspend fun copyItems(items: List<UnitElement>) {
            withContext(Dispatchers.Default) {
                list.addAll(
                    items.map {
                        when(it) {
                            is UnitElement.Fact -> {
                                UnitElement.Fact(
                                    data = it.data.copy(
                                        uid = UUID.randomUUID().toString()
                                    ),
                                    parentUid = it.parentUid,
                                    isLastParagraph = it.isLastParagraph,
                                    layer = it.layer,
                                    notLastLayers = it.notLastLayers
                                )
                            }
                            is UnitElement.Paragraph -> {
                                UnitElement.Paragraph(
                                    data = it.data.copy(
                                        uid = UUID.randomUUID().toString()
                                    ),
                                    layer = it.layer,
                                    notLastLayers = it.notLastLayers
                                )
                            }
                        }
                    }
                )
            }
        }

        /** copies a single item */
        suspend fun pasteItem(uid: String): Boolean {
            return withContext(Dispatchers.Default) {
                list.removeIf { it.uid == uid }
            }
        }
    }
}