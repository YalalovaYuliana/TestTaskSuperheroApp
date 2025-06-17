package com.hdaf.testtasksuperheroapp.feature_superhero.domain.repository

import com.hdaf.testtasksuperheroapp.core.util.Resource
import com.hdaf.testtasksuperheroapp.feature_superhero.domain.model.Superhero
import kotlinx.coroutines.flow.Flow

interface SuperheroRepository {

    fun getAllSuperheroes(): Flow<Resource<List<Superhero>>>
    fun getSuperheroesByPublisher(publisher: String): Flow<Resource<List<Superhero>>>
    suspend fun updateFavoriteStatus(superheroId: Int, isFavourite: Boolean)
}