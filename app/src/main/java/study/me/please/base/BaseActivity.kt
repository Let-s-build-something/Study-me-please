package study.me.please.base

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import study.me.please.breeds.BreedsViewModel
import study.me.please.data.io.PsychologyTerm
import study.me.please.data.io.PsychologyTermAnswer
import study.me.please.data.io.Stopwatch
import study.me.please.data.questions.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class BaseActivity: ComponentActivity(), BackboneChannel {

    private var leftAtTime: Long = -1L

    override fun onStop() {
        super.onStop()
        leftAtTime = System.currentTimeMillis()
    }

    override fun onResume() {
        super.onResume()
        if(leftAtTime != -1L) {
            stopWatch.addToTimeStarted(System.currentTimeMillis().minus(leftAtTime))
            leftAtTime = -1
        }
    }

    private val Color.Companion.primary: Color
        get() = Color(0xFF7CBA9A)

    private val Color.Companion.background: Color
        get() = DarkGray

    private val viewModel: BreedsViewModel by viewModels()

    private val stopWatch = Stopwatch()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.dataManager.answerLog.collectLatest {
                    withContext(Dispatchers.Default) {
                        val correctCount = it.count { it.isCorrect }
                        viewModel.dataManager.successRate.value = (correctCount to it.size) to correctCount
                            .toDouble()
                            .div(it.size.toDouble())
                            .times(100)
                    }
                }
            }
        }
        setContent {
            MaterialTheme {
                GetMainScreen()
            }
        }
    }

    private val visibleCategories = hashMapOf(
        1 to (true to PsychologyOne.psychologyPrompts),
        2 to (true to PsychologyTwo.psychologyPrompts),
        3 to (true to PsychologyThree.psychologyPrompts),
        4 to (true to PsychologyFour.psychologyPrompts),
        5 to (true to PsychologyFive.psychologyPrompts),
        6 to (true to PsychologySix.psychologyPrompts),
        7 to (true to PsychologySeven.psychologyPrompts),
        8 to (true to PsychologyNine.psychologyPrompts),
        9 to (true to PsychologyTen.psychologyPrompts),
        10 to (true to PsychologyEight.psychologyPrompts),
        11 to (true to PsychologyEleven.psychologyPrompts),
        12 to (true to PsychologyHandmade.psychologyPrompts),
        13 to (true to PsychologyHandmadeTwo.psychologyPrompts),
        14 to (true to PhilosophyHandmade.philosophyPrompts),
        15 to (true to EthicsHandmade.ethicsPrompts),
        16 to (true to LawHandmade.lawPrompts),
        17 to (true to EconomyHandmade.economyPrompts),
        18 to (true to LogicHandmade.logicPrompts),
    )

    @OptIn(ExperimentalGlideComposeApi::class)
    @SuppressLint("CoroutineCreationDuringComposition")
    @Composable
    fun GetMainScreen() {
        /*var newString = viewModel.dataManager.stringsList
        viewModel.dataManager.answersList.forEach { number, answer ->
            newString = newString.replace("questionNumber = $number,", "questionNumber = $number, correctAnswer = ${
                when(answer) {
                    "a" -> 0
                    "b" -> 1
                    "c" -> 2
                    "d" -> 3
                    else -> -1
                }
            },")
        }*/
        val scope = rememberCoroutineScope()
        var term by remember { mutableStateOf<PsychologyTerm?>(null) }
        var shuffledAnswers by remember { mutableStateOf<List<PsychologyTermAnswer>>(listOf()) }
        val successRate = viewModel.dataManager.successRate.collectAsState()
        val timeElapsed = viewModel.dataManager.timeElapsed.collectAsState()
        var btnContinueVisible by remember { mutableStateOf(false) }
        var showDialog by remember { mutableStateOf(false) }
        var descriptionVisible by remember { mutableStateOf(false) }
        var btnErrorUid by remember { mutableStateOf("") }
        var showOptionReasoning by remember { mutableStateOf(false) }
        var correctAnswerColor by remember { mutableStateOf(Color.DarkGray) }
        val getNewPrompt: () -> Unit = {
            viewModel.dataManager.timeElapsed.update {
                it.plus(stopWatch.reset())
            }
            scope.launch {
                btnContinueVisible = false
                descriptionVisible = false
                btnErrorUid = ""
                showOptionReasoning = false
                correctAnswerColor = Color.DarkGray
                term = viewModel.scriptManager.getNewPrompt()
                shuffledAnswers = term?.answers?.shuffled().orEmpty()
            }
        }
        val flush: (newList: List<PsychologyTerm>?) -> Unit = {
            scope.launch {
                viewModel.scriptManager.flush(it)
                viewModel.dataManager.answerLog.value = listOf()
                viewModel.dataManager.successRate.value = (0 to 0) to 0.0
                viewModel.dataManager.timeElapsed.value = 0L
                getNewPrompt()
            }
        }
        if(term == null) flush(null)
        if(showDialog) {
            var itemChecked = false
            Dialog(
                onDismissRequest = {
                    if(itemChecked) {
                        scope.launch {
                            flush(visibleCategories.filter { it.value.first }.map { it.value.second }.flatten())
                        }
                    }
                    showDialog = false
                }
            ) {
                Surface(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                        .background(Color.background),
                    shape = MaterialTheme.shapes.large
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        LazyColumn(
                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            items(visibleCategories.size) { index ->
                                visibleCategories[index.plus(1)]?.let { item ->
                                    var isChecked by remember { mutableStateOf(item.first) }
                                    Row {
                                        Checkbox(checked = isChecked, onCheckedChange = { response ->
                                            itemChecked = true
                                            visibleCategories[index.plus(1)] = response to item.second
                                            isChecked = response
                                        })
                                        item.second.firstOrNull()?.categoryId?.let {
                                            Text(
                                                text = it,
                                                fontSize = 18.sp,
                                                color = Color.DarkGray,
                                                modifier = Modifier
                                                    .align(CenterVertically)
                                                    .padding(start = 4.dp)
                                                    .clickable(
                                                        indication = rememberRipple(bounded = false),
                                                        interactionSource = remember { MutableInteractionSource() }
                                                    ) {
                                                        itemChecked = true
                                                        visibleCategories[index.plus(1)] =
                                                            isChecked.not() to item.second
                                                        isChecked = isChecked.not()
                                                    }
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.mediumTopAppBarColors(
                        containerColor = Color.primary
                    ),
                    title = {
                        Text(
                            text = "${successRate.value.second.toInt()}% success rate (${successRate.value.first.first}/${successRate.value.first.second}), " +
                                "${timeElapsed.value.div(1000)
                                    .div(kotlin.math.max(1, viewModel.dataManager.answerLog.collectAsState().value.size))}s avg",
                            fontSize = 18.sp,
                            color = Color.DarkGray,
                            lineHeight = 22.sp
                        )
                    },
                    actions = {
                        Icon(
                            Icons.Default.List,
                            contentDescription = "Filter",
                            tint = Color.DarkGray,
                            modifier = Modifier
                                .height(38.dp)
                                .width(38.dp)
                                .clickable(
                                    indication = rememberRipple(bounded = false),
                                    interactionSource = remember { MutableInteractionSource() }
                                ) {
                                    showDialog = true
                                }
                                .padding(end = 6.dp)
                        )
                        Icon(
                            Icons.Default.Refresh,
                            contentDescription = "Clear",
                            tint = Color.DarkGray,
                            modifier = Modifier
                                .height(38.dp)
                                .width(38.dp)
                                .clickable(
                                    indication = rememberRipple(bounded = false),
                                    interactionSource = remember { MutableInteractionSource() }
                                ) {
                                    flush(null)
                                }
                        )
                    }
                )
            },
        ) { contentPadding ->
            ConstraintLayout(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
            ) {
                val (title, lazyColumnOptions, indexText) = createRefs()
                Text(
                    text = term?.prompt ?: "",
                    fontSize = 22.sp,
                    modifier = Modifier
                        .constrainAs(title) {
                            top.linkTo(
                                parent.top,
                                margin = contentPadding
                                    .calculateTopPadding()
                            )
                            linkTo(parent.start, parent.end)
                            width = Dimension.fillToConstraints
                        }
                        .padding(top = 18.dp, start = 12.dp, end = 12.dp, bottom = 12.dp),
                    color = Color.DarkGray,
                    maxLines = 99,
                    softWrap = true,
                    lineHeight = 24.sp
                )
                Text(
                    text = "${viewModel.scriptManager.index.plus(1)} z ${viewModel.scriptManager.size}",
                    fontSize = 22.sp,
                    modifier = Modifier
                        .constrainAs(indexText) {
                            bottom.linkTo(parent.bottom, 12.dp)
                            start.linkTo(parent.start, 12.dp)
                        },
                    color = Color.DarkGray,
                    softWrap = true,
                    lineHeight = 24.sp
                )
                LazyColumn(
                    modifier = Modifier
                        .constrainAs(lazyColumnOptions) {
                            linkTo(
                                title.bottom,
                                parent.bottom,
                                topMargin = 8.dp
                            )
                            linkTo(parent.start, parent.end, endMargin = 8.dp, startMargin = 24.dp)
                            width = Dimension.fillToConstraints
                            height = Dimension.fillToConstraints
                        },
                    horizontalAlignment = Alignment.Start
                ) {
                    item {
                        if(descriptionVisible && term?.textAnswer.isNullOrEmpty().not()) {
                            Text(
                                text = term?.textAnswer ?: "",
                                fontSize = 22.sp,
                                modifier = Modifier
                                    .fillMaxWidth(),
                                color = Color.Gray,
                                lineHeight = 24.sp
                            )
                        }
                        if(term?.imageAnswerUrl.isNullOrEmpty().not() && descriptionVisible) {
                            GlideImage(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight(),
                                model = term?.imageAnswerUrl,
                                contentScale = ContentScale.FillWidth,
                                contentDescription = term?.textAnswer
                            )
                        }
                    }

                    items(term?.answers?.size ?: 0) { index ->
                        val answer = shuffledAnswers.getOrNull(index)
                        val realAnswerIndex = term?.answers?.indexOfFirst { it.uid == answer?.uid }
                        Button(
                            onClick = {
                                if(btnContinueVisible.not()) {
                                    if(term?.isRepeated != true) {
                                        viewModel.logNewAnswer(answer, realAnswerIndex == term?.correctAnswer)
                                    }
                                    btnErrorUid = if(realAnswerIndex != term?.correctAnswer) {
                                        term?.let {
                                            viewModel.scriptManager.injectToPosition(it, 3, true)
                                            viewModel.scriptManager.injectToPosition(it, 10, true)
                                            viewModel.scriptManager.injectToPosition(it, 30)
                                            viewModel.scriptManager.injectToPosition(it, 999999, true)
                                        }
                                        answer?.uid.orEmpty()
                                    }else ""
                                    showOptionReasoning = true
                                    correctAnswerColor = Color(0xff02ad61)
                                    descriptionVisible = true
                                    btnContinueVisible = true
                                }
                            },
                            contentPadding = PaddingValues(
                                start = 20.dp,
                                top = 12.dp,
                                end = 20.dp,
                                bottom = 12.dp
                            ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if(btnErrorUid == answer?.uid) {
                                    Color(0xffe5193a)
                                } else if(realAnswerIndex == term?.correctAnswer) {
                                    correctAnswerColor
                                } else Color.DarkGray,
                                contentColor = Color.White
                            ),
                            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                        ) {
                            Text(answer?.text ?: "")
                        }
                        if(showOptionReasoning && answer?.explanationMessage?.isNotEmpty() == true) {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = answer.explanationMessage,
                                fontSize = 18.sp,
                                color = Color.DarkGray,
                                maxLines = 99,
                                softWrap = true,
                                lineHeight = 20.sp
                            )
                            GlideImage(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight(),
                                model = answer.imageExplanationUrl,
                                contentScale = ContentScale.FillWidth,
                                contentDescription = answer.explanationMessage
                            )
                        }
                    }
                    item {
                        // continuation, buttons
                        if(btnContinueVisible) {
                            Button(
                                shape = MaterialTheme.shapes.large,
                                onClick = {
                                    getNewPrompt()
                                },
                                contentPadding = PaddingValues(
                                    start = 20.dp,
                                    top = 12.dp,
                                    end = 20.dp,
                                    bottom = 12.dp
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentWidth(align = Alignment.End)
                                    .padding(
                                        top = 18.dp,
                                        end = 18.dp,
                                        bottom = if (btnErrorUid.isNotEmpty()) {
                                            18.dp
                                        } else 6.dp
                                    ),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.DarkGray,
                                    contentColor = Color.White
                                )
                            ) {
                                Text(
                                    text = "Continue",
                                )
                            }
                            if(btnErrorUid.isEmpty()) {
                                Button(
                                    shape = MaterialTheme.shapes.large,
                                    onClick = {
                                        term?.let {
                                            viewModel.scriptManager.injectToPosition(it, 6)
                                            viewModel.scriptManager.injectToPosition(it, 16)
                                        }
                                        getNewPrompt()
                                    },
                                    contentPadding = PaddingValues(
                                        start = 20.dp,
                                        top = 12.dp,
                                        end = 20.dp,
                                        bottom = 12.dp
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentWidth(align = Alignment.End)
                                        .padding(
                                            end = 18.dp,
                                            bottom = 18.dp
                                        ),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.DarkGray,
                                        contentColor = Color.White
                                    )
                                ) {
                                    Text(
                                        text = "Continue and repeat",
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onBackPressedExec() {

    }
}