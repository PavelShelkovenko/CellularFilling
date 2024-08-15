package com.pavelshelkovenko.cellularfilling.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val AppColorScheme = lightColorScheme(
    primary = Purple,
    onPrimary = White,
    onSecondary = Color.Black,
)

@Composable
fun CellularFillingTheme(
    content: @Composable () -> Unit
) {
    SystemBarColors()
    MaterialTheme(
        colorScheme = AppColorScheme,
        typography = AppTypography,
        content = content
    )
}

@Composable
fun SystemBarColors() {
    val systemUiController = rememberSystemUiController()
    systemUiController.apply {
        setSystemBarsColor(
            color = Color.Transparent
        )
        setNavigationBarColor(
            color = Color.Transparent
        )
    }
}