package study.me.please.ui.units.detail

import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.squadris.squadris.compose.theme.LocalTheme
import study.me.please.base.LocalIsTablet
import study.me.please.data.io.ImportedSource
import study.me.please.ui.units.ParagraphBlockState
import study.me.please.ui.units.paragraphBlock

/** screen for subject detail with user's main notes for certain collection */
@Composable
fun ParagraphScreen(
    isEmbedded: Boolean = false,
    paragraphUid: String? = null,
    importedSource: ImportedSource? = null,
    //TODO different viewmodel, shared datamanger with UnitScreen
    viewModel: ParagraphViewModel = hiltViewModel()
) {
    val categories = viewModel.categories.collectAsState()
    val paragraph = viewModel.paragraph.collectAsState()

    LaunchedEffect(Unit) {
        paragraphUid?.let { uid ->
            viewModel.requestParagraph(uid)
            viewModel.requestAllCategories()
        }
    }

    val lazyGridState = rememberLazyGridState()

    val configuration = LocalConfiguration.current
    val isLandScape = configuration.layoutDirection == Configuration.ORIENTATION_LANDSCAPE
            || LocalIsTablet.current
    val screenWidth = configuration.screenWidthDp

    LazyVerticalGrid(
        modifier = Modifier
            .background(LocalTheme.colors.backgroundLight)
            .fillMaxSize()
            .animateContentSize(),
        state = lazyGridState,
        columns = GridCells.Fixed(if(isLandScape) 2 else 1),
        horizontalArrangement = if(isLandScape) Arrangement.spacedBy(4.dp) else Arrangement.Start
    ) {
        paragraph.value?.let { safeParagraph ->
            paragraphBlock(
                state = ParagraphBlockState(
                    parentLayer = -1,
                    categories = categories,
                    paragraph = safeParagraph,
                    isReadOnly = true,
                    clipBoard = null,
                    updateParagraph = {}
                ),
                addNewCategory = null,
                onNewCategoryChosen = {},
                screenWidthDp = screenWidth,
            )
        }
    }
}