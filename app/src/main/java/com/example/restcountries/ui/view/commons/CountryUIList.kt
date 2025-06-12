package com.example.restcountries.ui.view.commons

import Country
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CountryUIList(
    list: List<Country>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(list) { country ->
            CountryUIItem(country = country)
        }
    }
}