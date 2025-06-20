package com.example.restcountries.domain

import com.example.restcountries.data.dto.CountryDTO

interface ICountryRepository {
    suspend fun fetchCountries(search: String): List<CountryDTO>
    suspend fun fetchCountry(cca3: String) : CountryDTO
    suspend fun fetchCountriesByRegion(region: String): List<CountryDTO>
    suspend fun fetchAllCountries(): List<CountryDTO>

}