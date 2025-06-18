package com.hdaf.testtasksuperheroapp.feature_superhero.data.remote

import com.hdaf.testtasksuperheroapp.feature_superhero.data.remote.dto.SuperheroDto
import retrofit2.http.GET

interface SuperheroApi {

    @GET("/all.json")
    suspend fun getAllSuperheroes(): List<SuperheroDto>
}