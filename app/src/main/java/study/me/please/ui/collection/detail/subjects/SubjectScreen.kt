package study.me.please.ui.collection.detail.subjects

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.squadris.squadris.compose.components.input.EditFieldInput
import com.squadris.squadris.compose.theme.Colors
import com.squadris.squadris.compose.theme.LocalTheme
import study.me.please.R
import study.me.please.base.LocalIsTablet
import study.me.please.data.io.FactIO
import study.me.please.data.io.subjects.CategoryIO
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.data.io.subjects.SubjectIO
import study.me.please.ui.components.ComponentHeaderButton
import study.me.please.ui.components.EditFieldItemPicker
import study.me.please.ui.components.ExpandableContent
import study.me.please.ui.components.FactCard

private const val MAX_LENGTH_SHORT_TEXT = 24

/**
 * Detail of a subject specific to a collection
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SubjectScreen(
    subject: SubjectIO,
    viewModel: SubjectsViewModel = hiltViewModel()
) {
    val categories = viewModel.categories.collectAsState()

    val focusManager = LocalFocusManager.current
    val localDensity = LocalDensity.current
    val configuration = LocalConfiguration.current

    val isLandScape = configuration.layoutDirection == Configuration.ORIENTATION_LANDSCAPE
            || LocalIsTablet.current

    val addContentVisible = remember(subject) { mutableStateOf(false) }
    val subjectBulletPoints = remember {
        mutableStateListOf(*subject.bulletPoints.toTypedArray())
    }
    val subjectParagraphs = remember(subject) {
        mutableStateListOf(*subject.paragraphs.toTypedArray())
    }

    val bridge = remember {
        object: SubjectScreenBridge {
            override fun updateSubjectBulletPoints() {
                subject.bulletPoints = subjectBulletPoints.toMutableList()
                viewModel.updateSubject(subject)
            }
            override fun updateParagraph(paragraph: ParagraphIO) {
                viewModel.updateParagraph(subject, newParagraph = paragraph)
            }
            override fun addSubjectParagraph() {
                subjectParagraphs.add(0, ParagraphIO())
            }
            override fun addSubjectBulletPoint() {
                subjectBulletPoints.add(0, " ")
            }
        }
    }

    LaunchedEffect(subjectBulletPoints.size) {
        addContentVisible.value = false
        bridge.updateSubjectBulletPoints()
    }
    LaunchedEffect(subjectParagraphs.size) {
        addContentVisible.value = false
        subject.paragraphs = subjectParagraphs
        viewModel.updateSubject(subject)
    }

    // TODO deleting by dragging -> then a dialog
    // TODO FAB/button in each block - opens a menu of types of data that can be added via either drag or click
    // TODO bulletin questions with minimal points but ability to add more if not understood

    Scaffold(
        contentColor = Color.Transparent,
        containerColor = Color.Transparent,
        floatingActionButton = {
            AnimatedVisibility(
                visible = addContentVisible.value.not(),
                enter = slideInHorizontally(initialOffsetX = { it }),
                exit = slideOutHorizontally(targetOffsetX = { it }),
            ) {
                FloatingActionButton(
                    modifier = Modifier.padding(bottom = 64.dp),
                    containerColor = LocalTheme.colors.tetrial,
                    contentColor = LocalTheme.colors.brandMain,
                    onClick = {
                        addContentVisible.value = true
                    }
                ) {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        imageVector = Icons.Outlined.Add,
                        contentDescription = stringResource(R.string.accessibility_add_content)
                    )
                }
            }
        }
    ) {
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTapGestures(onTap = {
                        focusManager.clearFocus()
                        addContentVisible.value = false
                    })
                },
            columns = GridCells.Fixed(if(isLandScape) 2 else 1),
            horizontalArrangement = if(isLandScape) Arrangement.spacedBy(4.dp) else Arrangement.Start
        ) {
            item(span = { GridItemSpan(if(isLandScape) 2 else 1) }) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    EditFieldInput(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .widthIn(min = TextFieldDefaults.MinWidth)
                            .height(with(localDensity) {
                                LocalTheme.styles.heading.fontSize.value.sp
                                    .toDp()
                                    .plus(16.dp)
                            }),
                        value = subject.name.ifEmpty { stringResource(R.string.subject_heading_hint) },
                        textStyle = LocalTheme.styles.heading,
                        isUnfocusedTransparent = true,
                        hint = stringResource(id = R.string.subject_heading_hint),
                        maxLines = 1,
                        minLines = 1,
                        paddingValues = PaddingValues(horizontal = 8.dp),
                        maxLength = MAX_LENGTH_SHORT_TEXT,
                        onValueChange = { output ->
                            subject.name = output
                            viewModel.updateSubject(subject)
                        }
                    )
                }
            }
            item(span = { GridItemSpan(if(isLandScape) 2 else 1) }) {
                AnimatedVisibility(visible = addContentVisible.value) {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        ComponentHeaderButton(
                            modifier = Modifier.fillMaxWidth(0.45f),
                            text = stringResource(R.string.subject_add_bullet_point),
                            onClick = {
                                bridge.addSubjectBulletPoint()
                            }
                        )
                    }
                }
            }
            itemsIndexed(subjectBulletPoints) { index, point ->
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    EditFieldInput(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .wrapContentWidth()
                            .widthIn(min = TextFieldDefaults.MinWidth),
                        value = point,
                        prefix = {
                            Box(
                                modifier = Modifier.fillMaxHeight(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "\u2022\t\t",
                                    style = LocalTheme.styles.category
                                )
                            }
                        },
                        textStyle = LocalTheme.styles.category,
                        isUnfocusedTransparent = true,
                        maxLines = 5,
                        minLines = 1,
                        paddingValues = PaddingValues(horizontal = 8.dp),
                        onValueChange = { output ->
                            if(output.isBlank()) {
                                subjectBulletPoints.removeAt(index)
                            }else {
                                subjectBulletPoints.removeAt(index)
                                subjectBulletPoints.add(index, output)
                                bridge.updateSubjectBulletPoints()
                            }
                        }
                    )
                }
            }
            item(span = { GridItemSpan(if(isLandScape) 2 else 1) }) {
                AnimatedVisibility(visible = addContentVisible.value) {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        ComponentHeaderButton(
                            modifier = Modifier.fillMaxWidth(0.45f),
                            text = stringResource(R.string.subject_add_paragraph),
                            onClick = {
                                bridge.addSubjectParagraph()
                            }
                        )
                    }
                }
            }
            itemsIndexed(
                subjectParagraphs,
                key = { _, paragraph -> paragraph.uid }
            ) { index, paragraph ->
                ParagraphBlock(
                    categories = categories.value.orEmpty(),
                    addNewCategory = { name ->
                        viewModel.addNewCategory(name = name)
                    },
                    paragraph = paragraph,
                    onNewCategoryChosen = { chosenCategory ->
                        subjectParagraphs.getOrNull(index)?.apply {
                            localCategory = chosenCategory
                            bridge.updateParagraph(this)
                        }
                    },
                    bridge = bridge,
                    addContentVisible = addContentVisible,
                    parentLayer = -1
                )
            }
            item {
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

private const val PARAGRAPH_MIN_HEIGHT_DP = 210

@Composable
private fun ParagraphBlock(
    parentLayer: Int,
    categories: List<CategoryIO>,
    paragraph: ParagraphIO,
    addNewCategory: (name: String) -> Unit,
    addContentVisible: MutableState<Boolean>,
    bridge: SubjectScreenBridge,
    onNewCategoryChosen: (category: CategoryIO) -> Unit
) {
    val localDensity = LocalDensity.current

    val nestedBulletPoints = remember(paragraph) {
        mutableStateListOf(*paragraph.bulletPoints.toTypedArray())
    }
    val nestedFacts = remember(paragraph) {
        mutableStateListOf(*paragraph.facts.toTypedArray())
    }
    val nestedParagraphs = remember(paragraph) {
        mutableStateListOf(*paragraph.paragraphs.toTypedArray())
    }

    LaunchedEffect(nestedBulletPoints.size) {
        addContentVisible.value = false
        paragraph.bulletPoints = nestedBulletPoints
        bridge.updateParagraph(paragraph)
    }
    LaunchedEffect(nestedFacts.size) {
        addContentVisible.value = false
        paragraph.facts = nestedFacts
        bridge.updateParagraph(paragraph)
    }
    LaunchedEffect(nestedParagraphs.size) {
        addContentVisible.value = false
        paragraph.paragraphs = nestedParagraphs
        bridge.updateParagraph(paragraph)
    }

    ExpandableContent(
        modifier = Modifier.padding(
            top = 8.dp,
            start = if(parentLayer >= 0) 8.dp else 0.dp
        ),
        text = paragraph.localCategory?.name ?: "",
        collapsedContent = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if(parentLayer >= 0) {
                    val identification = getLayerIdentification(parentLayer)
                    Text(
                        modifier = Modifier.padding(end = 6.dp),
                        text = identification.first,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = identification.second
                        )
                    )
                }
                EditFieldItemPicker(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .zIndex(1f),
                    values = categories,
                    defaultValue = paragraph.localCategory?.name ?: "",
                    onValueChosen = onNewCategoryChosen,
                    hint = stringResource(R.string.subject_categorize_paragraph),
                    onEmptyStateClicked = { inputValue ->
                        addNewCategory(inputValue)
                    }
                )
            }
        },
        defaultValue = true
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = PARAGRAPH_MIN_HEIGHT_DP.dp)
                .border(
                    width = 2.dp,
                    shape = RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomStart = LocalTheme.shapes.componentCornerRadius,
                        bottomEnd = LocalTheme.shapes.componentCornerRadius
                    ),
                    color = LocalTheme.colors.onBackgroundComponent
                )
                .padding(bottom = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(LocalTheme.shapes.betweenItemsSpace.times(2)))
            // bullet points
            AnimatedVisibility(visible = addContentVisible.value) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    ComponentHeaderButton(
                        modifier = Modifier.fillMaxWidth(0.45f),
                        text = stringResource(R.string.subject_add_bullet_point),
                        onClick = {
                            nestedBulletPoints.add(0, " ")
                        }
                    )
                }
            }
            nestedBulletPoints.forEachIndexed { index, point ->
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    EditFieldInput(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .wrapContentWidth()
                            .widthIn(min = TextFieldDefaults.MinWidth)
                            .height(with(localDensity) {
                                LocalTheme.styles.category.fontSize.value.sp
                                    .toDp()
                                    .plus(16.dp)
                            }),
                        value = point,
                        prefix = {
                            Text(
                                text = "\u2022\t\t",
                                style = LocalTheme.styles.category
                            )
                        },
                        textStyle = LocalTheme.styles.category,
                        isUnfocusedTransparent = true,
                        maxLines = 5,
                        minLines = 1,
                        paddingValues = PaddingValues(horizontal = 8.dp),
                        onValueChange = { output ->
                            if(output.isBlank()) {
                                nestedBulletPoints.removeAt(index)
                            }else {
                                nestedBulletPoints.removeAt(index)
                                nestedBulletPoints.add(index, output)
                            }
                        }
                    )
                }
            }

            // FACTS
            AnimatedVisibility(visible = addContentVisible.value) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    ComponentHeaderButton(
                        modifier = Modifier.fillMaxWidth(0.45f),
                        text = stringResource(R.string.subject_add_fact),
                        onClick = {
                            nestedFacts.add(0, FactIO())
                        }
                    )
                }
            }
            nestedFacts.forEachIndexed { index, fact ->
                FactCard(
                    modifier = Modifier.padding(8.dp),
                    data = fact,
                    requestDataSave = { newFact ->
                        nestedFacts.removeAt(index)
                        nestedFacts.add(index, newFact)
                    }
                )
            }

            // PARAGRAPHS
            AnimatedVisibility(visible = addContentVisible.value) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    ComponentHeaderButton(
                        modifier = Modifier.fillMaxWidth(0.45f),
                        text = stringResource(R.string.subject_add_paragraph),
                        onClick = {
                            nestedParagraphs.add(0, ParagraphIO())
                        }
                    )
                }
            }
            nestedParagraphs.forEachIndexed { index, nestedParagraph ->
                ParagraphBlock(
                    categories = categories,
                    addNewCategory = addNewCategory,
                    paragraph = nestedParagraph,
                    onNewCategoryChosen = { chosenCategory ->
                        nestedParagraphs.getOrNull(index)?.apply {
                            localCategory = chosenCategory
                            bridge.updateParagraph(this)
                        }
                    },
                    addContentVisible = addContentVisible,
                    bridge = bridge,
                    parentLayer = parentLayer.plus(1)
                )
            }
        }
    }
}

/** Returns text with its color based on the layer depth */
@Composable
private fun getLayerIdentification(layerDepth: Int): Pair<String, Color> {
    val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()
    val colors = listOf(
        Colors.PALETTE_YELLOW,
        Colors.PALETTE_BLUE_LIGHT,
        Colors.PALETTE_ORANGE,
        Colors.PALETTE_GREEN
    )

    val decimalRes = layerDepth.div(alphabet.size.coerceAtLeast(1))
    val res = layerDepth % alphabet.size

    val color = colors.getOrNull((if(decimalRes > 0) decimalRes else res) % colors.size)

    return (if(decimalRes > 0) {
        alphabet.getOrNull(decimalRes).toString() + res.toString()
    } else alphabet.getOrNull(res)?.toString() ?: "") to (color ?: Colors.GREEN_CORRECT)
}