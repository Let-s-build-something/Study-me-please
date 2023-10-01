package study.me.please.ui.session.detail

import androidx.activity.compose.BackHandler
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.ext.brandShimmerEffect
import com.squadris.squadris.utils.OnLifecycleEvent
import study.me.please.R
import study.me.please.base.navigation.ActionBarIcon
import study.me.please.base.navigation.NavigationUtils
import study.me.please.base.navigation.SessionDetailBarActions
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.SessionIO
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.ui.collection.detail.OptionsLayout
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.CollectionCard
import study.me.please.ui.components.EditFieldInput
import study.me.please.ui.components.InteractiveCardMode
import study.me.please.ui.components.PreferenceChooser
import study.me.please.ui.components.QuestionCard
import study.me.please.ui.components.SimpleModalBottomSheet
import study.me.please.ui.components.TextHeader
import study.me.please.ui.components.rememberInteractiveCardState

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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SessionDetailScreen(
    sessionUid: String? = null,
    collectionUidList: List<String>? = null,
    questionUidList: List<String>? = null,
    navController: NavController,
    changeActionBar: (actions: @Composable RowScope.() -> Unit) -> Unit,
    viewModel: SessionDetailViewModel = hiltViewModel()
) {
    val sessionDetail = viewModel.dataManager.session.collectAsState()
    val preferencePacks = viewModel.dataManager.preferencePacks.collectAsState()

    OnLifecycleEvent { event ->
        if(event == Lifecycle.Event.ON_RESUME) {
            viewModel.requestSessionDetail(
                sessionUid = sessionUid,
                collectionUidList = collectionUidList.orEmpty(),
                questionUidList = questionUidList.orEmpty()
            )
        }
    }

    if(sessionDetail.value == null) {
        ShimmerLayout()
    }else {
        val showPreferenceModal = remember { mutableStateOf(false) }
        val preferencesSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

        if(showPreferenceModal.value) {
            SimpleModalBottomSheet(
                onDismissRequest = {
                    showPreferenceModal.value = false
                },
                sheetState = preferencesSheetState,
            ) {
                PreferenceChooser(
                    modifier = Modifier
                        .padding(8.dp)
                        .padding(bottom = 32.dp),
                    onDeleteRequest = { preferencePack ->
                        viewModel.requestPreferencePackDelete(preferencePack?.uid)
                    },
                    requestPreferenceSave = { preferencePack ->
                        viewModel.requestPreferencePackSave(preferencePack)
                    },
                    defaultPreferencePack = preferencePacks.value?.firstOrNull(),
                    mustHaveSelection = false,
                    preferencePacks = preferencePacks.value
                )
            }
        }

        LaunchedEffect(showPreferenceModal.value) {
            if(showPreferenceModal.value) {
                preferencesSheetState.expand()
            }else preferencesSheetState.hide()
        }
        LaunchedEffect(sessionDetail.value) {
            changeActionBar {
                SessionDetailBarActions(
                    onChangePreferences = {
                        if(preferencePacks.value.isNullOrEmpty().not()) {
                            showPreferenceModal.value = true
                        }
                    },
                    onPlay = {
                        NavigationUtils.navigateToSession(
                            navController = navController,
                            sessionUid = sessionDetail.value?.uid,
                            toolbarTitle = sessionDetail.value?.name ?: ""
                        )
                    }
                )
            }
        }
        ContentLayout(
            session = sessionDetail.value,
            requestDataSave = {
                viewModel.saveSessionDetail()
            },
            navigateToCollection = { collection ->
                NavigationUtils.navigateToCollectionDetail(
                    navController = navController,
                    toolbarTitle = collection.name,
                    collectionUid = collection.uid
                )
            },
            onAddCollection = {
                NavigationUtils.navigateToCollectionLobby(navController)
            },
            preferencePacks = preferencePacks.value,
            requestPreferenceDelete = { preferencePack ->
                viewModel.requestPreferencePackDelete(preferencePack?.uid)
            },
            onPreferencePackChosen = { preferencePack ->
                sessionDetail.value?.apply {
                    this.preferencePack = preferencePack
                    viewModel.saveSessionDetail()
                }
            },
            requestPreferenceSave = { preferencePack ->
                viewModel.requestPreferencePackSave(preferencePack)
            }
        )
    }
}

