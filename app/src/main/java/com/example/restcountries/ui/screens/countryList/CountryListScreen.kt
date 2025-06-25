package com.example.restcountries.ui.screens.countryList

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.restcountries.ui.screens.Screens
import com.example.restcountries.ui.screens.commons.CountryUIList

@Composable
fun CountryListScreen(
    modifier: Modifier = Modifier,
    vm: CountryListScreenViewModel = viewModel(),
    navController: NavHostController,
    onLogOutClick: () -> Unit
) {
    val regions = listOf("all", "Africa", "Americas", "Asia", "Europe", "Oceania")
    var expanded by remember { mutableStateOf(false) }
    var selectedRegion = vm.uiState.selectedRegion
    val favoritos by vm.favoritos.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // 🧑‍💼 Encabezado
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Hola, ${vm.uiState.userName}",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f)
            )

            IconButton(onClick = { navController.navigate(Screens.BookMarks.route) }) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favoritos"
                )
            }

            IconButton(onClick = onLogOutClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                    contentDescription = "Cerrar sesión"
                )
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Lista de Países",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = vm.uiState.searchQuery,
                modifier = Modifier.weight(1f),
                label = { Text("Buscar País:") },
                singleLine = true,
                onValueChange = { vm.searchChange(it) }
            )
            Spacer(modifier = Modifier.width(12.dp))
            Button(onClick = { vm.fetchCountries() }) {
                Text("Buscar")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Box {
            OutlinedButton(
                onClick = { expanded = true },
                modifier = Modifier.width(250.dp)
            ) {
                Text("Seleccionar Región: ${selectedRegion.replaceFirstChar { it.uppercase() }}")
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
                            vm.onRegionSelected(region)
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // 🌍 Lista de países
        CountryUIList(
            countryList = vm.uiState.countryList,
            favoritos = favoritos,
            onClick = { cca3, isBookmarked ->
                navController.navigate(Screens.CountryDetail.createRoute(cca3, isBookmarked))
            },
            onBookmarkClick = { cca3 -> vm.toggleBookmark(cca3) }
        )
    }
}