package com.pavelshelkovenko.cellularfilling.presentation.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val DeadCellColorBrush = Brush.verticalGradient(
    colors = listOf(
        Color(0xFF0D658A),
        Color(0XFFB0FFB4)
    )
)

val AliveCellColorBrush = Brush.verticalGradient(
    colors = listOf(
        Color(0xFFFFB800),
        Color(0XFFFFF7B0)
    )
)

val LifeCellColorBrush = Brush.verticalGradient(
    colors = listOf(
        Color(0xFFAD00FF),
        Color(0XFFFFB0E9)
    )
)