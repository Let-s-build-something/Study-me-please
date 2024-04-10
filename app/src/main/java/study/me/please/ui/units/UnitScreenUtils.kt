package study.me.please.ui.units

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import study.me.please.data.io.FactIO
import study.me.please.data.io.subjects.CategoryIO
import study.me.please.data.io.subjects.ParagraphIO

val paragraphBlockMockDataState = ParagraphBlockState(
    parentLayer = -1,
    categories = mutableStateOf(
        listOf(
            CategoryIO(
                name = "theories",
                uid = "0"
            ),
            CategoryIO(
                name = "pencils",
                uid = "1"
            ),
            CategoryIO(
                name = "maps",
                uid = "2"
            )
        )
    ),
    selectedFact = mutableStateOf(null),
    clipBoard = null,
    paragraph = ParagraphIO(
        categoryUid = "1"
    ).apply {
        localCategory = CategoryIO(
            name = "maps",
            uid = "2"
        )
        facts = mutableListOf(
            FactIO(
                shortKeyInformation = "Short key information",
                longInformation = "This longInformation isn't correct, due to gramatical error"
            )
        )
        paragraphs = mutableListOf(
            ParagraphIO(
                categoryUid = "2",
                bulletPoints = mutableListOf(
                    "the spanish map"
                )
            ).apply {
                localCategory = CategoryIO(
                    name = "maps",
                    uid = "2"
                )
                facts = mutableListOf(
                    FactIO(
                        shortKeyInformation = "Short key information",
                        longInformation = "This longInformation isn't correct, due to gramatical error"
                    ),
                    FactIO(
                        shortKeyInformation = "Short key information",
                        longInformation = "This longInformation isn't correct, due to gramatical error"
                    )
                )
                paragraphs = mutableListOf(
                    ParagraphIO(
                        categoryUid = "1"
                    ).apply {
                        localCategory = CategoryIO(
                            name = "coconuts",
                            uid = "2"
                        )
                        facts = mutableListOf(
                            FactIO(
                                shortKeyInformation = "Short key information",
                                longInformation = "This longInformation isn't correct, due to gramatical error"
                            ),
                            FactIO(
                                shortKeyInformation = "Short key information",
                                longInformation = "This longInformation isn't correct, due to gramatical error"
                            )
                        )
                        paragraphs = mutableListOf(
                            ParagraphIO(
                                categoryUid = "1"
                            ).apply {
                                localCategory = CategoryIO(
                                    name = "coconuts",
                                    uid = "2"
                                )
                                facts = mutableListOf(
                                    FactIO(
                                        shortKeyInformation = "Short key information",
                                        longInformation = "This longInformation isn't correct, due to gramatical error"
                                    ),
                                    FactIO(
                                        shortKeyInformation = "Short key information",
                                        longInformation = "This longInformation isn't correct, due to gramatical error"
                                    )
                                )
                                paragraphs = mutableListOf(
                                    ParagraphIO(
                                        categoryUid = "1",
                                    ).apply {
                                        localCategory = CategoryIO(
                                            name = "coconuts",
                                            uid = "2"
                                        )
                                        facts = mutableListOf(
                                            FactIO(
                                                shortKeyInformation = "Short key information",
                                                longInformation = "This longInformation isn't correct, due to gramatical error"
                                            ),
                                            FactIO(
                                                shortKeyInformation = "Short key information",
                                                longInformation = "This longInformation isn't correct, due to gramatical error"
                                            )
                                        )
                                    }
                                )
                            },
                            ParagraphIO(
                                categoryUid = "1"
                            ).apply {
                                localCategory = CategoryIO(
                                    name = "coconuts",
                                    uid = "2"
                                )
                                facts = mutableListOf(
                                    FactIO(
                                        shortKeyInformation = "Short key information",
                                        longInformation = "This longInformation isn't correct, due to gramatical error"
                                    ),
                                    FactIO(
                                        shortKeyInformation = "Short key information",
                                        longInformation = "This longInformation isn't correct, due to gramatical error"
                                    )
                                )
                            }
                        )
                    }
                )
            },
            ParagraphIO(
                categoryUid = "0"
            ).apply {
                localCategory = CategoryIO(
                    name = "sandiwches",
                    uid = "2"
                )
                facts = mutableListOf(
                    FactIO(
                        shortKeyInformation = "Short key information",
                        longInformation = "This longInformation isn't correct, due to gramatical error"
                    ),
                    FactIO(
                        shortKeyInformation = "Short key information",
                        longInformation = "This longInformation isn't correct, due to gramatical error"
                    ),
                    FactIO(
                        shortKeyInformation = "Short key information",
                        longInformation = "This longInformation isn't correct, due to gramatical error"
                    )
                )
            }
        )
    },
    isReadOnly = false,
    updateParagraph = {},
    bulletPoints = mutableStateListOf(),
    paragraphs = mutableStateListOf(),
    blockStates = listOf(),
    facts = mutableStateListOf(),
    updateFact = {},
    bridge = object: ParagraphBlockBridge {
        override fun addFact(element: UnitsViewModel.ElementToDrag) {}
        override fun removeUiFact(uid: String) {}
        override fun requestFactsPaste() { }
        override fun addParagraph(element: UnitsViewModel.ElementToDrag) {}
        override fun removeUiParagraph(uid: String) {}
        override fun addNewBulletPoint(index: Int, bulletPoint: String?) {}
        override fun removeBulletPoint(index: Int) {}
        override fun updateBulletPoint(index: Int, output: String) {}
        override fun invalidate() {}
    }
)