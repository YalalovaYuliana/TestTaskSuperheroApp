package com.hdaf.testtasksuperheroapp.feature_superhero.presentation.superhero_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.hdaf.testtasksuperheroapp.R
import com.hdaf.testtasksuperheroapp.feature_superhero.domain.model.Superhero
import com.hdaf.testtasksuperheroapp.feature_superhero.presentation.common.SuperheroTopAppBar
import com.hdaf.testtasksuperheroapp.feature_superhero.presentation.superhero_list.components.SuperheroDropDownMenu
import com.hdaf.testtasksuperheroapp.feature_superhero.presentation.superhero_list.components.superhero_list.SuperheroList

@Composable
fun SuperheroListScreen(
    onItemClick: (Superhero) -> Unit,
    onNavigationIconClick: () -> Unit,
    viewModel: SuperheroListViewModel = hiltViewModel()
) {
    var state = viewModel.state.value

    Scaffold(
        topBar = {
            SuperheroTopAppBar(
                isMainScreen = true,
                onNavigationIconClick = onNavigationIconClick
            )
        }
    ) { innerPadding ->
        if (state.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.surfaceContainerHighest
                )
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                SuperheroDropDownMenu(
                    modifier = Modifier.padding(dimensionResource(R.dimen.dropdown_menu_padding)),
                    publishers = state.publishers,
                    onPublisherClick = { publisher ->
                        viewModel.onPublisherSelected(publisher)
                    }
                )
                SuperheroList(
                    modifier = Modifier.padding(dimensionResource(R.dimen.list_item_padding)),
                    superheroes = state.superheroItems,
                    onItemClick = onItemClick
                )
            }
        }
    }
}