package study.me.please.ui.community.collection

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Download
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.squadris.squadris.compose.base.LocalNavController
import com.squadris.squadris.compose.components.navigation.ActionBarIcon
import com.squadris.squadris.compose.components.navigation.NavIconType
import com.squadris.squadris.utils.RefreshableViewModel.Companion.requestData
import study.me.please.R
import study.me.please.base.navigation.NavigationRoot
import study.me.please.ui.components.pull_refresh.PullRefreshScreen

/** Screen for displaying public collections */
@Composable
fun PublicCollectionScreen(
    viewModel: PublicCollectionViewModel = hiltViewModel(),
    collectionUid: String,
    collectionName: String
) {
    val navController = LocalNavController.current

    val collection = viewModel.collection.collectAsState()


    LaunchedEffect(Unit) {
        viewModel.collectionUid = collectionUid
        viewModel.requestData(isSpecial = true, isPullRefresh = false)
    }

    PullRefreshScreen(
        title = collectionName,
        viewModel = viewModel,
        navIconType = NavIconType.BACK,
        actionIcons = {
            ActionBarIcon(
                text = stringResource(id = R.string.button_download),
                imageVector = Icons.Outlined.Download,
                onClick = {
                    viewModel.downloadCollection(onSuccess = { newUid ->
                        navController?.navigate(
                            NavigationRoot.CollectionDetail.createRoute(
                                NavigationRoot.CollectionDetail.CollectionDetailArgument(
                                    collectionUid = newUid,
                                    toolbarTitle = collectionName
                                )
                            )
                        )
                    })
                }
            )
        }
    ) {
        Column {

        }
    }
}