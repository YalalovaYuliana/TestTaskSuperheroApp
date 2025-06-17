package com.hdaf.testtasksuperheroapp.feature_superhero.domain.use_case

import com.hdaf.testtasksuperheroapp.feature_superhero.domain.repository.SuperheroRepository

class UpdateFavouriteStatusUseCase(
    private val superheroRepository: SuperheroRepository
) {
    suspend operator fun invoke(superheroId: Int, isFavourite: Boolean) {
        superheroRepository.updateFavoriteStatus(
            superheroId = superheroId,
            isFavourite = isFavourite
        )
    }
}