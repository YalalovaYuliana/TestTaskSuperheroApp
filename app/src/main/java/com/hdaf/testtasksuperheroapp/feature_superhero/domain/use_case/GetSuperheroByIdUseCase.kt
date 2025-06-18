package com.hdaf.testtasksuperheroapp.feature_superhero.domain.use_case

import com.hdaf.testtasksuperheroapp.core.util.Resource
import com.hdaf.testtasksuperheroapp.feature_superhero.domain.model.Superhero
import com.hdaf.testtasksuperheroapp.feature_superhero.domain.repository.SuperheroRepository
import kotlinx.coroutines.flow.Flow

class GetSuperheroByIdUseCase(
    private val superheroRepository: SuperheroRepository
) {

    operator fun invoke(superheroId: Int): Flow<Resource<Superhero>> {
        return superheroRepository.getSuperheroById(superheroId)
    }
}