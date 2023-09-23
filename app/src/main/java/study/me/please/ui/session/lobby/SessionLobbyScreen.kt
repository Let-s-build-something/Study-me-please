package study.me.please.ui.session.lobby

import android.se.omapi.Session
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.squadris.squadris.compose.theme.LocalTheme
import study.me.please.R
import study.me.please.base.navigation.NavigationUtils
import study.me.please.base.navigation.SessionAppBarActions
import study.me.please.base.navigation.SessionLobbyBarActions
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.SessionIO
import study.me.please.ui.components.BrandHeaderButton
import study.me.please.ui.components.SessionCard

/** communication bridge for controlling session lobby screen */
interface SessionLobbyListener {
    fun onCreateNewItem()
    fun onCheckingStarted(sessionUid: String)
}

/**
 * Session lobby screen for management of sessions
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SessionLobbyScreen(
    navController: NavController,
    sessionUid: String? = null,
    collectionUid: String? = null,
    createNewItem: Boolean = false,
    viewModel: SessionLobbyViewModel = hiltViewModel(),
    changeActionBar: (actions: @Composable RowScope.() -> Unit) -> Unit
) {
    val newItem = remember { mutableStateOf(createNewItem) }
    val sessionsFlow = viewModel.dataManager.sessions.collectAsState()
    val sessions = remember {
        derivedStateOf { mutableStateListOf(*sessionsFlow.value.orEmpty().toTypedArray()) }
    }
    val selectedSession = remember { mutableStateOf<SessionIO?>(null) }
    val sessionSheetState = rememberBottomSheetScaffoldState()
    val localFocusManager = LocalFocusManager.current
    val listener = remember(viewModel) {
        object: SessionLobbyListener {
            override fun onCreateNewItem() {

            }
            override fun onCheckingStarted(sessionUid: String) {

            }
        }
    }
    val showPreferenceModal = remember { mutableStateOf(false) }
    changeActionBar {
        SessionLobbyBarActions(
            onChangePreferences = {
                showPreferenceModal.value = true
            }
        )
    }

    LaunchedEffect(Unit) {
        viewModel.requestAllSessions()
    }
    LaunchedEffect(newItem) {
        listener.onCreateNewItem()
    }
    LaunchedEffect(selectedSession.value) {
        if(selectedSession.value?.uid != null) {
            localFocusManager.clearFocus()
            sessionSheetState.bottomSheetState.expand()
        }else sessionSheetState.bottomSheetState.collapse()
    }

    if(sessionsFlow.value != null) {
        SessionEditBottomSheetContent(
            session = selectedSession.value,
            onDismissRequest = {  },
            requestDataSave = {
                selectedSession.value?.let { session ->
                    viewModel.saveSession(session)
                }
            },
            navigateToCollection = { collection ->
                NavigationUtils.navigateToCollectionDetail(
                    navController = navController,
                    toolbarTitle = collection.name,
                    collectionUid = collection.uid
                )
            },
            state = sessionSheetState
        ) {
            val itemModifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .wrapContentHeight()
                .fillMaxWidth()

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                state = rememberLazyListState(),
                verticalArrangement = Arrangement.spacedBy(
                    LocalTheme.shapes.betweenItemsSpace
                )
            ) {
                item {
                    BrandHeaderButton(
                        modifier = itemModifier,
                        text = stringResource(id = R.string.collection_detail_add_question)
                    ) {
                        listener.onCreateNewItem()
                    }
                }
                items(
                    sessions.value,
                    key = { it.uid }
                ) { session ->
                    SessionCard(
                        modifier = itemModifier,
                        session = session,
                        onClick = {
                            selectedSession.value = session
                        },
                        onLongClick = {
                            listener.onCheckingStarted(session.uid)
                        }
                    )
                }
            }
        }
    }else {
        ShimmerLayout()
    }
}

@Composable
private fun ShimmerLayout() {

}