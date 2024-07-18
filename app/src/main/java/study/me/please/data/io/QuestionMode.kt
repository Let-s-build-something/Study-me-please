package study.me.please.data.io

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Psychology
import androidx.compose.material.icons.outlined.Quiz
import androidx.compose.material.icons.outlined.School
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.room.Ignore
import com.google.firebase.firestore.Exclude
import study.me.please.data.io.preferences.PreferenceOption

/**
 * Types of question modes
 */
enum class QuestionMode(
    val icon: ImageVector,
    val preferenceOptions: Set<PreferenceOption>
) {

    /** shows description and image before answering and then repeats the same without it */
    LEARNING(
        Icons.Outlined.School,
        preferenceOptions = setOf(
            PreferenceOption.WaitForCorrectAnswer
        )
    ),

    /** fast-pace repeating of questions */
    PRACTICING(
        Icons.Outlined.Psychology,
        preferenceOptions = setOf(
            PreferenceOption.RepeatOnMistake
        )
    ),

    /** perfecting timing, test format and number of mistakes/correct answers */
    TEST(
        Icons.Outlined.Quiz,
        preferenceOptions = setOf(
            PreferenceOption.ManualValidation
        )
    );


    /** returns a map of values and options */
    @get:Exclude
    @get:Ignore
    val optionsMap: HashMap<PreferenceOption, Boolean>
        get() = preferenceOptions.associateWith { true }.plus(
            PreferenceOption.entries.filter { it !in preferenceOptions }.associateWith { false }
        ) as HashMap<PreferenceOption, Boolean>
}