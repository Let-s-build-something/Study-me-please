package study.me.please.ui.session.detail

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.squadris.squadris.compose.components.DEFAULT_ANIMATION_LENGTH_SHORT
import com.squadris.squadris.compose.components.input.EditFieldInput
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.ext.brandShimmerEffect
import com.squadris.squadris.utils.OnLifecycleEvent
import study.me.please.R
import study.me.please.base.LocalNavController
import study.me.please.base.navigation.ActionBarIcon
import study.me.please.base.navigation.NavigationRoot
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.data.io.session.SessionIO
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.CollectionCard
import study.me.please.ui.components.InteractiveCardMode
import study.me.please.ui.components.OptionsLayout
import study.me.please.ui.components.QuestionCard
import study.me.please.ui.components.TextHeader
import study.me.please.ui.components.preference_chooser.PreferenceChooser
import study.me.please.ui.components.preference_chooser.PreferenceChooserController
import study.me.please.ui.components.pull_refresh.PullRefreshScreen
import study.me.please.ui.components.rememberInteractiveCardState
import study.me.please.ui.components.session.StatisticsTable

/** length of a [CollectionCard] name in shorten version */
private const val COLLECTION_CARD_NAME_SHORT_LENGTH = 24

enum class DialogToShow {
    DeleteCollections,
    DeleteQuestions,
}

/**
 * Screen for creating a new collection
 * including adding of questions, configuration and import of both
 */
