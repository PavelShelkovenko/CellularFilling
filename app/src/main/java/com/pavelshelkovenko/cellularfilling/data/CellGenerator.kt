package com.pavelshelkovenko.cellularfilling.data

import com.pavelshelkovenko.cellularfilling.domain.CellType

object CellGenerator {

    fun generate(): CellType = CellType.entries.shuffled().first()
}