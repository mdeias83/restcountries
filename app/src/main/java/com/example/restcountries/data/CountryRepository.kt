package com.example.restcountries.data

import com.example.restcountries.data.dto.CountryDTO
import com.example.restcountries.domain.ICountryRepository
//ACA ELIJO SI QUIERO USAR EL TEST DATASOURCE O EL API DATASOURCE
class CountryRepository(
   val countryDataSource: ICountryDataSource = CountryApiDataSource()
    ):  ICountryRepository
{
    override suspend fun fetchCountries(search: String): List<CountryDTO>{
        return countryDataSource.getCountryList(search)
    }
}