package com.example.restcountries.ui.screens

sealed class Screens (val route: String){
    object Splash: Screens("splash_screen")
    object CountryList: Screens("country_list_screen")
    object CountryDetail: Screens("country_detail_screen")
    object Login: Screens("login_screen")
}