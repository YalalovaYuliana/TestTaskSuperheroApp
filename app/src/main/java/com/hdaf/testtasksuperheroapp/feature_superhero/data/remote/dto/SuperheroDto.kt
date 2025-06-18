package com.hdaf.testtasksuperheroapp.feature_superhero.data.remote.dto

import com.hdaf.testtasksuperheroapp.feature_superhero.data.local.entity.SuperheroEntity

data class SuperheroDto(
    val appearance: AppearanceDto?,
    val biography: BiographyDto?,
    val connections: ConnectionsDto?,
    val id: Int?,
    val images: ImagesDto?,
    val name: String?,
    val powerstats: PowerstatsDto?,
    val slug: String?,
    val work: WorkDto?
) {
    fun toSuperheroEntity(): SuperheroEntity = SuperheroEntity(
        superheroId = id ?: 0,
        alias = name ?: "-",
        realName = biography?.fullName ?: "-",
        occupation = work?.occupation ?: "-",
        gender = appearance?.gender ?: "-",
        race = appearance?.race ?: "-",
        firstAppearance = biography?.firstAppearance ?: "-",
        alignment = biography?.alignment ?: "-",
        publisher = biography?.publisher ?: "-",
        imageUrl = images?.lg ?: "-",
        isFavourite = false
    )
}