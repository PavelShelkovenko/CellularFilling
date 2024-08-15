package com.pavelshelkovenko.cellularfilling.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pavelshelkovenko.cellularfilling.R
import com.pavelshelkovenko.cellularfilling.presentation.model.CellTypeUi
import com.pavelshelkovenko.cellularfilling.presentation.theme.CellularFillingTheme
import com.pavelshelkovenko.cellularfilling.presentation.theme.White

@Composable
fun CellCard(
    cellTypeUi: CellTypeUi,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(12.dp))
            .background(White)
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(brush = cellTypeUi.backgroundBrush),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = cellTypeUi.iconResId),
                modifier = Modifier.size(21.dp),
                contentDescription = stringResource(R.string.cell_type_icon)
            )
        }
        Spacer(modifier = modifier.width(16.dp))
        Column {
            Text(
                text = stringResource(id = cellTypeUi.title)  ,
                color = MaterialTheme.colorScheme.onSecondary,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = stringResource(id = cellTypeUi.description),
                color = MaterialTheme.colorScheme.onSecondary,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
fun PreviewCellCard() {
    CellularFillingTheme {
        CellCard(cellTypeUi = CellTypeUi.ALIVE)
    }
}