package study.me.please.data.io

import androidx.room.PrimaryKey
import study.me.please.data.io.subjects.ParagraphIO
import java.util.UUID

/** element within unit */
sealed class UnitElement(
    open var layer: Int,
    open val notLastLayers: List<Int>
) {

    /** paragraph container with its own paragraphs and facts */
    data class Paragraph(
        val data: ParagraphIO,
        override var layer: Int = 0,
        override val notLastLayers: List<Int> = listOf(),
    ): UnitElement(layer, notLastLayers) {

        /** returns uid of class instance */
        @PrimaryKey
        var elementUid: String = UUID.randomUUID().toString()

        override fun toString(): String {
            return "{" +
                    "${super.toString()}, " +
                    "$layer," +
                    "$data," +
                    "$notLastLayers, " +
                    "$uid, " +
                    "}"
        }
    }

    /** fact with simple information within */
    data class Fact(
        val data: FactIO,
        val parentUid: String = "",
        val innerIndex: Int = 0,
        val isLastParagraph: Boolean = false,
        val isNested: Boolean = false,
        val isLast: Boolean = false,
        override var layer: Int = 0,
        override val notLastLayers: List<Int> = listOf(),
    ): UnitElement(layer, notLastLayers) {

        /** returns uid of class instance */
        @PrimaryKey
        var elementUid: String = UUID.randomUUID().toString()

        override fun toString(): String {
            return "{" +
                    "layer: $layer," +
                    "data: $data," +
                    "innerIndex: $innerIndex," +
                    "isNested: $isNested," +
                    "parentUid: $parentUid," +
                    "isLastParagraph: $isLastParagraph" +
                    "notLastLayers: $notLastLayers, " +
                    "uid: $uid, " +
                    "}"
        }
    }

    /** returns uid of either [FactIO] or [ParagraphIO] */
    val uid: String
        get() = when(this) {
            is Paragraph -> data.uid
            is Fact -> data.uid
        }

    override fun toString(): String {
        return "{" +
                "$layer," +
                "$notLastLayers, " +
                "$uid, " +
                "}"
    }
}