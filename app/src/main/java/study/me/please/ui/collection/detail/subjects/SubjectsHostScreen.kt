package study.me.please.ui.collection.detail.subjects

import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.SecondaryScrollableTabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.squadris.squadris.compose.components.SearchChip
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.ext.customTabIndicatorOffset
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.base.BrandBaseScreen
import study.me.please.base.navigation.ActionBarIcon
import study.me.please.base.navigation.NavIconType
import study.me.please.data.io.subjects.SubjectIO
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.ComponentHeaderButton
import study.me.please.ui.components.collapsing_layout.CollapsingBehavior
import study.me.please.ui.components.collapsing_layout.CollapsingLayout

private const val ADD_NEW_SUBJECT_UID = "add_new_subject_uid"
private const val SEARCH_TEXT_UID = "search_text_uid"

/**
 * List of subjects specific to a collection
 *
 * This screen is the centre and beginning for any new learning subject
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SubjectsHostScreen(
    collectionUid: String,
    toolbarTitle: String? = "",
    viewModel: SubjectsViewModel = hiltViewModel()
) {
    val subjects = viewModel.subjects.collectAsState(initial = listOf())
    val filter = viewModel.filter.collectAsState()

    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    val isSearchChipChecked = remember(collectionUid) { mutableStateOf(false) }
    val currentPagerIndex = remember(collectionUid) { mutableIntStateOf(0) }
    val showDeleteDialog = remember(collectionUid) { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.requestSubjectsList(collectionUid)
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

    BrandBaseScreen(
        title = toolbarTitle,
        subtitle = stringResource(R.string.screen_subject),
        navIconType = NavIconType.CLOSE,
        actionIcons = {
            ActionBarIcon(
                text = stringResource(id = R.string.button_delete),
                imageVector = Icons.Outlined.Delete,
                onClick = {
                    showDeleteDialog.value = true
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

                CollapsingLayout(
                    modifier = Modifier.fillMaxSize(),
                    state = viewModel.collapsingLayoutState,
                    content = listOf(
                        @Composable {
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
                                listOf(SubjectIO(collectionUid = SEARCH_TEXT_UID))
                                    .plus(subjects.value.orEmpty())
                                    .plus(SubjectIO(collectionUid = ADD_NEW_SUBJECT_UID))
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
                                                        coroutineScope.launch {
                                                            pagerState.animateScrollToPage(index.minus(1))
                                                        }
                                                    }
                                                )
                                            }
                                        }
                                    }
                            }
                        } to CollapsingBehavior.ALWAYS,
                        @Composable {
                            HorizontalPager(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f),
                                state = pagerState
                            ) { index ->
                                subjects.value?.getOrNull(index)?.let { subject ->
                                    SubjectScreen(
                                        subject = subject,
                                        viewModel = viewModel
                                    )
                                }
                            }
                        } to CollapsingBehavior.NONE
                    )
                )
            }else {
                //TODO shimmerlayout
            }
        }
    }
}