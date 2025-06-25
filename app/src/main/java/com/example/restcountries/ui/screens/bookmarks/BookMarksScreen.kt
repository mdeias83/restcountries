package com.example.restcountries.ui.screens.bookmarks

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.restcountries.ui.screens.Screens
import com.example.restcountries.ui.screens.commons.CountryUIList

@Composable
fun BookMarksScreen(
    navController: NavController,
    vm: BookmarksScreenViewModel = viewModel(),
    onLogOutClick: () -> Unit
) {
    val favoritos by vm.favoritos.collectAsState()
    val userName = vm.uiState.userName
    val countries = vm.uiState.countryList

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // 🔝 Encabezado
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Hola, $userName",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f)
            )

            IconButton(
                onClick = {
                    navController.navigate(Screens.CountryList.route) {
                        popUpTo(Screens.CountryList.route) { inclusive = true }
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Volver a lista"
                )
            }

            IconButton(
                onClick = onLogOutClick
            ) {
                Icon(
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = "Cerrar sesión"
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Países Favoritos",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        // ⭐ Lista de países favoritos
        CountryUIList(
            countryList = countries,
            favoritos = favoritos,
            onClick = { cca3, isBookmarked ->
                navController.navigate(Screens.CountryDetail.createRoute(cca3, isBookmarked))
            },
            onBookmarkClick = { cca3 ->
                vm.toggleBookmark(cca3)
            }
        )
    }
}
