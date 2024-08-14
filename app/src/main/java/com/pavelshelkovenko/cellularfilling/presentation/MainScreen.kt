package com.pavelshelkovenko.cellularfilling.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pavelshelkovenko.cellularfilling.R
import com.pavelshelkovenko.cellularfilling.presentation.composables.CellCard
import com.pavelshelkovenko.cellularfilling.presentation.model.CellTypeUi


@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    val testList = listOf(CellTypeUi.ALIVE, CellTypeUi.DEATH, CellTypeUi.DEAD, CellTypeUi.LIFE)
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.header_title),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.displayLarge,
            textAlign = TextAlign.Center,
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp)
        ) {
            items(
                items = testList,
                key = { it.id }
            ) {
                CellCard(cellTypeUi = it)
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(4.dp)
        ) {
            Text(
                text = stringResource(R.string.create_button_title).uppercase(),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}