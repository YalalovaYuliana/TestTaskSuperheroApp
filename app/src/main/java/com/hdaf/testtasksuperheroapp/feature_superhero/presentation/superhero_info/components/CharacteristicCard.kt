package com.hdaf.testtasksuperheroapp.feature_superhero.presentation.superhero_info.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.hdaf.testtasksuperheroapp.R
import com.hdaf.testtasksuperheroapp.feature_superhero.domain.model.Superhero
import com.hdaf.testtasksuperheroapp.feature_superhero.presentation.superhero_info.components.characteristic_list.CharacteristicList
import com.hdaf.testtasksuperheroapp.ui.theme.Typography

@Composable
fun CharacteristicCard(
    modifier: Modifier = Modifier,
    superhero: Superhero?,
    onFavouriteClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .offset(y = dimensionResource(R.dimen.info_card_offset)),
        shape = RoundedCornerShape(
            topStart = dimensionResource(R.dimen.dropdown_card_corner),
            topEnd = dimensionResource(R.dimen.dropdown_card_corner),
        )
    ) {
        Row(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.card_inner_padding))
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = superhero?.alias ?: "",
                    style = Typography.headlineLarge
                )
                Text(
                    text = superhero?.realName ?: "",
                    style = Typography.bodyLarge
                )
            }
            IconButton(
                onClick = onFavouriteClick
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    tint = if (superhero?.isFavourite == true) MaterialTheme.colorScheme.surfaceContainerHigh else MaterialTheme.colorScheme.background,
                    contentDescription = null
                )
            }
            Spacer(
                modifier = modifier.height(dimensionResource(R.dimen.spacer_medium))
            )
        }
        CharacteristicList(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.card_inner_padding)),
            superhero = superhero
        )
    }
}