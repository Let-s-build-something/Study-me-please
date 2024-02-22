package study.me.please.ui.units.detail

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import study.me.please.base.LocalIsTablet
import study.me.please.ui.units.ParagraphBlockState
import study.me.please.ui.units.paragraphBlock

/** screen for subject detail with user's main notes for certain collection */
@Composable
fun ParagraphLayout(
    modifier: Modifier = Modifier,
    paragraphUid: String? = null,
    factUid: String? = null,
    viewModel: ParagraphViewModel = hiltViewModel()
) {
    val lazyGridState = rememberLazyGridState()
    val configuration = LocalConfiguration.current

    val isLandscape = configuration.layoutDirection == Configuration.ORIENTATION_LANDSCAPE
            || LocalIsTablet.current
    val screenWidth = configuration.screenWidthDp

    val paragraph = viewModel.paragraph.collectAsState()

    LaunchedEffect(Unit) {
        paragraphUid?.let { uid ->
            viewModel.requestParagraph(uid)
        }
    }

    // if we receive fact identifier, we want to scroll to it
    if(factUid != null) {
        LaunchedEffect(paragraph.value) {
            if(paragraph.value != null) {
                paragraph.value?.facts?.indexOfFirst { it.uid == factUid }?.let { index ->
                    // facts are right after the paragraph name -> thus index + 1
                    lazyGridState.scrollToItem(index + 1)
                }
            }
        }
    }

    paragraph.value?.let { safeParagraph ->
        val collapsedParagraphs = remember {
            mutableStateListOf(
                *paragraph.value?.paragraphs?.map { it.uid }?.toTypedArray().orEmpty()
            )
        }

        LazyVerticalGrid(
            modifier = modifier.fillMaxWidth(),
            state = lazyGridState,
            columns = GridCells.Fixed(if(isLandscape) 2 else 1),
            horizontalArrangement = if(isLandscape) Arrangement.spacedBy(4.dp) else Arrangement.Start
        ) {
            paragraphBlock(
                state = ParagraphBlockState(
                    parentLayer = -1,
                    paragraph = safeParagraph,
                    isReadOnly = true,
                    clipBoard = null,
                    updateParagraph = {},
                    selectedFact = mutableStateOf(null)
                ),
                collapsedParagraphs = collapsedParagraphs,
                addNewCategory = null,
                onNewCategoryChosen = {},
                screenWidthDp = screenWidth,
                isLandscape = isLandscape
            )
        }
    }
}