package com.fggc.groserycrud.presentation.groseries.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import com.eddwar.tote.core.Constants.Companion.DELETE_GROSERY

@Composable
fun DeleteIcon(
    deleteGrosery: () -> Unit
){
    IconButton(onClick =  deleteGrosery ) {
        Icon(imageVector = Icons.Default.Delete,
            contentDescription = DELETE_GROSERY)
    }
}