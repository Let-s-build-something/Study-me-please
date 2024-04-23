package study.me.please.data.io

import androidx.room.Entity
import androidx.room.PrimaryKey
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.data.room.AppRoomDatabase
import java.io.Serializable
import java.util.UUID

/** element within unit */
sealed class UnitElement(
    open var layer: Int,
    open val notLastLayers: List<Int>
) {

    /** paragraph container with its own paragraphs and facts */
    @Entity(tableName = AppRoomDatabase.ROOM_UNIT_ELEMENT_PARAGRAPH)
    data class Paragraph(
        val data: ParagraphIO,
        override var layer: Int = 0,
        override val notLastLayers: List<Int> = listOf(),
    ): UnitElement(layer, notLastLayers), Serializable {

        /** returns uid of class instance */
        @PrimaryKey
        var elementUid: String = UUID.randomUUID().toString()
    }

    /** fact with simple information within */
    @Entity(tableName = AppRoomDatabase.ROOM_UNIT_ELEMENT_FACT)
    data class Fact(
        val data: FactIO,
        val parentUid: String = "",
        val isLastParagraph: Boolean = false,
        override var layer: Int = 0,
        override val notLastLayers: List<Int> = listOf(),
    ): UnitElement(layer, notLastLayers), Serializable {

        /** returns uid of class instance */
        @PrimaryKey
        var elementUid: String = UUID.randomUUID().toString()
    }

    /** returns uid of either [FactIO] or [ParagraphIO] */
    val uid: String
        get() = when(this) {
            is Paragraph -> data.uid
            is Fact -> data.uid
        }
}