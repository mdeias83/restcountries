package com.example.restcountries.data

import com.example.restcountries.data.dto.CountryDTO

interface ICountryDataSource {
     suspend fun getCountryList(search: String): List<CountryDTO>
    //suspend fun getCountryByName(name: String): List<Country>
    //suspend fun getCountriesByRegion(region: String): List<Country>
}
