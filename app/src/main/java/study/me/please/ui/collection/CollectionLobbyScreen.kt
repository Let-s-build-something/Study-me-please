package study.me.please.ui.collection

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.DeleteSweep
import androidx.compose.material.icons.outlined.Deselect
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.SelectAll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.squadris.squadris.compose.base.LocalNavController
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.compose.theme.SharedColors
import com.squadris.squadris.ext.scalingClickable
import com.squadris.squadris.utils.OnLifecycleEvent
import com.squadris.squadris.utils.RefreshableViewModel.Companion.requestData
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.base.navigation.NavigationRoot
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.CollectionCard
import study.me.please.ui.components.ComponentHeaderButton
import study.me.please.ui.components.ImageAction
import study.me.please.ui.components.ListOptionsBottomSheet
import study.me.please.ui.components.pull_refresh.PullRefreshScreen
import study.me.please.ui.components.session.launcher.SessionLauncher
import study.me.please.ui.session.lobby.EditableListShimmerLayout

/** Screen with user's collections */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun CollectionLobbyScreen(
    viewModel: CollectionViewModel = hiltViewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    val collections = viewModel.collections.collectAsState()

    val bottomSheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(skipHiddenState = false)
    )

    val showDeleteDialog = remember { mutableStateOf(false) }
    val showSessionLauncher = remember { mutableStateOf<Boolean?>(null) }
    val checkedUidList = remember { mutableStateListOf<String>() }
    val selectedUid = remember { mutableStateOf<String?>(null) }

    val navController = LocalNavController.current
    val context = LocalContext.current

    OnLifecycleEvent { event ->
        if(event == Lifecycle.Event.ON_RESUME) {
            viewModel.requestData(isSpecial = true)
        }
    }


    val stopChecking = {
        Log.d("kostka_test", "stopChecking")
        checkedUidList.clear()
        coroutineScope.launch {
            bottomSheetState.bottomSheetState.hide()
        }
    }

    LaunchedEffect(checkedUidList.size) {
        coroutineScope.launch {
            if(checkedUidList.size > 0) {
                bottomSheetState.bottomSheetState.expand()
            } else stopChecking()
        }
    }

    if(showDeleteDialog.value) {
        BasicAlertDialog(
            title = stringResource(id = R.string.collection_delete_dialog_title),
            content = stringResource(
                id = R.string.collection_delete_dialog_description,
                checkedUidList.size
            ),
            icon = Icons.Outlined.Delete,
            confirmButtonState = ButtonState(
                text = stringResource(id = R.string.button_confirm)
            ) {
                viewModel.requestCollectionDeletion(checkedUidList.toSet())
                stopChecking()
            },
            dismissButtonState = ButtonState(
                text = stringResource(id = R.string.button_dismiss)
            ),
            onDismissRequest = { showDeleteDialog.value = false }
        )
    }

    // whether it should contain all or not
    showSessionLauncher.value?.let { justAdding ->
        SessionLauncher(
            collectionUidList = checkedUidList,
            containsAll = justAdding,
            onDismissRequest = {
                showSessionLauncher.value = null
            }
        )
    }

    PullRefreshScreen(
        modifier = Modifier.fillMaxSize(),
        viewModel = viewModel,
        title = stringResource(id = R.string.screen_collection_title)
    ) {
        BackHandler(checkedUidList.size > 0) {
            stopChecking()
        }

        if(collections.value == null) {
            EditableListShimmerLayout()
        }else {
            ListOptionsBottomSheet(
                onDismissRequest = {
                    Log.d("kostka_test", "onDismissRequest")
                    stopChecking()
                },
                actions = {
                    ImageAction(
                        leadingImageVector = Icons.Outlined.DeleteSweep,
                        text = stringResource(id = R.string.button_delete),
                        containerColor = SharedColors.RED_ERROR
                    ) {
                        showDeleteDialog.value = true
                    }
                    ImageAction(
                        leadingImageVector = Icons.Outlined.SelectAll,
                        text = stringResource(id = R.string.button_select_all)
                    ) {
                        checkedUidList.addAll(collections.value?.map { it.uid }.orEmpty())
                    }
                    ImageAction(
                        leadingImageVector = Icons.Outlined.Deselect,
                        text = stringResource(id = R.string.button_deselect)
                    ) {
                        checkedUidList.clear()
                    }
                    ImageAction(
                        leadingImageVector = Icons.Outlined.Add,
                        text = stringResource(id = R.string.button_add_to)
                    ) {
                        showSessionLauncher.value = true
                    }
                    val toolbarText = stringResource(id = R.string.session_detail_default_toolbar)
                    ImageAction(
                        leadingImageVector = Icons.Outlined.PlayArrow,
                        text = stringResource(id = R.string.button_start_session)
                    ) {
                        navController?.navigate(
                            NavigationRoot.SessionDetail.createRoute(
                                NavigationRoot.SessionDetail.SessionDetailArgument(
                                    toolbarTitle = toolbarText,
                                    collectionUidList = checkedUidList
                                )
                            )
                        )
                        stopChecking()
                    }
                },
                state = bottomSheetState
            ) { _ ->
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(LocalTheme.current.shapes.betweenItemsSpace)
                ) {
                    stickyHeader {
                        ComponentHeaderButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = LocalTheme.current.shapes.betweenItemsSpace),
                            text = stringResource(id = R.string.add_new_collection)
                        ) {
                            navController?.navigate(
                                NavigationRoot.CollectionDetail.createRoute(
                                    NavigationRoot.CollectionDetail.CollectionDetailArgument(
                                        toolbarTitle = context.getString(R.string.screen_collection_detail_new)
                                    )
                                )
                            )
                        }
                    }
                    if(collections.value.isNullOrEmpty().not()) {
                        items(
                            items = collections.value.orEmpty(),
                            key = { item ->
                                item.uid
                            }
                        ) { collection ->
                            CollectionCard(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .scalingClickable(
                                        onTap = {
                                            if (checkedUidList.size > 0) {
                                                if (checkedUidList.contains(collection.uid)) {
                                                    checkedUidList.remove(collection.uid)
                                                } else checkedUidList.add(collection.uid)
                                            } else {
                                                selectedUid.value = collection.uid
                                            }
                                        },
                                        onLongPress = {
                                            checkedUidList.add(collection.uid)
                                        }
                                    )
                                    .animateItemPlacement(),
                                data = collection,
                                onNavigateToDetail = {
                                    navController?.navigate(
                                        NavigationRoot.CollectionDetail.createRoute(
                                            NavigationRoot.CollectionDetail.CollectionDetailArgument(
                                                collectionUid = collection.uid,
                                                toolbarTitle = collection.name.ifEmpty {
                                                    context.getString(R.string.screen_collection_detail_new)
                                                }
                                            )
                                        )
                                    )
                                },
                                onNavigateToSession = {
                                    showSessionLauncher.value = false
                                },
                                onCheckedChange = { isChecked ->
                                    if(isChecked) {
                                        checkedUidList.add(collection.uid)
                                    }else checkedUidList.remove(collection.uid)
                                    selectedUid.value = null
                                },
                                isSelected = selectedUid.value == collection.uid,
                                isChecked = if(checkedUidList.size > 0) {
                                    checkedUidList.contains(collection.uid)
                                } else null
                            )
                        }
                    }else if(collections.value?.isEmpty() == true) {
                        item {
                            EmptyLayout(
                                emptyText = stringResource(id = R.string.collection_empty_error)
                            )
                        }
                    }else {
                        item {
                            // TODO loading state
                        }
                    }
                    item {
                        Spacer(modifier = Modifier.height(100.dp))
                    }
                }
            }
        }
    }
}

/** Empty state layout */
@Composable
fun EmptyLayout(
    modifier: Modifier = Modifier,
    rawAnimation: Int = R.raw.animation_empty,
    emptyText: String,
    content : @Composable ColumnScope.() -> Unit = {}
) {
    val localConfiguration = LocalConfiguration.current
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(rawAnimation)
    )

    Column(
        modifier = modifier
    ) {
        LottieAnimation(
            modifier = Modifier
                .padding(
                    top = 4.dp,
                    start = 4.dp,
                    end = 4.dp,
                    bottom = 8.dp
                )
                .height(localConfiguration.screenHeightDp.dp.div(2)),
            composition = composition,
            restartOnPlay = true,
            isPlaying = true,
            contentScale = ContentScale.Inside,
            iterations = Int.MAX_VALUE
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 8.dp,
                    end = 8.dp,
                    top = 4.dp,
                    bottom = 12.dp
                ),
            text = emptyText,
            fontSize = 18.sp,
            color = LocalTheme.current.colors.secondary,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        content()
    }
}