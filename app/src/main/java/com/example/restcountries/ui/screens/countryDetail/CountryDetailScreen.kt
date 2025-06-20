package com.example.restcountries.ui.screens.countryDetail

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.restcountries.ui.screens.commons.CountryUIItem

@Composable
fun CountryDetailScreen(
    cca3: String,
    modifier: Modifier = Modifier,
    vm: CountryDetailScreenViewModel = viewModel()

){
    vm.setCountryId(cca3)
    if (vm.uiState.countryDetail.cca3 == "") {
        CircularProgressIndicator()
    }
    else {
        CountryUIItem(vm.uiState.countryDetail, onClick = {cca3 -> {}})
    }
}
