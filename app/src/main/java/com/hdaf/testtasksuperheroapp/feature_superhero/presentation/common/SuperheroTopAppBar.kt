package com.hdaf.testtasksuperheroapp.feature_superhero.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hdaf.testtasksuperheroapp.R
import com.hdaf.testtasksuperheroapp.ui.theme.TestTaskSuperHeroAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperheroTopAppBar() {

    TopAppBar(
        title = {
            Column {
                Text(
                    text = "Good Afternoon"
                )
                Text(
                    text = "Yalalova Yuliana"
                )
            }
        },
        navigationIcon = {
            IconButton(
                onClick = {}
            ) {
                Image(
                    modifier = Modifier,
                    painter = painterResource(R.drawable.ic_profile),
                    contentDescription = stringResource(R.string.profile_button)
                )
            }
        },
        actions = {
            IconButton(
                modifier = Modifier.size(48.dp),
                onClick = {}
            ) {
                Icon(
                    modifier = Modifier
                        .size(40.dp) // Размер изображения
                        .clip(CircleShape),
                    imageVector = Icons.Default.Menu,
                    contentDescription = stringResource(R.string.menu_button)
                )
            }
        }
    )
}

@Preview
@Composable
fun SuperheroTopAppBarPreview() {
    TestTaskSuperHeroAppTheme {
        SuperheroTopAppBar()
    }
}