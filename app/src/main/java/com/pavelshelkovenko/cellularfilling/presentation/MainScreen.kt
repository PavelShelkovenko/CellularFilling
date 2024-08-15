package com.pavelshelkovenko.cellularfilling.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pavelshelkovenko.cellularfilling.R
import com.pavelshelkovenko.cellularfilling.presentation.composables.CellCard
import com.pavelshelkovenko.cellularfilling.presentation.composables.MovableGradientBackground
import com.pavelshelkovenko.cellularfilling.presentation.theme.CellularFillingTheme
import com.pavelshelkovenko.cellularfilling.presentation.utils.isScrolledToTheEnd

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
) {
    val viewModel = viewModel<CellularViewModel>()
    val state = viewModel.screenState.collectAsState()
    val lazyListState: LazyListState = rememberLazyListState()

    MovableGradientBackground(modifier = modifier)

    LaunchedEffect(state.value.cellsList.size) {
        if (!lazyListState.isScrolledToTheEnd()) {
            val itmIndex = lazyListState.layoutInfo.totalItemsCount - 1
            if (itmIndex >= 0) {
                val lastItem = lazyListState.layoutInfo.visibleItemsInfo.lastOrNull()
                lastItem?.let {
                    lazyListState.animateScrollToItem(itmIndex, it.size + it.offset)
                }
            }
        }
    }

    Column(
        modifier = modifier
            .padding(innerPadding)
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
            state = lazyListState,
            verticalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues(
                horizontal = 16.dp,
                vertical = 6.dp,
            ),
            modifier = Modifier.fillMaxHeight(0.9f)
        ) {
            items(
                items = state.value.cellsList,
                key = { cell -> cell.id }
            ) { cell ->
                CellCard(
                    cellTypeUi = cell.type,
                    modifier = Modifier
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                viewModel.onEvent(ScreenEvent.AddCell)
            },
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

@Preview
@Composable
fun PreviewMainScreen() {
    CellularFillingTheme {
        MainScreen(innerPadding = PaddingValues(16.dp))
    }
}





