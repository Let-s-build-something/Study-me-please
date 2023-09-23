package study.me.please.data.io

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Psychology
import androidx.compose.material.icons.outlined.Quiz
import androidx.compose.material.icons.outlined.School
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Types of question modes
 */
enum class QuestionMode(val icon: ImageVector) {
    /** shows description and image before answering and then repeats the same without it */
    LEARNING(Icons.Outlined.School),
    /** fast-pace repeating of questions */
    PRACTICING(Icons.Outlined.Psychology),
    /** perfecting timing, test format and number of mistakes/correct answers */
    TEST(Icons.Outlined.Quiz);
}