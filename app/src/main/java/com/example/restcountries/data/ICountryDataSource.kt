package com.example.restcountries.data

import com.example.restcountries.data.dto.CountryItemListDTO

interface ICountryDataSource {
     suspend fun getCountryList(search: String): List<CountryItemListDTO>
    //suspend fun getCountryByName(name: String): List<Country>
    //suspend fun getCountriesByRegion(region: String): List<Country>
}
