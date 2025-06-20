package com.example.restcountries.data

import com.example.restcountries.data.dto.CountryDTO
import com.example.restcountries.data.dto.emptyCountry
import com.example.restcountries.domain.ICountryRepository
//ACA ELIJO SI QUIERO USAR EL TEST DATASOURCE O EL API DATASOURCE
class CountryRepository(
   val countryDataSource: ICountryDataSource = CountryApiDataSource()
    ):  ICountryRepository
{
    override suspend fun fetchCountries(search: String): List<CountryDTO>{
        return countryDataSource.getCountryList(search)
    }

    override suspend fun fetchCountry(cca3: String): CountryDTO {
        val result = countryDataSource.getCountryByCca3(cca3)
        return result
    }

    override suspend fun fetchCountriesByRegion(region: String): List<CountryDTO>{
        return countryDataSource.getCountriesByRegion(region)
    }

    override suspend fun fetchAllCountries(): List<CountryDTO>{
        return countryDataSource.getAllCountries()
    }

}

