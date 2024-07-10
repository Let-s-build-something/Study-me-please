package study.me.please.ui.community

import androidx.activity.compose.BackHandler
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.CleaningServices
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.squadris.squadris.compose.base.LocalNavController
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.ext.brandShimmerEffect
import com.squadris.squadris.utils.RefreshableViewModel.Companion.requestData
import study.me.please.R
import study.me.please.base.navigation.NavigationRoot
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.community.CollectionCategoryIO
import study.me.please.ui.collection.EmptyLayout
import study.me.please.ui.components.BrandHeaderButton
import study.me.please.ui.components.CONTENT_TILE_HEIGHT_DP
import study.me.please.ui.components.ComponentHeaderButton
import study.me.please.ui.components.ContentTile
import study.me.please.ui.components.community.PublicCollectionCard
import study.me.please.ui.components.pull_refresh.PullRefreshScreen
import java.util.UUID

/** Home screen for the community section */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CommunityScreen(
    viewModel: CommunityViewModel = hiltViewModel()
) {
    val navController = LocalNavController.current
    val context = LocalContext.current

    val filter = viewModel.filter.collectAsState()
    val categories = viewModel.categories.collectAsState(initial = null)
    val collections = viewModel.collections.collectAsState(initial = null)

    LaunchedEffect(Unit) {
        viewModel.requestData(isSpecial = true, isPullRefresh = false)
    }

    PullRefreshScreen(
        viewModel = viewModel,
        title = stringResource(R.string.home_screen_community)
    ) {
        BackHandler(filter.value.categoryUid != null) {
            viewModel.clearFilter()
        }

        Crossfade(
            targetState = filter.value.categoryUid != null,
            label = "crossfadeSearchContent"
        ) { isSearch ->
            if(isSearch) {
                Crossfade(
                    targetState = collections.value?.isEmpty() == true,
                    label = "crossfadeEmptyLayout"
                ) { isEmpty ->
                    if(isEmpty) {
                        EmptyLayout(
                            emptyText = stringResource(R.string.community_search_empty)
                        ) {
                            BrandHeaderButton(
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .fillMaxWidth(0.8f),
                                startIconVector = Icons.Outlined.Add,
                                text = stringResource(id = R.string.community_search_action_two),
                                onClick = {
                                    navController?.navigate(
                                        NavigationRoot.CollectionDetail.createRoute(
                                            NavigationRoot.CollectionDetail.CollectionDetailArgument(
                                                toolbarTitle = context.getString(R.string.screen_collection_detail_new)
                                            )
                                        )
                                    )
                                }
                            )
                            ComponentHeaderButton(
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .fillMaxWidth(0.8f),
                                startIconVector = Icons.Outlined.CleaningServices,
                                text = stringResource(id = R.string.community_search_action_one),
                                onClick = {
                                    viewModel.clearFilter()
                                }
                            )
                        }
                    }else {
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(LocalTheme.current.shapes.betweenItemsSpace)
                        ) {
                            item { Spacer(modifier = Modifier.height(4.dp)) }
                            items(
                                items = collections.value ?: arrayOfNulls<CollectionIO?>(6).toList(),
                                key = {
                                    it?.uid ?: UUID.randomUUID().toString()
                                }
                            ) { collection ->
                                PublicCollectionCard(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 8.dp),
                                    collection = collection,
                                    onClick = {
                                        navController?.navigate(
                                            NavigationRoot.PublicCollection.createRoute(
                                                NavigationRoot.PublicCollection.PublicCollectionArgument(
                                                    collectionName = collection?.name ?: "",
                                                    collectionUid = collection?.uid ?: ""
                                                )
                                            )
                                        )
                                    }
                                )
                            }
                        }
                    }
                }
            }else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(LocalTheme.current.shapes.betweenItemsSpace)
                ) {
                    item { Spacer(modifier = Modifier.height(4.dp)) }
                    items(
                        items = categories.value ?: arrayOfNulls<CollectionCategoryIO?>(6).toList()
                    ) { category ->
                        Crossfade(
                            modifier = Modifier.padding(horizontal = 8.dp),
                            targetState = category != null,
                            label = "crossfadeShimmerContent"
                        ) { isLoaded ->
                            if(isLoaded && category != null) {
                                ContentTile(
                                    modifier = Modifier.fillMaxWidth(),
                                    imageUrl = category.imageUrl,
                                    title = category.name,
                                    description = category.description,
                                    onClick = {
                                        viewModel.filterCollection(category.uid)
                                    }
                                )
                            }else {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(CONTENT_TILE_HEIGHT_DP.dp)
                                        .brandShimmerEffect()
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}