package com.example.restcountries.ui.screens.countryDetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.restcountries.data.dto.CountryDTO

@Composable
fun CountryUIDetail(
    country: CountryDTO,
    isBookmarked: Boolean,
    onFavoriteClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Nombre país
        Text(
            text = country.name.common.uppercase(),
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(12.dp))

        AsyncImage(
            model = country.flags?.png
                ?: "https://flagcdn.com/w320/${country.cca2.lowercase()}.png",
            contentDescription = "Bandera de ${country.name.common}",
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        )

        Spacer(Modifier.height(24.dp))

        // Tarjeta con botón favorito en esquina superior derecha
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation()
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                // Contenido de la tarjeta
                Column(Modifier.padding(16.dp)) {
                    Text("Nombre oficial: ${country.name.official}")
                    Text("Capital: ${country.capital?.firstOrNull() ?: "-"}")
                    Text("Población: ${country.population}")
                    Text("Región: ${country.region}")
                    val languages = country.languages?.values?.joinToString(", ") ?: "-"
                    Text("Idiomas: $languages")
                    val currencies = country.currencies?.values?.joinToString(", ") { "${it.name} (${it.symbol})" } ?: "-"
                    Text("Moneda(s): $currencies")
                }

                // Botón en esquina superior derecha
                IconButton(
                    onClick = onFavoriteClick,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                ) {
                    Icon(
                        imageVector = if (isBookmarked) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = if (isBookmarked) "Quitar de favoritos" else "Agregar a favoritos",
                        tint = if (isBookmarked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface

                    )
                }
            }
        }
    }
}