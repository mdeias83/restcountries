package com.example.restcountries.domain

import com.example.restcountries.data.dto.CountryItemListDTO

interface ICountryRepository {
    suspend fun fetchCountries(search: String): List<CountryItemListDTO>
}