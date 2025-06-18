package com.hdaf.testtasksuperheroapp.feature_superhero.presentation.superhero_info.components.characteristic_list

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hdaf.testtasksuperheroapp.R
import com.hdaf.testtasksuperheroapp.feature_superhero.domain.model.Superhero

@Composable
fun CharacteristicList(
    modifier: Modifier = Modifier,
    superhero: Superhero?
) {
    Column(
        modifier = modifier,
    ) {
        CharacteristicItem(
            characteristicName = R.string.occupation,
            characteristicValue = superhero?.occupation
        )
        CharacteristicListDivider()
        CharacteristicItem(
            characteristicName = R.string.gender,
            characteristicValue = superhero?.gender
        )
        CharacteristicListDivider()
        CharacteristicItem(
            characteristicName = R.string.race,
            characteristicValue = superhero?.race
        )
        CharacteristicListDivider()
        CharacteristicItem(
            characteristicName = R.string.first_appearance,
            characteristicValue = superhero?.firstAppearance
        )
        CharacteristicListDivider()
        CharacteristicItem(
            characteristicName = R.string.alignment,
            characteristicValue = superhero?.alignment
        )
        CharacteristicListDivider()
        CharacteristicItem(
            characteristicName = R.string.publisher,
            characteristicValue = superhero?.publisher
        )
    }
}