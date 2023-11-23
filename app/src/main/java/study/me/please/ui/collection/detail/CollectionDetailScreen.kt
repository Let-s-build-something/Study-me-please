package study.me.please.ui.collection.detail

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.squadris.squadris.compose.components.CollapsingLayout
import com.squadris.squadris.compose.components.DEFAULT_ANIMATION_LENGTH_SHORT
import com.squadris.squadris.compose.components.EditFieldInput
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.ext.brandShimmerEffect
import com.squadris.squadris.utils.OnLifecycleEvent
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.base.LocalNavController
import study.me.please.base.navigation.CollectionDetailAppBarActions
import study.me.please.base.navigation.NavigationComponent
import study.me.please.base.navigation.NavigationDestination
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.FactIO
import study.me.please.data.io.QuestionIO
import study.me.please.ui.collection.detail.facts.FactsList
import study.me.please.ui.collection.detail.questions.QuestionsList
import study.me.please.ui.components.ImageAction
import study.me.please.ui.components.pull_refresh.PullRefreshScreen
import study.me.please.ui.components.tab_switch.MultiChoiceSwitch
import study.me.please.ui.components.tab_switch.rememberTabSwitchState

const val REQUEST_DATA_SAVE_DELAY = 500L

const val PAGE_INDEX_QUESTIONS = 0
const val PAGE_INDEX_FACTS = 1

/**
 * Screen for creating a new collection
 * including adding of questions, configuration and import of both
 */
@Composable
fun CollectionDetailScreen(
    title: String? = null,
    collectionUid: String? = null,
    viewModel: CollectionDetailViewModel = hiltViewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    val navController = LocalNavController.current

    val collectionDetailFlow = viewModel.collectionDetail.collectAsState()

    val collectionDetail = remember { collectionDetailFlow.value }
    var collectionTitle by remember(title) { mutableStateOf(title) }

    LaunchedEffect(collectionDetailFlow.value) {
        collectionTitle = collectionDetailFlow.value.name
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
        title = collectionTitle,
        actionIcons = {
            CollectionDetailAppBarActions {
                navController?.navigate(
                    NavigationDestination.SessionDetail.createRoute(
                        NavigationComponent.COLLECTION_UID_LIST to listOf(collectionDetailFlow.value.uid),
                        NavigationComponent.TOOLBAR_TITLE to collectionDetailFlow.value.name
                    )
                )
            }
        }
    ) { paddingValues ->
        if(collectionUid.isNullOrEmpty().not() && collectionDetailFlow.value.dateCreated == null) {
            ShimmerLayout(modifier = Modifier.padding(paddingValues))
        }else {
            ContentLayout(
                modifier = Modifier.padding(paddingValues),
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
                    navController?.navigate(
                        NavigationDestination.SessionPlay.createRoute(
                            NavigationComponent.TOOLBAR_TITLE to question.prompt,
                            NavigationComponent.IS_TESTING_MODE to true,
                            NavigationComponent.QUESTION_UID to question.uid
                        )
                    )
                },
                viewModel = viewModel,
                navigateToSession = { questionUids ->
                    navController?.navigate(
                        NavigationDestination.SessionPlay.createRoute(
                            NavigationComponent.TOOLBAR_TITLE to collectionDetail.name,
                            NavigationComponent.QUESTION_UID_LIST to questionUids
                        )
                    )
                }
            )
        }
    }
}

/** Layout for main content - showing actual information */
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ContentLayout(
    modifier: Modifier = Modifier,
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
        modifier = modifier
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
            .wrapContentHeight(),
        collapsingToolbar = @Composable {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
            ) {
                val clipboardManager: ClipboardManager = LocalClipboardManager.current
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
                        viewModel.getExportString { json ->
                            clipboardManager.setText(AnnotatedString(json))
                        }
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
                    onNavigateToQuestionTest = onNavigateToQuestionTest,
                    viewModel = viewModel,
                    navigateToSession = navigateToSession,
                    requestQuestionSave = requestQuestionSave
                )
            }else if(index == PAGE_INDEX_FACTS) {
                FactsList(
                    viewModel = viewModel,
                    collectionDetail = collectionDetail,
                    requestCollectionSave = requestCollectionSave,
                    requestFactSave = requestFactSave,
                    onPageChange = {
                        coroutineScope.launch {
                            contentPagerState.scrollToPage(0)
                        }
                    }
                )
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