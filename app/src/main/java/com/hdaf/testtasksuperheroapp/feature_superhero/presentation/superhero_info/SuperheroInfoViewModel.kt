package com.hdaf.testtasksuperheroapp.feature_superhero.presentation.superhero_info

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hdaf.testtasksuperheroapp.R
import com.hdaf.testtasksuperheroapp.core.util.Resource
import com.hdaf.testtasksuperheroapp.feature_superhero.domain.use_case.GetSuperheroByIdUseCase
import com.hdaf.testtasksuperheroapp.feature_superhero.domain.use_case.UpdateFavouriteStatusUseCase
import com.hdaf.testtasksuperheroapp.feature_superhero.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SuperheroInfoViewModel @Inject constructor(
    private val getSuperheroByIdUseCase: GetSuperheroByIdUseCase,
    private val updateFavouriteStatusUseCase: UpdateFavouriteStatusUseCase,
    savedStateHandle: SavedStateHandle,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _state = mutableStateOf(SuperheroInfoState())
    val state: State<SuperheroInfoState> = _state

    init {
        savedStateHandle.get<Int>(Constants.PARAM_SUPERHERO_ID)?.let { superheroId ->
            getSuperheroById(superheroId)
        }
    }

    private fun getSuperheroById(superheroId: Int) {
        getSuperheroByIdUseCase(superheroId).onEach { result ->
            when (result) {
                is Resource.Success -> _state.value = SuperheroInfoState(
                    superhero = result.data,
                    isLoading = false
                )

                is Resource.Error -> _state.value = SuperheroInfoState(
                    isLoading = false,
                    error = result.message
                        ?: context.getString(R.string.error_unexpected)
                )

                is Resource.Loading -> _state.value = SuperheroInfoState(
                    isLoading = true
                )
            }
        }.launchIn(viewModelScope)
    }

    fun onUpdateFavouriteStatus(superheroId: Int, isFavourite: Boolean) {
        viewModelScope.launch {
            updateFavouriteStatusUseCase(
                superheroId = superheroId,
                isFavourite = isFavourite
            )
        }
    }
}