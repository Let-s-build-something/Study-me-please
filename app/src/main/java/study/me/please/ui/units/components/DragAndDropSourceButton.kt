package study.me.please.ui.units.components

import android.content.ClipData
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draganddrop.DragAndDropTransferData
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squadris.squadris.compose.theme.LocalTheme
import com.squadris.squadris.ext.scalingDragSource
import study.me.please.data.io.FactIO
import study.me.please.data.io.UnitElement
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.ui.units.utils.ParagraphBlockBridge
import study.me.please.ui.units.UnitViewModel
import study.me.please.ui.units.utils.ElementType

/**
 * Button for drag and drop source - meaning it can be dragged and dropped,
 * it also can be simply clicked
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DragAndDropSourceButton(
    modifier: Modifier = Modifier,
    viewModel: UnitViewModel,
    imageVector: ImageVector,
    text: String = "",
    contentDescription: String,
    bridge: ParagraphBlockBridge,
    elementType: ElementType
) {
    Box(
        modifier = modifier
            .scalingDragSource(
                onLongPress = {
                    viewModel.localStateElement.value = (if(elementType == ElementType.PARAGRAPH) {
                        UnitElement.Paragraph(data = ParagraphIO())
                    }else {
                        UnitElement.Fact(data = FactIO())
                    }) to -1
                    this.startTransfer(
                        DragAndDropTransferData(
                            ClipData(
                                "",
                                // restrict to this type + paragraph, which is always supported
                                arrayOf(elementType.name, ElementType.PARAGRAPH.name),
                                ClipData.Item("")
                            )
                        )
                    )
                },
                onTap = {
                    viewModel.localStateElement.value = (if(elementType == ElementType.PARAGRAPH) {
                        UnitElement.Paragraph(data = ParagraphIO())
                    }else {
                        UnitElement.Fact(data = FactIO())
                    }) to -1
                    bridge.addNewElement()
                }
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = LocalTheme.current.colors.tetrial,
                    shape = FloatingActionButtonDefaults.shape
                )
                .shadow(
                    elevation = LocalTheme.current.styles.actionElevation,
                    shape = FloatingActionButtonDefaults.shape
                ),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                if(text.isNotBlank()) {
                    Text(
                        modifier = Modifier.padding(end = 4.dp),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = LocalTheme.current.colors.brandMainDark
                        ),
                        text = text.uppercase()
                    )
                }
                Icon(
                    modifier = Modifier.size(32.dp),
                    imageVector = imageVector,
                    tint = LocalTheme.current.colors.brandMainDark,
                    contentDescription = contentDescription
                )
            }
        }
    }
}