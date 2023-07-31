package com.eddwar.tote.presentation.groseries.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import com.eddwar.tote.core.Constants.Companion.ADD_GROSERY

@Composable
fun AddGroseryFloatingActionButton(
    openDialog: () -> Unit
){
    FloatingActionButton(
        onClick =  openDialog ,
        backgroundColor = MaterialTheme.colors.primary
        ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = ADD_GROSERY
        )
    }
}