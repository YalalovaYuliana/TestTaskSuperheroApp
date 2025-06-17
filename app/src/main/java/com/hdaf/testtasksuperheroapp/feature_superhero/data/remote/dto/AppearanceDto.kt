package com.hdaf.testtasksuperheroapp.feature_superhero.data.remote.dto

data class AppearanceDto(
    val eyeColor: String,
    val gender: String,
    val hairColor: String,
    val height: List<String>,
    val race: String,
    val weight: List<String>
)