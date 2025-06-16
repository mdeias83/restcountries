package com.example.restcountries.ui.screens.countryList

import com.example.restcountries.data.Country

data class CountryListScreenState (
    val countryList: List<Country> = emptyList(),
    val searchQuery: String=""
) {
}