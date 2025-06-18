package com.hdaf.testtasksuperheroapp.feature_superhero.presentation.superhero_info

import com.hdaf.testtasksuperheroapp.feature_superhero.domain.model.Superhero

data class SuperheroInfoState(
    val superhero: Superhero? = null,
    val isLoading: Boolean = false,
    val error: String = ""
)