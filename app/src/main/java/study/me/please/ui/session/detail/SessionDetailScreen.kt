package study.me.please.ui.session.detail

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.squadris.squadris.compose.base.LocalNavController
import com.squadris.squadris.compose.components.chips.DEFAULT_ANIMATION_LENGTH_SHORT
import com.squadris.squadris.compose.components.navigation.ActionBarIcon
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.ext.brandShimmerEffect
import com.squadris.squadris.ext.scalingClickable
import com.squadris.squadris.utils.OnLifecycleEvent
import com.squadris.squadris.utils.RefreshableViewModel.Companion.requestData
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.base.navigation.NavigationRoot
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.data.io.session.SessionIO
import study.me.please.ui.collection.detail.questions.detail.INPUT_DELAYED_RESPONSE_MILLIS
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.CollectionCard
import study.me.please.ui.components.ComponentHeaderButton
import study.me.please.ui.components.EditFieldInput
import study.me.please.ui.components.HorizontalBlock
import study.me.please.ui.components.OptionsLayout
import study.me.please.ui.components.OptionsLayoutAction
import study.me.please.ui.components.QuestionCard
import study.me.please.ui.components.checkedOptionsItems
import study.me.please.ui.components.preference_chooser.PreferenceChooser
import study.me.please.ui.components.pull_refresh.PullRefreshScreen
import study.me.please.ui.components.session.StatisticsTable
import java.util.UUID


/**
 * Screen for creating a new collection
 * including adding of questions, configuration and import of both
 */
@Composable
fun SessionDetailScreen(
    sessionUid: String,
    title: String,
    collectionUidList: List<String>? = null,
    questionUidList: List<String>? = null,
    viewModel: SessionDetailViewModel = hiltViewModel<SessionDetailViewModel, SessionDetailViewModel.SessionDetailViewModelFactory> { factory ->
        factory.create(
            sessionUid = sessionUid,
            defaultName = title,
            collectionUidList = collectionUidList.orEmpty(),
            questionUidList = questionUidList.orEmpty()
        )
    }
) {
    val session = viewModel.session.collectAsState()
    val navController = LocalNavController.current

    OnLifecycleEvent { event ->
        if(event == Lifecycle.Event.ON_CREATE) {
            viewModel.requestData(isSpecial = true)
        }
    }

    PullRefreshScreen(
        viewModel = viewModel,
        title = title,
        actionIcons = {
            ActionBarIcon(
                text = stringResource(id = R.string.button_play),
                imageVector = Icons.Outlined.PlayArrow,
                onClick = {
                    navController?.navigate(
                        NavigationRoot.SessionPlay.createRoute(
                            NavigationRoot.SessionPlay.SessionPlayArgument(
                                sessionUid = session.value?.uid ?: "",
                                toolbarTitle = session.value?.name ?: ""
                            )
                        )
                    )
                }
            )
        }
    ) {
        Crossfade(
            targetState = session.value == null,
            label = "CrossfadeContentLoading"
        ) { isLoading ->
            if(isLoading) {
                ShimmerLayout()
            }else {
                session.value?.let { safeSession ->
                    ContentLayout(
                        session = safeSession,
                        viewModel = viewModel
                    )
                }
            }
        }
    }

}

