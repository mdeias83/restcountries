package com.example.restcountries.ui.screens.countryList

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.restcountries.data.dto.CountryDTO

import com.example.restcountries.data.dto.Currency
import com.example.restcountries.data.dto.Flags
import com.example.restcountries.data.dto.Name
import com.example.restcountries.ui.screens.Screens
import com.example.restcountries.ui.screens.commons.CountryUIList
import com.example.restcountries.ui.theme.RestCountriesTheme

@Composable
fun CountryListScreen(
    modifier: Modifier = Modifier,
    vm: CountryListScreenViewModel = viewModel(),
    navController: NavHostController,
    onLogOutClick: () -> Unit,

) {
    val regions = listOf("all", "Africa", "Americas", "Asia", "Europe", "Oceania")
    var expanded by remember { mutableStateOf(false) }
    var selectedRegion = vm.uiState.selectedRegion
    val favoritos by vm.favoritos.collectAsState()


    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        // Encabezado: Bienvenida y botón de Logout
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Hola, ${vm.uiState.userName}",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f)
            )
            // Botón de Favoritos
            Button(onClick = { navController.navigate(Screens.BookMarks.route) }) {
                Text("Favoritos")
            }
            Button(onClick =  onLogOutClick ) {
                Text("Logout")
            }
        }


        Spacer(modifier = Modifier.height(25.dp))

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

        Box{
            OutlinedButton(onClick = { expanded = true }, modifier = Modifier.width(250.dp)) {
            Text("Seleccionar Region: ${selectedRegion.replaceFirstChar { it.uppercase() }}")
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.width(250.dp)
                ) {
                regions.forEach { region ->
                    DropdownMenuItem(
                        text = { Text(region.replaceFirstChar { it.uppercase() }) },
                        onClick = {
                            selectedRegion = region
                            expanded = false
                            // Llamá al viewModel para filtrar por región
                            vm.onRegionSelected(region)
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))


        CountryUIList(
            countryList = vm.uiState.countryList,
            favoritos = favoritos,
            onClick = { cca3,isBookmarked ->
                navController.navigate(Screens.CountryDetail.createRoute(cca3,isBookmarked))
            },
            onBookmarkClick = { cca3 -> vm.toggleBookmark(cca3) }
        )
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
            cca2 = "AR",
            name = Name(common = "Argentina", official = "República Argentina"),
            currencies = mapOf("ARS" to Currency(name = "Peso argentino", symbol = "$")),
            capital = listOf("Buenos Aires"),
            region = "América del Sur",
            languages = mapOf("spa" to "Español"),
            flag = "🇦🇷",
            population = 45808747,
            flags = Flags("","","")
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
        CountryUIList(
            paisesDePrueba, Modifier.fillMaxSize() as List<String>, onClick = {} as (String, Boolean) -> Unit,
            onBookmarkClick = TODO(),
            modifier = TODO()
        )
    }
}