package study.me.please.ui.components.session

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.compose.theme.SharedColors
import com.squadris.squadris.ext.roundOffDecimal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import study.me.please.R
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.session.SessionHistoryItem
import study.me.please.data.state.session.QuestionModule
import java.util.concurrent.TimeUnit
import kotlin.math.roundToInt

/**
 * Table for displaying statistics about [QuestionModule]
 * @param questionModule module on which statistics are based on
 */
@Composable
fun StatisticsTable(
    modifier: Modifier = Modifier,
    questionModule: QuestionModule,
    backgroundColor: Color = LocalTheme.current.colors.onBackgroundComponent
) {
    val items = questionModule.history//.filter { it.timeOfStart != null && it.isRepetition.not() }
    val responseTimeAverages = remember { mutableListOf<Long>() }
    val successRates = remember { mutableListOf<Float>() }
    val answeredQuestions = remember { mutableIntStateOf(0) }
    val allQuestions = remember { mutableIntStateOf(0) }
    val responseTime = remember { mutableLongStateOf(0L) }
    val successRate = remember { mutableFloatStateOf(0f) }
    val percentageDone = remember { mutableFloatStateOf(0f) }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.Default) {
            var iteratedValueSuccessRate = 0.0f
            var iteratedValueResponseTime = 0L

            //success rate with no repetitions
            items.filter { !it.isRepetition }.forEachIndexed { index, item ->
                if(item.timeOfStart != null) {
                    if(item.answers.all { answer -> answer.isCorrect }) {
                        iteratedValueSuccessRate++
                    }
                    successRates.add((iteratedValueSuccessRate / (index + 1)) * 100)
                }
            }


            // general response time
            items.forEachIndexed { index, item ->
                if(item.timeOfStart != null) {
                    // response time
                    iteratedValueResponseTime += item.timeToAnswer

                    responseTimeAverages.add(
                        iteratedValueResponseTime.div((index + 1))
                    )
                }
            }

            /*
            * val questionStack = questionModule.questionsStack.filter {
                it.isRepetition.not()
            }.size
            val pastQuestions = questionModule.history.filter { it.isRepetition.not() }.size

            // multiple rounds should start from 0
            answeredQuestions.intValue = if(pastQuestions >= questionStack) {
                questionStack % pastQuestions
            }else pastQuestions

            allQuestions.intValue = questionStack + answeredQuestions.intValue
            */

            answeredQuestions.intValue = questionModule.history.filter { it.isRepetition.not() }.size
            allQuestions.intValue = questionModule.questionsStack.filter {
                it.isRepetition.not()
            }.size + answeredQuestions.intValue
            val lastAnswered = answeredQuestions.intValue % allQuestions.intValue.coerceAtLeast(1)

            responseTime.longValue = iteratedValueResponseTime
            successRate.floatValue = iteratedValueSuccessRate
            percentageDone.floatValue = lastAnswered.toFloat()
                .div(allQuestions.intValue.coerceAtLeast(1).toFloat())
        }
    }
    val averageResponseTime = remember {
        derivedStateOf {
            if(items.isNotEmpty()) {
                responseTime.longValue.div(items.size)
            }else 0
        }
    }

    Column(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = LocalTheme.current.shapes.componentShape
            )
            .padding(12.dp)
    ) {
        val successResources = getSuccessText(successRates.lastOrNull() ?: 100.0f)
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(
                id = R.string.statistics_success_rate,
                successResources.first,
                (successRates.lastOrNull() ?: 100.0f).roundOffDecimal().toString()
            ),
            style = TextStyle(
                fontSize = 18.sp,
                color = successResources.second,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        )
        LinearProgressIndicator(
            modifier = Modifier
                .padding(top = 4.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(0.8f),
            strokeCap = StrokeCap.Round,
            progress = { percentageDone.floatValue },
            trackColor = LocalTheme.current.colors.tetrial,
            color = LocalTheme.current.colors.brandMain
        )
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 4.dp),
            text = stringResource(
                R.string.statistics_progress_percentage,
                percentageDone.floatValue.times(100f).roundToInt().toString()
            ),
            style = TextStyle(
                color = LocalTheme.current.colors.primary,
                fontSize = 14.sp
            )
        )

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(
                id = R.string.statistics_time_spent_total,
                millisToTimeLapsed(millis = responseTime.longValue),
                answeredQuestions.intValue,
                allQuestions.intValue
            ),
            style = TextStyle(
                fontSize = 14.sp,
                color = LocalTheme.current.colors.secondary,
                textAlign = TextAlign.Center
            )
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp),
            text = stringResource(
                id = R.string.statistics_time_spent_average,
                millisToTimeLapsed(millis = averageResponseTime.value)
            ),
            style = TextStyle(
                fontSize = 14.sp,
                color = LocalTheme.current.colors.secondary,
                textAlign = TextAlign.Center
            )
        )
    }
    //TODO https://proandroiddev.com/creating-graph-in-jetpack-compose-312957b11b2
}

