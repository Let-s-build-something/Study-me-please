package study.me.please.ui.units

import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.DeleteSweep
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.Inventory2
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.squadris.squadris.compose.components.MinimalisticIcon
import com.squadris.squadris.compose.components.SearchChip
import com.squadris.squadris.compose.components.input.EditFieldInput
import com.squadris.squadris.compose.theme.Colors
import com.squadris.squadris.compose.theme.LocalTheme
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.base.LocalIsTablet
import study.me.please.base.LocalNavController
import study.me.please.base.navigation.ActionBarIcon
import study.me.please.base.navigation.NavIconType
import study.me.please.base.navigation.NavigationNode.Companion.navigate
import study.me.please.base.navigation.NavigationRoot
import study.me.please.data.io.UnitsFilter
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.ui.collection.RefreshableViewModel.Companion.requestData
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.ComponentHeaderButton
import study.me.please.ui.components.ExpandableContent
import study.me.please.ui.components.ImageAction
import study.me.please.ui.components.pull_refresh.PullRefreshScreen
import study.me.please.ui.components.session.launcher.SessionLauncher

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
    val localFocusManager = LocalFocusManager.current
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current

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
        navIconType = if(drawerState.isExpanded.value.not()) NavIconType.HAMBURGER else NavIconType.CLOSE,
        onNavigationIconClick = {
            if(drawerState.isExpanded.value.not()) {
                drawerState.isExpanded.value = true
            }else onBackPressedDispatcher?.onBackPressedDispatcher?.onBackPressed()
        },
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
        BackHandler(drawerState.isExpanded.value.not()) {
            drawerState.isExpanded.value = true
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
                    LaunchedEffect(pagerState) {
                        snapshotFlow { pagerState.currentPage }.collect { index ->
                            currentPagerIndex.intValue = index
                            viewModel.currentUnit = units.value?.getOrNull(index)
                        }
                    }
                    LaunchedEffect(units.value?.size) {
                        coroutineScope.launch {
                            lastIndex.intValue = (units.value?.lastIndex ?: 0).coerceAtLeast(0)
                            pagerState.animateScrollToPage(lastIndex.intValue)
                        }
                    }

                    val unitActionType = rememberSaveable {
                        mutableStateOf(UnitActionType.DEFAULT)
                    }

                    HorizontalPager(
                        modifier = Modifier
                            .fillMaxSize()
                            .pointerInput(Unit) {
                                detectTapGestures(onTap = {
                                    drawerState.isExpanded.value = false
                                    unitActionType.value = UnitActionType.DEFAULT
                                    localFocusManager.clearFocus()
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
                }else {
                    //TODO shimmerlayout
                }
            }
        }
    }
}

private const val SCREEN_WIDTH_PART_OVERVIEW_MOBILE = 0.6
private const val SCREEN_WIDTH_PART_OVERVIEW_TABLET = 0.4

/** Drawer embedded within content with slight elevation */
data class EmbeddedDrawerState(

    /** X coordinate offset based on [isExpanded] */
    val xOffsetDp: Float,

    /** whether the drawer is expanded or not */
    val isExpanded: MutableState<Boolean>,

    /** width of the drawer composable */
    val drawerWidth: Dp
)

/**
 * Drawer embedded within content with slight elevation
 */
