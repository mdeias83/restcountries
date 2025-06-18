package com.example.restcountries.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ICountryAPI {
    @GET("name/{country}")
    suspend fun getCountrySearch(
        @Path("country") search: String,
        @Query("fields") fields: String = "name,region,capital,flag,population"
    ): List<Country>
    @GET("all")
    suspend fun getAllCountries(
        @Query("fields") fields: String = "name,region,capital,flag"
    ): List<Country>
}