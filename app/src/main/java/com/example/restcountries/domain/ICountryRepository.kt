package com.example.restcountries.domain

import com.example.restcountries.data.Country

interface ICountryRepository {
    suspend fun fetchCountries(): List<Country>
}