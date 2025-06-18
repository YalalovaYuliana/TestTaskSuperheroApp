package com.hdaf.testtasksuperheroapp.feature_superhero.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.hdaf.testtasksuperheroapp.R
import com.hdaf.testtasksuperheroapp.ui.theme.TestTaskSuperHeroAppTheme
import com.hdaf.testtasksuperheroapp.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperheroTopAppBar(
    isMainScreen: Boolean = false,
    onNavigationIconClick: () -> Unit
) {
    TopAppBar(
        modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.top_app_bar_padding)),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            scrolledContainerColor = Color.Transparent
        ),
        title = {
            if (isMainScreen) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(R.string.superhero),
                    textAlign = TextAlign.Center,
                    style = Typography.headlineLarge,
                    color = MaterialTheme.colorScheme.surfaceContainerHighest
                )
            }
        },
        actions = {
            IconButton(
                modifier = Modifier
                    .size(dimensionResource(R.dimen.profile_icon_size))
                    .clip(shape = CircleShape)
                    .background(if (isMainScreen) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceContainer),
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    tint = if (isMainScreen) MaterialTheme.colorScheme.surfaceContainerHighest else MaterialTheme.colorScheme.primary,
                    contentDescription = stringResource(R.string.menu_button)
                )
            }
        },
        navigationIcon = {
            IconButton(
                modifier = Modifier
                    .size(dimensionResource(R.dimen.profile_icon_size))
                    .clip(shape = CircleShape)
                    .background(MaterialTheme.colorScheme.surfaceContainer),
                onClick = onNavigationIconClick
            ) {
                if (isMainScreen) {
                    Image(
                        painter = painterResource(R.drawable.ic_profile),
                        contentDescription = stringResource(R.string.profile_button),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        tint = MaterialTheme.colorScheme.primary,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@Preview
@Composable
fun SuperheroTopAppBarPreview() {
    TestTaskSuperHeroAppTheme {
        SuperheroTopAppBar(
            onNavigationIconClick = {}
        )
    }
}