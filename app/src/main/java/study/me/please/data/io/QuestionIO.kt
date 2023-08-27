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
    val prompt: String = "",

    /** Text description answer for the prompt */
    @SerializedName("text_answer")
    val textAnswer: String = "",

    /** Image description answer for the prompt */
    @SerializedName("image_answer_url")
    val imageAnswerUrl: LargePathAsset? = null,

    /** List of options that can be answered */
    val answers: List<QuestionAnswerIO> = listOf(),

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
    var isRepeated: Boolean = false,

    /** path to audio file with prompt */
    @SerializedName("audio_prompt_url")
    val audioPromptUrl: LargePathAsset? = null,

    /** unique identifier */
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString(),

    /** type of this question */
    val type: QuestionPromptType = QuestionPromptType.TEXT_QUESTION
): Serializable