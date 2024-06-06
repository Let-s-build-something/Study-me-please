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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.squadris.squadris.compose.base.LocalIsTablet
import study.me.please.ui.units.UnitViewModel
import study.me.please.ui.units.components.paragraphBlock

/** screen for subject detail with user's main notes for certain collection */
@Composable
fun ParagraphLayout(
    modifier: Modifier = Modifier,
    paragraphUid: String? = null,
    factUid: String? = null,
    viewModel: UnitViewModel = hiltViewModel()
) {
    val configuration = LocalConfiguration.current

    val lazyGridState = rememberLazyGridState()
    val scope = rememberCoroutineScope()

    val isLandscape = configuration.layoutDirection == Configuration.ORIENTATION_LANDSCAPE
            || LocalIsTablet.current
    val screenWidth = configuration.screenWidthDp

    val elements = viewModel.elements.collectAsState()
    val collapsedParagraphs = viewModel.collapsedParagraphs.collectAsState()

    LaunchedEffect(Unit) {
        paragraphUid?.let { uid ->
            viewModel.requestParagraph(uid)
        }
    }

    // if we receive an identifier, we want to scroll to it
    if(factUid != null) {
        LaunchedEffect(elements.value) {
            if(elements.value.isNotEmpty()) {
                elements.value.indexOfFirst { it.uid == factUid }.takeIf { it != -1 }?.let { index ->
                    lazyGridState.scrollToItem(index)
                }
            }
        }
    }

    LazyVerticalGrid(
        modifier = modifier.fillMaxWidth(),
        state = lazyGridState,
        columns = GridCells.Fixed(if(isLandscape) 2 else 1),
        horizontalArrangement = if(isLandscape) Arrangement.spacedBy(4.dp) else Arrangement.Start
    ) {
        paragraphBlock(
            selectedFact = mutableStateOf(null),
            collapsedParagraphs = collapsedParagraphs,
            screenWidthDp = screenWidth,
            isLandscape = isLandscape,
            bridge = null,
            isReadOnly = true,
            viewModel = viewModel,
            activatedParent = mutableStateOf(""),
            collectionViewModel = null,
            dragAndDropTarget = mutableStateOf(""),
            focusManager = null,
            scope = scope,
            elements = elements
        )
    }
}