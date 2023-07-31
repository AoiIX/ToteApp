package com.eddwar.tote.presentation.groseries.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.eddwar.tote.domain.model.Grosery
import com.eddwar.tote.domain.repository.Groseries

@Composable
fun GroseriesContent(
    padding: PaddingValues,
    groseries: Groseries,
    deleteGrosery: (grosery:Grosery) -> Unit,
    navigateToUpdateGroseryScreen: (groseryId: Int) -> Unit
){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ){
        items(groseries){
                grosery->
            GroseryCard(
                grosery = grosery,
                deleteGrosery = {
                    deleteGrosery(grosery)
                },
                navigateToUpdateGroseryScreen =
                navigateToUpdateGroseryScreen
            )
        }
    }
}