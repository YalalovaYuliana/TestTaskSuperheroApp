package com.hdaf.testtasksuperheroapp.feature_superhero.data.repository

import android.content.Context
import com.hdaf.testtasksuperheroapp.R
import com.hdaf.testtasksuperheroapp.core.util.Resource
import com.hdaf.testtasksuperheroapp.feature_superhero.data.local.SuperheroDao
import com.hdaf.testtasksuperheroapp.feature_superhero.data.remote.SuperheroApi
import com.hdaf.testtasksuperheroapp.feature_superhero.domain.model.Superhero
import com.hdaf.testtasksuperheroapp.feature_superhero.domain.repository.SuperheroRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

class SuperheroRepositoryImpl(
    private val superheroApi: SuperheroApi,
    private val superheroDao: SuperheroDao,
    private val context: Context
) : SuperheroRepository {
    override fun getAllSuperheroes(): Flow<Resource<List<Superhero>>> = flow {
        emit(Resource.Loading())

        val superheroes = superheroDao.getAllSuperHeroes().map { it.toSuperhero() }
        emit(Resource.Loading(data = superheroes))

        try {
            val remoteSuperheroes = superheroApi.getAllSuperheroes()
            superheroDao.deleteAllSuperheros()
            superheroDao.insertSuperheros(remoteSuperheroes.map { it.toSuperheroEntity() })
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = context.getString(R.string.error_something_went_wrong),
                    data = superheroes
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = context.getString(R.string.error_network_connection),
                    data = superheroes
                )
            )
        }

        val newSuperheroes = superheroDao.getAllSuperHeroes().map { it.toSuperhero() }
        emit(Resource.Success(newSuperheroes))
    }

    override fun getSuperheroesByPublisher(publisher: String): Flow<Resource<List<Superhero>>> =
        flow {
            emit(Resource.Loading())
            try {
                val superheroes =
                    superheroDao.getSuperheroesByPublisher(publisher).map { it.toSuperhero() }
                emit(Resource.Success(superheroes))
            } catch (e: Exception) {
                emit(Resource.Error(message = context.getString(R.string.error_something_went_wrong)))
            }
        }

    override suspend fun updateFavoriteStatus(superheroId: Int, isFavourite: Boolean) {
        superheroDao.updateFavoriteStatus(
            superheroId = superheroId,
            isFavourite = isFavourite
        )
    }
}