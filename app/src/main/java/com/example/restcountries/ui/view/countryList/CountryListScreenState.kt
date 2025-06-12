package com.example.restcountries.ui.view.countryList

import Country

data class CountryListScreenState(
    val countryList: List<Country> = emptyList(),
    val searchQuery: String = ""
)