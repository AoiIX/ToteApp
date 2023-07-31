package com.eddwar.tote.presentation.groseries

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.eddwar.tote.core.Constants.Companion.GROSERIES_SCREEN
import com.eddwar.tote.presentation.groseries.components.AddGroseryAlertDialog
import com.eddwar.tote.presentation.groseries.components.GroseriesContent
import com.eddwar.tote.presentation.groseries.components.AddGroseryFloatingActionButton

@Composable
fun GroseriesScreen(
    viewModel: GroseriesViewModel = hiltViewModel(),
    navigateToUpdateGroseryScreen: (groseryId: Int) -> Unit
){
    val groseries by viewModel.groseries.collectAsState(
        initial = emptyList() )
    Scaffold(
        topBar ={
            TopAppBar(title = {
                Text(GROSERIES_SCREEN)
            })
        },
        content = {
                padding->
            GroseriesContent(
                padding = padding,
                groseries = groseries,
                deleteGrosery = {
                        grosery ->
                    viewModel.deleteGrosery(grosery)
                },
                navigateToUpdateGroseryScreen =
                navigateToUpdateGroseryScreen
            )
            AddGroseryAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog()
                },
                addGrosery = {grosery->
                    viewModel.addGrosery(grosery)
                }
            )
        },
        floatingActionButton = {
            AddGroseryFloatingActionButton(
                openDialog = {
                    viewModel.openDialog()
                }
            )
        }
    )
}