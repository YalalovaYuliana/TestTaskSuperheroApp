package com.hdaf.testtasksuperheroapp.feature_superhero.presentation.navgraph

sealed class Route(
    val route: String
) {
    object SuperheroListScreen : Route(route = "superheroListScreen")
    object SuperheroInfoScreen : Route(route = "superheroInfoScreen")
}