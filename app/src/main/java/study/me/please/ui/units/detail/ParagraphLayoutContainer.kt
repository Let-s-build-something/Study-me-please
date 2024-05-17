package study.me.please.ui.units.detail

import androidx.activity.OnBackPressedDispatcher
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardReturn
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.Velocity
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.squadris.squadris.compose.components.MinimalisticIcon
import com.squadris.squadris.compose.theme.LocalTheme
import study.me.please.base.navigation.NavigationNode.Companion.composableNode
import study.me.please.base.navigation.NavigationNotepadScreen
import study.me.please.data.io.ImportSourceType
import study.me.please.data.io.ImportedSource
import study.me.please.ui.components.ComponentHeaderButton
import study.me.please.ui.components.collapsing_layout.CollapsingBehavior
import study.me.please.ui.components.collapsing_layout.CollapsingLayout

/** screen for subject detail with user's main notes for certain collection */
@Composable
fun ParagraphLayoutContainer(
    modifier: Modifier = Modifier,
    importedSource: ImportedSource? = null,
    onCloseRequest: () -> Unit
) {
    val navController = rememberNavController()

    val currentImportedSource = remember {
        mutableStateOf(
            if(importedSource?.type == ImportSourceType.FACT) {
                importedSource.parent
            }else importedSource
        )
    }

    CollapsingLayout(
        modifier = modifier
            .background(
                LocalTheme.colors.onBackgroundComponentContrast,
                shape = LocalTheme.shapes.componentShape
            )
            .padding(4.dp)
            .nestedScroll(object : NestedScrollConnection {
                override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset =
                    Offset.Zero

                override suspend fun onPreFling(available: Velocity): Velocity = Velocity.Zero
                override suspend fun onPostFling(
                    consumed: Velocity,
                    available: Velocity
                ): Velocity = Velocity.Zero

                override fun onPostScroll(
                    consumed: Offset,
                    available: Offset,
                    source: NestedScrollSource
                ): Offset = Offset.Zero
            })
            .animateContentSize(),
        content = listOf(
            @Composable {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = if(currentImportedSource.value?.parent?.type == ImportSourceType.PARAGRAPH) {
                        Arrangement.SpaceBetween
                    }else Arrangement.End
                ) {
                    AnimatedVisibility(
                        currentImportedSource.value?.parent?.type == ImportSourceType.PARAGRAPH
                    ) {
                        ComponentHeaderButton(
                            startIconVector = Icons.AutoMirrored.Outlined.KeyboardReturn,
                            onClick = {
                                navController.navigate(
                                    NavigationNotepadScreen.Paragraph.createRoute(
                                        NavigationNotepadScreen.Paragraph.ParagraphArgument(
                                            paragraphUid = currentImportedSource.value?.parent?.sourceUid ?: ""
                                        )
                                    )
                                )
                                currentImportedSource.value = currentImportedSource.value?.parent
                            }
                        )
                    }
                    MinimalisticIcon(
                        imageVector = Icons.Outlined.Close,
                        onClick = onCloseRequest
                    )
                }
            } to CollapsingBehavior.ALWAYS,
            @Composable {
                CompositionLocalProvider(
                    androidx.activity.compose.LocalOnBackPressedDispatcherOwner provides object: OnBackPressedDispatcherOwner {
                        override val lifecycle: Lifecycle = LocalLifecycleOwner.current.lifecycle
                        override val onBackPressedDispatcher: OnBackPressedDispatcher = OnBackPressedDispatcher()
                    }
                ) {
                    NavHost(
                        modifier = Modifier.background(color = LocalTheme.colors.backgroundLight),
                        navController = navController,
                        startDestination = NavigationNotepadScreen.Paragraph.route
                    ) {
                        composableNode(NavigationNotepadScreen.Paragraph) { _, argument ->
                            ParagraphLayout(
                                paragraphUid = argument?.paragraphUid ?: currentImportedSource.value?.sourceUid,
                                factUid = if(currentImportedSource.value?.type == ImportSourceType.FACT) {
                                    currentImportedSource.value?.sourceUid
                                }else null
                            )
                        }
                    }
                }

            } to CollapsingBehavior.NONE
        )
    )
}