private const val GRADE_A1_PERCENTAGE = 90.0
private const val GRADE_A2_PERCENTAGE = 80.0

private const val GRADE_B1_PERCENTAGE = 70.0
private const val GRADE_B2_PERCENTAGE = 60.0

private const val GRADE_C1_PERCENTAGE = 55.0
private const val GRADE_C2_PERCENTAGE = 50.0

@Composable
private fun getSuccessText(percentageSuccess: Float): Pair<String, Color> {
    return when(percentageSuccess) {
        in GRADE_A1_PERCENTAGE .. 100.0 -> {
            stringResource(id = R.string.grade_a1) to SharedColors.GREEN_CORRECT
        }
        in GRADE_A2_PERCENTAGE .. GRADE_A1_PERCENTAGE -> {
            stringResource(id = R.string.grade_a2) to SharedColors.GREEN_CORRECT
        }
        in GRADE_B1_PERCENTAGE .. GRADE_A2_PERCENTAGE -> {
            stringResource(id = R.string.grade_b1) to SharedColors.YELLOW
        }
        in GRADE_B2_PERCENTAGE .. GRADE_B1_PERCENTAGE -> {
            stringResource(id = R.string.grade_b1) to SharedColors.YELLOW
        }
        in GRADE_C1_PERCENTAGE .. GRADE_B2_PERCENTAGE -> {
            stringResource(id = R.string.grade_c1) to SharedColors.YELLOW
        }
        in GRADE_C2_PERCENTAGE .. GRADE_C1_PERCENTAGE -> {
            stringResource(id = R.string.grade_c2) to SharedColors.ORANGE
        }
        else -> stringResource(id = R.string.grade_d) to SharedColors.RED_ERROR
    }
}

@Composable
fun millisToTimeLapsed(millis: Long): String {
    val days: Int = TimeUnit.MILLISECONDS.toDays(millis).toInt()
    val hours: Int = (TimeUnit.MILLISECONDS.toHours(millis) % TimeUnit.DAYS.toHours(1)).toInt()
    val minutes: Int = (TimeUnit.MILLISECONDS.toMinutes(millis) % TimeUnit.HOURS.toMinutes(1)).toInt()
    val seconds: Int = (TimeUnit.MILLISECONDS.toSeconds(millis) % TimeUnit.MINUTES.toSeconds(1)).toInt()

    return (if(days > 0) "${days}d " else "")
        .plus(if(hours > 0) "${hours}h " else "")
        .plus(if(minutes > 0) "${minutes}m " else "")
        .plus(if(seconds > 0) "${seconds}s " else "")
}

@Preview
@Composable
private fun Preview() {
    StatisticsTable(
        questionModule = QuestionModule(
            history = mutableListOf(
                SessionHistoryItem(null, 0, listOf(),
                    timeToAnswer = 0L
                ),
                SessionHistoryItem(null, 0, listOf(), timeToAnswer = 0L),
                SessionHistoryItem(null, 0, listOf(), timeToAnswer = 0L),
            ),
        ).apply {
            questions = listOf(
                QuestionIO(),
                QuestionIO(),
                QuestionIO(),
                QuestionIO(),
                QuestionIO(),
                QuestionIO(),
                QuestionIO(),
            )
        }
    )
}