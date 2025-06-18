package com.example.restcountries.data

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class CountryApiDataSource : ICountryDataSource {
    val BASE_URL = "https://restcountries.com/v3.1/"

    val retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
    val api = retrofit.create(ICountryAPI::class.java)
    override suspend fun getCountryList(): List<Country> {
        Log.d("RestCountries","CountryApiDataSource.getCountryList")
        val countries = api.getAllCountries()
        Log.d("RestCountries","CountryApiDataSource.getCountryList Result: ${countries.size}")
        return countries
        }
}