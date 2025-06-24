package com.example.restcountries.ui.screens.countryDetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.restcountries.ui.screens.commons.CountryUIItem
import com.example.restcountries.ui.screens.countryDetail.CountryUIDetail

@Composable
fun CountryDetailScreen(
    cca3: String,
    modifier: Modifier = Modifier,
    vm: CountryDetailScreenViewModel = viewModel(),
    initialBookmarked: Boolean, // <-- este es el que mencionás
) {
    LaunchedEffect(Unit) {
        vm.setCountryId(cca3)
    }

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
            onFavoriteClick = { vm.toggleBookmark(vm.uiState.cca3) }
        )
    }
}
