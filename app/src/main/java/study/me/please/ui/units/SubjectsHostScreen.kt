package study.me.please.ui.units

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.LibraryAdd
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SecondaryScrollableTabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.squadris.squadris.compose.components.SearchChip
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.ext.customTabIndicatorOffset
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.base.BrandBaseScreen
import study.me.please.base.LocalActivity
import study.me.please.base.LocalSnackbarHost
import study.me.please.base.navigation.ActionBarIcon
import study.me.please.base.navigation.NavIconType
import study.me.please.data.io.subjects.UnitIO
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.ComponentHeaderButton
import study.me.please.ui.units.UnitsViewModel.Companion.FAILED_INSERT

private const val ADD_NEW_SUBJECT_UID = "add_new_subject_uid"
private const val SEARCH_TEXT_UID = "search_text_uid"

/**
 * List of subjects specific to a collection
 *
 * This screen is the centre and beginning for any new learning subject
 */
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SubjectsHostScreen(
    collectionUid: String,
    toolbarTitle: String? = "",
    viewModel: UnitsViewModel = hiltViewModel()
) {
    val subjects = viewModel.subjects.collectAsState(initial = listOf())
    val filter = viewModel.filter.collectAsState()

    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val activity = LocalActivity.current
    val snackbarHostState = LocalSnackbarHost.current

    val isSearchChipChecked = remember(collectionUid) { mutableStateOf(false) }
    val currentPagerIndex = remember(collectionUid) { mutableIntStateOf(0) }
    val showDeleteDialog = remember(collectionUid) { mutableStateOf(false) }
    val checkedSubjects = remember(collectionUid) { mutableStateListOf<String>() }

    LaunchedEffect(Unit) {
        viewModel.requestSubjectsList(collectionUid)
    }

    LaunchedEffect(Unit) {
        viewModel.questionsGeneratingResponse.collectLatest { response ->
            checkedSubjects.clear()
            snackbarHostState?.showSnackbar(
                message = when {
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
            )
        }
    }

    if(showDeleteDialog.value) {
        subjects.value?.getOrNull(currentPagerIndex.intValue).let { subject ->
            if(subject != null) {
                BasicAlertDialog(
                    title = stringResource(id = R.string.subjects_delete_dialog_title),
                    content = stringResource(
                        id = R.string.subjects_delete_dialog_content,
                        subject.name
                    ),
                    icon = Icons.Outlined.Delete,
                    confirmButtonState = ButtonState(
                        text = stringResource(id = R.string.button_confirm)
                    ) {
                        viewModel.deleteSubject(subject.uid)
                        showDeleteDialog.value = false
                    },
                    dismissButtonState = ButtonState(
                        text = stringResource(id = R.string.button_dismiss)
                    ) {
                        showDeleteDialog.value = false
                    },
                    onDismissRequest = {
                        showDeleteDialog.value = false
                    }
                )
            }else {
                showDeleteDialog.value = false
            }
        }
    }

    BackHandler(checkedSubjects.size > 0) {
        checkedSubjects.clear()
    }

    BrandBaseScreen(
        title = toolbarTitle,
        subtitle = stringResource(R.string.screen_units),
        navIconType = NavIconType.CLOSE,
        actionIcons = {
            ActionBarIcon(
                text = stringResource(id = R.string.button_delete),
                imageVector = Icons.Outlined.Delete,
                onClick = {
                    showDeleteDialog.value = true
                }
            )
            ActionBarIcon(
                text = stringResource(id = R.string.subjects_button_generate),
                imageVector = Icons.Outlined.LibraryAdd,
                onClick = {
                    if(checkedSubjects.size > 0) {
                        if(activity != null) {
                            viewModel.generateQuestions(
                                checkedSubjectUids = checkedSubjects,
                                activity = activity,
                                collectionUid = collectionUid
                            )
                        }
                    }else {
                        subjects.value?.getOrNull(currentPagerIndex.intValue)?.let { subject ->
                            checkedSubjects.addAll(subjects.value?.map { it.uid } ?: listOf(subject.uid))
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            if(subjects.value != null) {
                val lastIndex = remember {
                    mutableIntStateOf((subjects.value?.lastIndex ?: 0).coerceAtLeast(0))
                }
                val pagerState = rememberPagerState(
                    initialPage = lastIndex.intValue,
                    pageCount = {
                        subjects.value?.size ?: 0
                    }
                )

                LaunchedEffect(pagerState) {
                    snapshotFlow { pagerState.currentPage }.collect { index ->
                        currentPagerIndex.intValue = index
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
                                checkedSubjects.clear()
                            })
                        },
                    state = pagerState,
                    // causes crashes if 0
                    beyondBoundsPageCount = 2
                ) { index ->
                    subjects.value?.getOrNull(index)?.let { subject ->
                        UnitScreen(
                            unit = subject,
                            viewModel = viewModel,
                            filtersContent = {
                                SecondaryScrollableTabRow(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 4.dp),
                                    selectedTabIndex = currentPagerIndex.intValue.plus(1),
                                    indicator = @Composable { tabPositions ->
                                        tabPositions.getOrNull(currentPagerIndex.intValue.plus(1))?.let { position ->
                                            if(pagerState.pageCount != 0) {
                                                TabRowDefaults.SecondaryIndicator(
                                                    modifier = Modifier
                                                        .customTabIndicatorOffset(position, horizontalPadding = 16.dp),
                                                    color = LocalTheme.colors.brandMain
                                                )
                                            }
                                        }
                                    },
                                    divider = {},
                                    containerColor = Color.Transparent
                                ) {
                                    listOf(UnitIO(collectionUid = SEARCH_TEXT_UID))
                                        .plus(subjects.value.orEmpty())
                                        .plus(UnitIO(collectionUid = ADD_NEW_SUBJECT_UID))
                                        .forEachIndexed { index, subject ->
                                            val modifier = Modifier
                                                .padding(horizontal = 4.dp)
                                                .wrapContentHeight()

                                            when(subject.collectionUid) {
                                                SEARCH_TEXT_UID -> {
                                                    SearchChip(
                                                        modifier = Modifier.fillMaxHeight(),
                                                        isChecked = isSearchChipChecked,
                                                        text = filter.value.textFilter,
                                                        onSearchOutput = { output ->
                                                            viewModel.filter.update {
                                                                SubjectsFilter(output)
                                                            }
                                                        },
                                                        onClick = {
                                                            isSearchChipChecked.value = true
                                                        }
                                                    )
                                                }
                                                ADD_NEW_SUBJECT_UID -> {
                                                    ComponentHeaderButton(
                                                        modifier = modifier,
                                                        onClick = {
                                                            viewModel.addNewSubject(
                                                                collectionUid = collectionUid,
                                                                prefix = context.getString(R.string.subject_heading_prefix)
                                                            )
                                                        }
                                                    )
                                                }
                                                else -> {
                                                    ComponentHeaderButton(
                                                        modifier = modifier,
                                                        startIconVector = null,
                                                        text = subject.name,
                                                        onClick = {
                                                            if(checkedSubjects.size > 0) {
                                                                if(checkedSubjects.contains(subject.uid)) {
                                                                    checkedSubjects.remove(subject.uid)
                                                                }else checkedSubjects.add(subject.uid)
                                                            }else {
                                                                coroutineScope.launch {
                                                                    pagerState.animateScrollToPage(index.minus(1))
                                                                }
                                                            }
                                                        },
                                                        extraContent = {
                                                            AnimatedVisibility(visible = checkedSubjects.size > 0) {
                                                                Checkbox(
                                                                    modifier = Modifier
                                                                        .align(Alignment.CenterVertically)
                                                                        .padding(end = 4.dp),
                                                                    checked = checkedSubjects.contains(subject.uid),
                                                                    onCheckedChange = { isChecked ->
                                                                        if(isChecked) {
                                                                            checkedSubjects.add(subject.uid)
                                                                        }else checkedSubjects.remove(subject.uid)
                                                                    },
                                                                    colors = LocalTheme.styles.checkBoxColorsDefault
                                                                )
                                                            }
                                                        }
                                                    )
                                                }
                                            }
                                        }
                                }
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