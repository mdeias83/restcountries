package com.example.restcountries.ui.screens.countryDetail

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


class CountryDetailScreenViewModel(
    private val countryRepository: ICountryRepository = CountryRepository()
) : ViewModel() {
    private val db = Firebase.firestore
    private val auth = FirebaseAuth.getInstance()
    private val _favoritos = MutableStateFlow<List<String>>(emptyList())
    val favoritos: StateFlow<List<String>> = _favoritos

    var uiState by mutableStateOf(CountryDetailScreenState())
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

    fun fetchCountry() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            uiState = uiState.copy(
                cca3 = uiState.cca3,
                countryDetail = countryRepository.fetchCountry(uiState.cca3)
            )
        }
    }

    fun setCountryId(cca3: String,): Unit {
        uiState = uiState.copy(cca3 = cca3, countryDetail = uiState.countryDetail) // Estado recibido desde la lista
        fetchCountry()
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


    fun getUserName(){
        uiState = uiState.copy(userName =  FirebaseAuth.getInstance().currentUser?.displayName?: "Usuario Desconocido")
    }

    /*
        fun checkIfBookmarked(cca3: String) {
            userId ?: return
            firestore.collection("bookmarks")
                .document(userId)
                .collection("countries")
                .document(cca3)
                .get()
                .addOnSuccessListener { document ->
                    uiState = uiState.copy(isBookmarked = document.exists())
                }
        }

        fun addBookmark(cca3: String) {
            userId ?: return

            // Solo se guarda el ID del país, podés agregar más si querés
            val bookmarkData = mapOf(
                "timestamp" to System.currentTimeMillis()
            )

            firestore.collection("bookmarks")
                .document(userId)
                .collection("countries")
                .document(cca3)
                .set(bookmarkData)
                .addOnSuccessListener {
                    uiState = uiState.copy(isBookmarked = true)
                }
        }

        fun removeBookmark(cca3: String) {
            userId ?: return

            firestore.collection("bookmarks")
                .document(userId)
                .collection("countries")
                .document(cca3)
                .delete()
                .addOnSuccessListener {
                    uiState = uiState.copy(isBookmarked = false)
                }
        }*/
}