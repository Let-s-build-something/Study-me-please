package study.me.please.ui.collection.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.squadris.squadris.compose.theme.AppTheme
import com.squadris.squadris.ext.brandShimmerEffect
import kotlinx.coroutines.flow.update
import study.me.please.R
import study.me.please.data.io.CollectionIO
import study.me.please.ui.components.AddNewItemFooter
import study.me.please.ui.components.EditFieldInput
import study.me.please.ui.components.ImageAction

enum class CollectionEditMode {
    NAME,
    DESCRIPTION,
    ALL,
    NONE;
}

data class CreateCollectionState(
    val editMode: CollectionEditMode
)

/**
 * Screen for creating a new collection
 * including adding of questions, configuration and import of both
 */
@Preview
@Composable
fun CreateCollectionScreen(
    collectionUid: String? = null,
    viewModel: CollectionDetailViewModel = hiltViewModel()
) {
    val collectionDetail = viewModel.dataManager.collectionDetail.collectAsState()
    val collectionState = remember { mutableStateOf(CreateCollectionState(
        editMode = CollectionEditMode.NONE
    )) }

    if(collectionUid != null) {
        viewModel.requestCollectionByUid(collectionUid)
    }
    if(collectionUid != null && collectionDetail.value.dateCreated == null) {
        ShimmerLayout()
    }else {
        ContentLayout(
            collectionDetail = collectionDetail.value,
            collectionState = collectionState.value,
            viewModel = viewModel
        )
    }
}

/** Layout for main content - showing actual information */
@Composable
private fun ContentLayout(
    collectionDetail: CollectionIO = CollectionIO(name = "name", description = "looong description"),
    collectionState: CreateCollectionState,
    viewModel: CollectionDetailViewModel
) {
    val backgroundCardModifier = Modifier
        .padding(start = 12.dp, end = 12.dp, top = 16.dp)
        .background(
            color = AppTheme.colors.onBackgroundComponent,
            shape = RoundedCornerShape(16.dp)
        )
        .fillMaxWidth()
        .padding(vertical = 12.dp, horizontal = 12.dp)

    val itemModifier = Modifier
        .padding(horizontal = 4.dp, vertical = 4.dp)
        .wrapContentHeight()
        .fillMaxWidth()

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        val (rowActions, columnInputs, columnContent) = createRefs()
        Row(
            modifier = backgroundCardModifier
                .horizontalScroll(rememberScrollState())
                .constrainAs(rowActions) {
                    linkTo(parent.start, parent.end)
                    top.linkTo(parent.top)
                }
        ) {
            if(collectionDetail.dateCreated != null) {
                ImageAction(
                    imageVector = Icons.Outlined.Edit,
                    text = stringResource(id = R.string.collection_detail_edit)
                ) {

                }
            }
        }
        Column(
            modifier = backgroundCardModifier
                .constrainAs(columnInputs) {
                    linkTo(parent.start, parent.end)
                    top.linkTo(rowActions.bottom)
                }
        ) {
            if(collectionDetail.name.isEmpty()
                || collectionState.editMode == CollectionEditMode.NAME
                || collectionState.editMode == CollectionEditMode.ALL
            ) {
                EditFieldInput(
                    modifier = itemModifier,
                    value = collectionDetail.name,
                    hint = stringResource(id = R.string.collection_detail_name_hint)
                ) { output ->
                    viewModel.dataManager.collectionDetail.update {
                        it.apply {
                            name = output
                        }
                    }
                }
            }else {
                Text(
                    modifier = itemModifier,
                    text = collectionDetail.name,
                    fontWeight = FontWeight.Bold,
                    color = AppTheme.colors.primary,
                    fontSize = 16.sp
                )
            }
            if(collectionDetail.description.isEmpty()
                || collectionState.editMode == CollectionEditMode.DESCRIPTION
                || collectionState.editMode == CollectionEditMode.ALL
            ) {
                EditFieldInput(
                    modifier = itemModifier,
                    value = collectionDetail.description,
                    hint = stringResource(id = R.string.collection_detail_description_hint),
                    minLines = 8,
                    maxLines = 8
                ) { output ->
                    viewModel.dataManager.collectionDetail.update {
                        it.apply {
                            description = output
                        }
                    }
                }
            }else {
                Text(
                    modifier = itemModifier,
                    text = collectionDetail.description,
                    fontWeight = FontWeight.Normal,
                    color = AppTheme.colors.primary,
                    fontSize = 14.sp
                )
            }
        }
        Column(
            modifier = backgroundCardModifier
                .constrainAs(columnContent) {
                    linkTo(parent.start, parent.end)
                    top.linkTo(columnInputs.bottom)
                }
        ) {
            Text(
                modifier = itemModifier,
                text = stringResource(id = R.string.collection_detail_questions_heading),
                color = AppTheme.colors.secondary,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            collectionDetail.questions.forEach {

            }
            AddNewItemFooter(
                modifier = itemModifier,
                text = stringResource(id = R.string.add_new_content_description)
            )
        }
    }
}

/** Layout for loading - shimmer effect */
@Composable
private fun ShimmerLayout() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
        ) {
            repeat(5) {
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .width(120.dp)
                        .brandShimmerEffect(RoundedCornerShape(12.dp))
                )
            }
        }
    }
}