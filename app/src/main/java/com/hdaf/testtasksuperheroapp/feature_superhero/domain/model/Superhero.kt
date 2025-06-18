package com.hdaf.testtasksuperheroapp.feature_superhero.domain.model

data class Superhero(
    val superheroId: Int,
    val alias: String,
    val realName: String,
    val occupation: String,
    val gender: String,
    val race: String,
    val firstAppearance: String,
    val alignment: String,
    val publisher: String,
    val imageUrl: String,
    val isFavourite: Boolean = false
)
