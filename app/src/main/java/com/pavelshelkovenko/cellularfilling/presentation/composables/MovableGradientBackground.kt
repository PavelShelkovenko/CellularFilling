package com.pavelshelkovenko.cellularfilling.presentation.composables

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.pavelshelkovenko.cellularfilling.presentation.theme.DarkPurple

@Composable
fun MovableGradientBackground(modifier: Modifier = Modifier) {

    val infiniteTransition = rememberInfiniteTransition(label = "background")
    val targetOffset = with(LocalDensity.current) { 1000.dp.toPx() }
    val offset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = targetOffset,
        animationSpec = infiniteRepeatable(
            tween(25000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "offset"
    )

    Box(
        modifier = modifier
            .animatedGradientBackground(
                offset = offset,
                colors = listOf(
                    DarkPurple,
                    Color.Black
                )
            )
    )
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
