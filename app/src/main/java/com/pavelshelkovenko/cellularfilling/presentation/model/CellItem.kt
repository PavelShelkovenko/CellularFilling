package com.pavelshelkovenko.cellularfilling.presentation.model

import java.util.UUID

class CellItem private constructor(
    val id: String,
    val type: CellTypeUi
) {

    companion object {
        fun createFromType(type: CellTypeUi): CellItem = CellItem(
            id = UUID.randomUUID().toString(),
            type = type
        )
    }
}
