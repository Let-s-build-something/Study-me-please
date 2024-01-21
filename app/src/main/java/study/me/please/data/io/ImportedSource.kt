package study.me.please.data.io

import java.io.Serializable

/** Information about source of import */
data class ImportedSource (

    /** Question prompt for user */
    val type: ImportSourceType = ImportSourceType.NONE,

    /** identifier for source */
    val sourceUid: String? = null,

    /** Parent importing source */
    //val parent: ImportedSource? = null TODO
): Serializable