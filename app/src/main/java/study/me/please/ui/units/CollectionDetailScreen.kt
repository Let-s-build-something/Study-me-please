@file:OptIn(ExperimentalFoundationApi::class)

package study.me.please.ui.units

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.Inventory2
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.squadris.squadris.compose.base.LocalNavController
import com.squadris.squadris.compose.components.chips.SearchChip
import com.squadris.squadris.compose.components.navigation.ActionBarIcon
import com.squadris.squadris.compose.components.navigation.NavIconType
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.utils.RefreshableViewModel.Companion.requestData
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.base.navigation.NavigationNode.Companion.navigate
import study.me.please.base.navigation.NavigationRoot
import study.me.please.data.io.UnitsFilter
import study.me.please.data.io.subjects.UnitIO
import study.me.please.ui.collection.detail.REQUEST_DATA_SAVE_DELAY
import study.me.please.ui.collection.detail.questions.detail.INPUT_DELAYED_RESPONSE_MILLIS
import study.me.please.ui.components.pull_refresh.PullRefreshScreen
import study.me.please.ui.components.session.launcher.SessionLauncher
import study.me.please.ui.units.components.CollectionDrawer
import study.me.please.ui.units.components.EmbeddedDrawerState
import study.me.please.ui.units.components.rememberEmbeddedDrawerState
import study.me.please.ui.units.utils.UnitActionType

