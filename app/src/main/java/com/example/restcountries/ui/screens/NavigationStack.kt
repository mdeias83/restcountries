package com.example.restcountries.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.restcountries.ui.screens.countryList.CountryListScreen
import com.example.restcountries.ui.screens.splash.SplashScreen

@Composable
fun NavigationStack(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ){
        composable (route = Screens.Splash.route){
            SplashScreen(navController = navController)
        }
        composable (route = Screens.CountryList.route){
            CountryListScreen()
        }
        composable (route = Screens.CountryDetail.route){
            //CountryDetailScreen()
        }
    }
}