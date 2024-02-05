package study.me.please.ui.units.detail

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.gson.GsonBuilder
import com.squadris.squadris.compose.theme.LocalTheme
import study.me.please.base.LocalNavController
import study.me.please.base.navigation.NavigationComponent
import study.me.please.base.navigation.NavigationComponent.getArgument
import study.me.please.base.navigation.NavigationNotepadScreen
import study.me.please.data.io.ImportSourceType
import study.me.please.data.io.ImportedSource

/** Embedded navigation under other screen */
@Composable
fun EmbeddedUnitNavigator(
    importedSource: ImportedSource? = null,
    paragraphUid: String? = null,
    unitUid: String? = null
) {
    val navController = rememberNavController()
    val gson = remember {
        GsonBuilder().create()
    }

    CompositionLocalProvider(LocalNavController provides navController) {
        NavHost(
            modifier = Modifier.background(LocalTheme.colors.backgroundLight),
            navController = navController,
            startDestination = if(paragraphUid != null || importedSource?.type == ImportSourceType.PARAGRAPH) {
                NavigationNotepadScreen.Paragraph.makeRoute(
                    importedSource = if(importedSource != null) gson.toJson(importedSource) else null,
                    isEmbedded = true,
                    paragraphUid = paragraphUid
                )
            }else NavigationNotepadScreen.Unit.makeRoute(
                isEmbedded = true,
                unitUid = unitUid ?: ""
            )
        ) {
            // PARAGRAPH
            composable(
                NavigationNotepadScreen.Paragraph.route,
                arguments = NavigationNotepadScreen.Paragraph.navArguments,
                deepLinks = NavigationNotepadScreen.Paragraph.deepLinks
            ) { backStackEntry ->
                ParagraphScreen(
                    isEmbedded = backStackEntry.getArgument(NavigationComponent.IS_EMBEDDED)?.toBoolean() == true,
                    paragraphUid = backStackEntry.getArgument(NavigationComponent.PARAGRAPH_UID),
                    importedSource = gson.fromJson(
                        backStackEntry.getArgument(NavigationComponent.PARAGRAPH_SOURCE),
                        ImportedSource::class.java
                    )
                )
            }

            // UNIT
            composable(
                NavigationNotepadScreen.Unit.route,
                arguments = NavigationNotepadScreen.Unit.navArguments,
                deepLinks = NavigationNotepadScreen.Unit.deepLinks
            ) { backStackEntry ->
                backStackEntry.getArgument(NavigationComponent.UNIT_UID)?.let { unitUid ->
                    UnitScreen(
                        isEmbedded = backStackEntry.getArgument(NavigationComponent.IS_EMBEDDED)?.toBoolean() == true,
                        unitUid = unitUid
                    )
                }
            }
        }
    }
}