@Composable
fun rememberEmbeddedDrawerState(
    defaultValue: Boolean = true
): EmbeddedDrawerState {
    val configuration = LocalConfiguration.current
    val isTablet = LocalIsTablet.current

    val isDrawerExpanded = rememberSaveable(defaultValue) {
        mutableStateOf(defaultValue)
    }
    val drawerWidthDp = configuration.screenWidthDp.times(
        if(isTablet) SCREEN_WIDTH_PART_OVERVIEW_TABLET else SCREEN_WIDTH_PART_OVERVIEW_MOBILE
    )

    val xOffsetDp: Float by animateFloatAsState(
        if(isDrawerExpanded.value) {
            0f
        }else -drawerWidthDp.toFloat(),
        label = ""
    )

    return EmbeddedDrawerState(
        xOffsetDp = xOffsetDp,
        isExpanded = isDrawerExpanded,
        drawerWidth = drawerWidthDp.dp
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun CollectionDrawer(
    modifier: Modifier = Modifier,
    viewModel: CollectionUnitsViewModel,
    onIndexChange: (index: Int) -> Unit,
    collectionUid: String,
    state: EmbeddedDrawerState = rememberEmbeddedDrawerState()
) {
    val context = LocalContext.current
    val localFocusManager = LocalFocusManager.current

    val units = viewModel.units.collectAsState(initial = listOf())
    val filter = viewModel.filter.collectAsState()
    val columnState = rememberLazyListState()

    val showDeleteDialog = remember(viewModel) { mutableStateOf(false) }
    val isSearchChipChecked = remember(viewModel) { mutableStateOf(false) }
    val checkedUnits = remember(collectionUid) { mutableStateListOf<String>() }
    val expandedUnits = remember { mutableStateListOf<String>() }

    if(showDeleteDialog.value) {
        val input = remember { mutableStateOf("") }

        BasicAlertDialog(
            title = stringResource(id = R.string.units_delete_dialog_title),
            content = stringResource(
                id = R.string.units_delete_dialog_content,
                checkedUnits.size
            ),
            icon = Icons.Outlined.Delete,
            confirmButtonState = ButtonState(
                text = stringResource(id = R.string.button_confirm),
                enabled = input.value == stringResource(id = R.string.units_delete_dialog_confirm_hint)
            ) {
                viewModel.deleteUnits(checkedUnits)
            },
            dismissButtonState = ButtonState(
                text = stringResource(id = R.string.button_dismiss)
            ),
            extraContent = {
                EditFieldInput(
                    modifier = Modifier.padding(16.dp),
                    value = "",
                    hint = stringResource(R.string.units_delete_dialog_confirm_hint),
                    maxLines = 1
                ) { output ->
                    input.value = output
                }
            },
            onDismissRequest = {
                checkedUnits.clear()
                showDeleteDialog.value = false
            }
        )
    }

    BackHandler(checkedUnits.size > 0) {
        checkedUnits.clear()
    }

    Card(
        modifier = modifier
            .width(state.drawerWidth)
            .fillMaxHeight()
            .offset(
                x = state.xOffsetDp.dp,
                y = 0.dp
            )
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    localFocusManager.clearFocus()
                })
            },
        elevation = LocalTheme.styles.cardClickableElevation,
        shape = RectangleShape,//LocalTheme.shapes.componentShape,
        colors = CardDefaults.cardColors(
            containerColor = LocalTheme.colors.onBackgroundComponent,
            contentColor = LocalTheme.colors.onBackgroundComponent
        )
    ) {
        LazyColumn(
            state = columnState
        ) {
            stickyHeader {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.units_overview),
                        style = LocalTheme.styles.subheading
                    )
                    MinimalisticIcon(
                        imageVector = Icons.Outlined.Close,
                        onClick = {
                            state.isExpanded.value = false
                        }
                    )
                }
            }
            item {
                SearchChip(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    isChecked = isSearchChipChecked,
                    text = filter.value.textFilter,
                    onSearchOutput = { output ->
                        viewModel.filter.update {
                            UnitsFilter(output)
                        }
                    },
                    onClick = {
                        isSearchChipChecked.value = true
                    }
                )
            }
            item {
                Crossfade(
                    modifier = Modifier
                        .padding(top = 32.dp, start = 8.dp)
                        .fillMaxWidth(),
                    targetState = checkedUnits.size > 0,
                    label = ""
                ) { isAnyChecked ->
                    if(isAnyChecked) {
                        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                            ImageAction(
                                leadingImageVector = Icons.Outlined.DeleteSweep,
                                text = stringResource(id = R.string.button_delete),
                                containerColor = Colors.RED_ERROR
                            ) {
                                showDeleteDialog.value = true
                            }
                        }
                    }else {
                        ComponentHeaderButton(
                            modifier = Modifier.fillMaxWidth(),
                            elevation = ButtonDefaults.elevatedButtonElevation(
                                0.dp, 0.dp, 0.dp, 0.dp, 0.dp
                            ),
                            onClick = {
                                viewModel.addNewUnit(
                                    collectionUid = collectionUid,
                                    prefix = context.getString(R.string.unit_heading_prefix)
                                )
                                onIndexChange(units.value?.size ?: 0)
                                state.isExpanded.value = false
                            },
                            text = stringResource(R.string.units_create_new),
                            textStyle = LocalTheme.styles.menuItem.copy(color = LocalTheme.colors.secondary)
                        )
                    }
                }
            }
            itemsIndexed(
                units.value.orEmpty()
            ) { index, unit ->
                Row(modifier = Modifier.padding(start = 8.dp)) {
                    AnimatedVisibility(visible = checkedUnits.size > 0) {
                        Checkbox(
                            modifier = Modifier.offset(x = -(12).dp),
                            checked = checkedUnits.contains(unit.uid),
                            onCheckedChange = { isChecked ->
                                checkedUnits.run {
                                    if(isChecked) {
                                        add(unit.uid)
                                    } else {
                                        remove(unit.uid)
                                    }
                                }
                            },
                            colors = LocalTheme.styles.checkBoxColorsDefault
                        )
                    }
                    ExpandableContent(
                        modifier = Modifier
                            .fillMaxWidth()
                            .combinedClickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = rememberRipple(),
                                onClick = {
                                    // checking mode vs regular click
                                    if (checkedUnits.size > 0) {
                                        checkedUnits.run {
                                            if (checkedUnits.contains(unit.uid)) {
                                                remove(unit.uid)
                                            } else {
                                                add(unit.uid)
                                            }
                                        }
                                    } else {
                                        onIndexChange(units.value?.indexOf(unit) ?: 0)
                                    }
                                },
                                onLongClick = {
                                    checkedUnits.add(unit.uid)
                                }
                            ),
                        arrowModifier = Modifier.clickable(
                            onClick = {
                                if (expandedUnits.contains(unit.uid)) {
                                    expandedUnits.remove(unit.uid)
                                } else expandedUnits.add(unit.uid)
                            },
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple()
                        ),
                        text = unit.name.ifEmpty {
                            stringResource(R.string.unit_heading_default, index + 1)
                        },
                        collapsedPadding = 8.dp,
                        isExpanded = expandedUnits.contains(unit.uid)
                    ) {
                        unit.paragraphs.forEach { paragraph ->
                            DashboardChildParagraph(
                                paragraph = paragraph,
                                openParagraph = { uidPath ->
                                    onIndexChange(units.value?.indexOf(unit) ?: 0)
                                    viewModel.scrollToElement.value = CollectionUnitsViewModel.ScrollToElement(
                                        elementUidList = uidPath,
                                        unitUid = unit.uid
                                    )
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun DashboardChildParagraph(
    paragraph: ParagraphIO,
    openParagraph: (uidPath: MutableList<String>) -> Unit,
    uidPath: MutableList<String> = mutableListOf(paragraph.uid)
) {
    paragraph.paragraphs.forEach { nestedParagraph ->
        if(nestedParagraph.paragraphs.isEmpty()) {
            Text(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .fillMaxWidth()
                    .clickable(
                        onClick = {
                            openParagraph(uidPath.apply { add(nestedParagraph.uid) })
                        },
                        interactionSource = remember { MutableInteractionSource() },
                        indication = rememberRipple()
                    )
                    .padding(8.dp),
                text = nestedParagraph.name,
                style = LocalTheme.styles.category
            )
        }else {
            val isExpanded = remember(paragraph.uid) {
                mutableStateOf(false)
            }

            ExpandableContent(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .fillMaxWidth()
                    .clickable(
                        onClick = {
                            openParagraph(uidPath.apply { add(nestedParagraph.uid) })
                        },
                        interactionSource = remember(paragraph.uid) { MutableInteractionSource() },
                        indication = rememberRipple()
                    ),
                arrowModifier = Modifier.clickable(
                    onClick = {
                        isExpanded.value = !isExpanded.value
                    },
                    interactionSource = remember(paragraph.uid) { MutableInteractionSource() },
                    indication = rememberRipple()
                ),
                text = nestedParagraph.name.ifEmpty { stringResource(R.string.subject_add_paragraph) },
                collapsedPadding = 8.dp,
                textStyle = LocalTheme.styles.category,
                isExpanded = isExpanded.value
            ) {
                DashboardChildParagraph(
                    paragraph = nestedParagraph,
                    uidPath = uidPath.apply { add(nestedParagraph.uid) },
                    openParagraph = openParagraph
                )
            }
        }
    }
}