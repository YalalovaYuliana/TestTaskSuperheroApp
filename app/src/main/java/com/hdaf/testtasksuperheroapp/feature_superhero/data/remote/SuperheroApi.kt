package com.hdaf.testtasksuperheroapp.feature_superhero.data.remote

import com.hdaf.testtasksuperheroapp.feature_superhero.data.remote.dto.SuperheroDto
import retrofit2.http.GET

interface SuperheroApi {

    @GET("/all.json")
    suspend fun getAllSuperheroes(): List<SuperheroDto>

//    @GET("/id/{superheroId}.json")
//    suspend fun getSuperheroById(@Path("superheroId") superheroId: String): SuperheroDto

    companion object {
        const val BASE_URL = "https://akabab.github.io/superhero-api/api"
    }
}