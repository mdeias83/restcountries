package com.example.restcountries.data

import android.util.Log
import com.example.restcountries.data.dto.CountryDTO
import retrofit2.HttpException
import java.io.IOException

class CountryApiDataSource : ICountryDataSource {
    private val TAG = "RestCountries"

    override suspend fun getCountryList(search: String): List<CountryDTO> {
        Log.d(TAG, "CountryApiDataSource.getCountryList")

        return try {
            Log.d(TAG, "CountryApiDataSource.getCountryList $search")
            val countries = RetrofitInstance.countryApi.getCountrySearch(search)

            Log.d(TAG, "CountryApiDataSource.getCountryList Result: ${countries.size}")
            return countries
        } catch (e: HttpException) {
            Log.e(TAG, "ERROR HTTP, ${e.code()} ${e.message()}")
            emptyList()
        } catch (e: IOException) {
            Log.e(TAG, "ERROR NETWORK, ${e.localizedMessage}")
            emptyList()
        } catch (e: Exception) {
            Log.e(TAG, "ERROR DESCONOCIDO, ${e.localizedMessage}")
            emptyList()
        }
    }
}