package com.example.restcountries.ui.screens.bookmarks

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.restcountries.ui.screens.Screens
import com.example.restcountries.ui.screens.commons.CountryUIList

@Composable
fun BookMarksScreen(
    navController: NavController,
    vm: BookmarksScreenViewModel = viewModel()
) {
    val favoritos by vm.favoritos.collectAsState()
    Log.d("BookMarks","${favoritos.toString()}")
}