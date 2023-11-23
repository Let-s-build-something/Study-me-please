package study.me.please.ui.settings

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.squadris.squadris.compose.theme.LocalTheme
import study.me.please.R
import study.me.please.base.BrandBaseScreen

/**
 * Screen for editing app preferences
 */
@Composable
fun SettingsScreen(
    isDarkTheme: Boolean,
    viewModel: SettingsViewModel = hiltViewModel(),
    onThemeChange: (isDarkTheme: Boolean) -> Unit = {}
) {
    BrandBaseScreen(
        title = stringResource(id = R.string.screen_settings_title)
    ) { paddingValues ->
        ConstraintLayout(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 10.dp)
        ) {
            val (txtTheme, switchTheme) = createRefs()
            Text(
                modifier = Modifier
                    .constrainAs(txtTheme) {
                        start.linkTo(parent.start)
                        top.linkTo(switchTheme.top)
                        bottom.linkTo(switchTheme.bottom)
                    },
                text = stringResource(id = R.string.screen_settings_text_theme),
                color = LocalTheme.colors.secondary,
                fontSize = 16.sp
            )
            Switch(
                modifier = Modifier
                    .padding(12.dp)
                    .constrainAs(switchTheme) {
                        start.linkTo(txtTheme.end)
                    },
                checked = isDarkTheme,
                onCheckedChange = { isChecked ->
                    viewModel.requestThemeChange(isChecked)
                    onThemeChange(isChecked)
                },
                colors = LocalTheme.styles.switchColorsDefault
            )
        }
    }
}