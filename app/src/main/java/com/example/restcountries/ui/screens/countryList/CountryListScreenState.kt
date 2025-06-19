package com.example.restcountries.ui.screens.countryList

import com.example.restcountries.data.dto.CountryItemListDTO

data class CountryListScreenState (
    val countryList: List<CountryItemListDTO> = emptyList(),
    val searchQuery: String=""
) {
}