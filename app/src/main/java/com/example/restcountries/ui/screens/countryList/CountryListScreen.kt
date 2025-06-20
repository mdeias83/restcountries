package com.example.restcountries.ui.screens.countryList

import CountryUIList
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.restcountries.data.dto.CountryDTO
import com.example.restcountries.data.dto.CountryDTO.Currency
import com.example.restcountries.data.dto.CountryDTO.Name
import com.example.restcountries.ui.screens.Screens
import com.example.restcountries.ui.theme.RestCountriesTheme

@Composable
fun CountryListScreen(
    modifier: Modifier = Modifier,
    vm: CountryListScreenViewModel = viewModel(),
    navController: NavHostController
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
        Row(
            modifier= Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            TextField(
                value= vm.uiState.searchQuery,
                modifier = Modifier.weight(1f),
                label = {Text("Buscar País: ")},
                singleLine = true,
                onValueChange = {vm.searchChange(it)}
            )
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = {
                    vm.fetchCountries()
                }
            ) {
                Text("Buscar")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        CountryUIList(vm.uiState.countryList, Modifier.fillMaxSize(), onClick = {
                cca3 ->
            Log.d("DEBUG", "Navegando a detalle con cca3: $cca3")
            navController.navigate(Screens.CountryDetail.route + "/$cca3")
        })
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
        CountryDTO(
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
        CountryUIList(paisesDePrueba, Modifier.fillMaxSize(), onClick = {})
    }
}