package study.me.please.ui.components.session

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.squadris.squadris.compose.theme.Colors
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.ext.roundOffDecimal
import study.me.please.R
import study.me.please.ui.session.QuestionModule
import java.util.concurrent.TimeUnit

/**
 * Table for displaying statistics about [QuestionModule]
 * @param questionModule module on which statistics are based on
 */
@Composable
fun StatisticsTable(
    modifier: Modifier = Modifier,
    questionModule: QuestionModule,
    backgroundColor: Color = LocalTheme.colors.onBackgroundComponent
) {
    val items = questionModule.history.filter { it.timeOfStart != null && it.wasRepeated.not() }
    val responseTimeAverages = mutableListOf<Long>()
    val successRates = mutableListOf<Double>()
    var iteratedValueSuccessRate = 0.0
    var iteratedValueResponseTime = 0L

    items.forEachIndexed { index, item ->
        if(item.timeOfStart != null) {
            if(item.answers.none { it.isCorrect.not() }) {
                iteratedValueSuccessRate++
            }

            // response time
            iteratedValueResponseTime += item.timeToAnswer.minus(item.timeOfStart)

            responseTimeAverages.add(
                iteratedValueResponseTime.div((index + 1))
            )
            successRates.add(
                (iteratedValueSuccessRate.div((index.toDouble() + 1.0))) * 100.0
            )
        }
    }
    val averageResponseTime = if(items.isNotEmpty()) {
        iteratedValueResponseTime.div(items.size)
    }else 0

    ConstraintLayout(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = LocalTheme.shapes.componentShape
            )
            .padding(12.dp)
    ) {
        val (
            txtTotalTimeSpent,
            txtAverageResponseTime,
            txtSuccessRate,
            layoutResponseGraph,
            layoutSuccessRateGraph
        ) = createRefs()
        Text(
            modifier = Modifier
                .constrainAs(txtTotalTimeSpent) {
                    linkTo(parent.start, parent.end, bias = 0f)
                    top.linkTo(txtSuccessRate.bottom)
                },
            text = stringResource(
                id = R.string.statistics_time_spent_total,
                millisToTimeLapsed(millis = iteratedValueResponseTime),
                items.size
            ),
            style = TextStyle(
                fontSize = 14.sp,
                color = LocalTheme.colors.secondary
            )
        )
        Text(
            modifier = Modifier
                .constrainAs(txtAverageResponseTime) {
                    linkTo(parent.start, parent.end, bias = 0f)
                    top.linkTo(txtTotalTimeSpent.bottom, 2.dp)
                },
            text = stringResource(
                id = R.string.statistics_time_spent_average,
                millisToTimeLapsed(millis = averageResponseTime)
            ),
            style = TextStyle(
                fontSize = 14.sp,
                color = LocalTheme.colors.secondary
            )
        )

        val successResources = getSuccessText(successRates.lastOrNull() ?: 100.0)
        Text(
            modifier = Modifier
                .constrainAs(txtSuccessRate) {
                    linkTo(parent.start, parent.end, bias = 0f)
                    top.linkTo(parent.top)
                },
            text = stringResource(
                id = R.string.statistics_success_rate,
                successResources.first,
                (successRates.lastOrNull() ?: 100.0).roundOffDecimal().toString()
            ),
            style = TextStyle(
                fontSize = 18.sp,
                color = successResources.second,
                fontWeight = FontWeight.Bold
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
private fun getSuccessText(percentageSuccess: Double): Pair<String, Color> {
    return when(percentageSuccess) {
        in GRADE_A1_PERCENTAGE .. 100.0 -> {
            stringResource(id = R.string.grade_a1) to Colors.GREEN_CORRECT
        }
        in GRADE_A2_PERCENTAGE .. GRADE_A1_PERCENTAGE -> {
            stringResource(id = R.string.grade_a2) to Colors.GREEN_CORRECT
        }
        in GRADE_B1_PERCENTAGE .. GRADE_A2_PERCENTAGE -> {
            stringResource(id = R.string.grade_b1) to Colors.YELLOW
        }
        in GRADE_B2_PERCENTAGE .. GRADE_B1_PERCENTAGE -> {
            stringResource(id = R.string.grade_b1) to Colors.YELLOW
        }
        in GRADE_C1_PERCENTAGE .. GRADE_B2_PERCENTAGE -> {
            stringResource(id = R.string.grade_c1) to Colors.YELLOW
        }
        in GRADE_C2_PERCENTAGE .. GRADE_C1_PERCENTAGE -> {
            stringResource(id = R.string.grade_c2) to Colors.ORANGE
        }
        else -> stringResource(id = R.string.grade_d) to Colors.RED_ERROR
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
            history = mutableListOf()
        )
    )
}