package com.hdaf.testtasksuperheroapp.feature_superhero.domain.use_case

import com.hdaf.testtasksuperheroapp.core.util.Resource
import com.hdaf.testtasksuperheroapp.feature_superhero.domain.repository.SuperheroRepository
import kotlinx.coroutines.flow.Flow

class GetAllPublishersUseCase(
    private val superheroRepository: SuperheroRepository
) {
    operator fun invoke(): Flow<Resource<List<String>>> {
        return superheroRepository.getAllPublishers()
    }
}