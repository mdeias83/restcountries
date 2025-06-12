package com.example.restcountries.data.network

import retrofit2.http.GET
import retrofit2.http.Query
import com.google.android.ads.mediationtestsuite.dataobjects.Country
interface CountryApiService {

    @GET("independent")
    suspend fun getIndependentCountries(
        @Query("status") status: Boolean = true,
        @Query("fields") fields: String = "cca3,name,languages,capital,flag,currencies,region,population"
    ): List<Country>
}