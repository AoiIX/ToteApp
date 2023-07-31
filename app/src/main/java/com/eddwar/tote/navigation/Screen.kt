package com.eddwar.tote.navigation

import com.eddwar.tote.core.Constants.Companion.GROSERIES_SCREEN
import com.eddwar.tote.core.Constants.Companion.UPDATE_GROSERIES_SCREEN

sealed class Screen(val route: String){
    object GroseriesScreen: Screen(GROSERIES_SCREEN)
    object UpdateGroseryScreen: Screen(UPDATE_GROSERIES_SCREEN)
}
