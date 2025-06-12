package com.example.restcountries.ui.view.countryList

import Country
import Currency
import Name
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.restcountries.ui.theme.RestCountriesTheme
import com.example.restcountries.ui.view.commons.CountryUIList
import com.example.restcountries.ui.viewmodel.CountryListScreenViewModel

@Composable
fun CountryListScreen(
    modifier: Modifier = Modifier,
    vm: CountryListScreenViewModel = viewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(
            text = "Lista de Países",
            style = MaterialTheme.typography.titleLarge,
            modifier = modifier
        )
        Spacer(modifier = Modifier.height(12.dp))
        CountryUIList(vm.uiState.countryList, Modifier.fillMaxSize())
    }
}

@Preview(showBackground = true)
@Composable
fun CountryPreview() {
    RestCountriesTheme {
        CountryListScreenPreview()
    }
}

// Esto es solo para el preview:
@Composable
fun CountryListScreenPreview() {
    // Armá un país fake (para que veas cómo se ve la lista)
    val paisesDePrueba = listOf(
        Country(
            cca3 = "ARG",
            name = Name(common = "Argentina", official = "República Argentina"),
            currencies = mapOf("ARS" to Currency(name = "Peso argentino", symbol = "$")),
            capital = listOf("Buenos Aires"),
            region = "América del Sur",
            languages = mapOf("spa" to "Español"),
            flag = "🇦🇷",
            population = 45808747
        )
    )
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(
            text = "Lista de Países",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(12.dp))
        CountryUIList(paisesDePrueba, Modifier.fillMaxSize())
    }
}