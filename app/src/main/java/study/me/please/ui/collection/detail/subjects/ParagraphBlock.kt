package study.me.please.ui.collection.detail.subjects

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.squadris.squadris.compose.theme.Colors
import com.squadris.squadris.compose.theme.LocalTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.data.io.FactIO
import study.me.please.data.io.FactType
import study.me.please.data.io.subjects.CategoryIO
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.ComponentHeaderButton
import study.me.please.ui.components.EditFieldItemPicker
import study.me.please.ui.components.ExpandableContent
import study.me.please.ui.components.FactCard
import study.me.please.ui.components.InteractiveCardMode
import study.me.please.ui.components.InteractiveCardState
import study.me.please.ui.components.ListItemEditField
import study.me.please.ui.components.OptionsLayout

/** Block of a paragraph under a subject */
@Composable
fun ParagraphBlock(
    parentLayer: Int,
    categories: List<CategoryIO>,
    viewModel: SubjectsViewModel,
    paragraph: ParagraphIO,
    addNewCategory: (name: String) -> Unit,
    addContentVisible: MutableState<Boolean>,
    parentBridge: SubjectScreenBridge,
    onNewCategoryChosen: (category: CategoryIO) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()

    val nestedBulletPoints = remember(paragraph) {
        mutableStateListOf(*paragraph.bulletPoints.toTypedArray())
    }
    val nestedFacts = remember(paragraph) {
        mutableStateListOf(*paragraph.facts.map { it to InteractiveCardState() }.toTypedArray())
    }
    val nestedParagraphs = remember(paragraph) {
        mutableStateListOf(*paragraph.paragraphs.toTypedArray())
    }

    var showDeleteDialog by remember { mutableStateOf(false) }

    val bridge = remember {
        object: ParagraphBlockBridge {
            val selectedFactUids = mutableStateListOf<String>()

            override fun stopChecking() {
                nestedFacts.forEach {
                    it.second.isChecked.value = false
                    it.second.mode.value = InteractiveCardMode.DATA_DISPLAY
                }
                selectedFactUids.clear()
            }
            override fun addNewFact() {
                addContentVisible.value = false
                nestedFacts.add(0, FactIO() to InteractiveCardState())
                stopChecking()
                nestedFacts.firstOrNull()?.second?.mode?.value = InteractiveCardMode.EDIT
            }
            override fun requestFactsPaste() {
                nestedFacts.addAll(
                    0,
                    viewModel.clipBoard.facts.paste().map { it to InteractiveCardState() }
                )
                stopChecking()
            }
            override fun requestFactsDeletion() {
                nestedFacts.removeAll { selectedFactUids.contains(it.first.uid) }
                stopChecking()
            }
        }
    }

    LaunchedEffect(bridge.selectedFactUids.size) {
        if(bridge.selectedFactUids.size > 0) {
            nestedFacts.forEach {
                it.second.mode.value = InteractiveCardMode.CHECKING
            }
        }else {
            bridge.stopChecking()
        }
    }
    nestedFacts.forEach { fact ->
        // when checked, add to selected list
        LaunchedEffect(fact.second.isChecked.value) {
            if(fact.second.isChecked.value) {
                bridge.selectedFactUids.add(fact.first.uid)
            }else bridge.selectedFactUids.remove(fact.first.uid)
        }
        // if we start editing one fact, others should stop being edited
        LaunchedEffect(fact.second.mode.value == InteractiveCardMode.EDIT) {
            nestedFacts.forEach {
                if(it.first.uid != fact.first.uid
                    && fact.second.mode.value == InteractiveCardMode.EDIT
                ) {
                    it.second.mode.value = InteractiveCardMode.DATA_DISPLAY
                }
            }
        }
    }

    BackHandler(bridge.selectedFactUids.size > 0) {
        bridge.stopChecking()
    }

    if(showDeleteDialog) {
        BasicAlertDialog(
            title = stringResource(id = R.string.fact_delete_dialog_title),
            content = stringResource(
                id = R.string.fact_delete_dialog_description,
                bridge.selectedFactUids.size
            ),
            icon = Icons.Outlined.Delete,
            confirmButtonState = ButtonState(
                text = stringResource(id = R.string.button_confirm)
            ) {
                bridge.requestFactsDeletion()
                bridge.stopChecking()
                showDeleteDialog = false
            },
            dismissButtonState = ButtonState(
                text = stringResource(id = R.string.button_dismiss)
            ) { showDeleteDialog = false }
        )
    }

    LaunchedEffect(nestedBulletPoints.size) {
        paragraph.bulletPoints = nestedBulletPoints
        parentBridge.updateParagraph(paragraph)
    }
    LaunchedEffect(nestedFacts.size) {
        paragraph.facts = nestedFacts.map { it.first }
        parentBridge.updateParagraph(paragraph)
    }
    LaunchedEffect(nestedParagraphs.size) {
        paragraph.paragraphs = nestedParagraphs
        parentBridge.updateParagraph(paragraph)
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
        // for performance reasons, we do not expand more complex paragraph by default
        defaultValue = paragraph.isEmpty
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
                                bridge.addNewFact()
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
                            bridge.addNewFact()
                        }
                    )
                }
            }

            OptionsLayout(
                modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp),
                onCopyRequest = {
                    coroutineScope.launch(Dispatchers.Default) {
                        viewModel.clipBoard.facts.copyItems(
                            paragraph.facts.filter { bridge.selectedFactUids.contains(it.uid) }
                        )
                        bridge.stopChecking()
                    }
                },
                onPasteRequest = { bridge.requestFactsPaste() },
                onDeleteRequest = { showDeleteDialog = true },
                onSelectAll = {
                    nestedFacts.forEach {
                        it.second.isChecked.value = true
                    }
                },
                onDeselectAll = { bridge.stopChecking() },
                isEditMode = bridge.selectedFactUids.size > 0,
                hasPasteOption = viewModel.clipBoard.facts.isEmpty.value.not(),
                animateTopDown = false,
                onClipBoardRemoval = { viewModel.clipBoard.facts.clear() }
            )
            nestedFacts.forEach { fact ->
                FactCard(
                    modifier = Modifier.padding(8.dp),
                    data = fact.first,
                    state = fact.second,
                    requestDataSave = { newFact ->
                        addContentVisible.value = false
                        paragraph.facts.find { it.uid == newFact.uid }?.updateTO(newFact)
                        parentBridge.updateParagraph(paragraph)
                    },
                    categoryUseCase = viewModel
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
                            categoryUid = chosenCategory.uid
                            parentBridge.updateParagraph(this)
                        }
                    },
                    addContentVisible = addContentVisible,
                    parentBridge = parentBridge,
                    parentLayer = parentLayer.plus(1),
                    viewModel = viewModel
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

private const val PARAGRAPH_MIN_HEIGHT_DP = 210
interface ParagraphBlockBridge {

    /** Gives away all selected item and stops checking */
    fun stopChecking()

    /** Adds a new nested fact and saves TO */
    fun addNewFact()

    /** Requests a paste of current clipboard data */
    fun requestFactsPaste()

    /** Requests for a facts deletion */
    fun requestFactsDeletion()
}