package com.hdaf.testtasksuperheroapp.feature_superhero.presentation.navgraph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hdaf.testtasksuperheroapp.feature_superhero.presentation.superhero_info.SuperheroInfoScreen
import com.hdaf.testtasksuperheroapp.feature_superhero.presentation.superhero_list.SuperheroListScreen

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        startDestination = Route.SuperheroListScreen.route,
        navController = navController
    ) {
        composable(
            route = Route.SuperheroListScreen.route
        ) {
            SuperheroListScreen(
                onItemClick = { superhero ->
                    navController.navigate(Route.SuperheroInfoScreen.route + "/${superhero.superheroId}")
                },
                onNavigationIconClick = { }
            )
        }
        composable(
            route = Route.SuperheroInfoScreen.route + "/{superheroId}"
        ) {
            SuperheroInfoScreen(
                modifier = Modifier.fillMaxSize(),
                onNavigationIconClick = {
                    navController.navigateUp()
                }
            )
        }
    }
}