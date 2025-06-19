package com.example.restcountries.ui.screens.countryList

import com.example.restcountries.data.dto.CountryDTO

data class CountryListScreenState (
    val countryList: List<CountryDTO> = emptyList(),
    val searchQuery: String=""
) {
}