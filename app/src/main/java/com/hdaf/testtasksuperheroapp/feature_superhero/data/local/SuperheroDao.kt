package com.hdaf.testtasksuperheroapp.feature_superhero.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hdaf.testtasksuperheroapp.feature_superhero.data.local.entity.SuperheroEntity

@Dao
interface SuperheroDao {

    @Query("SELECT * FROM superheroentity")
    fun getAllSuperHeroes(): List<SuperheroEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSuperheros(
        superheroes: List<SuperheroEntity>
    )

    @Query("DELETE FROM superheroentity")
    suspend fun deleteAllSuperheros()

    //    @Query("SELECT * FROM superheroentity WHERE superheroId = :superheroId")
//    suspend fun getSuperheroById(superheroId: Int): SuperheroEntity

    @Query("SELECT * FROM superheroentity WHERE publisher = :publisher")
    suspend fun getSuperheroesByPublisher(publisher: String): List<SuperheroEntity>

    @Query("UPDATE superheroentity SET isFavourite = :isFavourite WHERE superheroId = :superheroId")
    suspend fun updateFavoriteStatus(superheroId: Int, isFavourite: Boolean)

    @Query("SELECT DISTINCT publisher FROM superheroentity")
    suspend fun getAllPublishers(): List<String>
}