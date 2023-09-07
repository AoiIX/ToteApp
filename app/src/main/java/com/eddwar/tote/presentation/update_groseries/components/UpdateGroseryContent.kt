package com.eddwar.tote.presentation.update_groseries.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.eddwar.tote.core.Constants.Companion.AMOUNT
import com.eddwar.tote.core.Constants.Companion.MEASURE
import com.eddwar.tote.core.Constants.Companion.NAME
import com.eddwar.tote.core.Constants.Companion.UPDATE
import com.eddwar.tote.domain.model.Grosery

@Composable
fun UpdateGroseryContent(
    padding: PaddingValues,
    grosery: Grosery,
    updateGrosery: (grosery: Grosery) -> Unit,
    updateName: (name: String) -> Unit,
    updateAmount: (amount: String) -> Unit,
    updateMeasure: (measure: String) -> Unit,
    navigateBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        TextField(
            value = grosery.name,
            onValueChange = {name->
                updateName(name)
            },
            maxLines = 1,
            placeholder = {
                Text(NAME)
            }
        )
        Spacer(modifier = Modifier
            .height(8.dp))
        TextField(
            value = grosery.amount,
            onValueChange = {amount->
                updateAmount(amount)
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Number
            ),
            maxLines = 1,
            placeholder = {
                Text(AMOUNT)
            }
        )
        TextField(
            value = grosery.measure,
            onValueChange = {measure->
                updateMeasure(measure)
            },
            maxLines = 1,
            placeholder = {
                Text(MEASURE)
            }
        )
        Button(
            onClick = {
                updateGrosery(grosery)
                navigateBack()
            }
        ){
            Text(UPDATE)
        }
    }
}