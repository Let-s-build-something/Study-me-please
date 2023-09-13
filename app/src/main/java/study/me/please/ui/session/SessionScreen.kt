package study.me.please.ui.session

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

/**
 * Screen for displaying and answering questions within pre-defined session
 * @param isTestingMode the session will not be saved.
 *                      Session also has extra functionality for discovery purposes
 * @param sessionUid session identifier
 * @param collectionUid collection identifier
 * @param questionUid question identifier
 */
@Composable
fun SessionScreen(
    navController: NavController,
    isTestingMode: Boolean = false,
    sessionUid: String? = null,
    collectionUid: String? = null,
    questionUid: String? = null,
    changeActionBar: (actions: @Composable RowScope.() -> Unit) -> Unit,
    viewModel: SessionViewModel = hiltViewModel()
) {
    val session = viewModel.dataManager.session.collectAsState()
    val collection = viewModel.dataManager.collection.collectAsState()
    val question = viewModel.dataManager.question.collectAsState()

    questionUid?.let { uid ->
        viewModel.requestQuestionByUid(uid)
    }
    collectionUid?.let { uid ->
        viewModel.requestCollectionByUid(uid)
    }
    sessionUid?.let { uid ->
        viewModel.requestSessionByUid(uid)
    }
}