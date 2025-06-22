package com.example.restcountries.data

import com.example.restcountries.data.dto.CountryDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ICountryAPI

{

    @GET("name/{country}")
    suspend fun getCountrySearch(
        @Path("country") search: String,
        @Query("fields") fields: String = "cca3,cca2,name,region,flag,flags"
    ): List<CountryDTO>


    @GET("all")
    suspend fun getAllCountries(
        @Query("fields") fields: String = "cca3,cca2,name,region,flag,flags"
    ): List<CountryDTO>

    @GET("region/{region}")
    suspend fun getCountriesByRegion(
        @Path("region") region: String,
        @Query("fields") fields: String = "cca3,cca2,name,region,flag,flags"
    ): List<CountryDTO>


    @GET("alpha/{code}")
    suspend fun getCountryByCca3(
        @Path("code") cca3: String,
        @Query("fields") fields: String = "cca3,cca2,name,region,capital,population,languages,currencies,flag,flags"
    ): CountryDTO
}