package study.me.please.ui.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import study.me.please.R
import study.me.please.base.BrandBaseScreen
import com.squadris.squadris.compose.components.navigation.NavIconType
import study.me.please.ui.components.SwitchText

/**
 * Screen for editing app preferences
 */
@Composable
fun SettingsScreen(
    isDarkTheme: MutableState<Boolean>,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    BrandBaseScreen(
        title = stringResource(id = R.string.screen_settings_title),
        navIconType = NavIconType.HOME
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(12.dp)
        ) {
            SwitchText(
                text = stringResource(id = R.string.screen_settings_text_theme),
                isChecked = isDarkTheme.value,
                onCheckChanged = { isChecked ->
                    viewModel.requestThemeChange(isChecked)
                    isDarkTheme.value = isChecked
                }
            )
        }
    }
}