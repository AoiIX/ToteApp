package com.eddwar.tote.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.eddwar.tote.presentation.groseries.GroseriesScreen

@Composable
fun NavGraph(navController: NavHostController){
    NavHost(navController = navController,
        startDestination = Screen.GroseriesScreen.route){
        composable(
            route = Screen.GroseriesScreen.route
        ){
            GroseriesScreen()
        }
    }
}