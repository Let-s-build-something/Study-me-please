package study.me.please.ui.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.squadris.squadris.compose.theme.AppTheme

/**
 * Simple bottom sheet layout
 * material3 library crashes due to internal issue - TODO make a switch the moment it works
 */
@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun SimpleBottomSheet(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit = {},
    topBar: (@Composable () -> Unit)? = null,
    sheetContent: @Composable ColumnScope.() -> Unit = {},
    state: BottomSheetScaffoldState = rememberBottomSheetScaffoldState(),
    content: @Composable (paddingValues: PaddingValues) -> Unit = {}
) {
    LaunchedEffect(key1 = state.bottomSheetState.currentValue) {
        if(state.bottomSheetState.isCollapsed) {
            onDismissRequest()
        }
    }
    androidx.compose.material.BottomSheetScaffold(
        modifier = modifier,
        scaffoldState = state,
        sheetPeekHeight = 0.dp,
        contentColor = Color.Transparent,
        sheetElevation = 24.dp,
        backgroundColor = Color.Transparent,
        topBar = topBar,
        sheetContent = sheetContent,
        content = content,
        sheetBackgroundColor = AppTheme.colors.onBackgroundComponentContrast,
        sheetContentColor = Color.Transparent,
        drawerScrimColor = Color.Transparent,
        drawerBackgroundColor = Color.Transparent,
        drawerContentColor = Color.Transparent,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
    )
}