package com.pavelshelkovenko.cellularfilling.presentation.model

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Brush
import com.pavelshelkovenko.cellularfilling.R
import com.pavelshelkovenko.cellularfilling.presentation.theme.AliveCellColorBrush
import com.pavelshelkovenko.cellularfilling.presentation.theme.DeadCellColorBrush
import com.pavelshelkovenko.cellularfilling.presentation.theme.LifeCellColorBrush
import java.util.UUID

enum class CellTypeUi(
    val id: Int,
    @StringRes val title: Int,
    @StringRes val description: Int,
    val backgroundBrush: Brush,
    val iconResId: Int,
) {
    ALIVE(
        id = UUID.randomUUID().clockSequence(),
        title = R.string.alive_title,
        description = R.string.alive_description,
        backgroundBrush = AliveCellColorBrush,
        iconResId = R.drawable.ic_alive
    ),
    DEAD(
        id = UUID.randomUUID().clockSequence(),
        title = R.string.dead_title,
        description = R.string.dead_description,
        backgroundBrush = DeadCellColorBrush,
        iconResId = R.drawable.ic_dead
    ),
    LIFE(
        id = UUID.randomUUID().clockSequence(),
        title = R.string.life_title,
        description = R.string.life_description,
        backgroundBrush = LifeCellColorBrush,
        iconResId = R.drawable.ic_life
    ),
    DEATH(
        id = UUID.randomUUID().clockSequence(),
        title = R.string.death_title,
        description = R.string.death_description,
        backgroundBrush = DeadCellColorBrush,
        iconResId = R.drawable.ic_dead
    ),
}
