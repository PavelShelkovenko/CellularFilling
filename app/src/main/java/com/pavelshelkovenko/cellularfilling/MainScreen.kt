package com.pavelshelkovenko.cellularfilling

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.pavelshelkovenko.cellularfilling.composables.Header


@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Header(
            text = stringResource(R.string.cellular_filling),
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
        )
    }
}