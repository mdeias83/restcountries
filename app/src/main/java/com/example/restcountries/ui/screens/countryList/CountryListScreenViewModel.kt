package com.example.restcountries.ui.screens.countryList

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restcountries.data.Country
import com.example.restcountries.data.CountryRepository
import com.example.restcountries.data.CountryTestDataSource
import com.example.restcountries.domain.ICountryRepository
import com.google.gson.Gson
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException

class CountryListScreenViewModel(
    private val countryRepository: ICountryRepository = CountryRepository()
) : ViewModel()
{
    //val repo = CountryRepository(CountryTestDataSource())
    var uiState by mutableStateOf(CountryListScreenState())
    private set

    init{
        fetchCountries()
    }


    private var fetchJob: Job?=null

    fun fetchCountries(){
        //De aca llamamos a la capa de datos
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try{
                uiState = uiState.copy(countryList = countryRepository.fetchCountries())

            }
            catch(e: IOException) {
                Log.e("ResCountriesAPP","Error recuperando la lista de paises")
            }
        }

    }
}

