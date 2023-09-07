package com.eddwar.tote.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.eddwar.tote.core.Constants.Companion.GROSERY_ID
import com.eddwar.tote.presentation.groseries.GroseriesScreen
import com.eddwar.tote.presentation.update_groseries.UpdateGroseryScreen

@Composable
fun NavGraph(
    navController: NavHostController
){
    NavHost(navController = navController,
        startDestination =  Screen.GroseriesScreen.route ){
        composable(
            route = Screen.GroseriesScreen.route
        ){
            GroseriesScreen(
                navigateToUpdateGroseryScreen = { groseryId ->
                    navController.navigate(
                        "${Screen.UpdateGroseryScreen.route}/${groseryId}"
                    )
                }
            )
        }
        composable(
            route = "${Screen.UpdateGroseryScreen.route}/{$GROSERY_ID}",
            arguments = listOf(
                navArgument(GROSERY_ID){
                    type = NavType.IntType
                }
            )
        ){
                backStackEntry ->
            val groseryId = backStackEntry.arguments?.getInt(GROSERY_ID) ?:0
            UpdateGroseryScreen(
                groseryId = groseryId,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}