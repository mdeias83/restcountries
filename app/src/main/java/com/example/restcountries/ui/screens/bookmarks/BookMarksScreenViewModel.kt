package com.example.restcountries.ui.screens.bookmarks

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restcountries.data.CountryRepository
import com.example.restcountries.data.dto.CountryDTO
import com.example.restcountries.domain.ICountryRepository
import kotlinx.coroutines.Job

import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.IOException

class BookmarksScreenViewModel : ViewModel() {
    private val countryRepository: ICountryRepository = CountryRepository()
    private val db = Firebase.firestore
    private val auth = FirebaseAuth.getInstance()

    // Lista reactiva de favoritos (por ejemplo, solo los cca3)
    private val _favoritos = MutableStateFlow<List<String>>(emptyList())
    val favoritos: StateFlow<List<String>> = _favoritos
    var countries: List<CountryDTO> = emptyList()

    var uiState by mutableStateOf(BookmarksState())
        private set

    private var fetchJob: Job? = null


    init {
        getUserName() //User init
        listenFavorites()
        getFavoriteCountries()
    //getAllCountries()
    }

    //LLAMADA AL REPO


     fun getAllCountries() {
        viewModelScope.launch {
            try {
                uiState = uiState.copy(countryList = countryRepository.fetchAllCountries())


            } catch (e: Exception) {
               uiState=uiState.copy(countryList = emptyList())
            }
        }
    }

    //FAVORITOS
    private fun listenFavorites() {
        val uid = auth.currentUser?.uid ?: return
        db.collection("users").document(uid)
            .collection("favorites").document("list")
            .addSnapshotListener { snapshot, error ->
                if (snapshot != null && snapshot.exists()) {
                    val countries = snapshot.get("countries") as? List<String> ?: emptyList()
                    _favoritos.value = countries
                    //getFavoriteCountries() // 👉 Actualiza lista filtrada
                } else {
                    _favoritos.value = emptyList()
                }
            }
    }

    fun getFavoriteCountries() {
        viewModelScope.launch {
            try {
                val allCountries = countryRepository.fetchAllCountries()
                val favoriteIds = _favoritos.value

                val favoriteCountries = allCountries.filter { it.cca3 in favoriteIds }

                uiState = uiState.copy(countryList = favoriteCountries)

            } catch (e: Exception) {
                uiState = uiState.copy(countryList = emptyList())
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
        //ACA ACTUALIZO LUEGO DE ELIMINAR DE LA LISTA

        getFavoriteCountries()
    }

    fun getUserName() {
        uiState = uiState.copy(
            favoritos = uiState.favoritos,
            userName = FirebaseAuth.getInstance().currentUser?.displayName ?: "Usuario Desconocido"
        )
    }

}


