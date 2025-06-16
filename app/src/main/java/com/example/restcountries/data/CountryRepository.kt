package com.example.restcountries.data

import com.example.restcountries.domain.ICountryRepository

class CountryRepository(
   val countryDataSource: ICountryDataSource = CountryTestDataSource()
    ):  ICountryRepository
{
    override suspend fun fetchCountries(): List<Country>{
        return countryDataSource.getCountryList()
    }
}