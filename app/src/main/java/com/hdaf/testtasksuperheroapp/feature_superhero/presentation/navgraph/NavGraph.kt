package com.hdaf.testtasksuperheroapp.feature_superhero.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
                }
            )
        }
    }
}