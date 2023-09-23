package study.me.please.ui.session.lobby

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material.icons.outlined.ContentPaste
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Deselect
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.SelectAll
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.squadris.squadris.compose.theme.Colors
import com.squadris.squadris.compose.theme.LocalTheme
import study.me.please.R
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.SessionIO
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.CollectionCard
import study.me.please.ui.components.EditFieldInput
import study.me.please.ui.components.ImageAction
import study.me.please.ui.components.InteractiveCardMode
import study.me.please.ui.components.PreferenceChooser
import study.me.please.ui.components.SimpleBottomSheet
import study.me.please.ui.components.rememberInteractiveCardState

/** Bottom sheet layout for editing a question */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SessionEditBottomSheetContent(
    modifier: Modifier = Modifier,
    session: SessionIO?,
    requestDataSave: () -> Unit,
    navigateToCollection: (collection: CollectionIO) -> Unit,
    state: BottomSheetScaffoldState = rememberBottomSheetScaffoldState(),
    onDismissRequest: () -> Unit = {},
    content: @Composable (paddingValues: PaddingValues) -> Unit = {}
) {
    val showDeleteDialog = remember { mutableStateOf(false) }
    val selectedCollectionUids = remember { mutableStateListOf<String>() }
    val interactiveStates = session?.collections?.map {
        rememberInteractiveCardState()
    }
    val stopChecking = {
        interactiveStates?.forEach {
            it.isChecked.value = false
            it.mode.value = InteractiveCardMode.DATA_DISPLAY
        }
        selectedCollectionUids.clear()
    }
    if(selectedCollectionUids.size > 0) {
        BackHandler {
            stopChecking()
        }
    }

    if(showDeleteDialog.value) {
        BasicAlertDialog(
            dialogTitle = stringResource(id = R.string.session_lobby_screen_delete_title),
            dialogText = stringResource(
                id = R.string.session_lobby_screen_delete_text,
                selectedCollectionUids.size
            ),
            icon = Icons.Outlined.Delete,
            confirmButtonState = ButtonState(
                text = stringResource(id = R.string.button_confirm)
            ) {
                session?.collectionUids?.removeAll { selectedCollectionUids.contains(it) }
                requestDataSave()
                stopChecking()
                showDeleteDialog.value = false
            },
            dismissButtonState = ButtonState(
                text = stringResource(id = R.string.button_dismiss)
            ) { showDeleteDialog.value = false }
        )
    }

    SimpleBottomSheet(
        sheetContent = {
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(
                        start = 8.dp,
                        end = 8.dp,
                        top = 8.dp
                    )
                    .windowInsetsPadding(WindowInsets.systemBars)
                    .windowInsetsPadding(WindowInsets.ime)
            ) {
                EditFieldInput(
                    modifier = Modifier
                        .padding(start = 8.dp, top = 8.dp),
                    value = session?.name ?: "",
                    hint = stringResource(id = R.string.collection_detail_name_hint)
                ) { output ->
                    session?.name = output
                    requestDataSave()
                }
                LazyRow(
                    modifier = Modifier,
                    state = rememberLazyListState(),
                    horizontalArrangement = Arrangement.spacedBy(
                        LocalTheme.shapes.betweenItemsSpace
                    )
                ) {
                    item {
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                    itemsIndexed(
                        session?.collections.orEmpty(),
                        key = { _, collection ->  collection.uid }
                    ) { index, collection ->
                        interactiveStates?.getOrNull(index)?.let { cardState ->
                            CollectionCard(
                                data = collection,
                                state = cardState,
                                skipOptions = true,
                                onNavigateToDetail = {
                                    navigateToCollection(collection)
                                }
                            )
                        }
                        session?.collections
                    }
                    item {
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                }
                PreferenceChooser(
                    modifier = Modifier
                        .padding(8.dp),
                    preferencePacks = ,
                    requestPreferenceSave = {

                    },
                    onPreferencePackChosen = { preferencePack ->
                        session?.preferences = preferencePack
                        requestDataSave()
                    },
                    onDeleteRequest = {
                        dele
                    },
                    defaultPreferencePack = session?.preferences
                )
            }
        },
        modifier = modifier,
        onDismissRequest = {
            stopChecking()
            onDismissRequest()
        },
        state = state,
        content = content,
    )

    LaunchedEffect(selectedCollectionUids.size) {
        if(selectedCollectionUids.size > 0) {
            interactiveStates?.forEach {
                it.mode.value = InteractiveCardMode.CHECKING
            }
        }else {
            stopChecking()
            selectedCollectionUids.clear()
        }
    }
}

@Composable
private fun OptionsLayout(
    onDeleteRequest: () -> Unit = {},
    onCopyRequest: () -> Unit = {},
    onPasteRequest: () -> Unit = {},
    onSelectAll: () -> Unit = {},
    onDeselectAll: () -> Unit = {},
    onTestPlay: () -> Unit = {},
    isEditMode: Boolean = false,
    hasPasteOption: Boolean = false
) {
    if(isEditMode) {
        ImageAction(
            leadingImageVector = Icons.Outlined.Delete,
            text = stringResource(id = R.string.button_delete),
            containerColor = Colors.RED_ERROR,
            onClick = onDeleteRequest
        )
        ImageAction(
            leadingImageVector = Icons.Outlined.SelectAll,
            text = stringResource(id = R.string.button_select_all),
            onClick = onSelectAll
        )
        ImageAction(
            leadingImageVector = Icons.Outlined.Deselect,
            text = stringResource(id = R.string.button_deselect),
            onClick = onDeselectAll
        )
        ImageAction(
            leadingImageVector = Icons.Outlined.ContentCopy,
            text = stringResource(id = R.string.button_copy),
            onClick = onCopyRequest
        )
    }
    if(hasPasteOption) {
        ImageAction(
            leadingImageVector = Icons.Outlined.ContentPaste,
            text = stringResource(id = R.string.button_paste),
            onClick = onPasteRequest
        )
    }
    ImageAction(
        leadingImageVector = Icons.Outlined.PlayArrow,
        text = stringResource(id = R.string.button_test_play),
        onClick = onTestPlay
    )
}

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
private fun Preview() {
    SessionEditBottomSheetContent(
        session = SessionIO(),
        requestDataSave = {},
        navigateToCollection = {

        }
    )
}