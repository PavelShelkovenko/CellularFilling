package com.pavelshelkovenko.cellularfilling

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.pavelshelkovenko.cellularfilling.ui.theme.BackgroundColorBrush
import com.pavelshelkovenko.cellularfilling.ui.theme.CellularFillingTheme
import com.pavelshelkovenko.cellularfilling.ui.theme.TransparentSystemBars

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TransparentSystemBars()
            CellularFillingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(brush = BackgroundColorBrush)
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}
