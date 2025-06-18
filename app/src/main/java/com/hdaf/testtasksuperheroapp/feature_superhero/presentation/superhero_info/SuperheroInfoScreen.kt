package com.hdaf.testtasksuperheroapp.feature_superhero.presentation.superhero_info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.hdaf.testtasksuperheroapp.R
import com.hdaf.testtasksuperheroapp.feature_superhero.presentation.common.SuperheroTopAppBar
import com.hdaf.testtasksuperheroapp.feature_superhero.presentation.superhero_info.components.CharacteristicCard

@Composable
fun SuperheroInfoScreen(
    modifier: Modifier = Modifier,
    onNavigationIconClick: () -> Unit,
    viewModel: SuperheroInfoViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val state = viewModel.state.value
    val superhero = state.superhero
    val scrollState = rememberScrollState()

    Box(
        modifier = modifier.background(MaterialTheme.colorScheme.surfaceContainerHighest)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(R.dimen.superhero_info_image_size_height)),
            model = ImageRequest.Builder(context).data(superhero?.imageUrl).build(),
            contentDescription = superhero?.alias,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = modifier
                .verticalScroll(scrollState)
                .padding(top = dimensionResource(R.dimen.superhero_info_image_size_height))
        ) {
            Spacer(
                modifier = Modifier.height(
                    dimensionResource(R.dimen.info_card_offset) -
                            dimensionResource(R.dimen.superhero_info_image_size_height)
                )
            )
            CharacteristicCard(
                superhero = superhero,
                onFavouriteClick = {
                    superhero?.let {
                        viewModel.onUpdateFavouriteStatus(
                            superheroId = it.superheroId,
                            isFavourite = !it.isFavourite
                        )
                    }
                }
            )
        }
        SuperheroTopAppBar(
            onNavigationIconClick = onNavigationIconClick
        )
    }
}