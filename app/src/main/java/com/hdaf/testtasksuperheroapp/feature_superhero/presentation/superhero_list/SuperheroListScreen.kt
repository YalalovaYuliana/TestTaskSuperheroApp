package com.hdaf.testtasksuperheroapp.feature_superhero.presentation.superhero_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.hdaf.testtasksuperheroapp.feature_superhero.domain.model.Superhero
import com.hdaf.testtasksuperheroapp.feature_superhero.presentation.common.SuperheroTopAppBar
import com.hdaf.testtasksuperheroapp.feature_superhero.presentation.superhero_list.components.SuperheroDropDownMenu
import com.hdaf.testtasksuperheroapp.feature_superhero.presentation.superhero_list.components.superhero_list.SuperheroList

@Composable
fun SuperheroListScreen(
    onItemClick: (Superhero) -> Unit,
    viewModel: SuperheroListViewModel = hiltViewModel()
) {
    var state = viewModel.state.value

    Scaffold(
        topBar = {
            SuperheroTopAppBar()
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            SuperheroDropDownMenu(
                publishers = state.publishers,
                onPublisherClick = { publisher ->
                    viewModel.onPublisherSelected(publisher)
                }
            )
            SuperheroList(
                superheroes = state.superheroItems,
                onItemClick = onItemClick
            )
        }
    }
}