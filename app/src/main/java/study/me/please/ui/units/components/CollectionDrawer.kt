package study.me.please.ui.units.components

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.DeleteSweep
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.squadris.squadris.compose.base.LocalIsTablet
import com.squadris.squadris.compose.components.MinimalisticIcon
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.compose.theme.SharedColors
import study.me.please.R
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.ui.components.BasicAlertDialog
import study.me.please.ui.components.ButtonState
import study.me.please.ui.components.ComponentHeaderButton
import study.me.please.ui.components.EditFieldInput
import study.me.please.ui.components.ExpandableContent
import study.me.please.ui.components.ImageAction
import study.me.please.ui.units.CollectionUnitsViewModel
import study.me.please.ui.units.FocusedUnitElement

/**
 * Drawer embedded within content with slight elevation
 */
@Composable
fun rememberEmbeddedDrawerState(
    defaultValue: Boolean = true
): EmbeddedDrawerState {
    val configuration = LocalConfiguration.current
    val isTablet = LocalIsTablet.current

    val isDrawerExpanded = rememberSaveable(defaultValue) {
        mutableStateOf(defaultValue)
    }
    val drawerWidthDp = configuration.screenWidthDp.times(
        if(isTablet) SCREEN_WIDTH_PART_OVERVIEW_TABLET else SCREEN_WIDTH_PART_OVERVIEW_MOBILE
    )

    val xOffsetDp: Float by animateFloatAsState(
        if(isDrawerExpanded.value) {
            0f
        }else -drawerWidthDp.toFloat(),
        label = ""
    )

    return EmbeddedDrawerState(
        xOffsetDp = xOffsetDp,
        isExpanded = isDrawerExpanded,
        drawerWidth = drawerWidthDp.dp
    )
}

