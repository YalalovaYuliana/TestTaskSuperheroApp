package com.hdaf.testtasksuperheroapp.feature_superhero.presentation.superhero_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextOverflow
import com.hdaf.testtasksuperheroapp.R
import com.hdaf.testtasksuperheroapp.ui.theme.Typography

@Composable
fun SuperheroDropDownMenu(
    modifier: Modifier = Modifier,
    currentPublisher: String,
    publishers: List<String>,
    onPublisherClick: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                expanded = !expanded
            },
        shape = RoundedCornerShape(dimensionResource(R.dimen.dropdown_card_corner))
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surfaceContainer)
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.card_inner_padding)),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = currentPublisher,
                style = Typography.headlineSmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Icon(
                imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = null
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            },
        ) {
            publishers.forEach { publisher ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = publisher,
                            style = Typography.headlineSmall
                        )
                    },
                    onClick = {
                        onPublisherClick(publisher)
                        expanded = false
                    }
                )
            }

        }
    }
}