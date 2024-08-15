package com.pavelshelkovenko.cellularfilling.presentation

import com.pavelshelkovenko.cellularfilling.presentation.model.CellItem

data class ScreenState(
    val cellsList: List<CellItem> = emptyList(),
)