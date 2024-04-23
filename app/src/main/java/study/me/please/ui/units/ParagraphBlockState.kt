package study.me.please.ui.units

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import study.me.please.base.GeneralClipBoard

/**
 * Bridge for the ParagraphBlockState to be used in the ParagraphBlock
 * @param parentLayer - the layer of the block in the nested structure
 * @param selectedFact - the selected fact in the block
 * @param clipBoard - the clipboard to be used in the block
 * @param paragraph - the paragraph to be used in the block
 * @param isReadOnly - whether the block is read only
 */
@Composable
fun rememberParagraphBlockState(
    parentLayer: Int,
    selectedFact: MutableState<String?>,
    clipBoard: GeneralClipBoard?,
    viewModel: CollectionUnitsViewModel,
    //paragraph: ParagraphIO,
    isReadOnly: Boolean = false
): ParagraphBlockState {
    val scope = rememberCoroutineScope()
    val invalidateScope = rememberCoroutineScope()

    /*val nestedParagraphs = remember(paragraph.uid, paragraph.paragraphs) {
        mutableStateListOf(*paragraph.paragraphs.toTypedArray())
    }
    val nestedBulletPoints = remember(paragraph.uid, paragraph.bulletPoints) {
        mutableStateListOf(*paragraph.bulletPoints.toTypedArray())
    }
    val nestedFacts = remember(paragraph.uid, paragraph.facts) {
        mutableStateListOf(*paragraph.facts.toTypedArray())
    }*/

    /*LaunchedEffect(paragraph) {
        viewModel.paragraphPatch.collectLatest { patch ->
            if(patch?.uid == paragraph.uid) {
                Log.d("kostka_test", "patch: ${patch.uid}")
                paragraph.updateTO(patch)
                //bridge.invalidate()
                viewModel.paragraphPatch.value = null
            }
        }
    }*/

    return ParagraphBlockState(
        parentLayer = parentLayer,
        selectedFact = selectedFact,
        clipBoard = clipBoard,
        //paragraph = paragraph,
        isReadOnly = isReadOnly,/*
        bulletPoints = nestedBulletPoints,
        paragraphs = nestedParagraphs,
        facts = nestedFacts,
        bridge = bridge,
        blockStates = nestedBlockStates*/
    )
}


data class ParagraphBlockState(
    val parentLayer: Int,
    val selectedFact: MutableState<String?>,
    val clipBoard: GeneralClipBoard?,
    //val paragraph: ParagraphIO,
    val isReadOnly: Boolean,
/*
    val bulletPoints: List<String>,
    val facts: List<FactIO>,
    val paragraphs: List<ParagraphIO>,
    val blockStates: List<ParagraphBlockState>,*/
)

/** type of the element in the paragraph */
enum class ElementType {
    FACT,
    EMPTY_SPACE,
    PARAGRAPH
}