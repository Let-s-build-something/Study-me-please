package study.me.please.ui.collection.detail

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DocumentScanner
import androidx.compose.material.icons.outlined.FileDownload
import androidx.compose.material.icons.outlined.FileUpload
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults.exitAlwaysScrollBehavior
import androidx.compose.material3.BottomAppBarScrollBehavior
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import com.squadris.squadris.compose.components.CollapsingLayout
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.ext.brandShimmerEffect
import com.squadris.squadris.utils.OnLifecycleEvent
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.base.navigation.CollectionDetailAppBarActions
import study.me.please.base.navigation.NavigationUtils
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.FactIO
import study.me.please.data.io.QuestionIO
import study.me.please.ui.components.EditFieldInput
import study.me.please.ui.components.ImageAction
import study.me.please.ui.components.tab_switch.DEFAULT_ANIMATION_LENGTH_SHORT
import study.me.please.ui.components.tab_switch.MultiChoiceSwitch
import study.me.please.ui.components.tab_switch.rememberTabSwitchState

const val REQUEST_DATA_SAVE_DELAY = 500L

private const val PAGE_INDEX_QUESTIONS = 0
private const val PAGE_INDEX_FACTS = 1

/**
 * Screen for creating a new collection
 * including adding of questions, configuration and import of both
 */
@Composable
fun CollectionDetailScreen(
    collectionUid: String? = null,
    navController: NavController,
    changeActionBar: (actions: @Composable RowScope.() -> Unit) -> Unit,
    viewModel: CollectionDetailViewModel = hiltViewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    val collectionDetailFlow = viewModel.collectionDetail.collectAsState()

    OnLifecycleEvent { event ->
        if(event == Lifecycle.Event.ON_RESUME) {
            if(collectionUid.isNullOrEmpty().not()) {
                viewModel.requestCollectionByUid(collectionUid ?: "")
            }
        }
    }

    if(collectionUid.isNullOrEmpty().not() && collectionDetailFlow.value.dateCreated == null) {
        ShimmerLayout()
    }else {
        val collectionDetail = remember { collectionDetailFlow.value }
        LaunchedEffect(collectionDetailFlow.value) {
            changeActionBar {
                CollectionDetailAppBarActions {
                    NavigationUtils.navigateToSessionDetail(
                        navController,
                        collectionUidList = listOf(collectionDetailFlow.value.uid),
                        toolbarTitle = collectionDetailFlow.value.name
                    )
                }
            }
        }
        ContentLayout(
            collectionDetail = collectionDetail,
            requestCollectionSave = {
                coroutineScope.coroutineContext.cancelChildren()
                coroutineScope.launch {
                    delay(REQUEST_DATA_SAVE_DELAY)
                    viewModel.requestCollectionSave(collectionDetail)
                }
            },
            requestQuestionSave = { question ->
                if(question.uid.isNotEmpty()) {
                    coroutineScope.coroutineContext.cancelChildren()
                    coroutineScope.launch {
                        delay(REQUEST_DATA_SAVE_DELAY)
                        viewModel.requestQuestionSave(question)
                    }
                }
            },
            requestFactSave = { fact ->
                coroutineScope.coroutineContext.cancelChildren()
                coroutineScope.launch {
                    delay(REQUEST_DATA_SAVE_DELAY)
                    viewModel.requestFactSave(fact)
                }
            },
            onNavigateToQuestionTest = { question ->
                NavigationUtils.navigateToSession(
                    navController = navController,
                    toolbarTitle = question.prompt,
                    questionUid = question.uid,
                    isTesting = true
                )
            },
            viewModel = viewModel,
            navigateToSession = { questionUids ->
                NavigationUtils.navigateToSession(
                    navController = navController,
                    toolbarTitle = collectionDetail.name,
                    questionUids = questionUids
                )
            }
        )
    }
}

