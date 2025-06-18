package com.hdaf.testtasksuperheroapp.feature_superhero.presentation.superhero_info.components.characteristic_list

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.hdaf.testtasksuperheroapp.R
import com.hdaf.testtasksuperheroapp.ui.theme.Typography

@Composable
fun CharacteristicItem(
    modifier: Modifier = Modifier,
    @StringRes characteristicName: Int,
    characteristicValue: String?
) {
    Row(
        modifier = modifier.padding(dimensionResource(R.dimen.list_item_inner_padding)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(characteristicName) + ": ",
            style = Typography.headlineSmall
        )
        Text(
            text = characteristicValue ?: "-",
            style = Typography.bodyMedium
        )
    }
}