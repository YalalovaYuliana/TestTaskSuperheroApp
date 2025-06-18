package com.hdaf.testtasksuperheroapp.feature_superhero.presentation.superhero_info.components.characteristic_list

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.hdaf.testtasksuperheroapp.R

@Composable
fun CharacteristicListDivider() {
    HorizontalDivider(
        modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.divider_padding)),
        thickness = dimensionResource(R.dimen.divider_thickness),
        color = MaterialTheme.colorScheme.surfaceContainerHigh
    )
}