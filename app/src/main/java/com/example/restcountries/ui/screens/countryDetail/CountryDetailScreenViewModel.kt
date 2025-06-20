package com.example.restcountries.ui.screens.countryDetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restcountries.data.CountryRepository
import com.example.restcountries.domain.ICountryRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CountryDetailScreenViewModel(
    private val countryRepository: ICountryRepository = CountryRepository()
) : ViewModel() {
    var uiState by mutableStateOf(CountryDetailScreenState())
        private set

    private var fetchJob: Job? = null

    fun fetchCountry(){
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            uiState= uiState.copy(cca3 = uiState.cca3, countryDetail = countryRepository.fetchCountry(uiState.cca3))
        }
    }
    fun setCountryId (cca3 : String): Unit {
        uiState.copy(cca3 =  cca3, countryDetail = uiState.countryDetail)
        fetchCountry()
    }
}