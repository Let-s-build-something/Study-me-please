package study.me.please.ui.units

import study.me.please.data.io.FactIO
import study.me.please.data.io.subjects.ParagraphIO

val paragraphMockData = ParagraphIO(
    name = "coconuts",
    uid = "1"
).apply {
    facts = mutableListOf(
        FactIO(
            shortKeyInformation = "Short key information",
            longInformation = "This longInformation isn't correct, due to gramatical error"
        )
    )
    paragraphs = mutableListOf(
        ParagraphIO(
            name = "2",
            bulletPoints = mutableListOf(
                "the spanish map"
            )
        ).apply {
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
                    name = "1"
                ).apply {
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
                            name = "1"
                        ).apply {
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
                                    name = "1",
                                ).apply {
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
                            name = "1"
                        ).apply {
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
            name = "0"
        ).apply {
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
}