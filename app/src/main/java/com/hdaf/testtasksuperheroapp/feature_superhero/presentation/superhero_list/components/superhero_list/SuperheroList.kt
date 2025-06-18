package com.hdaf.testtasksuperheroapp.feature_superhero.presentation.superhero_list.components.superhero_list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hdaf.testtasksuperheroapp.feature_superhero.domain.model.Superhero

@Composable
fun SuperheroList(
    modifier: Modifier = Modifier,
    superheroes: List<Superhero>,
    onItemClick: (Superhero) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(superheroes) { superhero ->
            SuperheroListItem(
                superhero = superhero,
                onItemClick = {
                    onItemClick(superhero)
                }
            )
        }
    }
}