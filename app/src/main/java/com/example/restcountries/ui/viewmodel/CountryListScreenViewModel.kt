package com.example.restcountries.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.restcountries.ui.view.countryList.CountryListScreenState

class CountryListScreenViewModel : ViewModel(){
    var uiState by mutableStateOf(CountryListScreenState())
        private set
    fun fetchCountries(){

    }
}