package com.example.restcountries.ui.view.countryList

import Country
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
    vm: CountryListScreenViewModel = viewModel(),
    modifier: Modifier = Modifier)
    {
    Column (
        modifier=Modifier.fillMaxSize().padding(16.dp)
    ){
        Text(
            text = "Lista de Paises",
            style = MaterialTheme.typography.titleLarge,
            modifier = modifier
        )
        Spacer(modifier = Modifier.height(12.dp))
        //Lista
        CountryUIList(vm.uiState.countryList, Modifier.fillMaxSize())
    }

}

@Preview(showBackground = true)
@Composable
fun CountryPreview() {
    RestCountriesTheme {
        CountryListScreen(emptyList())
    }
}


