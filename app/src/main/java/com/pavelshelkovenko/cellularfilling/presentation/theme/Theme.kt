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
    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun CellularFillingTheme(
    content: @Composable () -> Unit
) {
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
            color = Purple
        )
        setNavigationBarColor(
            color = Color.Transparent
        )
    }
}