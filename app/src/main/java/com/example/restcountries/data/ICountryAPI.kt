package com.example.restcountries.data

import retrofit2.http.GET
import retrofit2.http.Query

interface ICountryAPI {
    @GET("name")
    suspend fun getCountrySearch(
        @Query("v") search: String
    ) : List<Country>

}