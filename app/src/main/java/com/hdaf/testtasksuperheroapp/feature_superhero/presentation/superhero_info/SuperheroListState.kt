package com.hdaf.testtasksuperheroapp.feature_superhero.presentation.superhero_info

import com.hdaf.testtasksuperheroapp.feature_superhero.domain.model.Superhero

data class SuperheroListState(
    val superheroItems: List<Superhero> = emptyList(),
    val publishers: List<String> = emptyList(),
    val isLoading: Boolean = false
)