/**
 * List of subjects specific to a collection
 *
 * This screen is the centre and beginning for any new learning subject
 */
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CollectionDetailScreen(
    collectionUid: String,
    toolbarTitle: String? = "",
    viewModel: CollectionUnitsViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val navController = LocalNavController.current

    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberEmbeddedDrawerState(defaultValue = false)

    val units = viewModel.units.collectAsState(initial = listOf())

    val currentPagerIndex = rememberSaveable(collectionUid) { mutableIntStateOf(0) }
    val lastIndex = remember {
        mutableIntStateOf((units.value?.lastIndex ?: 0).coerceAtLeast(0))
    }
    val showSessionLauncher = remember { mutableStateOf(false) }

    val pagerState = rememberPagerState(
        initialPage = lastIndex.intValue,
        pageCount = {
            units.value?.size ?: 0
        }
    )

    LaunchedEffect(Unit) {
        viewModel.collectionUid = collectionUid
        viewModel.defaultUnitPrefix = context.getString(R.string.unit_heading_prefix)
        viewModel.requestData(isSpecial = true)
    }

    if(showSessionLauncher.value) {
        SessionLauncher(
            collectionUidList = listOf(collectionUid),
            containsAll = false,
            onDismissRequest = {
                showSessionLauncher.value = false
            }
        )
    }

    PullRefreshScreen(
        viewModel = viewModel,
        title = (units.value?.getOrNull(currentPagerIndex.intValue)?.name ?: "").ifEmpty {
            stringResource(R.string.unit_heading_default, currentPagerIndex.intValue + 1)
        },
        subtitle = toolbarTitle,
        navIconType = NavIconType.BACK,
        actionIcons = {
            ActionBarIcon(
                text = stringResource(id = R.string.collection_detail_start_session),
                imageVector = Icons.Outlined.PlayArrow,
                onClick = {
                    showSessionLauncher.value = true
                }
            )
            ActionBarIcon(
                text = stringResource(id = R.string.screen_questions),
                imageVector = Icons.Outlined.Inventory2,
                onClick = {
                    viewModel.collection.value?.uid?.let { uid ->
                        navController?.navigate(
                            NavigationRoot.CollectionQuestions,
                            data = NavigationRoot.CollectionQuestions.CollectionQuestionsArgument(
                                collectionUid = uid,
                                toolbarTitle = toolbarTitle ?: ""
                            )
                        )
                    }
                }
            )
            ActionBarIcon(
                text = stringResource(id = R.string.screen_collection_about),
                imageVector = Icons.Outlined.Description,
                onClick = {
                    viewModel.collection.value?.uid?.let { uid ->
                        navController?.navigate(
                            NavigationRoot.CollectionAbout,
                            data = NavigationRoot.CollectionQuestions.CollectionQuestionsArgument(
                                collectionUid = uid,
                                toolbarTitle = toolbarTitle ?: ""
                            )
                        )
                    }
                }
            )
        }
    ) {
        BackHandler(drawerState.isExpanded.value) {
            drawerState.isExpanded.value = false
        }

        Box {
            CollectionDrawer(
                modifier = Modifier
                    .align(Alignment.CenterStart),
                state = drawerState,
                viewModel = viewModel,
                collectionUid = collectionUid,
                onIndexChange = { index ->
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .offset(
                        x = drawerState.xOffsetDp.dp.plus(drawerState.drawerWidth),
                        y = 0.dp
                    )
            ) {
                if(units.value != null) {
                    ContentLayout(
                        viewModel = viewModel,
                        pagerState = pagerState,
                        drawerState = drawerState,
                        units = units,
                        currentPagerIndex = currentPagerIndex,
                        lastIndex = lastIndex
                    )
                }else {
                    //TODO shimmerlayout
                }
            }
        }
    }
}

/** content that requires data */
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ContentLayout(
    viewModel: CollectionUnitsViewModel,
    pagerState: PagerState,
    drawerState: EmbeddedDrawerState,
    units: State<List<UnitIO>?>,
    currentPagerIndex: MutableState<Int>,
    lastIndex: MutableState<Int>
) {
    val focusManager = LocalFocusManager.current
    val density = LocalDensity.current

    val hasScrolled = rememberSaveable {
        mutableStateOf(false)
    }
    val delayedScope = rememberCoroutineScope()
    val coroutineScope = rememberCoroutineScope()
    val inputScope = rememberCoroutineScope()
    val isSearchChipChecked = rememberSaveable(viewModel) { mutableStateOf(false) }
    val currentSearchIndex = rememberSaveable(viewModel) {
        mutableIntStateOf(0)
    }

    val filter = viewModel.filter.collectAsState()
    val searchResults = viewModel.searchResults.collectAsState(initial = null)

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { index ->
            currentPagerIndex.value = index

            if(index != viewModel.collection.value?.lastSelectedUnitIndex) {
                viewModel.collection.value?.lastSelectedUnitIndex = index
                delayedScope.coroutineContext.cancelChildren()
                delayedScope.launch {
                    delay(REQUEST_DATA_SAVE_DELAY)
                    viewModel.updateCollection()
                }
            }
        }
    }
    LaunchedEffect(units.value?.size) {
        coroutineScope.launch {
            if(pagerState.pageCount > 0 && !hasScrolled.value) {
                lastIndex.value = (units.value?.lastIndex ?: 0).coerceAtLeast(0)
                pagerState.scrollToPage(lastIndex.value)
                hasScrolled.value = true
            }
        }
    }

    val unitActionType = rememberSaveable {
        mutableStateOf(UnitActionType.DEFAULT)
    }

    Box {
        AnimatedVisibility(
            modifier = Modifier
                .fillMaxWidth()
                .zIndex(10f)
                // takes focus away, so there are no accidental clicks
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    focusManager.clearFocus()
                },
            visible = drawerState.isExpanded.value.not()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                NavIconType.HAMBURGER.imageVector?.let { asset ->
                    Icon(
                        modifier = Modifier
                            .padding(start = 4.dp)
                            .background(
                                color = LocalTheme.current.colors.brandMain,
                                shape = LocalTheme.current.shapes.chipShape
                            )
                            .size(42.dp)
                            .clip(LocalTheme.current.shapes.chipShape)
                            .clickable(
                                indication = rememberRipple(
                                    bounded = true,
                                    color = LocalTheme.current.colors.contrastActionLight
                                ),
                                interactionSource = remember { MutableInteractionSource() }
                            ) {
                                drawerState.isExpanded.value = true
                            }
                            .padding(6.dp),
                        imageVector = asset.first,
                        contentDescription = asset.second,
                        tint = LocalTheme.current.colors.tetrial
                    )
                }
                AnimatedVisibility(
                    visible = pagerState.pageCount > 1 && isSearchChipChecked.value.not()
                ) {
                    PagerIndicatorRow(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(bottom = 8.dp),
                        pagerState = pagerState
                    )
                }
                SearchChip(
                    modifier = Modifier.padding(end = 6.dp),
                    maxHeight = 38.sp,
                    isChecked = isSearchChipChecked,
                    text = filter.value.textFilter,
                    onSearchOutput = { output ->
                        inputScope.coroutineContext.cancelChildren()
                        inputScope.launch {
                            delay(INPUT_DELAYED_RESPONSE_MILLIS)
                            viewModel.filter.update {
                                UnitsFilter(output)
                            }
                        }
                    },
                    onClick = {
                        isSearchChipChecked.value = isSearchChipChecked.value.not()
                    },
                    extraContent = {
                        AnimatedVisibility(visible = filter.value.textFilter.isNotBlank()) {
                            Row(
                                modifier = Modifier
                                    .padding(start = 4.dp)
                                    .clip(LocalTheme.current.shapes.chipShape)
                                    .background(
                                        color = LocalTheme.current.colors.brandMainDark,
                                        shape = LocalTheme.current.shapes.chipShape
                                    ),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                val current = (currentSearchIndex.intValue + 1).coerceAtMost(searchResults.value?.size ?: 0)
                                val isEnabled = remember {
                                    derivedStateOf {
                                        (searchResults.value?.size ?: 0) > 0
                                    }
                                }

                                Text(
                                    modifier = Modifier.padding(start = 8.dp),
                                    text = "${current}/${searchResults.value?.size}",
                                    style = TextStyle(
                                        color = Color.White,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                )

                                // move up
                                Icon(
                                    modifier = Modifier
                                        .size(with(density) { 38.sp.toDp() })
                                        .clickable(
                                            indication = rememberRipple(
                                                bounded = true,
                                                color = Color.White
                                            ),
                                            enabled = isEnabled.value,
                                            interactionSource = remember { MutableInteractionSource() }
                                        ) {
                                            currentSearchIndex.intValue =
                                                (currentSearchIndex.intValue - 1)
                                                    .coerceAtLeast(0)

                                            val newResult =
                                                searchResults.value?.getOrNull(currentSearchIndex.intValue)
                                            coroutineScope.launch {
                                                units.value
                                                    ?.indexOfFirst {
                                                        it.uid == newResult?.unitUid
                                                    }
                                                    .takeIf { it != -1 }
                                                    ?.let { index ->
                                                        pagerState.animateScrollToPage(index)
                                                    }
                                            }
                                            focusManager.clearFocus()
                                            viewModel.scrollToElement.value = newResult
                                        }
                                        .padding(2.dp),
                                    imageVector = Icons.Outlined.KeyboardArrowUp,
                                    contentDescription = stringResource(R.string.accessibility_search_up),
                                    tint = if(isEnabled.value) Color.White else LocalTheme.current.colors.brandMain
                                )

                                // move down
                                Icon(
                                    modifier = Modifier
                                        .size(with(density) { 38.sp.toDp() })
                                        .clickable(
                                            indication = rememberRipple(
                                                bounded = true,
                                                color = Color.White
                                            ),
                                            enabled = isEnabled.value,
                                            interactionSource = remember { MutableInteractionSource() }
                                        ) {
                                            currentSearchIndex.intValue =
                                                (currentSearchIndex.intValue + 1)
                                                    .coerceAtMost(
                                                        searchResults.value?.size?.minus(1) ?: 0
                                                    )

                                            val newResult =
                                                searchResults.value?.getOrNull(currentSearchIndex.intValue)
                                            coroutineScope.launch {
                                                units.value
                                                    ?.indexOfFirst {
                                                        it.uid == newResult?.unitUid
                                                    }
                                                    .takeIf { it != -1 }
                                                    ?.let { index ->
                                                        pagerState.animateScrollToPage(index)
                                                    }
                                            }
                                            focusManager.clearFocus()
                                            viewModel.scrollToElement.value = newResult
                                        }
                                        .padding(2.dp),
                                    imageVector = Icons.Outlined.KeyboardArrowDown,
                                    contentDescription = stringResource(R.string.accessibility_search_down),
                                    tint = if(isEnabled.value) Color.White else LocalTheme.current.colors.brandMain
                                )
                                Spacer(Modifier)
                            }
                        }
                    }
                )
            }
        }
        HorizontalPager(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTapGestures(onTap = {
                        drawerState.isExpanded.value = false
                        unitActionType.value = UnitActionType.DEFAULT
                        focusManager.clearFocus()
                    })
                },
            state = pagerState,
            beyondBoundsPageCount = 1
        ) { index ->
            units.value?.getOrNull(index)?.let { unit ->
                UnitContent(
                    unit = unit,
                    collectionViewModel = viewModel,
                    unitActionType = unitActionType,
                    requestRefresh = {
                        viewModel.requestData(isSpecial = true)
                    }
                )
            }
        }
    }
}

// To get scroll offset
val PagerState.pageOffset: Float
    get() = this.currentPage + this.currentPageOffsetFraction

@Composable
private fun PagerIndicatorRow(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    color: Color = LocalTheme.current.colors.tetrial
) {
    val density = LocalDensity.current

    val dotSize = with(density) { 12.dp.toPx() }
    val activeDotWidth = with(density) { 46.dp.toPx() }

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(pagerState.pageCount) { index ->
            val posOffset = pagerState.pageOffset
            val dotOffset = posOffset % 1
            val current = posOffset.toInt()

            val factor = (dotOffset * (activeDotWidth - dotSize))
            val calculatedWidth = when {
                index == current -> activeDotWidth - factor
                index - 1 == current || (index == 0 && posOffset > pagerState.pageCount - 1) -> dotSize + factor
                else -> dotSize
            }

            Box(
                modifier = Modifier
                    .background(
                        color = color,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .height(with(density) { dotSize.toDp() })
                    .width(with(density) { calculatedWidth.toDp() })
            )
        }
    }
}