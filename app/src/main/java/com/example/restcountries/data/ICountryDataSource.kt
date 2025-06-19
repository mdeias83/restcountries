package com.example.restcountries.data

interface ICountryDataSource {
     suspend fun getCountryList(search: String): List<Country>
    //suspend fun getCountryByName(name: String): List<Country>
    //suspend fun getCountriesByRegion(region: String): List<Country>
}
