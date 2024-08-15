package com.pavelshelkovenko.cellularfilling.data

import com.pavelshelkovenko.cellularfilling.domain.CellType

object CellTypeGenerator {

    fun generate(): CellType = CellType.entries.shuffled().first()
}