package com.pavelshelkovenko.cellularfilling.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.pavelshelkovenko.cellularfilling.presentation.theme.CellularFillingTheme
import com.pavelshelkovenko.cellularfilling.presentation.theme.SystemBarColors

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SystemBarColors()
            CellularFillingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier
                            .fillMaxSize(),
                        innerPadding = innerPadding,
                    )
                }
            }
        }
    }
}
