package study.me.please.data.io

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.firebase.firestore.Exclude
import com.google.gson.annotations.SerializedName
import study.me.please.data.room.AppRoomDatabase
import java.io.Serializable
import java.util.UUID

@Entity(tableName = AppRoomDatabase.ROOM_QUESTION_ANSWER_TABLE)
data class QuestionAnswerIO (

    /** Answer text to be displayed */
    @Deprecated("Use textList instead")
    var text: String = "",

    /** list of texts */
    var textList: List<String> = listOf(),

    /** What is the reasoniung behind this answer being wrong/correct */
    @SerializedName("explanation_message")
    var explanationMessage: String = "",

    /** list of explanations */
    var explanationList: List<String> = listOf(),

    /** unique identifier */
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString(),

    /** explanation image */
    @SerializedName("image_explanation")
    var imageExplanation: LargePathAsset? = null,

    /** whether this answer is the correct one to a parent prompt */
    @SerializedName("is_correct")
    var isCorrect: Boolean = false,

    /** Whether the prompt is list mode */
    var isListAnswer: Boolean = textList.isNotEmpty(),

    /** The source route of this item */
    val importedSource: ImportedSource? = null
): Serializable {

    /** whether this object has no important data */
    @get:Exclude
    @get:Ignore
    val isEmpty: Boolean
        get() = text.isBlank()
                && textList.none { it.isNotBlank() }
                && explanationMessage.isBlank()

    /** Updates this object with new question */
    fun updateTO(answer: QuestionAnswerIO) {
        this.text = answer.text
        this.textList = answer.textList
        this.explanationList = answer.explanationList
        this.explanationMessage = answer.explanationMessage
        this.imageExplanation = answer.imageExplanation
        this.isCorrect = answer.isCorrect
    }
}