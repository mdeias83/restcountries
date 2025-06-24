package com.example.restcountries.ui.screens.bookmarks

import com.example.restcountries.data.dto.CountryDTO


data class BookmarksState(
    val bookmarks: List<CountryDTO> = emptyList(),
    val userName: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
) {

}