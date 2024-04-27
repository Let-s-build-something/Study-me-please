package study.me.please.ui.account

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.squadris.squadris.compose.theme.LocalTheme
import study.me.please.R
import study.me.please.base.BrandBaseScreen
import study.me.please.base.LocalNavController
import study.me.please.base.navigation.NavIconType
import study.me.please.ui.components.ErrorHeaderButton

/**
 * Main screen for displaying basic user data and dashboard for user-related actions
 */
@Composable
fun AccountDashboardScreen(
    viewModel: AccountDashboardViewModel = hiltViewModel()
) {
    val navController = LocalNavController.current

    val currentUser = viewModel.currentUser.collectAsState()

    LaunchedEffect(key1 = currentUser.value) {
        if(currentUser.value == null) navController?.popBackStack()
    }

    BrandBaseScreen(
        title = stringResource(R.string.screen_account_title),
        subtitle = currentUser.value?.displayName,
        navIconType = NavIconType.HOME,
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f),
                model = R.drawable.i1_sign_in,
                contentDescription = stringResource(R.string.accessibility_sign_in_illustration)
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
                    .background(
                        color = LocalTheme.colors.onBackgroundComponent,
                        shape = LocalTheme.shapes.componentShape
                    )
                    .fillMaxSize()
                    .padding(vertical = 8.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Bottom
            ) {
                ErrorHeaderButton(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    text = stringResource(R.string.account_dashboard_button_logout),
                    onClick = {
                        viewModel.logoutCurrentUser()
                    }
                )
            }
        }
    }
}