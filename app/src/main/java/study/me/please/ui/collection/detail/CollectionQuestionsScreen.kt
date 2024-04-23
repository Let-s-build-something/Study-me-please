package study.me.please.ui.collection.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.ext.brandShimmerEffect
import com.squadris.squadris.utils.OnLifecycleEvent
import study.me.please.R
import study.me.please.ui.collection.RefreshableViewModel.Companion.requestData
import study.me.please.ui.collection.detail.questions.QuestionsList
import study.me.please.ui.components.pull_refresh.PullRefreshScreen

/**
 * Screen for creating a new collection
 * including adding of questions, configuration and import of both
 */
@Composable
fun CollectionQuestionsScreen(
    title: String? = null,
    collectionUid: String? = null,
    viewModel: CollectionDetailViewModel = hiltViewModel()
) {
    val collectionDetail = viewModel.collectionDetail.collectAsState()
    val collectionTitle = remember(title) {
        mutableStateOf(collectionDetail.value?.name?.ifBlank { title } ?: title)
    }

    OnLifecycleEvent { event ->
        if(event == Lifecycle.Event.ON_RESUME) {
            if(collectionUid.isNullOrEmpty().not()) {
                viewModel.collectionUid = collectionUid ?: ""
                viewModel.requestData(isSpecial = true)
            }
        }
    }

    PullRefreshScreen(
        viewModel = viewModel,
        title = stringResource(id = R.string.screen_questions),
        subtitle = collectionTitle.value
    ) { paddingValues ->
        if(collectionUid.isNullOrEmpty().not() && collectionDetail.value == null) {
            ShimmerLayout(modifier = Modifier.padding(paddingValues))
        }else {
            QuestionsList(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .padding(paddingValues),
                viewModel = viewModel
            )
        }
    }
}

/** Layout for loading - shimmer effect */
@Preview
@Composable
private fun ShimmerLayout(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(start = 4.dp, end = 4.dp, top = 8.dp, bottom = 32.dp)
    ) {
        repeat(5) {
            Box(
                modifier = Modifier
                    .height(70.dp)
                    .padding(top = 8.dp, start = 12.dp, end = 12.dp)
                    .fillMaxWidth()
                    .brandShimmerEffect(LocalTheme.shapes.componentShape)
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
    }
}