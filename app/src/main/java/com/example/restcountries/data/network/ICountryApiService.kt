package com.example.restcountries.data.network

import Country
import retrofit2.http.GET
import retrofit2.http.Query
interface CountryApiService {

    @GET("independent")
    suspend fun getIndependentCountries(
        @Query("status") status: Boolean = true,
        @Query("fields") fields: String = "cca3,name,languages,capital,flag,currencies,region,population"
    ): List<Country>
}