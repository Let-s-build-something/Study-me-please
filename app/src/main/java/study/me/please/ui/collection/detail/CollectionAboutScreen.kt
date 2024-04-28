package study.me.please.ui.collection.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.squadris.squadris.compose.components.input.EditFieldInput
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.ext.brandShimmerEffect
import com.squadris.squadris.utils.OnLifecycleEvent
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.data.io.CollectionIO
import study.me.please.ui.collection.RefreshableViewModel.Companion.requestData
import study.me.please.ui.collection.detail.questions.detail.INPUT_DELAYED_RESPONSE_MILLIS
import study.me.please.ui.components.pull_refresh.PullRefreshScreen

const val REQUEST_DATA_SAVE_DELAY = 200L

const val PAGE_INDEX_QUESTIONS = 0

/** Main communication and controlling channel */
interface CollectionDetailBridge {

    /** Updates collection by changes in receiving collection */
    fun updateCollection(collection: CollectionIO)

    /** Requests a DB collection save */
    fun requestCollectionSave()
}

/**
 * Screen for creating a new collection
 * including adding of questions, configuration and import of both
 */
@Composable
fun CollectionAboutScreen(
    title: String? = null,
    collectionUid: String? = null,
    viewModel: CollectionDetailViewModel = hiltViewModel()
) {
    val collectionDetail = viewModel.collectionDetail.collectAsState()
    val collectionTitle = remember(title) {
        mutableStateOf(collectionDetail.value?.name?.ifBlank { title })
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
        title = stringResource(id = R.string.screen_collection_about),
        subtitle = collectionTitle.value
    ) { paddingValues ->
        if(collectionUid.isNullOrEmpty().not() && collectionDetail.value == null) {
            ShimmerLayout(modifier = Modifier.padding(paddingValues))
        }else {
            LaunchedEffect(Unit) {
                collectionTitle.value = collectionDetail.value?.name?.ifBlank { title }
            }

            collectionDetail.value?.let {
                ContentLayout(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .padding(paddingValues),
                    viewModel = viewModel,
                    collectionTitleState = collectionTitle,
                    collectionDetail = it
                )
            }
        }
    }
}

/** Layout for main content - showing actual information */
@Composable
private fun ContentLayout(
    modifier: Modifier = Modifier,
    viewModel: CollectionDetailViewModel,
    collectionDetail: CollectionIO,
    collectionTitleState: MutableState<String?>
) {
    val coroutineScope = rememberCoroutineScope()
    //val clipboardManager: ClipboardManager = LocalClipboardManager.current

    val bridge = remember(collectionDetail.uid) {
        object: CollectionDetailBridge {
            override fun requestCollectionSave() {
                coroutineScope.coroutineContext.cancelChildren()
                coroutineScope.launch {
                    delay(REQUEST_DATA_SAVE_DELAY)
                    viewModel.requestCollectionSave(collectionDetail)
                }
            }

            override fun updateCollection(collection: CollectionIO) {
                viewModel.updateCollection(collection)
                requestCollectionSave()
            }
        }
    }

    val itemModifier = Modifier
        .padding(horizontal = 4.dp, vertical = 4.dp)
        .wrapContentHeight()
        .fillMaxWidth()

    val inputScope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
    ) {
        EditFieldInput(
            modifier = itemModifier,
            value = collectionDetail.name,
            hint = stringResource(id = R.string.collection_detail_name_hint),
            maxLines = 1,
            minLines = 1
        ) { output ->
            inputScope.coroutineContext.cancelChildren()
            inputScope.launch {
                delay(INPUT_DELAYED_RESPONSE_MILLIS)
                collectionDetail.name = output
                bridge.updateCollection(collectionDetail)
                collectionTitleState.value = output
            }
        }
        EditFieldInput(
            modifier = itemModifier,
            value = collectionDetail.description,
            hint = stringResource(id = R.string.collection_detail_description_hint),
            minLines = 8,
            maxLines = 8
        ) { output ->
            inputScope.coroutineContext.cancelChildren()
            inputScope.launch {
                delay(INPUT_DELAYED_RESPONSE_MILLIS)
                collectionDetail.description = output
                bridge.updateCollection(collectionDetail)
            }
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
        Box(
            modifier = Modifier
                .height(70.dp)
                .padding(top = 16.dp, start = 12.dp, end = 12.dp)
                .fillMaxWidth()
                .brandShimmerEffect(LocalTheme.shapes.componentShape)
        )
        Box(
            modifier = Modifier
                .height(160.dp)
                .padding(top = 8.dp, start = 12.dp, end = 12.dp)
                .fillMaxWidth()
                .brandShimmerEffect(LocalTheme.shapes.componentShape)
        )
        Spacer(modifier = Modifier.height(32.dp))
    }
}