package com.hdaf.testtasksuperheroapp.feature_superhero.presentation.superhero_list.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun SuperheroDropDownMenu(
    modifier: Modifier = Modifier,
    publishers: List<String>,
    onPublisherClick: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    DropdownMenu(
        modifier = modifier
            .clickable {
                expanded = true
            },
        expanded = expanded,
        onDismissRequest = {
            expanded = false
        },
    ) {
        publishers.forEach { publisher ->
            DropdownMenuItem(
                text = { Text(text = publisher) },
                onClick = {
                    onPublisherClick(publisher)
                    expanded = false
                }
            )
        }

    }
}