/** Layout for main content - showing actual information */
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
private fun ContentLayout(
    collectionDetail: CollectionIO,
    onNavigateToQuestionTest: (questionIO: QuestionIO) -> Unit,
    viewModel: CollectionDetailViewModel,
    requestCollectionSave: () -> Unit,
    navigateToSession: (questionUids: List<String>) -> Unit,
    requestQuestionSave: (question: QuestionIO) -> Unit,
    requestFactSave: (fact: FactIO) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val contentPagerState = rememberPagerState { 2 }
    val contentSwitchState = rememberTabSwitchState(
        tabs = mutableListOf(
            stringResource(id = R.string.collection_detail_page_questions),
            stringResource(id = R.string.collection_detail_page_facts)
        ),
        selectedTabIndex = remember(collectionDetail) {
            mutableIntStateOf(contentPagerState.currentPage)
        },
        onSelectionChange = { page ->
            coroutineScope.launch {
                contentPagerState.animateScrollToPage(
                    page,
                    animationSpec = tween(DEFAULT_ANIMATION_LENGTH_SHORT)
                )
            }
        }
    )
    LaunchedEffect(contentPagerState) {
        snapshotFlow { contentPagerState.currentPage }.collect { page ->
            contentSwitchState.selectedTabIndex.value = page
        }
    }

    val itemModifier = Modifier
        .padding(horizontal = 4.dp, vertical = 4.dp)
        .wrapContentHeight()
        .fillMaxWidth()

    CollapsingLayout(
        modifier = Modifier
            .padding(top = 4.dp)
            .shadow(
                elevation = LocalTheme.styles.componentElevation,
                shape = LocalTheme.shapes.componentShape,
                clip = true
            )
            .background(
                color = LocalTheme.colors.onBackgroundComponent,
                shape = LocalTheme.shapes.componentShape
            )
            .wrapContentHeight()
            .padding(horizontal = 12.dp),
        collapsingToolbar = @Composable {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState())
                        .padding(start = 6.dp, top = 6.dp, end = 6.dp),
                    horizontalArrangement = Arrangement.spacedBy(
                        LocalTheme.shapes.betweenItemsSpace
                    )
                ) {
                    ImageAction(
                        modifier = Modifier,
                        leadingImageVector = Icons.Outlined.FileDownload,
                        text = stringResource(id = R.string.button_import)
                    ) {

                    }
                    ImageAction(
                        modifier = Modifier,
                        leadingImageVector = Icons.Outlined.FileUpload,
                        text = stringResource(id = R.string.button_export)
                    ) {

                    }
                    ImageAction(
                        modifier = Modifier,
                        leadingImageVector = Icons.Outlined.DocumentScanner,
                        text = stringResource(id = R.string.button_scan)
                    ) {

                    }
                }

                EditFieldInput(
                    modifier = itemModifier,
                    value = collectionDetail.name,
                    hint = stringResource(id = R.string.collection_detail_name_hint),
                    maxLines = 1,
                    minLines = 1
                ) { output ->
                    collectionDetail.apply {
                        name = output
                    }
                    requestCollectionSave()
                }
                EditFieldInput(
                    modifier = itemModifier,
                    value = collectionDetail.description,
                    hint = stringResource(id = R.string.collection_detail_description_hint),
                    minLines = 8,
                    maxLines = 8
                ) { output ->
                    collectionDetail.apply {
                        description = output
                    }
                    requestCollectionSave()
                }

                Box(
                    modifier = Modifier
                        .padding(top = LocalTheme.shapes.betweenItemsSpace)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    MultiChoiceSwitch(
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth(0.75f),
                        state = contentSwitchState
                    )
                }
            }
        }
    ) {
        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            state = contentPagerState,
            beyondBoundsPageCount = 2,
            key = { it }
        ) { index ->
            if(index == PAGE_INDEX_QUESTIONS) {
                QuestionsList(
                    collectionDetail = collectionDetail,
                    onNavigateToQuestionTest = onNavigateToQuestionTest,
                    viewModel = viewModel,
                    requestCollectionSave = requestCollectionSave,
                    navigateToSession = navigateToSession,
                    requestQuestionSave = requestQuestionSave
                )
            }else if(index == PAGE_INDEX_FACTS) {
                FactsList(
                    viewModel = viewModel,
                    collectionDetail = collectionDetail,
                    requestCollectionSave = requestCollectionSave,
                    requestFactSave = requestFactSave
                )
            }
        }
    }
}

/** Layout for loading - shimmer effect */
@Preview
@Composable
private fun ShimmerLayout() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(start = 4.dp, end = 4.dp, top = 8.dp, bottom = 32.dp)
            .background(
                LocalTheme.colors.onBackgroundComponent,
                shape = LocalTheme.shapes.componentShape
            )
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