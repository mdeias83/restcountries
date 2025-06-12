package com.example.restcountries.ui.view.commons

import Country
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp

@Composable
fun CountryUIItem(
    country: Country,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(8.dp)) {
        Text(text = country.name.official, style = MaterialTheme.typography.titleMedium)
        Text(text = "Región: ${country.region}", style = MaterialTheme.typography.bodyMedium)
    }
}