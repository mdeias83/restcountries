package com.example.restcountries.ui.screens.commons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.restcountries.data.dto.CountryDTO

/*
@Composable
fun CountryUIItem(
    country: CountryDTO,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit

    )
{
    Card(
        modifier = modifier
            .clickable{
                onClick(country.cca3)
            }
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Nombre y bandera
            Row {

// Para cada país en la lista
                AsyncImage(
                    model = country.flags?.png ?: "https://flagcdn.com/w320/${country.cca2.lowercase()}.png",
                    contentDescription = "Bandera de ${country.name.common}",
                    modifier = Modifier.size(48.dp) // O el tamaño que quieras
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
*/
@Composable
fun CountryUIItem(
    country: CountryDTO,
    onClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp)
            .clickable { onClick(country.cca3) },
        //elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            // Bandera
            AsyncImage(
                model = country.flags?.png
                    ?: "https://flagcdn.com/w40/${country.cca2.lowercase()}.png",
                contentDescription = "Bandera de ${country.name.common}",
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.LightGray, shape = MaterialTheme.shapes.small)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                // Nombre del país
                Text(
                    text = country.name.common,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    ),
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(4.dp))
                // Región
                Text(
                    text = country.region,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                )
            }
        }
    }
}