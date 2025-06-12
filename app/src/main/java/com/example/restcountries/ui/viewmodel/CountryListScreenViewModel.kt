package com.example.restcountries.ui.viewmodel

import Country
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.restcountries.ui.view.countryList.CountryListScreenState
import com.google.gson.Gson

class CountryListScreenViewModel : ViewModel(){
    var uiState by mutableStateOf(CountryListScreenState())
        private set
    init {
        fetchCountries()
    }
    fun fetchCountries(){
        uiState= uiState.copy(countryList = getCountryList())
    }
}
