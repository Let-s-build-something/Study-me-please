package study.me.please.data.io

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.squadris.squadris.utils.DateUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.data.room.AppRoomDatabase
import java.io.Serializable
import java.util.Date
import java.util.UUID

/** question prompt */
@Entity(tableName = AppRoomDatabase.ROOM_QUESTION_TABLE)
data class QuestionIO (

    /** Question prompt for user */
    var prompt: String = "",

    /** In case we are asking multiple points */
    var promptList: List<String> = listOf(),

    /** further explanation of this question */
    @SerializedName("text_explanation")
    var textExplanation: String = "",

    /** image explanation of this question */
    @SerializedName("image_explanation_url")
    var imageExplanationUrl: LargePathAsset? = null,

    /** List of options that can be answered */
    var answers: MutableList<QuestionAnswerIO> = mutableListOf(),

    /** Number of question from workbook */
    @SerializedName("question_number")
    val questionNumber: Int = -1,

    /** User input for where this question originates from */
    @SerializedName("category_name")
    val categoryName: String = "",

    /** path to audio file with prompt */
    @SerializedName("audio_prompt_url")
    val audioPromptUrl: LargePathAsset? = null,

    /** path to video file with prompt */
    @SerializedName("video_prompt_url")
    val videoPromptUrl: LargePathAsset? = null,

    /** path to image file with prompt */
    @SerializedName("image_prompt_url")
    var imagePromptUrl: LargePathAsset? = null,

    /** unique identifier */
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString(),

    /** type of this question */
    val type: QuestionPromptType = QuestionPromptType.TEXT_QUESTION,

    /** source of importation if any */
    var importedSource: ImportedSource = ImportedSource(),

    /** date of creation of this data object */
    @SerializedName("date_created")
    @ColumnInfo("date_created")
    val dateCreated: Long = DateUtils.now.timeInMillis
): Serializable