package study.me.please.ui.units

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshots.SnapshotStateList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import study.me.please.base.GeneralClipBoard
import study.me.please.data.io.FactIO
import study.me.please.data.io.subjects.CategoryIO
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.ui.collection.detail.REQUEST_DATA_SAVE_DELAY

/**
 * Bridge for the ParagraphBlockState to be used in the ParagraphBlock
 * @param parentLayer - the layer of the block in the nested structure
 * @param categories - the list of categories to be used in the block
 * @param selectedFact - the selected fact in the block
 * @param clipBoard - the clipboard to be used in the block
 * @param paragraphArg - the paragraph to be used in the block
 * @param isReadOnly - whether the block is read only
 * @param updateParagraph - the function to update the paragraph
 * @param updateFact - the function to update the fact
 */
@Composable
fun rememberParagraphBlockState(
    parentLayer: Int,
    categories: State<List<CategoryIO>?>,
    selectedFact: MutableState<String?>,
    clipBoard: GeneralClipBoard?,
    viewModel: UnitsViewModel,
    paragraphArg: ParagraphIO,
    isReadOnly: Boolean = false,
    updateParagraph: (ParagraphIO) -> Unit,
    updateFact: (FactIO) -> Unit
): ParagraphBlockState {
    val scope = rememberCoroutineScope()
    val invalidateScope = rememberCoroutineScope()

    var paragraph = remember(paragraphArg) {
        paragraphArg
    }
    val nestedParagraphs = remember(paragraphArg) {
        mutableStateListOf(*paragraph.paragraphs.toTypedArray())
    }
    val nestedBulletPoints = remember(paragraphArg) {
        mutableStateListOf(*paragraph.bulletPoints.toTypedArray())
    }
    val nestedFacts = remember(paragraphArg) {
        mutableStateListOf(*paragraph.facts.toTypedArray())
    }
    val nestedBlockStates = nestedParagraphs.map { nestedParagraph ->
        rememberParagraphBlockState(
            parentLayer = parentLayer + 1,
            categories = categories,
            selectedFact = selectedFact,
            clipBoard = clipBoard,
            paragraphArg = nestedParagraph,
            isReadOnly = isReadOnly,
            updateFact = updateFact,
            updateParagraph = updateParagraph,
            viewModel = viewModel
        )
    }

    val bridge = remember(paragraphArg) {
        object: ParagraphBlockBridge {
            override fun removeUiFact(uid: String) {
                scope.launch(Dispatchers.Default) {
                    nestedFacts.removeIf { it.uid == uid }
                }
            }
            override fun removeUiParagraph(uid: String) {
                scope.launch(Dispatchers.Default) {
                    nestedParagraphs.removeIf { it.uid == uid }
                }
            }
            override fun invalidate() {
                invalidateScope.coroutineContext.cancelChildren()
                invalidateScope.launch(Dispatchers.Default) {
                    delay(REQUEST_DATA_SAVE_DELAY)
                    Log.d("kostka_test", "ParagraphBlockState invalidate")
                    if (paragraph.facts.size != nestedFacts.size) {
                        nestedFacts.removeAll { iterator ->
                            paragraph.facts.none { iterator.uid == it.uid }
                        }
                        paragraph.facts.forEachIndexed { index, factIO ->
                            if (nestedFacts.none { it.uid == factIO.uid }) {
                                nestedFacts.add(index, factIO)
                            }
                        }
                    }
                    if (paragraph.paragraphs.size != nestedParagraphs.size) {
                        nestedParagraphs.removeAll { iterator ->
                            paragraph.paragraphs.none { iterator.uid == it.uid }
                        }
                        paragraph.paragraphs.forEachIndexed { index, paragraphIO ->
                            if (nestedParagraphs.none { it.uid == paragraphIO.uid }) {
                                nestedParagraphs.add(index, paragraphIO)
                            }
                        }
                    }
                }
            }
            override fun removeBulletPoint(index: Int) {
                nestedBulletPoints.removeAt(index)
                paragraph.bulletPoints = nestedBulletPoints
                updateParagraph(paragraph)
            }
            override fun updateBulletPoint(index: Int, output: String) {
                nestedBulletPoints[index] = output
                paragraph.bulletPoints = nestedBulletPoints
                updateParagraph(paragraph)
            }
            override fun addNewBulletPoint(index: Int, bulletPoint: String?) {
                nestedBulletPoints.add(index, bulletPoint ?: "")
                paragraph.bulletPoints = nestedBulletPoints
                updateParagraph(paragraph)
            }
            override fun addFact(element: UnitsViewModel.ElementToDrag) {
                if(element.fact != null && nestedFacts.none { it.uid == element.fact.uid }) {
                    nestedFacts.add(element.index, element.fact)

                    if(element.fact.isEmpty) {
                        selectedFact.value = element.fact.uid
                    }
                }
            }

            override fun addParagraph(element: UnitsViewModel.ElementToDrag) {
                if(element.paragraph != null && nestedParagraphs.none { it.uid == element.paragraph.uid }) {
                    nestedParagraphs.add(element.index, element.paragraph)
                }
            }

            override fun requestFactsPaste() {
                nestedFacts.addAll(0, clipBoard?.facts?.paste().orEmpty())
                paragraph.facts = nestedFacts
                updateParagraph(paragraph)
            }
        }
    }

    LaunchedEffect(paragraphArg) {
        viewModel.paragraphPatch.collectLatest { patch ->
            if(patch?.uid == paragraphArg.uid) {
                paragraph = patch
                bridge.invalidate()
            }
        }
    }

    return ParagraphBlockState(
        parentLayer = parentLayer,
        categories = categories,
        selectedFact = selectedFact,
        clipBoard = clipBoard,
        paragraph = paragraph,
        isReadOnly = isReadOnly,
        updateFact = updateFact,
        updateParagraph = updateParagraph,
        bulletPoints = nestedBulletPoints,
        paragraphs = nestedParagraphs,
        facts = nestedFacts,
        bridge = bridge,
        blockStates = nestedBlockStates
    )
}


data class ParagraphBlockState(
    val parentLayer: Int,
    val categories: State<List<CategoryIO>?> = mutableStateOf(listOf()),
    val selectedFact: MutableState<String?>,
    val clipBoard: GeneralClipBoard?,
    val paragraph: ParagraphIO,
    val isReadOnly: Boolean,
    val updateParagraph: (ParagraphIO) -> Unit,
    val updateFact: (FactIO) -> Unit,
    val bridge: ParagraphBlockBridge,

    //TODO !!!!!!!!
    //TODO remove things that should be live - val makes it so it doesn't get invalidated - put them into a constructor
    // then remove the localCategories and change generating
    val bulletPoints: List<String>,
    val facts: SnapshotStateList<FactIO>,
    val paragraphs: SnapshotStateList<ParagraphIO>,
    val blockStates: List<ParagraphBlockState>,
)

/** type of the element in the paragraph */
enum class ElementType {
    FACT,
    EMPTY_SPACE,
    PARAGRAPH
}