package study.me.please.ui.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.squadris.squadris.compose.theme.LocalTheme

/**
 * Simple bottom sheet layout
 * material3 library crashes due to internal issue - TODO make a switch the moment it works
 */
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SimpleBottomSheet(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit = {},
    topBar: (@Composable () -> Unit)? = null,
    sheetContent: @Composable ColumnScope.() -> Unit = {},
    state: BottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            skipHiddenState = false, initialValue = SheetValue.Hidden
        )
    ),
    content: @Composable (paddingValues: PaddingValues) -> Unit = {}
) {
    LaunchedEffect(key1 = state.bottomSheetState.currentValue) {
        if(state.bottomSheetState.isVisible.not()) {
            onDismissRequest()
        }
    }
    BottomSheetScaffold(
        sheetContent = sheetContent,
        content = content,
        modifier = modifier,
        scaffoldState = state,
        sheetPeekHeight = 0.dp,
        contentColor = Color.Transparent,
        topBar = topBar,
        sheetContentColor = Color.Transparent,
        sheetShape = RoundedCornerShape(
            topStart = LocalTheme.current.shapes.componentCornerRadius,
            topEnd = LocalTheme.current.shapes.componentCornerRadius
        ),
        sheetContainerColor = LocalTheme.current.colors.onBackgroundComponent,
        sheetDragHandle = {},
        containerColor = Color.Transparent,
        sheetShadowElevation = LocalTheme.current.styles.actionElevation,
        sheetTonalElevation = LocalTheme.current.styles.actionElevation
    )
}