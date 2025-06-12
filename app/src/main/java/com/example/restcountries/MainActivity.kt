package com.example.restcountries

import Country
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.restcountries.ui.theme.RestCountriesTheme
import com.example.restcountries.ui.view.countryList.CountryListScreen
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
            setContent {
                RestCountriesTheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        CountryListScreen(
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
    }
}


