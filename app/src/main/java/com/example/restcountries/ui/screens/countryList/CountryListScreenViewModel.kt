package com.example.restcountries.ui.screens.countryList

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restcountries.data.CountryRepository
import com.example.restcountries.domain.ICountryRepository
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.IOException

class CountryListScreenViewModel(
    private val countryRepository: ICountryRepository = CountryRepository()
) : ViewModel() {
    private val db = Firebase.firestore
    private val auth = FirebaseAuth.getInstance()

    // Lista reactiva de favoritos (por ejemplo, solo los cca3)
    private val _favoritos = MutableStateFlow<List<String>>(emptyList())
    val favoritos: StateFlow<List<String>> = _favoritos


    var uiState by mutableStateOf(CountryListScreenState())
        private set



    private var fetchJob: Job? = null

    init {
        getUserName() //User init
        listenFavorites()


    }

    private fun listenFavorites() {
        val uid = auth.currentUser?.uid ?: return
        db.collection("users").document(uid)
            .collection("favorites").document("list")
            .addSnapshotListener { snapshot, error ->
                if (snapshot != null && snapshot.exists()) {
                    val countries = snapshot.get("countries") as? List<String> ?: emptyList()
                    _favoritos.value = countries
                } else {
                    _favoritos.value = emptyList()
                }
            }
    }

    fun toggleBookmark(cca3: String) {
        val uid = auth.currentUser?.uid ?: return
        val docRef = db.collection("users").document(uid).collection("favorites").document("list")

        val isFav = _favoritos.value.contains(cca3)
        val update = if (isFav) {
            mapOf("countries" to com.google.firebase.firestore.FieldValue.arrayRemove(cca3))
        } else {
            mapOf("countries" to com.google.firebase.firestore.FieldValue.arrayUnion(cca3))
        }
        docRef.set(update, com.google.firebase.firestore.SetOptions.merge())
    }



    fun fetchCountries() {
        //De aca llamamos a la capa de datos
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                uiState =
                    uiState.copy(countryList = countryRepository.fetchCountries(uiState.searchQuery), searchQuery = uiState.searchQuery)

            } catch (e: IOException) {
                Log.e("ResCountriesAPP", "Error recuperando la lista de paises")
            }
        }

    }

    fun searchChange(search: String) {
        uiState = uiState.copy(searchQuery = search, countryList = uiState.countryList )
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
                uiState = uiState.copy(countryList = countries, selectedRegion = region, searchQuery = uiState.searchQuery, userName = uiState.userName)
            } catch (e: Exception) {
                uiState = uiState.copy(countryList = emptyList(),selectedRegion = region, searchQuery = uiState.searchQuery, userName = uiState.userName)
            }
        }
    }

    fun getUserName(){
        uiState = uiState.copy(searchQuery = uiState.searchQuery, countryList = uiState.countryList, userName =  FirebaseAuth.getInstance().currentUser?.displayName?: "Usuario Desconocido")
    }



}


