package com.example.restcountries.domain

import com.example.restcountries.data.dto.CountryDTO

interface ICountryRepository {
    suspend fun fetchCountries(search: String): List<CountryDTO>
    suspend fun fetchCountry(cca3: String) : CountryDTO
}