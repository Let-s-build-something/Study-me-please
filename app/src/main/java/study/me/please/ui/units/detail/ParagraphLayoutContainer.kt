package study.me.please.ui.units.detail

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardReturn
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.Velocity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.squadris.squadris.compose.components.MinimalisticIcon
import com.squadris.squadris.compose.theme.LocalTheme
import study.me.please.base.navigation.NavigationComponent
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
            .background(LocalTheme.colors.backgroundLight)
            .nestedScroll(object: NestedScrollConnection {
                override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset = Offset.Zero
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
                                    NavigationNotepadScreen.Paragraph.makeRoute(
                                        paragraphUid = currentImportedSource.value?.parent?.sourceUid
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
                NavHost(
                    modifier = Modifier.background(color = LocalTheme.colors.backgroundLight),
                    navController = navController,
                    startDestination = NavigationNotepadScreen.Paragraph.route
                ) {
                    composable(
                        NavigationNotepadScreen.Paragraph.route,
                        deepLinks = NavigationNotepadScreen.Paragraph.deepLinks,
                        arguments = NavigationNotepadScreen.Paragraph.navArguments
                    ) { navBackstackEntry ->
                        (navBackstackEntry.arguments?.getString(
                            NavigationComponent.PARAGRAPH_UID
                        ) ?: currentImportedSource.value?.sourceUid)?.let { paragraphUid ->
                            ParagraphLayout(
                                paragraphUid = paragraphUid,
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