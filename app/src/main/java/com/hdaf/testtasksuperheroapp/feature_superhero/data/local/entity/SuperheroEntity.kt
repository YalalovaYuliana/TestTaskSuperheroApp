package com.hdaf.testtasksuperheroapp.feature_superhero.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hdaf.testtasksuperheroapp.feature_superhero.domain.model.Superhero

@Entity
data class SuperheroEntity(
    @PrimaryKey val superheroId: Int? = null,
    val alias: String,
    val realName: String,
    val occupation: String,
    val gender: String,
    val race: String,
    val firstAppearance: String,
    val alignment: String,
    val publisher: String,
    val imageUrl: String,
    var isFavourite: Boolean = false
) {
    fun toSuperhero(): Superhero {
        return Superhero(
            superheroId = superheroId ?: 0,
            alias = alias,
            realName = realName,
            occupation = occupation,
            gender = gender,
            race = race,
            firstAppearance = firstAppearance,
            alignment = alignment,
            publisher = publisher,
            imageUrl = imageUrl
        )
    }
}