/**
 * Drawer which is embedded within the layout for overview of all paragraphs and units of a collection
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CollectionDrawer(
    modifier: Modifier = Modifier,
    viewModel: CollectionUnitsViewModel,
    onIndexChange: (index: Int) -> Unit,
    state: EmbeddedDrawerState = rememberEmbeddedDrawerState()
) {
    val context = LocalContext.current
    val localFocusManager = LocalFocusManager.current

    val units = viewModel.units.collectAsState(initial = listOf())
    val columnState = rememberLazyListState()

    val showDeleteDialog = remember(viewModel) { mutableStateOf(false) }
    val checkedUnits = remember(viewModel.collectionUid) { mutableStateListOf<String>() }
    val expandedUnits = remember { mutableStateListOf<String>() }

    if(showDeleteDialog.value) {
        val input = remember { mutableStateOf("") }

        BasicAlertDialog(
            title = stringResource(id = R.string.units_delete_dialog_title),
            content = stringResource(
                id = R.string.units_delete_dialog_content,
                checkedUnits.size
            ),
            icon = Icons.Outlined.Delete,
            confirmButtonState = ButtonState(
                text = stringResource(id = R.string.button_confirm),
                enabled = input.value == stringResource(id = R.string.units_delete_dialog_confirm_hint)
            ) {
                viewModel.deleteUnits(checkedUnits.toList())
            },
            dismissButtonState = ButtonState(
                text = stringResource(id = R.string.button_dismiss)
            ),
            extraContent = {
                EditFieldInput(
                    modifier = Modifier.padding(16.dp),
                    value = "",
                    hint = stringResource(R.string.units_delete_dialog_confirm_hint),
                    maxLines = 1
                ) { output ->
                    input.value = output
                }
            },
            onDismissRequest = {
                checkedUnits.clear()
                showDeleteDialog.value = false
            }
        )
    }

    BackHandler(checkedUnits.size > 0) {
        checkedUnits.clear()
    }

    Card(
        modifier = modifier
            .width(state.drawerWidth)
            .fillMaxHeight()
            .offset(
                x = state.xOffsetDp.dp,
                y = 0.dp
            )
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    localFocusManager.clearFocus()
                })
            },
        elevation = LocalTheme.current.styles.cardClickableElevation,
        shape = RectangleShape,//LocalTheme.shapes.componentShape,
        colors = CardDefaults.cardColors(
            containerColor = LocalTheme.current.colors.onBackgroundComponent,
            contentColor = LocalTheme.current.colors.onBackgroundComponent
        )
    ) {
        LazyColumn(
            state = columnState
        ) {
            stickyHeader {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.units_overview),
                        style = LocalTheme.current.styles.subheading
                    )
                    MinimalisticIcon(
                        imageVector = Icons.Outlined.Close,
                        onClick = {
                            state.isExpanded.value = false
                        }
                    )
                }
            }
            item {
                Crossfade(
                    modifier = Modifier
                        .padding(top = 32.dp, start = 8.dp, end = 8.dp)
                        .fillMaxWidth(),
                    targetState = checkedUnits.size > 0,
                    label = ""
                ) { isAnyChecked ->
                    if(isAnyChecked) {
                        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                            ImageAction(
                                modifier = Modifier.fillMaxWidth(),
                                leadingImageVector = Icons.Outlined.DeleteSweep,
                                text = stringResource(id = R.string.button_delete),
                                containerColor = SharedColors.RED_ERROR
                            ) {
                                showDeleteDialog.value = true
                            }
                        }
                    }else {
                        ComponentHeaderButton(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                viewModel.addNewUnit(
                                    collectionUid = viewModel.collectionUid,
                                    prefix = context.getString(R.string.unit_heading_prefix)
                                )
                                onIndexChange(units.value?.size ?: 0)
                                state.isExpanded.value = false
                            },
                            text = stringResource(R.string.units_create_new),
                            textStyle = LocalTheme.current.styles.menuItem.copy(color = LocalTheme.current.colors.secondary)
                        )
                    }
                }
            }
            itemsIndexed(
                units.value.orEmpty()
            ) { index, unit ->
                Row(modifier = Modifier.padding(start = 8.dp)) {
                    AnimatedVisibility(visible = checkedUnits.size > 0) {
                        Checkbox(
                            modifier = Modifier.offset(x = -(12).dp),
                            checked = checkedUnits.contains(unit.uid),
                            onCheckedChange = { isChecked ->
                                checkedUnits.run {
                                    if(isChecked) {
                                        add(unit.uid)
                                    } else {
                                        remove(unit.uid)
                                    }
                                }
                            },
                            colors = LocalTheme.current.styles.checkBoxColorsDefault
                        )
                    }
                    ExpandableContent(
                        modifier = Modifier
                            .fillMaxWidth()
                            .combinedClickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = rememberRipple(),
                                onClick = {
                                    // checking mode vs regular click
                                    if (checkedUnits.size > 0) {
                                        checkedUnits.run {
                                            if (checkedUnits.contains(unit.uid)) {
                                                remove(unit.uid)
                                            } else {
                                                add(unit.uid)
                                            }
                                        }
                                    } else {
                                        onIndexChange(units.value?.indexOf(unit) ?: 0)
                                    }
                                },
                                onLongClick = {
                                    checkedUnits.add(unit.uid)
                                }
                            ),
                        arrowModifier = Modifier.clickable(
                            onClick = {
                                if (expandedUnits.contains(unit.uid)) {
                                    expandedUnits.remove(unit.uid)
                                } else expandedUnits.add(unit.uid)
                            },
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple()
                        ),
                        text = AnnotatedString(
                            unit.name.ifEmpty {
                                stringResource(R.string.unit_heading_default, index + 1)
                            }
                        ),
                        collapsedPadding = 8.dp,
                        isExpanded = expandedUnits.contains(unit.uid)
                    ) {
                        DashboardChildParagraph(
                            paragraphs = unit.paragraphs,
                            openParagraph = { uidPath ->
                                onIndexChange(units.value?.indexOf(unit) ?: 0)
                                viewModel.scrollToElement.value = FocusedUnitElement(
                                    elementPath = uidPath,
                                    unitUid = unit.uid
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun DashboardChildParagraph(
    paragraphs: List<ParagraphIO>,
    openParagraph: (uidPath: MutableList<String>) -> Unit,
    uidPath: MutableList<String> = mutableListOf()
) {
    paragraphs.forEach { nestedParagraph ->
        if(nestedParagraph.paragraphs.isEmpty()) {
            Text(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .fillMaxWidth()
                    .clickable(
                        onClick = {
                            openParagraph(uidPath.apply { add(nestedParagraph.uid) })
                        },
                        interactionSource = remember { MutableInteractionSource() },
                        indication = rememberRipple()
                    )
                    .padding(8.dp),
                text = nestedParagraph.name,
                style = LocalTheme.current.styles.category
            )
        }else {
            val isExpanded = remember(nestedParagraph.uid) {
                mutableStateOf(false)
            }

            ExpandableContent(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .fillMaxWidth()
                    .clickable(
                        onClick = {
                            openParagraph(uidPath.apply { add(nestedParagraph.uid) })
                        },
                        interactionSource = remember(nestedParagraph.uid) { MutableInteractionSource() },
                        indication = rememberRipple()
                    ),
                arrowModifier = Modifier.clickable(
                    onClick = {
                        isExpanded.value = !isExpanded.value
                    },
                    interactionSource = remember(nestedParagraph.uid) { MutableInteractionSource() },
                    indication = rememberRipple()
                ),
                text = AnnotatedString(
                    nestedParagraph.name.ifEmpty { stringResource(R.string.subject_add_paragraph) }
                ),
                collapsedPadding = 8.dp,
                textStyle = LocalTheme.current.styles.category,
                isExpanded = isExpanded.value
            ) {
                DashboardChildParagraph(
                    paragraphs = nestedParagraph.paragraphs,
                    uidPath = uidPath.apply { add(nestedParagraph.uid) },
                    openParagraph = openParagraph
                )
            }
        }
    }
}

/** Drawer embedded within content with slight elevation */
data class EmbeddedDrawerState(

    /** X coordinate offset based on [isExpanded] */
    val xOffsetDp: Float,

    /** whether the drawer is expanded or not */
    val isExpanded: MutableState<Boolean>,

    /** width of the drawer composable */
    val drawerWidth: Dp
)

private const val SCREEN_WIDTH_PART_OVERVIEW_MOBILE = 0.6
private const val SCREEN_WIDTH_PART_OVERVIEW_TABLET = 0.4