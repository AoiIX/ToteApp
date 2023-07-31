package com.eddwar.tote.presentation.groseries.components
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import com.eddwar.tote.core.Constants.Companion.ADD
import com.eddwar.tote.core.Constants.Companion.ADD_GROSERY
import com.eddwar.tote.core.Constants.Companion.NAME
import com.eddwar.tote.core.Constants.Companion.AMOUNT
import com.eddwar.tote.core.Constants.Companion.MEASURE
import com.eddwar.tote.core.Constants.Companion.DISMISS
import com.eddwar.tote.core.Constants.Companion.NO_VALUE
import com.eddwar.tote.domain.model.Grosery
import kotlinx.coroutines.job

@Composable
fun AddGroseryAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addGrosery: (grosery: Grosery) -> Unit
){
    if (openDialog){
        var name by remember { mutableStateOf(NO_VALUE)}
        var amount by remember { mutableStateOf(NO_VALUE)}
        var measure by remember { mutableStateOf(NO_VALUE)}
        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = { closeDialog },
            title = {
                Text(ADD_GROSERY)
            },
            text = {
                Column() {
                    TextField(
                        value = name,
                        onValueChange = {name = it},
                        placeholder = {
                            Text(NAME)
                        },
                        modifier = Modifier.focusRequester(focusRequester)
                    )
                    LaunchedEffect(Unit){
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = amount,
                        onValueChange = {amount = it},
                        placeholder = {
                            Text(AMOUNT)
                        }
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        val grosery = Grosery(0, name, amount, measure)
                        addGrosery(grosery)
                    }) {
                    Text(ADD)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog) {
                    Text(DISMISS)
                }
            }

        )
    }
}