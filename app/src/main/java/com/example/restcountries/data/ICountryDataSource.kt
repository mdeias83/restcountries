package com.example.restcountries.data

interface ICountryDataSource {
     suspend fun getCountryList(): List<Country>
    //suspend fun getCountryByName(name: String): List<Country>
    //suspend fun getCountriesByRegion(region: String): List<Country>
}
