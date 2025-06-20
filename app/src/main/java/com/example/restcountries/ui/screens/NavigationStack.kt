package com.example.restcountries.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.restcountries.ui.screens.countryDetail.CountryDetailScreen
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
            CountryListScreen(navController = navController)
        }
        composable(route = Screens.CountryDetail.route + "/{cca3}") { backStackEntry ->
            val cca3 = backStackEntry.arguments?.getString("cca3") ?: ""
            CountryDetailScreen(cca3 = cca3)
        }
    }
}