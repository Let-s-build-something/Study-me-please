package study.me.please.base.navigation

import kotlin.reflect.KClass

/** Navigation destinations within notepad */
sealed class NavigationNotepadScreen<T>(
    override val identification: String,
    override val argumentKClass: KClass<T>? = null
): NavigationNode<T>(identification, argumentKClass) where T: Any {

    /** screen for subject detail with user's main notes for certain collection */
    object Paragraph: NavigationNotepadScreen<Paragraph.ParagraphArgument>(
        identification = "paragraph",
        argumentKClass = ParagraphArgument::class
    ) {
        /** Argument for paragraph screen */
        data class ParagraphArgument(

            /** unique identifier for the paragraph to be displayed */
            val paragraphUid: String,

            /** unique identifier for specific fact */
            val factUid: String = ""
        )
    }

    /** screen for subject detail with user's main notes for certain collection */
    object Unit: NavigationNotepadScreen<Unit.UnitArgument>(
        identification = "unit",
        argumentKClass = UnitArgument::class
    ) {

        /** Argument for unit screen */
        data class UnitArgument(
            /** unique identifier for the unit */
            val unitUid: String
        )
    }
}