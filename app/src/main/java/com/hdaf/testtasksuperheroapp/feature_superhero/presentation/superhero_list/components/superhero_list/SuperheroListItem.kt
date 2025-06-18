package com.hdaf.testtasksuperheroapp.feature_superhero.presentation.superhero_list.components.superhero_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.hdaf.testtasksuperheroapp.R
import com.hdaf.testtasksuperheroapp.feature_superhero.domain.model.Superhero
import com.hdaf.testtasksuperheroapp.ui.theme.TestTaskSuperHeroAppTheme
import com.hdaf.testtasksuperheroapp.ui.theme.Typography

@Composable
fun SuperheroListItem(
    modifier: Modifier = Modifier,
    superhero: Superhero,
    onItemClick: (Superhero) -> Unit
) {
    val context = LocalContext.current

    Card(
        modifier = modifier
            .padding(dimensionResource(R.dimen.list_item_padding))
            .clickable {
                onItemClick(superhero)
            },
        shape = RoundedCornerShape(dimensionResource(R.dimen.dropdown_card_corner))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.card_inner_padding)),
        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    modifier = Modifier
                        .height(dimensionResource(R.dimen.superhero_card_image_size_height))
                        .width(dimensionResource(R.dimen.superhero_card_image_size_width))
                        .clip(MaterialTheme.shapes.medium),
                    model = ImageRequest.Builder(context).data(superhero.imageUrl).build(),
                    contentDescription = superhero.alias,
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(dimensionResource(R.dimen.list_item_padding)),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = superhero.alias,
                        style = Typography.headlineMedium
                    )
                    Text(
                        text = superhero.realName,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = Typography.bodyMedium
                    )
                }
            }
            Icon(
                imageVector = Icons.Default.Favorite,
                tint = if (superhero.isFavourite) MaterialTheme.colorScheme.surfaceContainer else MaterialTheme.colorScheme.background,
                contentDescription = null
            )
        }
    }
}

@Composable
@Preview
fun SuperheroListItemPreview() {
    TestTaskSuperHeroAppTheme {
        SuperheroListItem(
            superhero = Superhero(
                superheroId = 0,
                alias = "Spiderman",
                realName = "Peter Parker",
                occupation = "Spider, school student",
                gender = "male",
                race = "human",
                firstAppearance = "Amazing Fantasy #15",
                alignment = "good",
                publisher = "Marvel Comics",
                imageUrl = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/620-spider-man.jpg",
                isFavourite = false
            )
        ) { }
    }
}