package com.pavelshelkovenko.cellularfilling.presentation

import androidx.lifecycle.ViewModel
import com.pavelshelkovenko.cellularfilling.data.CellTypeGenerator
import com.pavelshelkovenko.cellularfilling.presentation.model.CellItem
import com.pavelshelkovenko.cellularfilling.presentation.model.CellTypeUi
import com.pavelshelkovenko.cellularfilling.presentation.model.mapToCellTypeUi
import kotlinx.coroutines.flow.MutableStateFlow

class CellularViewModel : ViewModel() {

    var screenState = MutableStateFlow(ScreenState())
        private set

    fun onEvent(event: ScreenEvent) {
        when (event) {
            ScreenEvent.AddCell -> {
                addCell()
            }
        }
    }

    private fun addCell() {
        val newCellList = screenState.value.cellsList.toMutableList()
        val newCellItem = CellItem.createFromType(CellTypeGenerator.generate().mapToCellTypeUi())
        newCellList.add(newCellItem)
        if (shouldKillLife(newCellItem.type)) {
            newCellList[newCellList.size - 4] = CellItem.createFromType(CellTypeUi.DEAD)
        }
        if (shouldAddLife(newCellItem.type)) {
            newCellList.add(CellItem.createFromType(CellTypeUi.LIFE))
        }
        screenState.value = screenState.value.copy(
            cellsList = newCellList
        )
    }

    private fun shouldAddLife(newCellType: CellTypeUi): Boolean {
        val cellList = screenState.value.cellsList
        if (cellList.size <= 1) return false
        return (newCellType == CellTypeUi.ALIVE
                && cellList[cellList.size - 1].type == CellTypeUi.ALIVE
                && cellList[cellList.size - 2].type == CellTypeUi.ALIVE)
    }

    private fun shouldKillLife(newCellType: CellTypeUi): Boolean {
        val cellList = screenState.value.cellsList
        if (cellList.size <= 2) return false
        return (newCellType == CellTypeUi.DEAD
                && cellList[cellList.size - 1].type == CellTypeUi.DEAD
                && cellList[cellList.size - 2].type == CellTypeUi.DEAD
                && cellList[cellList.size - 3].type == CellTypeUi.LIFE)
    }
}

