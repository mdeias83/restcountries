package com.example.restcountries.ui.screens.bookmarks

import com.example.restcountries.data.dto.CountryDTO


data class BookmarksState(
    val countryList: List<CountryDTO> = emptyList(),
    val favoritos: List<CountryDTO> = emptyList(),
    val userName: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
) {

}