/** Layout for main content - showing actual information */
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ContentLayout(
    modifier: Modifier = Modifier,
    session: SessionIO,
    viewModel: SessionDetailViewModel
) {
    val configuration = LocalConfiguration.current
    val navController = LocalNavController.current
    val inputScope = rememberCoroutineScope()

    val questions = viewModel.questions.collectAsState()
    val questionModule = viewModel.sessionPreferenceModule.collectAsState()
    val collections = viewModel.collections.collectAsState()


    val showDialog = remember { mutableStateOf(false) }
    val checkedUidList = remember { mutableStateListOf<String>() }

    BackHandler(checkedUidList.size > 0) {
        checkedUidList.clear()
    }

    if(showDialog.value) {
        BasicAlertDialog(
            title = stringResource(R.string.collection_remove_dialog_title),
            content = stringResource(R.string.collection_remove_dialog_description, checkedUidList.size),
            icon = Icons.Outlined.Delete,
            confirmButtonState = ButtonState(
                text = stringResource(id = R.string.button_confirm)
            ) {
                viewModel.removeItems(checkedUidList.toSet())
                checkedUidList.clear()
            },
            dismissButtonState = ButtonState(
                text = stringResource(id = R.string.button_dismiss)
            ),
            onDismissRequest = {
                showDialog.value = false
            }
        )
    }

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .wrapContentHeight()
            .animateContentSize()
    ) {
        if((questionModule.value?.history?.size ?: 0) > 1) {
            questionModule.value?.let { module ->
                StatisticsTable(
                    modifier = Modifier.fillMaxWidth(),
                    questionModule = module,
                    backgroundColor = LocalTheme.current.colors.onBackgroundComponentContrast
                )
            }
        }

        // name
        EditFieldInput(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
                .padding(top = 24.dp),
            value = session.name,
            hint = stringResource(id = R.string.collection_detail_name_hint)
        ) { output ->
            inputScope.coroutineContext.cancelChildren()
            inputScope.launch {
                delay(INPUT_DELAYED_RESPONSE_MILLIS)
                viewModel.updateSessionName(output)
            }
        }

        //preferences
        Text(
            modifier = Modifier.padding(start = 8.dp, top = 12.dp),
            text = stringResource(R.string.session_detail_mode_title),
            style = TextStyle(
                color = LocalTheme.current.colors.secondary,
                fontSize = 14.sp
            )
        )
        PreferenceChooser(
            modifier = Modifier
                .padding(vertical = 8.dp),
            preferencePack = session.preferencePack ?: SessionPreferencePack(),
            onSaveRequest = { newPack ->
                viewModel.updatePreferencePack(newPack)
            }
        )

        Spacer(Modifier.height(16.dp))

        // collections
        HorizontalBlock(
            modifier = Modifier.animateContentSize(),
            heading = stringResource(R.string.screen_collection_title)
        ) {
            items(
                items = collections.value ?: arrayOfNulls<CollectionIO>(2).toList(),
                key = { collection ->  collection?.uid ?: UUID.randomUUID().toString() }
            ) { collection ->
                CollectionCard(
                    modifier = Modifier
                        .scalingClickable(
                            onTap = {
                                if(collection != null) {
                                    if (checkedUidList.size > 0) {
                                        if (checkedUidList.contains(collection.uid)) {
                                            checkedUidList.remove(collection.uid)
                                        } else {
                                            checkedUidList.add(collection.uid)
                                        }
                                    } else {
                                        navController?.navigate(
                                            NavigationRoot.CollectionDetail.createRoute(
                                                NavigationRoot.CollectionDetail.CollectionDetailArgument(
                                                    collectionUid = collection.uid,
                                                    toolbarTitle = collection.name
                                                )
                                            )
                                        )
                                    }
                                }
                            },
                            onLongPress = {
                                if (checkedUidList.size == 0) {
                                    checkedUidList.add(collection?.uid ?: "")
                                }
                            }
                        )
                        .width(configuration.screenWidthDp.times(0.4f).dp),
                    isChecked = if(checkedUidList.size > 0) {
                        checkedUidList.contains(collection?.uid)
                    }else null,
                    data = collection
                )
            }
            item {
                ComponentHeaderButton(
                    onClick = {
                        navController?.navigate(NavigationRoot.CollectionLobby.route)
                    }
                )
            }
        }

        // questions
        AnimatedVisibility(questions.value?.isEmpty() == false) {
            HorizontalBlock(
                modifier = Modifier.animateContentSize(),
                heading = stringResource(R.string.collection_detail_questions_heading)
            ) {
                items(
                    questions.value ?: arrayOfNulls<QuestionIO>(6).toList(),
                    key = { question ->  question?.uid ?: UUID.randomUUID().toString() }
                ) { question ->
                    QuestionCard(
                        modifier = Modifier
                            .scalingClickable(
                                onTap = {
                                    if(question != null) {
                                        if (checkedUidList.size > 0) {
                                            if (checkedUidList.contains(question.uid)) {
                                                checkedUidList.remove(question.uid)
                                            } else {
                                                checkedUidList.add(question.uid)
                                            }
                                        } else {
                                            navController?.navigate(
                                                NavigationRoot.QuestionDetail.createRoute(
                                                    NavigationRoot.QuestionDetail.QuestionDetailArgument(
                                                        toolbarTitle = question.prompt,
                                                        questionUid = question.uid
                                                    )
                                                )
                                            )
                                        }
                                    }
                                },
                                onLongPress = {
                                    if (checkedUidList.size == 0) {
                                        checkedUidList.add(question?.uid ?: "")
                                    }
                                }
                            )
                            .animateItemPlacement(
                                tween(
                                    durationMillis = DEFAULT_ANIMATION_LENGTH_SHORT,
                                    easing = LinearOutSlowInEasing
                                )
                            ),
                        isChecked = if(checkedUidList.size > 0) {
                            checkedUidList.contains(question?.uid)
                        }else null,
                        data = question
                    )
                }
            }
        }

        OptionsLayout(
            actions = if(checkedUidList.size > 0) checkedOptionsItems else emptyList(),
            onClick = { action ->
                when(action) {
                    is OptionsLayoutAction.SelectAll -> {
                        checkedUidList.clear()
                        checkedUidList.addAll(questions.value?.map { it.uid }.orEmpty())
                        checkedUidList.addAll(collections.value?.map { it.uid }.orEmpty())
                    }
                    is OptionsLayoutAction.DeselectAll -> {
                        checkedUidList.clear()
                    }
                    is OptionsLayoutAction.Delete -> {
                        showDialog.value = true
                    }
                    else -> {}
                }
            }
        )
        Spacer(modifier = Modifier.height(32.dp))
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
            .background(
                LocalTheme.current.colors.onBackgroundComponent,
                shape = LocalTheme.current.shapes.componentShape
            )
            .padding(start = 4.dp, end = 4.dp, top = 8.dp, bottom = 32.dp)
    ) {
        Box(
            modifier = Modifier
                .height(60.dp)
                .padding(top = 16.dp, start = 4.dp, end = 4.dp)
                .fillMaxWidth()
                .brandShimmerEffect(LocalTheme.current.shapes.componentShape)
        )
        Box(
            modifier = Modifier
                .height(100.dp)
                .padding(top = 8.dp, start = 4.dp, end = 4.dp)
                .fillMaxWidth()
                .brandShimmerEffect(LocalTheme.current.shapes.componentShape)
        )
        Box(
            modifier = Modifier
                .height(55.dp)
                .padding(top = 24.dp, start = 4.dp, end = 4.dp)
                .fillMaxWidth()
                .brandShimmerEffect(LocalTheme.current.shapes.componentShape)
        )
        Spacer(modifier = Modifier.height(32.dp))
        repeat(5) {
            Box(
                modifier = Modifier
                    .height(40.dp)
                    .padding(top = 8.dp, start = 4.dp, end = 4.dp)
                    .fillMaxWidth()
                    .brandShimmerEffect(LocalTheme.current.shapes.componentShape)
            )
        }
    }
}