package com.hdaf.testtasksuperheroapp.feature_superhero.presentation.superhero_info

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hdaf.testtasksuperheroapp.core.util.Resource
import com.hdaf.testtasksuperheroapp.feature_superhero.domain.model.Superhero
import com.hdaf.testtasksuperheroapp.feature_superhero.domain.use_case.GetAllPublishersUseCase
import com.hdaf.testtasksuperheroapp.feature_superhero.domain.use_case.GetAllSuperheroesUseCase
import com.hdaf.testtasksuperheroapp.feature_superhero.domain.use_case.GetSuperheroesByPublisherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SuperheroListViewModel @Inject constructor(
    private val getAllSuperheroesUseCase: GetAllSuperheroesUseCase,
    private val getSuperheroesByPublisherUseCase: GetSuperheroesByPublisherUseCase,
    private val getAllPublishersUseCase: GetAllPublishersUseCase
) : ViewModel() {

    private val _state = mutableStateOf(SuperheroListState())
    val state: State<SuperheroListState> = _state

    init {
        loadAllSuperheroes()
        loadPublishers()
    }

    private fun loadPublishers() {
        getAllPublishersUseCase()
            .onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        val publishers = listOf("All superheroes") + (result.data ?: emptyList())
                        _state.value = state.value.copy(
                            publishers = publishers,
                            isLoading = false
                        )
                    }

                    is Resource.Error -> {
                        _state.value = state.value.copy(
                            isLoading = false
                        )
                    }

                    is Resource.Loading -> {
                        _state.value = state.value.copy(
                            isLoading = true
                        )
                    }
                }
            }.launchIn(viewModelScope)
    }

    private fun loadAllSuperheroes() {
        getAllSuperheroesUseCase()
            .onEach { result ->
                updateState(result)
            }.launchIn(viewModelScope)
    }

    fun onPublisherSelected(publisher: String?) {
        viewModelScope.launch {
            if (publisher == null || publisher == "All superheroes") {
                loadAllSuperheroes()
            } else {
                getSuperheroesByPublisherUseCase(publisher)
                    .collect { result ->
                        updateState(result)
                    }
            }
        }
    }

    private fun updateState(result: Resource<List<Superhero>>) {
        _state.value = when (result) {
            is Resource.Success -> state.value.copy(
                superheroItems = result.data ?: emptyList(),
                isLoading = false
            )

            is Resource.Error -> state.value.copy(
                superheroItems = result.data ?: emptyList(),
                isLoading = false
            )

            is Resource.Loading -> state.value.copy(
                superheroItems = result.data ?: emptyList(),
                isLoading = true
            )
        }
    }
}