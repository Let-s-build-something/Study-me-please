package study.me.please.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.squadris.squadris.compose.theme.LocalTheme

/**
 * Bottom sheet layout for editing a question
 * material3 library crashes due to internal issue - TODO make a switch the moment it works
 */
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
@Deprecated("Replace with [OptionsLayout]")
fun ListOptionsBottomSheet(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit = {},
    topBar: (@Composable () -> Unit)? = null,
    actions: @Composable () -> Unit = {},
    sheetContentModifier: Modifier = Modifier,
    state: BottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(skipHiddenState = false)
    ),
    content: @Composable (paddingValues: PaddingValues) -> Unit = {}
) {
    SimpleBottomSheet(
        sheetContent = {
            Row(
                modifier = sheetContentModifier
                    .horizontalScroll(rememberScrollState())
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 8.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(
                    LocalTheme.shapes.betweenItemsSpace
                )
            ) {
                Spacer(modifier = Modifier.width(LocalTheme.shapes.betweenItemsSpace))
                actions()
                Spacer(modifier = Modifier.width(LocalTheme.shapes.betweenItemsSpace))
            }
        },
        modifier = modifier,
        onDismissRequest = onDismissRequest,
        topBar = topBar,
        state = state,
        content = content,
    )
}