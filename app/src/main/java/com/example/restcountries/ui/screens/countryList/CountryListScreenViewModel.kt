package com.example.restcountries.ui.screens.countryList

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restcountries.data.CountryRepository
import com.example.restcountries.domain.ICountryRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException

class CountryListScreenViewModel(
    private val countryRepository: ICountryRepository = CountryRepository()
) : ViewModel() {
    //val repo = CountryRepository(CountryTestDataSource())
    var uiState by mutableStateOf(CountryListScreenState())
    var userName by mutableStateOf("Usuario") // Poné el nombre del usuario aquí
        private set



    private var fetchJob: Job? = null

    init {
        //User init
        val currentUser = FirebaseAuth.getInstance().currentUser
        val name = currentUser?.displayName ?: currentUser?.email ?: "Invitado"
        uiState = uiState.copy(userName = name)
        //init de lista
        onRegionSelected("all")
    }
    fun fetchCountries() {
        //De aca llamamos a la capa de datos
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                uiState =
                    uiState.copy(countryList = countryRepository.fetchCountries(uiState.searchQuery))

            } catch (e: IOException) {
                Log.e("ResCountriesAPP", "Error recuperando la lista de paises")
            }
        }

    }

    fun searchChange(search: String) {
        uiState = uiState.copy(searchQuery = search, countryList = uiState.countryList)
    }


    // Función para actualizar la región y traer los países correspondientes
    fun onRegionSelected(region: String) {
        uiState = uiState.copy(selectedRegion = region)
        viewModelScope.launch {
            try {
                val countries = if (region == "all") {
                    countryRepository.fetchAllCountries()
                } else {
                    countryRepository.fetchCountriesByRegion(region)
                }
                uiState = uiState.copy(countryList = countries)
            } catch (e: Exception) {
                uiState = uiState.copy(countryList = emptyList())
            }
        }
    }


    fun logout() {
        FirebaseAuth.getInstance().signOut()
        // Acá podés navegar a Login si querés
    }

}


