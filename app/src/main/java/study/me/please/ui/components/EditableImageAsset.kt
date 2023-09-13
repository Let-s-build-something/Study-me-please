package study.me.please.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.request.ImageRequest
import com.squadris.squadris.compose.theme.AppTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import study.me.please.R
import study.me.please.data.io.LargePathAsset

/**
 * @param asset url and uri data for loading this image
 */
@Composable
fun EditableImageAsset(
    modifier: Modifier = Modifier,
    asset: LargePathAsset?,
    isInEditMode: Boolean = false,
    onUrlChange: (output: String) -> Unit = {},
    onLoadState: (state: AsyncImagePainter.State) -> Unit = {}
) {
    val isFieldError = remember { mutableStateOf(false) }
    val isLoading = remember { mutableStateOf(false) }
    val loadingScope = rememberCoroutineScope()
    val currentProgress = remember { mutableFloatStateOf(0f) }

    LaunchedEffect(isLoading.value) {
        loadingScope.launch {
            while (isLoading.value) {
                if(currentProgress.floatValue >= 1f) {
                    currentProgress.floatValue = 0f
                }else {
                    currentProgress.floatValue += 0.01f
                    delay(10)
                }
            }
        }
    }

    Column(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        if(asset != null) {
            if(isLoading.value) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .size(32.dp)
                        .animateContentSize(),
                    trackColor = AppTheme.colors.secondary,
                    strokeWidth = 2.dp,
                    color = AppTheme.colors.brandMain,
                    progress = currentProgress.floatValue
                )
            }
            if(!asset.isEmpty) {
                AsyncImage(
                    modifier = Modifier
                        .animateContentSize()
                        .wrapContentHeight()
                        .fillMaxWidth(),
                    model = if(asset.isLocal) {
                        asset.localUri
                    }else {
                        ImageRequest.Builder(LocalContext.current)
                            .data(asset.url)
                            .crossfade(true)
                            .build()
                    },
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    onState = { loadState ->
                        isFieldError.value = loadState is AsyncImagePainter.State.Error
                        isLoading.value = loadState is AsyncImagePainter.State.Loading
                        onLoadState(loadState)
                    }
                )
            }
            if(isInEditMode) {
                EditFieldInput(
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    value = (if(asset.isLocal) {
                        stringResource(id = R.string.image_field_local_value)
                    } else asset.urlPath) ?: "",
                    hint = stringResource(id = R.string.image_field_url_hint),
                    minLines = 1,
                    maxLines = 1,
                    isError = isFieldError.value,
                    clearable = true
                ) { output ->
                    onUrlChange(output)
                    isFieldError.value = false
                }
            }
        }
    }
}