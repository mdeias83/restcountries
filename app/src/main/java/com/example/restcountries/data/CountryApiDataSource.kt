package com.example.restcountries.data

import android.util.Log
import com.example.restcountries.data.dto.CountryDTO
import com.example.restcountries.data.dto.emptyCountry
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

    override suspend fun getAllCountries(): List<CountryDTO> {
        Log.d(TAG, "CountryApiDataSource.getCountryList")

        return try {
            Log.d(TAG, "CountryApiDataSource.getAllCountries")
            val countries = RetrofitInstance.countryApi.getAllCountries()

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

    override suspend fun getCountryByCca3(cca3: String): CountryDTO {
        Log.d("DEBUG", "Llamando a getCountryByCca3 con cca3=$cca3")
        return try {
            val result = RetrofitInstance.countryApi.getCountryByCca3(cca3)
            return result
        } catch (e: HttpException) {
            Log.e(TAG, "ERROR HTTP, ${e.code()} ${e.message()}")
            emptyCountry()
        }catch (e: IOException) {
            Log.e(TAG, "ERROR NETWORK, ${e.localizedMessage}")
            emptyCountry()
        } catch (e: Exception) {
            Log.e(TAG, "ERROR DESCONOCIDO, ${e.localizedMessage}")
            emptyCountry()
        }

    }
    override suspend fun getCountriesByRegion(region: String): List<CountryDTO> {
        return RetrofitInstance.countryApi.getCountriesByRegion(region)
    }
}
