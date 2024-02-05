package study.me.please.ui.units

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
    clipBoard = null,
    isReadOnly = false,
    paragraph = ParagraphIO(
        categoryUid = "1",
        facts = mutableListOf(
            FactIO(
                shortKeyInformation = "Short key information",
                longInformation = "This longInformation isn't correct, due to gramatical error"
            )
        ),
        paragraphs = mutableListOf(
            ParagraphIO(
                categoryUid = "2",
                bulletPoints = mutableListOf(
                    "the spanish map"
                ),
                facts = mutableListOf(
                    FactIO(
                        shortKeyInformation = "Short key information",
                        longInformation = "This longInformation isn't correct, due to gramatical error"
                    ),
                    FactIO(
                        shortKeyInformation = "Short key information",
                        longInformation = "This longInformation isn't correct, due to gramatical error"
                    )
                ),
                paragraphs = mutableListOf(
                    ParagraphIO(
                        categoryUid = "1",
                        facts = mutableListOf(
                            FactIO(
                                shortKeyInformation = "Short key information",
                                longInformation = "This longInformation isn't correct, due to gramatical error"
                            ),
                            FactIO(
                                shortKeyInformation = "Short key information",
                                longInformation = "This longInformation isn't correct, due to gramatical error"
                            )
                        ),
                        paragraphs = mutableListOf(
                            ParagraphIO(
                                categoryUid = "1",
                                facts = mutableListOf(
                                    FactIO(
                                        shortKeyInformation = "Short key information",
                                        longInformation = "This longInformation isn't correct, due to gramatical error"
                                    ),
                                    FactIO(
                                        shortKeyInformation = "Short key information",
                                        longInformation = "This longInformation isn't correct, due to gramatical error"
                                    )
                                ),
                                paragraphs = mutableListOf(
                                    ParagraphIO(
                                        categoryUid = "1",
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
                                    ).apply {
                                        localCategory = CategoryIO(
                                            name = "coconuts",
                                            uid = "2"
                                        )
                                    }
                                )
                            ).apply {
                                localCategory = CategoryIO(
                                    name = "coconuts",
                                    uid = "2"
                                )
                            },
                            ParagraphIO(
                                categoryUid = "1",
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
                            ).apply {
                                localCategory = CategoryIO(
                                    name = "coconuts",
                                    uid = "2"
                                )
                            }
                        )
                    ).apply {
                        localCategory = CategoryIO(
                            name = "coconuts",
                            uid = "2"
                        )
                    }
                )
            ).apply {
                localCategory = CategoryIO(
                    name = "maps",
                    uid = "2"
                )
            },
            ParagraphIO(
                categoryUid = "0",
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
            ).apply {
                localCategory = CategoryIO(
                    name = "sandiwches",
                    uid = "2"
                )
            }
        )
    ).apply {
        localCategory = CategoryIO(
            name = "maps",
            uid = "2"
        )
    },
    updateParagraph = {}
)