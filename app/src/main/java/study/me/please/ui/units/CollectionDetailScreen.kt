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
import androidx.compose.material.icons.outlined.LibraryAdd
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarResult
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
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.base.BrandBaseScreen
import study.me.please.base.LocalActivity
import study.me.please.base.LocalIsTablet
import study.me.please.base.LocalNavController
import study.me.please.base.LocalSnackbarHost
import study.me.please.base.navigation.ActionBarIcon
import study.me.please.base.navigation.NavIconType
import study.me.please.base.navigation.NavigationNode.Companion.navigate
import study.me.please.base.navigation.NavigationRoot
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.ComponentHeaderButton
import study.me.please.ui.components.ExpandableContent
import study.me.please.ui.components.ImageAction
import study.me.please.ui.components.LineButton
import study.me.please.ui.components.session.launcher.SessionLauncher
import study.me.please.ui.units.UnitsViewModel.Companion.FAILED_INSERT

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
    viewModel: UnitsViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val navController = LocalNavController.current
    val localFocusManager = LocalFocusManager.current
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current

    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberEmbeddedDrawerState(defaultValue = false)

    val subjects = viewModel.subjects.collectAsState(initial = listOf())

    val currentPagerIndex = rememberSaveable(collectionUid) { mutableIntStateOf(0) }
    val lastIndex = remember {
        mutableIntStateOf((subjects.value?.lastIndex ?: 0).coerceAtLeast(0))
    }
    val showSessionLauncher = remember { mutableStateOf(false) }

    val pagerState = rememberPagerState(
        initialPage = lastIndex.intValue,
        pageCount = {
            subjects.value?.size ?: 0
        }
    )

    LaunchedEffect(Unit) {
        viewModel.requestSubjectsList(
            collectionUid = collectionUid,
            defaultUnitPrefix = context.getString(R.string.unit_heading_prefix)
        )
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

    BrandBaseScreen(
        title = (subjects.value?.getOrNull(currentPagerIndex.intValue)?.name ?: "").ifEmpty {
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
    ) { paddingValues ->
        BackHandler(drawerState.isExpanded.value.not()) {
            drawerState.isExpanded.value = true
        }

        Box {
            CollectionDrawer(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(paddingValues),
                state = drawerState,
                viewModel = viewModel,
                collectionUid = collectionUid,
                onIndexChange = { index ->
                    coroutineScope.launch {
                        pagerState.scrollToPage(index)
                    }
                }
            )
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .offset(
                        x = drawerState.xOffsetDp.dp.plus(drawerState.drawerWidth),
                        y = 0.dp
                    )
            ) {
                if(subjects.value != null) {
                    LaunchedEffect(pagerState) {
                        snapshotFlow { pagerState.currentPage }.collect { index ->
                            currentPagerIndex.intValue = index
                            viewModel.currentUnit = subjects.value?.getOrNull(index)
                        }
                    }
                    LaunchedEffect(subjects.value?.size) {
                        coroutineScope.launch {
                            lastIndex.intValue = (subjects.value?.lastIndex ?: 0).coerceAtLeast(0)
                            pagerState.animateScrollToPage(lastIndex.intValue)
                        }
                    }

                    HorizontalPager(
                        modifier = Modifier
                            .fillMaxSize()
                            .pointerInput(Unit) {
                                detectTapGestures(onTap = {
                                    drawerState.isExpanded.value = false
                                    localFocusManager.clearFocus()
                                })
                            },
                        state = pagerState,
                        // causes crashes if 0
                        beyondBoundsPageCount = 2
                    ) { index ->
                        subjects.value?.getOrNull(index)?.let { subject ->
                            UnitContent(
                                unit = subject,
                                viewModel = viewModel
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
    viewModel: UnitsViewModel,
    onIndexChange: (index: Int) -> Unit,
    collectionUid: String,
    state: EmbeddedDrawerState = rememberEmbeddedDrawerState()
) {
    val context = LocalContext.current
    val snackbarHostState = LocalSnackbarHost.current
    val localFocusManager = LocalFocusManager.current
    val activity = LocalActivity.current
    val navController = LocalNavController.current

    val subjects = viewModel.subjects.collectAsState(initial = listOf())
    val filter = viewModel.filter.collectAsState()
    val columnState = rememberLazyListState()

    val showDeleteDialog = remember(viewModel) { mutableStateOf(false) }
    val isSearchChipChecked = remember(viewModel) { mutableStateOf(false) }
    val checkedUnits = remember(collectionUid) { mutableStateListOf<String>() }
    val expandedUnits = remember { mutableStateListOf<String>() }

    if(showDeleteDialog.value) {
        val input = remember { mutableStateOf("") }

        BasicAlertDialog(
            title = stringResource(id = R.string.subjects_delete_dialog_title),
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

    LaunchedEffect(Unit) {
        viewModel.questionsGeneratingResponse.collectLatest { response ->
            checkedUnits.clear()
            val snackbarMessage = when {
                response.errorCode == QuestionGenerator.GeneratingQuestionErrorCode.NOT_ENOUGH_DATA.name
                        || response.data.isNullOrEmpty() -> {
                    context.getString(R.string.subject_generating_error_no_data)
                }
                response.errorCode == FAILED_INSERT -> {
                    context.getString(R.string.subject_generating_error_update_failed)
                }
                response.data.isNotEmpty() -> context.getString(
                    R.string.subject_generating_success,
                    response.data.size
                )
                else -> context.getString(R.string.subject_generating_error_generic)
            }

            if(snackbarHostState?.showSnackbar(
                message = snackbarMessage,
                actionLabel = context.getString(R.string.unit_generating_success_action)
            ) == SnackbarResult.ActionPerformed) {
                viewModel.collection.value?.let { collection ->
                    navController?.navigate(
                        NavigationRoot.CollectionQuestions,
                        data = NavigationRoot.CollectionQuestions.CollectionQuestionsArgument(
                            collectionUid = collection.uid,
                            toolbarTitle = collection.name
                        )
                    )
                }
            }
        }
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
                        Row {
                            ImageAction(
                                leadingImageVector = Icons.Outlined.DeleteSweep,
                                text = stringResource(id = R.string.button_delete),
                                containerColor = Colors.RED_ERROR
                            ) {
                                showDeleteDialog.value = true
                            }
                            ImageAction(
                                modifier = Modifier.weight(1f, fill = true),
                                leadingImageVector = Icons.Outlined.LibraryAdd,
                                text = stringResource(id = R.string.subjects_button_generate)
                            ) {
                                if(activity != null) {
                                    viewModel.generateQuestions(
                                        checkedSubjectUids = checkedUnits,
                                        activity = activity,
                                        collectionUid = collectionUid
                                    )
                                }
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
                                onIndexChange(subjects.value?.size ?: 0)
                                state.isExpanded.value = false
                            },
                            text = stringResource(R.string.units_create_new),
                            textStyle = LocalTheme.styles.menuItem.copy(color = LocalTheme.colors.secondary)
                        )
                    }
                }
            }
            itemsIndexed(
                subjects.value.orEmpty()
            ) { index, unit ->
                Row(modifier = Modifier.padding(start = 8.dp)) {
                    ExpandableContent(
                        modifier = Modifier
                            .fillMaxWidth()
                            .combinedClickable(
                                interactionSource = remember {
                                    MutableInteractionSource()
                                },
                                indication = rememberRipple(),
                                onClick = {
                                    // checking mode vs regular click
                                    if(checkedUnits.size > 0) {
                                        checkedUnits.run {
                                            if(checkedUnits.contains(unit.uid)) {
                                                remove(unit.uid)
                                            } else {
                                                add(unit.uid)
                                            }
                                        }
                                    }else {
                                        if (expandedUnits.contains(unit.uid)) {
                                            expandedUnits.remove(unit.uid)
                                        } else expandedUnits.add(unit.uid)
                                        onIndexChange(index)
                                    }
                                },
                                onLongClick = {
                                    checkedUnits.add(unit.uid)
                                }
                            ),
                        collapsedPadding = 8.dp,
                        isExpanded = expandedUnits.contains(unit.uid),
                        collapsedContent = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
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
                                Text(
                                    text = unit.name.ifEmpty {
                                        stringResource(R.string.unit_heading_default, index + 1)
                                    },
                                    style = LocalTheme.styles.linkText.copy(color = LocalTheme.colors.secondary)
                                )
                            }
                        }
                    ) {
                        Column(
                            modifier = modifier.fillMaxWidth()
                        ) {
                            unit.paragraphs.forEach { paragraph ->
                                //TODO remove categories
                                LineButton(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable(
                                            onClick = {
                                                //TODO navigate and scroll to given paragraph
                                            },
                                            interactionSource = remember { MutableInteractionSource() },
                                            indication = rememberRipple()
                                        ),
                                    text = paragraph.localCategory?.name ?: "",
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}