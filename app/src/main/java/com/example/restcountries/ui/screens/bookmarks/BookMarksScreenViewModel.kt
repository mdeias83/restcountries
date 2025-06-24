package com.example.restcountries.ui.screens.bookmarks

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BookmarksScreenViewModel : ViewModel() {
    private val db = Firebase.firestore
    private val auth = FirebaseAuth.getInstance()

    // Lista reactiva de favoritos (por ejemplo, solo los cca3)
    private val _favoritos = MutableStateFlow<List<String>>(emptyList())
    val favoritos: StateFlow<List<String>> = _favoritos


    var uiState by mutableStateOf(BookmarksState())
        private set



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

    fun getUserName(){
        uiState = uiState.copy(bookmarks = uiState.bookmarks, userName =  FirebaseAuth.getInstance().currentUser?.displayName?: "Usuario Desconocido")
    }



}
