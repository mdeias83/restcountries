package com.example.restcountries.data

import com.example.restcountries.data.dto.CountryDTO

interface ICountryDataSource {
     suspend fun getCountryList(search: String): List<CountryDTO>
     suspend fun getCountryById(cca3: String): List<CountryDTO>
    //suspend fun getCountriesByRegion(region: String): List<Country>
}
