package study.me.please.data.io

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import study.me.please.data.room.AppRoomDatabase
import java.io.Serializable
import java.util.UUID

@Entity(tableName = AppRoomDatabase.ROOM_QUESTION_ANSWER_TABLE)
data class QuestionAnswerIO (

    /** Answer text to be displayed */
    var text: String = "",

    /** What is the reasoniung behind this answer being wrong/correct */
    @SerializedName("explanation_message")
    var explanationMessage: String = "",

    /** unique identifier */
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString(),

    /** explanation image */
    @SerializedName("image_explanation")
    var imageExplanation: LargePathAsset? = null,

    /** whether this answer is the correct one to a parent prompt */
    @SerializedName("is_correct")
    var isCorrect: Boolean = false
): Serializable {

    /** whether this object has no important data */
    val isEmpty: Boolean
        get() = text.isEmpty()
            && explanationMessage.isEmpty()
            && imageExplanation?.isEmpty != false
}