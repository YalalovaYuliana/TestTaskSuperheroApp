package com.hdaf.testtasksuperheroapp.feature_superhero.data.remote.dto

data class BiographyDto(
    val aliases: List<String>,
    val alignment: String,
    val alterEgos: String,
    val firstAppearance: String,
    val fullName: String,
    val placeOfBirth: String,
    val publisher: String
)