/** Layout for main content - showing actual information */
@Composable
private fun ContentLayout(
    modifier: Modifier = Modifier,
    session: SessionIO?,
    requestDataSave: () -> Unit,
    navigateToCollection: (collection: CollectionIO) -> Unit,
    preferencePacks: MutableList<SessionPreferencePack>?,
    onPreferencePackChosen: (SessionPreferencePack) -> Unit = {},
    requestPreferenceSave: (SessionPreferencePack?) -> Unit,
    requestPreferenceDelete: (SessionPreferencePack?) -> Unit,
    onAddCollection: () -> Unit
) {
    val localFocusManager = LocalFocusManager.current
    val showDialog = remember { mutableStateOf<DialogToShow?>(null) }
    val selectedCollectionUids = remember { mutableStateListOf<String>() }
    val selectedQuestionUids = remember { mutableStateListOf<String>() }
    val collections = remember(session?.collections) {
        mutableStateListOf(*session?.collections?.toTypedArray().orEmpty())
    }
    val questions = remember(session?.questions) {
        mutableStateListOf(*session?.questions?.toTypedArray().orEmpty())
    }
    val interactiveCollectionStates = collections.map {
        rememberInteractiveCardState()
    }
    val interactiveQuestionStates = questions.map {
        rememberInteractiveCardState()
    }
    val stopChecking = {
        interactiveCollectionStates.forEach {
            it.isChecked.value = false
            it.mode.value = InteractiveCardMode.DATA_DISPLAY
        }
        selectedCollectionUids.clear()
        interactiveQuestionStates.forEach {
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
            dialogTitle = stringResource(
                id = if(showDialog.value == DialogToShow.DeleteCollections) {
                    R.string.collection_delete_dialog_title
                }else R.string.question_delete_dialog_title
            ),
            dialogText = if(showDialog.value == DialogToShow.DeleteCollections) {
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
                showDialog.value = null
            },
            dismissButtonState = ButtonState(
                text = stringResource(id = R.string.button_dismiss)
            ) { showDialog.value = null }
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
                top = 4.dp,
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
            .background(
                color = LocalTheme.colors.onBackgroundComponentContrast,
                shape = LocalTheme.shapes.componentShape
            )

        // name
        EditFieldInput(
            modifier = Modifier
                .padding(top = 8.dp),
            value = session?.name ?: "",
            hint = stringResource(id = R.string.collection_detail_name_hint)
        ) { output ->
            session?.name = output
            requestDataSave()
        }

        //preferences
        PreferenceChooser(
            modifier = Modifier
                .padding(vertical = 8.dp),
            preferencePacks = preferencePacks,
            onPreferencePackChosen = onPreferencePackChosen,
            requestPreferenceSave = requestPreferenceSave,
            onDeleteRequest = requestPreferenceDelete,
            defaultPreferencePack = session?.preferencePack,
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
                Spacer(modifier = Modifier.width(16.dp))
            }
            item {
                ActionBarIcon(
                    text = stringResource(id = R.string.button_add),
                    imageVector = Icons.Outlined.Add
                ) {
                    onAddCollection()
                }
            }
            itemsIndexed(
                collections,
                key = { _, collection ->  collection.uid }
            ) { index, collection ->
                interactiveCollectionStates.getOrNull(index)?.let { cardState ->
                    LaunchedEffect(cardState.isChecked.value) {
                        if(cardState.isChecked.value) {
                            selectedCollectionUids.add(collection.uid)
                        }else selectedCollectionUids.remove(collection.uid)
                    }
                    CollectionCard(
                        modifier = Modifier
                            .wrapContentHeight()
                            .wrapContentWidth(),
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
            onDeleteRequest = {
                showDialog.value = DialogToShow.DeleteCollections
            },
            onCopyRequest = {

            },
            onPasteRequest = {

            },
            onSelectAll = {
                interactiveCollectionStates.forEach {
                    it.isChecked.value = true
                }
            },
            onDeselectAll = {
                selectedCollectionUids.clear()
            }
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
                Spacer(modifier = Modifier.width(16.dp))
            }
            item {
                ActionBarIcon(
                    text = stringResource(id = R.string.button_add),
                    imageVector = Icons.Outlined.Add
                ) {
                    onAddCollection()
                }
            }
            itemsIndexed(
                questions,
                key = { _, question ->  question.uid }
            ) { index, question ->
                interactiveQuestionStates.getOrNull(index)?.let { cardState ->
                    LaunchedEffect(cardState.isChecked.value) {
                        if(cardState.isChecked.value) {
                            selectedQuestionUids.add(question.uid)
                        }else selectedQuestionUids.remove(question.uid)
                    }
                    QuestionCard(
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
            item {
                Spacer(modifier = Modifier.width(16.dp))
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
                interactiveQuestionStates.forEach {
                    it.isChecked.value = true
                }
            },
            selectAllVisible = questions.size.minus(selectedQuestionUids.size) > 1,
            deselectAllVisible = selectedQuestionUids.size > 1,
            onDeselectAll = {
                selectedQuestionUids.clear()
            }
        )
        Spacer(modifier = Modifier.height(32.dp))
    }

    LaunchedEffect(selectedCollectionUids.size) {
        if(selectedCollectionUids.size > 0) {
            interactiveCollectionStates.forEach {
                it.mode.value = InteractiveCardMode.CHECKING
            }
        }else {
            stopChecking()
            selectedCollectionUids.clear()
        }
    }
    LaunchedEffect(selectedCollectionUids.size) {
        if(selectedCollectionUids.size > 0) {
            interactiveQuestionStates.forEach {
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
private fun ShimmerLayout() {
    Column(
        modifier = Modifier
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