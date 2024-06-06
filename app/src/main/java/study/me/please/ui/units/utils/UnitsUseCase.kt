package study.me.please.ui.units.utils

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.data.io.subjects.UnitIO
import study.me.please.ui.units.UnitsRepository
import javax.inject.Inject

/** module for working with units */
class UnitsUseCase @Inject constructor(
    private val repository: UnitsRepository
) {

    /** Makes a request to return subjects */
    internal suspend fun getUnitsByCollection(collectionUid: String): List<UnitIO> {
        return withContext(Dispatchers.Default) {
            repository.getUnitsByCollection(collectionUid)?.onEach { unit ->
                if(unit.factUidList.isNotEmpty()) {
                    unit.facts.clear()
                    unit.facts.addAll(
                        repository.getFactsBy(unit.factUidList).orEmpty().sortedBy {
                            unit.factUidList.indexOf(it.uid)
                        }.onEach {
                            if(it.factUidList.isNotEmpty()) {
                                it.facts.clear()
                                it.facts.addAll(
                                    repository.getFactsBy(it.factUidList).orEmpty().sortedBy { sort ->
                                        it.factUidList.indexOf(sort.uid)
                                    }
                                )
                            }
                        }
                    )
                }
                if(unit.paragraphUidList.isNotEmpty()) {
                    unit.paragraphs.clear()
                    unit.paragraphs.addAll(
                        repository.getParagraphsBy(unit.paragraphUidList).orEmpty().sortedBy {
                            unit.paragraphUidList.indexOf(it.uid)
                        }.onEach { paragraph ->
                            if(paragraph.factUidList.isNotEmpty()) {
                                paragraph.facts.clear()
                                paragraph.facts.addAll(
                                    repository.getFactsBy(paragraph.factUidList).orEmpty().sortedBy {
                                        paragraph.factUidList.indexOf(it.uid)
                                    }.onEach {
                                        if(it.factUidList.isNotEmpty()) {
                                            it.facts.clear()
                                            it.facts.addAll(
                                                repository.getFactsBy(it.factUidList).orEmpty().sortedBy { sort ->
                                                    it.factUidList.indexOf(sort.uid)
                                                }
                                            )
                                        }
                                    }
                                )
                            }
                            if(paragraph.paragraphUidList.isNotEmpty()) {
                                paragraph.paragraphs.clear()
                                paragraph.paragraphs.addAll(
                                    repository.getParagraphsBy(paragraph.paragraphUidList)?.sortedBy {
                                        paragraph.factUidList.indexOf(it.uid)
                                    }.orEmpty()
                                )
                            }

                            iterateFurtherAction(paragraph) { iterationParagraph ->
                                if(iterationParagraph.factUidList.isNotEmpty()) {
                                    iterationParagraph.facts.clear()
                                    iterationParagraph.facts.addAll(
                                        repository.getFactsBy(iterationParagraph.factUidList).orEmpty().sortedBy {
                                            iterationParagraph.factUidList.indexOf(it.uid)
                                        }.onEach {
                                            if(it.factUidList.isNotEmpty()) {
                                                it.facts.clear()
                                                it.facts.addAll(
                                                    repository.getFactsBy(it.factUidList).orEmpty().sortedBy { sort ->
                                                        it.factUidList.indexOf(sort.uid)
                                                    }
                                                )
                                            }
                                        }
                                    )
                                }
                                if(iterationParagraph.paragraphUidList.isNotEmpty()) {
                                    iterationParagraph.paragraphs.clear()
                                    iterationParagraph.paragraphs.addAll(
                                        repository.getParagraphsBy(iterationParagraph.paragraphUidList)?.sortedBy {
                                            iterationParagraph.factUidList.indexOf(it.uid)
                                        }.orEmpty()
                                    )
                                }
                            }
                        }
                    )
                }
            }.orEmpty()
        }
    }

    /** iterates into all possible depths */
    private suspend fun iterateFurtherAction(
        paragraph: ParagraphIO,
        action: suspend (ParagraphIO) -> Unit
    ) {
        withContext(Dispatchers.Default) {
            val paragraphsCopy = paragraph.paragraphs.toList()
            paragraphsCopy.forEach { iterationParagraph ->
                action(iterationParagraph)
                iterateFurtherAction(
                    paragraph = iterationParagraph,
                    action = action,
                )
            }
            paragraph.paragraphs = paragraphsCopy.toMutableList()
        }
    }
}