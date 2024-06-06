package study.me.please.ui.sign_up

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.credentials.CredentialManager
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.squadris.squadris.compose.theme.LocalTheme
import study.me.please.R
import study.me.please.base.BrandBaseScreen
import com.squadris.squadris.compose.base.LocalNavController
import com.squadris.squadris.compose.components.navigation.NavIconType

/** screen for sign up (registration) */
@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel = hiltViewModel()
) {
    BrandBaseScreen(
        title = stringResource(R.string.screen_sign_up),
        subtitle = stringResource(R.string.screen_sign_up_subtitle),
        navIconType = NavIconType.BACK
    ) {
        SignUpContent(
            viewModel = viewModel
        )
    }
}

private const val LOADING_DISPLAY_DELAY = 200L
private const val DATA_REQUEST_DELAY = 1000L

@Preview(showBackground = true)
@Composable
private fun SignUpContent(
    viewModel: SignUpViewModel? = null
) {
    val context = LocalContext.current
    val navController = LocalNavController.current

    val currentUser = viewModel?.currentUser?.collectAsState()

    val credentialManager = remember { CredentialManager.create(context) }

    LaunchedEffect(currentUser?.value) {
        if(currentUser?.value != null) {
            navController?.popBackStack()
        }
    }

    Column(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .fillMaxSize()
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f),
            model = R.drawable.i0_sign_up,
            contentDescription = stringResource(R.string.accessibility_sign_up_illustration)
        )

        Row(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .background(
                    color = LocalTheme.current.colors.onBackgroundComponent,
                    shape = LocalTheme.current.shapes.componentShape
                )
                .padding(vertical = 12.dp, horizontal = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .clickable {
                        viewModel?.requestGoogleSignIn(
                            webClientId = context.getString(R.string.firebase_web_client_id),
                            filterAuthorizedAccounts = true,
                            credentialManager = credentialManager,
                            context = context
                        )
                    },
                painter = painterResource(LocalTheme.current.icons.googleSignUp),
                contentDescription = null
            )
        }

        /*Text(
            modifier = Modifier.padding(start = 8.dp),
            text = stringResource(R.string.sign_up_username_helper),
            style = TextStyle(
                fontSize = 12.sp,
                color = LocalTheme.colors.secondary
            )
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            EditFieldInput(
                modifier = Modifier.weight(1f),
                hint = stringResource(R.string.sign_up_username_hint),
                value = "",
                onValueChange = { value ->
                    if(value.isNotBlank()) {
                        viewModel?.inputState?.value = SignUpViewModel.InputState.IDLE
                        inputScope.coroutineContext.cancelChildren()
                        inputScope.launch {
                            delay(LOADING_DISPLAY_DELAY)
                            viewModel?.inputState?.value = SignUpViewModel.InputState.LOADING
                            delay(DATA_REQUEST_DELAY)
                            viewModel?.checkUsernameValidity(value)
                        }
                    }
                },
                paddingValues = PaddingValues(start = 16.dp),
                isError = inputState?.value == SignUpViewModel.InputState.ERROR,
                errorText = usernameResponse?.value?.errorText
            )
            AnimatedVisibility(
                visible = inputState?.value == SignUpViewModel.InputState.SUCCESS
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(32.dp),
                    color = LocalTheme.colors.brandMain,
                    strokeWidth = 2.dp,
                    trackColor = LocalTheme.colors.secondary,
                )
            }
        }

        AnimatedVisibility(
            visible = true//inputState?.value == SignUpViewModel.InputState.SUCCESS
        ) {

        }*/
    }
}