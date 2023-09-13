package study.me.please.data.io

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import study.me.please.data.room.AppRoomDatabase
import java.io.Serializable
import java.util.UUID

/** question prompt */
@Entity(tableName = AppRoomDatabase.ROOM_QUESTION_TABLE)
data class QuestionIO (

    /** Question prompt for user */
    var prompt: String = "",

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

    /** List of uids of correct answers */
    @SerializedName("correct_answers_uid")
    val correctAnswersUid: List<String> = listOf(),

    /** whether this prompt is repeated for the sake of remembering */
    @SerializedName("is_repeated")
    @Deprecated("Isn't this only a local variable, why are we saving this?")
    var isRepeated: Boolean = false,

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
    val type: QuestionPromptType = QuestionPromptType.TEXT_QUESTION
): Serializable