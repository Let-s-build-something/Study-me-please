package study.me.please.data.io

import study.me.please.ui.units.utils.QuestionGenerator
import java.io.Serializable

/** Information about source of import */
data class ImportedSource(

    /** Question prompt for user */
    val type: ImportSourceType = ImportSourceType.NONE,

    /** identifier for source */
    val sourceUid: String? = null,

    /** Parent importing source */
    val parent: ImportedSource? = null,

    /**
     * Reason is an open enum value
     * For question generating, [QuestionGenerator.FactGeneratingGoal] and [QuestionGenerator.UnitGeneratingGoal] is used
     */
    val reason: String? = null
): Serializable