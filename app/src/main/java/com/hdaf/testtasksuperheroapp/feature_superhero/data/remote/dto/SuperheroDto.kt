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
        alias = name ?: "unknown",
        realName = biography?.fullName ?: "unknown",
        occupation = work?.occupation ?: "unknown",
        gender = appearance?.gender ?: "unknown",
        race = appearance?.race ?: "unknown",
        firstAppearance = biography?.firstAppearance ?: "unknown",
        alignment = biography?.alignment ?: "unknown",
        publisher = biography?.publisher ?: "unknown",
        imageUrl = images?.md ?: "unknown",
        isFavourite = false
    )
}