package com.example.restcountries.ui.screens.countryDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
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
    onClick: (String) -> Unit

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

        // Bandera
        AsyncImage(
            model = country.flag, // Creamos una ext o lo mapeás vos
            contentDescription = "Bandera de ${country.name.common}",
            modifier = Modifier
                .height(120.dp)
                .fillMaxWidth()
        )

        Spacer(Modifier.height(24.dp))

        // Tarjeta de datosarg
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation()
        ) {
            Column(Modifier.padding(16.dp)) {
                Text("Bandera de ${country.name.common}:   ${country.flag}")
                Text("Nombre oficial: ${country.name.official}")
                Text("Capital: ${country.capital?.firstOrNull() ?: "-"}")
                Text("Población: ${country.population}")
                Text("Región: ${country.region}")
                Text("Idiomas: ${country.languages?.values?.joinToString() ?: "-"}")
                Text("Moneda: ${country.currencies?.values?.firstOrNull()?.name ?: "-"} (${country.currencies?.values?.firstOrNull()?.symbol ?: ""})")
            }
        }

       /* // Favoritos
        IconButton(
            onClick = onFavoriteClick,
            modifier = Modifier.align(Alignment.End)
        ) {
            Icon(Icons.Default.FavoriteBorder, contentDescription = "Agregar a Favoritos")
        }*/
    }
}