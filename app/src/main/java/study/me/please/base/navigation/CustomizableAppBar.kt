package study.me.please.base.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.theme.LocalTheme

/**
 * Custom app bar with options of customization
 * @param title title of the screen/app
 * @param navigationIcon current icon for navigation back/closing or none in case of null
 * @param actions other actions on the right side of the action bar
 * @param onNavigationIconClick event upon clicking on navigation back
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomizableAppBar(
    modifier: Modifier = Modifier,
    title: String? = "Home",
    subtitle: String? = null,
    navigationIcon: Pair<ImageVector, String>? = Icons.Outlined.Home to "",
    actions: @Composable RowScope.() -> Unit = {},
    onNavigationIconClick: () -> Unit = {}
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Column(verticalArrangement = Arrangement.Center) {
                AnimatedVisibility(visible = title != null) {
                    Text(
                        modifier = Modifier
                            .wrapContentHeight()
                            .offset {
                                IntOffset(0, if(subtitle != null) 14.sp.value.toInt() else 0)
                            },
                        text = title ?: "",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        color = LocalTheme.colors.tetrial,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                }
                AnimatedVisibility(visible = subtitle != null) {
                    Text(
                        modifier = Modifier.wrapContentHeight(),
                        text = subtitle ?: "",
                        fontSize = 14.sp,
                        color = LocalTheme.colors.tetrial,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                }
            }
        },
        navigationIcon = {
            navigationIcon?.let { navigationIcon ->
                Icon(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(48.dp)
                        .clip(LocalTheme.shapes.rectangularActionShape)
                        .clickable(
                            indication = rememberRipple(
                                bounded = true,
                                color = LocalTheme.colors.contrastActionLight
                            ),
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onNavigationIconClick()
                        }
                        .padding(8.dp),
                    imageVector = navigationIcon.first,
                    contentDescription = navigationIcon.second,
                    tint = LocalTheme.colors.tetrial
                )
            }
        },
        actions = {
            actions(this)
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = LocalTheme.colors.brandMain,
            scrolledContainerColor = LocalTheme.colors.brandMain,
            navigationIconContentColor = LocalTheme.colors.tetrial,
            titleContentColor = LocalTheme.colors.tetrial,
            actionIconContentColor = LocalTheme.colors.tetrial
        )
    )
}



@Preview
@Composable
private fun Preview() {
    CustomizableAppBar(
        actions = {
            DefaultAppBarActions()
        },
        subtitle = "subtitle",
        title = "title"
    )
}