@Composable
fun SessionDetailScreen(
    sessionUid: String? = null,
    collectionUidList: List<String>? = null,
    questionUidList: List<String>? = null,
    title: String? = null,
    viewModel: SessionDetailViewModel = hiltViewModel()
) {
    val sessionDetail = viewModel.session.collectAsState()
    val navController = LocalNavController.current

    LaunchedEffect(Unit) {
        viewModel.requestPreferencePacks()
    }

    OnLifecycleEvent { event ->
        if(event == Lifecycle.Event.ON_CREATE) {
            viewModel.defaultName = title ?: ""
            viewModel.sessionUid = sessionUid
            viewModel.collectionUidList = collectionUidList.orEmpty()
            viewModel.questionUidList = questionUidList.orEmpty()
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
                                sessionUid = sessionDetail.value?.uid ?: "",
                                toolbarTitle = sessionDetail.value?.name ?: ""
                            )
                        )
                    )
                }
            )
        }
    ) { paddingValues ->
        if(sessionDetail.value == null) {
            ShimmerLayout(modifier = Modifier.padding(paddingValues))
        }else {
            ContentLayout(
                modifier = Modifier.padding(paddingValues),
                session = sessionDetail.value,
                viewModel = viewModel,
                requestDataSave = {
                    viewModel.saveSessionDetail()
                },
                navigateToCollection = { collection ->
                    navController?.navigate(
                        NavigationRoot.CollectionDetail.createRoute(
                            NavigationRoot.CollectionDetail.CollectionDetailArgument(
                                collectionUid = collection.uid,
                                toolbarTitle = collection.name
                            )
                        )
                    )
                },
                onAddCollection = {
                    navController?.navigate(NavigationRoot.CollectionLobby.route)
                },
                onPreferencePackChosen = { preferencePack ->
                    sessionDetail.value?.apply {
                        this.preferencePackUid = preferencePack.uid
                        this.estimatedMode = preferencePack.estimatedMode
                    }
                    viewModel.saveSessionDetail()
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
    session: SessionIO?,
    viewModel: SessionDetailViewModel,
    requestDataSave: () -> Unit,
    navigateToCollection: (collection: CollectionIO) -> Unit,
    onPreferencePackChosen: (SessionPreferencePack) -> Unit = {},
    onAddCollection: () -> Unit
) {
    val questions = viewModel.questions.collectAsState()
    val collections = viewModel.collections.collectAsState()
    val preferencePacks = viewModel.preferencePacks.collectAsState()
    val selectedCollectionUids = remember { mutableStateListOf<String>() }

    val localFocusManager = LocalFocusManager.current

    val showDialog = remember { mutableStateOf<DialogToShow?>(null) }
    val selectedQuestionUids = remember { mutableStateListOf<String>() }
    val interactiveCollectionStates = collections.value?.map {
        rememberInteractiveCardState()
    }
    val interactiveQuestionStates = questions.value?.map {
        rememberInteractiveCardState()
    }
    val stopChecking = {
        interactiveCollectionStates?.forEach {
            it.isChecked.value = false
            it.mode.value = InteractiveCardMode.DATA_DISPLAY
        }
        selectedCollectionUids.clear()
        interactiveQuestionStates?.forEach {
            it.isChecked.value = false
            it.mode.value = InteractiveCardMode.DATA_DISPLAY
        }
        selectedQuestionUids.clear()
    }
    if(selectedCollectionUids.size > 0 || selectedQuestionUids.size > 0) {
        BackHandler {
            stopChecking()
        }
    }

    if(showDialog.value != null) {
        BasicAlertDialog(
            title = stringResource(
                id = if(showDialog.value == DialogToShow.DeleteCollections) {
                    R.string.collection_delete_dialog_title
                }else R.string.question_delete_dialog_title
            ),
            content = if(showDialog.value == DialogToShow.DeleteCollections) {
                stringResource(
                    id = R.string.collection_delete_dialog_description,
                    selectedCollectionUids.size
                )
            }else stringResource(
                id = R.string.question_delete_dialog_description,
                selectedQuestionUids.size
            ),
            icon = Icons.Outlined.Delete,
            confirmButtonState = ButtonState(
                text = stringResource(id = R.string.button_confirm)
            ) {
                if(showDialog.value == DialogToShow.DeleteCollections) {
                    session?.collectionUidList?.removeAll { selectedCollectionUids.contains(it) }
                }else session?.questionUidList?.removeAll { selectedQuestionUids.contains(it) }
                requestDataSave()
                stopChecking()
            },
            dismissButtonState = ButtonState(
                text = stringResource(id = R.string.button_dismiss)
            ),
            onDismissRequest = { showDialog.value = null }
        )
    }

    Column(
        modifier = modifier
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    localFocusManager.clearFocus()
                })
            }
            .verticalScroll(rememberScrollState())
            .padding(
                top = 12.dp,
                start = 4.dp,
                end = 4.dp,
                bottom = 0.dp
            )
            .shadow(
                elevation = LocalTheme.styles.componentElevation,
                shape = LocalTheme.shapes.componentShape,
                clip = true
            )
            .background(
                color = LocalTheme.colors.onBackgroundComponent,
                shape = LocalTheme.shapes.componentShape
            )
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 12.dp)
            .animateContentSize()
    ) {
        val rowModifier = Modifier
            .padding(vertical = 12.dp)
            .clip(LocalTheme.shapes.componentShape)
            .background(
                color = LocalTheme.colors.onBackgroundComponentContrast,
                shape = LocalTheme.shapes.componentShape
            )

        // name
        EditFieldInput(
            modifier = Modifier
                .padding(top = 12.dp),
            value = session?.name ?: "",
            hint = stringResource(id = R.string.collection_detail_name_hint)
        ) { output ->
            session?.name = output
            requestDataSave()
        }

        AnimatedVisibility(visible = session?.questionModule != null) {
            session?.questionModule?.let { module ->
                StatisticsTable(
                    modifier = rowModifier.fillMaxWidth(),
                    questionModule = module,
                    backgroundColor = LocalTheme.colors.onBackgroundComponentContrast
                )
            }
        }

        //preferences
        PreferenceChooser(
            modifier = Modifier
                .padding(vertical = 8.dp),
            preferencePacks = preferencePacks.value,
            controller = object: PreferenceChooserController {
                override fun addPreferencePack(name: String): SessionPreferencePack {
                    return viewModel.addNewPreferencePack(name = name)
                }
                override fun savePreference(preference: SessionPreferencePack) {
                    viewModel.requestPreferencePackSave(preference)
                }
                override fun deletePreference(preferenceUid: String) {
                    session?.preferencePackUid = ""
                    session?.estimatedMode = null
                    viewModel.requestPreferencePackDelete(preferenceUid)
                }
                override fun choosePreference(preference: SessionPreferencePack) {
                    onPreferencePackChosen(preference)
                }
            },
            defaultPreferencePack = preferencePacks.value?.find { it.uid == session?.preferencePackUid },
            expandedByDefault = false
        )

        // collections
        TextHeader(text = stringResource(id = R.string.screen_collection_title))
        LazyRow(
            modifier = rowModifier
                .zIndex(1f),
            state = rememberLazyListState(),
            horizontalArrangement = Arrangement.spacedBy(
                LocalTheme.shapes.betweenItemsSpace
            ),
            contentPadding = PaddingValues(vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            item {
                ActionBarIcon(
                    text = stringResource(id = R.string.button_add),
                    imageVector = Icons.Outlined.Add
                ) {
                    onAddCollection()
                }
            }
            itemsIndexed(
                collections.value.orEmpty(),
                key = { _, collection ->  collection.uid }
            ) { index, collection ->
                interactiveCollectionStates?.getOrNull(index)?.let { cardState ->
                    LaunchedEffect(cardState.isChecked.value) {
                        if(cardState.isChecked.value) {
                            selectedCollectionUids.add(collection.uid)
                        }else selectedCollectionUids.remove(collection.uid)
                    }
                    CollectionCard(
                        modifier = Modifier
                            .wrapContentHeight()
                            .wrapContentWidth()
                            .animateItemPlacement(
                                tween(
                                    durationMillis = DEFAULT_ANIMATION_LENGTH_SHORT,
                                    easing = LinearOutSlowInEasing
                                )
                            ),
                        data = collection,
                        state = cardState,
                        skipOptions = true,
                        onNavigateToDetail = {
                            navigateToCollection(collection)
                        },
                        clipToName = true,
                        maxNameLength = COLLECTION_CARD_NAME_SHORT_LENGTH
                    )
                }
                session?.collectionUidList
            }
            item {
                Spacer(modifier = Modifier.width(16.dp))
            }
        }

        OptionsLayout(
            isEditMode = selectedCollectionUids.size > 0,
            onDeleteRequest = { showDialog.value = DialogToShow.DeleteCollections },
            onCopyRequest = {

            },
            onPasteRequest = {

            },
            onSelectAll = {
                interactiveCollectionStates?.forEach {
                    it.isChecked.value = true
                }
            },
            onDeselectAll = {
                selectedCollectionUids.clear()
            },
            onClipBoardRemoval = {  }
        )

        // questions
        TextHeader(text = stringResource(id = R.string.collection_detail_questions_heading))
        LazyRow(
            modifier = rowModifier
                .zIndex(1f),
            state = rememberLazyListState(),
            horizontalArrangement = Arrangement.spacedBy(
                LocalTheme.shapes.betweenItemsSpace
            ),
            contentPadding = PaddingValues(vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            item {
                ActionBarIcon(
                    text = stringResource(id = R.string.button_add),
                    imageVector = Icons.Outlined.Add
                ) {
                    onAddCollection()
                }
            }
            itemsIndexed(
                questions.value.orEmpty(),
                key = { _, question ->  question.uid }
            ) { index, question ->
                interactiveQuestionStates?.getOrNull(index)?.let { cardState ->
                    LaunchedEffect(cardState.isChecked.value) {
                        if(cardState.isChecked.value) {
                            selectedQuestionUids.add(question.uid)
                        }else selectedQuestionUids.remove(question.uid)
                    }
                    QuestionCard(
                        modifier = Modifier
                            .animateItemPlacement(
                                tween(
                                    durationMillis = DEFAULT_ANIMATION_LENGTH_SHORT,
                                    easing = LinearOutSlowInEasing
                                )
                            ),
                        data = question,
                        state = cardState
                    ) {
                        if(cardState.mode.value == InteractiveCardMode.CHECKING) {
                            cardState.isChecked.value = cardState.isChecked.value.not()
                        }
                    }
                }
                session?.collectionUidList
            }
        }
        OptionsLayout(
            isEditMode = selectedQuestionUids.size > 0,
            onDeleteRequest = {
                showDialog.value = DialogToShow.DeleteQuestions
            },
            onCopyRequest = {

            },
            onPasteRequest = {

            },
            onSelectAll = {
                interactiveQuestionStates?.forEach {
                    it.isChecked.value = true
                }
            },
            selectAllVisible = questions.value.orEmpty().size.minus(selectedQuestionUids.size) > 1,
            deselectAllVisible = selectedQuestionUids.size > 1,
            onDeselectAll = {
                selectedQuestionUids.clear()
            },
            onClipBoardRemoval = {  }
        )
        Spacer(modifier = Modifier.height(32.dp))
    }

    LaunchedEffect(selectedCollectionUids.size) {
        if(selectedCollectionUids.size > 0) {
            interactiveCollectionStates?.forEach {
                it.mode.value = InteractiveCardMode.CHECKING
            }
        }else {
            stopChecking()
            selectedCollectionUids.clear()
        }
    }
    LaunchedEffect(selectedCollectionUids.size) {
        if(selectedCollectionUids.size > 0) {
            interactiveQuestionStates?.forEach {
                it.mode.value = InteractiveCardMode.CHECKING
            }
        }else {
            stopChecking()
            selectedCollectionUids.clear()
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
            .background(
                LocalTheme.colors.onBackgroundComponent,
                shape = LocalTheme.shapes.componentShape
            )
            .padding(start = 4.dp, end = 4.dp, top = 8.dp, bottom = 32.dp)
    ) {
        Box(
            modifier = Modifier
                .height(60.dp)
                .padding(top = 16.dp, start = 4.dp, end = 4.dp)
                .fillMaxWidth()
                .brandShimmerEffect(LocalTheme.shapes.componentShape)
        )
        Box(
            modifier = Modifier
                .height(100.dp)
                .padding(top = 8.dp, start = 4.dp, end = 4.dp)
                .fillMaxWidth()
                .brandShimmerEffect(LocalTheme.shapes.componentShape)
        )
        Box(
            modifier = Modifier
                .height(55.dp)
                .padding(top = 24.dp, start = 4.dp, end = 4.dp)
                .fillMaxWidth()
                .brandShimmerEffect(LocalTheme.shapes.componentShape)
        )
        Spacer(modifier = Modifier.height(32.dp))
        repeat(5) {
            Box(
                modifier = Modifier
                    .height(40.dp)
                    .padding(top = 8.dp, start = 4.dp, end = 4.dp)
                    .fillMaxWidth()
                    .brandShimmerEffect(LocalTheme.shapes.componentShape)
            )
        }
    }
}