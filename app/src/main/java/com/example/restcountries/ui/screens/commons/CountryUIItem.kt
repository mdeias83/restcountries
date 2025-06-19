package com.example.restcountries.ui.screens.commons

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.restcountries.data.dto.CountryDTO

@Composable
fun CountryUIItem(country: CountryDTO, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Nombre y bandera
            Row {
                Text(
                    text = country.flag ?: "🏳️",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Column {
                    Text(
                        text = country.name.common,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = country.name.official,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            // Región
            Text(
                text = "Región: ${country.region}",
                style = MaterialTheme.typography.bodyMedium
            )


        }
    }
}
