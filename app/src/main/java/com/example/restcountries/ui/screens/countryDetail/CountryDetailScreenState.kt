package com.example.restcountries.ui.screens.countryDetail

import com.example.restcountries.data.dto.CountryDTO
import com.example.restcountries.data.dto.emptyCountry

data class CountryDetailScreenState(
    val cca3 : String="",
    val countryDetail: CountryDTO = emptyCountry(),
    val isLoading: Boolean = true,
    val error: String? = null,
    val userName: String = "",

    ) {

}