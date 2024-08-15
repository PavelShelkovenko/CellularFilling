package com.pavelshelkovenko.cellularfilling.presentation.utils

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import com.pavelshelkovenko.cellularfilling.domain.CellType
import com.pavelshelkovenko.cellularfilling.presentation.model.CellTypeUi

fun LazyListState.isScrolledToTheEnd(): Boolean {
    val lastItem = layoutInfo.visibleItemsInfo.lastOrNull()
    return lastItem == null || lastItem.size + lastItem.offset <= layoutInfo.viewportEndOffset
}

fun Modifier.animatedGradientBackground(
    offset: Float,
    colors: List<Color>
): Modifier {
    return this.drawWithCache {
        val brushSize = 600f
        val brush = Brush.linearGradient(
            colors = colors,
            start = Offset(offset, offset),
            end = Offset(
                offset + brushSize,
                offset + brushSize
            ),
            tileMode = TileMode.Mirror
        )
        onDrawBehind {
            drawRect(brush)
        }
    }
}

fun CellType.mapToCellTypeUi(): CellTypeUi {
    return when(this) {
        CellType.ALIVE -> CellTypeUi.ALIVE
        CellType.DEAD -> CellTypeUi.DEAD
    }
}