package study.me.please.ui.collection.detail.subjects

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
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
import androidx.compose.runtime.saveable.rememberSaveable
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
import study.me.please.data.io.FactType
import study.me.please.data.io.subjects.CategoryIO
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.data.io.subjects.SubjectIO
import study.me.please.ui.components.ComponentHeaderButton
import study.me.please.ui.components.EditFieldItemPicker
import study.me.please.ui.components.ExpandableContent
import study.me.please.ui.components.FactCard
import study.me.please.ui.components.ListItemEditField
import study.me.please.ui.components.OptionsLayout

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

    val addContentVisible = rememberSaveable { mutableStateOf(false) }
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
                addContentVisible.value = false
                subjectParagraphs.add(0, ParagraphIO())
            }
            override fun addSubjectBulletPoint() {
                addContentVisible.value = false
                subjectBulletPoints.add(0, " ")
            }
        }
    }

    LaunchedEffect(subjectBulletPoints.size) {
        bridge.updateSubjectBulletPoints()
    }
    LaunchedEffect(subjectParagraphs.size) {
        subject.paragraphs = subjectParagraphs
        viewModel.updateSubject(subject)
    }

    // TODO deleting by dragging -> then a dialog
    // TODO FAB/button in each block - opens a menu of types of data that can be added via either drag or click
    // TODO bulletin questions with minimal points but ability to add more if not understood

    Scaffold(
        modifier = Modifier.animateContentSize(),
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
        val showButtonParagraphsUp = subjectParagraphs.size == 0 || subjectBulletPoints.size == 0

        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTapGestures(onTap = {
                        focusManager.clearFocus()
                        addContentVisible.value = false
                    })
                }
                .animateContentSize(),
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
                        value = subject.name,
                        textStyle = LocalTheme.styles.heading,
                        isUnfocusedTransparent = true,
                        hint = stringResource(id = R.string.subject_heading_prefix),
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
                AnimatedVisibility(
                    modifier = (if(showButtonParagraphsUp.not()) Modifier.fillMaxWidth()
                    else Modifier.fillMaxWidth(0.45f)).padding(horizontal = 16.dp),
                    visible = addContentVisible.value
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = if(showButtonParagraphsUp) {
                            Arrangement.spacedBy(8.dp)
                        }else Arrangement.Center
                    ) {
                        ButtonAddBulletPoint(
                            modifier = if(showButtonParagraphsUp) Modifier.weight(1f)
                            else Modifier.fillMaxWidth(0.45f),
                            onClick = { bridge.addSubjectBulletPoint() }
                        )
                        AnimatedVisibility(
                            modifier = Modifier.weight(1f),
                            visible = subjectParagraphs.size == 0
                        ) {
                            ButtonAddParagraph(
                                modifier = Modifier.weight(1f),
                                onClick = { bridge.addSubjectParagraph() }
                            )
                        }
                    }
                }
            }
            itemsIndexed(subjectBulletPoints) { index, point ->
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    ListItemEditField(
                        prefix = FactType.BULLET_POINT_PREFIX,
                        value = point,
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
                AnimatedVisibility(visible = addContentVisible.value && showButtonParagraphsUp.not()) {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        ButtonAddParagraph(
                            modifier = Modifier.fillMaxWidth(0.45f),
                            onClick = { bridge.addSubjectParagraph() }
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
        paragraph.bulletPoints = nestedBulletPoints
        bridge.updateParagraph(paragraph)
    }
    LaunchedEffect(nestedFacts.size) {
        paragraph.facts = nestedFacts
        bridge.updateParagraph(paragraph)
    }
    LaunchedEffect(nestedParagraphs.size) {
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
            val showButtonFactUp = nestedFacts.size == 0 || nestedBulletPoints.size == 0
            val showButtonParagraphsUp = nestedParagraphs.size == 0 || nestedFacts.size == 0

            Spacer(modifier = Modifier.height(LocalTheme.shapes.betweenItemsSpace.times(2)))

            // bullet points
            AnimatedVisibility(
                modifier = Modifier.fillMaxWidth(),
                visible = addContentVisible.value
            ) {
                Row(
                    modifier = (if(showButtonFactUp.not() && showButtonParagraphsUp.not()) {
                        Modifier.fillMaxWidth(0.45f)
                    }else Modifier.fillMaxWidth()).padding(horizontal = 16.dp),
                    horizontalArrangement = if(showButtonFactUp.not() && showButtonParagraphsUp.not()) {
                        Arrangement.Center
                    }else Arrangement.spacedBy(8.dp)
                ) {
                    ButtonAddBulletPoint(
                        modifier = if(showButtonFactUp.not() && showButtonParagraphsUp.not()) {
                            Modifier.fillMaxWidth(0.45f)
                        }else Modifier.weight(1f),
                        onClick = {
                            addContentVisible.value = false
                            nestedBulletPoints.add(0, " ")
                        }
                    )
                    AnimatedVisibility(
                        modifier = Modifier.weight(1f),
                        visible = showButtonFactUp
                    ) {
                        ButtonAddFact(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                addContentVisible.value = false
                                nestedFacts.add(0, FactIO())
                            }
                        )
                    }
                    AnimatedVisibility(
                        modifier = Modifier.weight(1f),
                        visible = showButtonParagraphsUp
                    ) {
                        ButtonAddParagraph(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                addContentVisible.value = false
                                nestedParagraphs.add(0, ParagraphIO())
                            }
                        )
                    }
                }
            }
            nestedBulletPoints.forEachIndexed { index, point ->
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    ListItemEditField(
                        prefix = FactType.BULLET_POINT_PREFIX,
                        value = point,
                        onValueChange = { output ->
                            addContentVisible.value = false
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
            AnimatedVisibility(visible = addContentVisible.value && showButtonFactUp.not()) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    ButtonAddFact(
                        modifier = Modifier.fillMaxWidth(0.45f),
                        onClick = {
                            addContentVisible.value = false
                            nestedFacts.add(0, FactIO())
                        }
                    )
                }
            }

            /* TODO controlling of facts
            OptionsLayout(
                onCopyRequest = {
                    controller.copyItems()
                },
                onPasteRequest = {
                    viewModel.pasteFactsClipBoard()
                    controller.stopChecking()
                },
                onDeleteRequest = {
                    showDeleteDialog.value = true
                },
                onSelectAll = {
                    interactiveStates.forEach {
                        it.isChecked.value = true
                    }
                },
                onDeselectAll = {
                    controller.selectedFactUids.clear()
                },
                isEditMode = controller.selectedFactUids.size > 0,
                hasPasteOption = viewModel.clipBoard.facts.isEmpty.value.not(),
                animateTopDown = false
            )*/
            nestedFacts.forEach {fact ->
                FactCard(
                    modifier = Modifier.padding(8.dp),
                    data = fact,
                    requestDataSave = { newFact ->
                        addContentVisible.value = false
                        paragraph.facts.find { it.uid == newFact.uid }?.updateTO(newFact)
                        bridge.updateParagraph(paragraph)
                    }
                )
            }

            // PARAGRAPHS
            AnimatedVisibility(visible = addContentVisible.value && showButtonParagraphsUp.not()) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    ButtonAddParagraph(
                        modifier = Modifier.fillMaxWidth(0.45f),
                        onClick = {
                            addContentVisible.value = false
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

@Composable
private fun ButtonAddBulletPoint(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    ComponentHeaderButton(
        modifier = modifier,
        text = stringResource(R.string.subject_add_bullet_point),
        onClick = onClick
    )
}

@Composable
private fun ButtonAddParagraph(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    ComponentHeaderButton(
        modifier = modifier,
        text = stringResource(R.string.subject_add_paragraph),
        onClick = onClick
    )
}

@Composable
private fun ButtonAddFact(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    ComponentHeaderButton(
        modifier = modifier,
        text = stringResource(R.string.subject_add_fact),
        onClick = onClick
    )
}