package com.example.restcountries.data

import com.example.restcountries.domain.ICountryRepository
//ACA ELIJO SI QUIERO USAR EL TEST DATASOURCE O EL API DATASOURCE
class CountryRepository(
   val countryDataSource: ICountryDataSource = CountryTestDataSource()
    ):  ICountryRepository
{
    override suspend fun fetchCountries(): List<Country>{
        return countryDataSource.getCountryList()
    }
}