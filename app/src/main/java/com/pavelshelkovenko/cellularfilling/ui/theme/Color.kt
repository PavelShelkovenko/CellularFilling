package com.pavelshelkovenko.cellularfilling.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color


val Primary = Color(0xFF5A3472)
val OnPrimary = Color(0xFFFFFFFF)
val SystemColor = Color(0xFF6650a4)

val BackgroundColorBrush = Brush.verticalGradient(
    colors = listOf(
        Primary,
        Color.Black
    )
)