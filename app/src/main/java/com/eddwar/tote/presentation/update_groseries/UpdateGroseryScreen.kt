package com.eddwar.tote.presentation.update_groseries

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.eddwar.tote.presentation.groseries.GroseriesViewModel
import com.eddwar.tote.presentation.update_groseries.components.UpdateGroseryContent
import com.eddwar.tote.presentation.update_groseries.components.UpdateGroseryTopBar

@Composable
fun UpdateGroseryScreen(
    viewModel: GroseriesViewModel = hiltViewModel(),
    groseryId: Int,
    navigateBack: () -> Unit
){
    LaunchedEffect(Unit){
        viewModel.getGrosery(groseryId)
    }
    Scaffold(
        topBar = {
            UpdateGroseryTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdateGroseryContent(
                padding = padding,
                grosery = viewModel.grosery,
                updateName = { name->
                    viewModel.updateName(name)
                },
                updateAmount = {amount->
                    viewModel.updateAmount(amount)
                },
                updateMeasure = {measure ->
                    viewModel.updateMeasure(measure)
                },
                updateGrosery = {grosery ->
                    viewModel.updateGrosery(grosery)
                },
                navigateBack = navigateBack
            )
        }
    )
}