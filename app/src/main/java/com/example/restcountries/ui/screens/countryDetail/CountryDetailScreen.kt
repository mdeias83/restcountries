package com.example.restcountries.ui.screens.countryDetail

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.restcountries.ui.screens.Screens

@Composable
fun CountryDetailScreen(
    cca3: String,
    initialBookmarked: Boolean,
    navController: NavHostController,
    onLogoutClick: () -> Unit,
    vm: CountryDetailScreenViewModel = viewModel(),
) {
    LaunchedEffect(Unit) {
        vm.setCountryId(cca3)
    }

    val userName = vm.uiState.userName

    Column(modifier = Modifier.fillMaxSize()) {

        // 🌍 Encabezado
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Hola, $userName",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f)
            )

            // 🔙 Volver a lista
            IconButton(onClick = {
                navController.navigate(Screens.CountryList.route) {
                    popUpTo(Screens.CountryList.route) { inclusive = true }
                }
            }) {
                Icon(Icons.Default.Home, contentDescription = "Volver a lista")
            }

            // ❤️ Favoritos
            IconButton(onClick = {
                navController.navigate(Screens.BookMarks.route)
            }) {
                Icon(Icons.Default.Favorite, contentDescription = "Ir a favoritos")
            }

            // 🚪 Logout
            IconButton(onClick = onLogoutClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                    contentDescription = "Cerrar sesión"
                )
            }
        }

        // 🌐 Contenido principal
        if (vm.uiState.countryDetail.cca3 == "") {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            CountryUIDetail(
                country = vm.uiState.countryDetail,
                isBookmarked = vm.uiState.isBookmarked,
                onFavoriteClick = {
                    vm.toggleBookmark(cca3)
                }
            )
        }
    }
}