package com.squadris.squadris.compose.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.squadris.squadris.compose.theme.LocalTheme

/**
 * Simple bottom sheet layout
 * material3 library crashes due to internal issue - TODO make a switch the moment it works
 */
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SimpleModalBottomSheet(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit = {},
    sheetState: SheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
    contentWindowInsets: @Composable () -> WindowInsets = { BottomSheetDefaults.windowInsets },
    content: @Composable ColumnScope.() -> Unit = {}
) {
    // hotfix, native onDismissRequest doesn't work when collapsing by drag
    val previousValue = remember { mutableStateOf(sheetState.currentValue) }
    LaunchedEffect(sheetState.currentValue) {
        if(previousValue.value != SheetValue.Hidden && sheetState.currentValue == SheetValue.Hidden) {
            onDismissRequest()
        }
        previousValue.value = sheetState.currentValue
    }
    ModalBottomSheet(
        modifier = modifier,
        onDismissRequest = onDismissRequest,
        content = content,
        sheetState = sheetState,
        containerColor = LocalTheme.current.colors.onBackgroundComponent,
        shape = RoundedCornerShape(
            topStart = LocalTheme.current.shapes.componentCornerRadius,
            topEnd = LocalTheme.current.shapes.componentCornerRadius
        ),
        tonalElevation = LocalTheme.current.styles.actionElevation,
        dragHandle = {  },
        contentWindowInsets = contentWindowInsets
    )
}