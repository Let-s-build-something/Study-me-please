package study.me.please.ui.collection.detail

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.material.icons.outlined.FileUpload
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.Source
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
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
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.squadris.squadris.compose.components.DEFAULT_ANIMATION_LENGTH_SHORT
import com.squadris.squadris.compose.components.input.EditFieldInput
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.ext.brandShimmerEffect
import com.squadris.squadris.utils.OnLifecycleEvent
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.base.LocalNavController
import study.me.please.base.navigation.ActionBarIcon
import study.me.please.base.navigation.NavigationComponent
import study.me.please.base.navigation.NavigationScreen
import study.me.please.data.io.CollectionIO
import study.me.please.ui.collection.detail.facts.FactsList
import study.me.please.ui.collection.detail.questions.QuestionsList
import study.me.please.ui.components.ExpandableContent
import study.me.please.ui.components.ImageAction
import study.me.please.ui.components.collapsing_layout.CollapsingBehavior
import study.me.please.ui.components.collapsing_layout.CollapsingLayout
import study.me.please.ui.components.pull_refresh.PullRefreshScreen
import study.me.please.ui.components.tab_switch.MultiChoiceSwitch
import study.me.please.ui.components.tab_switch.rememberTabSwitchState

const val REQUEST_DATA_SAVE_DELAY = 500L

const val PAGE_INDEX_QUESTIONS = 0
const val PAGE_INDEX_FACTS = 1

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
fun CollectionDetailScreen(
    title: String? = null,
    collectionUid: String? = null,
    viewModel: CollectionDetailViewModel = hiltViewModel()
) {
    val navController = LocalNavController.current

    val collectionDetail = viewModel.collectionDetail.collectAsState()
    val collectionTitle = remember(title) {
        mutableStateOf(collectionDetail.value.name.ifBlank { title })
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
        title = collectionTitle.value,
        subtitle = stringResource(id = R.string.collection),
        actionIcons = {
            ActionBarIcon(
                text = stringResource(id = R.string.collection_detail_start_session),
                imageVector = Icons.Outlined.PlayArrow,
                onClick = {
                    navController?.navigate(
                        NavigationScreen.SessionDetail.createRoute(
                            NavigationComponent.COLLECTION_UID_LIST to listOf(collectionDetail.value.uid),
                            NavigationComponent.TOOLBAR_TITLE to collectionDetail.value.name
                        )
                    )
                }
            )
            ActionBarIcon(
                text = stringResource(id = R.string.screen_units),
                imageVector = Icons.Outlined.Source,
                onClick = {
                    navController?.navigate(
                        NavigationScreen.Units.createRoute(
                            NavigationComponent.COLLECTION_UID to collectionDetail.value.uid,
                            NavigationComponent.TOOLBAR_TITLE to collectionDetail.value.name
                        )
                    )
                }
            )
        }
    ) { paddingValues ->
        if(collectionUid.isNullOrEmpty().not() && collectionDetail.value.dateCreated == null) {
            ShimmerLayout(modifier = Modifier.padding(paddingValues))
        }else {
            ContentLayout(
                modifier = Modifier.padding(paddingValues),
                viewModel = viewModel,
                collectionTitleState = collectionTitle
            )
        }
    }
}

/** Layout for main content - showing actual information */
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ContentLayout(
    modifier: Modifier = Modifier,
    viewModel: CollectionDetailViewModel,
    collectionTitleState: MutableState<String?>
) {
    val collectionDetail = viewModel.collectionDetail.collectAsState()

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
    val clipboardManager: ClipboardManager = LocalClipboardManager.current

    val bridge = remember(collectionDetail.value.uid) {
        object: CollectionDetailBridge {
            override fun requestCollectionSave() {
                coroutineScope.coroutineContext.cancelChildren()
                coroutineScope.launch {
                    delay(REQUEST_DATA_SAVE_DELAY)
                    viewModel.requestCollectionSave(collectionDetail.value)
                }
            }

            override fun updateCollection(collection: CollectionIO) {
                viewModel.updateCollection(collection)
                requestCollectionSave()
            }
        }
    }

    LaunchedEffect(contentPagerState) {
        snapshotFlow { contentPagerState.currentPage }.collect { page ->
            contentSwitchState.selectedTabIndex.value = page
        }
    }

    val itemModifier = Modifier
        .padding(horizontal = 4.dp, vertical = 4.dp)
        .wrapContentHeight()
        .fillMaxWidth()

    val isExpandedByDefault = collectionDetail.value.name.isEmpty()
            || (collectionDetail.value.factUidList.size <= 3
                && collectionDetail.value.questionUidList.size <= 3)
    var isBasicInfoExpanded by remember { mutableStateOf(isExpandedByDefault) }

    CollapsingLayout(
        modifier = modifier.wrapContentHeight(),
        state = viewModel.collapsingLayoutState,
        content = listOf(
            @Composable {
                ExpandableContent(
                    modifier = Modifier
                        .clickable(
                            onClick = { isBasicInfoExpanded = isBasicInfoExpanded.not() },
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple()
                        )
                        .verticalScroll(rememberScrollState())
                        .fillMaxWidth(),
                    text = stringResource(R.string.collection_detail_basic_information),
                    isExpanded = isBasicInfoExpanded
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp)
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
                                leadingImageVector = Icons.Outlined.FileUpload,
                                text = stringResource(id = R.string.button_export)
                            ) {
                                viewModel.getExportString { json ->
                                    clipboardManager.setText(AnnotatedString(json))
                                }
                            }
                            /*ImageAction(
                                modifier = Modifier,
                                leadingImageVector = Icons.Outlined.DocumentScanner,
                                text = stringResource(id = R.string.button_scan)
                            ) {

                            }*/
                        }

                        EditFieldInput(
                            modifier = itemModifier,
                            value = collectionDetail.value.name,
                            hint = stringResource(id = R.string.collection_detail_name_hint),
                            maxLines = 1,
                            minLines = 1
                        ) { output ->
                            collectionDetail.value.name = output
                            bridge.updateCollection(collectionDetail.value)
                            collectionTitleState.value = output
                        }
                        EditFieldInput(
                            modifier = itemModifier,
                            value = collectionDetail.value.description,
                            hint = stringResource(id = R.string.collection_detail_description_hint),
                            minLines = 8,
                            maxLines = 8
                        ) { output ->
                            collectionDetail.value.description = output
                            bridge.updateCollection(collectionDetail.value)
                        }
                    }
                }
            } to CollapsingBehavior.ON_TOP,
            @Composable {
                Box(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
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
            } to CollapsingBehavior.NONE,
            @Composable {
                HorizontalPager(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    state = contentPagerState,
                    beyondBoundsPageCount = 2,
                    key = { it }
                ) { index ->
                    if(index == PAGE_INDEX_QUESTIONS) {
                        QuestionsList(viewModel = viewModel)
                    }else if(index == PAGE_INDEX_FACTS) {
                        FactsList(
                            viewModel = viewModel,
                            onPageChange = {
                                coroutineScope.launch {
                                    contentPagerState.scrollToPage(0)
                                }
                            }
                        )
                    }
                }
            } to CollapsingBehavior.NONE,
        )
    )
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