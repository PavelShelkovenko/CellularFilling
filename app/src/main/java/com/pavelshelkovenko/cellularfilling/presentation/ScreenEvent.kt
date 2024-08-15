package com.pavelshelkovenko.cellularfilling.presentation

sealed interface ScreenEvent {

    data object AddCell: ScreenEvent
}