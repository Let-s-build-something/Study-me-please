package study.me.please.ui.components.session.launcher

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.squadris.squadris.compose.base.LocalNavController
import com.squadris.squadris.compose.components.SimpleModalBottomSheet
import com.squadris.squadris.compose.components.chips.DEFAULT_ANIMATION_LENGTH_SHORT
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.utils.OnLifecycleEvent
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.base.navigation.NavigationRoot
import study.me.please.ui.components.ImageAction
import study.me.please.ui.components.InteractiveCardMode
import study.me.please.ui.components.LineButton
import study.me.please.ui.components.OutlinedButton
import study.me.please.ui.components.rememberInteractiveCardState
import study.me.please.ui.components.session.SessionCard

/**
 * Base sheet for adding item to either session or collection
 */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun SessionLauncher(
    modifier: Modifier = Modifier,
    viewModel: SessionLauncherViewModel = hiltViewModel(),
    collectionUidList: List<String>? = null,
    questionUidList: List<String>? = null,
    containsAll: Boolean = true,
    sheetState: SheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
    onDismissRequest: () -> Unit = {}
) {
    val navController = LocalNavController.current
    val context = LocalContext.current

    val scope = rememberCoroutineScope()

    val sessions = viewModel.sessions.collectAsState()

    OnLifecycleEvent { event ->
        if(event == Lifecycle.Event.ON_RESUME) {
            viewModel.requestSessions(
                containsAll = containsAll,
                collectionUidList = collectionUidList,
                questionUidList = questionUidList
            )
        }
    }

    SimpleModalBottomSheet(
        onDismissRequest = {
            onDismissRequest()
            scope.launch {
                sheetState.hide()
            }
        },
        sheetState = sheetState
    ) {
        AnimatedContent(
            targetState = sessions.value == null,
            label = ""
        ) { isShimmer ->
            if(isShimmer) {
                //TODO shimmer
            }else {
                val coroutineScope = rememberCoroutineScope()
                val selectedSessionUidList = remember { mutableStateListOf<String>() }

                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .animateContentSize()
                        .padding(16.dp)
                        .padding(bottom = 16.dp)
                ) {
                    val footerItem: @Composable () -> Unit = {
                        AnimatedVisibility(
                            visible = selectedSessionUidList.size > 0,
                            enter = slideInVertically(initialOffsetY = { it.times(2) }),
                            exit = slideOutVertically(targetOffsetY = { it.times(2) })
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 12.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.End
                            ) {
                                OutlinedButton(
                                    thenModifier = Modifier
                                        .padding(vertical = 6.dp, horizontal = 6.dp),
                                    text = stringResource(id = R.string.button_cancel),
                                    isActivated = false,
                                    onClick = {
                                        selectedSessionUidList.clear()
                                        coroutineScope.launch {
                                            sheetState.hide()
                                        }
                                    }
                                )
                                Spacer(modifier = Modifier.width(12.dp))
                                ImageAction(
                                    text = stringResource(id = R.string.session_launcher_action_confirm),
                                    onClick = {
                                        viewModel.saveSessionSelection(
                                            selectedSessionUidList = selectedSessionUidList,
                                            collectionUidList = collectionUidList,
                                            questionUidList = questionUidList
                                        )
                                    }
                                )
                            }
                        }
                    }

                    val interactiveCardStates = sessions.value?.map {
                        rememberInteractiveCardState(mode = mutableStateOf(
                            InteractiveCardMode.CHECKING
                        ))
                    }

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        verticalArrangement = Arrangement.spacedBy(LocalTheme.current.shapes.betweenItemsSpace)
                    ) {
                        item {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(LocalTheme.current.shapes.circularActionShape)
                                    .clickable {
                                        navController?.navigate(
                                            NavigationRoot.SessionDetail.createRoute(
                                                NavigationRoot.SessionDetail.SessionDetailArgument(
                                                    toolbarTitle = context.getString(R.string.session_detail_default_toolbar),
                                                    collectionUidList = collectionUidList.orEmpty(),
                                                    questionUidList = questionUidList.orEmpty()
                                                )
                                            )
                                        )
                                        onDismissRequest()
                                    },
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Image(
                                    modifier = Modifier
                                        .size(48.dp)
                                        .padding(8.dp),
                                    painter = rememberVectorPainter(image = Icons.Outlined.Add),
                                    contentDescription = null,
                                    colorFilter = ColorFilter.tint(color = LocalTheme.current.colors.secondary)
                                )
                                LineButton(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(8.dp),
                                    text = AnnotatedString(
                                        stringResource(R.string.session_launcher_new)
                                    ),
                                    textStyle = LocalTheme.current.styles.menuItem.copy(color = LocalTheme.current.colors.secondary)
                                )
                            }
                        }
                        itemsIndexed(
                            sessions.value.orEmpty(),
                            key = { _, session -> session.uid }
                        ) { index, session ->
                            interactiveCardStates?.getOrNull(index)?.let { state ->
                                LaunchedEffect(state.isChecked.value) {
                                    if(state.isChecked.value && state.isEnabled.value) {
                                        selectedSessionUidList.add(session.uid)
                                    }else selectedSessionUidList.remove(session.uid)
                                }

                                LaunchedEffect(Unit) {
                                    state.isEnabled.value = session.isPlayable.not()
                                    state.isChecked.value = session.isPlayable
                                }

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .animateItemPlacement(
                                            tween(
                                                durationMillis = DEFAULT_ANIMATION_LENGTH_SHORT,
                                                easing = LinearOutSlowInEasing
                                            )
                                        ),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    SessionCard(
                                        modifier = Modifier.fillMaxWidth(0.8f),
                                        verticalAlignment = Alignment.CenterVertically,
                                        session = session,
                                        state = state
                                    )
                                    AnimatedVisibility(session.isPlayable) {
                                        ImageAction(
                                            modifier = Modifier.wrapContentWidth(),
                                            leadingImageVector = Icons.Outlined.PlayArrow,
                                            text = stringResource(id = R.string.button_play)
                                        ) {
                                            navController?.navigate(
                                                NavigationRoot.SessionPlay.createRoute(
                                                    NavigationRoot.SessionPlay.SessionPlayArgument(
                                                        toolbarTitle = session.name,
                                                        sessionUid = session.uid
                                                    )
                                                )
                                            )
                                            onDismissRequest()
                                        }
                                    }
                                }
                            }
                        }
                        item {
                            footerItem()
                        }
                    }
                }
            }
        }
    }
}