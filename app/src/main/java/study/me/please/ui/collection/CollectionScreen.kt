package study.me.please.ui.collection

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.squadris.squadris.compose.components.getDefaultPullRefreshSize
import com.squadris.squadris.compose.theme.AppTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.base.DraggableRefreshIndicator
import study.me.please.base.ProgressBarRefreshIndicator
import study.me.please.base.navigation.NavigationUtils
import study.me.please.ui.components.CollectionCard
import study.me.please.ui.components.AddNewItemFooter
import study.me.please.ui.components.CollectionCardMode
import study.me.please.ui.components.CollectionCardState
import study.me.please.ui.components.rememberCollectionCardState

/** Screen with user's collections */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CollectionScreen(
    navController: NavController,
    activity: Activity,
    viewModel: CollectionViewModel = hiltViewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    val isRefreshing = remember { mutableStateOf(false) }
    val pullRefreshSize = getDefaultPullRefreshSize(activity = activity)
    val pullRefreshState = rememberPullRefreshState(
        refreshing = isRefreshing.value,
        onRefresh = {
            coroutineScope.launch {
                isRefreshing.value = true
                delay(2000)
                isRefreshing.value = false
            }
        },
        refreshThreshold = pullRefreshSize,
        refreshingOffset = pullRefreshSize
    )

    val collectionStates = mutableListOf<CollectionCardState>()
    val collections = viewModel.dataManager.collections.collectAsState()
    if(collections.value == null) {
        viewModel.requestCollections()
    }
    val indicatorOffset = remember { mutableStateOf(0.dp) }

    for(i in 0 until (collections.value?.size ?: 0)) {
        collectionStates.add(
            rememberCollectionCardState(
                mode = CollectionCardMode.DATA_DISPLAY,
                isChecked = false
            )
        )
    }

    DraggableRefreshIndicator(
        pullRefreshSize = pullRefreshSize,
        state = pullRefreshState,
        isRefreshing = isRefreshing.value
    ) { indicatorOffsetDp ->
        indicatorOffset.value = indicatorOffsetDp
    }
    ConstraintLayout(
        modifier = Modifier
            .pullRefresh(pullRefreshState)
            .fillMaxSize()
            .graphicsLayer {
                translationY = indicatorOffset.value.toPx()
            }
    ) {
        val mainContent = createRef()
        ProgressBarRefreshIndicator(isRefreshing = isRefreshing.value, state = pullRefreshState)
        LazyColumn(
            modifier = Modifier
                .constrainAs(mainContent) {
                    linkTo(
                        parent.top,
                        parent.bottom
                    )
                    linkTo(
                        parent.start,
                        parent.end,
                        startMargin = 8.dp,
                        endMargin = 8.dp
                    )
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                },
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                AddNewItemFooter(
                    modifier = Modifier.padding(top = 4.dp),
                    text = stringResource(id = R.string.add_new_collection)
                ) {
                    NavigationUtils.navigateToCollectionDetail(
                        navController = navController,
                        name = activity.getString(R.string.screen_collection_detail_new)
                    )
                }
            }
            if(collections.value?.isNotEmpty() == true) {
                itemsIndexed(
                    items = collections.value ?: listOf(),
                    key = { _, item ->
                        item.uid
                    }
                ) { index, item ->
                    CollectionCard(
                        imageVector = null, //TODO
                        iconUrlPath = item.icon?.url,
                        questionMode = item.defaultPreference.estimatedMode,
                        description = item.description,
                        dateCreated = item.dateCreated,
                        state = collectionStates.getOrNull(index) ?: rememberCollectionCardState(),
                        heading = item.name,
                        onLongClick = {
                            collectionStates.forEach {
                                it.mode = CollectionCardMode.CHECKING
                            }
                        }
                    )
                }
            }else if(collections.value?.isEmpty() == true) {
                item {
                    EmptyScreen()
                }
            }else {
                // loading state
            }
        }
    }
}

@Composable
private fun EmptyScreen() {
    val localConfiguration = LocalConfiguration.current
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.animation_empty)
    )
    // empty state
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 12.dp,
                bottom = 4.dp
            ),
        text = stringResource(id = R.string.collection_empty_error),
        fontSize = 18.sp,
        color = AppTheme.colors.secondary,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
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
}