package com.hdaf.testtasksuperheroapp.feature_superhero.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.hdaf.testtasksuperheroapp.feature_superhero.data.local.SuperheroDataBase
import com.hdaf.testtasksuperheroapp.feature_superhero.data.remote.SuperheroApi
import com.hdaf.testtasksuperheroapp.feature_superhero.data.repository.SuperheroRepositoryImpl
import com.hdaf.testtasksuperheroapp.feature_superhero.domain.repository.SuperheroRepository
import com.hdaf.testtasksuperheroapp.feature_superhero.domain.use_case.GetAllPublishersUseCase
import com.hdaf.testtasksuperheroapp.feature_superhero.domain.use_case.GetAllSuperheroesUseCase
import com.hdaf.testtasksuperheroapp.feature_superhero.domain.use_case.GetSuperheroByIdUseCase
import com.hdaf.testtasksuperheroapp.feature_superhero.domain.use_case.GetSuperheroesByPublisherUseCase
import com.hdaf.testtasksuperheroapp.feature_superhero.domain.use_case.UpdateFavouriteStatusUseCase
import com.hdaf.testtasksuperheroapp.feature_superhero.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SuperheroModule {

    @Provides
    @Singleton
    fun provideGetSuperheroByIdUseCase(
        superheroRepository: SuperheroRepository
    ): GetSuperheroByIdUseCase {
        return GetSuperheroByIdUseCase(superheroRepository)
    }

    @Provides
    @Singleton
    fun provideGetAllSuperheroesUseCase(
        superheroRepository: SuperheroRepository
    ): GetAllSuperheroesUseCase {
        return GetAllSuperheroesUseCase(superheroRepository)
    }

    @Provides
    @Singleton
    fun provideGetAllPublishersUseCase(
        superheroRepository: SuperheroRepository
    ): GetAllPublishersUseCase {
        return GetAllPublishersUseCase(superheroRepository)
    }

    @Provides
    @Singleton
    fun provideGetSuperheroesByPublisherUseCase(
        superheroRepository: SuperheroRepository
    ): GetSuperheroesByPublisherUseCase {
        return GetSuperheroesByPublisherUseCase(superheroRepository)
    }

    @Provides
    @Singleton
    fun provideUpdateFavouriteStatusUseCase(
        superheroRepository: SuperheroRepository
    ): UpdateFavouriteStatusUseCase {
        return UpdateFavouriteStatusUseCase(superheroRepository)
    }

    @Provides
    @Singleton
    fun provideAppContext(app: Application): Context {
        return app.applicationContext
    }

    @Provides
    @Singleton
    fun provideSuperheroRepository(
        superheroApi: SuperheroApi,
        superheroDataBase: SuperheroDataBase,
        context: Context
    ): SuperheroRepository {
        return SuperheroRepositoryImpl(
            superheroApi = superheroApi,
            superheroDao = superheroDataBase.dao,
            context = context
        )
    }

    @Provides
    @Singleton
    fun provideSuperheroDataBase(
        app: Application
    ): SuperheroDataBase {
        return Room.databaseBuilder(
            app,
            SuperheroDataBase::class.java,
            "superhero_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideSuperheroApi(): SuperheroApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(SuperheroApi::class.java)
    }
}